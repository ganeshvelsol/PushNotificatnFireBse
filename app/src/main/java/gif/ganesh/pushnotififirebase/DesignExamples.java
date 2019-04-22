package gif.ganesh.pushnotififirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class DesignExamples extends AppCompatActivity
{

    EditText one_input,two_input,three_input,four_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_examples);
//  code for reading the id of a device
       /*/ FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this, new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult)
            {
                Log.e("tokenId",""+instanceIdResult);
                Toast.makeText(DesignExamples.this, ""+instanceIdResult, Toast.LENGTH_SHORT).show();
            }
        });*/
        initParams();
    }
    public void initParams()
    {
        one_input=findViewById(R.id.one_input);
        two_input=findViewById(R.id.two_input);
        three_input=findViewById(R.id.three_input);
        four_input=findViewById(R.id.four_input);


        one_input.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                two_input.requestFocus();
            }
        });


        two_input.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s)
            {
                three_input.requestFocus();
            }
        });
    }
}
