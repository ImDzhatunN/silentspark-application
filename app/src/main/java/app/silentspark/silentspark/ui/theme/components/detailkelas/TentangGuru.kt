package app.silentspark.silentspark.ui.theme.components.detailkelas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.silentspark.silentspark.R
import app.silentspark.silentspark.ui.theme.theme.Coklat
import app.silentspark.silentspark.ui.theme.theme.SilentSparkTheme

@Composable
fun TentangGuru(
    modifier: Modifier = Modifier,
    name : String,
    date : String,
    bahasa : String,
    sesi : String

    ) {
    Box(
        modifier = modifier
            .width(360.dp)
            .height(200.dp)
            .background(
                Color(0xFF67725F).copy(alpha = 0.15f),
                shape = RoundedCornerShape(25.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .padding(top = 24.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Nama",
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                )
                Text(
                    text = name,
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = "Sisa Sesi Perhari",
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                )
                Text(
                    text = date,
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Bahasa",
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                )
                Text(
                    text = bahasa,
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Selesai",
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                )
                Text(
                    text = sesi,
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                )

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    SilentSparkTheme {
        TentangGuru(
            name = "Bianca Savador",
            date = "15 Mei 2024",
            bahasa = "Indonesia | Inggris",
            sesi = "Selesai"
        )
    }
}