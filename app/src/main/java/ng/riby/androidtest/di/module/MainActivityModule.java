package ng.riby.androidtest.di.module;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import dagger.Module;
import dagger.Provides;
import ng.riby.androidtest.core.helpers.MapHelper;
import ng.riby.androidtest.core.helpers.UIHelper;
import ng.riby.androidtest.core.listeners.schedulers.AppRxSchedulers;
import ng.riby.androidtest.di.scopes.ActivityScope;
import ng.riby.androidtest.main.home.MainActivity;
import ng.riby.androidtest.main.home.mvvm.MainActivityViewModel;

@Module
public class MainActivityModule {

    @ActivityScope
    @Provides
    MainActivityViewModel provideHomeViewModel(MainActivity mainActivity, AppRxSchedulers appRxSchedulers, UIHelper uiHelper,
                                               FusedLocationProviderClient locationProviderClient, MapHelper mapHelper) {

        return new MainActivityViewModel(mainActivity, appRxSchedulers, uiHelper.getLocationRequest(), locationProviderClient, mapHelper);
    }

    @ActivityScope
    @Provides
    MapHelper provideMapHelper(MainActivity context) {
        return new MapHelper(context.getResources());
    }


    @ActivityScope
    @Provides
    AppRxSchedulers provideAppRxSchedulers() {
        return new AppRxSchedulers();
    }

    @ActivityScope
    @Provides
    FusedLocationProviderClient provideFusedLocationProviderClient(MainActivity mainActivity) {
        return LocationServices.getFusedLocationProviderClient(mainActivity);
    }
}
