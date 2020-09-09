package ng.riby.androidtest.core.interpolators;

import com.google.android.gms.maps.model.LatLng;

public interface LatLngInterpolator {

    LatLng interpolate(float fraction, LatLng origin, LatLng destination);
}
