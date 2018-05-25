# RxObservableField
[![](https://www.jitpack.io/v/IlyaPavlovskii/RxObservablefield.svg)](https://www.jitpack.io/#IlyaPavlovskii/RxObservablefield)
[![license](https://img.shields.io/badge/license-apache-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Android library for converting BaseObservable to RxJava Observable

## Gradle setup
* Project level build.gradle
```
allprojects {
    repositories {
    ...
        maven { url 'https://www.jitpack.io' }
    }
}
```
* Application level build.gradle
```
dependencies {
    implementation 'com.github.IlyaPavlovskii:RxObservablefield:-SNAPSHOT'
}
```

## Quick start
```
ObservableInt intCounter = new ObservableInt(0);
ObservableFloat floatCounter = new ObservableFloat(0.0f);
ObservableField<String> text = new ObservableField<>();

public Observable<String> allChanges() {
    Observable<String> intObs = RxObservableUtils.asObservable(intCounter)
            .map(val -> "Int: " + val);
    Observable<String> floatObs = RxObservableUtils.asObservable(floatCounter)
            .map(val -> String.format("Float: %.2f", val));
    Observable<String> textObs = RxObservableUtils.asObservable(text)
            .map(val -> "Text: " + val);

    return Observable.mergeArray(intObs, floatObs, textObs);
}

```



## Developed by
Ilya Pavlovskii <a href="mailto:pavlovskii.ilya@gmail.com">pavlovskii.ilya@gmail.com</a></br>

## License
```
Copyright 2018 Ilya Pavlovskii

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```