package app.silentspark.silentspark.ui.theme.components

import app.silentspark.silentspark.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.silentspark.silentspark.model.Kelas
import app.silentspark.silentspark.ui.theme.theme.Abuabu
import app.silentspark.silentspark.ui.theme.theme.Coklat

@Composable
fun ItemRowKelas(
    modifier: Modifier = Modifier,
    statusColour: Color,
    textColor: Color,
    kelas: Kelas,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                Color(0xFF67725F).copy(alpha = 0.15f),
                shape = RoundedCornerShape(15.dp)
            )
            .clickable(onClick = onClick)
    ) {
        Row {
//            Image(
//                painter = painterResource(kelas.image),
//                contentDescription = "",
//                modifier = modifier
//                    .size(width = 90.dp, height = 75.dp)
//                    .padding(start = 16.dp)
//                    .align(Alignment.CenterVertically)
//                    .clip(RoundedCornerShape(7.dp)),
//                contentScale = ContentScale.Crop
//            )

            Column(modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp)) {
                Text(
                    text = kelas.title,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = Coklat,
                    fontSize = 16.sp,
                    letterSpacing = 0.2.sp
                )
                Text(
                    text = kelas.description ?: "-",
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = Abuabu,
                    fontSize = 14.sp,
                    letterSpacing = 0.2.sp
                )
                Text(
                    text = kelas.bulan,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = Abuabu,
                    fontSize = 14.sp,
                    letterSpacing = 0.2.sp
                )

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(8.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Button(
                        onClick = { /* Handle sign up click */ },
                        colors = ButtonDefaults.buttonColors(statusColour),
                        shape = RoundedCornerShape(size = 10.dp),
                        modifier = Modifier
                            .width(180.dp)
                            .height(35.dp)
                    ) {
                        Text(
                            text = kelas.status,
                            color = textColor,
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold))
                        )
                    }
                }
            }
            Spacer(modifier = modifier.weight(10f))
            Box(
                modifier = Modifier
                    .fillMaxHeight(),
            ) {
                Image(
                    alignment = Alignment.Center,
                    painter = painterResource(id = R.drawable.ic_arrowback),
                    contentDescription = "",
                    modifier = modifier
                        .padding(top = 55.dp, start = 18.dp, end = 15.dp)
                        .size(26.dp)
                )
            }
        }
    }
}
