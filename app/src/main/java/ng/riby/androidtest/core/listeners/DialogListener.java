package ng.riby.androidtest.core.listeners;

public interface DialogListener {
    void onPositiveClick();

    default void onNegativeClick() {
    }
}
