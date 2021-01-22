package org.techtown.sampleparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;
    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

                // SimpleData 객체 생성
                // 정수는 100, 문자열은 "Hello Android!"인 데이터가 객체로 만들어짐
                SimpleData data = new SimpleData(100, "Hello Android!");

                // 인텐트에 부가 데이터로 넣기
                intent.putExtra(KEY_SIMPLE_DATA, data);
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });

    }
}