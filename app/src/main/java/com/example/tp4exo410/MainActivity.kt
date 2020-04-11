package com.example.tp4exo410

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.tp_sonia_exo4.Enseignant
import com.example.tp_sonia_exo4.Module
import com.example.tp_sonia_exo4.Séance
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var Enseignant1 = Enseignant("Mostefai", "Mohamed Amine", "m_mostefai@esi.dz", "Maitre De Conférence" )
        var Enseignant2 = Enseignant("Zakaria", "Chahnez", "c_zakaria@esi.dz", "Maitre De Conférence" )


        var QLOG= Module("QLOG","1h30",3,Enseignant2)
        var TDM = Module("TDM","4 heure",3, Enseignant1)

        var date1 = Date(2020, 5, 21)
        var date2 = Date(2020, 5, 25)



        var Séance1 = Séance(TDM,date1,"8h30",Enseignant1)
        var Séance2= Séance( QLOG, date2,"15h00",Enseignant2)


        var ListSéance= mutableListOf( Séance1, Séance2)
        var listView = findViewById<ListView>(R.id.Agenda)

        val listItems = arrayOfNulls<String>(ListSéance.size)
        for (i in 0 until ListSéance.size) {
            val séance = ListSéance[i]
            listItems[i] = "Module : " + séance.GetNameSéance() + "\n   Le : " + séance.date.date.toString() + " / " + séance.date.month.toString() + " / " +séance.date.year.toString()+"\n   A " + séance.heure
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter

        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE){

        } else {
            listView.setOnItemClickListener { _, _, position, _ ->
                val element = adapter.getItemId(position).toString().toInt() // The item that was clicked
                //val item = ListSéance.get(element) as Séance


                val intent = Intent(this@MainActivity,ModuleDetailsActivity::class.java)
                intent.putExtra("position",element)
                startActivity(intent)
            }
        }
    }

}
