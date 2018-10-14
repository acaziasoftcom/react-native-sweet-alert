/**
 * @providesModule RNSweetAlert
 * @flow
 */

'use strict';

import React, { NativeModules } from 'react-native';
import isHex from 'is-hexcolor';

const Native = NativeModules.RNSweetAlert;

const DEFAULT_OPTIONS = {
  title: '',
  subTitle: '',
  confirmButtonTitle: 'OK',
  confirmButtonColor: '#000',
  otherButtonTitle: 'Cancel',
  otherButtonColor: '#dedede',
  style: 'success'
}

const SweetAlert = {
  showAlertWithOptions: (options = DEFAULT_OPTIONS, callback = () => {}) => {
    Native.showAlertWithOptions(options, callback)
  },
  dismissAlert: () => Native.hideSweetAlert(),
};

export default SweetAlert;
