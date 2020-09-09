package ng.riby.androidtest.di;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import ng.riby.androidtest.RibyTrackerApp;
import ng.riby.androidtest.di.module.ContributeActivityModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class, ContributeActivityModule.class})
public interface AppComponent {

    void inject(RibyTrackerApp ribyTrackerApp);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(RibyTrackerApp app);

        AppComponent build();
    }

}
