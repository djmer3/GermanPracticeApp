/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package xyz.dmercer.myapplication.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper

/**
 * The Room database that contains the Users table
 */
@Database(entities = [Question::class], version = 1)
abstract class QuestionDatabase : RoomDatabase() {

    abstract fun questionDAO(): QuestionDAO

    private fun populateInitialData(context: Context, database:QuestionDatabase){
        val res = context.resources
        val id = res.getIdentifier("questions", "raw", context.packageName)
        val inputStream = res.openRawResource(id)

        val mapper = ObjectMapper()
        val myObjects: List<Question> = mapper.readValue(
            inputStream,
            object : TypeReference<List<Question?>?>() {})

        myObjects.forEach{question->
            questionDAO().insert(question)
        }
    }

    companion object {

        @Volatile private var INSTANCE: QuestionDatabase? = null

        fun getInstance(context: Context): QuestionDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context): QuestionDatabase {
            val database = Room.databaseBuilder(
                context.applicationContext,
                QuestionDatabase::class.java, "Sample.db"
            ).build()



            return database
        }



/*        var rdc: Callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) { // do something after database has been created
            }

            override fun onOpen(db: SupportSQLiteDatabase) { // do something every time database is open
            }
        }*/
    }
}
