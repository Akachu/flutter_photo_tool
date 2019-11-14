import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
// import 'package:flutter_photo_tool/flutter_photo_tool.dart';

void main() {
  const MethodChannel channel = MethodChannel('flutter_photo_tool');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    // expect(await FlutterPhotoTool.platformVersion, '42');
  });
}
