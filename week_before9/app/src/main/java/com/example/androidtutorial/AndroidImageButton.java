package com.example.androidtutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AndroidImageButton extends AppCompatActivity {

    TextView text1, text2;
    Switch switchagree;
    RadioGroup rGroup1;
    RadioButton radioArray[] = new RadioButton[3];
    ImageView img;
    Button btnQuit, btnRerun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_image_button);
        setTitle("안드로이드 사진 보기");
        text1 = (TextView) findViewById(R.id.Text1);
        text2 = (TextView) findViewById(R.id.Text2);
        switchagree = (Switch) findViewById(R.id.switch1);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        radioArray[0] = (RadioButton) findViewById(R.id.radio70);
        radioArray[1] = (RadioButton) findViewById(R.id.radio80);
        radioArray[2] = (RadioButton) findViewById(R.id.radio90);
        img = (ImageView) findViewById(R.id.imageView);
        btnQuit = (Button) findViewById(R.id.btnQuit);
        btnRerun = (Button) findViewById(R.id.btnRerun);

        switchagree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton coompoundButton, boolean b) {
                if(switchagree.isChecked() == true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                    btnQuit.setVisibility(View.VISIBLE);
                    btnRerun.setVisibility(View.VISIBLE);
                }
                else{
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                    btnQuit.setVisibility(View.INVISIBLE);
                    btnRerun.setVisibility(View.INVISIBLE);
                }
            }
        });

        final int draw[] = {R.drawable.api70, R.drawable.api80, R.drawable.api90};
        for(int i = 0 ; i < radioArray.length; i++){
            final int index = i;
            radioArray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    img.setImageResource(draw[index]);
                }
            });
        }
        btnQuit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

        btnRerun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                text2.setVisibility(View.INVISIBLE);
                rGroup1.setVisibility(View.INVISIBLE);
                img.setVisibility(View.INVISIBLE);
                btnQuit.setVisibility(View.INVISIBLE);
                btnRerun.setVisibility(View.INVISIBLE);

                rGroup1.clearCheck();
                switchagree.setChecked(false);
            }
        });
    }
}