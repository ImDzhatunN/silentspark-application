package app.silentspark.silentspark.ui.theme.components

import app.silentspark.silentspark.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.silentspark.silentspark.ui.theme.theme.poppinsFamily
import app.silentspark.silentspark.ui.theme.theme.putih

@Composable
fun AnumDetails(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .background(color = Color.Green)
    ) {
        Column(modifier.padding(start = 24.dp, top = 16.dp, bottom = 16.dp, end = 24.dp)) {
            Text(
                text ="Bayar Dengan :",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                color = putih,
                fontSize = 14.sp,
            )
            Spacer(modifier = modifier.padding(bottom = 16.dp))

            Row(modifier.padding(end = 8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ellips),
                    contentDescription = "",
                    modifier = modifier
                        .size(22.dp)
                )
                Column (modifier = Modifier.padding(start = 8.dp)){}
                Text(
                    text = "E-Wallet",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    color = putih,
                    fontSize = 14.sp,
                    modifier = modifier
                        .clickable {  }
                )
            }

            Row(modifier.padding(top = 8.dp)){
                Image(
                    painter = painterResource(id = R.drawable.ellips),
                    contentDescription = "",
                    modifier = modifier
                        .size(22.dp)
                )
                Column (modifier = Modifier.padding(start = 8.dp)){}
                Text(
                    text = "Bank",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    color = putih,
                    fontSize = 14.sp,
                    modifier = modifier
                        .clickable {  }
                )
            }
            Spacer(modifier = modifier.padding(bottom = 16.dp))
            Image(
                painter = painterResource(id = R.drawable.dropdown),
                contentDescription = "",
                modifier = modifier
                    .fillMaxWidth()
                    .size(width = 56.dp, height = 64.dp)
                    .clickable { }
            )
            Spacer(modifier = modifier.padding(bottom = 8.dp))
            Text(
                text = "Masukkan Nomor Akun Bank kamu",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                color = putih,
                fontSize = 14.sp
            )
            Image(
                painter = painterResource(id = R.drawable.dropkosong),
                contentDescription ="",
                modifier = modifier
                    .fillMaxWidth()
                    .size(width = 56.dp, height = 64.dp)
                    .clickable { }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAnumDetailst() {
    AnumDetails()
}