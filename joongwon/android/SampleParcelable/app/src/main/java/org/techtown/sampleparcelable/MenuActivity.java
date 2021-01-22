package org.techtown.sampleparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    TextView textView;

    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name","mike"); // 보낼 데이터
                setResult(RESULT_OK, intent);   // 클릭 시 보낼 값 전달

                finish();
            }
        });

        Intent intent = getIntent();
        processIntent(intent);
    }

    private void processIntent(Intent intent) {
        if(intent != null) {
            // 받은 부가 데이터 항목 가져오기
            Bundle bundle = intent.getExtras();

            // KEY_SIMPLE_DATA로 설정되어 있던 값을 찾아서 가져옴
            SimpleData data = bundle.getParcelable(KEY_SIMPLE_DATA);

            textView.setText("전달 받은 데이터\nNumber : " + data.number + "\nMessage : " + data.message);

        }
    }
}