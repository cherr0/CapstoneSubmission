package com.example.samplelayoutinflater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);//화면에 표시할 xml 레이아웃을 지정하거나 화면에 표시할 뷰 객체를 지정

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"버튼이 눌렸어요",Toast.LENGTH_LONG).show();

            }
        });
        setContentView(R.layout.activity_main);
    }
}