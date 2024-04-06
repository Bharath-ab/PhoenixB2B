package com.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TestUtil {
    public static String apiToken;
    private static Properties prop;
    public static String masterAPIResponse;
    static {
        loadPropFile();
    }

    public static void loadPropFile() {
        FileReader fileReader;
        prop = new Properties();
        try {
            File myFile = new File(System.getProperty("user.dir") + "/configs/dev.properties");
            fileReader = new FileReader(myFile);
            prop.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseURL() {
        return prop.getProperty("BASE_URL");
    }

    public static String getOriginUrl() {
        return prop.getProperty("ORIGIN");
    }

    public static String getRefererUrl() {
        return prop.getProperty("REFERER");
    }

    public static String generateString(int lengthOfString) {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "").toUpperCase().substring(0, lengthOfString);
    }

    public static String generateNumber(int length) {
        Random random = new Random();
        long nextLong = Math.abs(random.nextLong());
        return String.valueOf(nextLong).substring(0, length);
    }

    private void parseObject(JSONObject json, String key,ArrayList<Object> storeKeys) {
        storeKeys.add(json.get(key));

    }

    private  ArrayList<Object> getKeys(JSONObject json, String key,ArrayList<Object> storeKeys) {
        boolean exists = json.has(key);
        Iterator<?> keys;
        String nextKeys;

        if (!exists) {
            keys = json.keys();
            while (keys.hasNext()) {

                nextKeys = (String) keys.next();

                try {
                    if (json.get(nextKeys) instanceof JSONObject) {

                        if (exists == false) {
                            getKeys(json.getJSONObject(nextKeys), key,storeKeys);
                        }

                    } else if (json.get(nextKeys) instanceof JSONArray) {
                        JSONArray jsonarray = json.getJSONArray(nextKeys);
                        for (int i = 0; i < jsonarray.length(); i++) {
                            String jsonarrayString = jsonarray.get(i).toString();
                            JSONObject innerJSON = new JSONObject(jsonarrayString);

                            if (exists == false) {
                                getKeys(innerJSON, key,storeKeys);
                            }

                        }

                    }

                } catch (Exception e) {
                }

            }

        } else {
            parseObject(json, key,storeKeys);
        }
        return storeKeys;
    }

    public ArrayList<Object> iterateOverJSONArray(String jsonASString, String key) {
        ArrayList<Object> parsedKeys = new ArrayList<>();
        JSONObject convertedJSON;

        if(jsonASString.charAt(0)=='{'){
            convertedJSON = new JSONObject(jsonASString);
            getKeys(convertedJSON, key,parsedKeys);
        }
        else if(jsonASString.charAt(0) =='['){
            jsonASString  = jsonASString.substring(1, jsonASString.length() - 1);
            jsonASString = "{\"jsonArrayToJson\":"+jsonASString+"}";
            convertedJSON = new JSONObject(jsonASString);
            getKeys(convertedJSON, key,parsedKeys);

        }

        return parsedKeys;
    }

    public static List<String> convertObjectArrayToList(ArrayList<Object> objectArrayList){
                List<String> strings = objectArrayList.stream()
                .map(object -> Objects.toString(object, null))
                .toList();
        return strings;
    }

}
