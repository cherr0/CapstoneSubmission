package com.example.samplelifecycle;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        println("onCreate 호출됨");
    }

    @Override
    protected void onStart() {
        super.onStart();

        println("onStart 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();

        println("onStop 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        println("onDestroy 호출됨");
    }

    @Override
    protected void onPause() {
        super.onPause();
        println("onPause 호출됨");
        saveState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        println("onResume 호출됨");
        restoreState();
    }

    public void println(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
        Log.d("Main", data);
    }
    
    //저장된 데이터를 가져와 토스트 메시지로 띄움
    protected void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        //데이터가 있을때
        if ((pref != null) && (pref.contains("name"))) {
            String name = pref.getString("name", "");//데이터 가져옴
            nameInput.setText(name);//에디트텍스트에 띄움
        }
    }
    
    //저장
    protected void saveState() {
        //pre문자열을 저장소의 이름으로 사용
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();//데이터를 저장할 수 있도록 edit메소드 호출
        editor.putString("name", nameInput.getText().toString());//저장할 데이터를 설정
        editor.commit();//커밋 메소드로 실제 저장
    }

    protected void clearState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}