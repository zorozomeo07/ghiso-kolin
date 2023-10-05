package techauso.ghiso.ghisolode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class WellCome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_well_come)
        Handler().postDelayed({
             val intent= Intent(this@WellCome,MainActivity::class.java)
            startActivity(intent)
        },1000)
    }

    override fun onBackPressed() {
//        super.onBackPressed()
    }
}