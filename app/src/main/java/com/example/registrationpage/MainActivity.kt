package com.example.registrationpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }
    private fun initViews(){
        val registerButton = findViewById<Button>(R.id.btn_register)
        val edtUserName = findViewById<EditText>(R.id.edt_user_name)
        val edtPassword = findViewById<EditText>(R.id.edt_password)
        val edtConfirmPassword = findViewById<EditText>(R.id.edt_confirm_password)

        registerButton.setOnClickListener {
            val user = User(edtUserName.text.toString(), edtPassword.text.toString())
            if(register(userName = user.userName!!,
                password = user.password!!,
                confirmPassword = edtConfirmPassword.text.toString())){
                startProfileActivity(user)
                Toast.makeText(this, "Successfully", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun register(userName : String, password : String, confirmPassword : String) : Boolean{
        return userName.isNotBlank()
                && password == confirmPassword
                && password.isNotBlank()
                && confirmPassword.isNotBlank()
    }

    private fun startProfileActivity(user : User){
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("user", user)
        intent.putExtra("image", R.drawable.img_layout)
        startActivity(intent)

    }
}