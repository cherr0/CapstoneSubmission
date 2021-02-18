package org.techtown;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private View drawerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawer);

        Button btn_open = (Button) findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        Button btn_close = (Button) findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });


        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

    }

    // 이곳에서 상태값들을 받아온다
    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        // 슬라이드
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        // 열림
        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        // 닫힘
        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        // 어떤 상태 변화를 받아옴
        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
}