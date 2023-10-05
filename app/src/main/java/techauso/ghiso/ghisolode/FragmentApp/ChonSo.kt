package techauso.ghiso.ghisolode.FragmentApp

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import techauso.ghiso.ghisolode.R
import java.lang.Math.abs
import kotlin.random.Random

class ChonSo : Fragment() {

    //all
    lateinit var allC:TextView
    lateinit var allD:TextView
    // tai
    lateinit var taiC:TextView
    lateinit var taiD:TextView
    //xiu
    lateinit var xiuD:TextView
    lateinit var xiuC:TextView
    //le
    lateinit var leC:TextView
    lateinit var leD:TextView
    //chan
    lateinit var chanC:TextView
    lateinit var chanD:TextView
    //xoa
    lateinit var xoaC:TextView
    lateinit var xoaD:TextView
    lateinit var timeAll:TextView
    // biến tiền , time
    var time=0
    var points=0
    var soAB=0
    // txt biến
    lateinit var allMoney:TextView
    lateinit var  txtTimes:TextView
    // dăt
    lateinit var x1:TextView
    lateinit var x3:TextView
    lateinit var x5:TextView
    lateinit var x10:TextView

    // số chọn hàng chẵn
    lateinit var C0:TextView
    lateinit var C1:TextView
    lateinit var C2:TextView
    lateinit var C3:TextView
    lateinit var C4:TextView
    lateinit var C5:TextView
    lateinit var C6:TextView
    lateinit var C7:TextView
    lateinit var C8:TextView
    lateinit var C9:TextView

    // sô chọn hang donVi
    lateinit var D0:TextView
    lateinit var D1:TextView
    lateinit var D2:TextView
    lateinit var D3:TextView
    lateinit var D4:TextView
    lateinit var D5:TextView
    lateinit var D6:TextView
    lateinit var D7:TextView
    lateinit var D8:TextView
    lateinit var D9:TextView
    lateinit var allSo:TextView
    lateinit var start:TextView
    // bien luu data
    lateinit var shave:SharedPreferences
    lateinit var edistA:SharedPreferences.Editor
    //arraylist
    private var  arrayListChuc= arrayListOf<Int>()
    private var arrayListDonVi= arrayListOf<Int>()
    private  var arrayAll= mutableListOf<Int>()
    private  var resultsArray= mutableListOf<Int>()
    private  var commonValues = mutableListOf<Int>()
    // boolean hàng chuc
    private var actionC0: Boolean =true
    private var actionC1: Boolean =true
    private var actionC2: Boolean =true
    private var actionC3: Boolean =true
    private var actionC4: Boolean =true
    private var actionC5: Boolean =true
    private var actionC6: Boolean =true
    private var actionC7: Boolean =true
    private var actionC8: Boolean =true
    private var actionC9: Boolean =true

    // boolean hang don vi
    private var actionD0: Boolean =true
    private var actionD1: Boolean =true
    private var actionD2: Boolean =true
    private var actionD3: Boolean =true
    private var actionD4: Boolean =true
    private var actionD5: Boolean =true
    private var actionD6: Boolean =true
    private var actionD7: Boolean =true
    private var actionD8: Boolean =true
    private var actionD9: Boolean =true
    // boolean xdat
    private var actionX1: Boolean =true
    private var actionX3: Boolean =true
    private var actionX5: Boolean =true
    private var actionX10: Boolean =true
    var inumber:Int=0


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.frame_chon_so, container, false)
        // Inflate the layout for this fragme
        // all
        allC=rootView.findViewById(R.id.allC)
        allD=rootView.findViewById(R.id.allD)
        // tai
        taiC=rootView.findViewById(R.id.TaiC)
        taiD=rootView.findViewById(R.id.TaiD)
        //xiu
        xiuC=rootView.findViewById(R.id.XiuC)
        xiuD=rootView.findViewById(R.id.XiuD)
        //le
        leC=rootView.findViewById(R.id.LeC)
        leD=rootView.findViewById(R.id.LeD)
        //chan
        chanC=rootView.findViewById(R.id.ChanC)
        chanD=rootView.findViewById(R.id.ChanD)
        //xoa
        xoaC=rootView.findViewById(R.id.XóaC)
        xoaD=rootView.findViewById(R.id.XóaD)

        // dat
        x1=rootView.findViewById(R.id.x1Dat)
        x3=rootView.findViewById(R.id.x3Dat)
        x5=rootView.findViewById(R.id.x5Dat)
        x10=rootView.findViewById(R.id.x10Dat)
        // all money , time
        allMoney=rootView.findViewById(R.id.all)
        txtTimes=rootView.findViewById(R.id.times)
        timeAll=rootView.findViewById(R.id.timeAll)

        // so hang chăn

        C0=rootView.findViewById(R.id.txt0C)
        C1=rootView.findViewById(R.id.txt1C)
        C2=rootView.findViewById(R.id.txt2C)
        C3=rootView.findViewById(R.id.txt3C)
        C4=rootView.findViewById(R.id.txt4C)
        C6=rootView.findViewById(R.id.txt6C)
        C5=rootView.findViewById(R.id.txt5C)
        C7=rootView.findViewById(R.id.txt7C)
        C8=rootView.findViewById(R.id.txt8C)
        C9=rootView.findViewById(R.id.txt9C)

        // so hang donvi

        D0=rootView.findViewById(R.id.txt0D)
        D1=rootView.findViewById(R.id.txt1D)
        D2=rootView.findViewById(R.id.txt2D)
        D3=rootView.findViewById(R.id.txt3D)
        D4=rootView.findViewById(R.id.txt4D)
        D6=rootView.findViewById(R.id.txt6D)
        D5=rootView.findViewById(R.id.txt5D)
        D7=rootView.findViewById(R.id.txt7D)
        D8=rootView.findViewById(R.id.txt8D)
        D9=rootView.findViewById(R.id.txt9D)

        // all soo, start
        allSo=rootView.findViewById(R.id.indexNumber)
        start=rootView.findViewById(R.id.starts)

        // luu
        shave=requireContext().getSharedPreferences("dataGhiso", AppCompatActivity.MODE_PRIVATE)
        edistA=shave.edit()
        // tien , time
        time=shave.getInt("times",15)
        points=shave.getInt("points",100000)
        allMoney.text="All: $points"
        val ts=xuLichuoitime(time)
        txtTimes.text="Time: $ts"

        // xu li all so lo
        // all so
        if(arrayListChuc.size==0 || arrayListDonVi.size==0){
            var soB=0
            allSo.text="Đã chọn: $soB số"
        }
        inumber=1


        ///***
