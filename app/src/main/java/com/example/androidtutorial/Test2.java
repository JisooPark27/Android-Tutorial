package com.example.androidtutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Test2 extends AppCompatActivity {


    //todo ::  버전 문제인지 import가 안된다
//    private Acti<Intent> resultLauncher;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2);
        setTitle("메인 액티비티");
        final EditText edtNum1 = (EditText) findViewById(R.id.editNum1);
        final EditText edtNum2 = (EditText) findViewById(R.id.editNum2);

        final RadioGroup rdoGroup = (RadioGroup) findViewById(R.id.rdoGroup);
        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);

//        resultLauncher = registerForActivirt

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                switch (rdoGroup.getCheckedRadioButtonId()) {
                    case R.id.rdoAdd:
                        intent.putExtra("Calc", "+");
                        break;
                    case R.id.rdoSub:
                        intent.putExtra("Calc", "-");
                        break;
                    case R.id.rdoMul:
                        intent.putExtra("Calc", "*");
                        break;
                    case R.id.rdoDiv:
                        intent.putExtra("Calc", "/");
                        break;
                    default:
                        break;
                }
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));

            }
        });
    }
}
