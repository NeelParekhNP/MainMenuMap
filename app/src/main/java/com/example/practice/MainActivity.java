package com.example.practice;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView image = (ImageView) findViewById(R.id.imageView);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        constraintLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                float tx = event.getX();
                float ty = event.getY();

                int action = event.getAction();
                switch (action)
                {
                    case MotionEvent.ACTION_DOWN :
                        tx = event.getX();
                        ty = event.getY();

                        ObjectAnimator animX = ObjectAnimator.ofFloat(image, "x", tx-135);
                        ObjectAnimator animY = ObjectAnimator.ofFloat(image, "y", ty-135);
                        AnimatorSet animSetXY = new AnimatorSet();
                        animSetXY.playTogether(animX, animY);
                        animSetXY.start();

                    default :
                        break;
                }
                return true;
            }
        });
    }
}
