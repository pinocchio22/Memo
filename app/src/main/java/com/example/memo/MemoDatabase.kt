package com.example.memo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * @author CHOI
 * @email vviian.2@gmail.com
 * @created 2021-02-18
 * @desc
 */

@Database(entities = arrayOf(MemoEntity::class), version = 1)
abstract class MemoDatabase : RoomDatabase() {
    abstract fun memoDAO() : MemoDAO

    companion object {
        var INSTANCE : MemoDatabase? = null

        fun getInstance(context: Context) : MemoDatabase? {
            if (INSTANCE == null){
                synchronized(MemoDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    MemoDatabase::class.java,"memo.db")
                        .fallbackToDestructiveMigration()       // 수정사항이 반영된 새로운 버전이 만들어지면 이전 버전은 drop
                        .build()
                }
            }

            return INSTANCE
        }
    }


}