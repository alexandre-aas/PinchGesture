package com.s.d.a.a.pinchgesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.widget.TextView;

public class PinchActivity extends AppCompatActivity {

    TextView txvPrincipal;
    ScaleGestureDetector escalaDetectorGestos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinch);

        txvPrincipal = findViewById(R.id.txvPrincipal);

        escalaDetectorGestos = new ScaleGestureDetector(this, new LocalOnScaleGestureListener());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        escalaDetectorGestos.onTouchEvent(event);
        return true;
    }

    public class LocalOnScaleGestureListener extends
            SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            float scaleFactor = detector.getScaleFactor();

            if (scaleFactor > 1) {
                txvPrincipal.setText("Aumentar Zoom");
            } else {
                txvPrincipal.setText("Diminiur Zoom");
            }
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {

        }
    }
}
