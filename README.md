
# react-native-sweet-alert

## Getting started

`$ npm install react-native-sweet-alert --save`

### Mostly automatic installation

`$ react-native link react-native-sweet-alert`

### Manual installation

# On Android:

__In the AndroidManifest.xml file__

Below this line:

`
xmlns:android="http://schemas.android.com/apk/res/android"
`

add this:

`
xmlns:tools="http://schemas.android.com/tools"
`

And in the `<application>` tag, add this property:

`
tools:replace="android:icon"
`

so it will look like:

```
<application
  android:name=".MainApplication"
  android:allowBackup="true"
  android:label="@string/app_name"
  android:icon="@mipmap/ic_launcher"
  tools:replace="android:icon"
  android:theme="@style/AppTheme">
```

# On iOS:

Since the vendor library is written in Swift, apart from doing usual `react-native link react-native-sweet-alert`, you will also have to create a Bridging Header for Swift file, which is also pretty easy:

- Open the project with XCode.



__And then you can use the library like so:__

```
import SweetAlert from 'react-native-sweet-alert';
```

```
SweetAlert.showAlert({
  type: 'normal', // error, success, warning, progress (Android Only).
  title: 'Example Title',
  contentText: 'Example Content Text',
  cancellable: true,
},
  acceptButtonCallback => console.log(acceptButtonCallback),
  cancelButtonCallback => console.log(cancelButtonCallback));
```

### With the dialog in progress mode, we also have following methods available:

`resetCount()` Reset the counter of the progress.

`isSpinning(): Promise` Get spinning status of the progress bar.

`spin():` Start spinning.

`setBarColor(type: string)` Changes the progress bar color. Argument must be a hex color string like `#ff0000`

# On iOS:

I'm still working on the iOS port, if you are willing to help, welcome.
