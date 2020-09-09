package ng.riby.androidtest.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ng.riby.androidtest.main.home.MainActivity;
import ng.riby.androidtest.di.module.MainActivityModule;
import ng.riby.androidtest.di.scopes.ActivityScope;

@Module
public abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity bindMainActivity();

}
