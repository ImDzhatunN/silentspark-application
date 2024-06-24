package app.silentspark.silentspark.ui.theme.screen

import app.silentspark.silentspark.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.silentspark.silentspark.ui.theme.components.BoxLogin
import app.silentspark.silentspark.ui.theme.theme.Green
import app.silentspark.silentspark.ui.theme.theme.putih
@Composable
fun LoginScreen (
    navController: NavHostController,
    modifier: Modifier = Modifier,

    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Green)
    ){
        Row ( horizontalArrangement = Arrangement.End
        ) { Spacer(modifier = modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.shape1),
                contentDescription = "")
        }
    }
    Column {
        Row (modifier = modifier
            .padding(top = 15.dp, start = 15.dp)
        ) {
            Image(
                modifier = modifier
                    .width(38.dp)
                    .height(39.dp),
                painter = painterResource(id = R.drawable.ic_topbar),
                contentDescription = "navigation kembali",
            )
        }
    }
    Spacer(modifier = modifier.height(32.dp))


    Box(
        modifier = modifier
            .width(292.24091.dp)
            .height(482.29288.dp)
            .padding(top = 74.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.shape2), // Replace with your shape resource
            contentDescription = "",
            modifier = modifier
                .fillMaxSize()
                .align(Alignment.Center)
        )
        Column(
            modifier = modifier
                .align(Alignment.Center)
                .padding(16.dp)
                .offset(y = (-130).dp),
        ) {
            Text(
                text = "Daftarkan Akun Anda",
                style = TextStyle(
                    fontSize = 22.sp,
                    lineHeight = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = putih
                )

            )

            Text(
                text = "Bersiaplah untuk terhubung, belajar, dan menginspirasi di dalamnya. Mari kita mulai!",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = putih
                )
            )
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        BoxLogin(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSignInScreen(){
    LoginScreen(navController = rememberNavController())
}





