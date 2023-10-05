package techauso.ghiso.ghisolode

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import techauso.ghiso.ghisolode.FragmentApp.ChonSo
import techauso.ghiso.ghisolode.FragmentApp.ChonSoNhanh
import techauso.ghiso.ghisolode.FragmentApp.NhapSo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FunApp : AppCompatActivity() {
    lateinit var time:TextView
    lateinit var txtChonSo:TextView
    lateinit var txtNhapSo:TextView
    lateinit var txtChonSoNhanh:TextView

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_fun_app)
        time=findViewById(R.id.dateTime)
        txtChonSo=findViewById(R.id.chonSo)
        txtNhapSo=findViewById(R.id.nhapSo)
        txtChonSoNhanh=findViewById(R.id.chonSoNhanh)
        // set time
        val timeNow= LocalDateTime.now()
        val timeDinhDang=DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val cTime=timeNow.format(timeDinhDang)
        time.text="Ngày: $cTime"
        // set fragment
        val framentChonSo=ChonSo()
        val fragmentNhapSo=NhapSo()
        val fragmentChonSoNhanh=ChonSoNhanh()

        txtChonSo.setOnClickListener {
            Select(txtChonSo,framentChonSo)
        }
        txtNhapSo.setOnClickListener {
            Select(txtNhapSo,fragmentNhapSo)
        }
        txtChonSoNhanh.setOnClickListener {
            Select(txtChonSoNhanh,fragmentChonSoNhanh)
        }
        // fragment khoi dau
        Select(txtChonSo,framentChonSo)
    }
    fun Select(txt:TextView, fagment:Fragment){
        txtChonSo.setBackgroundResource(R.drawable.nut_w1)
        txtNhapSo.setBackgroundResource(R.drawable.nut_w2)
        txtChonSoNhanh.setBackgroundResource(R.drawable.nut_w3)
        // set click
        txt.setBackgroundResource(R.drawable.nut_click)
            // click thay thế fragment

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        // Thay thế fragment hiện tại bằng fragment mới
        fragmentTransaction.replace(R.id.fragmentApp, fagment)
        fragmentTransaction.addToBackStack(null) // Để thêm fragment vào ngăn xếp (tùy chọn)
        fragmentTransaction.commit()

    }

    override fun onBackPressed() {
//        super.onBackPressed()
        startActivity(Intent(this@FunApp,MainActivity::class.java))
    }
}