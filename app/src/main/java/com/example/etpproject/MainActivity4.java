package com.example.etpproject;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class MainActivity4 extends AppCompatActivity {
    private EditText fb, insta, twitter, github;
    private ImageView imageView;
    Button popupbtn;
    Dialog mdialog;
    ImageView iv;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().hide();
        fb = findViewById(R.id.fb);
        insta = findViewById(R.id.insta);
        twitter = findViewById(R.id.twitter);
        github = findViewById(R.id.github);

        //iv=findViewById(R.id.iv1);
        mdialog = new Dialog(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Fetching the stored data
        // from the SharedPreference
        SharedPreferences sh = getSharedPreferences("Sharedprefer", MODE_PRIVATE);

        String s1 = sh.getString("fb", "");
        String s2 = sh.getString("insta", "");
        String s3 = sh.getString("twitter", "");
        String s4 = sh.getString("github", "");


        // Setting the fetched data
        // in the EditTexts
        fb.setText(s1);
        insta.setText(s2);
        twitter.setText(s3);
        github.setText(s4);


    }

    // Store the data in the SharedPreference
    // in the onPause() method
    // When the user closes the application
    // onPause() will be called
    // and data will be stored
    @Override
    protected void onPause() {
        super.onPause();

        // Creating a shared pref object
        // with a file name "MySharedPref"
        // in private mode
        SharedPreferences sharedPreferences = getSharedPreferences("Sharedprefer", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("fb", fb.getText().toString());
        myEdit.putString("insta", insta.getText().toString());
        myEdit.putString("twitter", twitter.getText().toString());
        myEdit.putString("github", github.getText().toString());

        myEdit.apply();
    }

    public void QRCodeButton(View view) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode("Facebook: " + fb.getText().toString() + "\n\nInstagram: " + insta.getText().toString() + "\n\nTwitter: " +
                    twitter.getText().toString() + "\n\nGithub: " + github.getText().toString(), BarcodeFormat.QR_CODE, 200, 200);
            Bitmap bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565);
            for (int x = 0; x < 200; x++) {
                for (int y = 0; y < 200; y++) {
                    bitmap.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
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
    public void scanqr1(View view){
        Intent in = new Intent(MainActivity4.this, scanqr.class);
        startActivity(in);
    }

}