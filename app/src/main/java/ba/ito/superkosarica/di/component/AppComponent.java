package ba.ito.superkosarica.di.component;

import javax.inject.Singleton;

import ba.ito.superkosarica.App;
import ba.ito.superkosarica.di.module.ActivityBindingModule;
import ba.ito.superkosarica.di.module.ApplicationModule;
import ba.ito.superkosarica.startup_wizzard.StartupModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        ActivityBindingModule.class,
        StartupModule.class
})
public interface AppComponent extends AndroidInjector<App> {

    @Override
    void inject(App instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(App application);

        AppComponent build();
    }
}
