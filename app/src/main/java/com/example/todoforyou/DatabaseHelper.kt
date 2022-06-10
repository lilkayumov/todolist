package com.example.todoforyou

import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Integer.parseInt

class DatabaseHelper(context: Context) : SQLiteOpenHelper(
    context, DATABASE_NAME, null,
    DATABASE_VERSION
) {
    companion object {
        private val DATABASE_NAME = "task"
        private val DATABASE_VERSION = 1
        private val TABLE_NAME = "tasktable"
        private val ID = "id"
        private val TASK_NAME = "taskName"
        private val TASK_DETAIL = "taskDetail"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val createDatabase =
            "CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY, $TASK_NAME TEXT, $TASK_DETAIL TEXT)"
        p0?.execSQL(createDatabase)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
        p0?.execSQL(DROP_TABLE)
        onCreate(p0)
    }

    fun addTask(taskModel: TaskModel): Boolean {
        val db = this.writableDatabase
        val value = ContentValues()
        value.put(TASK_NAME, taskModel.taskName)
        value.put(TASK_DETAIL, taskModel.taskDetail)
        val success = db.insert(TABLE_NAME, null, value)
        db.close()
        return (Integer.parseInt("$success")!= -1)
    }

    @SuppressLint("Range")
    fun getAllTask(): List<TaskModel> {
        val allTasks=ArrayList<TaskModel>()
        val db=writableDatabase
        val selectedQuery="SELECT * FROM $TABLE_NAME"
        val cursor=db.rawQuery(selectedQuery,null)
        if (cursor!=null){
            if (cursor.moveToFirst()){
                do {
                    val task= TaskModel()
                    task.id=Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
                    task.taskName=cursor.getString(cursor.getColumnIndex(TASK_NAME))
                    task.taskDetail=cursor.getString(cursor.getColumnIndex(TASK_DETAIL))
                    allTasks.add(task)
                }
                    while (cursor.moveToNext())
            }
        }
    return allTasks
    }
}