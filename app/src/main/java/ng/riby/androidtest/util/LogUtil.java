package ng.riby.androidtest.util;

import android.util.Log;

public class LogUtil {
    private static final String TAG = LogUtil.class.getSimpleName();

    public static void w(String msg) {
        Log.e(TAG, msg);
    }

    public static void w(String tag, String msg) {
        Log.e(tag, msg);
    }
}
