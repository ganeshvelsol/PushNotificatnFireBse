package gif.ganesh.pushnotififirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneAuthentication extends AppCompatActivity
{
    Button button_submit;
    EditText phone_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_authentication);
        phone_edit=findViewById(R.id.phone_edit);
        button_submit=findViewById(R.id.button_submit);

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sendRelatedData();
            }
        });
    }
    public void sendRelatedData()
    {
        String number=phone_edit.getText().toString().trim();

        PhoneAuthProvider.getInstance().verifyPhoneNumber(number,60, TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,mCallBack);
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack= new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken)
        {
            super.onCodeSent(s, forceResendingToken);
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential)
        {

            phoneAuthCredential.getSmsCode(); //this is the main code to receive the message code
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }
    };
}
