package techauso.ghiso.ghisolode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView

class RuleGame : AppCompatActivity() {
    lateinit var  textrule:TextView
    lateinit var out:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_rule_game)

        // text rule
        textrule=findViewById(R.id.txxtrule)
        textrule.setText(R.string.rule)

        // thoát
        out=findViewById(R.id.thoatRule)
        out.setOnClickListener { onBackPressed() }

    }

    override fun onBackPressed() {
        startActivity(Intent(this@RuleGame,MainActivity::class.java))
    }
}