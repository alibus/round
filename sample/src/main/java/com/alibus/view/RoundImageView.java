package com.alibus.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.ImageView;

/**
 * 项目名称：round
 * 类描述：
 * 创建人：alibus
 * 创建时间：16-3-24 下午4:14
 * 修改人：alibus
 * 修改时间：16-3-24 下午4:14
 * 修改备注：
 */
public class RoundImageView extends ImageView {
    private static final int KEY_SHADOW_COLOR = 503316480;
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final float X_OFFSET = 0.0F;
    private static final float Y_OFFSET = 1.75F;
    private static final float SHADOW_RADIUS = 3.5F;
    private static final int SHADOW_ELEVATION = 4;
    private Animation.AnimationListener mListener;
    private int mShadowRadius;


    public RoundImageView(Context context) {
        super(context);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RoundImageView(Context context, int color, float radius) {
        super(context);
        float density = this.getContext().getResources().getDisplayMetrics().density;
        int diameter = (int) (radius * density * 2.0F);
        int shadowYOffset = (int) (density * 1.75F);
        int shadowXOffset = (int) (density * 0.0F);
        this.mShadowRadius = (int) (density * 3.5F);
        ShapeDrawable circle;
        if (this.elevationSupported()) {
            circle = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, 4.0F * density);
        } else {
            RoundImageView.OvalShadow oval = new RoundImageView.OvalShadow(this.mShadowRadius, diameter);
            circle = new ShapeDrawable(oval);
            ViewCompat.setLayerType(this, 1, circle.getPaint());
            circle.getPaint().setShadowLayer((float) this.mShadowRadius, (float) shadowXOffset, (float) shadowYOffset, 503316480);
            int padding = this.mShadowRadius;
            this.setPadding(padding, padding, padding, padding);
        }

        circle.getPaint().setColor(color);
        this.setBackgroundDrawable(circle);
    }

    private boolean elevationSupported() {
        return Build.VERSION.SDK_INT >= 16;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!this.elevationSupported()) {
            this.setMeasuredDimension(this.getMeasuredWidth() + this.mShadowRadius * 2, this.getMeasuredHeight() + this.mShadowRadius * 2);
        }

    }

    public void setAnimationListener(Animation.AnimationListener listener) {
        this.mListener = listener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.mListener != null) {
            this.mListener.onAnimationStart(this.getAnimation());
        }

    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.mListener != null) {
            this.mListener.onAnimationEnd(this.getAnimation());
        }

    }

    public void setBackgroundColorRes(int colorRes) {
        this.setBackgroundColor(this.getContext().getResources().getColor(colorRes));
    }

    public void setBackgroundColor(int color) {
        if (this.getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) this.getBackground()).getPaint().setColor(color);
        }

    }

    private class OvalShadow extends OvalShape {
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint = new Paint();
        private int mCircleDiameter;

        public OvalShadow(int shadowRadius, int circleDiameter) {
            RoundImageView.this.mShadowRadius = shadowRadius;
            this.mCircleDiameter = circleDiameter;
            this.mRadialGradient = new RadialGradient((float) (this.mCircleDiameter / 2), (float) (this.mCircleDiameter / 2), (float) RoundImageView.this.mShadowRadius, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.mShadowPaint.setShader(this.mRadialGradient);
        }

        public void draw(Canvas canvas, Paint paint) {
            int viewWidth = RoundImageView.this.getWidth();
            int viewHeight = RoundImageView.this.getHeight();
            canvas.drawCircle((float) (viewWidth / 2), (float) (viewHeight / 2), (float) (this.mCircleDiameter / 2 + RoundImageView.this.mShadowRadius), this.mShadowPaint);
            canvas.drawCircle((float) (viewWidth / 2), (float) (viewHeight / 2), (float) (this.mCircleDiameter / 2), paint);
        }
    }
}
