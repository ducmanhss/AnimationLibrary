package com.manh.library.animationdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;




public class MainRippleView extends View {
    a a;
    a b;
    private Context c;
    private Paint d;
    private Paint e;
    private Paint f;
    private Paint g;
    private float h;
    private float i;
    private int j;
    private float k;
    private float l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;

    class a {
        float a;
        int b;

        a(int i, int i2) {
            this.a = (float) i;
            this.b = i2;
        }

        public String toString() {
            return "Circle{width=" + this.a + ", alpha=" + this.b + '}';
        }
    }

    public MainRippleView(Context context) {
        this(context, null);
    }

    public MainRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainRippleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new a((int) z.a(115.0f), 255);
        this.b = new a((int) z.a(115.0f), 255);
        this.n = context.getResources().getColor(R.color.colorWhite);
        this.k = z.a(0.65f);
        this.l = z.a(0.28f);
        this.m = 10;
        this.o = true;
        this.p = true;
        a();
    }

    private void a() {
        this.c = getContext();
        this.d = new Paint(1);
        this.d.setColor(this.n);
        this.d.setAntiAlias(true);
        this.d.setStrokeWidth((float) z.a(this.c, 1.0f));
        this.d.setStyle(Style.FILL);
        this.e = new Paint(1);
        this.e.setColor(this.c.getResources().getColor(R.color.colorWhite));
        this.e.setAntiAlias(true);
        this.e.setStrokeWidth((float) z.a(this.c, 1.0f));
        this.e.setStyle(Style.STROKE);
        this.f = new Paint(1);
        this.f.setColor(this.n);
        this.f.setAntiAlias(true);
        this.f.setStrokeWidth((float) z.a(this.c, 1.0f));
        this.f.setStyle(Style.FILL);
        this.g = new Paint(1);
        this.g.setColor(this.n);
        this.g.setAntiAlias(true);
        this.g.setStrokeWidth((float) z.a(this.c, 1.0f));
        this.g.setStyle(Style.STROKE);
        this.m = z.a(this.c, (float) this.m);
        setBackgroundColor(0);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    private void a(Canvas canvas) {
        canvas.save();
        this.d.setAlpha(this.a.b);
        this.e.setAlpha(this.a.b * 2);
        this.g.setAlpha(this.a.b * 2);
        canvas.drawCircle(this.h / 2.0f, this.i / 2.0f, this.a.a, this.d);
        canvas.drawCircle(this.h / 2.0f, this.i / 2.0f, this.a.a, this.e);
        this.f.setAlpha(this.b.b);
        canvas.drawCircle(this.h / 2.0f, this.i / 2.0f, this.b.a, this.g);
        canvas.drawCircle(this.h / 2.0f, this.i / 2.0f, this.b.a, this.f);
        if (this.a.a > this.h / 2.0f) {
            this.a.a = (float) ((int) z.a(115.0f));
            this.b.a = (float) ((int) z.a(115.0f));
        } else {
            if (this.p) {
                double d2 = (255.0d - (((double) this.a.a) * (255.0d / (((double) this.h) / 2.0d)))) * 0.25d;
                this.a.b = (int) d2;
                this.b.b = (int) d2;
            }
            this.a.a += this.k;
            this.b.a += this.l;
        }
        invalidate();
        canvas.restore();
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i3);
        int size2 = MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            this.h = (float) size;
        } else {
            this.h = (float) z.a(this.c, 120.0f);
        }
        if (mode2 == 1073741824) {
            this.i = (float) size2;
        } else {
            this.i = (float) z.a(this.c, 120.0f);
        }
        float max = Math.max(this.h, this.i);
        this.i = max;
        this.h = max;
        setMeasuredDimension((int) this.h, (int) this.i);
    }
}