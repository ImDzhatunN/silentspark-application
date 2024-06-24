package app.silentspark.silentspark.ui.theme.components.detailkelas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.silentspark.silentspark.R
import app.silentspark.silentspark.ui.theme.theme.Coklat
import app.silentspark.silentspark.ui.theme.theme.SilentSparkTheme

@Composable
fun AksesKelas(
    modifier: Modifier = Modifier,
    topik : String,
    linkzoom : String,

    ) {
    Box(
        modifier = modifier
            .width(360.dp)
            .height(270.dp)
            .background(
                Color(0xFF67725F).copy(alpha = 0.15f),
                shape = RoundedCornerShape(25.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Akses Kelas",
                color = Coklat,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Topik",
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            )
            Text(
                text = topik,
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Link Zoom",
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            )
            Text(
                text = linkzoom,
                color = Color.Blue,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
            )


        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    SilentSparkTheme {
       AksesKelas(
            topik = "Memahami macam isyarat (Isyando, ASL, BISINDO",
           linkzoom = "https://us06web.zoom.us/j/89554588370?pwd=fQTIuqCON8Y3AIjo9gGxyRpkMeFOt0.1"

        )
    }
}