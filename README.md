# Youtube-Channel-Videos
Android project to list all youtube channel videos

# Technology
kotlin</br>
Mvvm</br>
Dagger2</br>
rxJava</br>
Androidx</br>
Retrofit</br>

# Configuration
To configure the project you need first to add your API_KEY and CHANNEL_ID in BuildConfig throw app gradle file 

```
buildTypes {
        debug {
            buildConfigField("String", "API_KEY", "\"API_KEY\"")
            buildConfigField("String", "CHANNEL_ID", "\"CHANNEL_ID\"")
            buildConfigField("String", "BASE_URL", "\"https://www.googleapis.com/\"")
        }
        release {
            buildConfigField("String", "API_KEY", "\"API_KEY\"")
            buildConfigField("String", "CHANNEL_ID", "\"CHANNEL_ID\"")
            buildConfigField("String", "BASE_URL", "\"https://www.googleapis.com/\"")
        }
    }
```

# ScreenShots

<img src="https://github.com/thisAAY/Youtube-Channel-Videos/blob/master/screenshots/screenshot.png?raw=true=360x640" alt="screenshot1" width="360" height="640"/>

