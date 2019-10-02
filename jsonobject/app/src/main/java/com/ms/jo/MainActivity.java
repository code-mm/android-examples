package com.ms.jo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static final String json = "[\n" +
            "    {\n" +
            "        \"event\": \"SDKActivatedEvent\",\n" +
            "        \"result\": \"Y\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"event\": \"ResourceLoadingRequestedEvent\",\n" +
            "        \"result\": \"Y\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"event\": \"ResourceUpdatedEvent\",\n" +
            "        \"result\": \"Y\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"event\": \"GameServerLoggedinEvent\",\n" +
            "        \"result\": \"Y\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"event\": \"RoleCreatedEvent\",\n" +
            "        \"result\": \"Y\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"condition\": [\n" +
            "            {\n" +
            "                \"k\": \"lvl\",\n" +
            "                \"v\": [\n" +
            "                    {\n" +
            "                        \"lvl\": \"15\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"lvl\": \"20\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"lvl\": \"58\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"lvl\": \"105\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"lvl\": \"120\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"lvl\": \"160\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            {\n" +
            "                \"k\": \"lvl2\",\n" +
            "                \"v\": [\n" +
            "                    {\n" +
            "                        \"lvl2\": \"150\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"lvl2\": \"200\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"lvl2\": \"580\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"lvl2\": \"1005\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"lvl2\": \"1200\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"lvl2\": \"1600\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        ],\n" +
            "        \"event\": \"GameLevelChangedEvent\",\n" +
            "        \"result\": \"Y\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"condition\": [\n" +
            "            {\n" +
            "                \"k\": \"tsnm\",\n" +
            "                \"v\": [\n" +
            "                    {\n" +
            "                        \"tsnm\": \"无尽魔窟\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"tsnm\": \"太古祭坛\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"tsnm\": \"试炼BOSS\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"tsnm\": \"世界BOSS\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        ],\n" +
            "        \"event\": \"GameTaskMovedEvent\",\n" +
            "        \"result\": \"Y\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"event\": \"GameUnionUserJoinedEvent\",\n" +
            "        \"result\": \"Y\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"event\": \"RoleCreatedEvent\",\n" +
            "        \"result\": \"Y\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"event\": \"PayMethodConfirmedEvent\",\n" +
            "        \"result\": \"Y\"\n" +
            "    }\n" +
            "]";


    // 所有MTA实现类的classpath
    public static final String[] classpaths = {
            "com.chujian.mta.impl.channel.APPSFLYER",
            "com.chujian.mta.impl.channel.TOUTIAO",
            "com.chujian.mta.impl.channel.GDT",
            "com.chujian.mta.impl.channel.UC",
            "com.chujian.mta.impl.channel.HUAWEI",
            "com.chujian.mta.impl.channel.YSDK",
            "com.chujian.mta.impl.channel.MEIZU",
            "com.chujian.mta.impl.channel.OPPO",
            "com.chujian.mta.impl.channel.VIVO",
            "com.chujian.mta.impl.channel.LENOVO",
            "com.chujian.mta.impl.channel.YUEWEM",
            "com.chujian.mta.impl.channel.BAIDU",
            "com.chujian.mta.impl.channel.PAPA",
            "com.chujian.mta.impl.channel.BILIBILI",
            "com.chujian.mta.impl.channel.QIHOO360",
            "com.chujian.mta.impl.channel.XIAOMI",
            "com.chujian.mta.impl.channel.SANSUNG",
            "com.chujian.mta.impl.channel.PPS",
            "com.chujian.mta.impl.channel.F4399",
            "com.chujian.mta.impl.channel.GIONEE",
    };


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AFEventUtils.init(json);
        System.out.println("---------是否发送");
        System.out.println(" SDKActivatedEvent : " + AFEventUtils.isSend("SDKActivatedEvent"));
        System.out.println(" ResourceLoadingRequestedEvent : " + AFEventUtils.isSend("ResourceLoadingRequestedEvent"));
        System.out.println(" RoleCreatedEvent : " + AFEventUtils.isSend("RoleCreatedEvent"));
        System.out.println(" GameLevelChangedEvent : " + AFEventUtils.isSend("GameLevelChangedEvent"));


        System.out.println("---------是否包含条件");
        System.out.println(" GameLevelChangedEvent : " + AFEventUtils.isCondition("GameLevelChangedEvent"));
        System.out.println(" GameTaskMovedEvent : " + AFEventUtils.isCondition("GameTaskMovedEvent"));
        System.out.println(" GameUnionUserJoinedEvent : " + AFEventUtils.isCondition("GameUnionUserJoinedEvent"));

        System.out.println("---------获取条件K");
        System.out.println(" GameTaskMovedEvent : " + AFEventUtils.getAFConditionK("GameTaskMovedEvent"));
        System.out.println(" GameLevelChangedEvent : " + AFEventUtils.getAFConditionK("GameLevelChangedEvent"));
        System.out.println(" ResourceLoadingRequestedEvent : " + AFEventUtils.getAFConditionK("ResourceLoadingRequestedEvent"));

        System.out.println("---------获取条件V");


        List<String> gameLevelChangedEvent = AFEventUtils.getAFConditionK("GameLevelChangedEvent");

        if (gameLevelChangedEvent != null && gameLevelChangedEvent.size() > 0) {

            for (String item : gameLevelChangedEvent) {

                List<String> gameLevelChangedEvent1 = AFEventUtils.getAFConditionV("GameLevelChangedEvent", item);

                System.out.println(" GameLevelChangedEvent : " + item + " : " + gameLevelChangedEvent1);

            }

        }


        for (String item : classpaths) {

            System.out.println("channelName : "+item.substring(item.lastIndexOf(".")+1,item.length()));

        }


