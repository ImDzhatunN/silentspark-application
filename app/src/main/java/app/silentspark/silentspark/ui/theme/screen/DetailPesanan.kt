package app.silentspark.silentspark.ui.theme.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.silentspark.silentspark.R
import app.silentspark.silentspark.navigation.Screen
import app.silentspark.silentspark.ui.theme.components.ButtonNext
import app.silentspark.silentspark.ui.theme.components.CompDetailPesanan
import app.silentspark.silentspark.ui.theme.theme.poppinsFamily

@Composable
fun DetailPesanan(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .padding(vertical = 8.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "",
                    modifier = Modifier
                        .size(42.dp)
                        .clickable { navController.popBackStack() },
                    contentScale = ContentScale.FillWidth,
                )
                Text(
                    text = "Detail Pesanan",
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFamily,
                    color = Color.Gray
                )
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                CompDetailPesanan()
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)

            ) {
                Text(
                    text = "Tentukan Jadwal Kelas Anda",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp)
            ) {
                Text(
                    text = "Pesan Anda",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.dropkosong),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .size(50.dp)
                )
                Text(
                    text = "Informasi Kontak",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(top = 32.dp)
                )
                Text(
                    text = "Informasi Anda akan diberikan kepada guru yang telah Anda pilih",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp
                )
                Text(
                    text = "Nama Lengkap",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.dropkosong),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .size(50.dp)
                )
                Text(
                    text = "Nama Belakang",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.dropkosong),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .size(50.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ButtonNext(
                    text = "Selanjutnya",
                    onClick = {
                        navController.navigate(Screen.PaymentFlow.route)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailPesananPreview() {
    DetailPesanan(navController = rememberNavController())
}
