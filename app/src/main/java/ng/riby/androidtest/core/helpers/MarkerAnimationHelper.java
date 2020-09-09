package ng.riby.androidtest.core.helpers;

import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import ng.riby.androidtest.core.interpolators.LatLngInterpolator;

public class MarkerAnimationHelper {

    public static void animateMarker(final Marker marker, final LatLng finalPosition,
                                     final LatLngInterpolator latLngInterpolator) {
        final LatLng startPos = marker.getPosition();
        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        final Interpolator interpolator = new AccelerateDecelerateInterpolator();
        final float durationInMs = 2000;

        handler.post(new Runnable() {
            long elapsed;
            float time;
            float velocity;

            @Override
            public void run() {
                elapsed = SystemClock.uptimeMillis() - start;
                time = elapsed / durationInMs;
                velocity = interpolator.getInterpolation(time);
                marker.setPosition(latLngInterpolator.interpolate(velocity, startPos, finalPosition));

                if (time < 1) {
                    handler.postDelayed(this, 16);
                }
            }
        });
    }
}
