package com.dicoding.fitjourney.ui.login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dicoding.fitjourney.R
import com.dicoding.fitjourney.data.retrofil.ApiClient
import com.dicoding.fitjourney.data.retrofil.ApiService
import com.dicoding.fitjourney.data.retrofil.User
import com.dicoding.fitjourney.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast
import com.dicoding.fitjourney.data.retrofil.ApiResponse

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menggunakan View Binding untuk mengakses layout
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            val user = User(username, password)

            val apiService = ApiClient.retrofit.create(ApiService::class.java)
            apiService.login(user).enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        // Berhasil login, lanjut ke Home atau informasi akun
                        // Anda bisa memulai activity baru di sini
                    } else {
                        Toast.makeText(this@LoginActivity, "Login gagal", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Error: ${t.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        }
    }
}

