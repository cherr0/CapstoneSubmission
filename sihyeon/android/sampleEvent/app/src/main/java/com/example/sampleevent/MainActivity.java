package com.example.sampleevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode ==KeyEvent.KEYCODE_BACK) { //백버튼일때
            Toast.makeText(this, "시스템[Back] 버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
            //토스트로 위의 내용을 메시지를 출력
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //리소스의 레이아웃의 액티비티메인 xml 설정

        textView = findViewById(R.id.textView);//텍스트뷰 아이디 값을 찾아 텍스트 뷰 변수에 참조

        View view = findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() { //뷰가 터치 됐을 때마다 리스너 객체의 onTouch 메서드 자동 호출
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();//액션 정보

                float curX = motionEvent.getX();//x좌표값
                float curY = motionEvent.getY();//y좌표값

                if(action == MotionEvent.ACTION_DOWN) {
                    println("손가락 눌림 : " + curX + ", " + curY);
                }else if(action == MotionEvent.ACTION_MOVE) {
                    println("손가락 움직임 : " + curX + ", " + curY);
                }else if(action == MotionEvent.ACTION_UP) {
                    println("손가락 뗌 : " + curX + ", " + curY);
                }

                return true;
            }
        });

    }
    public void println(String data) {
        textView.append(data + "\n");//절달받은 데이터를 텍스트뷰로 보여줌
    }
}