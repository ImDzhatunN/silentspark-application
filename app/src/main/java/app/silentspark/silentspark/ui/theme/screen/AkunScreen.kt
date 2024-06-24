package app.silentspark.silentspark.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.silentspark.silentspark.R
import app.silentspark.silentspark.navigation.Screen
import app.silentspark.silentspark.ui.theme.components.PhotoPicker
import app.silentspark.silentspark.ui.theme.theme.Coklat
import app.silentspark.silentspark.ui.theme.theme.Green



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AkunScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_back_topbar),
                            contentDescription = "Icon",
                            modifier = modifier
                                .width(38.dp)
                                .height(39.dp)
                                .clickable { navController.popBackStack() }
                        )
                        Spacer(modifier = modifier.weight(1f))
                        Text(
                            text = "Akun",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                color = Green
                            ),
                            modifier = modifier.padding(end = 16.dp)
                        )
                    }
                },
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                PhotoPicker()

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .padding(start = 30.dp)
                        .clickable { navController.navigate("profile") },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Profile",
                        tint = Coklat,
                        modifier = Modifier.size(28.dp)
                    )
                    Text(
                        text = "Profile",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            color = Coklat
                        ),
                        modifier = modifier.padding(start = 20.dp)
                    )
                }

                Spacer(modifier = modifier.height(10.dp))

                Row (  modifier = Modifier
                    .padding(start = 30.dp),
                    verticalAlignment = Alignment.CenterVertically)
                {
                    Image(
                        painter = painterResource(id = R.drawable.ic_about),
                        contentDescription = "Icon",
                        modifier = modifier
                            .size(25.dp)
                            .clickable { onBackClick() }
                    )
                    Text(
                        text = "Tentang Kami",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            color = Coklat
                        ),
                        modifier = modifier.padding(start = 20.dp)
                    )
                }
                Spacer(modifier = modifier.height(10.dp))

                Row(
                    modifier = Modifier.padding(start = 30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector =Icons.Outlined.ExitToApp ,
                        contentDescription = "Keluar",
                        tint = Coklat,
                        modifier = Modifier
                            .size(28.dp)


                    )
                    Text(
                        text = "keluar",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            color = Coklat
                        ),
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .clickable {
                                navController.navigate(Screen.Login.route)
                            }
                    )

                }

            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewAccountScreen() {
    AkunScreen(navController = rememberNavController())
}

