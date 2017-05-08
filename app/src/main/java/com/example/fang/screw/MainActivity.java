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

import static com.example.fang.screw.Config.TAG_Y;

public class MainActivity extends AppCompatActivity {

    private String JSON_STRING;
    private Handler handler = new Handler();
    private Button start,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button)findViewById(R.id.btn_start);
        stop = (Button)findViewById(R.id.btn_stop);
        handler.removeCallbacks(update);

        final ProgressBar circle=(ProgressBar) findViewById(R.id.progressbar);
        circle.setVisibility(View.GONE);

        start.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                handler.postDelayed(update, 10);
                circle.setVisibility(View.VISIBLE);
            }
        });
        stop.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(update);
                circle.setVisibility(View.GONE);
            }
        });

    }
    private Runnable update = new Runnable() {
        public void run() {
            getJSON();
            handler.postDelayed(this, 10);
        }
    };

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {
            ProgressBar circle=(ProgressBar) findViewById(R.id.progressbar);
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                circle.setVisibility(View.VISIBLE);
                //loading = ProgressDialog.show(MainActivity.this, "Fetching Data", "Wait...", false, false);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Config.URL_LOCATION);
                return s;
            }
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

    private void showData() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);

            int i = 0;
            JSONObject jo = result.getJSONObject(i);
            String x = jo.getString(Config.TAG_X);
            String y = jo.getString(TAG_Y);
            int x_i = Integer.parseInt(x);

            switch (y) {
                case "A_Y0":
                    ImageView a_y0 = (ImageView) findViewById(R.id.a_y0);
                    a_y0.setImageResource(R.drawable.change);
                    a_y0.setImageLevel(x_i);
                    break;
                case "A_Y1":
                    ImageView a_y1 = (ImageView) findViewById(R.id.a_y1);
                    a_y1.setImageResource(R.drawable.change);
                    a_y1.setImageLevel(x_i);
                    break;
                case "A_Y2":
                    ImageView a_y2 = (ImageView) findViewById(R.id.a_y2);
                    a_y2.setImageResource(R.drawable.change);
                    a_y2.setImageLevel(x_i);
                    break;
                case "A_Y3":
                    ImageView a_y3 = (ImageView) findViewById(R.id.a_y3);
                    a_y3.setImageResource(R.drawable.change);
                    a_y3.setImageLevel(x_i);
                    break;
                case "A_Y4":
                    ImageView a_y4 = (ImageView) findViewById(R.id.a_y4);
                    a_y4.setImageResource(R.drawable.change);
                    a_y4.setImageLevel(x_i);
                    break;
                case "B_Y0":
                    ImageView b_y0 = (ImageView) findViewById(R.id.b_y0);
                    b_y0.setImageResource(R.drawable.change);
                    b_y0.setImageLevel(x_i);
                    break;
                case "B_Y1":
                    ImageView b_y1 = (ImageView) findViewById(R.id.b_y1);
                    b_y1.setImageResource(R.drawable.change);
                    b_y1.setImageLevel(x_i);
                    break;
                case "B_Y2":
                    ImageView b_y2 = (ImageView) findViewById(R.id.b_y2);
                    b_y2.setImageResource(R.drawable.change);
                    b_y2.setImageLevel(x_i);
                    break;
                case "B_Y3":
                    ImageView b_y3 = (ImageView) findViewById(R.id.b_y3);
                    b_y3.setImageResource(R.drawable.change);
                    b_y3.setImageLevel(x_i);
                    break;
                case "B_Y4":
                    ImageView b_y4 = (ImageView) findViewById(R.id.b_y4);
                    b_y4.setImageResource(R.drawable.change);
                    b_y4.setImageLevel(x_i);
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
