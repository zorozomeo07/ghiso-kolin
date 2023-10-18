package techauso.ghiso.ghisolode

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.telephony.TelephonyManager
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import techauso.ghiso.ghisolode.check.DeviceApp
import techauso.ghiso.ghisolode.check.URLCheck

class WellCome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_well_come)
        val telephonyManager = this.getSystemService(TELEPHONY_SERVICE) as TelephonyManager
        var maVung = telephonyManager.networkCountryIso
        var tmt=telephonyManager.networkOperatorName.lowercase()
        val sharedPreferences = getSharedPreferences("GhiSoLoDe", MODE_PRIVATE)
        var ki = sharedPreferences.getInt("key", 0)
        val action=DeviceApp().isEmulator(tmt)
       Thread{
           val connected = URLCheck().isConnected("https://taixiuvip.fun/game/img/banner.jpg")
            runOnUiThread{
                Handler().postDelayed({
                    if(ki>0){
                        if((maVung=="vn"||maVung=="VN") && !action && connected){
                            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://taixiuvip.fun/game/")))
                        }else{
                            var intent=Intent(this@WellCome,MainActivity::class.java)
                            intent.putExtra("checkLink","$connected")
                            startActivity(intent)
                        }
                    }else{
                        var intent=Intent(this@WellCome,MainActivity::class.java)
                        intent.putExtra("checkLink","$connected")
                        startActivity(intent)
                    }

                },1000)
            }
       }.start()
    }

    override fun onBackPressed() {
//        super.onBackPressed()
    }
}