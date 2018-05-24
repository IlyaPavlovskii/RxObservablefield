package by.droid.rx.observablefield.example;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import by.droid.rx.observablefield.example.databinding.ActivityMainBinding;
import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @NonNull
    private final ViewModelProvider.Factory mViewModelFactory = new ViewModelProviderFactory();
    @NonNull
    private MainViewModel mViewModel;

    @NonNull
    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = getViewModel();
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setModel(mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mCompositeDisposable.add(mViewModel
                .allChanges()
                .subscribe(
                        log -> Timber.d("log: %s", log),
                        Timber::w));
    }

    @Override
    protected void onStop() {
        super.onStop();
        mCompositeDisposable.clear();
    }

    @NonNull
    private MainViewModel getViewModel() {
        return ViewModelProviders
                .of(this, mViewModelFactory)
                .get(MainViewModel.class);
    }
}
