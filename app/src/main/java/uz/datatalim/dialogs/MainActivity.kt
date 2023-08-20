package uz.datatalim.dialogs

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.toDrawable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        customDialog()

    }

    private fun customDialog() {

        val dialog=Dialog(this)

        val bCustomDialog:Button=findViewById(R.id.btnCustom)

        bCustomDialog.setOnClickListener {

            dialog.setContentView(R.layout.item_dialog)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.setCancelable(false)
            val etEnterValue=dialog.findViewById<EditText>(R.id.etEnterValue)
            val bDone=dialog.findViewById<Button>(R.id.btnDone)
            val ivCancel=dialog.findViewById<ImageView>(R.id.ivCancel)

            ivCancel.setOnClickListener {

                dialog.dismiss()

            }

            dialog.show()

        }

    }

    private fun initView() {

        val btnSimple:Button=findViewById(R.id.btnSimple)
        val btnCustom:Button=findViewById(R.id.btnCustom)

        btnSimple.setOnClickListener {

            val dialog=AlertDialog.Builder(this)
            dialog.setMessage("Bu yerda sizning reklamangiz bo'lishi mumlimn edi")
            dialog.setTitle("Bu reklama")
            dialog.setIcon(R.drawable.ic_launcher_foreground)
            dialog.setPositiveButtonIcon(R.drawable.baseline_done_24.toDrawable())
            dialog.setCancelable( false)
            dialog.setPositiveButton("Yes", object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {

                    Toast.makeText(this@MainActivity, "daaa", Toast.LENGTH_SHORT).show()

                }


            })
            dialog.setNegativeButton("No",object :DialogInterface.OnClickListener{

                override fun onClick(dialog: DialogInterface?, which: Int) {

                    Toast.makeText(this@MainActivity, "Yoooooq", Toast.LENGTH_SHORT).show()

                }


            })

            dialog.show()

        }

    }


}