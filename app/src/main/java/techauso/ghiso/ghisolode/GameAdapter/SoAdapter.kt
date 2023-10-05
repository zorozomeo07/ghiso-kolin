package techauso.ghiso.ghisolode.GameAdapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import techauso.ghiso.ghisolode.FunApp
import techauso.ghiso.ghisolode.ModelGame.SoModel
import techauso.ghiso.ghisolode.R

class SoAdapter(private val soModel: ArrayList<SoModel>,private  var context: Context) : RecyclerView.Adapter<SoAdapter.ViewHolder>() {

    // Tạo ViewHolder cho mỗi item trong RecyclerView
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text1: TextView = view.findViewById(R.id.time1)
        val text2: TextView = view.findViewById(R.id.time2)
        val text3: TextView = view.findViewById(R.id.time3)
        val control:ConstraintLayout=view.findViewById(R.id.game)
    }
    // Tạo ViewHolder mới
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.iteam_game, parent, false)
        return ViewHolder(view)
    }

    // Liên kết dữ liệu với ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val so=soModel[position].number
        val time=xuLichuoitime(so)
        if(so>59){
            holder.text2.text="XSST $time Phút"
            holder.text1.text="$time Phút"

        }else{
            holder.text2.text="XSST $so Giây"
            holder.text1.text="$so Giây"
        }
        holder.text3.text="XSST $time Phút"
        holder.control.setOnClickListener {
            val intent= Intent(context,FunApp::class.java)
            val shave=context.getSharedPreferences("dataGhiso", AppCompatActivity.MODE_PRIVATE)
            val edistA=shave.edit()
            //pust time time
            edistA.putInt("times",so)
            edistA.apply()
            context.startActivity(intent)
        }

    }

    // Trả về số lượng item trong RecyclerView
    override fun getItemCount(): Int {
        return soModel.size
    }
    fun xuLichuoitime(time:Int):String{
        val minutes = (time % 3600) / 60
        val remainingSeconds = time % 60
        return String.format("%02d:%02d",  minutes, remainingSeconds)
    }
}