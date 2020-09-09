package ng.riby.androidtest.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Singleton;

@Singleton
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
