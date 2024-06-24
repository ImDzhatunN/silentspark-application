package app.silentspark.silentspark.ui.theme.components

import app.silentspark.silentspark.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.silentspark.silentspark.ui.theme.theme.KuningMuda
import app.silentspark.silentspark.ui.theme.theme.SilentSparkTheme
import app.silentspark.silentspark.ui.theme.theme.putih
@Composable
fun ItemBeranda(
    modifier: Modifier = Modifier,
//    image: Int,
    title: String,
    desc: String,
    price: String,
) {

    Box(
        modifier = modifier
            .width(460.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(KuningMuda)

    ) {
        Row {
//            Image(
//                painter = painterResource(image),
//                contentDescription = "",
//                modifier = Modifier
//                    .size(width = 90.dp, height = 75.dp)
//                    .padding(start = 16.dp)
//                    .align(Alignment.CenterVertically)
//                    .clip(RoundedCornerShape(7.dp)),
//                contentScale = ContentScale.Crop
//            )

            Column(modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp)) {
                Text(
                    text = title,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = putih,
                    fontSize = 16.sp,
                    letterSpacing = 0.2.sp
                )
                Text(
                    text = desc,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    color = putih,
                    lineHeight = 15.sp,
                    fontSize = 14.sp,
                    letterSpacing = 0.2.sp
                )
                Text(
                    text = price,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = putih,
                    fontSize = 14.sp,
                    letterSpacing = 0.2.sp
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .align(Alignment.BottomEnd),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_stars),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterVertically) // Posisi vertikal di tengah
            )

            Text(
                text = "(50)",
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = putih,
                fontSize = 12.sp,
                letterSpacing = 0.2.sp,
                modifier = Modifier.align(Alignment.CenterVertically) // Posisi vertikal di tengah
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun Preview() {
    SilentSparkTheme {
        ItemBeranda(
//            image = R.drawable.illus_teach,
            title = "Bianca Savador",
            desc = stringResource(id = R.string.lorem),
            price = "Rp 100.000"
        )
    }
}