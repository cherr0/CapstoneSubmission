package org.techtown.sampleintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.button);  // 버튼 객체 참조
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // 인텐트 객체 생성하고 name의 값을 부가 데이터로 넣기
                Intent intent = new Intent();
                intent.putExtra("name","mike");

                setResult(RESULT_OK, intent);   // 응답 보내기
                finish();   // 현재 액티비티 없애기
            }
        });
    }
}