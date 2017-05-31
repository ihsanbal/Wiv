package com.ihsanbal.wiv;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * @author ihsan on 31/05/2017.
 */
public class AspectRatioLayout extends FrameLayout {

    private static final float DEFAULT_ASPECT_RATIO = 1.0f;
    private static final int DEFAULT_ADJUST_DIMENSION = 0;

    static final int ADJUST_DIMENSION_HEIGHT = 0;

    protected double aspectRatio;
    private int dimensionToAdjust;

    public AspectRatioLayout(Context context) {
        this(context, null);
    }

    public AspectRatioLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AspectRatioLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initAttributes(attrs, defStyle);
    }

    private void initAttributes(AttributeSet attrs, int styleResId) {
        final TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs,
                R.styleable.AspectRatioLayout, styleResId, 0);
        try {
            aspectRatio = a.getFloat(
                    R.styleable.AspectRatioLayout_aspect_ratio,
                    DEFAULT_ASPECT_RATIO);
            dimensionToAdjust = a.getInt(
                    R.styleable.AspectRatioLayout_dimension_to_adjust,
                    DEFAULT_ADJUST_DIMENSION);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width, height;
        final int horizontalPadding = getPaddingLeft() + getPaddingRight();
        final int verticalPadding = getPaddingBottom() + getPaddingTop();

        if (dimensionToAdjust == ADJUST_DIMENSION_HEIGHT) {
            if (View.MeasureSpec.getMode(widthMeasureSpec) == View.MeasureSpec.EXACTLY) {
                width = View.MeasureSpec.getSize(widthMeasureSpec) - horizontalPadding;
            } else {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                width = getMeasuredWidth() - horizontalPadding;
            }
            height = (int) (width / aspectRatio);
        } else {
            if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.EXACTLY) {
                height = MeasureSpec.getSize(heightMeasureSpec) - verticalPadding;
            } else {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                height = getMeasuredHeight() - verticalPadding;
            }
            width = (int) (height * aspectRatio);
        }

        super.onMeasure(
                View.MeasureSpec.makeMeasureSpec(width + horizontalPadding, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(height + verticalPadding, View.MeasureSpec.EXACTLY));
    }
}
