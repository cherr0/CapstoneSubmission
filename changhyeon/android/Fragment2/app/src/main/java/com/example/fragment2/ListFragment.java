package com.example.fragment2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    public static interface  ImageSelectionCallback{
        public void onImageSelected(int position);
    }

    public ImageSelectionCallback callback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof ImageSelectionCallback){
            callback = (ImageSelectionCallback) context;
        }
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(callback != null){
                    callback.onImageSelected(0);
                }
            }
        });


        Button button2 = rootView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(callback != null){
                    callback.onImageSelected(1);
                }
            }
        });

        Button button3 = rootView.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(callback != null){
                    callback.onImageSelected(2);
                }
            }
        });

        return rootView;
    }
}

/*
*  각각의 버튼을 클릭했을 때는 callback 객체의 onImageSelected() 메서드를 호출합니다.
*  onAttach() 메서드는 프래그먼트가 액티비티 위에 올라오는 시점에 호출됩니다.
*  그래서 프래그먼트에서 해당 액티비티를 참조하고 싶다면 onAttach() 메서드로 전달되는
*  파라미터를 참조하거나 getActivity() 메서드를 호출하여 반환되는 객체를 참조할 수 있습니다. 그리고
*  그 객체를 변수에 할당하면 프래그먼트 클래스안에서 자유롭게 액티비티 객체를 참조할 수 있게 됩니다.
*
* onAttach() 메서드가 호출될 때 callback 변수에 객체가 할당되었는데 그 자료형이 Activity가 아니라
* ImageSelectionCallback 입니다. 왜 이렇게 했을까요?
* 화면에서 선택된 버튼에 따라 다른 프래그먼트의 이미지를 바꿔주려면 액티비티 쪽으로 데이터를 전달해야
* 하므로 액티비티에 onImageSelected() 메서드를 정의한 후 그 메서드를 호출하도록 합니다.
* 그런데 매번 액티비티마다 다른 이름의 메서드들 만들면 프래그먼트가 올라간 액티비티가 다른 액티비티로 변경되었을때
* 해당 액티비티가 무엇인지 매번 확인해야 하는 번거로움이 있습니다. 이 때문에 인터페이스를 하나 정의한 후
* 액티비티가 이 인터페이스를 구현하도록 하는 것이 좋습니다. 여기에서는 ImageSelectionCallback 인터페이스를 정의했으며
* onImageSelected() 메서드는 이 인터페이스 안에 정의했습니다.
*
* */