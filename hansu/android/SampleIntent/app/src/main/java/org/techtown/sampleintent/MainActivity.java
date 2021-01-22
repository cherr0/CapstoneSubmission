package org.techtown.sampleintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUSET_CODE_MENU = 101; // 새 액티비티를 띄울때 보낼 요청코드

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { // 새로 띄웠던 메뉴 액티비티가 응답을 보내오면 그 응답을 처리하는 역할
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUSET_CODE_MENU) {
            Toast.makeText(getApplicationContext(),
                    "onActivityResult 메서드 호출됨. 요청 코드 : " + requestCode +
                            ", 결과 코드 : " + requestCode, Toast.LENGTH_LONG).show();
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                Toast.makeText(getApplicationContext(),"응답으로 전달된 name : " + name,
                        Toast.LENGTH_LONG ).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class); //첫번째 파라미터로 컨텍스 객체가 전달 일반적으로는 this사용 두번째 파라미터로는 매니액티비티 클래스를 전달
                startActivityForResult(intent, REQUSET_CODE_MENU); // 새 액티비티로 응답 가능
            }
        });

    }
}