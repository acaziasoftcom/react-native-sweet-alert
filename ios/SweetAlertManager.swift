import Foundation

@objc(SweetAlertManager)
class SweetAlertManager: RCTViewManager {
    var alert = SweetAlert()

    @objc
    func showAlert(_ title: String, callback: RCTResponseSenderBlock) {
        _ = alert.showAlert(title)
    }

    @objc
    func showAlertWithOptions(_ options: NSDictionary, callback: @escaping RCTResponseSenderBlock) {
        let title: String = options.object(forKey: "title") as! String
        let subTitle: String = options.object(forKey: "subTitle") as! String
        let confirmButtonTitle: String = options.object(forKey: "confirmButtonTitle") as! String
        let confirmButtonColor: String = options.object(forKey: "confirmButtonColor") as! String
        
        let otherButtonTitle: String = options.object(forKey: "otherButtonTitle") as! String
        let otherButtonColor: String = options.object(forKey: "otherButtonColor") as! String

        // error none success warning
        let style: String = options.object(forKey: "style") as! String
        var convertedStyle = AlertStyle.none

        switch style {
        case "error":
            convertedStyle = AlertStyle.error
            break
        case "success":
            convertedStyle = AlertStyle.success
            break
        case "warning":
            convertedStyle = AlertStyle.warning
            break
        default:
            convertedStyle = AlertStyle.none
        }

        _ = alert.showAlert(title, subTitle: subTitle, style: convertedStyle, buttonTitle: confirmButtonTitle, buttonColor: hexStringToUIColor(hex: confirmButtonColor), otherButtonTitle: otherButtonTitle, otherButtonColor: hexStringToUIColor(hex: otherButtonColor), action: { (isOtherButton: Bool) in
            // True == isOtherButton.
            callback([isOtherButton, isOtherButton])
        })
    }

    @objc
    func hideSweetAlert() {
        _ = alert.closeAlert(0)
    }
    
    func hexStringToUIColor (hex: String) -> UIColor {
        var cString:String = hex.trimmingCharacters(in: .whitespacesAndNewlines).uppercased()
        
        if (cString.hasPrefix("#")) {
            cString.remove(at: cString.startIndex)
        }
        
        if ((cString.count) != 6) {
            return UIColor.gray
        }
        
        var rgbValue:UInt32 = 0
        Scanner(string: cString).scanHexInt32(&rgbValue)
        
        return UIColor(
            red: CGFloat((rgbValue & 0xFF0000) >> 16) / 255.0,
            green: CGFloat((rgbValue & 0x00FF00) >> 8) / 255.0,
            blue: CGFloat(rgbValue & 0x0000FF) / 255.0,
            alpha: CGFloat(1.0)
        )
    }

    override class func requiresMainQueueSetup() -> Bool {
        return true
    }
}
