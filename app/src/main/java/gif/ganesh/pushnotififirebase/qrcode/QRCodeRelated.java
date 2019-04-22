package gif.ganesh.pushnotififirebase.qrcode;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import gif.ganesh.pushnotififirebase.MainActivity;
import gif.ganesh.pushnotififirebase.R;

import static android.Manifest.permission.CAMERA;

public class QRCodeRelated extends AppCompatActivity //implements ZXingScannerView.ResultHandler
{

    private static final int camera_req = 1;
    //private ZXingScannerView scannerView;
    Button hello_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_related);

        hello_button = findViewById(R.id.hello_button);
        hello_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performData();
            }
        });
    }

    public void performData()
    {
        IntentIntegrator integrator=new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan");
        integrator.setCameraId(0);
        integrator.setOrientationLocked(false);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        IntentResult result= IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (result!=null)
        {
            if (result.getContents() == null)
            {
                Toast.makeText(this, "you cancelled scan", Toast.LENGTH_LONG).show();
            }else
            {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}

