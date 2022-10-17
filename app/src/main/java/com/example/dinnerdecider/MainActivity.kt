package com.example.dinnerdecider

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var foodToEat : TextView
    private lateinit var foodToAdd: EditText

    var foods: ArrayList<String> = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_addFood : Button = findViewById(R.id.activity_main_bt_addFood)
        var btn_decide : Button = findViewById(R.id.activity_main_bt_decide)
        btn_addFood.setOnClickListener { addFood() }
        btn_decide.setOnClickListener { decide() }

        foodToEat = findViewById(R.id.activity_main_tv_foodToEat)
        foodToAdd = findViewById(R.id.activity_main_et_foodToAdd)

    }
    private fun addFood(){
        if(!foodToAdd.text.toString().equals("") && !foods.contains(foodToAdd.text.toString())){
            foods.add(foodToAdd.text.toString())
        }
        foodToAdd.setText("")
        hideKeyboard(foodToAdd)
    }
    private fun decide(){
        foodToEat.text = foods.random()

    }
    private fun hideKeyboard(v : View){

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)
    }
}