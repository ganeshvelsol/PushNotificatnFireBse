package gif.ganesh.pushnotififirebase.imageviewToGallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import gif.ganesh.pushnotififirebase.R;

public class ImageviewToGallryStore extends AppCompatActivity
{
    ImageView image_view;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview_to_gallry_store);
        image_view=findViewById(R.id.image_view);
    }

    public void saveImage(View v)
    {
        Bitmap bit= BitmapFactory.decodeResource(getResources(),R.drawable.profile);


        //code to create an image in the gallery
        MediaStore.Images.Media.insertImage(getContentResolver(), bit, "ss" , "");


        //code to crate a directory inthe external device and store an image into it
//        File path= Environment.getExternalStorageDirectory();
//
//        File dir=new File(path+"/saves/");
//
//        dir.mkdir();
//
//        File file=new File(dir,"sample.png");
//
//        try
//        {
//            OutputStream out=new FileOutputStream(file);
//            bit.compress(Bitmap.CompressFormat.PNG,100,out);
//            out.flush();
//            out.close();
//
//        } catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //upto here
    }
}
