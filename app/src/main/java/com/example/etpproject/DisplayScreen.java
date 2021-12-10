package com.example.etpproject;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class DisplayScreen extends AppCompatActivity {
    private EditText fb,insta,twitter,github;
    private ImageView imageView;
    Button popupbtn;
    Dialog mdialog;
    ImageView iv;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info);
        getSupportActionBar().hide();
        fb = findViewById(R.id.fb);
        insta = findViewById(R.id.insta);
        twitter = findViewById(R.id.twitter);
        github = findViewById(R.id.github);

        //iv=findViewById(R.id.iv1);
        mdialog=new Dialog(this);
    }

    public void QRCodeButton(View view){
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode("Facebook: "+fb.getText().toString()+"\nInstagram: "+insta.getText().toString()+"\nTwitter: "+
                            twitter.getText().toString()+"\nGithub: "+github.getText().toString(), BarcodeFormat.QR_CODE, 200, 200);
            Bitmap bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565);
            for (int x = 0; x<200; x++){
                for (int y=0; y<200; y++){
                    bitmap.setPixel(x,y,bitMatrix.get(x,y)? Color.BLACK : Color.WHITE);
                }
            }
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.activity_popupactivity);
            dialog.setTitle("Title...");
            ImageView image = (ImageView) dialog.findViewById(R.id.bmiv2);
            image.setImageBitmap(bitmap);
            dialog.show();


//
//            imageView.setImageBitmap(bitmap);
          //  Bitmap bitmap2= BitmapFactory.decodeResource(getResources(),bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}