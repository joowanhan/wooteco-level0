package fastcampus.part0.chapter3_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
/**
 * 1. Activity 가 실행, 종료 생명주기
 * 2. 다른 앱 실행 시, 생명주기 (홈버튼)
 * 3. 다른 Activity 실행 시, 생명주기
 * */


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener { navigateNextActivity() }
        findViewById<Button>(R.id.button2).setOnClickListener { finish() }

        Toast.makeText(this, "라이프사이클 - Main : onCreate", Toast.LENGTH_SHORT).show()
        Log.d("라이프사이클 - Main", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "라이프사이클 - Main : onStart", Toast.LENGTH_SHORT).show()
        Log.d("라이프사이클 - Main", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "라이프사이클 - Main : onRestart", Toast.LENGTH_SHORT).show()
        Log.d("라이프사이클 - Main", "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "라이프사이클 - Main : onResume", Toast.LENGTH_SHORT).show()
        Log.d("라이프사이클 - Main", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "라이프사이클 - Main : onPause", Toast.LENGTH_SHORT).show()
        Log.d("라이프사이클 - Main", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "라이프사이클 - Main : onStop", Toast.LENGTH_SHORT).show()
        Log.d("라이프사이클 - Main", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "라이프사이클 - Main : onDestroy", Toast.LENGTH_SHORT).show()
        Log.d("라이프사이클 - Main", "onDestroy")
    }

    private fun navigateNextActivity() {
        val intent = Intent(this, NextActivity::class.java)
        startActivity(intent)
    }
}