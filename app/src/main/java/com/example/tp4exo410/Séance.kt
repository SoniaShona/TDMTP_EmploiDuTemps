package com.example.tp_sonia_exo4

import java.util.*

class Séance (
    val ModuleSéance: Module,
    val date : Date,
    val heure : String,
    val Prof: Enseignant
){
    fun GetNameSéance(): String{
        return ModuleSéance.intitulé
    }
}