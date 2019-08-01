package com.example.practice;

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
            PointF DownPT = new PointF(); // Record Mouse Position When Pressed Down
            PointF StartPT = new PointF(); // Record Start Position of 'img'

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_MOVE :
                        /*image.setX((int)(StartPT.x + event.getX() - DownPT.x));
                        image.setY((int)(StartPT.y + event.getY() - DownPT.y));
                        StartPT.set( image.getX(), image.getY() );*/
                        break;
                    case MotionEvent.ACTION_DOWN :
                        image.setX(event.getX());
                        image.setY(event.getY());
                        /*DownPT.set( event.getX(), event.getY() );
                        StartPT.set( image.getX(), image.getY() );*/
                        break;
                    case MotionEvent.ACTION_UP :
                        // Nothing have to do
                        break;
                    default :
                        break;
                }
                return true;
            }
        });
    }
}
