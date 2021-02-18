package org.techtown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText) findViewById(R.id.et_save);


        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("key", "");  // 인자1 : 키값, 인자2 : 값이 없을 경우의 기본값
        et_save.setText(value);
    }


    // 앱을 종료시킬 경우 실행되는 생명주기 메서드
    @Override
    protected void onDestroy() {
        super.onDestroy();


        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // 앱을 나갈 때 Text 값 저장
        String value = et_save.getText().toString();    // Text 값 받아오기
        editor.putString("key", value); // 값 넣기 (이름, 값)
        editor.commit(); // 값 저장
   }
}