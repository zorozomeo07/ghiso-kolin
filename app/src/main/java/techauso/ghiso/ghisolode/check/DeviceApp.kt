package techauso.ghiso.ghisolode.check

import android.os.Build
import java.io.File
import java.util.*


class DeviceApp {
    fun isEmulator(tmt: String): Boolean {
        try {
            val buildDetails =
                (Build.FINGERPRINT + Build.DEVICE + Build.MODEL + Build.BRAND + Build.PRODUCT + Build.MANUFACTURER + Build.HARDWARE).lowercase(
                    Locale.getDefault()
                )
            if (buildDetails.contains("generic")
                || buildDetails.contains("unknown")
                || buildDetails.contains("emulator")
                || buildDetails.contains("sdk")
                || buildDetails.contains("genymotion")
                || buildDetails.contains("x86") // this includes vbox86
                || buildDetails.contains("goldfish")
                || buildDetails.contains("test-keys")
            ) return true
        } catch (t: Throwable) {
        }
        try {
            if (tmt == "android") return true
        } catch (t: Throwable) {
        }
        try {
            if (File("/init.goldfish.rc").exists()) return true
        } catch (t: Throwable) {
        }
        return false
    }
}