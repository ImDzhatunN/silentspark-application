package app.silentspark.silentspark.ui.theme.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.silentspark.silentspark.R

@Composable
fun PhotoPicker() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
            .clickable { }
    ) {
        Box(
            modifier = Modifier
                .size(400.dp)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_meedia),
                contentDescription = "Pilih Foto",
                modifier = Modifier
                    .size(190.dp)
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 27.dp)
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                ButtonPilihFoto(
                    text = "Pilih Foto",
                    onClick = { }
                )
            }
        }
    }
}

@Preview
@Composable
fun PhotoPickerPreview() {
    PhotoPicker()
}
