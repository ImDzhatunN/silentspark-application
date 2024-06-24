package app.silentspark.silentspark.ui.theme.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.silentspark.silentspark.R
import app.silentspark.silentspark.navigation.Screen
import app.silentspark.silentspark.ui.theme.components.ButtonNext
import app.silentspark.silentspark.ui.theme.theme.Coklat
import app.silentspark.silentspark.ui.theme.theme.CoklatMuda
import app.silentspark.silentspark.ui.theme.theme.ijolumut
import app.silentspark.silentspark.ui.theme.theme.ijoo

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun RincianPesananScreen(navController : NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.buttonhijau),
                            contentDescription = "Icon",
                            modifier = Modifier
                                .width(38.dp)
                                .height(39.dp)
                                .clickable { navController.popBackStack() }
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "Rincian Pesanan",
                            style = MaterialTheme.typography.titleSmall.copy(
                                color = ijolumut,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            ),
                            textAlign = TextAlign.End,
                            modifier = Modifier.padding(end = 20.dp)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .wrapContentSize() // Adjust box to wrap content size
                    .clip(RoundedCornerShape(16.dp))
                    .border(BorderStroke(2.dp, Color.Gray), shape = RoundedCornerShape(16.dp))
                    .background(ijoo)
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentSize() // Adjust column to wrap content size
                        .padding(20.dp),
                    verticalArrangement = Arrangement.Top
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.bianca_savador),
                            contentDescription = null,
                            modifier = Modifier
                                .size(110.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(
                            verticalArrangement = Arrangement.Top,
                            modifier = Modifier.height(100.dp)
                        ) {
                            Text(
                                text = "Bianca Savador",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                                color = Color.White
                            )
                            Text(
                                text = "Belajar Bahasa Isyarat 1 Bulan",
                                fontSize = 11.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Rp 980.000,00",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Divider(color = Color.Gray, thickness = 2.dp)
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Biaya Registrasi",
                            fontSize = 12.sp,
                            color = Coklat,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            modifier = Modifier
                                .padding(1.5.dp)
                                .width(145.dp)
                                .height(45.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(size = 9.dp)
                                )
                                .padding(start = 16.dp, top = 14.dp, end = 16.dp, bottom = 14.dp),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Digunakan",
                            fontSize = 12.sp,
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            modifier = Modifier
                                .padding(1.5.dp)
                                .width(115.dp)
                                .height(47.dp)
                                .background(
                                    color = CoklatMuda,
                                    shape = RoundedCornerShape(size = 9.dp)
                                )
                                .padding(start = 16.dp, top = 14.dp, end = 16.dp, bottom = 14.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Biaya Umum",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            color = Color.White
                        )
                        Text(
                            text = "-",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Biaya Registrasi",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            color = Color.White
                        )
                        Text(
                            text = "Rp 100.000,00",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Divider(color = Color.Gray, thickness = 2.dp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Total",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "Rp 100.000,00",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                ButtonNext(text = "Selanjutnya", onClick = {navController.navigate(Screen.DetailPesanan.route)
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RincianPesananScreenPreview() {
    RincianPesananScreen(navController = rememberNavController())
}
