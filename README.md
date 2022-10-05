# Koin-App
Sample app to try Koin with ViewModel.

> Add the dependencies:

  ```gradle
  ...
	dependencies {
    ...
    // Koin
    implementation "io.insert-koin:koin-android:3.2.0-beta-1"
	}
  ```

> Modules.kt:
```
val appModule = module {
    single { MyRepositoryImpl() }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}
```

> MyApp.kt:
```
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, viewModelModule))
        }
    }
}

```
> Go to AndroidManifest and add:
  ```AndroidManifest
  <application
        android:name=".MyApp"
        ...
  </application>
  ```

> MainActivity.kt:
```
private val vm:MainViewModel = get()
```
Or:
```
private val vm by viewModel<MainViewModel>()
```
