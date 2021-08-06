
# Payoneer

<img src="https://user-images.githubusercontent.com/47601553/128331873-dfefd10e-6cf5-49f5-826a-3d9a0309ded2.jpg" width="500" style="max-width:100%;">

This is take way assigment for Payoneer recruitment process.

## Table of Contents

- [Prerequisite](#prerequisite)
- [The App](#theapp)
- [Architecture](#architecture)
- [Testing](#testing)
- [ScreenShots](#screenshots)
- [Sample App and Source Code](#sampleappandsourcecode)

## Prerequisite

This project uses the Gradle build system. To build this project, use the
`gradlew build` command or use "Import Project" in Android Studio.

## The App

A small app that loads and presents a list of payment methods like Visa, SEPA and
PayPal for Payoneer customers. The app has one Activity that only act as entry point.

The project has been written in Java language. For network requests, it uses Retrofit with RxJava and Gson.

Dagger2 has been used for Dependency injection.

## Architecture
The project is built using the MVVM architectural pattern and make heavy use of a couple of Android Jetpack components. Mvvm allows for the separation of concern which also makes testing easier. The MVVM pattern is shown in the diagram. 



## MVVM diagram
The first time the app is opened, the data will be fetched from the backend api service and stored locally in room. 
But if there is no internet or the api service is down, the data will be fetched from the local cache.
This is handled in the repository class.
ViewModel is basically responsible for updating the UI (Activity/Fragment) with the data changes.
The ViewModel will initialise an instance of the Repository class and update the UI based with this data.


<img src="https://user-images.githubusercontent.com/47601553/128049430-1d098d5f-0e93-453a-9e9f-31875d05e55a.png" width="500" style="max-width:100%;">


## Testing
All tests are under the Android Test package. All the tests are run using JUnit.

## ScreenShots


The app is available in both day and night theme.


<img src="https://user-images.githubusercontent.com/47601553/128050057-1329ee0b-4b62-4c66-af56-38cbb176a643.jpg" width="200" style="max-width:100%;">   <img src="https://user-images.githubusercontent.com/47601553/128050100-f7c220d8-bde2-41ff-92a6-1714fceef7a2.jpg" width="200" style="max-width:100%;"></br></br>

## Libraries

Libraries used in the whole application are:

- [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI related data in a lifecycle conscious way 
- [Room](https://developer.android.com/training/data-storage/room) - Provides abstraction layer over SQLite
- [kotlinx.coroutines](https://github.com/ReactiveX/RxJava) - RxJava is a Java VM implementation of Reactive Extensions: a library for composing asynchronous and event-based programs by using observable sequences.
- [Dagger2](https://dagger.dev/dev-guide/) - Used for Dependency injection
- [Retrofit](https://square.github.io/retrofit/) - Turns your HTTP API into a Java interface.
- [Mockito](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html) - Enables mock creation, verification and stubbing for testing
- [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver) - A scriptable web server for testing HTTP clients
- [Glide](https://github.com/bumptech/glide) - Media management and image loading framework for Android

## Sample App and Source Code

[Sample.App](https://drive.google.com/file/d/1thBIMv_iKiMHpq0gNiEkTk3p0NtIZYM6/view?usp=sharing) - Get APK debug app
<p><a href="https://drive.google.com/file/d/1thBIMv_iKiMHpq0gNiEkTk3p0NtIZYM6/view?usp=sharing"><img width="150" alt="Get it on Google Drive" src="https://user-images.githubusercontent.com/47601553/128481494-a5347b33-cc5f-4a2a-8d2a-7fc5f6acd41b.jpg" data-canonical-src="https://storage.googleapis.com/gweb-uniblog-publish-prod/images/Google_Drive.max-1100x1100.png" style="max-width:100%;"></a></p>

[Source.Code](https://github.com/Hechio/payoneer) - Access to the project's github reporitory

