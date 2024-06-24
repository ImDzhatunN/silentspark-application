package app.silentspark.silentspark.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
import app.silentspark.silentspark.ui.theme.components.ButtonSimpan
import app.silentspark.silentspark.ui.theme.components.DataLengkapiProfilesiswa
import app.silentspark.silentspark.ui.theme.components.SiswaLengkapiProfileItem
import app.silentspark.silentspark.ui.theme.theme.ijolumut


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
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
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Profile",
                            style = MaterialTheme.typography.titleSmall.copy(
                                color = ijolumut,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            ),
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 20.dp)
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        Text(
                            text = "Informasi Lengkap",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            ),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                    items(DataLengkapiProfilesiswa) { profileItem ->
                        SiswaLengkapiProfileItem(profileItem)
                    }
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            ButtonSimpan(
                                text = "Simpan",
                                onClick = {
                                },
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController= rememberNavController())
}