package gif.ganesh.pushnotififirebase;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MyFbToken extends FirebaseInstanceIdService
{
    @Override
    public void onTokenRefresh()
    {
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.e("tokenGenrated",token);
    }
}

//
//public class MyFbToken extends FirebaseMessagingService
//{
//
//    private MainActivity con;
//    @Override
//    public void onNewToken(String s)
//    {
//        //super.onNewToken(s);
//
//        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener( con,  new OnSuccessListener<InstanceIdResult>() {
//            @Override
//            public void onSuccess(InstanceIdResult instanceIdResult) {
//                String newToken = instanceIdResult.getToken();
//                Log.e("newToken",newToken);
//
//            }
//        });
//
//
//    }


//}
