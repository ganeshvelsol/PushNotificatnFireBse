package gif.ganesh.pushnotififirebase.firebaseWithFireStore;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.TimeUnit;

import javax.security.auth.callback.Callback;

import gif.ganesh.pushnotififirebase.R;
import gif.ganesh.pushnotififirebase.fireStoreExample.FireStoreModels;

public class FireBaseCumFireStore extends AppCompatActivity
{
    EditText person_name,person_phone,verify_code;
    Button save_btn;
    private FirebaseAuth mAuth;
    Button phone_authentication,confirm_btn;

    String codeSent,code;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base_cum_fire_store);
        initParams();
    }
    public void initParams()
    {
        mAuth=FirebaseAuth.getInstance();
        person_name=findViewById(R.id.person_name);
        person_phone=findViewById(R.id.person_phone);
        save_btn=findViewById(R.id.save_btn);
        phone_authentication=findViewById(R.id.phone_authentication);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                performData();
            }
        });

        phone_authentication.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                phoneAuthentication();
            }
        });

    }
    public void performData()
    {
        String personEmail=person_name.getText().toString().trim();
        String personPhone=person_phone.getText().toString().trim();

        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        final FireStoreModels fs=new FireStoreModels(personEmail,personPhone,"null");



        mAuth.createUserWithEmailAndPassword(personEmail,personPhone)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {

                        if (task.isSuccessful())
                        {
                            //inserting the data into the firestotr when the user authenticates done succesfully
                            db.collection("ExampleWithFirestore")
                                    .add(fs)
                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>()
                                    {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference)
                                        {
                                            Toast.makeText(FireBaseCumFireStore.this, ""+documentReference.get().toString(), Toast.LENGTH_SHORT).show();
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(FireBaseCumFireStore.this, "failed to insert", Toast.LENGTH_SHORT).show();
                                }
                            });
                            //upto here for inserting data

                            Toast.makeText(FireBaseCumFireStore.this, "completed registration", Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(FireBaseCumFireStore.this, "failed"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });




    }


    public void phoneAuthentication()
    {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91 9505611896",        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);
    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential)
            {
                //Log.e("pauth",""+phoneAuthCredential.getSmsCode());

                //PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);
                signInWithPhoneAuthCredential(phoneAuthCredential);

            }

            @Override
            public void onVerificationFailed(FirebaseException e)
            {

            }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken)
        {
            super.onCodeSent(s, forceResendingToken);
            codeSent = s;

        }
    };

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential)
    {
        FirebaseAuth mauth=FirebaseAuth.getInstance();
        mauth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(FireBaseCumFireStore.this, "success", Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(FireBaseCumFireStore.this, "Invalid ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
