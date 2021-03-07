package com.codesample;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyfirebaseIIDservice";

    // FCM 토큰 : 각 기기에서 받아올 수 있는 난수의 값
    // 토큰을 가지고 있는 디바이스들은 푸쉬 알림을 이 프로젝트에 한해서 받을 수 있다.
    @Override
    public void onTokenRefresh() {

        String token = FirebaseInstanceId.getInstance().getToken();

        Log.e(TAG, "token : " + token);

        sendRegistrationToServer(token);

    }



    private void sendRegistrationToServer (String token) {

    }
}
