# StateLayout

This library was inspired by [EmptyLayout] (https://github.com/alamkanak/android-empty-layout). It's easy to show the state of loading ,
error and empty state.


##Usage

In xml 
```
<?xml version="1.0" encoding="utf-8"?>
<com.jasonhezz.github.library.StateLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/state_layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:errorView="@layout/view_error_sample"
    >


  <TextView
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:text="Hello World!"
      />


</com.jasonhezz.github.library.StateLayout>
```
java code
```
StateLayout.setState(StateLayout.TYPE_ERROR);
```

##Customer error/loading/emty view?
```
  app:errorView:"@layout/your layout"
  app:emtyView:"@layout/your layout"
  app:loadingView："@layout/your layout"
```
##Noitice
StateLayout can only contains one child like ScrollView

##License
MIT license





