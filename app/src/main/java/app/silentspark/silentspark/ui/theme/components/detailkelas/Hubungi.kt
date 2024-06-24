package app.silentspark.silentspark.ui.theme.components.detailkelas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.silentspark.silentspark.R
import app.silentspark.silentspark.ui.theme.theme.Coklat
import app.silentspark.silentspark.ui.theme.theme.SilentSparkTheme
import app.silentspark.silentspark.ui.theme.theme.putih

@Composable
fun Hubungi(
    modifier: Modifier = Modifier,
    email : String,
    navController: NavHostController
) {

    Box(
        modifier = modifier
            .width(360.dp)
            .height(250.dp)
            .background(
                Color(0xFF67725F).copy(alpha = 0.15f),
                shape = RoundedCornerShape(25.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Hubungi",
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            )
            Text(
                text = email,
                color = Color.Blue,
                fontSize = 14.sp,
                textAlign = TextAlign.Justify,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
            )
            Box(
                modifier = modifier.fillMaxWidth(),
            ) {
                Button(
                    onClick = { /* Handle Google login click */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF22C55E),
                        contentColor = Coklat
                    ),
                    shape = RoundedCornerShape(size = 50.dp),
                    modifier = modifier
                        .width(170.dp)
                        .height(46.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Whatsapp,
                        contentDescription = null,
                        tint = putih,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {  }
                    )
                    Text(
                        text = "WhatsApp",
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = putih,
                        fontSize = 12.sp,

                        )

                }
            }

            Text(
                text = "Ulasan",
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = modifier
                        .width(38.dp)
                        .height(39.dp),
                    painter = painterResource(id = R.drawable.ic_tambah),
                    contentDescription = "Tambahkan Ulasan",
                )
                Text(
                    text = "Tambah Ulasan",
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    modifier = Modifier.padding(9.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    val navController = rememberNavController()
    SilentSparkTheme {
        Hubungi(
            email = "biancasavandor@gmail.com",
            navController = navController
        )
    }
}
