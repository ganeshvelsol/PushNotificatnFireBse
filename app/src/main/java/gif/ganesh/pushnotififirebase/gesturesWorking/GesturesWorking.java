package gif.ganesh.pushnotififirebase.gesturesWorking;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import gif.ganesh.pushnotififirebase.R;

public class GesturesWorking extends AppCompatActivity //implements View.OnTouchListener, GestureDetector.OnGestureListener
{

    SwipeRefreshLayout sipe_refresh;
    LinearLayout linear_inner;
    private GestureDetector mgesture;
    public String DEBUG_TAG="ss";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures_working);
        linear_inner=(LinearLayout)findViewById(R.id.linear_inner);

        sipe_refresh=findViewById(R.id.sipe_refresh);
        //mgesture=new GestureDetector(this,this);
        //inear_inner.setOnTouchListener(this);

        sipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh()
            {

                sipe_refresh.setColorSchemeColors(Color.GRAY);
                //Toast.makeText(GesturesWorking.this, "from swipe refersh", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run()
                    {

                        sipe_refresh.setRefreshing(false);
                        sipe_refresh.setColorSchemeColors(Color.RED);
                        boolean connection=isNetworkAvailable();
                        if(connection)
                        {
                            Toast.makeText(GesturesWorking.this, "found", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(GesturesWorking.this, "not found", Toast.LENGTH_SHORT).show();
                        }

                    }
                },5000);

            }
        });

    }


    public boolean isNetworkAvailable(){

        ConnectivityManager connectivityManager=(ConnectivityManager) this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        return networkInfo !=null;
    }

//    @Override
//    public boolean onTouch(View v, MotionEvent event)
//    {
//
//        int action = event.getAction();
//
//        switch(action) {
//            case (MotionEvent.ACTION_DOWN):
//                Log.d(DEBUG_TAG, "Action was DOWN");
//                return true;
//            case (MotionEvent.ACTION_MOVE):
//                Log.d(DEBUG_TAG, "Action was MOVE");
//                return true;
//            case (MotionEvent.ACTION_UP):
//                Log.d(DEBUG_TAG, "Action was UP");
//                return true;
//            case (MotionEvent.ACTION_CANCEL):
//                Log.d(DEBUG_TAG, "Action was CANCEL");
//                return true;
//            case (MotionEvent.ACTION_OUTSIDE):
//                Log.d(DEBUG_TAG, "Movement occurred outside bounds " +
//                        "of current screen element");
//                return true;
//            default:
//                return super.onTouchEvent(event);
//        }
////        if (v.getId()==R.id.linear_inner)
////        {
////            mgesture.onTouchEvent(event);
////            return true;
////        }
////
////        return true;
//    }
//
//
//
//    //methods from guestre interface
//
//    @Override
//    public boolean onDown(MotionEvent e) {
//        return false;
//    }
//
//    @Override
//    public void onShowPress(MotionEvent e) {
//
//    }
//
//    @Override
//    public boolean onSingleTapUp(MotionEvent e) {
//        return false;
//    }
//
//    @Override
//    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        return false;
//    }
//
//    @Override
//    public void onLongPress(MotionEvent e) {
//
//    }
//
//    @Override
//    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        return false;
//    }
}
