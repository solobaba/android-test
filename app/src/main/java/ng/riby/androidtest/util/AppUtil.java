package ng.riby.androidtest.util;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.MaterialDialog;

import ng.riby.androidtest.R;
import ng.riby.androidtest.core.listeners.DialogListener;

public class AppUtil {
    public static void showDialog(Context context, String title, String content,
                                  final DialogListener listener, String positiveText, boolean cancellable) {

        buildDialog(context, title, content)
                .getBuilder()
                .positiveText(positiveText)
                .positiveColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .onPositive((dialog, which) -> listener.onPositiveClick())
                .onNegative((dialog, which) -> listener.onNegativeClick())
                .cancelable(cancellable)
                .show();
    }

    private static MaterialDialog buildDialog(Context context, String title, String content) {
        return new MaterialDialog.Builder(context)
                .title(title)
                .content(content)
                .build();
    }

    public static double distanceBetweenTwoPoint(double originLat, double originLng, double destinationLat, double destinationLng) {
        double earthRadius = 3958.75;
        double dLat = Math.toRadians(destinationLat - originLat);
        double dLng = Math.toRadians(destinationLng - originLng);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(originLat))
                * Math.cos(Math.toRadians(destinationLat)) * Math.sin(dLng / 2)
                * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = earthRadius * c;

        double meterConversion = 1609;

        return (int) (dist * meterConversion);
    }
}
