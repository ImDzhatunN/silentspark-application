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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.silentspark.silentspark.ui.theme.components.PreviewButtonLihat_Kelas
import app.silentspark.silentspark.ui.theme.theme.poppinsFamily

@Composable
fun PaymentComplete() {
    Column(
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
        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                text = "Terima Kasih Atas Pembelian Anda",
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
                painter = painterResource(id = R.drawable.checklist),
                contentDescription = ""
            )
        }
        Text(
            text = "Pembayaran Selesai",
            fontWeight = FontWeight.SemiBold,
            fontFamily = poppinsFamily,
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            PreviewButtonLihat_Kelas()
        }
        Text(
            text = "Dapatkan Tanda Terima",
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = colorResource(id = R.color.text2),
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPaymentComplete() {
    PaymentComplete()
}