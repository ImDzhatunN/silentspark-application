package app.silentspark.silentspark.ui.theme.components

import app.silentspark.silentspark.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.silentspark.silentspark.ui.theme.theme.Hijau
import app.silentspark.silentspark.ui.theme.theme.poppinsFamily
import app.silentspark.silentspark.ui.theme.theme.putih

@Composable
fun CompDetailPesanan(
    modifier: Modifier = Modifier
) { Box(modifier = modifier
    .clip(RoundedCornerShape(16.dp))
    .fillMaxWidth()
    .background(color = Hijau)
) {
    Column (modifier.padding(16.dp).fillMaxWidth().align(Alignment.Center)){
        Box(modifier = Modifier
            .size(150.dp)
            .padding(16.dp)
            .align(Alignment.CenterHorizontally)
        ) {
            Image( modifier = modifier
                .size(150.dp)
                .align(Alignment.Center),
                painter = painterResource(id = R.drawable.fotodetailpesanan), contentDescription = "")
        }
        Row (modifier = modifier
            .padding(start =16.dp, end=16.dp, bottom = 8.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Harga",
                fontFamily = poppinsFamily,
                fontSize= 12.sp,
                fontWeight = FontWeight.Medium,
                color = putih
            )
            Text(text = "Rp.980.000/bulan",
                fontFamily = poppinsFamily,
                fontSize= 12.sp,
                fontWeight = FontWeight.Medium,
                color = putih
            )
        }
        Row (modifier = modifier
            .padding(start =16.dp, end=16.dp, bottom = 8.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Nama",
                fontFamily = poppinsFamily,
                fontSize= 12.sp,
                fontWeight = FontWeight.Medium,
                color = putih
            )
            Text(text = "Bianca Savador",
                fontFamily = poppinsFamily,
                fontSize= 12.sp,
                fontWeight = FontWeight.Medium,
                color = putih
            )
        }
        Row (modifier = modifier
            .padding(start =16.dp, end=16.dp, bottom = 8.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Sertifikat",
                fontFamily = poppinsFamily,
                fontSize= 12.sp,
                fontWeight = FontWeight.Medium,
                color = putih
            )
            Text(text = "Tersedia",
                fontFamily = poppinsFamily,
                fontSize= 12.sp,
                fontWeight = FontWeight.Medium,
                color = putih
            )
        }
        Row (modifier = modifier
            .padding(start =16.dp, end=16.dp, bottom = 8.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Bahasa",
                fontFamily = poppinsFamily,
                fontSize= 12.sp,
                fontWeight = FontWeight.Medium,
                color = putih
            )
            Text(text = "Indonesia|Inggris",
                fontFamily = poppinsFamily,
                fontSize= 12.sp,
                fontWeight = FontWeight.Medium,
                color = putih
            )
        }
        Row (modifier = modifier
            .padding(start =16.dp, end=16.dp, bottom = 8.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Ketersediaan",
                fontFamily = poppinsFamily,
                fontSize= 12.sp,
                fontWeight = FontWeight.Medium,
                color = putih
            )
            Text(text = "07.00-22.00 WIB",
                fontFamily = poppinsFamily,
                fontSize= 12.sp,
                fontWeight = FontWeight.Medium,
                color = putih
            )
        }
    }
}
}

@Preview(showBackground = false)
@Composable
private fun CompDetailPesananPreview() {
    CompDetailPesanan()
}