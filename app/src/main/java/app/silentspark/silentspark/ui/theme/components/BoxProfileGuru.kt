package app.silentspark.silentspark.ui.theme.components


import app.silentspark.silentspark.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.silentspark.silentspark.dummy.DataDummy
import app.silentspark.silentspark.model.ProfileGuru
import app.silentspark.silentspark.ui.theme.theme.Abuabu
import app.silentspark.silentspark.ui.theme.theme.Coklat
import app.silentspark.silentspark.ui.theme.theme.KuningMuda
import app.silentspark.silentspark.ui.theme.theme.putih

@Composable
fun BoxProfileGuru(
    navController: NavHostController,
    price: String,
    namareview: String,
    textreview: String,
    initialRating: Int,
    buttonText: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    profileGuru: ProfileGuru? = null // Initialize with null to handle case where profileGuru is null
) {
    val currentProfileGuru = profileGuru ?: remember { DataDummy.profileGuru }

    var rating by rememberSaveable { mutableIntStateOf(initialRating) }
    var isButtonClicked by remember { mutableStateOf(false) }
    val buttonColor = if (isButtonClicked) KuningMuda else Abuabu // Replace with your colors

    Box(
        modifier = modifier
            .width(400.dp)
            .height(950.dp)
            .background(
                Color.White,
                shape = RoundedCornerShape(
                    topStart = 25.dp, topEnd = 25.dp
                )
            )
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)

        ) {
            Text(
                text = "Tentang ${currentProfileGuru.name ?: "Tidak ada Nama"}",
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            )
            Text(
                text = currentProfileGuru.about ?: "Tidak ada Detail Guru",
                color = Coklat,
                fontSize = 14.sp,
                textAlign = TextAlign.Justify,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                modifier = Modifier.padding(bottom = 8.dp),
            )

            Text(
                text = "Detail Kelas",
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            )
            Text(
                text = currentProfileGuru.detail_class ?: "Tidak ada detail kelas",
                color = Coklat,
                fontSize = 14.sp,
                textAlign = TextAlign.Justify,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                modifier = Modifier.padding(bottom = 8.dp),
            )

            Text(
                text = "Detail Tarif",
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            )

            Column(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = price,
                        color = Coklat,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Justify,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        modifier = modifier.padding(bottom = 8.dp, start = 10.dp),
                    )
                    Button(
                        onClick = { isButtonClicked = !isButtonClicked },
                        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
                        shape = RoundedCornerShape(size = 6.dp),
                        modifier = modifier
                            .width(150.dp)
                            .height(42.dp)
                            .padding(5.dp)

                    ) {
                        Text(
                            text = buttonText,
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold))
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = price,
                        color = Coklat,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Justify,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        modifier = modifier.padding(bottom = 8.dp, start = 10.dp),
                    )
                    Button(
                        onClick = { isButtonClicked = !isButtonClicked },
                        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
                        shape = RoundedCornerShape(size = 6.dp),
                        modifier = modifier
                            .width(150.dp)
                            .height(42.dp)
                            .padding(5.dp)

                    ) {
                        Text(
                            text = buttonText,
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold))
                        )
                    }
                }

            }

            Text(
                text = "Hubungi",
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            )
            Text(
                text = currentProfileGuru.email ?: "Email Tidak Ditemukan",
                color = Color.Blue,
                fontSize = 14.sp,
                textAlign = TextAlign.Justify,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                modifier = Modifier.padding(bottom = 8.dp),
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
                        .padding(vertical = 5.dp)
                ) {
                    Icon(
                        imageVector =Icons.Filled.Whatsapp,
                        contentDescription = null,
                        tint = putih,
                        modifier = Modifier
                            .size(30.dp)

                    )
                    Spacer(modifier = modifier.width(8.dp))
                    Text(
                        text = "WhatsApp",
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = putih,
                        fontSize = 12.sp,


                        )
                }
            }
            Spacer(modifier = modifier.height(8.dp))

            Text(
                text = "Apa Kata Mereka",
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            )
            Row(
                modifier = Modifier.padding(top = 8.dp, start = 8.dp)
            ) {
                Image(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(70.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.img_dummy),
                    contentDescription = "",
                    alignment = Alignment.TopCenter,
                )
                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Text(text = namareview,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        fontSize = 14.sp,
                        color = Coklat,
                    )
                    RatingBar(rating = rating) { newRating ->
                        rating = newRating
                    }
                    Text(text = textreview,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 14.sp,
                        color = Coklat,
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {navController.navigate("rincian_pesanan")},
                    colors = ButtonDefaults.buttonColors(containerColor = Coklat),
                    shape = RoundedCornerShape(size = 6.dp),
                    modifier = modifier
                        .width(300.dp)
                        .height(50.dp)
                        .padding(5.dp)
                ) {
                    Text(
                        "Buat Pesanan",
                        color = putih,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                }
            }
        }

    }
}

@Composable
fun RatingBar(rating: Int, onRatingChanged: (Int) -> Unit) {
    Row {
        for (i in 1..5) {
            Icon(
                imageVector = if (i <= rating) Icons.Filled.Star else Icons.Filled.StarBorder,
                contentDescription = null,
                tint = Color(0xFFFFD700), // Warna bintang (emas)
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 4.dp)
                    .clickable { onRatingChanged(i) }
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun PreviewBoxProfileGuru() {
    BoxProfileGuru(
        navController = rememberNavController(),
        price = "1 Bulan",
        namareview = "Angga",
        textreview = "Beli kelas selama tiga bulan, pembelajarannya menarik dan mudah dimengerti. Alhamdulillah dua bulan juga udah mulai paham dan bisa mempraktekan.",
        initialRating = 4, // Set nilai initialRating agar bintang terlihat
        buttonText = "Rp 980.000",
        onButtonClick = { /* Handle button click */},
        profileGuru = DataDummy.profileGuru
    )
}



