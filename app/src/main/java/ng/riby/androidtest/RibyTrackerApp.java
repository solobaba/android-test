package ng.riby.androidtest;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import ng.riby.androidtest.core.data.manager.DatabaseManager;
import ng.riby.androidtest.di.DaggerAppComponent;

public class RibyTrackerApp extends Application implements HasActivityInjector {

    private static final String TAG = RibyTrackerApp.class.getSimpleName();

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    private static RibyTrackerApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);

        DatabaseManager databaseManager = DatabaseManager.getInstance(this);
        databaseManager.emptyDatabase();
    }

    public static synchronized RibyTrackerApp getInstance() {
        return mInstance;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
