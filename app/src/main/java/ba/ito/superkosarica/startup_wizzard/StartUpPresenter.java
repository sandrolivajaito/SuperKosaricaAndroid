package ba.ito.superkosarica.startup_wizzard;

import javax.inject.Inject;

import ba.ito.superkosarica.R;
import ba.ito.superkosarica.model.StartUpEnum;


public class StartUpPresenter implements StartUpContract.Presenter {
    private StartUpContract.View view;

    @Inject
    public StartUpPresenter() {
    }

    @Override
    public void takeView(StartUpContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        view = null;
    }

    @Override
    public void start(int currentStep) {
        view.setSelectedPosition(currentStep);
        switch (currentStep) {
            case StartUpEnum.STEP_ONE:
                view.displayImage(R.drawable.setup_wizzard_step_one);
                view.setStepTitle(R.string.wizzard_step_one_title);
                view.setStepDescription(R.string.wizzard_step_one_message);
                break;
            case StartUpEnum.STEP_TWO:
                view.displayImage(R.drawable.setup_wizzard_step_two);
                view.setStepTitle(R.string.wizzard_step_two_title);
                view.setStepDescription(R.string.wizzard_step_two_message);
                break;
            case StartUpEnum.STEP_THREE:
                view.displayImage(R.drawable.setup_wizzard_step_three);
                view.setStepTitle(R.string.wizzard_step_three_title);
                view.setStepDescription(R.string.wizzard_step_three_message);
                break;
            case StartUpEnum.STEP_FOUR:
                view.displayImage(R.drawable.setup_wizzard_step_four);
                view.setStepTitle(R.string.wizzard_step_four_title);
                view.setStepDescription(R.string.wizzard_step_four_message);
                break;
            case StartUpEnum.STEP_FIVE:
                view.displayImage(R.drawable.setup_wizzard_step_five);
                view.setStepTitle(R.string.wizzard_step_five_title);
                view.setStepDescription(R.string.wizzard_step_five_message);
                view.hideSkipButton();
                view.showFinishWizardButton();
                break;
        }
    }

    @Override
    public void stop() {

    }
}
