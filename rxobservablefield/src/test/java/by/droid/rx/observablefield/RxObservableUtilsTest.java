package by.droid.rx.observablefield;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableByte;
import android.databinding.ObservableChar;
import android.databinding.ObservableDouble;
import android.databinding.ObservableField;
import android.databinding.ObservableFloat;
import android.databinding.ObservableInt;
import android.databinding.ObservableLong;
import android.databinding.ObservableParcelable;
import android.databinding.ObservableShort;
import android.graphics.Rect;

import org.junit.Test;

import io.reactivex.observers.TestObserver;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 24.05.2018<br>
 * Time: 2:00<br>
 * Project name: RxObservableField<br>
 * ===================================================================================<br>
 */
public class RxObservableUtilsTest {

    @Test
    public void testObservableField_emitter() {
        final ObservableField<String> field = new ObservableField<>();
        TestObserver<String> testObserver = RxObservableUtils.asObservable(field)
                .test();
        field.set("test1");
        field.set("test2");
        field.set("test3");
        testObserver.assertValues("test1", "test2", "test3");
    }

    @Test
    public void testObservableField_error() {
        final ObservableField<String> field = new ObservableField<>("default value");
        TestObserver<String> testObserver = RxObservableUtils.asObservable(field)
                .test();
        field.set(null);
        testObserver.assertError(NullPointerException.class);
    }

    @Test
    public void testObservableInt_emitter() {
        final ObservableInt field = new ObservableInt();
        TestObserver<Integer> testObserver = RxObservableUtils.asObservable(field)
                .test();
        field.set(1);
        field.set(102);
        field.set(91);
        testObserver.assertValues(1, 102, 91);
    }

    @Test
    public void testObservableBoolean_emitter() {
        final ObservableBoolean field = new ObservableBoolean();
        TestObserver<Boolean> testObserver = RxObservableUtils.asObservable(field)
                .test();
        field.set(true);
        field.set(false);
        field.set(false);
        field.set(true);
        field.set(false);
        testObserver.assertValues(true, false, true, false);
    }

    @Test
    public void testObservableByte_emitter() {
        final ObservableByte field = new ObservableByte();
        TestObserver<Byte> testObserver = RxObservableUtils.asObservable(field)
                .test();
        field.set((byte) 120);
        field.set((byte) 12);
        field.set((byte) 8);
        testObserver.assertValues((byte) 120, (byte) 12, (byte) 8);
    }

    @Test
    public void testObservableCharacter_emitter() {
        final ObservableChar field = new ObservableChar();
        TestObserver<Character> testObserver = RxObservableUtils.asObservable(field)
                .test();
        field.set('t');
        field.set('e');
        field.set('s');
        field.set('t');
        testObserver.assertValues('t', 'e', 's', 't');
    }

    @Test
    public void testObservableDouble_emitter() {
        final ObservableDouble field = new ObservableDouble();
        TestObserver<Double> testObserver = RxObservableUtils.asObservable(field)
                .test();
        field.set(0.91);
        field.set(2.1);
        field.set(3.145135);
        testObserver.assertValues(0.91, 2.1, 3.145135);
    }

    @Test
    public void testObservableFloat_emitter() {
        final ObservableFloat field = new ObservableFloat();
        TestObserver<Float> testObserver = RxObservableUtils.asObservable(field)
                .test();
        field.set(0.91f);
        field.set(2.1f);
        field.set(3.145135f);
        testObserver.assertValues(0.91f, 2.1f, 3.145135f);
    }

    @Test
    public void testObservableLong_emitter() {
        final ObservableLong field = new ObservableLong();
        TestObserver<Long> testObserver = RxObservableUtils.asObservable(field)
                .test();
        field.set(Long.MAX_VALUE);
        field.set(0L);
        field.set(2);
        field.set(Long.MIN_VALUE);
        testObserver.assertValues(Long.MAX_VALUE, 0L, 2L, Long.MIN_VALUE);
    }

    @Test
    public void testObservableShort_emitter() {
        final ObservableShort field = new ObservableShort();
        TestObserver<Short> testObserver = RxObservableUtils.asObservable(field)
                .test();
        field.set((short) 2);
        field.set(Short.MAX_VALUE);
        field.set(Short.MIN_VALUE);
        field.set((short) 8);
        testObserver.assertValues((short) 2, Short.MAX_VALUE, Short.MIN_VALUE, (short) 8);
    }

    @Test
    public void testObservableParcelable_emitter() {
        final ObservableParcelable<Rect> field = new ObservableParcelable<>();
        TestObserver<Rect> testObserver = RxObservableUtils.asObservable(field)
                .test();
        Rect rect1 = new Rect(0, 0, 10, 10);
        Rect rect2 = new Rect(10, 10, 123, 321);
        Rect rect3 = new Rect(-91, -40, 10, 10);

        field.set(rect1);
        field.set(rect2);
        field.set(rect3);

        testObserver.assertValues(rect1, rect2, rect3);
    }
}
