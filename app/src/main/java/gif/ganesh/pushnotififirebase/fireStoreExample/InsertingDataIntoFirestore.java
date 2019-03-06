package gif.ganesh.pushnotififirebase.fireStoreExample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import gif.ganesh.pushnotififirebase.R;

public class InsertingDataIntoFirestore extends AppCompatActivity
{
    EditText person_name,person_phone,person_email;
    Button save_btn,read_data;
    RecyclerView recycler_view;
    List<FireStoreModels> lists;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserting_data_into_firestore);
        initParams();
    }
    public void initParams()
    {

        person_name=findViewById(R.id.person_name);
        person_phone=findViewById(R.id.person_phone);
        person_email=findViewById(R.id.person_email);
        recycler_view=findViewById(R.id.recycler_view);
        save_btn=findViewById(R.id.save_btn);
        read_data=findViewById(R.id.read_data);

        read_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readData();
            }
        });
        lists=new ArrayList<>();
        save_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PerformDataLogic();
            }
        });

    }
    public boolean checkConditions(String pnames,String pnumbere,String pEmail)
    {
        if (pnames.isEmpty())
        {
            person_name.requestFocus();
            person_name.setError("enter person name");
            return true;
        }if (pnumbere.isEmpty())
    {
        person_phone.requestFocus();
        person_phone.setError("enter person phone");
        return true;
    }
    if (pEmail.isEmpty())
    {
        person_email.requestFocus();
        person_email.setError("enter email");
        return true;
    }
    return false;
    }

    public void PerformDataLogic()
    {
        String pName=person_name.getText().toString().trim();
        String pPhoine=person_phone.getText().toString().trim();
        String pEmail=person_email.getText().toString().trim();


        if (!checkConditions(pName,pPhoine,pEmail))
        {
            //here code to insert data into firestore
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            FireStoreModels fs=new FireStoreModels(pName,pPhoine,pEmail);


            //inserting data into firestore
            db.collection("usersDetails")
                    .add(fs)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>()
                    {
                        @Override
                        public void onSuccess(DocumentReference documentReference)
                        {
                            Toast.makeText(InsertingDataIntoFirestore.this, ""+documentReference.get().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener()
            {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(InsertingDataIntoFirestore.this, "fails"+e, Toast.LENGTH_SHORT).show();
                }
            });


            //code for reading the data from firestore


        }
    }
    public void readData()
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("usersDetails")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>()
                {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots)
                    {
                        if (queryDocumentSnapshots.isEmpty())
                        {
                        }else
                        {
                            List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d:list)
                            {
                                FireStoreModels fs=d.toObject(FireStoreModels.class);
                                lists.add(fs);
                            }
                            FireStoreAdapter fa=new FireStoreAdapter(InsertingDataIntoFirestore.this,lists);
                            recycler_view.setAdapter(fa);
                            recycler_view.setLayoutManager(new LinearLayoutManager(InsertingDataIntoFirestore.this));
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(InsertingDataIntoFirestore.this, "error"+e, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
