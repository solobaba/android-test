package ng.riby.androidtest.di;

import android.content.Context;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ng.riby.androidtest.RibyTrackerApp;
import ng.riby.androidtest.core.data.manager.DatabaseManager;
import ng.riby.androidtest.core.helpers.UIHelper;
import ng.riby.androidtest.di.scopes.ActivityScope;

@Module
public class AppModule {

    @Singleton
    @Provides
    DatabaseManager provideDatabaseManager(RibyTrackerApp app) {
        return DatabaseManager.getInstance(app.getApplicationContext());
    }

    @Singleton
    @Provides
    Context provideContext(RibyTrackerApp application) {
        return application.getApplicationContext();
    }

    @ActivityScope
    @Provides
    UIHelper provideUIHelper(RibyTrackerApp app) {
        return new UIHelper(app.getApplicationContext());
    }
}
