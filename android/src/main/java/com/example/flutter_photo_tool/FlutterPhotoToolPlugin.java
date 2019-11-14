package com.example.flutter_photo_tool;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import java.io.File;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class FlutterPhotoToolPlugin implements MethodCallHandler {
  Activity activity;
  MethodChannel methodChannel;
  Registrar registrar;

  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_photo_tool");
    channel.setMethodCallHandler(new FlutterPhotoToolPlugin(registrar.activity(), channel, registrar));
  }

  public FlutterPhotoToolPlugin(Activity activity, MethodChannel methodChannel, Registrar registrar) {
    this.activity = activity;
    this.methodChannel = methodChannel;
    this.registrar = registrar;
    this.methodChannel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getRootPath")) {
      String path = Environment.getExternalStorageDirectory().getPath();
      result.success(path);
    } else if (call.method.equals("getPicturesPath")) {
      String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();
      result.success(path);
    } else if (call.method.equals("scanFile")) {
      String path = call.argument("path");
      result.success(scanFile(path));
    } else {
      result.notImplemented();
    }
  }

  private boolean scanFile(String path) {
    try {
      Context context = this.registrar.activeContext().getApplicationContext();
      File file = new File(path);

      Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
      intent.setData(Uri.fromFile(file));
      context.sendBroadcast(intent);
      return true;
    } catch (Exception exception) {
      System.err.println(exception.toString());
      return false;
    }
  }
}
