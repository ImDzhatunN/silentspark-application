package app.silentspark.silentspark.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
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
import androidx.compose.foundation.layout.*


@Composable
fun BoxTandaTerima(
    modifier: Modifier = Modifier,
    name : String,
    date : String,
    tagihan : String,
    sesi : String,
    metodepembayaran : String,
    status : String,
    total : String,

    ) {
    Box(
        modifier = modifier
            .width(360.dp)
            .height(360.dp)
            .background(
                Color(0xFF67725F).copy(alpha = 0.15f),
                shape = RoundedCornerShape(25.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .padding(top = 24.dp)
        ) {
            Text(
                text = "Rincian Pembayaran",
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 14.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Nama Guru",
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
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
                    text = "Tanggal",
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
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
                    text = "Tagihan",
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                )
                Text(
                    text = tagihan,
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
                    text = "Sesi",
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                )
                Text(
                    text = sesi,
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
                    text = "Pilihan Pembayaran",
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                )
                Text(
                    text = metodepembayaran,
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
                    text = "Status",
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                )
                Text(
                    text = status,
                    color = Coklat,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                )
            }
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 13.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Total",
                    color = Coklat,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                )
                Text(
                    text = total,
                    color = Coklat,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    SilentSparkTheme {
        BoxTandaTerima(
            name = "Bianca Savador",
            date = "15 Mei 2024",
            tagihan = "Rp 680.000",
            sesi = "2 Bulan",
            metodepembayaran = "Shopee Pay",
            status = "Menunggu Pembayaran",
            total = "Rp 680.000"
        )
    }
}