/**
 * @providesModule RNSweetAlert
 * @flow
 */
'use strict';

import React, { NativeModules } from 'react-native';
import isHex from 'is-hexcolor';

const SweetAlertNative = NativeModules.RNSweetAlert;

const SweetAlert = {
  showAlert: (data, acceptCallback = () => console.log('accepted'), cancelCallback = () => console.log('cancelled')) => {
    SweetAlertNative.showSweetAlert({
      type: 'normal', // error, success, warning, progress.
      title: '',
      contentText: '',
      cancellable: true,
      ...data
    }, acceptCallback, cancelCallback);
  },
  dismissAlert: () => SweetAlertNative.hideSweetAlert(),
  changeAlertType: (type) => SweetAlertNative.changeAlertType(type),
  setBarColor: (barColor) => {
  	if (isHex(barColor)) {
  		SweetAlertNative.setBarColor(barColor);
  	}
  },

};

export default SweetAlert;
