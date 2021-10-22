package com.example.kopapirollo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var cpuHp3 : ImageView
    private lateinit var cpuHp2 : ImageView
    private lateinit var cpuHp1 : ImageView
    private lateinit var playerHp3 : ImageView
    private lateinit var playerHp2 : ImageView
    private lateinit var playerHp1 : ImageView
    private lateinit var cpuChoicePic : ImageView
    private lateinit var playerChoicePic : ImageView
    private lateinit var rockChoiceBtn : Button
    private lateinit var paperChoiceBtn : Button
    private lateinit var scissorsChoiceBtn : Button
    private lateinit var rnd : Random

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        cpuHp3 = findViewById(R.id.cpuHp3)
        cpuHp2 = findViewById(R.id.cpuHp2)
        cpuHp1 = findViewById(R.id.cpuHp1)
        playerHp3 = findViewById(R.id.playerHp3)
        playerHp2 = findViewById(R.id.playerHp2)
        playerHp1 = findViewById(R.id.playerHp1)
        cpuChoicePic = findViewById(R.id.cpuChoicePic)
        playerChoicePic = findViewById(R.id.playerChoicePic)
        rockChoiceBtn = findViewById(R.id.rockChoiceBtn)
        paperChoiceBtn = findViewById(R.id.paperChoiceBtn)
        scissorsChoiceBtn = findViewById(R.id.scissorsChoiceBtn)
        rnd = Random
    }
}