package com.example.fang.screw;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




public class MainActivity extends AppCompatActivity {

    private String JSON_STRING;
    private Handler handler = new Handler();
    private Button start,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*宣告各種元件*/
        start = (Button)findViewById(R.id.btn_start);
        stop = (Button)findViewById(R.id.btn_stop);
        handler.removeCallbacks(update);
        final ProgressBar circle=(ProgressBar) findViewById(R.id.progressbar);
        circle.setVisibility(View.GONE);
        /*監聽start鍵的點擊事件 計時器開始+progressbar可見*/
        start.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                handler.postDelayed(update, 10);
                circle.setVisibility(View.VISIBLE);
            }
        });
        /*監聽stop鍵的點擊事件 停止更新+progressbar隱藏*/
        stop.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(update);
                circle.setVisibility(View.GONE);
            }
        });
    }
    /*工作包事件*/
    private Runnable update = new Runnable() {
        public void run() {
            getJSON();
            handler.postDelayed(this, 10);
        }
    };
    /*獲得getJSON字串*/
    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //loading = ProgressDialog.show(MainActivity.this, "Fetching Data", "Wait...", false, false);
            }
            /*背景執行獲取字串*/
            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Config.URL_LOCATION);
                return s;
            }
            /*獲得字串之後呼叫更新圖片的function*/
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                JSON_STRING = s;
                showData();
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
    /*更新圖片function*/
    private void showData() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
            String str_value[] = new String[10];
            int i;
            /*將回傳的JSON字串丟至字串陣列*/
            for(i=0;i<=9;i++)
            {
                JSONObject jo = result.getJSONObject(i);
                switch(i)
                {
                    case 0:
                        str_value[0]  = jo.getString(Config.TAG_a_y0);
                        break;
                    case 1:
                        str_value[1] = jo.getString(Config.TAG_a_y1);
                        break;
                    case 2:
                        str_value[2] = jo.getString(Config.TAG_a_y2);
                        break;
                    case 3:
                        str_value[3] = jo.getString(Config.TAG_a_y3);
                        break;
                    case 4:
                        str_value[4] = jo.getString(Config.TAG_a_y4);
                        break;
                    case 5:
                        str_value[5] = jo.getString(Config.TAG_b_y0);
                        break;
                    case 6:
                        str_value[6] = jo.getString(Config.TAG_b_y1);
                        break;
                    case 7:
                        str_value[7] = jo.getString(Config.TAG_b_y2);
                        break;
                    case 8:
                        str_value[8] = jo.getString(Config.TAG_b_y3);
                        break;
                    case 9:
                        str_value[9] = jo.getString(Config.TAG_b_y4);
                        break;
                }
            }
            /*將字串陣列轉成整數陣列*/

            int value[] = new int[10];
            for(int j=0;j<=9;j++)
            {
                value[j]=Integer.parseInt(str_value[j]);
            }
            ImageView a_y0 = (ImageView) findViewById(R.id.a_y0);
            a_y0.setImageResource(R.drawable.change);
            a_y0.setImageLevel(value[0]);
            ImageView a_y1 = (ImageView) findViewById(R.id.a_y1);
            a_y1.setImageResource(R.drawable.change);
            a_y1.setImageLevel(value[1]);
            ImageView a_y2 = (ImageView) findViewById(R.id.a_y2);
            a_y2.setImageResource(R.drawable.change);
            a_y2.setImageLevel(value[2]);
            ImageView a_y3 = (ImageView) findViewById(R.id.a_y3);
            a_y3.setImageResource(R.drawable.change);
            a_y3.setImageLevel(value[3]);
            ImageView a_y4 = (ImageView) findViewById(R.id.a_y4);
            a_y4.setImageResource(R.drawable.change);
            a_y4.setImageLevel(value[4]);
            ImageView b_y0 = (ImageView) findViewById(R.id.b_y0);
            b_y0.setImageResource(R.drawable.change);
            b_y0.setImageLevel(value[5]);
            ImageView b_y1 = (ImageView) findViewById(R.id.b_y1);
            b_y1.setImageResource(R.drawable.change);
            b_y1.setImageLevel(value[6]);
            ImageView b_y2 = (ImageView) findViewById(R.id.b_y2);
            b_y2.setImageResource(R.drawable.change);
            b_y2.setImageLevel(value[7]);
            ImageView b_y3 = (ImageView) findViewById(R.id.b_y3);
            b_y3.setImageResource(R.drawable.change);
            b_y3.setImageLevel(value[8]);
            ImageView b_y4 = (ImageView) findViewById(R.id.b_y4);
            b_y4.setImageResource(R.drawable.change);
            b_y4.setImageLevel(value[9]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
