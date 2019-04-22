package gif.ganesh.pushnotififirebase.sharedPreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gif.ganesh.pushnotififirebase.R;

public class SharedPreferencesExmps extends AppCompatActivity
{
    Button button_save;
    EditText one_label,second_label;
    SharedPreferences sp;
    SharedPreferences.Editor spe;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_exmps);

        sp=getSharedPreferences("mm", Context.MODE_PRIVATE);
        spe=sp.edit();

        if (sp.contains("ones"))
        {
            Toast.makeText(this, sp.getString("ones",null), Toast.LENGTH_SHORT).show();
        }
        one_label=findViewById(R.id.one_label);
        second_label=findViewById(R.id.second_label);
        button_save=findViewById(R.id.button_save);
        button_save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveDataToSp();
            }
        });
    }
    public void saveDataToSp()
    {
        String one=one_label.getText().toString().trim();
        String second=second_label.getText().toString().trim();

        spe.putString("ones",one);
        spe.commit();
    }

}
