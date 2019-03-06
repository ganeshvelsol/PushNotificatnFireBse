package gif.ganesh.pushnotififirebase;

import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFbToken extends FirebaseInstanceIdService
{
    @Override
    public void onTokenRefresh()
    {
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.e("tokenGenrated",token);
    }
}
