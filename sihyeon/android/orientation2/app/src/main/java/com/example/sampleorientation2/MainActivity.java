package com.example.sampleorientation2;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //뉴 컨피그에는 현재 단말이 가로인지 새로인지에 대한 정보가 들어 있다

        //가로 방향일 때 처리
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) { 
            showToast("방향 : ORIENTATION_LANDSCAPE");
        //세로 방향일 때 처리
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            showToast("방향 : ORIENTATION_PORTRAIT");
        }
    }
    public void showToast(String data) {
        Toast.makeText(this,data, Toast.LENGTH_LONG).show();
    }
}