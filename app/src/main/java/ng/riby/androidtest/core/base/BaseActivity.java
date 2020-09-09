package ng.riby.androidtest.core.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import javax.inject.Inject;

import ng.riby.androidtest.core.constant.AppConstant;
import ng.riby.androidtest.core.helpers.UIHelper;
import ng.riby.androidtest.core.listeners.OnBackPressedListener;
import ng.riby.androidtest.objects.NavData;
import ng.riby.androidtest.util.LogUtil;

public abstract class BaseActivity <T extends ViewDataBinding> extends AppCompatActivity {
    private T viewDataBinding;
    private Context context;
    private Bundle bundle;

    @Inject
    UIHelper uiHelper;

    /**
     * @return layout id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * @return layout id
     */
    public int getNavHost() {
        return -1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        context = this;
        bundle = getIntent().getExtras();

        if (bundle == null) {
            bundle = new Bundle();
        }
    }

    public boolean hasPermission() {
        return uiHelper.checkLocationProvideEnabled();
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M
                || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    public T getViewDataBinding() {
        return viewDataBinding;
    }

    @Override
    public void onBackPressed() {
        try {
            final Fragment navHost = getSupportFragmentManager().getFragments().get(0);
            final Fragment currentFrag = navHost.getChildFragmentManager().getFragments().get(0);
            final NavController controller = Navigation.findNavController(this, getNavHost());
            if (currentFrag instanceof OnBackPressedListener) {
                NavData sourceObj = ((OnBackPressedListener) currentFrag).onBackPressed();
                LogUtil.w("source obj:", sourceObj.toString());
                if (sourceObj.getNavigatedId() > 0) {
                    controller.navigate(sourceObj.getNavigatedId(), sourceObj.getBundle());
                } else {
                    boolean showNav = sourceObj.getBundle().getBoolean(AppConstant.SHOW_BACK_BUTTON);
                    if (showNav) {
                        finish();
                    } else {
                        super.onBackPressed();
                    }
                }
            } else if (!controller.popBackStack()) {
                super.onBackPressed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public void launchActivity(Context context, Class<?> clazz, Bundle bundle, boolean isNewTask) {
        Intent intent = new Intent(context, clazz);
        if (bundle != null)
            intent.putExtras(bundle);
        if (isNewTask)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void launchActivity(Context context, Class<?> clazz, boolean isNewTask) {
        Intent intent = new Intent(context, clazz);
        if (isNewTask)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void launchActivity(Context context, Class<?> clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }
}
