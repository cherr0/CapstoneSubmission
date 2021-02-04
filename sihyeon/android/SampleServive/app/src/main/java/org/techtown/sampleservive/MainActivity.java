package org.techtown.sampleservive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.EditText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MyService.class);//인턴트 객체 만들고 부가데이터 넣기
                intent.putExtra("command","show"); //인텐트로 액티비티를 이동하는데 이 때
                //액티비티 이동과 동시에 이전 액티비티에서 이동하는 액티비티로 해당 값을 넘겨 준다.
                intent.putExtra("name",name); //인텐트에 해당 내용과 String 내용을 전달

                startService(intent);
            }
        });
        Intent passedIntent = getIntent();
        processIntent(passedIntent);
    }

    @Override
    protected void onNewIntent(Intent intent) { //액티비가 이미 있으면 oncreate를 실행하지 않고 바로여기로 온다
        processIntent(intent);//액티비티가 이미 만들어져 있을 때 전달된 인텐트 처리하기
        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent) {
        if(intent != null) {
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");

            Toast.makeText(this,"command : " + command + ", name : " + name, Toast.LENGTH_LONG).show();
        }
    }
}