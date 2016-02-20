package com.jeff.michael.heesung.lrn;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by jeff on 2/20/16.
 */
public class Utility {

    public static String JsonArrayToString(JSONArray jArray){
        String string = "";
        JSONArray jsonArray = new JSONArray();
        for(int i = 0, count = jsonArray.length(); i< count; i++)
        {
            try {
                string += jsonArray.getString(i).toString();
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return string;
    }
}
