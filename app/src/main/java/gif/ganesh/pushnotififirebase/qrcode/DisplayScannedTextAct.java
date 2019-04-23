package gif.ganesh.pushnotififirebase.qrcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import gif.ganesh.pushnotififirebase.R;

public class DisplayScannedTextAct extends AppCompatActivity {

    TextView ss_display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scanned_text);
        Bundle b=getIntent().getExtras();
        String ss=b.getString("text");

        ss_display=findViewById(R.id.ss_display);
        ss_display.setText(ss);

    }
}
