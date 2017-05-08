package com.example.fang.screw;

/**
 * Created by FANG on 2017/3/20.
 */

public class Config {
    public static final String URL_LOCATION="http://140.125.49.210/CAN_database/xy_location_test.php";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_CAN_X= "X";
    public static final String KEY_CAN_Y = "Y";


    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_a_y0 = "a_y0";
    public static final String TAG_a_y1 = "a_y1";
    public static final String TAG_a_y2 = "a_y2";
    public static final String TAG_a_y3 = "a_y3";
    public static final String TAG_a_y4 = "a_y4";
    public static final String TAG_b_y0 = "b_y0";
    public static final String TAG_b_y1 = "b_y1";
    public static final String TAG_b_y2 = "b_y2";
    public static final String TAG_b_y3 = "b_y3";
    public static final String TAG_b_y4 = "b_y4";


    //employee id to pass with intent
    public static final String CAN_ID = "can_id";

}
