package com.example.customviewdrawline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import petrov.kristiyan.colorpicker.ColorPicker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ControlUndo.setOnClickListener {
            PaintArea.setUndo()
        }
        ControlRedo.setOnClickListener {
            PaintArea.setRedo()
        }
        ControlDelete.setOnClickListener {
            PaintArea.setDelete()
        }
        ControlColorPicker.setOnClickListener {
            val color = ColorPicker(this)
            color.setOnFastChooseColorListener(object : ColorPicker.OnFastChooseColorListener {
                override fun setOnFastChooseColorListener(position: Int, color: Int) {
                    PaintArea.setColor(color)
                }

                override fun onCancel() {
                    color.dismissDialog()
                }

            }).setRoundColorButton(true).show()
        }
    }
}