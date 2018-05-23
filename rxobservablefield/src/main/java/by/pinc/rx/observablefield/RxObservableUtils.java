package by.pinc.rx.observablefield;

import android.databinding.ObservableField;
import android.databinding.ObservableFloat;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 23.05.2018<br>
 * Time: 2:50<br>
 * Project name: RxObservableField<br>
 * ===================================================================================<br>
 */
public class RxObservableUtils {

    private RxObservableUtils() {
    }

    public static <T> Observable<T> convert(@NonNull final ObservableField<T> field) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(final ObservableEmitter<T> emitter) throws Exception {
                field.addOnPropertyChangedCallback(new android.databinding.Observable.OnPropertyChangedCallback() {
                    @Override
                    public void onPropertyChanged(android.databinding.Observable sender, int propertyId) {
                        emitter.onNext(field.get());
                    }
                });
            }
        });
    }

    public static Observable<Integer> convert(@NonNull final ObservableInt field) {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(final ObservableEmitter<Integer> emitter) throws Exception {
                field.addOnPropertyChangedCallback(new android.databinding.Observable.OnPropertyChangedCallback() {
                    @Override
                    public void onPropertyChanged(android.databinding.Observable sender, int propertyId) {
                        emitter.onNext(field.get());
                    }
                });
            }
        });
    }

    public static Observable<Float> convert(@NonNull final ObservableFloat field) {
        return Observable.create(new ObservableOnSubscribe<Float>() {
            @Override
            public void subscribe(final ObservableEmitter<Float> emitter) throws Exception {
                field.addOnPropertyChangedCallback(new android.databinding.Observable.OnPropertyChangedCallback() {
                    @Override
                    public void onPropertyChanged(android.databinding.Observable sender, int propertyId) {
                        emitter.onNext(field.get());
                    }
                });
            }
        });
    }

}
