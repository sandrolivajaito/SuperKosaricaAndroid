package ba.ito.superkosarica.startup_wizzard;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import ba.ito.superkosarica.base.BasePresenter;
import ba.ito.superkosarica.base.BaseView;

public interface StartUpContract {

    interface Presenter extends BasePresenter<View> {
        void start(int currentStep);

        void stop();
    }

    interface View extends BaseView<Presenter> {
        void setSelectedPosition(int position);

        void displayImage(@DrawableRes int imageDrawable);

        void setStepTitle(@StringRes int stepTitle);

        void setStepDescription(@StringRes int stepDescription);

        void hideSkipButton();

        void showFinishWizardButton();

    }

}
