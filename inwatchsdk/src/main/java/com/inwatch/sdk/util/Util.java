package com.inwatch.sdk.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by alibus on 16-3-19.
 */
public class Util {

    public static String hashMapToJson(HashMap map) {
        String string = "{";
        for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry e = (Map.Entry) it.next();
            string += "'" + e.getKey() + "':";
            string += "'" + e.getValue() + "',";
        }
        string = string.substring(0, string.lastIndexOf(","));
        string += "}";
        return string;
    }
}
