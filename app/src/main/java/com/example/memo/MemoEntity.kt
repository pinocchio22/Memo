package com.example.memo

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author CHOI
 * @email vviian.2@gmail.com
 * @created 2021-02-18
 * @desc
 */
@Entity(tableName= "memo")
data class MemoEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Long?,
    var memo : String = "")