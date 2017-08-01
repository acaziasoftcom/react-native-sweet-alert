package com.clipsub.sweetalert;

import android.graphics.Color;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class RNSweetAlertModule extends ReactContextBaseJavaModule {
  private SweetAlertDialog sweetAlertDialog;
  RNSweetAlertModule(final ReactApplicationContext reactContext) {
    super(reactContext);
    sweetAlertDialog = new SweetAlertDialog(reactContext);
  }

  @Override
  public String getName() {
    return "SweetAlert";
  }

  @ReactMethod
  public void showSweetAlert(ReadableMap options, final Callback acceptCallback, final Callback cancelCallback) {
    String type = options.getString("type");
    String title = options.getString("title");
    String contentText = options.getString("contentText");
    boolean cancellable = options.getBoolean("cancellable");
    switch (type) {
      case "normal":
        sweetAlertDialog.changeAlertType(SweetAlertDialog.NORMAL_TYPE);
        break;
      case "error":
        sweetAlertDialog.changeAlertType(SweetAlertDialog.ERROR_TYPE);
        break;
      case "success":
        sweetAlertDialog.changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
        break;
      case "warning":
        sweetAlertDialog.changeAlertType(SweetAlertDialog.WARNING_TYPE);
        break;
      case "progress":
        sweetAlertDialog.changeAlertType(SweetAlertDialog.PROGRESS_TYPE);
        break;
      default:
        sweetAlertDialog.changeAlertType(SweetAlertDialog.NORMAL_TYPE);
        break;
    }

    sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
      @Override
      public void onClick(SweetAlertDialog sweetAlertDialog) {
        acceptCallback.invoke("accepted");
        sweetAlertDialog.dismissWithAnimation();
      }
    });
    sweetAlertDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
      @Override
      public void onClick(SweetAlertDialog sweetAlertDialog) {
        cancelCallback.invoke("cancelled");
      }
    });
    sweetAlertDialog.setTitleText(title);
    sweetAlertDialog.setContentText(contentText);
    sweetAlertDialog.setCancelable(cancellable);
    sweetAlertDialog.show();
  }

  @ReactMethod
  public void hideSweetAlert() {
    if (sweetAlertDialog != null && sweetAlertDialog.isShowing()) {
      sweetAlertDialog.dismissWithAnimation();
    }
  }

  @ReactMethod
  public void changeAlertType(String alertType) {
    switch (alertType) {
      case "normal":
        sweetAlertDialog.changeAlertType(SweetAlertDialog.NORMAL_TYPE);
        break;
      case "error":
        sweetAlertDialog.changeAlertType(SweetAlertDialog.ERROR_TYPE);
        break;
      case "success":
        sweetAlertDialog.changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
        break;
      case "warning":
        sweetAlertDialog.changeAlertType(SweetAlertDialog.WARNING_TYPE);
        break;
      case "progress":
        sweetAlertDialog.changeAlertType(SweetAlertDialog.PROGRESS_TYPE);
        break;
      default:
        sweetAlertDialog.changeAlertType(SweetAlertDialog.NORMAL_TYPE);
        break;
    }
  }

  @ReactMethod
  public void showContentText(boolean isShow) {
    sweetAlertDialog.showContentText(isShow);
  }

  @ReactMethod
  public void showCancelButton(boolean isShow) {
    sweetAlertDialog.showCancelButton(isShow);
  }

  @ReactMethod
  public void resetCount() {
    sweetAlertDialog.getProgressHelper().resetCount();
  }

  // Get spinning status, better to use a boolean variable in JS side instead.
  @ReactMethod
  public void isSpinning(Promise promise) {
    try {
      promise.resolve(sweetAlertDialog.isShowing());
    } catch(Exception e) {
      promise.reject("SweetAlert", e);
    }
  }

  @ReactMethod
  public void spin() {
    sweetAlertDialog.getProgressHelper().spin();
  }

  @ReactMethod
  public void stopSpinning() {
    sweetAlertDialog.getProgressHelper().stopSpinning();
  }

  @ReactMethod
  public void setProgress(float number) {
    sweetAlertDialog.getProgressHelper().setProgress(number);
  }

  @ReactMethod
  public void setInstantProgress(float number) {
    sweetAlertDialog.getProgressHelper().setInstantProgress(number);
  }

  @ReactMethod
  public void setCircleRadius(int radius) {
    sweetAlertDialog.getProgressHelper().setCircleRadius(radius);
  }

  @ReactMethod
  public void setBarWidth(int barWidth) {
    sweetAlertDialog.getProgressHelper().setBarWidth(barWidth);
  }

  @ReactMethod
  public void setBarColor(String barColor) {
    sweetAlertDialog.getProgressHelper().setBarColor(Color.parseColor(barColor));
  }

  @ReactMethod
  public void setRimWidth(int rimWidth) {
    sweetAlertDialog.getProgressHelper().setRimWidth(rimWidth);
  }

  @ReactMethod
  public void setSpinSpeed(float spinSpeed) {
    sweetAlertDialog.getProgressHelper().setSpinSpeed(spinSpeed);
  }
}
