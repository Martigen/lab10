package com.example.martigen.lab10;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.*;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Wheel extends SurfaceView implements SurfaceHolder.Callback {



    DisplayMetrics mDisplayMetrics;
    Thread thread;
    float dx, dy;
    Bitmap mBitmap;
    int imgSize;
    Paint paint;
    int rotation = 0;
    private boolean click = false;

    public Wheel(Context context) {
        super(context);
        getHolder().addCallback(this);

        paint = new Paint();
        paint.setAntiAlias(true);

        mDisplayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(mDisplayMetrics);

        dx = mDisplayMetrics.widthPixels;
        dy = mDisplayMetrics.heightPixels;
        imgSize = Math.round(dx-30);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.kolo);
        mBitmap = Bitmap.createScaledBitmap(
                bitmap,
                imgSize,
                imgSize,
                false
        );



        /*((RelativeLayout)findViewById(R.id.zad3a)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("aa");

            }
        });
*/
    }



    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    tryDrawing(getHolder());
                    try {

                    } catch (Exception e) {
                    }
                }
            }
        };
        thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        tryDrawing(holder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        thread.interrupt();
    }

    @Override
    public boolean performClick() {
        if(click==false){

                thread.stop();

        }
        else
            thread.start();

         return true;
    }

    public void tryDrawing(SurfaceHolder holder) {
        Canvas canvas = holder.lockCanvas();
        if (canvas == null) {
        } else {
            drawMyStuff(canvas);
            holder.unlockCanvasAndPost(canvas);
        }
    }

    private void drawMyStuff(final Canvas canvas) {
        canvas.drawRGB(32, 32, 32);

        rotation = (rotation + 4 ) % 360;
        canvas.rotate(rotation, imgSize/2, imgSize/2);
        canvas.drawBitmap(mBitmap, 0, 0, paint);


    }


}

