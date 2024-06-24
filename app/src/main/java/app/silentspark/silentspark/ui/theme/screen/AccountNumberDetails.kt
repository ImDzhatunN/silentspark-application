package app.silentspark.silentspark.ui.theme.screen

import app.silentspark.silentspark.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import app.silentspark.silentspark.ui.theme.components.AnumDetails
import app.silentspark.silentspark.ui.theme.components.PreviewButtonNext
import app.silentspark.silentspark.ui.theme.theme.poppinsFamily

@Composable
fun AccountNumberDetails() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
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
            Text(
                text = "Pembayaran",
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFamily,
                color = Color.Gray
            )
        }
        Column (
            modifier = Modifier
                .padding(16.dp)
        ) {
            AnumDetails()
        }
        Row(
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            PreviewButtonNext()
        }
        Text(
            text = "Data pribadi Anda akan digunakan untuk kepentingan pemesanan, mendukung pengalaman Anda di website ini, dan untuk tujuan lain yang dijelaskan dalam kebijakan privasi kami",
            fontWeight = FontWeight.Normal,
            fontFamily = poppinsFamily,
            fontSize = 10.sp,
            color = colorResource(id = R.color.text2),
            modifier = Modifier
                .padding(start = 42.dp, top = 8.dp, end = 42.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewAccountNumberDetails() {
    AccountNumberDetails()
}