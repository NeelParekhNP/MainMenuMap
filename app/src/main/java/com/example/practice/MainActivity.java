package com.example.practice;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private ConstraintLayout constraintLayout;
    //Handler to create delays for animation
    private Handler timeControl = new Handler();

    private float newX;
    private float newY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide status bar (that shows time, battery etc)
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


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

                        // Set the x and y values separately
                        newX = findNearestGridX(event.getX());
                        newY = findNearestGridY(event.getY());

                        // wait for a second before moving
                        timeControl.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                image.setX(newX);
                                image.setY(newY);
                            }
                        }, 1000);



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

    public float findNearestGridX(float touchX) {

        // Get screen height and width
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int dpHeight = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        //Create variables for the 10 possible positions
        float x0 = 0;
        float x1 = (width / 9);
        float x2 = (width / 9) * 2;
        float x3 = (width / 9) * 3;
        float x4 = (width / 9) * 4;
        float x5 = (width / 9) * 5;
        float x6 = (width / 9) * 6;
        float x7 = (width / 9) * 7;
        float x8 = (width / 9) * 8;

        // horizontal position 0
        if (touchX < x1) {
            return x0;
        }
        // horizontal position 1
        if (touchX >= x1 && touchX < x2) {
            return x1;
        }
        // horizontal position 2
        if (touchX >= x2 && touchX < x3) {
            return x2;
        }
        // horizontal position 3
        if (touchX >= x3 && touchX < x4) {
            return x3;
        }
        // horizontal position 4
        if (touchX >= x4 && touchX < x5) {
            return x4;
        }
        // horizontal position 5
        if (touchX >= x5 && touchX < x6) {
            return x5;
        }
        // horizontal position 6
        if (touchX >= x6 && touchX < x7) {
            return x6;
        }
        // horizontal position 7
        if (touchX >= x7 && touchX < x8) {
            return x7;
        }
        // horizontal position 8
        else {
            return x8;
        }
    }

        public float findNearestGridY(float touchY){

            // Get screen height and width
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int height = displayMetrics.heightPixels;
            int width = displayMetrics.widthPixels;

            //Create variables for the 10 possible positions
            float y0 = 0;
            float y1 = (height / 16);
            float y2 = (height / 16) * 2;
            float y3 = (height / 16) * 3;
            float y4 = (height / 16) * 4;
            float y5 = (height / 16) * 5;
            float y6 = (height / 16) * 6;
            float y7 = (height / 16) * 7;
            float y8 = (height / 16) * 8;
            float y9 = (height / 16) * 9;
            float y10 = (height / 16) * 10;
            float y11 = (height / 16) * 11;
            float y12 = (height / 16) * 12;
            float y13 = (height / 16) * 13;
            float y14 = (height / 16) * 14;
            float y15 = (height / 16) * 15;


            // vertical position 0
            if (touchY < y1) {
                return y0;
            }
            // vertical position 1
            if (touchY >= y1 && touchY < y2) {
                return y1;
            }
            // vertical position 2
            if (touchY >= y2 && touchY < y3) {
                return y2;
            }
            // vertical position 3
            if (touchY >= y3 && touchY < y4) {
                return y3;
            }
            // vertical position 4
            if (touchY >= y4 && touchY < y5) {
                return y4;
            }
            // vertical position 5
            if (touchY >= y5 && touchY < y6) {
                return y5;
            }
            // vertical position 6
            if (touchY >= y6 && touchY < y7) {
                return y6;
            }
            // vertical position 7
            if (touchY >= y7 && touchY < y8) {
                return y7;
            }
            // vertical position 8
            if (touchY >= y8 && touchY < y9) {
                return y8;
            }
            // vertical position 9
            if (touchY >= y9 && touchY < y10) {
                return y9;
            }
            // vertical position 10
            if (touchY >= y10 && touchY < y11) {
                return y10;
            }
            // vertical position 11
            if (touchY >= y11 && touchY < y12) {
                return y11;
            }
            // vertical position 12
            if (touchY >= y12 && touchY < y13) {
                return y12;
            }
            // vertical position 13
            if (touchY >= y13 && touchY < y14) {
                return y13;
            }
            // vertical position 14
            if (touchY >= y14 && touchY < y15) {
                return y14;
            }
            // vertical position 15
            else {
                return y15;
            }
        }





    /**
    public float findNearestGridX(float touchX){

        Context context = getApplicationContext();

        // Get screen height and width
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int dpHeight = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;



        float dpTouchX = convertPixeltoDP(touchX, width);

        // horizontal position 1
        if(dpTouchX <= 32){
            return convertDpToPixel(24, width);
        }
        // horizontal position 2
        if(dpTouchX > 32 && dpTouchX <= 48){
            return convertDpToPixel(40, width);
        }
        // horizontal position 3
        if(dpTouchX > 48 && dpTouchX <= 64){
            return convertDpToPixel(56, width);
        }
        // horizontal position 4
        if(dpTouchX > 64 && dpTouchX <= 80){
            return convertDpToPixel(72, width);
        }
        // horizontal position 5
        if(dpTouchX > 80 && dpTouchX <= 96){
            return convertDpToPixel(88, width);
        }
        // horizontal position 6
        if(dpTouchX > 96 && dpTouchX <= 112){
            return convertDpToPixel(104, width);
        }
        // horizontal position 7
        if(dpTouchX > 112 && dpTouchX <= 128){
            return convertDpToPixel(120, width);
        }
        // horizontal position 8
        if(dpTouchX > 128 && dpTouchX <= 144){
            return convertDpToPixel(136, width);
        }
        // horizontal position 9
        else{
            return convertDpToPixel(152, width);
        }

    }
    */

    /**
    public float convertDpToPixel(float dp, int screenPixelDimension){
        return (dp/160) * screenPixelDimension;
    }
     */

    /**
    public static float convertDpToPixel(float dp, Context context){
        return  dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
     */

    /**
    public float convertPixeltoDP(float px, int screenPixelDimension){
        return (px/screenPixelDimension) * 160;
    }
     */

    /**
    public static float convertPixeltoDP(float px, Context context){
        return  px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
     */

}
