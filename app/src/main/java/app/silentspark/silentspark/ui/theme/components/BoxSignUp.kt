package app.silentspark.silentspark.ui.theme.components

import android.content.Context
import android.util.Log
import android.widget.Toast
import app.silentspark.silentspark.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import app.silentspark.silentspark.controller.ApiInterface
import app.silentspark.silentspark.controller.RetrofitInstance
import app.silentspark.silentspark.controller.SignInBody
import app.silentspark.silentspark.ui.theme.screen.SignUpBody
import app.silentspark.silentspark.ui.theme.theme.AbuBiruMuda
import app.silentspark.silentspark.ui.theme.theme.AbuBiruTua
import app.silentspark.silentspark.ui.theme.theme.Abuabu
import app.silentspark.silentspark.ui.theme.theme.Coklat
import app.silentspark.silentspark.ui.theme.theme.putih
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.sign


@Composable
fun BoxSingUp(
    navController: NavHostController,
    modifier: Modifier = Modifier)
{

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    var fullName by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current

    fun signup(nama: String, email: String, password: String) {
        isLoading = true
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val signupinfo = SignUpBody(nama, email, password)

        retIn.signup(signupinfo).enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                isLoading = false
                Toast.makeText(context, "Signup failed: ${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                isLoading = false
                if (response.isSuccessful && response.code() == 201) {
                    val responseBody = response.body()?.string()
                    val jsonObject = responseBody?.let { JSONObject(it) }
                    val token = jsonObject?.getString("token")
                    Toast.makeText(context, "Signup success!", Toast.LENGTH_SHORT).show()
                    navController.navigate("home")

                    val sharedPreferences = context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
                    sharedPreferences.edit().putString("access_token", token).apply()

                } else {
                    val errorBody = response.errorBody()?.string() ?: "Unknown error"
                    Log.d("REGISTER_USER_BARU", errorBody)
                    Toast.makeText(context, "Error:${errorBody}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    Box(
        modifier = modifier
            .width(400.dp)
            .height(620.dp)
            .background(
                Color.White,
                shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp) // Rounded corners only at the top
            )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Nama Lengkap",
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                modifier = Modifier.padding(8.dp)
            )

            OutlinedTextField(
                value = fullName,
                onValueChange = { fullName = it },
                placeholder = {
                    Text(
                        "Masukkan nama lengkap",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = AbuBiruTua,
                            fontSize = 14.sp
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(51.dp),
                textStyle = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = AbuBiruMuda
                ),
                shape = RoundedCornerShape(size = 9.dp)
            )

            Text(
                text = "Alamat Email",
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                modifier = Modifier.padding(8.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text(
                        "contoh@gmail.com",
                        style = TextStyle(
                            color = AbuBiruTua,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(51.dp),
                textStyle = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = AbuBiruMuda
                ),
                shape = RoundedCornerShape(size = 9.dp)
            )

            Text(
                text = "Kata Sandi",
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                modifier = Modifier.padding(8.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("**************") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(51.dp),
                textStyle = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = AbuBiruTua
                ),
                shape = RoundedCornerShape(size = 9.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Coklat,
                        uncheckedColor = Abuabu
                    )
                )

                Text(
                    text = "Ingat saya",
                    color = AbuBiruTua,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    modifier = Modifier.padding(start = 4.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                ClickableText(
                    text = AnnotatedString("Lupa kata sandi?"),
                    onClick = { /* Handle forgot password */ },
                    style = TextStyle(
                        color = Color.Blue,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { signup(fullName, email, password) },
                    colors = ButtonDefaults.buttonColors(containerColor = Coklat),
                    shape = RoundedCornerShape(size = 6.dp),
                    modifier = modifier
                        .width(300.dp)
                        .height(50.dp)
                        .padding(5.dp)
                ) {
                    Text(
                        "Masuk",
                        color = putih,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                }
            }

            Box(
                modifier = modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {   },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Coklat
                    ),
                    border = BorderStroke(1.dp, Coklat),
                    shape = RoundedCornerShape(size = 6.dp),
                    modifier = modifier
                        .width(288.dp)
                        .height(55.dp)
                        .padding(vertical = 8.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_google),
                            contentDescription = "Google Logo",
                            modifier = modifier.size(24.dp)
                        )
                        Spacer(modifier = modifier.width(8.dp))
                        Text(
                            text = "Masuk dengan Google",
                            color = Coklat,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold))
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Apakah anda belum memiliki akun?",
                    color = Abuabu,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
                Spacer(modifier = Modifier.width(4.dp))
                ClickableText(
                    text = AnnotatedString("Masuk Akun"),
                    onClick = { navController.navigate("login")  },
                    style = TextStyle(
                        color = Color.Blue,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                )
            }
        }
    }
}

