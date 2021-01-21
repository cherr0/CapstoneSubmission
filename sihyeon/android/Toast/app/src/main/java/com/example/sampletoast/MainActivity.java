package com.example.sampletoast;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);//x값이 들어갈 곳 id를 통해 참조
        editText2 = findViewById(R.id.editText2);//y값이 들어갈 곳 id를 통해 참조
    }
    public void onButton1Clicked(View v) {
        try {
            Toast toastView = Toast.makeText(this,"위치가 바뀐 토스트 메시지입니다.", Toast.LENGTH_LONG);
            int xOffset = Integer.parseInt(editText.getText().toString());//값 string을 int로 형변환 후 x 값 가져오기
            int yOffset = Integer.parseInt(editText2.getText().toString());//값 string을 int로 형변환 후 y 값 가져오기

            toastView.setGravity(Gravity.TOP|Gravity.TOP,xOffset,yOffset);//top을 정렬 위치로 정하고 좌표값에 맞게 정렬
            toastView.show();//보여주기
        } catch(NumberFormatException e) { //형변환 실패했을 경우
            e.printStackTrace();
        }
    }
    public void onButton2Clicked(View v) {
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(
                R.layout.toastborder,
                (ViewGroup)findViewById(R.id.toast_layout_root));
        TextView text = layout.findViewById(R.id.text);

        Toast toast = new Toast(this);
        text.setText("모양 바꾼 토스트");
        toast.setGravity(Gravity.CENTER,0,-100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
    public void onButton3Clicked(View v) {
        Snackbar.make(v, "스낵바입니다.", Snackbar.LENGTH_LONG).show();
    }
}