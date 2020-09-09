package ng.riby.androidtest.objects;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

import java.io.Serializable;

public class NavData implements Serializable {
    @IdRes
    private int navigatedId = -1;
    private Bundle bundle;

    public NavData() {

    }

    public NavData(int navigatedId, Bundle bundle) {
        this.navigatedId = navigatedId;
        this.bundle = bundle;
    }

    public int getNavigatedId() {
        return navigatedId;
    }

    public void setNavigatedId(int navigatedId) {
        this.navigatedId = navigatedId;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    @NonNull
    @Override
    public String toString() {
        return "SourceObject{" +
                "navigateId=" + navigatedId +
                ", bundle=" + bundle +
                '}';
    }
}
