package com.graetpro.library.cloudmusicapi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Search {
    public static final int _CONTAIN_FREQUCNEY = 10;

    public static String[] searchMusic(String text, int offset) {
        String[] gStrings = { "", "", "", "", "", "", "", "", "", "", "" };
        String json = Request
                .get("https://api.imjad.cn/cloudmusic/?type=search&search_type=1&s=" + text + "&offset=" + offset);
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(json);
        JsonObject a = jsonObject.get("result").getAsJsonObject();
        JsonArray x = a.getAsJsonArray("songs");
        for (int f = 0; f <= _CONTAIN_FREQUCNEY; f++) {
            JsonObject v = (JsonObject) x.get(f);
            String h = v.get("id").getAsString().toString();
            gStrings[f] = h;
        }
        return gStrings;
    }

    public static String[] searchMusicReturnName(String text, int offset) {
        String[] gStrings = { "", "", "", "", "", "", "", "", "", "", "" };
        String json = Request
                .get("https://api.imjad.cn/cloudmusic/?type=search&search_type=1&s=" + text + "&offset=" + offset);
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(json);
        JsonObject a = jsonObject.get("result").getAsJsonObject();
        JsonArray x = a.getAsJsonArray("songs");
        for (int f = 0; f <= _CONTAIN_FREQUCNEY; f++) {
            JsonArray k = x.get(f).getAsJsonObject().getAsJsonArray("ar");
            JsonObject v = (JsonObject) x.get(f);
            String musicName = v.get("name").getAsString().toString();
            String singer = k.get(0).getAsJsonObject().get("name").getAsString().toString();
            gStrings[f] = singer + " - " + musicName;
        }
        return gStrings;
    }

    public static String[] sercxiMusikoReveniNomo(String text, int offset) {
        String[] gStrings = { "", "", "", "", "", "", "", "", "", "", "" };
        String json = Request
                .get("https://api.imjad.cn/cloudmusic/?type=search&search_type=1&s=" + text + "&offset=" + offset);
        String[] singer = { "", "", "", "", "", "", "", "", "", "", "" };
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(json);
        JsonObject a = jsonObject.get("result").getAsJsonObject();
        JsonArray x = a.getAsJsonArray("songs");
        for (int f = 0; f <= _CONTAIN_FREQUCNEY; f++) {
            JsonArray k = x.get(0).getAsJsonObject().getAsJsonArray("ar");
            JsonObject v = (JsonObject) x.get(f);
            String musicName = v.get("name").getAsString().toString();
            for (int b = 0; b <= 5; b++) {
                try {
                    singer[b]=k.get(b).getAsJsonObject().get("name").getAsString().toString() + "/";
                } catch (Exception e) {

                }
            }
            gStrings[f] = singer[f] + " - " + musicName;
        }
        return gStrings;
    }
}
