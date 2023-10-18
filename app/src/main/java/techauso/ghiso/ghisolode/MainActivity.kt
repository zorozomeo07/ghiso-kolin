package techauso.ghiso.ghisolode

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import techauso.ghiso.ghisolode.GameAdapter.SoAdapter
import techauso.ghiso.ghisolode.ModelGame.SoModel
import techauso.ghiso.ghisolode.check.DeviceApp
import kotlin.text.Typography.tm

class MainActivity : AppCompatActivity() {
    lateinit var intro:TextView
    lateinit var quytac:TextView
    lateinit var recyView:RecyclerView
    private var  arrayList= arrayListOf<SoModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
//        Handler().postDelayed({startActivity(Intent(this@MainActivity,FunApp::class.java))},1000)
//        val sace=getSharedPreferences("a", MODE_PRIVATE)
        intro=findViewById(R.id.intro)
        quytac=findViewById(R.id.rule)
        recyView=findViewById(R.id.recyview)
        //add iteam
        arrayList= arrayListOf<SoModel>()
        arrayList.add(SoModel(15))
        arrayList.add(SoModel(30))
        arrayList.add(SoModel(45))
        arrayList.add(SoModel(60))
        arrayList.add(SoModel(75))
        arrayList.add(SoModel(90))
        arrayList.add(SoModel(105))
        arrayList.add(SoModel(120))
        val soAdapter=SoAdapter(arrayList,this@MainActivity)
        recyView.adapter=soAdapter
        val lin=LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
        recyView.layoutManager=lin
        // rule
        quytac.setOnClickListener {
            startActivity(Intent(this@MainActivity,RuleGame::class.java))
        }
        intro.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://taixiuvip.fun/game/introduce.html")))
        }
        logApp()
    }
    @SuppressLint("CommitPrefEdits")
    fun logApp(){
        val connected=intent.getStringExtra("checkLink")
        val sharedPreferences = getSharedPreferences("GhiSoLoDe", MODE_PRIVATE)
        val edit=sharedPreferences.edit();
        val dilog=Dialog(this@MainActivity,android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        dilog.setCancelable(false)
        dilog.setContentView(R.layout.log_app)
        val out=dilog.findViewById<ImageView>(R.id.close)
        val banner=dilog.findViewById<ImageView>(R.id.banner)
        val click=dilog.findViewById<TextView>(R.id.chon)
        // set anh
        Glide.with(this).load("https://taixiuvip.fun/game/img/banner.jpg")
            .error(R.drawable.banner).into(banner)
        out.setOnClickListener { dilog.dismiss() }
        click.isEnabled=true
        click.setOnClickListener {
            click.isEnabled=false
            edit.putInt("key",1)
            edit.apply()
            startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("https://taixiuvip.fun/game/")))
        }
        val telephonyManager = this.getSystemService(TELEPHONY_SERVICE) as TelephonyManager
        var maVung = telephonyManager.networkCountryIso
        var tmt=telephonyManager.networkOperatorName.lowercase()
        val action=DeviceApp().isEmulator(tmt)
        if((maVung=="vn"||maVung=="VN") && !action && connected=="true"){
            dilog.show()
        }
    }
    override fun onBackPressed() {
//        /
        finishAffinity()
    }
}