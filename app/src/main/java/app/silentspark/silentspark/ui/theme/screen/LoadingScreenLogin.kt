package app.silentspark.silentspark.ui.theme.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.silentspark.silentspark.R
import app.silentspark.silentspark.controller.ApiInterface
import app.silentspark.silentspark.controller.RetrofitInstance
import app.silentspark.silentspark.ui.theme.theme.Green
import app.silentspark.silentspark.ui.theme.theme.putih
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoadingScreenLogin(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(true) }
    var message by remember { mutableStateOf("Sedang Login ...") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator(color = putih)
            Spacer(modifier = Modifier.height(16.dp))
        }
        Text(
            text = message,
            style = TextStyle(
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = putih
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLoadingScreenLogin() {
    LoadingScreenLogin(navController = rememberNavController())
}
