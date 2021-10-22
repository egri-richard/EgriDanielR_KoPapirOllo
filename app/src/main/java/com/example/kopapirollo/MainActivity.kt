package com.example.kopapirollo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
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
    private lateinit var rockChoiceBtn : ImageButton //rock is represented as 0
    private lateinit var paperChoiceBtn : ImageButton //paper is represented as 1
    private lateinit var scissorsChoiceBtn : ImageButton //scissors is represented as 2
    private lateinit var numOfDrawText : TextView
    private lateinit var finishAlert : AlertDialog.Builder
    private lateinit var rnd : Random
    private var cpuCurrentHp = 3
    private var playerCurrentHp = 3
    private var numOfDraw = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        rockChoiceBtn.setOnClickListener {
            playerChoicePic.setImageResource(R.drawable.rock)
            game(0)
        }

        paperChoiceBtn.setOnClickListener {
            playerChoicePic.setImageResource(R.drawable.paper)
            game(1)
        }

        scissorsChoiceBtn.setOnClickListener {
            playerChoicePic.setImageResource(R.drawable.scissors)
            game(2)
        }
    }

    private fun game(playerSelector : Int) {
        val cpuSelector = rnd.nextInt(3)
        when(cpuSelector){
            0 -> cpuChoicePic.setImageResource(R.drawable.rock)
            1 -> cpuChoicePic.setImageResource(R.drawable.paper)
            2 -> cpuChoicePic.setImageResource(R.drawable.scissors)
        }

        if( (playerSelector == 0 && cpuSelector == 0) ||
            (playerSelector == 1 && cpuSelector == 1) ||
            (playerSelector == 2 && cpuSelector == 2)) {
            numOfDraw++
            numOfDrawText.text = "Döntetlenek száma: ${numOfDraw}"
        } else if(  (playerSelector == 0 && cpuSelector == 2) ||
                    (playerSelector == 1 && cpuSelector == 0) ||
                    (playerSelector == 2 && cpuSelector == 1)) {
            cpuCurrentHp--
            when(cpuCurrentHp) {
                2 -> cpuHp3.setImageResource(R.drawable.heart1)
                1 -> cpuHp2.setImageResource(R.drawable.heart1)
                else -> {
                    cpuHp1.setImageResource(R.drawable.heart1)
                    finishAlert.setTitle("Győztél!").show()
                }
            }
        } else {
            playerCurrentHp--
            when(playerCurrentHp) {
                2 -> playerHp3.setImageResource(R.drawable.heart1)
                1 -> playerHp2.setImageResource(R.drawable.heart1)
                else -> {
                    playerHp1.setImageResource(R.drawable.heart1)
                    finishAlert.setTitle("Vesztettél!").show()
                }
            }
        }
    }

    private fun reset() {
        cpuCurrentHp = 3
        playerCurrentHp = 3
        cpuHp1.setImageResource(R.drawable.heart2)
        cpuHp2.setImageResource(R.drawable.heart2)
        cpuHp3.setImageResource(R.drawable.heart2)
        playerHp1.setImageResource(R.drawable.heart2)
        playerHp2.setImageResource(R.drawable.heart2)
        playerHp3.setImageResource(R.drawable.heart2)
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
        numOfDrawText = findViewById(R.id.numOfDrawText)
        finishAlert = AlertDialog.Builder(this)
            .setMessage("Szeretne új játékot játszani?")
            .setPositiveButton("Igen") {_, _ -> reset()}
            .setNegativeButton("Nem") {_, _ -> finish()}
        rnd = Random
    }
}