package com.example.fang.screw;

/**
 * Created by FANG on 2017/3/20.
 */

public class Config {
    public static final String URL_LOCATION="http://140.125.49.210/CAN_database/xy_location.php";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_CAN_X= "X";
    public static final String KEY_CAN_Y = "Y";


    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_X = "X";
    public static final String TAG_Y = "Y";


    //employee id to pass with intent
    public static final String CAN_ID = "can_id";

}
