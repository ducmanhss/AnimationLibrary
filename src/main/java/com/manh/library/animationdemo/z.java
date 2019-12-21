package com.manh.library.animationdemo;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;


public class z {
    public static float a;
    private static float b;

    public static int a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int c(Context context) {
        char c = 65535;
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return c;
        }
    }

    public static int d(Context context) {
        char c = 65535;
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("navigation_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return c;
        }
    }

    public static Bitmap a(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap createBitmap = Bitmap.createBitmap(decorView.getDrawingCache(), 0, 0, a((Context) activity), b((Context) activity));
        decorView.destroyDrawingCache();
        return createBitmap;
    }

    public static Bitmap b(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap drawingCache = decorView.getDrawingCache();
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache, 0, i, a((Context) activity), b((Context) activity) - i);
        decorView.destroyDrawingCache();
        return createBitmap;
    }

    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static float a(float f) {
        return (Resources.getSystem().getDisplayMetrics().density * f) + 0.5f;
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean e(Context context) {
        boolean z;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier > 0) {
            z = resources.getBoolean(identifier);
        } else {
            z = false;
        }
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"qemu.hw.mainkeys"});
            if ("1".equals(str)) {
                return false;
            }
//            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
//                return true;
//            }
            return z;
        } catch (Exception e) {
            return z;
        }
    }

    public static int c(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }

    public static void a(Activity activity, final Application application) {
        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        if (b == 0.0f) {
            b = displayMetrics.density;
            a = displayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                public void onConfigurationChanged(Configuration configuration) {
                    if (configuration != null && configuration.fontScale > 0.0f) {
                        z.a = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                public void onLowMemory() {
                }
            });
        }
        float f = ((float) displayMetrics.widthPixels) / 360.0f;
        displayMetrics.density = f;
        int i = (int) (160.0f * f);
        displayMetrics.densityDpi = i;
        float f2 = (a / b) * f;
        displayMetrics.scaledDensity = f2;
        DisplayMetrics displayMetrics2 = activity.getResources().getDisplayMetrics();
        displayMetrics2.scaledDensity = f;
        displayMetrics2.density = f;
        displayMetrics2.densityDpi = i;
        displayMetrics2.scaledDensity = f2;
    }

    public static Bitmap a(Drawable drawable) {
        int i = 1;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight <= 0) {
            intrinsicHeight = 1;
        }
        if (intrinsicWidth > 0) {
            i = intrinsicWidth;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, intrinsicHeight, drawable.getOpacity() != PixelFormat.OPAQUE ? Config.ARGB_8888 : Config.RGB_565);
        drawable.setBounds(0, 0, i, intrinsicHeight);
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }
}
