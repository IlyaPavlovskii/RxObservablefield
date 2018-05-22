package by.pinc.rx.observablefield.example;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import by.pinc.rx.observablefield.example.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @NonNull
    private final ViewModelProvider.Factory mViewModelFactory = new ViewModelProviderFactory();
    @NonNull
    private ActivityMainBinding mBinding;
    @NonNull
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = getViewModel();
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setModel(mViewModel);
    }

    @NonNull
    private MainViewModel getViewModel() {
        return ViewModelProviders
                .of(this, mViewModelFactory)
                .get(MainViewModel.class);
    }
}
