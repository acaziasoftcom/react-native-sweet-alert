# Install the package from NPM:

`
yarn add react-native-sweet-alert
`

or

`
npm install --save react-native-sweet-alert
`

# Link to the current project:

`
react-native link react-native-sweet-alert
`

# On Android:

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

And then you can use the library like so:

import SweetAlert from 'react-native-sweet-alert';

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

Extra options and methods (Android only):

dismissAlert():

Dismiss the alert with JavaScript code. Since the dialog is single instance.

changeAlertType(type: string):

Change the alert type, one of following: normal, error, success, warning, progress

showContentText():

Show the content text with animation.

showCancelButton():

Show the cancel button with animation.

### With the dialog in progress mode, we also have following methods available:

resetCount()

Reset the counter of the progress.

isSpinning(): Promise

Get spinning status of the progress bar.

spin():

Start spinning.

# On iOS:

I'm still working on the iOS port, if you are willing to help, welcome.
