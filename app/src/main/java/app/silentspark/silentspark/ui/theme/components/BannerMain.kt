package app.silentspark.silentspark.ui.theme.components

import app.silentspark.silentspark.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.silentspark.silentspark.ui.theme.theme.Coklat
import app.silentspark.silentspark.ui.theme.theme.SilentSparkTheme
import app.silentspark.silentspark.ui.theme.theme.colorLinear1
import app.silentspark.silentspark.ui.theme.theme.colorLinear2
import app.silentspark.silentspark.ui.theme.theme.poppinsFamily
import app.silentspark.silentspark.ui.theme.theme.putih

@Composable
fun BannerMain(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorLinear1, colorLinear2
                    ),
                )
            )

    ) {
        Row {
            Image(
                alignment = Alignment.TopCenter,
                painter = painterResource(id = R.drawable.img_main_banner),
                contentDescription = "",
                modifier = modifier
                    .size(110.dp)
                    .padding( start = 16.dp)
            )

            Column(modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp)) {
                Text(
                    text = "Layanan Bahasa Isyarat",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Bold,
                    color = Coklat,
                    fontSize = 14.sp,
                )
                Text(
                    text = stringResource(id = R.string.baris2),
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = putih,
                    fontSize = 12.sp,
                    lineHeight = 15.sp,
                    letterSpacing = 1.sp

                )
                Text(
                    text = stringResource(id = R.string.baris3),
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    color = putih,
                    lineHeight = 15.sp,
                    fontSize = 12.sp,
                )
            }
        }
    }
}

@Composable
@Preview
private fun Preview() {
    SilentSparkTheme {
        BannerMain()
    }
}