package ba.ito.superkosarica.di.module;


import ba.ito.superkosarica.MainActivity;
import ba.ito.superkosarica.di.scope.ActivityScoped;
import ba.ito.superkosarica.startup_wizzard.StartupModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = StartupModule.class) //TODO Add injections
    abstract MainActivity tasksActivity();
}
