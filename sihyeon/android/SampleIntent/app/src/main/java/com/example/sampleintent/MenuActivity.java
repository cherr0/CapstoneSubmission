package com.example.sampleintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();//인텐트 객체 생성
                intent.putExtra("name","mike");//네임값을 부가 데이터로 넣는다.
                setResult(RESULT_OK,intent); //응답 보내기
                finish();//현재 액티비티 없애기

            }
        });

    }
}