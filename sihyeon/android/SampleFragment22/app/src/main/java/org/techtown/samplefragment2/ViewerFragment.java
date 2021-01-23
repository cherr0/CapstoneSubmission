package org.techtown.samplefragment2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ViewerFragment extends Fragment {
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //첫번째는 부풀릴 xml 소스이고 두번째는 뷰그룹이고
        //세번째는 false라서 뷰에 붙이지 않고 가지고만 있는다
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_viewer, container, false);
        imageView = rootView.findViewById(R.id.imageView);

        return rootView;
    }
    //이미지 세팅
    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }

}