package org.techtown.receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        // 확인 버튼을 누를 경우 finish() 메서드를 호출하여 이 화면을 닫아준다.
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 전달받은 인텐트 처리하도록 processIntent 메서드 호출하기
        Intent passedIntnet = getIntent();
        processIntent(passedIntnet);
    }

    /*
        이 액티비티가 이미 만들어져 있는 상태에서 전달받은 인텐트도 처리하도록 한다.
        processIntent() 메서드 안에서는 인텐트 객체 안에 들어 있는 부가 데이터를 꺼내서 입력상자에 설정한다.
     */
    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);

        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent) {

        // 인텐트가 null이 아니면 그 안에 들어있는 부가 데이터를 화면에 보여주기
       if(intent != null) {
            String sender = intent.getStringExtra("sender");
            String contents = intent.getStringExtra("contents");
            String receivedDate = intent.getStringExtra("receivedDate");

            editText.setText(sender);
            editText2.setText(contents);
            editText3.setText(receivedDate);
        }
    }
}