//        click(C0,actionC0)
        arrayListChuc= arrayListOf()
        arrayListDonVi= arrayListOf()
        arrayAll= mutableListOf()
        resultsArray= mutableListOf()
        commonValues= mutableListOf()
        resultsArray.clear()
        arrayListChuc.clear()
        arrayListDonVi.clear()
        arrayAll.clear()
        commonValues.clear()

        //chon so
        choChon(true)

        // Hang chục
        allC.setOnClickListener {
            SelctOptionLe(allC,"Chuc")
            AllA("Chuc")
            So()
        }
        taiC.setOnClickListener {
            SelctOptionLe(taiC,"Chuc")
            TaiA("Chuc")
            So()

        }
        xiuC.setOnClickListener {
            SelctOptionLe(xiuC,"Chuc")
            XiuA("Chuc")
            So()
        }

        leC.setOnClickListener { SelctOptionLe(leC,"Chuc")
            LeA("Chuc")
            So()

        }
        chanC.setOnClickListener {
            SelctOptionLe(chanC,"Chuc")
            ChanA("Chuc")
            So()
        }
        // hang don vi
        allD.setOnClickListener {
            SelctOptionLe(allD,"Dv")
            AllA("Dv")
            So()

        }
        taiD.setOnClickListener {
            SelctOptionLe(taiD,"Dv")
            TaiA("Dv")
            So()
        }
        xiuD.setOnClickListener {
            SelctOptionLe(xiuD,"Dv")
            XiuA("Dv")
            So()
        }
        leD.setOnClickListener {
            SelctOptionLe(leD,"Dv")
            LeA("Dv")
            So()
        }
        chanD.setOnClickListener {
            SelctOptionLe(chanD,"Dv")
            ChanA("Dv")
            So()
        }



        xoaD.setOnClickListener {
            allD.setBackgroundResource(R.drawable.t1)
            taiD.setBackgroundResource(R.drawable.t1)
            xiuD.setBackgroundResource(R.drawable.t1)
            leD.setBackgroundResource(R.drawable.t1)
            chanD.setBackgroundResource(R.drawable.t1)
            XoaA("Dv")
            var soB=0
            allSo.text="Đã chọn: $soB số"
        }
        xoaC.setOnClickListener {
            allC.setBackgroundResource(R.drawable.t1)
            taiC.setBackgroundResource(R.drawable.t1)
            xiuC.setBackgroundResource(R.drawable.t1)
            leC.setBackgroundResource(R.drawable.t1)
            chanC.setBackgroundResource(R.drawable.t1)
            XoaA("Chuc")
            var soB=0
            allSo.text="Đã chọn: $soB số"
        }

        // số hang Chuc
        C0.setOnClickListener {
            if(actionC0){
                actionC0=false
                C0.setBackgroundResource(R.drawable.tron_two)
                arrayListChuc.add(0)
                So()
            }else{
                actionC0=true
                C0.setBackgroundResource(R.drawable.tron_one)
                arrayListChuc.remove(0)
                So()

            }
            Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")

        }
        C1.setOnClickListener {
            if(actionC1){
                actionC1=false
                C1.setBackgroundResource(R.drawable.tron_two)
                arrayListChuc.add(1)
                So()
            }else{
                actionC1=true
                C1.setBackgroundResource(R.drawable.tron_one)
                arrayListChuc.remove(1)
                So()
            }
            Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")

        }
        C3.setOnClickListener {
            if(actionC3){
                actionC3=false
                C3.setBackgroundResource(R.drawable.tron_two)
                arrayListChuc.add(3)
                So()
            }else{
                actionC3=true
                C3.setBackgroundResource(R.drawable.tron_one)
                arrayListChuc.remove(3)
                So()
            }
            Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")

        }
        C4.setOnClickListener {
            if(actionC4){
                actionC4=false
                C4.setBackgroundResource(R.drawable.tron_two)
                arrayListChuc.add(4)
                So()
            }else{
                actionC4=true
                C4.setBackgroundResource(R.drawable.tron_one)
                arrayListChuc.remove(4)
                So()
            }
            Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")

        }
        C5.setOnClickListener {
            if(actionC5){
                actionC5=false
                C5.setBackgroundResource(R.drawable.tron_two)
                arrayListChuc.add(5)
                So()
            }else{
                actionC5=true
                C5.setBackgroundResource(R.drawable.tron_one)
                arrayListChuc.remove(5)
                So()
            }
            Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")

        }
        C6.setOnClickListener {
            if(actionC6){
                actionC6=false
                C6.setBackgroundResource(R.drawable.tron_two)
                arrayListChuc.add(6)
                So()
            }else{
                actionC6=true
                C6.setBackgroundResource(R.drawable.tron_one)
                arrayListChuc.remove(6)
                So()
            }
            Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")

        }
        C7.setOnClickListener {
            if(actionC7){
                actionC7=false
                C7.setBackgroundResource(R.drawable.tron_two)
                arrayListChuc.add(7)
                So()
            }else{
                actionC7=true
                C7.setBackgroundResource(R.drawable.tron_one)
                arrayListChuc.remove(7)
                So()
            }
            Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")


        }
        C8.setOnClickListener {
            if(actionC8){
                actionC8=false
                C8.setBackgroundResource(R.drawable.tron_two)
                arrayListChuc.add(8)
                So()
            }else{
                actionC8=true
                C8.setBackgroundResource(R.drawable.tron_one)
                arrayListChuc.remove(8)
                So()
            }
            Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")

        }
        C9.setOnClickListener {
            if(actionC9){
                actionC9=false
                C9.setBackgroundResource(R.drawable.tron_two)
                arrayListChuc.add(9)
                So()
            }else{
                actionC9=true
                C9.setBackgroundResource(R.drawable.tron_one)
                arrayListChuc.remove(9)
                So()
            }
            Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")

        }
        C2.setOnClickListener {
            if(actionC2){
                actionC2=false
                C2.setBackgroundResource(R.drawable.tron_two)
                arrayListChuc.add(2)
                So()
            }else{
                actionC2=true
                C2.setBackgroundResource(R.drawable.tron_one)
                arrayListChuc.remove(2)
                So()
            }
            Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")

        }


        // sô hang don vi
        D0.setOnClickListener {

            if(actionD0){
                actionD0=false
                D0.setBackgroundResource(R.drawable.tron_two)
                arrayListDonVi.add(0)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }else{
                actionD0=true
                D0.setBackgroundResource(R.drawable.tron_one)
                arrayListDonVi.remove(0)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }
        }
        D1.setOnClickListener {
            if(actionD1){
                actionD1=false
                D1.setBackgroundResource(R.drawable.tron_two)
                arrayListDonVi.add(1)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }else{
                actionD1=true
                D1.setBackgroundResource(R.drawable.tron_one)
                arrayListDonVi.remove(1)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }
        }
        D2.setOnClickListener {
            if(actionD2){
                actionD2=false
                D2.setBackgroundResource(R.drawable.tron_two)
                arrayListDonVi.add(2)
                So()

                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }else{
                actionD2=true
                D2.setBackgroundResource(R.drawable.tron_one)
                arrayListDonVi.remove(2)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }
        }
        D3.setOnClickListener {
            if(actionD3){
                actionD3=false
                D3.setBackgroundResource(R.drawable.tron_two)
                arrayListDonVi.add(3)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }else{
                actionD3=true
                D3.setBackgroundResource(R.drawable.tron_one)
                arrayListDonVi.remove(3)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }
        }
        D4.setOnClickListener {
            if(actionD4){
                actionD4=false
                D4.setBackgroundResource(R.drawable.tron_two)
                arrayListDonVi.add(4)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }else{
                actionD4=true
                D4.setBackgroundResource(R.drawable.tron_one)
                arrayListDonVi.remove(4)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }
        }
        D5.setOnClickListener {
            if(actionD5){
                actionD5=false
                D5.setBackgroundResource(R.drawable.tron_two)
                arrayListDonVi.add(5)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }else{
                actionD5=true
                D5.setBackgroundResource(R.drawable.tron_one)
                arrayListDonVi.remove(5)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }
        }
        D6.setOnClickListener {
            if(actionD6){
                actionD6=false
                D6.setBackgroundResource(R.drawable.tron_two)
                arrayListDonVi.add(6)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }else{
                actionD6=true
                D6.setBackgroundResource(R.drawable.tron_one)
                arrayListDonVi.remove(6)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }
        }
        D7.setOnClickListener {
            if(actionD7){
                actionD7=false
                D7.setBackgroundResource(R.drawable.tron_two)
                arrayListDonVi.add(7)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }else{
                actionD7=true
                D7.setBackgroundResource(R.drawable.tron_one)
                arrayListDonVi.remove(7)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }
        }
        D8.setOnClickListener {
            if(actionD8){
                actionD8=false
                D8.setBackgroundResource(R.drawable.tron_two)
                arrayListDonVi.add(8)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }else{
                actionD8=true
                D8.setBackgroundResource(R.drawable.tron_one)
                arrayListDonVi.remove(8)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }
        }
        D9.setOnClickListener {
            if(actionD9){
                actionD9=false
                D9.setBackgroundResource(R.drawable.tron_two)
                arrayListDonVi.add(9)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }else{
                actionD9=true
                D9.setBackgroundResource(R.drawable.tron_one)
                arrayListDonVi.remove(9)
                So()
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            }
        }
        Log.d("checkMANGC","${arrayListChuc.size}  ads $arrayListChuc")
        Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
        // x dat
        x1.setOnClickListener {
            val a=soAB*2000
            if(points>=a){
                if(actionX1){
                    actionX1=false
                    inumber=2
                    x1.setBackgroundResource(R.drawable.tron_two)

                }else{
                    actionX1=true
                    inumber=1
                    x1.setBackgroundResource(R.drawable.tron_one)

                }
                x3.setBackgroundResource(R.drawable.tron_one)
                x5.setBackgroundResource(R.drawable.tron_one)
                x10.setBackgroundResource(R.drawable.tron_one)
                actionX3=true
                actionX5=true
                actionX10=true

            }else{
                Toast.makeText(requireContext(),"Không đủ points",Toast.LENGTH_SHORT).show()
            }


        }
        x3.setOnClickListener {
            val a=soAB*3000
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
                x1.setBackgroundResource(R.drawable.tron_one)
                x5.setBackgroundResource(R.drawable.tron_one)
                x10.setBackgroundResource(R.drawable.tron_one)
                actionX1=true
                actionX5=true
                actionX10=true

            }else{
                Toast.makeText(requireContext(),"Không đủ points",Toast.LENGTH_SHORT).show()
            }



        }
        x5.setOnClickListener {
            val a=soAB*5000
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
                x1.setBackgroundResource(R.drawable.tron_one)
                x10.setBackgroundResource(R.drawable.tron_one)
                actionX3=true
                actionX1=true
                actionX10=true
            } else{
            Toast.makeText(requireContext(),"Không đủ points",Toast.LENGTH_SHORT).show()
            }

        }
        x10.setOnClickListener {
            val a=soAB*5000
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
                x1.setBackgroundResource(R.drawable.tron_one)
                actionX3=true
                actionX5=true
                actionX1=true
            } else{
                Toast.makeText(requireContext(),"Không đủ points",Toast.LENGTH_SHORT).show()
            }


        }


        start.setOnClickListener {
            if (arrayListChuc.size == 0 || arrayListDonVi.size == 0) {
                Toast.makeText(requireContext(), "Vui Long chọn số", Toast.LENGTH_SHORT).show()
            } else {
                if (arrayListDonVi.size == 1 && arrayListChuc.size == 1) {
                    var a = arrayListChuc[0] * 10 + arrayListDonVi[0]
                    arrayAll.add(a)
                } else if (arrayListChuc.size == 1) {
                    arrayAll.clear()
                    for (i in 0 until arrayListDonVi.size) {
                        var a = arrayListChuc[0] * 10 + arrayListDonVi[i]
                        arrayAll.add(a)
                    }
                } else if (arrayListDonVi.size == 1) {
                    arrayAll.clear()
                    for (i in 0 until arrayListChuc.size) {
                        var a = arrayListChuc[i] * 10 + arrayListDonVi[0]
                        arrayAll.add(a)
                    }

                } else {
                    arrayAll.clear()
                    for (i in 0 until arrayListChuc.size) {
                        for (j in 0 until arrayListDonVi.size) {
                            var a = arrayListChuc[i] * 10 + arrayListDonVi[j]
                            arrayAll.add(a)

                        }
                    }
                }
            }
            Log.d("Datta", "$arrayAll")
//            val minutes = (time % 3600) / 60
//            val remainingSeconds = time % 60
//
//            return String.format("%02d:%02d",  minutes, remainingSeconds)
            choChon(false)
            start.setBackgroundResource(R.drawable.start_iconx)


            val countime = object : CountDownTimer(time.toLong()*1000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    var T_giay = millisUntilFinished /1000
                    var a=T_giay.toInt()
                    val b=xuLichuoitime(a)
                    txtTimes.text = "Time: $b"
                }

                override fun onFinish() {

                    repeat(5){
                        val random=Random.nextInt(1,100)
                        resultsArray.add(random)
                    }



                    for (value in resultsArray) {
                        if (value in arrayAll && value !in commonValues) {
                            commonValues.add(value)
                        }
                    }
                    Log.d("ketQuarAB","$resultsArray")
                    Log.d("ketAAB","$commonValues")
                    timeAll.visibility=View.VISIBLE
                    Handler().postDelayed({
                        timeAll.visibility=View.INVISIBLE
                         logA()

                    },300)
                }

            }
            countime.start()
        }
        points=shave.getInt("points", 0)
        if(points<2000){
            edistA.putInt("points", 100000)
            edistA.apply()
        }

        return rootView
    }
    fun logA(){
        var dilog=Dialog(requireContext())
        dilog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dilog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dilog.setCancelable(false)
        dilog.setContentView(R.layout.dilog_app)
        var txt1=dilog.findViewById<TextView>(R.id.suiKQ)
        var txt2=dilog.findViewById<TextView>(R.id.suiAllSoChon)
        var txt3=dilog.findViewById<TextView>(R.id.suiSoTrung)
        var txt4=dilog.findViewById<TextView>(R.id.out)
        txt1.text="Kết Quả\n$resultsArray"
        txt2.text="Số bạn chọn\n$arrayAll"
        if(commonValues.size>0){
            txt3.text="Số trùng ${commonValues.size}:\n$commonValues"
        }else{
            txt3.text="Không có số trùng"
        }
        txt4.setOnClickListener {
            if(commonValues.size>0) {
                val tien = 70000 * inumber * commonValues.size
                points += tien
                allMoney.text = "All: $points"
                edistA.putInt("points", points)
                edistA.apply()
            }else{
                soAB=arrayListChuc.size * arrayListDonVi.size
                points-= kotlin.math.abs(soAB * 1000 * inumber)
                allMoney.text="All: $points"
                edistA.putInt("points",points)
                edistA.apply()
            }
            choChon(true)
            XoaA("Chuc")
            XoaA("Dv")
            resultsArray.clear()
            arrayListChuc.clear()
            arrayListDonVi.clear()
            arrayAll.clear()
            commonValues.clear()
            So()

            dilog.dismiss()
            start.setBackgroundResource(R.drawable.start_icon)

        }
        dilog.show()
    }
    fun choChon( action:Boolean){
        // hàng chẵn
        allC.isEnabled=action
        taiC.isEnabled=action
        xiuC.isEnabled=action
        leC.isEnabled=action
        chanC.isEnabled=action
        xiuC.isEnabled=action
        C0.isEnabled=action
        C1.isEnabled=action
        C2.isEnabled=action
        C3.isEnabled=action
        C4.isEnabled=action
        C5.isEnabled=action
        C6.isEnabled=action
        C7.isEnabled=action
        C8.isEnabled=action
        C9.isEnabled=action
        // hang don vi
        allD.isEnabled=action
        taiD.isEnabled=action
        xiuD.isEnabled=action
        leD.isEnabled=action
        chanD.isEnabled=action
        xiuD.isEnabled=action
        D0.isEnabled=action
        D1.isEnabled=action
        D2.isEnabled=action
        D3.isEnabled=action
        D4.isEnabled=action
        D5.isEnabled=action
        D6.isEnabled=action
        D7.isEnabled=action
        D8.isEnabled=action
        D9.isEnabled=action
        // hang đat
        x1.isEnabled=action
        x3.isEnabled=action
        x5.isEnabled=action
        x10.isEnabled=action
        // start
        start.isEnabled=action
    }
    fun So(){
        soAB=arrayListChuc.size * arrayListDonVi.size
        allSo.text="Đã chọn: $soAB số"
        Log.d("SốD","$soAB")

    }
    fun SelctOptionLe(text:TextView,ten:String){
       if(ten=="Chuc"){
           allC.setBackgroundResource(R.drawable.t1)
           taiC.setBackgroundResource(R.drawable.t1)
           xiuC.setBackgroundResource(R.drawable.t1)
           leC.setBackgroundResource(R.drawable.t1)
           chanC.setBackgroundResource(R.drawable.t1)
           text.setBackgroundResource(R.drawable.t2)
       }else if(ten=="Dv"){
           allD.setBackgroundResource(R.drawable.t1)
           taiD.setBackgroundResource(R.drawable.t1)
           xiuD.setBackgroundResource(R.drawable.t1)
           leD.setBackgroundResource(R.drawable.t1)
           chanD.setBackgroundResource(R.drawable.t1)
           text.setBackgroundResource(R.drawable.t2)
       }
    }

    fun AllA(ten:String){
        if(ten=="Chuc"){
            actionC0=false
            actionC1=false
            actionC2=false
            actionC3=false
            actionC4=false
            actionC5=false
            actionC6=false
            actionC7=false
            actionC8=false
            actionC9=false
            arrayListChuc.clear()
            arrayListChuc.add(0)
            arrayListChuc.add(1)
            arrayListChuc.add(2)
            arrayListChuc.add(3)
            arrayListChuc.add(4)
            arrayListChuc.add(5)
            arrayListChuc.add(6)
            arrayListChuc.add(7)
            arrayListChuc.add(8)
            arrayListChuc.add(9)
            Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")


            C0.setBackgroundResource(R.drawable.tron_two)
            C1.setBackgroundResource(R.drawable.tron_two)
            C2.setBackgroundResource(R.drawable.tron_two)
            C3.setBackgroundResource(R.drawable.tron_two)
            C4.setBackgroundResource(R.drawable.tron_two)
            C5.setBackgroundResource(R.drawable.tron_two)
            C6.setBackgroundResource(R.drawable.tron_two)
            C7.setBackgroundResource(R.drawable.tron_two)
            C8.setBackgroundResource(R.drawable.tron_two)
            C9.setBackgroundResource(R.drawable.tron_two)

        }else if(ten=="Dv"){
            actionD0=false
            actionD1=false
            actionD2=false
            actionD3=false
            actionD4=false
            actionD5=false
            actionD6=false
            actionD7=false
            actionD8=false
            actionD9=false
            arrayListDonVi.clear()
            arrayListDonVi.add(0)
            arrayListDonVi.add(1)
            arrayListDonVi.add(2)
            arrayListDonVi.add(3)
            arrayListDonVi.add(4)
            arrayListDonVi.add(5)
            arrayListDonVi.add(6)
            arrayListDonVi.add(7)
            arrayListDonVi.add(8)
            arrayListDonVi.add(9)
            Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            D0.setBackgroundResource(R.drawable.tron_two)
            D1.setBackgroundResource(R.drawable.tron_two)
            D2.setBackgroundResource(R.drawable.tron_two)
            D3.setBackgroundResource(R.drawable.tron_two)
            D4.setBackgroundResource(R.drawable.tron_two)
            D5.setBackgroundResource(R.drawable.tron_two)
            D6.setBackgroundResource(R.drawable.tron_two)
            D7.setBackgroundResource(R.drawable.tron_two)
            D8.setBackgroundResource(R.drawable.tron_two)
            D9.setBackgroundResource(R.drawable.tron_two)
        }

    }

    fun XiuA(ten:String) {
        if (ten == "Chuc") {
            actionC0=false
            actionC1=false
            actionC2=false
            actionC3=false
            actionC4=false
            actionC5=true
            actionC6=true
            actionC7=true
            actionC8=true
            actionC9=true
            arrayListChuc.clear()
            arrayListChuc.add(0)
            arrayListChuc.add(1)
            arrayListChuc.add(2)
            arrayListChuc.add(3)
            arrayListChuc.add(4)
            Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")

            C0.setBackgroundResource(R.drawable.tron_two)
            C1.setBackgroundResource(R.drawable.tron_two)
            C2.setBackgroundResource(R.drawable.tron_two)
            C3.setBackgroundResource(R.drawable.tron_two)
            C4.setBackgroundResource(R.drawable.tron_two)
            C5.setBackgroundResource(R.drawable.tron_one)
            C6.setBackgroundResource(R.drawable.tron_one)
            C7.setBackgroundResource(R.drawable.tron_one)
            C8.setBackgroundResource(R.drawable.tron_one)
            C9.setBackgroundResource(R.drawable.tron_one)

        } else if (ten == "Dv") {
            actionD0=false
            actionD1=false
            actionD2=false
            actionD3=false
            actionD4=false
            actionD5=true
            actionD6=true
            actionD7=true
            actionD8=true
            actionD9=true
            arrayListDonVi.clear()
            arrayListDonVi.add(0)
            arrayListDonVi.add(1)
            arrayListDonVi.add(2)
            arrayListDonVi.add(3)
            arrayListDonVi.add(4)
            Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")

            D0.setBackgroundResource(R.drawable.tron_two)
            D1.setBackgroundResource(R.drawable.tron_two)
            D2.setBackgroundResource(R.drawable.tron_two)
            D3.setBackgroundResource(R.drawable.tron_two)
            D4.setBackgroundResource(R.drawable.tron_two)
            D5.setBackgroundResource(R.drawable.tron_one)
            D6.setBackgroundResource(R.drawable.tron_one)
            D7.setBackgroundResource(R.drawable.tron_one)
            D8.setBackgroundResource(R.drawable.tron_one)
            D9.setBackgroundResource(R.drawable.tron_one)
        }
    }
        fun TaiA(ten: String) {
            if (ten == "Chuc") {
                actionC0=true
                actionC1=true
                actionC2=true
                actionC3=true
                actionC4=true
                actionC5=false
                actionC6=false
                actionC7=false
                actionC8=false
                actionC9=false
                arrayListChuc.clear()
                arrayListChuc.add(6)
                arrayListChuc.add(5)
                arrayListChuc.add(7)
                arrayListChuc.add(8)
                arrayListChuc.add(9)
                Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")
                C0.setBackgroundResource(R.drawable.tron_one)
                C1.setBackgroundResource(R.drawable.tron_one)
                C2.setBackgroundResource(R.drawable.tron_one)
                C3.setBackgroundResource(R.drawable.tron_one)
                C4.setBackgroundResource(R.drawable.tron_one)
                C5.setBackgroundResource(R.drawable.tron_two)
                C6.setBackgroundResource(R.drawable.tron_two)
                C7.setBackgroundResource(R.drawable.tron_two)
                C8.setBackgroundResource(R.drawable.tron_two)
                C9.setBackgroundResource(R.drawable.tron_two)

            } else if (ten == "Dv") {
                actionD0=true
                actionD1=true
                actionD2=true
                actionD3=true
                actionD4=true
                actionD5=false
                actionD6=false
                actionD7=false
                actionD8=false
                actionD9=false
                arrayListDonVi.clear()
                arrayListDonVi.add(6)
                arrayListDonVi.add(5)
                arrayListDonVi.add(7)
                arrayListDonVi.add(8)
                arrayListDonVi.add(9)
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
                D0.setBackgroundResource(R.drawable.tron_one)
                D1.setBackgroundResource(R.drawable.tron_one)
                D2.setBackgroundResource(R.drawable.tron_one)
                D3.setBackgroundResource(R.drawable.tron_one)
                D4.setBackgroundResource(R.drawable.tron_one)
                D5.setBackgroundResource(R.drawable.tron_two)
                D6.setBackgroundResource(R.drawable.tron_two)
                D7.setBackgroundResource(R.drawable.tron_two)
                D8.setBackgroundResource(R.drawable.tron_two)
                D9.setBackgroundResource(R.drawable.tron_two)
            }
        }

        fun LeA(ten: String) {
            if (ten == "Chuc") {
                actionC0=true
                actionC1=false
                actionC2=true
                actionC3=false
                actionC4=true
                actionC5=false
                actionC6=true
                actionC7=false
                actionC8=true
                actionC9=false
                arrayListChuc.clear()
                arrayListChuc.add(1)
                arrayListChuc.add(3)
                arrayListChuc.add(5)
                arrayListChuc.add(7)
                arrayListChuc.add(9)
                Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")

                C0.setBackgroundResource(R.drawable.tron_one)
                C1.setBackgroundResource(R.drawable.tron_two)
                C2.setBackgroundResource(R.drawable.tron_one)
                C3.setBackgroundResource(R.drawable.tron_two)
                C4.setBackgroundResource(R.drawable.tron_one)
                C5.setBackgroundResource(R.drawable.tron_two)
                C6.setBackgroundResource(R.drawable.tron_one)
                C7.setBackgroundResource(R.drawable.tron_two)
                C8.setBackgroundResource(R.drawable.tron_one)
                C9.setBackgroundResource(R.drawable.tron_two)

            } else if (ten == "Dv") {
                actionD0=true
                actionD1=false
                actionD2=true
                actionD3=false
                actionD4=true
                actionD5=false
                actionD6=true
                actionD7=false
                actionD8=true
                actionD9=false
                arrayListDonVi.clear()
                arrayListDonVi.add(1)
                arrayListDonVi.add(3)
                arrayListDonVi.add(5)
                arrayListDonVi.add(7)
                arrayListDonVi.add(9)
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
                D0.setBackgroundResource(R.drawable.tron_one)
                D1.setBackgroundResource(R.drawable.tron_two)
                D2.setBackgroundResource(R.drawable.tron_one)
                D3.setBackgroundResource(R.drawable.tron_two)
                D4.setBackgroundResource(R.drawable.tron_one)
                D5.setBackgroundResource(R.drawable.tron_two)
                D6.setBackgroundResource(R.drawable.tron_one)
                D7.setBackgroundResource(R.drawable.tron_two)
                D8.setBackgroundResource(R.drawable.tron_one)
                D9.setBackgroundResource(R.drawable.tron_two)
            }
        }

        fun ChanA(ten: String) {
            if (ten == "Chuc") {
                actionC0=false
                actionC1=true
                actionC2=false
                actionC3=true
                actionC4=false
                actionC5=true
                actionC6=false
                actionC7=true
                actionC8=false
                actionC9=true
                arrayListChuc.clear()
                arrayListChuc.add(0)
                arrayListChuc.add(2)
                arrayListChuc.add(4)
                arrayListChuc.add(6)
                arrayListChuc.add(8)
                Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")
                C0.setBackgroundResource(R.drawable.tron_two)
                C1.setBackgroundResource(R.drawable.tron_one)
                C2.setBackgroundResource(R.drawable.tron_two)
                C3.setBackgroundResource(R.drawable.tron_one)
                C4.setBackgroundResource(R.drawable.tron_two)
                C5.setBackgroundResource(R.drawable.tron_one)
                C6.setBackgroundResource(R.drawable.tron_two)
                C7.setBackgroundResource(R.drawable.tron_one)
                C8.setBackgroundResource(R.drawable.tron_two)
                C9.setBackgroundResource(R.drawable.tron_one)

            } else if (ten == "Dv") {
                actionD0=false
                actionD1=true
                actionD2=false
                actionD3=true
                actionD4=false
                actionD5=true
                actionD6=false
                actionD7=true
                actionD8=false
                actionD9=true
                arrayListDonVi.clear()
                arrayListDonVi.add(0)
                arrayListDonVi.add(2)
                arrayListDonVi.add(4)
                arrayListDonVi.add(6)
                arrayListDonVi.add(8)
                Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
                D0.setBackgroundResource(R.drawable.tron_two)
                D1.setBackgroundResource(R.drawable.tron_one)
                D2.setBackgroundResource(R.drawable.tron_two)
                D3.setBackgroundResource(R.drawable.tron_one)
                D4.setBackgroundResource(R.drawable.tron_two)
                D5.setBackgroundResource(R.drawable.tron_one)
                D6.setBackgroundResource(R.drawable.tron_two)
                D7.setBackgroundResource(R.drawable.tron_one)
                D8.setBackgroundResource(R.drawable.tron_two)
                D9.setBackgroundResource(R.drawable.tron_one)
            }
        }
    fun XoaA(ten: String) {
        if (ten == "Chuc") {
            actionC0=true
            actionC1=true
            actionC2=true
            actionC3=true
            actionC4=true
            actionC5=true
            actionC6=true
            actionC7=true
            actionC8=true
            actionC9=true
            arrayListChuc.clear()
            Log.d("checkMANG","${arrayListChuc.size}  ads $arrayListChuc")


            C0.setBackgroundResource(R.drawable.tron_one)
            C1.setBackgroundResource(R.drawable.tron_one)
            C2.setBackgroundResource(R.drawable.tron_one)
            C3.setBackgroundResource(R.drawable.tron_one)
            C4.setBackgroundResource(R.drawable.tron_one)
            C5.setBackgroundResource(R.drawable.tron_one)
            C6.setBackgroundResource(R.drawable.tron_one)
            C7.setBackgroundResource(R.drawable.tron_one)
            C8.setBackgroundResource(R.drawable.tron_one)
            C9.setBackgroundResource(R.drawable.tron_one)

        } else if (ten == "Dv") {
            actionD0=true
            actionD1=true
            actionD2=true
            actionD3=true
            actionD4=true
            actionD5=true
            actionD6=true
            actionD7=true
            actionD8=true
            actionD9=true
            arrayListDonVi.clear()
            Log.d("checkMANGDv","${arrayListDonVi.size}  ads $arrayListDonVi")
            D0.setBackgroundResource(R.drawable.tron_one)
            D1.setBackgroundResource(R.drawable.tron_one)
            D2.setBackgroundResource(R.drawable.tron_one)
            D3.setBackgroundResource(R.drawable.tron_one)
            D4.setBackgroundResource(R.drawable.tron_one)
            D5.setBackgroundResource(R.drawable.tron_one)
            D6.setBackgroundResource(R.drawable.tron_one)
            D7.setBackgroundResource(R.drawable.tron_one)
            D8.setBackgroundResource(R.drawable.tron_one)
            D9.setBackgroundResource(R.drawable.tron_one)
        }
    }
    fun xuLichuoitime(time:Int):String{
        val minutes = (time % 3600) / 60
        val remainingSeconds = time % 60

        return String.format("%02d:%02d",  minutes, remainingSeconds)
    }

}


