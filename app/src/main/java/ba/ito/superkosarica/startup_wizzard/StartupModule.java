package ba.ito.superkosarica.startup_wizzard;

import ba.ito.superkosarica.di.scope.FragmentScoped;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class StartupModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract StartUpFragment startUpFragment();

    @FragmentScoped
    @Binds
    abstract StartUpContract.Presenter startUpPresenter(StartUpPresenter presenter);
}
