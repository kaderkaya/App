package com.kaderkayaarslan.kotlinkenny

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import android.os.Handler 

class MainActivity : AppCompatActivity() {
    var score = 0
    var imageArray = ArrayList<ImageView>()
    var handler = Handler( )
    var runnable = kotlinx.coroutines.Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ImageArray
        imageArray.add(imageView)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)     
        imageArray.add(imageView9)
        hideImages()


                                 // countdown timer

        object : CountDownTimer(15000,1000) {
            override fun onTick( millisUntilFinished :  Long) {
                timeText.text ="Time : " +millisUntilFinished/1000

            }

            override fun onFinish() {
                timeText.text = "Time:0"
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Restart The Game?")
                alert.setPositiveButton("Yes") { dialog, which ->
                    val intent = intent
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("No") { dialog, which ->
                    Toast.makeText(applicationContext, android.R.string.no, Toast.LENGTH_SHORT).show()
                }
                alert.show()
            }

        }.start()
    }

    fun hideImages() {
        runnable = object : Runnable{
            override fun run()  {

                for (image in imageArray)   {
                    image.visibility = View.INVISIBLE
                }

                val random = Random
                val randomIndex = random.nextInt(9)
                imageArray[randomIndex].visibility = View.VISIBLE
                handler.postDelayed(runnable,500)
            }

        }
        handler.post(runnable)








    }


    fun increaseScore(view: View) {
        score = score+1
        scoreText.text = "score$score"
    }
}