package app.silentspark.silentspark.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import app.silentspark.silentspark.R
import app.silentspark.silentspark.dummy.DataDummy
import app.silentspark.silentspark.ui.theme.components.BoxProfileGuru
import app.silentspark.silentspark.ui.theme.components.RatingBar
import app.silentspark.silentspark.ui.theme.theme.Green
import app.silentspark.silentspark.ui.theme.theme.putih

@Composable
fun ProfileSiswa(
    modifier: Modifier = Modifier,
    teacherrating: Int,
    onBackClick: () -> Unit = {},
) {
    var rating by rememberSaveable { mutableIntStateOf( teacherrating) }
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Green)
            .verticalScroll(scrollState)
    ){
        Row (modifier = modifier
            .padding(top = 15.dp, start = 15.dp)
        ) {
            Image(
                modifier = modifier
                    .width(38.dp)
                    .height(39.dp),
                painter = painterResource(id = R.drawable.ic_topbar),
                contentDescription = "navigation kembali",
            )
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = "Profile Guru",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = putih
                ),
                modifier = modifier.padding(end = 16.dp)
            )
        }
        Spacer(modifier = modifier.height(32.dp))
        Row {
            Image(
                painter = painterResource(R.drawable.teacher),
                contentDescription = "",
                modifier = modifier
                    .size(width = 150.dp, height = 100.dp)
                    .padding(start = 35.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Column(modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp)) {
                Text(
                    text = "Bianca Savador",
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = putih,
                    fontSize = 16.sp,
                )
                RatingBar(rating = rating) { newRating ->
                    rating = newRating
                }
                Text(
                    buildAnnotatedString {
                        append("4.9/")
                        withStyle(style = SpanStyle(fontSize = 14.sp)
                        ) {
                            append("5")
                        }
                    },
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = putih,
                    fontSize = 14.sp,
                    letterSpacing = 1.sp
                )
            }

        }
        Spacer(modifier = modifier.height(32.dp))

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            BoxProfileGuru(

                navController = rememberNavController(),
                price = "3 bulan",
                namareview = "Angga",
                textreview = "\"Beli kelas selama tiga bulan, pembelajarannya menarik dan mudah dimengerti. Alhamdulillah dua bulan juga udah mulai paham dan bisa mempraktekan.",
                initialRating = 4,
                buttonText = "Rp680.000",
                profileGuru = DataDummy.profileGuru,
                onButtonClick = { /*TODO*/ })
        }

    }

}

@Composable
fun Teacherrating(rating: Float,  onRatingChanged: (Int) -> Unit) {
    Row {
        for (i in 1..5) {
            Icon(
                imageVector = if (i <= rating) Icons.Filled.Star else Icons.Filled.StarBorder,
                contentDescription = null,
                tint = Color(0xFFFFD700),
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 4.dp)
                    .clickable { onRatingChanged(i) }
            )
        }
    }
}

