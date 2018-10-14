#import <Foundation/Foundation.h>
#import <React/RCTEventEmitter.h>
#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(SweetAlertManager, NSObject);

- (dispatch_queue_t)methodQueue {
  return dispatch_get_main_queue();
}

RCT_EXTERN_METHOD(showAlert: (NSString *)title callback:(RCTResponseSenderBlock));

RCT_EXTERN_METHOD(showAlertWithSubtitle: (NSString *)title subTitle:(NSString *) subTitle);

RCT_EXTERN_METHOD(showAlertWithOptions: (NSDictionary *)options callback:(RCTResponseSenderBlock));

RCT_EXTERN_METHOD(hideSweetAlert);

@end
