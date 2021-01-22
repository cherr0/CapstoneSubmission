package com.example.samplelayoutinflater;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {
    LinearLayout contaitner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        contaitner = findViewById(R.id.container);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater)//객체 얻어오기
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);//context=리소스 접근통로
                inflater.inflate(R.layout.sub1, contaitner, true);
                //1번째 자리 부풀릴 xml소스, 두번째자리 뷰의 부모 뷰그룹, 마지막 뷰에 붙일건지 여부
                CheckBox checkBox = contaitner.findViewById(R.id.checkBox);
                checkBox.setText("로딩되었어요");

            }

        });
    }
}