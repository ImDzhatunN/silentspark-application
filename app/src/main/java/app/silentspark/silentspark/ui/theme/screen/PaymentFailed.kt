package app.silentspark.silentspark.ui.theme.screen

import app.silentspark.silentspark.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.silentspark.silentspark.ui.theme.components.PreviewButtonTutup
import app.silentspark.silentspark.ui.theme.theme.poppinsFamily


@Composable
fun PaymentFailed() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(42.dp)
                    .clickable { },
                contentScale = ContentScale.FillWidth,
                painter = painterResource(id = R.drawable.back),
                contentDescription = "",
                alignment = Alignment.Center,
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        ) {
            Text(
                text = "Transaksi tidak dapat diproses",
                fontWeight = FontWeight.Normal,
                fontFamily = poppinsFamily,
                fontSize = 16.sp
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(200.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.failedicon),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                text = "Pesanan ########## Dikonfirmasi",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
            Text(
                text = "Transaksi gagal",
                fontFamily = poppinsFamily,
                color = Color.Red
            )
        }
        Row (
            modifier = Modifier
                .padding(top = 16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            PreviewButtonTutup()
        }
        Column (
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        ) {
            Text(
                text = "Coba Ulangi Transaksi",
                fontFamily = poppinsFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.text2)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPaymentFailed() {
    PaymentFailed()
}