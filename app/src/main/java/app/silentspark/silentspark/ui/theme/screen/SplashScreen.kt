package app.silentspark.silentspark.ui.theme.screen

import app.silentspark.silentspark.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import app.silentspark.silentspark.ui.theme.components.ButtonGetStarted
import app.silentspark.silentspark.ui.theme.theme.putih

@Composable
fun SplashScreen(
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF67725F)),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF67725F)),
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.splash),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(157.dp)
                    .width(161.dp)
            )
            Spacer(modifier = Modifier.height(52.dp))
            Text(
                text = "Selamat Datang di",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleSmall.copy(
                    color = putih, fontFamily = FontFamily(
                        Font(R.font.poppins_semibold)
                    )
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Silent Spark",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleSmall.copy(
                    color = putih, fontFamily = FontFamily(
                        Font(R.font.poppins_semibold)
                    )
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Belajar dan Mengajar Bahasa Isyarat Praktis, Dimanapun dan Kapanpun",
                fontSize = 14.sp,
                style = MaterialTheme.typography.titleSmall.copy(
                    color = putih, fontFamily = FontFamily(
                        Font(R.font.poppins_regular)
                    )
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(26.dp))
            Column(
                modifier = Modifier.padding(start = 16.dp, top = 10.dp, end = 16.dp, bottom = 10.dp)
            ) {

                ButtonGetStarted(navController= navController)
            }
        }
    }
}


