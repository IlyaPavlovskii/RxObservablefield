package by.pinc.rx.observablefield;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.databinding.ObservableFloat;
import android.databinding.ObservableInt;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 23.05.2018<br>
 * Time: 1:43<br>
 * Project name: RxObservableField<br>
 * ===================================================================================<br>
 */
public class MainViewModel extends ViewModel {

    public final ObservableInt intCounter = new ObservableInt(0);
    public final ObservableFloat floatCounter = new ObservableFloat(0.0f);
    public final ObservableField<String> text = new ObservableField<>();
    public final ObservableField<String> logger = new ObservableField<>();

    public void integerIncrement() {
        this.intCounter.set(this.intCounter.get() + 1);
    }

    public void integerDecrement() {
        this.intCounter.set(this.intCounter.get() - 1);
    }

    public void floatIncrement() {
        this.floatCounter.set(this.floatCounter.get() + 0.1f);
    }

    public void floatDecrement() {
        this.floatCounter.set(this.floatCounter.get() - 0.1f);
    }

}
