package org.techtown.permission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // SD 카드에 접근하기 위한 권한
        String[] permissions = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        checkPermissions(permissions);
    }

    public void checkPermissions(String[] permissions) {

        // 권한 요청 리스트
       ArrayList<String> targetList = new ArrayList<String>();

        for(int i=0 ; i<permissions.length ; i++) {
            String curPermission = permissions[i];

            /*
                checkSelfPermission() 메서드로 이미 권한이 부여되어 있는지 확인함
                만약 권한이 부여되지 않았다면 requestPermissions() 메서드를 호출하여 권한 부여 요청 대화상자를 띄워준다.
                이 대화상자는 직접 만드는 것이 아닌 시스템에서 띄워주기 때문에 사용자가 수락했는지, 거부했는지 여부를 콜백 메서드로 받아 확인하는 것이 가능하다.
                이렇게 권한을 요청하면 콜백 메서드로 그 결과를 받을 수 있다.
            */
            int permissionCheck = ContextCompat.checkSelfPermission(this, curPermission);

            // 필요 권한마다 사용 가능한지 확인 후 메시지 출력
            if(permissionCheck == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, curPermission + " 권한 있음.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, curPermission + " 권한 없음.", Toast.LENGTH_LONG).show();
                if(ActivityCompat.shouldShowRequestPermissionRationale(this, curPermission)) {
                    Toast.makeText(this, curPermission + " 권한 설명 필요함",
                            Toast.LENGTH_LONG).show();
                }else {
                    targetList.add(curPermission);
                }
            }
        }

        String[] targets = new String[targetList.size()];
        targetList.toArray(targets);

        // 위험권한 부여 요청
        ActivityCompat.requestPermissions(this, targets, 101);
    }

    // 메서드 재정의
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {   // 요청 코드가 맞는지 확인

            case 101 : {    // 사용자가 권한을 수락했는지에 대한 여부를 확인
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "첫 번째 권한을 사용자가 승인함",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "첫 번째 권한 거부됨.", Toast.LENGTH_LONG).show();
                }

                return;
            }

        }
    }
}