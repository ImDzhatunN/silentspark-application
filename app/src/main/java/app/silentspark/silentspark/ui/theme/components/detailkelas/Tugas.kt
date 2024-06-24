package app.silentspark.silentspark.ui.theme.components.detailkelas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.silentspark.silentspark.R
import app.silentspark.silentspark.ui.theme.theme.Abuabu
import app.silentspark.silentspark.ui.theme.theme.Coklat
import app.silentspark.silentspark.ui.theme.theme.KuningMuda
import app.silentspark.silentspark.ui.theme.theme.SilentSparkTheme
import app.silentspark.silentspark.ui.theme.theme.putih

@Composable
fun Tugas(
    modifier: Modifier = Modifier,
    namatugas : String,
    desctugas : String,
    text:String,
    nilai:String,
    setText: (String) -> Unit

)
{
    Box(
        modifier = modifier
            .width(460.dp)
            .height(720.dp)
            .border(BorderStroke(1.dp, Abuabu), shape = RoundedCornerShape(25.dp))
            .background(color = putih, shape = RoundedCornerShape(25.dp))

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = namatugas,
                color = Coklat,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            )
            Text(
                text = desctugas,
                color = Coklat,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ditugaskan",
                    color = Abuabu,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    modifier = modifier
                        .padding(end = 12.dp)
                )
                Icon(
                    imageVector = Icons.Default.AccessTime,
                    tint = Abuabu,
                    contentDescription = "Clock"
                )
                Text(
                    text = "12:40 PM",
                    color = Abuabu,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                )
                Icon(
                    imageVector = Icons.Default.CalendarMonth,
                    tint = Abuabu,
                    contentDescription = "Clock"
                )
                Text(
                    text = "01 Mei 2024",
                    color = Abuabu,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Jatuh Tempo",
                    color = Abuabu,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                )
                Icon(
                    imageVector = Icons.Default.AccessTime,
                    tint = Abuabu,
                    contentDescription = "Clock"
                )
                Text(
                    text = "12:40 PM",
                    color = Abuabu,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                )
                Icon(
                    imageVector = Icons.Default.CalendarMonth,
                    tint = Abuabu,
                    contentDescription = "Clock"
                )
                Text(
                    text = "01 Mei 2024",
                    color = Abuabu,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "File",
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                modifier = modifier
                    .padding(start = 10.dp, bottom = 8.dp)
            )

            Box(
                modifier = Modifier
                    .size(width = 360.dp, height = 200.dp)
                    .drawBehind {
                        val strokeWidth = 1.dp.toPx()
                        val dashWidth = 10.dp.toPx()
                        val dashGap = 10.dp.toPx()
                        val pathEffect =
                            PathEffect.dashPathEffect(floatArrayOf(dashWidth, dashGap), 0f)

                        drawRoundRect(
                            color = Abuabu,
                            topLeft = androidx.compose.ui.geometry.Offset.Zero,
                            size = this.size,
                            cornerRadius = CornerRadius(15.dp.toPx(), 15.dp.toPx()),
                            style = Stroke(
                                width = strokeWidth,
                                pathEffect = pathEffect
                            )
                        )
                    }
                    .background(color = putih, shape = RoundedCornerShape(25.dp))
                    .padding(8.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(35.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_uploud),
                    contentDescription = "",
                )
            }
            Text(
                text = "Max: 50 MB",
                color = Coklat,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                modifier = modifier
                    .padding(start = 10.dp, top = 8.dp, bottom = 10.dp)
            )

            OutlinedTextField(
                value = text,
                onValueChange = setText,
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 26.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_light)),
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(size = 9.dp)

            )

            Text(
                text = "Uploud tugas dalam bentuk PDF/Word jika berupa File atau Video dalam bentuk Link",
                color = Abuabu,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                modifier = modifier
                    .padding(start = 10.dp, top = 8.dp)
            )
            Text(
                text = "Penilaian",
                color = Coklat,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                modifier = modifier
                    .padding(start = 10.dp, bottom = 8.dp, top = 10.dp)
            )


            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                OutlinedTextField(
                    value = nilai,
                    onValueChange = setText,
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 26.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_light)),
                    ),
                    modifier = Modifier
                        .height(50.dp)
                        .weight(3f),
                    shape = RoundedCornerShape(size = 9.dp)
                )
                Spacer(modifier = Modifier.weight(1f))


                Box(
                ) {
                    Button(
                        onClick = { /* Handle login click */ },
                        colors = ButtonDefaults.buttonColors(containerColor = KuningMuda),
                        shape = RoundedCornerShape(size = 8.dp),
                        modifier = modifier
                            .width(140.dp)
                            .height(50.dp)

                    ) {
                        Text(
                            "Kirim Tugas",
                            color = putih,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold))
                        )
                    }
                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    SilentSparkTheme {
        var textState by remember { mutableStateOf("Link") }
        Tugas(
            text = "Link",
            nilai = "Link",
            setText = {newText -> textState = newText},
            namatugas = "Tugas 1",
            desctugas = stringResource(id = R.string.lorem)
        )
    }
}