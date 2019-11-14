#import "FlutterPhotoToolPlugin.h"
#import <flutter_photo_tool/flutter_photo_tool-Swift.h>

@implementation FlutterPhotoToolPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterPhotoToolPlugin registerWithRegistrar:registrar];
}
@end
