package techauso.ghiso.ghisolode.FragmentApp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import techauso.ghiso.ghisolode.R
import kotlin.random.Random

class ChonSoNhanh : Fragment() {
    lateinit var radioGroup:RadioGroup
    lateinit var t1:TextView
    lateinit var t2:TextView
    lateinit var t3:TextView
    lateinit var t4:TextView
    lateinit var t5:TextView
    private val textSo = arrayOfNulls<TextView>(100)

    var a=0

    @SuppressLint("DiscouragedApi", "ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.frame_chon_so_nhanh, container, false)
        // Inflate the layout for this fragme
        radioGroup=rootView.findViewById(R.id.group)
        t1=rootView.findViewById(R.id.t1)
        t2=rootView.findViewById(R.id.t2)
        t3=rootView.findViewById(R.id.t3)
        t4=rootView.findViewById(R.id.t4)
        t5=rootView.findViewById(R.id.t5)
        // xử lsi textview
        for(i in 0..99){
            val textID=resources.getIdentifier("num$i","id",requireActivity().packageName)
            textSo[i]= rootView.findViewById(textID)
        }
        // xử lí button radio
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.button1->{
                    a=1
                    t1.text="1 Lô"
                    t2.text="2 Lô"
                    t3.text="3 Lô"
                    t4.text="5 Lô"
                    t5.text="10 Lô"
                    for(i in 0..99){
                        textSo[i]?.setBackgroundResource(R.drawable.t1)}
                    reset()

                }
                R.id.button2->{
                    a=2
                    t1.text="Cùng số"
                    t2.text="Chẵn"
                    t3.text="Lẻ"
                    t4.text="Lớn"
                    t5.text="Nhỏ"
                    for(i in 0..99){
                        textSo[i]?.setBackgroundResource(R.drawable.t1)}
                    reset()

                }
            }
        }
        t1.setOnClickListener {
            chon(t1)
            if(a==1){
                for(i in 0..99){
                    textSo[i]?.setBackgroundResource(R.drawable.t1)
                }
                var b=Random.nextInt(0,99)
                textSo[b]?.setBackgroundResource(R.drawable.t2)

            }else if( a==2){
                for(i in 0..99){
                    textSo[i]?.setBackgroundResource(R.drawable.t1)

                }
                var arraySam= arrayOf(11,22,33,44,55,66,77,88,99,0)

                for(i in arraySam.indices){
                    textSo[arraySam[i]]?.setBackgroundResource(R.drawable.t2)
                }

            }else{
                for(i in 0..99){
                    textSo[i]?.setBackgroundResource(R.drawable.t1)
                }
                var arraySam= arrayOf(11,22,33,44,55,66,77,88,99,0)

                for(i in arraySam.indices){
                    textSo[arraySam[i]]?.setBackgroundResource(R.drawable.t2)
                }
            }
        }
        t2.setOnClickListener {
            chon(t2)
            if(a==1){
                for(i in 0..99){
                    textSo[i]?.setBackgroundResource(R.drawable.t1)
                }

                var listSo=mutableListOf<Int>()
                repeat(2){
                    val random=Random.nextInt(0,99)
                    listSo.add(random)
                }
                for(i in 0 until listSo.size){
                    textSo[listSo[i]]?.setBackgroundResource(R.drawable.t2)
                }


            }else if( a==2){
                for(i in 0..99){
                    textSo[i]?.setBackgroundResource(R.drawable.t1)
                    if(i%2==0){
                        textSo[i]?.setBackgroundResource(R.drawable.t2)
                    }else{
                        textSo[i]?.setBackgroundResource(R.drawable.t1)
                    }
                }

            }else{
                for(i in 0..99){
                    textSo[i]?.setBackgroundResource(R.drawable.t1)
                    if(i%2==0){
                        textSo[i]?.setBackgroundResource(R.drawable.t2)
                    }else{
                        textSo[i]?.setBackgroundResource(R.drawable.t1)
                    }
                }
            }
        }
        t3.setOnClickListener {
            chon(t3)
            if(a==1){
                for(i in 0..99){
                    textSo[i]?.setBackgroundResource(R.drawable.t1)
                }
                var listSo=mutableListOf<Int>()
                repeat(3){
                    val random=Random.nextInt(0,99)
                    listSo.add(random)
                }
                for(i in 0 until listSo.size){
                    textSo[listSo[i]]?.setBackgroundResource(R.drawable.t2)
                }


            }else if( a==2){
                for(i in 0..99){
                    textSo[i]?.setBackgroundResource(R.drawable.t1)
                    if(i%2==0){
                        textSo[i]?.setBackgroundResource(R.drawable.t1)
                    }else{
                        textSo[i]?.setBackgroundResource(R.drawable.t2)
                    }
                }

            }else{
                for(i in 0..99){
                    textSo[i]?.setBackgroundResource(R.drawable.t1)
                    if(i%2==0){
                        textSo[i]?.setBackgroundResource(R.drawable.t1)
                    }else{
                        textSo[i]?.setBackgroundResource(R.drawable.t2)
                    }
                }
            }
        }
        t4.setOnClickListener {
            chon(t4)
            if(a==1){
                for(i in 0..99){
                    textSo[i]?.setBackgroundResource(R.drawable.t1)
                }
                var listSo=mutableListOf<Int>()
                repeat(5){
                    val random=Random.nextInt(0,99)
                    listSo.add(random)
                }
                for(i in 0 until listSo.size){
                    textSo[listSo[i]]?.setBackgroundResource(R.drawable.t2)
                }


            }else if( a==2){
                for(i in 0..99){
                    textSo[i]?.setBackgroundResource(R.drawable.t1)
                    if(i>49){
                        textSo[i]?.setBackgroundResource(R.drawable.t2)
                    }else{
                        textSo[i]?.setBackgroundResource(R.drawable.t1)
                    }
                }

            }else{
                for(i in 0..99){
                    textSo[i]?.setBackgroundResource(R.drawable.t1)
                    if(i>49){
                        textSo[i]?.setBackgroundResource(R.drawable.t2)
                    }else{
                        textSo[i]?.setBackgroundResource(R.drawable.t1)
                    }
                }
            }
        }
        t5.setOnClickListener {
            chon(t5)
            if(a==1){
                for(i in 0..99){
                    textSo[i]?.setBackgroundResource(R.drawable.t1)
                }
                var listSo=mutableListOf<Int>()
                repeat(10){
                    val random=Random.nextInt(0,99)
                    listSo.add(random)
                }
                for(i in 0 until listSo.size){
                    textSo[listSo[i]]?.setBackgroundResource(R.drawable.t2)
                }


            }else if( a==2){
                for(i in 0..99){
                    textSo[i]?.setBackgroundResource(R.drawable.t1)
                    if(i>49){
                        textSo[i]?.setBackgroundResource(R.drawable.t1)
                    }else{
                        textSo[i]?.setBackgroundResource(R.drawable.t2)
                    }
                }

            }else{
                for(i in 0..99){
                    textSo[i]?.setBackgroundResource(R.drawable.t1)
                    if(i>49){
                        textSo[i]?.setBackgroundResource(R.drawable.t1)
                    }else{
                        textSo[i]?.setBackgroundResource(R.drawable.t2)
                    }
                }
            }
        }


        return rootView
    }
    fun chon(texts:TextView){
        t1.setBackgroundResource(R.drawable.t1)
        t2.setBackgroundResource(R.drawable.t1)
        t3.setBackgroundResource(R.drawable.t1)
        t4.setBackgroundResource(R.drawable.t1)
        t5.setBackgroundResource(R.drawable.t1)
        texts.setBackgroundResource(R.drawable.t2)

    }
    fun reset(){
        t1.setBackgroundResource(R.drawable.t1)
        t2.setBackgroundResource(R.drawable.t1)
        t3.setBackgroundResource(R.drawable.t1)
        t4.setBackgroundResource(R.drawable.t1)
        t5.setBackgroundResource(R.drawable.t1)
    }
}