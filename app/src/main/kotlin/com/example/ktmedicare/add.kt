package com.example.ktmedicare

import android.os.Bundle
import android.widget.CompoundButton

class add {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener { view ->
            tv1.text = ""

            if (cb1.isChecked)
                tv1.append("체크 박스 1 체크")

            if (cb2.isChecked)
                tv1.append("체크 박스 2 체크")

            if (cb3.isChecked)
                tv1.append("체크 박스 3 체크")
        }

        btn2.setOnClickListener { view ->
            cb1.isChecked = true
            cb2.isChecked = true
            cb3.isChecked = true
        }

        btn3.setOnClickListener { view ->
            cb1.isChecked = false
            cb2.isChecked = false
            cb3.isChecked = false
        }

        btn4.setOnClickListener { view ->
            cb1.toggle()
            cb2.toggle()
            cb3.toggle()
        }

        var listener = CheckBoxListener()
        cb1.setOnCheckedChangeListener(listener);

        cb2.setOnCheckedChangeListener{compoundButton, b ->
            if(b)
                tv1.text = "Event : CheckBox2 Checked"
            else
                tv1.text = "Event CheckBox2 unChecked"
        }

        cb3.setOnCheckedChangeListener{compoundButton, b ->
            if(b)
                tv1.text = "Event : CheckBox3 Checked"
            else
                tv1.text = "Event CheckBox3 unChecked"
        }
    }

    inner class CheckBoxListener : CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            if(p1)
                tv1.text = "Event : CheckBox1 Checked"
            else
                tv1.text = "Event CheckBox1 unChecked"
        }
    }
}