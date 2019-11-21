# BitCoin-Grafik

BitCoin-Grafik is an Android applications that displays a graphical information about bitcoin transactions

### Tech

Below is a list of tools used in building this library:

* [Dagger 2](https://github.com/google/dagger) for dependencies injection!
* [RxJava](https://github.com/ReactiveX/RxJava) for asynchronous processes
* [Timber](https://github.com/JakeWharton/timber) for logs
* [Material Design](https://material.io/develop/android/) for views and material theme
* [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started) for all intra-module navigation
* [ViewModel and LiveData](https://developer.android.com/topic/libraries/architecture/lifecycle) for asynchronous delivery of data with lifecycle awareness
##### Testing 
* [JUnit](https://junit.org/junit4/)
* [Espresso](https://developer.android.com/training/testing/espresso)
* [MockK](https://github.com/mockk/mockk)
* [TestRule](https://developer.android.com/training/testing/junit-rules)
* [Fragment Testing](https://developer.android.com/training/basics/fragments/testing)

### Installation

Falling Words requires a phone running on API 21 and above.
Clone the repository and run. 

### How to run
To run the project, you need Android 3.5, any of the release candidates will suffice. 
- Clone the project
- Import into Android Studio. 
- Run
- To run tests, follow the comments in the ViewModel classes
- If you have any problem building because of kotlin modules, please check the StackOverflow answer [here](https://stackoverflow.com/questions/56607089/new-gradle-sync-is-not-supported-due-to-containing-kotlin-modules-using-an-unsup/56630152#56630152)

### TODO
 - Write MORE UI tests
 - Add Night Mode
 - Integrate offline-first functionality
