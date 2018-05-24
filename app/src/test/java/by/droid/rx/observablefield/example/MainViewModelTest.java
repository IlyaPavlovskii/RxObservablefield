package by.droid.rx.observablefield.example;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.observers.TestObserver;

import static junit.framework.Assert.assertEquals;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 25.05.2018<br>
 * Time: 2:30<br>
 * Project name: RxObservableField<br>
 * ===================================================================================<br>
 */
public class MainViewModelTest {

    private MainViewModel mViewModel;

    @Before
    public void setup() {
        mViewModel = new MainViewModel();
    }

    @Test
    public void integerIncrement() {
        int startVal = mViewModel.intCounter.get();
        mViewModel.integerIncrement();
        assertEquals(startVal + 1, mViewModel.intCounter.get());

        mViewModel.intCounter.set(3);
        mViewModel.integerIncrement();
        assertEquals(4, mViewModel.intCounter.get());
    }

    @Test
    public void integerDecrement() {
        int startVal = mViewModel.intCounter.get();
        mViewModel.integerDecrement();
        assertEquals(startVal - 1, mViewModel.intCounter.get());

        mViewModel.intCounter.set(3);
        mViewModel.integerDecrement();
        assertEquals(2, mViewModel.intCounter.get());
    }

    @Test
    public void floatIncrement() {
        float startVal = mViewModel.floatCounter.get();
        mViewModel.floatIncrement();
        assertEquals(startVal + 0.1f, mViewModel.floatCounter.get());

        mViewModel.floatCounter.set(1.1f);
        mViewModel.floatIncrement();
        assertEquals(1.2f, mViewModel.floatCounter.get());
    }

    @Test
    public void floatDecrement() {
        float startVal = mViewModel.floatCounter.get();
        mViewModel.floatDecrement();
        assertEquals(startVal - 0.1f, mViewModel.floatCounter.get());

        mViewModel.floatCounter.set(1.1f);
        mViewModel.floatDecrement();
        assertEquals(1.0f, mViewModel.floatCounter.get());
    }

    @Test
    public void allChanges() {
        TestObserver<String> testObserver = mViewModel.allChanges().test();
        mViewModel.intCounter.set(1);
        mViewModel.floatCounter.set(3.1f);
        mViewModel.text.set("koko");
        testObserver.assertValues("Int: 1", "Float: 3,10", "Text: koko");
    }
}