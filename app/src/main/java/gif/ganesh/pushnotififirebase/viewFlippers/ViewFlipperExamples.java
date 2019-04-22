package gif.ganesh.pushnotififirebase.viewFlippers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import gif.ganesh.pushnotififirebase.R;

public class ViewFlipperExamples extends AppCompatActivity
{
    ViewFlipper mviewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper_examples);

        mviewFlipper=findViewById(R.id.view_flipper);
        int img[]={R.drawable.one,R.drawable.two,R.drawable.three};

       for (int i=0;i<img.length;i++)
       {
           flipperImages(img[i]);
       }
    }

    public void flipperImages(int imgs)
    {
        final ImageView im=new ImageView(this);
        im.setImageResource(imgs);

        mviewFlipper.addView(im);
        mviewFlipper.setFlipInterval(4000);
        mviewFlipper.setAutoStart(true);
        mviewFlipper.setInAnimation(this,android.R.anim.fade_in);
        mviewFlipper.setOutAnimation(this,android.R.anim.fade_out);

    }
}
