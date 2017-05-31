Wiv
--------

[![CircleCI](https://circleci.com/gh/ihsanbal/Wiv/tree/master.svg?style=svg)](https://circleci.com/gh/ihsanbal/Wiv/tree/master)
[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat-square)](http://www.oracle.com/technetwork/java/javase/downloads/jre7-downloads-1880261.html)

Library of [Tweet-ui](https://docs.fabric.io/android/twitter/tweet-ui.html) TweetMediaView component.

<p align="center">
    <img src="https://github.com/ihsanbal/Wiv/blob/master/resources/logo.jpg" width="300" height="300"/>
</p>

Usage
--------

```java

MediaView mediaView;
ArrayList<String> medias;

//medias.add("http://datalook.io/app/uploads/NY.jpg");
mediaView.setOnMediaClickListener(new MediaView.OnMediaClickListener() {
    @Override
    public void onMediaClick(View view, int index) {
        Snackbar.make(view, "onClickIndex :" + index, Snackbar.LENGTH_LONG).show();
    }
});
mediaView.setMedias(medias);
```

```xml
<com.ihsanbal.wiv.AspectRatioLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginTop="?attr/actionBarSize"
        app:aspect_ratio="1"
        app:dimension_to_adjust="height">

        <com.ihsanbal.wiv.MediaView
            android:id="@+id/media.view"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="14dp"
            app:background_color="@android:color/white"
            app:corner_radii="15dp"
            app:divider_size="2dp" />

</com.ihsanbal.wiv.AspectRatioLayout>
```

Download
--------

Gradle:
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}

dependencies {
	compile 'com.github.ihsanbal:Wiv:1.0.0'
}
```

Maven:
```xml
<repository>
   <id>jitpack.io</id>
   <url>https://jitpack.io</url>
</repository>

<dependency>
	    <groupId>com.github.ihsanbal</groupId>
	    <artifactId>Wiv</artifactId>
	    <version>1.0.0</version>
</dependency>
```
