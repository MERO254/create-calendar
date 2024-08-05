package com.example.calendarview

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btncalendar: Button = findViewById(R.id.btncalendar)
        var txtcalendar:TextView = findViewById(R.id.txtcalendar)

        btncalendar.setOnClickListener {

            var calendar = Calendar.getInstance()
            var year = calendar.get(Calendar.YEAR)
            var month = calendar.get(Calendar.MONTH)
            var day = calendar.get(Calendar.DAY_OF_MONTH)

            var datePickerDialog = DatePickerDialog(this,{_,selectyear,selectmonth,selectday ->
                var datepicked = String.format("%d:%02d:%02d", day,month,year)
                txtcalendar.text = datepicked
            },year,month,day)

            datePickerDialog.show()

        }
    }
}