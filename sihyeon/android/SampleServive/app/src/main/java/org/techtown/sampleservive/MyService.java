package org.techtown.sampleservive;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public void onCreate() {

        super.onCreate();
        Log.d(TAG,"onCreate()호출됨");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand() 호출됨");

        if(intent == null){//인턴트 객체가 널이 아니면 프로세스커맨드 메서드를 호출한다.
            return Service.START_NOT_STICKY;
        } else {
            processCommand(intent);
        }

        return super.onStartCommand(intent, flags, startId);
    }


    private void processCommand(Intent intent) {//인텐트에서 부가데이터 가져온다
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");

        Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);//액티비티를 띄우기 위한 객체 만들기
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |  //인텐트에 플래그 추가하기
                Intent.FLAG_ACTIVITY_SINGLE_TOP 
                | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Log.d(TAG,"command :" + command+",name : " + name);
        showIntent.putExtra("command","show");
        showIntent.putExtra("name", name + " from service.");
        startActivity(showIntent);

        for(int i = 0; i<5; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            };
            Log.d(TAG,"Waiting " + i + "second.");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


}