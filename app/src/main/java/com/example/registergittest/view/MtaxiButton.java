package com.example.registergittest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

import com.example.registergittest.R;


public class MtaxiButton extends Button {
    private boolean isPressAnimation;
    private float alpha = 1f;

    public MtaxiButton(Context context) {
        super(context);
        init();
    }

    public MtaxiButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        applyAttributes(attrs);
    }

    public MtaxiButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        applyAttributes(attrs);
    }

    protected void init() {
        this.isPressAnimation = true;
    }

    protected void applyAttributes(AttributeSet attrs) {
        this.isPressAnimation = attrs.getAttributeBooleanValue(R.styleable.MtaxiButton_press_animation, true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.isClickable() && this.isEnabled() && isPressAnimation) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    alpha = getAlpha();
                    setAlpha(0.3f);
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    setAlpha(alpha);
                    break;
            }
        }
        return super.onTouchEvent(event);
    }
}
