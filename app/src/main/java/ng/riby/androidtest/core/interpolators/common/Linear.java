package ng.riby.androidtest.core.interpolators.common;

import com.google.android.gms.maps.model.LatLng;
import ng.riby.androidtest.core.interpolators.LatLngInterpolator;

public class Linear implements LatLngInterpolator {
    @Override
    public LatLng interpolate(float fraction, LatLng origin, LatLng destination) {
        double lat = (destination.latitude - origin.latitude) * fraction + origin.latitude;
        double lng = (destination.longitude - origin.longitude) * fraction + origin.longitude;
        return new LatLng(lat, lng);
    }
}
