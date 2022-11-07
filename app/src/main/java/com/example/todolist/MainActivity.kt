package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        println("CREATING")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        val tmp  = findViewById<Button>(R.id.btnAddTodo)

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }
        btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }

    override fun onStart() {
        println("STARTING")
        super.onStart()
    }

    override fun onStop() {
        println("STOPPING")
        super.onStop()
    }

    override fun onDestroy() {
        println("DESTROYING")
        super.onDestroy()
    }

    override fun onRestart() {
        println("RESTARTING")
        super.onRestart()
    }

    override fun onResume() {
        println("RESUMING")
        super.onResume()
    }

    override fun onPause() {
        println("PAUSING")
        super.onPause()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        println("RESTORING STATE")
        super.onRestoreInstanceState(savedInstanceState)

        savedInstanceState?.run {
            var temp = getParcelableArrayList<Todo>("todoList")
            for (element in temp!!) {
                todoAdapter.addTodo(element)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        println("SAVING STATE")
        super.onSaveInstanceState(outState)

        outState?.run {
            putParcelableArrayList("todoList", ArrayList<Parcelable>(todoAdapter.getList()))
        }
    }
}
