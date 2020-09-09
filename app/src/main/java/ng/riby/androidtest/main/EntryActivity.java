package ng.riby.androidtest.main;

import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.annotation.Nullable;
import ng.riby.androidtest.R;
import ng.riby.androidtest.core.base.BaseActivity;
import ng.riby.androidtest.databinding.ActivityEntryBinding;
import ng.riby.androidtest.main.home.MainActivity;

public class EntryActivity extends BaseActivity<ActivityEntryBinding> {

    ActivityEntryBinding binding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_entry;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewDataBinding();

        CountDownTimer count = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                initApp();
            }
        };
        count.start();
    }

    public void initApp() {
        launchActivity(this, MainActivity.class);
    }
}
