package by.pinc.rx.observablefield;

import android.databinding.BaseObservable;
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
import android.os.Parcelable;
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

    public static <T> Observable<T> asObservable(@NonNull final ObservableField<T> field) {
        return Observable.create(subscriber(field, new Getter<T>() {
            @Override
            public T get() {
                return field.get();
            }
        }));
    }

    public static Observable<Integer> asObservable(@NonNull final ObservableInt field) {
        return Observable.create(subscriber(field, new Getter<Integer>() {
            @Override
            public Integer get() {
                return field.get();
            }
        }));
    }

    public static Observable<Boolean> asObservable(@NonNull final ObservableBoolean field) {
        return Observable.create(subscriber(field, new Getter<Boolean>() {
            @Override
            public Boolean get() {
                return field.get();
            }
        }));
    }

    public static Observable<Byte> asObservable(@NonNull final ObservableByte field) {
        return Observable.create(subscriber(field, new Getter<Byte>() {
            @Override
            public Byte get() {
                return field.get();
            }
        }));
    }

    public static Observable<Character> asObservable(@NonNull final ObservableChar field) {
        return Observable.create(subscriber(field, new Getter<Character>() {
            @Override
            public Character get() {
                return field.get();
            }
        }));
    }

    public static Observable<Double> asObservable(@NonNull final ObservableDouble field) {
        return Observable.create(subscriber(field, new Getter<Double>() {
            @Override
            public Double get() {
                return field.get();
            }
        }));
    }

    public static Observable<Float> asObservable(@NonNull final ObservableFloat field) {
        return Observable.create(subscriber(field, new Getter<Float>() {
            @Override
            public Float get() {
                return field.get();
            }
        }));
    }

    public static Observable<Long> asObservable(@NonNull final ObservableLong field) {
        return Observable.create(subscriber(field, new Getter<Long>() {
            @Override
            public Long get() {
                return field.get();
            }
        }));
    }

    public static <T extends Parcelable> Observable<T> asObservable(@NonNull final ObservableParcelable<T> field) {
        return Observable.create(subscriber(field, new Getter<T>() {
            @Override
            public T get() {
                return field.get();
            }
        }));
    }

    public static Observable<Short> asObservable(@NonNull final ObservableShort field) {
        return Observable.create(subscriber(field, new Getter<Short>() {
            @Override
            public Short get() {
                return field.get();
            }
        }));
    }

    private static <T> ObservableOnSubscribe<T> subscriber(final BaseObservable field, final Getter<T> getter) {
        return new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(final ObservableEmitter<T> emitter) {
                field.addOnPropertyChangedCallback(new android.databinding.Observable.OnPropertyChangedCallback() {
                    @Override
                    public void onPropertyChanged(android.databinding.Observable sender, int propertyId) {
                        emitter.onNext(getter.get());
                    }
                });
            }
        };
    }

}
