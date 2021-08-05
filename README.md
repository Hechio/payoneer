
# Payoneer

<img src="https://user-images.githubusercontent.com/47601553/128331873-dfefd10e-6cf5-49f5-826a-3d9a0309ded2.jpg" width="500" style="max-width:100%;">

This is take way assigment for Payoneer recruitment process.


A small app that loads and presents a list of payment methods like Visa, SEPA and
PayPal for Payoneer customers.

The project has been written in Java language. For network requests, it uses Retrofit with RxJava and Gson.

Dagger2 has been used for Dependency injection.

I am using MVVM pattern as shown in the diagram. 



## MVVM diagram
The first time the app is opened, the data will be fetched from the backend api service and stored locally in room. 
But if there is no internet or the api service is down, the data will be fetched from the local cache.
This is handled in the repository class.
ViewModel is basically responsible for updating the UI (Activity/Fragment) with the data changes.
The ViewModel will initialise an instance of the Repository class and update the UI based with this data.


<img src="https://user-images.githubusercontent.com/47601553/128049430-1d098d5f-0e93-453a-9e9f-31875d05e55a.png" width="500" style="max-width:100%;">


## ScreenShots


The app is available in both day and night theme.

<img src="https://user-images.githubusercontent.com/47601553/128050057-1329ee0b-4b62-4c66-af56-38cbb176a643.jpg" width="200" style="max-width:100%;">   <img src="https://user-images.githubusercontent.com/47601553/128050100-f7c220d8-bde2-41ff-92a6-1714fceef7a2.jpg" width="200" style="max-width:100%;"></br></br>


