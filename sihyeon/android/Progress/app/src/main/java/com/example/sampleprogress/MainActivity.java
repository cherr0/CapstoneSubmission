package com.example.sampleprogress;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = findViewById(R.id.progressBar);//프로그래스바 객체 참조하기
        progressBar.setIndeterminate(false);
        progressBar.setProgress(80);//정수 값을 받아와 프로그래스바의 현재 값으로 설정

        Button button = findViewById(R.id.button);//보여주기버튼
        button.setOnClickListener(new View.OnClickListener() { //누를때마다 이벤트발생
            @Override
            public void onClick(View view) {
                dialog = new ProgressDialog(MainActivity.this); //프로그래스다이로그 객체 생성
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//원모양 
                dialog.setMessage("데이터를 확인하는 중입니다.");

                dialog.show();
            }
        });
        Button button2 = findViewById(R.id.button2); //닫기버튼아이디
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog != null) { //플로그래스 대화상자 없애기
                    dialog.dismiss();
                }
            }
            });
        }
    }


