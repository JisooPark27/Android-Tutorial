package com.example.week11_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터(박지수)");
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        MyGalleryAdapter galApdater = new MyGalleryAdapter(this);
        gallery.setAdapter(galApdater);
    }

    public class MyGalleryAdapter extends BaseAdapter {
        Context context;
        Integer[] posterId =
                {R.drawable.mov11, R.drawable.mov12, R.drawable.mov13, R.drawable.mov14,
                        R.drawable.mov15, R.drawable.mov16, R.drawable.mov17,
                        R.drawable.mov18, R.drawable.mov19, R.drawable.mov20};
        String[] posterTitle =
                {"여인의 향기", "쥬라기 공원", "포레스트 검프", "사랑의 블랙홀", "혹성탈출", "아름다운비행",
                        "내이름은 칸", "해리포터", "마더", "킹콩을 들다"};

        public MyGalleryAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(posterId[position]);

            final int pos = position;
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterId[pos]);

                    Toast toast = new Toast(getApplicationContext());
                    View toastView = (View) View.inflate(getApplicationContext(),
                            R.layout.toast, null);
                    TextView toastText = (TextView) toastView.findViewById(R.id.textView1);
                    toastText.setText(posterTitle[pos]);
                    toast.setView(toastView);
                    toast.show();
                    return false;
                }
            });

            return imageView;
        }
    }


}