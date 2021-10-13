package com.example.androidtutorial;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ColorMenuSettingAndButtonToast extends AppCompatActivity {

    LinearLayout layout;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_menu_setting_and_button_toast);
        layout = (LinearLayout) findViewById(R.id.layout);
        textView = (TextView) findViewById(R.id.textView1);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] versionArray = new String[] {"파이리", "꼬부기", "이상해씨"};
                AlertDialog.Builder dlg =new AlertDialog.Builder(ColorMenuSettingAndButtonToast.this);
                dlg.setTitle("좋아하는 포켓몬은");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setSingleChoiceItems(versionArray, 5, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView.setText(versionArray[i]);
                    }
                });
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(ColorMenuSettingAndButtonToast.this);
                        View toastView = (View) View.inflate(ColorMenuSettingAndButtonToast.this, R.layout.toast1, null);
                        TextView toastText = (TextView) toastView.findViewById(R.id.toastText1);
                        toastText.setText(textView.getText().toString() + "를 선택하셨습니다.");
                        toast.setView(toastView);
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
                dlg.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemRed:layout.setBackgroundColor(Color.RED);
            return true;
            case R.id.itemGreen:layout.setBackgroundColor(Color.GREEN);
            return true;
            case R.id.itemBlue:layout.setBackgroundColor(Color.BLUE);
            return true;

        }
        return false;
    }
}