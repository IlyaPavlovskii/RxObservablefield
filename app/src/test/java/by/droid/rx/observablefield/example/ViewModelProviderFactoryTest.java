package by.droid.rx.observablefield.example;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 25.05.2018<br>
 * Time: 2:18<br>
 * Project name: RxObservableField<br>
 * ===================================================================================<br>
 */
public class ViewModelProviderFactoryTest {

    private ViewModelProvider.Factory mFactory;

    @Before
    public void setup() {
        mFactory = new ViewModelProviderFactory();
    }

    @Test
    public void create_Success() {
        ViewModel viewModel = mFactory.create(MainViewModel.class);
        assertNotNull(viewModel);
    }

    @Test
    public void create_Failure() {
        try {
            mFactory.create(TestViewModel.class);
        } catch (IllegalArgumentException ex) {
            assertNotNull(ex);
            assertTrue(ex.getMessage().contains("TestViewModel"));
        }
    }

    private class TestViewModel extends ViewModel {

    }
}