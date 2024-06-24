package app.silentspark.silentspark.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
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
import app.silentspark.silentspark.dummy.DataDummy
import app.silentspark.silentspark.model.KeteranganPesanan
import app.silentspark.silentspark.ui.theme.components.BoxTandaTerima
import app.silentspark.silentspark.ui.theme.theme.Green
import app.silentspark.silentspark.ui.theme.theme.SilentSparkTheme
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TandaTerimaScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    tandaterima: List<KeteranganPesanan> = emptyList(),
    onBackClick: () -> Unit = {}
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
                            contentDescription = "Icon Back",
                            modifier = modifier
                                .width(38.dp)
                                .height(39.dp)
                                .clickable { navController.popBackStack() }
                        )
                        Spacer(modifier = modifier.weight(1f))
                        Text(
                            text = "Tanda Terima",
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
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                tandaterima.forEach { pesanan ->
                    Box(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        BoxTandaTerima(
                            name = pesanan.name,
                            date = pesanan.date,
                            tagihan = pesanan.tagihan,
                            sesi = pesanan.sesi,
                            metodepembayaran = pesanan.metodepembayaran,
                            status = pesanan.status,
                            total = pesanan.total
                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTandaTerimaScreen() {
    val navController = rememberNavController()
    SilentSparkTheme {
        TandaTerimaScreen(
            navController = navController,
            tandaterima = DataDummy.listKeteranganPesanan,
            onBackClick = {}
        )
    }
}
