/**
 * @providesModule RNSweetAlert
 * @flow
 */
'use strict';

import React, { NativeModules } from 'react-native';

const SweetAlert = {
  showAlert: (data) => NativeModules.RNSweetAlert.showSweetAlert(data),
  dismissAlert: () => NativeModules.RNSweetAlert.hideSweetAlert(),
  changeAlertType: (type) => NativeModules.RNSweetAlert.changeAlertType(type),
};

export default SweetAlert;
