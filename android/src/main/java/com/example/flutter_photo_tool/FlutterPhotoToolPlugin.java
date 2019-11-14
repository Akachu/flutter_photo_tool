package com.example.flutter_photo_tool;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import android.os.Environment;

/** FlutterPhotoToolPlugin */
public class FlutterPhotoToolPlugin implements MethodCallHandler {
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_photo_tool");
    channel.setMethodCallHandler(new FlutterPhotoToolPlugin());
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getRootPath")) {
      String path = Environment.getExternalStorageDirectory().getPath();
      result.success(path);
    } else if (call.method.equals("getPicturesPath")) {
      String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();
      result.success(path);
    } else {
      result.notImplemented();
    }
  }
}
