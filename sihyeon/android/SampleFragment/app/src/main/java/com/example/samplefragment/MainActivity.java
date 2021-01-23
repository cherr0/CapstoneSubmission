package com.example.samplefragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MainFragment mainFragment;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = (MainFragment)getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        menuFragment = new MenuFragment();
    }

    public void onFragmentChanged(int index) {
        //0일 경우 메인프래그먼트 창 리플레이스르를 통해 프래그먼트를 바꾼다
        //리플레이스의 첫번째는 프래그먼트를 담고있는 레이아웃의 아이디를 전달해야 한다.
        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, 
                    menuFragment).commit();
            //1일 경우 메뉴프래그먼트 창
        } else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, 
                    mainFragment).commit();
        }
    }
}