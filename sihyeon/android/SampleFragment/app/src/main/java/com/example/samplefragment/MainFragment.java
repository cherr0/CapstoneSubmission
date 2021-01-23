package com.example.samplefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class MainFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //최상위 레이아웃
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //겟 액티비티 메서드를 통해 프래그먼트가 올라가있는 액티비티가 어떤것인지 확인한다
                MainActivity activity = (MainActivity) getActivity();
                //메인 액티비티에 새로 추가할 메서드로 프래그먼트 매니저를 이용해 프래그먼트를 전환하는 메서드
                activity.onFragmentChange(0);
            }
        });

        return rootView;
    }

}
