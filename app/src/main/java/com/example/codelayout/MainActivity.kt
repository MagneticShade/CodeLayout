package com.example.codelayout

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layout=findViewById<ConstraintLayout>(R.id.layout)

        val button1=CreateButton(layout,1)
        val button2=CreateButton(layout,2)
        val button3=CreateButton(layout,3)
        val button4=CreateButton(layout,4)
        val button5=CreateButton(layout,5)
        val set = ConstraintSet()

        set.setDimensionRatio(layout.id, "16:9");
        set.clone(layout)
        set.connect(button1.id,ConstraintSet.LEFT,layout.id,ConstraintSet.LEFT,0)
        set.connect(button1.id,ConstraintSet.TOP,layout.id,ConstraintSet.TOP,0)

        set.connect(button2.id,ConstraintSet.RIGHT,layout.id,ConstraintSet.RIGHT,0)
        set.connect(button2.id,ConstraintSet.TOP,layout.id,ConstraintSet.TOP,0)

        set.connect(button3.id,ConstraintSet.LEFT,layout.id,ConstraintSet.LEFT,0)
        set.connect(button3.id,ConstraintSet.BOTTOM,layout.id,ConstraintSet.BOTTOM,0)

        set.connect(button4.id,ConstraintSet.RIGHT,layout.id,ConstraintSet.RIGHT,0)
        set.connect(button4.id,ConstraintSet.BOTTOM,layout.id,ConstraintSet.BOTTOM,0)

        set.connect(button5.id,ConstraintSet.TOP,layout.id,ConstraintSet.TOP,0)
        set.connect(button5.id,ConstraintSet.BOTTOM,layout.id,ConstraintSet.BOTTOM,0)
        set.connect(button5.id,ConstraintSet.LEFT,layout.id,ConstraintSet.LEFT,0)
        set.connect(button5.id,ConstraintSet.RIGHT,layout.id,ConstraintSet.RIGHT,0)


        set.applyTo(layout)

        button5.setOnClickListener{
            set.clear(button5.id,ConstraintSet.TOP)
            set.applyTo(layout)
        }
    }

    private fun CreateButton(layout: ConstraintLayout,int:Int): Button {

        val button=Button(this)
        button.setBackgroundColor(Color.CYAN)
        button.layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        button.id=int
        layout.addView(button)
        return button
    }
}