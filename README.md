# flutter_photo_tool

사진폴더 가져오는거랑
수동 미디어스캔 돌리는거

```dart
Future<String> FlutterPhotoTool.getRootPath();

String path = await FlutterPhotoTool.getRootPath();
print(path); // /storage/sdcard0


Future<String> FlutterPhotoTool.getPicturesPath();

String path = await FlutterPhotoTool.getPicturesPath();
print(path); // /storage/sdcard0/Pictures


Future<void> FlutterPhotoTool.scanFile(String path);

await FlutterPhotoTool.scanFile(path + 'imageName.jpg');
// media scan
```
