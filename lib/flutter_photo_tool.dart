import 'dart:async';

import 'package:flutter/services.dart';

class FlutterPhotoTool {
  static const MethodChannel _channel =
      const MethodChannel('flutter_photo_tool');

  static Future<String> getRootPath() async {
    final String version = await _channel.invokeMethod('getRootPath');
    return version;
  }

  static Future<String> getPicturesPath() async {
    final String version = await _channel.invokeMethod('getPicturesPath');
    return version;
  }

  static Future<void> scanFile(String path) async {
    await _channel.invokeMethod('scanFile', {
      'path': path,
    });
  }
}
