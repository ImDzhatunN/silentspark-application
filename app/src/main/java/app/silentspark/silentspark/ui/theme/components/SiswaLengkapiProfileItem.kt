package app.silentspark.silentspark.ui.theme.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.silentspark.silentspark.R
import app.silentspark.silentspark.ui.theme.navigation.ProfileItem

@Composable
fun SiswaLengkapiProfileItem(profileItem: ProfileItem) {
    val (text, setText) = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        Text(
            text = profileItem.label,
            style = MaterialTheme.typography.titleSmall.copy(
                fontSize = 12.sp,
                color = Color.Black,
                fontFamily = FontFamily(
                    Font(R.font.poppins_semibold)
                )
            ),
        )
        OutlinedTextField(
            value = text,
            onValueChange = setText,
            textStyle = TextStyle(
                fontSize = 12.sp,
                lineHeight = 26.sp,
                fontFamily = FontFamily(Font(R.font.poppins_light)),
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),
            ),
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSiswaLengkapiProfileItem() {
    val sampleDataLengkapiProfileSiswa = ProfileItem(label = "E-Mail")
    SiswaLengkapiProfileItem(profileItem = sampleDataLengkapiProfileSiswa)
}
