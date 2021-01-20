package org.techtown.mysamplescrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    ImageView imageView;
    BitmapDrawable bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            scrollView = findViewById(R.id.scrollView);
            imageView = findViewById(R.id.imageView);
            scrollView.setHorizontalScrollBarEnabled(false);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.a);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getMinimumHeight();

        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;

    }

    public void onButton1Clicked(View v) {
        changeImage();
    }

    private  void  changeImage () {
        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.b);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getMinimumHeight();

        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
    }
}