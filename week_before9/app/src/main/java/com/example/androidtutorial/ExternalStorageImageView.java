package com.example.androidtutorial;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileFilter;

public class ExternalStorageImageView extends AppCompatActivity {

    Button btnPrev, btnNext;
    MyPictureView myPicture;
    TextView tvNumber;
    int curNum;
    File[] imageFiles;
    String imageFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.external_storage_image);
        setTitle("간단 이미지 뷰어");
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        tvNumber = (TextView) findViewById(R.id.textView);
        myPicture = (MyPictureView) findViewById(R.id.myPicture);

        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile();
            }
        });
        imageFileName = imageFiles[0].toString();
        myPicture.imagePath = imageFileName;
        tvNumber.setText("1/" + imageFiles.length);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (curNum <= 0) {
                    curNum = imageFiles.length - 1;
                } else {
                    curNum--;
                }
                imageFileName = imageFiles[curNum].toString();
                myPicture.imagePath = imageFileName;
                myPicture.invalidate();
                tvNumber.setText((curNum + 1) + "/" + imageFiles.length);

            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (curNum >= imageFiles.length - 1) {
                    curNum = 0;
                } else {
                    curNum++;
                }
                imageFileName = imageFiles[curNum].toString();
                myPicture.imagePath = imageFileName;
                myPicture.invalidate();
                tvNumber.setText((curNum + 1) + "/" + imageFiles.length);
            }
        });
    }


}
