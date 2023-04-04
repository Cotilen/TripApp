package br.senai.sp.jandira.tripapp.dao.repository

import android.content.Context
import br.senai.sp.jandira.tripapp.dao.TripDb
import br.senai.sp.jandira.tripapp.model.User

class UserRepository(context: Context) {

    //Variavel que representa nosso banco de dados
    private val db = TripDb.getDataBase(context)

    fun save(user: User): Long {
        return db.UserDao().save(user)
    }
}