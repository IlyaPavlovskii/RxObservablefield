package by.droid.rx.observablefield.example;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 23.05.2018<br>
 * Time: 1:47<br>
 * Project name: RxObservableField<br>
 * ===================================================================================<br>
 */
public class ViewModelProviderFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        ViewModel viewModel = null;
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            viewModel = new MainViewModel();
        }

        if (viewModel == null) {
            throw new IllegalArgumentException("Unknown ViewModel class.Check factory: " + modelClass.getSimpleName());
        } else {
            return (T) viewModel;
        }
    }
}
