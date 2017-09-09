/**
 * @providesModule RNSweetAlert
 * @flow
 */
'use strict';

import React, { NativeModules } from 'react-native';

const SweetAlert = {
  showAlert: (data, acceptCallback, cancelCallback) => NativeModules.RNSweetAlert.showSweetAlert(data, acceptCallback, cancelCallback),
  dismissAlert: () => NativeModules.RNSweetAlert.hideSweetAlert(),
  changeAlertType: (type) => NativeModules.RNSweetAlert.changeAlertType(type),
};

export default SweetAlert;
