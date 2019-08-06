package com.example.practice;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.PointF;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView farmImage, potatoImage;
    private ImageButton farmButton;
    private ConstraintLayout constraintLayout;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private static final long COUNTDOWN_IN_MILLIS = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final ImageView potatoImage = (ImageView) findViewById(R.id.imageView);
        potatoImage = (ImageView) findViewById(R.id.imageView);
        farmButton = (ImageButton) findViewById(R.id.button_farm);
        //farmImage = (ImageView) findViewById(R.id.imageView_farm);
        farmButton.setOnClickListener(clickListener);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

/*        constraintLayout.setOnTouchListener(new View.OnTouchListener() {

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

                        ObjectAnimator animX = ObjectAnimator.ofFloat(potatoImage, "x", tx-135);
                        ObjectAnimator animY = ObjectAnimator.ofFloat(potatoImage, "y", ty-135);
                        AnimatorSet animSetXY = new AnimatorSet();
                        animSetXY.playTogether(animX, animY);
                        animSetXY.start();

                    default :
                        break;
                }
                return true;
            }
        });

        potatoImage.setOnDragListener(dragListener);
    }

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            int drag = dragEvent.getAction();

            switch (drag) {
                case DragEvent.ACTION_DROP:
                    Intent myIntent = new Intent(getBaseContext(), Game1.class);
                    startActivity(myIntent);
                    break;
            }
            return true;
        }
    };*/
    }
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            timeLeftInMillis =COUNTDOWN_IN_MILLIS;
            startCountDown();
            /*Intent myIntent = new Intent(getBaseContext(), Game1.class);
            startActivity(myIntent);*/

        }
    };

    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                float x = farmButton.getX();
                float y = farmButton.getY();

                ObjectAnimator animX = ObjectAnimator.ofFloat(potatoImage, "x", x-150);
                ObjectAnimator animY = ObjectAnimator.ofFloat(potatoImage, "y", y+100);
                AnimatorSet animSetXY = new AnimatorSet();
                animSetXY.playTogether(animX, animY);
                animSetXY.start();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                Intent myIntent = new Intent(getBaseContext(), Game1.class);
                startActivity(myIntent);
            }
        }.start();
    }

}
