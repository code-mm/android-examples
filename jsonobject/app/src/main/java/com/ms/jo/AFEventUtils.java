package com.ms.jo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AFEventUtils {

    public static String MJSON = "[\n" +
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

    private static JSONArray jsonArray;

    public static void init(String json) {

        MJSON = json;
        try {
            jsonArray = new JSONArray(MJSON);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    // 是否发送
    public static boolean isSend(String event) {
        if (event == null) {
            return false;
        }
        try {
            if (jsonArray == null || jsonArray.length() < 1) {
                return false;
            }
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
                if (event.equals(jsonObject.get("event"))) {
                    if ("Y".equals(jsonObject.get("result"))) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }


    // 是否带条件
    public static boolean isCondition(String event) {
        if (event == null) {
            return false;
        }

        try {

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());

                Object event1 = jsonObject.get("event").toString();

                if (event.equals(event1)) {

                    Iterator<String> keys = jsonObject.keys();

                    while (keys.hasNext()) {
                        String next = keys.next();
                        if ("condition".equals(next)) {

                            String condition = jsonObject.get("condition").toString();

                            if (condition != null && !"".equals(condition)) {

                                JSONArray jsonArray = new JSONArray(condition);

                                if (jsonArray != null && jsonArray.length() > 0) {

                                    return true;
                                }
                            }

                        }
                    }
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }


    // 获取条件 K
    public static List<String> getAFConditionK(String event) {
        List<String> list = new ArrayList<>();
        if (event == null) {
            return list;
        }
        try {
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());

                Object event1 = jsonObject.get("event").toString();

                if (event.equals(event1)) {

                    Iterator<String> keys = jsonObject.keys();

                    while (keys.hasNext()) {
                        String next = keys.next();
                        if ("condition".equals(next)) {

                            String condition = jsonObject.get("condition").toString();

                            if (condition != null && !"".equals(condition)) {
                                JSONArray jsonArray = new JSONArray(condition);
                                if (jsonArray == null || jsonArray.length() < 1) {
                                    return list;
                                }
                                for (int j = 0; j < jsonArray.length(); j++) {
                                    JSONObject jsonObject1 = new JSONObject(jsonArray.get(j).toString());
                                    Iterator<String> keys1 = jsonObject1.keys();
                                    while (keys1.hasNext()) {
                                        String next1 = keys1.next();
                                        if ("k".equals(next1)) {
                                            list.add(jsonObject1.get("k").toString());
                                        }
                                    }

                                }
                                return list;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    // 获取条件 V
    public static List<String> getAFConditionV(String event, String key) {
        List<String> list = new ArrayList<>();
        if (event == null) {
            return list;
        }
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
                Object event1 = jsonObject.get("event").toString();
                if (event.equals(event1)) {
                    Iterator<String> keys = jsonObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if ("condition".equals(next)) {
                            String condition = jsonObject.get("condition").toString();
                            if (condition != null && !"".equals(condition)) {
                                JSONArray jsonArray = new JSONArray(condition);
                                if (jsonArray == null || jsonArray.length() < 1) {
                                    return list;
                                }
                                for (int j = 0; j < jsonArray.length(); j++) {
                                    JSONObject jsonObject1 = new JSONObject(jsonArray.get(j).toString());
                                    String k1 = jsonObject1.get("k").toString();
                                    JSONArray jsonArray1 = new JSONArray(jsonObject1.get("v").toString());
                                    if (jsonArray1 == null || jsonArray1.length() < 1) {
                                        return list;
                                    }
                                    for (int k = 0; k < jsonArray1.length(); k++) {
                                        if (key.equals(k1)) {
                                            JSONObject jsonObject2 = new JSONObject(jsonArray1.get(k).toString());
                                            list.add(jsonObject2.get(key).toString());
                                        }
                                    }

                                }
                                return list;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }
}
