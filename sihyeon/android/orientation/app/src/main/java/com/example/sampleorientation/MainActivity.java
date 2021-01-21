package com.example.sampleorientation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;
    EditText editText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast("onCreate 호출됨"); //메모리가 만들어져야 할 시점에서 메 create 메서드 호출

        editText = findViewById(R.id.editText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {//클릭할때마다 세팅
            @Override
            public void onClick(View view) {
                name = editText.getText().toString();//텍스트값 받아와서 저장
                showToast("입력된 값을 변수에 저장했습니다 : " + name);
            }
        });
        if(savedInstanceState != null) {
            name = savedInstanceState.getString("name");//단말에 저장된 값을 다시 불러온다
            showToast("값을 복원했습니다." + name);
        }

    }
    @Override
    protected void onStart() {
        super.onStart();

        showToast("onStart 호출됨");//화면에 보이기 전에 onStart 메서드 호출
    }



    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop 호출됨");//화면에 보이다가 없어지면 스탑 메서드 호출 
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestory 호출됨");//메모리가 없어지는 시점

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) { //액티비티 메모리가 없어지기 전에 이 메서드 안에서 변수 값을 저장
        super.onSaveInstanceState(outState);
        
        outState.putString("name",name);
    }


    private void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
        //데이터를 받아 토스트 보여주기
    }

}