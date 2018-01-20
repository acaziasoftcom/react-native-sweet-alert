/**
 * @providesModule RNSweetAlert
 * @flow
 */
'use strict';

import React, { NativeModules } from 'react-native';
import isHex from 'is-hexcolor';

const Native = NativeModules.RNSweetAlert;

const SweetAlert = {
  showAlert: (data = {}, acceptCallback = () => true, cancelCallback = () => true) => {
    Native.showSweetAlert({
      type: 'normal',
      title: '',
      contentText: '',
      cancellable: true,
      ...data
    }, acceptCallback, cancelCallback);
  },
  dismissAlert: () => Native.hideSweetAlert(),
  changeAlertType: (type) => Native.changeAlertType(type),
  showCancelButton: (bool = true) => {
     if (typeof bool == 'boolean') {
        Native.showCancelButton(bool);
     }
  },
  showContentText: (bool = true) => {
     if (typeof bool == 'boolean') {
        Native.showContentText(bool);
     }
  },
  setBarColor: (barColor) => {
  	if (isHex(barColor)) {
  		  Native.setBarColor(barColor);
  	}
  },
  resetCount: () => {
        Native.resetCount();
  },
  spin: () => {
        Native.spin();
  }

};

export default SweetAlert;
