package com.example.martigen.lab10;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class zad1 extends AppCompatActivity {

    ViewGroup mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zad1);


        mainLayout=  (RelativeLayout)findViewById(R.id.myLavout);

        final ImageView   wheelView = new ImageView(this);
        wheelView.setImageResource(R.drawable.redcircle);
        wheelView.setVisibility(View.INVISIBLE);
        mainLayout.addView(wheelView);

        final ImageView   wheelView2 = new ImageView(this);
        wheelView2.setImageResource(R.drawable.redcircle);
        wheelView2.setVisibility(View.INVISIBLE);
        mainLayout.addView(wheelView2);

        mainLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_MOVE: {
                            
                            for (int idx = 0; idx < event.getPointerCount(); idx++) {
                                int ID = event.getPointerId(idx);//pobranie unikalnego id dlakażdego dotyku
                                System.out.println(ID);
                                if(ID==0) {
                                    wheelView.setX(event.getX(idx) - 25);
                                    wheelView.setY(event.getY(idx) - 25);
                                }

                               if(ID==1) {
                                    wheelView2.setVisibility(View.VISIBLE);
                                    wheelView2.setX(event.getX(idx) - 25);
                                    wheelView2.setY(event.getY(idx) - 25);
                                }
                            }
                            if(event.getPointerCount()==1){
                                wheelView2.setVisibility(View.INVISIBLE);
                            }


                        break;
                    }

                        case MotionEvent.ACTION_DOWN: {

                            wheelView.setVisibility(View.VISIBLE);

                            break;
                        }
                        case MotionEvent.ACTION_UP: {
                            wheelView.setVisibility(View.INVISIBLE);
                            wheelView2.setVisibility(View.INVISIBLE);
                            break;
                        }

                    }
                    return true;
                }

        });

    }
}
