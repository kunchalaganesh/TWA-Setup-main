package com.skillclash.twa_setup

import io.flutter.embedding.android.FlutterFragmentActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant
import android.content.Intent
import android.net.Uri
import androidx.annotation.NonNull
import android.os.Bundle
import com.google.androidbrowserhelper.trusted.LauncherActivity

// TODO Step 7
class MainActivity: FlutterFragmentActivity() {

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
            // Note: this method is invoked on the main thread.
            call, result ->
            when (call.method) {
                "openTWA" -> {
                    launchTWA()
                }
            }
        }
    }

    companion object {
        private const val CHANNEL = "method_channel/twa"
    }

    private fun launchTWA() {
        // TODO STEP 8
        // Create an intent and add the url to open as data in it
        // Open TWA Launcher Activity
        val intent = Intent(this, LauncherActivity::class.java)
        intent.data = Uri.parse("https://skillclash.com")
        startActivity(intent)
    }
}

// TODO STEP 6
// Head over to https://developers.google.com/digital-asset-links/tools/generator and generate your
// Asset Links. You need to add package name of your app (in this case: com.gamezop.twa_setup),
// SHA256 fingerprint (which you can generate using this link:
// https://developer.android.com/studio/publish/app-signing#generate-key and the website you are
// opening (in this case: https://gamezop.com)
// The asset links generate you will need to host on your website at the location that is specified
// when you generate the Asset Links
// Which will look like this:
// [{
//   "relation": ["delegate_permission/common.handle_all_urls"],
//      "target" : { "namespace": "android_app", "package_name": "com.gamezop.twa_setup",
//                   "sha256_cert_fingerprints": ["14:6D:E9:83:C5:73:06:50:D8:EE:B9:95:2F:34:FC:64:16:A0:83:42:E6:1D:BE:A8:8A:04:96:B2:3F:CF:44:E5"] }
// }]
// Post statement file at https://gamezop.com/.well-known/assetlinks.json.
