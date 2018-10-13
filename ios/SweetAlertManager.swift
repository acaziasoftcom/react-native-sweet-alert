import Foundation

@objc(SweetAlertManager)
class SweetAlertManager: RCTViewManager {
  
  var alert = SweetAlert();
  
  @objc
  func showAlert(_ title: String, callback: RCTResponseSenderBlock) -> Void {
    _ = alert.showAlert(title)
  }
  
  @objc
  func showAlertWithSubtitle(_ title: String, subTitle: String?) -> Void {
    _ = alert.showAlert(title, subTitle: subTitle, style: AlertStyle.none)
  }
  
  @objc
  func hideSweetAlert() -> Void {
    _ = alert.closeAlert(0)
  }
  
  override static func requiresMainQueueSetup() -> Bool {
    return true
  }
}
