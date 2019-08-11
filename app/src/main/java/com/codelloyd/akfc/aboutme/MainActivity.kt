package com.codelloyd.akfc.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.codelloyd.akfc.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private val myName: MyName = MyName("codelloyd")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    binding.myName = myName

    binding.doneButton.setOnClickListener {
      addNickname()
    }

    binding.nicknameText.setOnClickListener {
      updateNickname()
    }
  }

  private fun addNickname() {
    binding.apply {
      myName?.nickname = nicknameEdit.text.toString()
      invalidateAll()

      nicknameEdit.visibility = View.GONE
      doneButton.visibility = View.GONE
      nicknameText.visibility = View.VISIBLE

      // Hide the keyboard.
      val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
      imm.hideSoftInputFromWindow(doneButton.windowToken, 0)
    }
  }

  private fun updateNickname() {
    binding.apply {
      nicknameEdit.visibility = View.VISIBLE
      doneButton.visibility = View.VISIBLE
      nicknameText.visibility = View.GONE

      // Set the focus to the edit text.
      nicknameEdit.requestFocus()

      // Show the keyboard.
      val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
      imm.showSoftInput(nicknameEdit, 0)
    }
  }
}
