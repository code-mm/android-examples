package com.example.app.interceptor;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;


// 公共参数拦截器

public class CommonParamsInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {

        //获取到请求
        Request request = chain.request();
        //获取请求的方式
        String method = request.method();
        //获取请求的路径
        String oldUrl = request.url().toString();

        //TODO 要添加的公共参数
        Map<String, String> map = new HashMap<>();
        //eg:map.put("source", "android");

        if ("GET".equals(method)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(oldUrl);
            if (oldUrl.contains("?")) {
                //?在最后面....2类型
                if (oldUrl.indexOf("?") == oldUrl.length() - 1) {
                } else {
                    //3类型...拼接上&
                    stringBuilder.append("&");
                }
            } else {
                //不包含? 属于1类型,,,先拼接上?号
                stringBuilder.append("?");
            }
            //添加公共参数....
            for (Map.Entry<String, String> entry : map.entrySet()) {
                //拼接
                stringBuilder.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue())
                        .append("&");
            }
            //删掉最后一个&符号
            if (stringBuilder.indexOf("&") != -1) {
                stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("&"));
            }
            // 新的url
            String newUrl = stringBuilder.toString();
            //拿着新的路径重新构建请求
            request = request.newBuilder()
                    .url(newUrl)
                    .build();
        } else if ("POST".equals(method)) {
            //先获取到老的请求的实体内容
            RequestBody oldRequestBody = request.body();

            //如果请求调用的是上面doPost方法
            if (oldRequestBody instanceof FormBody) {
                FormBody oldBody = (FormBody) oldRequestBody;

                //构建一个新的请求实体内容
                FormBody.Builder builder = new FormBody.Builder();
                //1.添加老的参数
                for (int i = 0; i < oldBody.size(); i++) {
                    builder.add(oldBody.name(i), oldBody.value(i));
                }
                //2.添加公共参数
                for (Map.Entry<String, String> entry : map.entrySet()) {

                    builder.add(entry.getKey(), entry.getValue());
                }

                // 新的请求实体
                FormBody newBody = builder.build();

                //构建一个新的请求
                request = request.newBuilder()
                        .url(oldUrl)
                        .post(newBody)
                        .build();
            }
        }

        Response response = chain.proceed(request);
        return response;
    }
}