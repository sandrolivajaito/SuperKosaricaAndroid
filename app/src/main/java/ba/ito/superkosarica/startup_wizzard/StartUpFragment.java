package ba.ito.superkosarica.startup_wizzard;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import ba.ito.superkosarica.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StartUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StartUpFragment extends DaggerFragment implements StartUpContract.View {


    private static final String BUNDLE_CURRENT_STEP = "BUNDLE_CURRENT_STEP";
    @BindView(R.id.text_skip)
    TextView textSkip;
    @BindView(R.id.image_step)
    ImageView imageStep;
    @BindView(R.id.text_step_title)
    TextView textStepTitle;
    @BindView(R.id.text_step_description)
    TextView textStepDescription;
    @BindView(R.id.dot_one)
    FrameLayout dotOne;
    @BindView(R.id.dot_two)
    FrameLayout dotTwo;
    @BindView(R.id.dot_three)
    FrameLayout dotThree;
    @BindView(R.id.dot_four)
    FrameLayout dotFour;
    @BindView(R.id.dot_five)
    FrameLayout dotFive;
    Unbinder unbinder;

    @BindView(R.id.btn_finish_wizard)
    Button btnFinishWizard;

    @Inject
    StartUpContract.Presenter presenter;

    private int currentStep;

    public StartUpFragment() {
        // Required empty public constructor
    }


    public static StartUpFragment newInstance(int currentStep) {
        StartUpFragment fragment = new StartUpFragment();

        Bundle args = new Bundle();
        args.putInt(BUNDLE_CURRENT_STEP, currentStep);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start_up, container, false);
        unbinder = ButterKnife.bind(this, view);
        currentStep = getArguments().getInt(BUNDLE_CURRENT_STEP);


        presenter.takeView(this);
        presenter.start(currentStep);

        return view;
    }


    @Override
    public void setSelectedPosition(int position) {
        switch (position) {
            case 1:
                dotOne.setBackground(getResources().getDrawable(R.drawable.setup_wizzard_step_selected));
                break;
            case 2:
                dotTwo.setBackground(getResources().getDrawable(R.drawable.setup_wizzard_step_selected));
                break;
            case 3:
                dotThree.setBackground(getResources().getDrawable(R.drawable.setup_wizzard_step_selected));
                break;
            case 4:
                dotFour.setBackground(getResources().getDrawable(R.drawable.setup_wizzard_step_selected));
                break;
            case 5:
                dotFive.setBackground(getResources().getDrawable(R.drawable.setup_wizzard_step_selected));
                break;
        }
    }

    @Override
    public void displayImage(int imageDrawable) {
        imageStep.setImageDrawable(getResources().getDrawable(imageDrawable));
    }

    @Override
    public void setStepTitle(int stepTitle) {
        textStepTitle.setText(getResources().getString(stepTitle));
    }

    @Override
    public void setStepDescription(int stepDescription) {
        textStepDescription.setText(getResources().getString(stepDescription));
    }

    @Override
    public void hideSkipButton() {
        textSkip.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showFinishWizardButton() {
        btnFinishWizard.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.dropView();
    }

}
