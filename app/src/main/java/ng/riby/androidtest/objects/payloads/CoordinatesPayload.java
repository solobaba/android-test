package ng.riby.androidtest.objects.payloads;

import androidx.annotation.NonNull;

import ng.riby.androidtest.core.data.entities.Coordinates;

public class CoordinatesPayload {
    private double originLat;

    private double originLng;

    private double destinationLat;

    private double destinationLng;

    public static CoordinatesPayload create(Coordinates coordinates) {
        CoordinatesPayload payload = new CoordinatesPayload();
        payload.originLat = coordinates.getOriginLat();
        payload.destinationLat = coordinates.getDestinationLat();
        payload.originLng = coordinates.getOriginLng();
        payload.destinationLng = coordinates.getDestinationLng();
        return payload;
    }

    @NonNull
    @Override
    public String toString() {
        return "CoordinatesPayload{" +
                "originLat=" + originLat + '\'' +
                "destinationLat=" + destinationLat + '\'' +
                "originLng=" + originLng + '\'' +
                "destinationLng=" + destinationLng + '\'' +
                '}';
    }
}
