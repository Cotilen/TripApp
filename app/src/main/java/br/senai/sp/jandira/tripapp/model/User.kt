package br.senai.sp.jandira.tripapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.URI

@Entity(tableName = "tbl_user")
data class User(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "user-name") var username: String = "",
    var email: String = "",
    var phone: String = "",
    var password: String = "",
    @ColumnInfo(name = "is_over_18") var isOver18: Boolean = false,
    @ColumnInfo (name = "profile_photo") var profilePhoto: String = ""
)
