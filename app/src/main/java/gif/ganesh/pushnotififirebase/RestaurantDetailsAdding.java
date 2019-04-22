package gif.ganesh.pushnotififirebase;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.shimmer.ShimmerFrameLayout;

public class RestaurantDetailsAdding extends AppCompatActivity {

    ShimmerFrameLayout shimmers;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details_adding);

        shimmers=findViewById(R.id.shimmers);
        shimmers.startShimmer();

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {

                shimmers.stopShimmer();
            }
        },5000);
    }
}
