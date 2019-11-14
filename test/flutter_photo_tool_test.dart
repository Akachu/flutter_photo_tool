import 'package:flutter/services.dart';
import 'package:flutter_photo_tool/flutter_photo_tool.dart';
import 'package:flutter_test/flutter_test.dart';
// import 'package:flutter_photo_tool/flutter_photo_tool.dart';

void main() {
  const MethodChannel channel = MethodChannel('flutter_photo_tool');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return methodCall.toString();
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('scanFile', () async {
    await FlutterPhotoTool.scanFile('path');
  });
}
