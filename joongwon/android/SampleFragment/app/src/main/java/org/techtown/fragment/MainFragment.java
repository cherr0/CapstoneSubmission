package org.techtown.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {
    /*
    inflate() 메서드로 전달되는 첫번째 파라미터는 XML 레이아웃 파일이 되므로
    R.layout.fragment_main 이 입력되어 있다.

    두번째 파라미터는 이 XML 레이아웃이 설정될 뷰그룹 객체가 되는데 onCreateView() 메서드로
    전달되는 두번째 파라미터가 가장 상위 레이아웃이다. 따라서 컨테이너 객체를 전달하면 된다.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 최상위 레이아웃 객체 지정
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main,container,false);
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.onFragmentChanged(0);
            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }
}