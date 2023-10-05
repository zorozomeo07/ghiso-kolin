package techauso.ghiso.ghisolode.FragmentApp

import android.app.Dialog
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import techauso.ghiso.ghisolode.R
import kotlin.random.Random

class NhapSo : Fragment() {
    lateinit var tMon:TextView
    lateinit var txtTime:TextView
    lateinit var txtValue:TextView
    lateinit var Input:EditText
    lateinit var x2:TextView
    lateinit var x3:TextView
    lateinit var x5:TextView
    lateinit var x10:TextView
    lateinit var txt:TextView
    lateinit var start:TextView
    var inumber:Int=0
    var b=2000
    var points=0
    var so:String=""
    var time=0
    var KQ:Int=0
    lateinit var txtAllTime:TextView
    lateinit var shave:SharedPreferences
    lateinit var edits:SharedPreferences.Editor
    // boolean xdat
    private var actionX2: Boolean =true
    private var actionX3: Boolean =true
    private var actionX5: Boolean =true
    private var actionX10: Boolean =true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.frame_nhap_so, container, false)
        // Inflate the layout for this fragme
        tMon=rootView.findViewById(R.id.all)
        txtTime=rootView.findViewById(R.id.times)
        txtValue=rootView.findViewById(R.id.valueNS)
        x2=rootView.findViewById(R.id.x1Dat)
        x3=rootView.findViewById(R.id.x3Dat)
        x5=rootView.findViewById(R.id.x5Dat)
        x10=rootView.findViewById(R.id.x10Dat)
        Input=rootView.findViewById(R.id.inputSo)
        txt=rootView.findViewById(R.id.indexNumber)
        start=rootView.findViewById(R.id.starts)
        txtAllTime=rootView.findViewById(R.id.timeAll)
        txt.visibility=View.INVISIBLE
        txtValue.text="Value: $b"

        // luu
        shave=requireContext().getSharedPreferences("dataGhiso", AppCompatActivity.MODE_PRIVATE)
        edits=shave.edit()
        time=shave.getInt("times",15)
        points=shave.getInt("points",100000)
        tMon.text="All: $points"
        val ts=xuLichuoitime(time)
        txtTime.text="Time: $ts"



        x2.setOnClickListener {
            val a=b*2
            if(points>=a){
                if(actionX2){
                    actionX2=false
                   inumber =2
                    x2.setBackgroundResource(R.drawable.tron_two)
                }else{
                    actionX2=true
                    inumber=1
                    x2.setBackgroundResource(R.drawable.tron_one)

                }
                x3.setBackgroundResource(R.drawable.tron_one)
                x5.setBackgroundResource(R.drawable.tron_one)
                x10.setBackgroundResource(R.drawable.tron_one)
                actionX3=true
                actionX5=true
                actionX10=true

            }else{
                Toast.makeText(requireContext(),"Không đủ points", Toast.LENGTH_SHORT).show()
            }


        }
        x3.setOnClickListener {
            val a=b*3
            if(points>=a){
                if(actionX3){
                    actionX3=false
                    inumber=3
                    x3.setBackgroundResource(R.drawable.tron_two)

                }else{
                    actionX3=true
                    inumber=1
                    x3.setBackgroundResource(R.drawable.tron_one)

                }
                x2.setBackgroundResource(R.drawable.tron_one)
                x5.setBackgroundResource(R.drawable.tron_one)
                x10.setBackgroundResource(R.drawable.tron_one)
                actionX2=true
                actionX5=true
                actionX10=true

            }else{
                Toast.makeText(requireContext(),"Không đủ points", Toast.LENGTH_SHORT).show()
            }



        }
        x5.setOnClickListener {
            val a=5*b
            if(points>=a){
                if(actionX5){
                    actionX5=false
                    inumber=5
                    x5.setBackgroundResource(R.drawable.tron_two)

                }else{
                    actionX5=true
                    inumber=1
                    x5.setBackgroundResource(R.drawable.tron_one)

                }
                x3.setBackgroundResource(R.drawable.tron_one)
                x2.setBackgroundResource(R.drawable.tron_one)
                x10.setBackgroundResource(R.drawable.tron_one)
                actionX3=true
                actionX2=true
                actionX10=true
            } else{
                Toast.makeText(requireContext(),"Không đủ points", Toast.LENGTH_SHORT).show()
            }

        }
        x10.setOnClickListener {
            val a=b*10
            if(points>=a){
                if(actionX10){
                    actionX10=false
                    inumber=10
                    x10.setBackgroundResource(R.drawable.tron_two)

                }else{
                    actionX10=true
                    inumber=1
                    x10.setBackgroundResource(R.drawable.tron_one)

                }
                x3.setBackgroundResource(R.drawable.tron_one)
                x5.setBackgroundResource(R.drawable.tron_one)
                x2.setBackgroundResource(R.drawable.tron_one)
                actionX3=true
                actionX5=true
                actionX2=true
            } else{
                Toast.makeText(requireContext(),"Không đủ points", Toast.LENGTH_SHORT).show()
            }


        }
        start.setOnClickListener {
            so=Input.text.toString()
            if(so==""){
                Toast.makeText(requireContext(),"Bạn cần chọn số !",Toast.LENGTH_SHORT).show()
            }else{
                chon(false)
                start.setBackgroundResource(R.drawable.start_iconx)

                val countime = object : CountDownTimer(time.toLong()*1000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        var T_giay = millisUntilFinished /1000
                        var a=T_giay.toInt()
                        val b=xuLichuoitime(a)
                        txtTime.text = "Time: $b"
                    }

                    override fun onFinish() {
                        KQ= Random.nextInt(0,100)
                        txtAllTime.visibility=View.VISIBLE
                        Handler().postDelayed({
                            txtAllTime.visibility=View.INVISIBLE
                            logA()

                        },300)
                    }

                }
                countime.start()
            }
            points=shave.getInt("points", 0)
            if(points<2000){
                edits.putInt("points", 100000)
                edits.apply()
            }

        }


        return rootView
    }
    fun logA(){
        var dilog= Dialog(requireContext())
        dilog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dilog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dilog.setCancelable(false)
        dilog.setContentView(R.layout.dilog_app)
        var txt1=dilog.findViewById<TextView>(R.id.suiKQ)
        var txt2=dilog.findViewById<TextView>(R.id.suiAllSoChon)
        var txt3=dilog.findViewById<TextView>(R.id.suiSoTrung)
        var txt4=dilog.findViewById<TextView>(R.id.out)
        txt1.text="Kết Quả\n$KQ"
        txt2.text="Số bạn chọn\n$so"
        var id=so.toInt()
        if(id==KQ){
            txt3.text="Bạn chọn đúng đó - chúc mừng"
        }else{
            txt3.text="Số chưa chính xác - Chúc may mắn lần sau"
        }
        txt4.setOnClickListener {

            if(id==KQ){
                points+= kotlin.math.abs(70 * inumber*b)
                edits.putInt("points",points)
                edits.apply()
            }else{
                points-= b*inumber
                tMon.text="All: $points"
                edits.putInt("points",points)
                edits.apply()
            }
            chon(true)
            dilog.dismiss()
            start.setBackgroundResource(R.drawable.start_icon)

        }
        dilog.show()
    }
    fun xuLichuoitime(time:Int):String{
        val minutes = (time % 3600) / 60
        val remainingSeconds = time % 60

        return String.format("%02d:%02d",  minutes, remainingSeconds)
    }
    fun chon(actionA:Boolean){
        x2.isEnabled=actionA
        x3.isEnabled=actionA
        x5.isEnabled=actionA
        x10.isEnabled=actionA
        start.isEnabled=actionA
    }
}