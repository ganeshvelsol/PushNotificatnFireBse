package gif.ganesh.pushnotififirebase.androidMVVMExmples;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gif.ganesh.pushnotififirebase.R;


public class MVVMExamples extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvmexamples);
        //ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmexamples);
    }
}
