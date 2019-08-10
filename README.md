# Youtube-Channel-Videos
Android project to list all youtube channel videos

# Technology
kotlin
Dagger2
rxJava
Androidx
retrofit

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

![alt text](https://github.com/thisAAY/Youtube-Channel-Videos/blob/master/screenshots/screenshot.png?raw=true "Screenshot1")