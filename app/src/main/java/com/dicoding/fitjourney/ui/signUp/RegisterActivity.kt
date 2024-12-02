package com.dicoding.fitjourney.ui.signUp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dicoding.fitjourney.R
import com.dicoding.fitjourney.data.retrofil.ApiClient
import com.dicoding.fitjourney.data.retrofil.ApiResponse
import com.dicoding.fitjourney.data.retrofil.ApiService
import com.dicoding.fitjourney.data.retrofil.User
import com.dicoding.fitjourney.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menggunakan View Binding untuk mengakses layout
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val fullname = binding.fullnameEditText.text.toString()
            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            val user = User(username, password, fullname)

            val apiService = ApiClient.retrofit.create(ApiService::class.java)
            apiService.register(user).enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        // Berhasil register, lanjutkan ke login atau ke activity lain
                    } else {
                        Toast.makeText(this@RegisterActivity, "Register gagal", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
