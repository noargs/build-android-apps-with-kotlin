### Reading data from an API   
    
     
- we will create an app that presents us with one random
- secret cat agent from the TheCatAPI.     
- Add internet permission to your app 
```xml
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="github.noargs.catagentprofile">
        
        <uses-permission android:name="android.permission.INTERNET" />
        
        <application>
            ...
        </application>    
        
    </manifest>
```
- your *dependencies* block should now look something like this
```groovy
    dependencies {
        implementation 'androidx.core:core-ktx:1.8.0'
        implementation 'androidx.appcompat:appcompat:1.4.2'
        implementation 'com.google.android.material:material:1.6.1'
        implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
        implementation 'androidx.navigation:navigation-fragment-ktx:2.2.2'
        implementation 'androidx.navigation:navigation-ui-ktx:2.2.2' 
        implementation 'com.squareup.retrofit2:retrofit:2.9.0' 
        implementation 'com.squareup.retrofit2:converter-scalars:2.9.0'
        implementation 'com.squareup.retrofit2:converter-moshi:2.9.0'
        testImplementation 'junit:junit:4.+'
        androidTestImplementation 'androidx.test.ext:junit:1.1.3'
        androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    }
```

- `ScalarsConverterFactory` to be recognised, we added following dependency in app module gradle
```groovy
    implementation 'com.squareup.retrofit2:converter-scalars:2.9.0'
```  
- we added **Moshi** to handle *JSON* response from server
```groovy
    implementation 'com.squareup.retrofit2:converter-moshi:2.9.0'  
```
