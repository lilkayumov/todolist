package com.example.todoforyou

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoforyou.databinding.ActivityMain2Binding
import com.example.todoforyou.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    lateinit var dbHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        dbHelper = DatabaseHelper(this)
        binding.btnSave.setOnClickListener {
            val taskModel = TaskModel()
            taskModel.taskName = binding.createTitle.text.toString()
            taskModel.taskDetail = binding.createTime.text.toString()
            dbHelper.addTask(taskModel)
            finish()
        }
    }
}