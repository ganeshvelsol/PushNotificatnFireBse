package gif.ganesh.pushnotififirebase.gesturesWorking;

import android.content.Context;
import android.os.MessageQueue;
import android.view.GestureDetector;
import android.view.MotionEvent;

import gif.ganesh.pushnotififirebase.MainActivity;

public class GuestActivitys extends GestureDetector.SimpleOnGestureListener
{

    public static int min_x=100;
    public static int min_y=100;
    public static int max_x=100;
    public static int max_y=100;

    public MainActivity activity;

    public MainActivity getActivity() {
        return activity;
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
    {
        //return super.onFling(e1, e2, velocityX, velocityY);

        float deltax=e1.getX()-e2.getX();
        float deltay=e1.getY()-e2.getY();


        float matabsx=Math.abs(deltax);
        float matabsy=Math.abs(deltay);

       // if (matabsx>=)

        return true;
    }
}
