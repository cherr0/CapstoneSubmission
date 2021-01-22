package com.example.sampleintent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU =101;

    //새로 띄웠던 메뉴 액티비티가 응답을 보내오면 응답 처리하는 역할
    //첫번째 requestCode 요청코드와 같다 이 값으로 응답을 구분한다
    //두번째 requestCode 새 액티비티로 부터 전달된 응답 코드 처리결과가 정상인지 아닌지 구분
    //세번째 전달받은 인텐트
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_MENU) {
            Toast.makeText(getApplicationContext(),
                    "onActivityResult 메서드 호출됨. 요청코드 : " + requestCode +
                            ", 결과 코드"+ resultCode, Toast.LENGTH_LONG).show();

            if(resultCode ==RESULT_OK) { //정상처리 시
                String name = data.getStringExtra("name");
                Toast.makeText(getApplicationContext(), "응답으로 전달된 name : " + name,
                        Toast.LENGTH_LONG).show();
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

                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivityForResult(intent,REQUEST_CODE_MENU);
                //이 메소드는 새 액티비티를 띄우지만 새 액티비티로 부터 응답을 받을 수 있다.
                //request코드 메뉴는 새 액티비티를 띄울 때 보낼 요청 코드 숫자는 마음대로 해도 됨

            }
        });
    }
}