//        System.out.println(AFEventUtils.getAFConditionV("GameTaskMovedEvent"));
//        System.out.println(AFEventUtils.getAFConditionV("GameLevelChangedEvent"));
//        System.out.println(AFEventUtils.getAFConditionV("ResourceUpdatedEvent"));

//        try {
//            // 载入配置文件
//            JSONArray jsonArray = new JSONArray(json);
//
//            // 检验数据是否安全
//            if (jsonArray == null || jsonArray.length() < 1) {
//                return;
//            }
//
//            // 循环取出对象
//            for (int i = 0; i < jsonArray.length(); i++) {
//
//                // 获取第一个对象
//                JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
//
//                // 获取所有key
//                Iterator<String> keys = jsonObject.keys();
//
//                while (keys.hasNext()) {
//                    String next = keys.next();
//                    System.out.println("keys.next() : " + next);
//
//                    if (next.equals("event")) {
//
//                        // 事件名称
//                        Object event = jsonObject.get("event");
//
//                        System.out.println("event : " + event);
//                    }
//
//                    if (next.equals("result")) {
//
//                        // Y N
//                        Object result = jsonObject.get("result");
//
//                        System.out.println("result : " + result);
//                    }
//
//                    if (next.equals("condition")) {
//
//                        // 条件
//                        Object condition = jsonObject.get("condition");
//
//                        // 检验数据是否安全
//                        if (condition == null || "".equals(condition)) {
//                            return;
//                        }
//
//                        //
//                        System.out.println(condition);
//
//                        //
//                        JSONArray jsonArray1 = new JSONArray(condition.toString());
//
//                        //
//                        if (jsonArray1 == null || jsonArray1.length() < 1) {
//                            return;
//                        }
//
//                        //
//                        for (int j = 0; j < jsonArray1.length(); j++) {
//                            JSONObject jsonObject1 = new JSONObject(jsonArray1.get(j).toString());
//                            Object k = jsonObject1.get("k");
//                            Object v = jsonObject1.get("v");
//
//
//                            JSONArray jsonArray2 = new JSONArray(v.toString());
//
//                            for (int l = 0; l < jsonArray2.length(); l++) {
//
//                                JSONObject jsonObject2 = new JSONObject(jsonArray2.get(l).toString());
//
//                                Object o = jsonObject2.get(k.toString());
//                            }
//                        }
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
