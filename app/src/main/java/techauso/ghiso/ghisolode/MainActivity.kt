package techauso.ghiso.ghisolode

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import techauso.ghiso.ghisolode.GameAdapter.SoAdapter
import techauso.ghiso.ghisolode.ModelGame.SoModel

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
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=DQj-_rXMCZA")))
        }
    }

    override fun onBackPressed() {
//        /
        finishAffinity()
    }
}