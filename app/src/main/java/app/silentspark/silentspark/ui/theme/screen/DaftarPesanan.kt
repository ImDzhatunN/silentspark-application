package app.silentspark.silentspark.ui.theme.screen

import android.content.Context
import android.util.Log
import app.silentspark.silentspark.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.silentspark.silentspark.controller.ApiInterface
import app.silentspark.silentspark.controller.RetrofitInstance
import app.silentspark.silentspark.dummy.DataDummy
import app.silentspark.silentspark.model.Course
import app.silentspark.silentspark.model.CourseResponse
import app.silentspark.silentspark.model.Kelas
import app.silentspark.silentspark.model.Pesanan
import app.silentspark.silentspark.model.PesananResponse
import app.silentspark.silentspark.ui.theme.components.BoxItemDaftarPesanan
import app.silentspark.silentspark.ui.theme.components.ItemSearchBarPreview
import app.silentspark.silentspark.ui.theme.theme.Coklat
import app.silentspark.silentspark.ui.theme.theme.Green
import app.silentspark.silentspark.ui.theme.theme.SilentSparkTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


fun fetchPesanan(context: Context, callback: (List<Pesanan>) -> Unit) {
    val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
    retIn.getPesanan().enqueue(object : Callback<PesananResponse> {
        override fun onResponse(call: Call<PesananResponse>, response: Response<PesananResponse>) {
            if (response.isSuccessful) {
                val courseResponse = response.body()
                if (courseResponse != null && courseResponse.success == "OK") {
                    val courseList = courseResponse.data
                    Log.d("DAFTARPESANAN", "Pesanan list: $courseList")
                    callback(courseList)
                } else {
                    Log.e("DAFTARPESANAN", "Response was not successful or success was not OK")
                    // Handle the case where success is not OK
                }
            } else {
                Log.e("DAFTARPESANAN", "Response error: ${response.errorBody()?.string()}")
                // Handle the error
            }
        }

        override fun onFailure(call: Call<PesananResponse>, t: Throwable) {
            Log.e("CourseViewDAFTARPESANANModel", "Request failed", t)
            // Handle the failure
        }
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaftarPesanan(
    navController: NavHostController,
    modifier: Modifier = Modifier,
//    listPesan: List<Pesanan> = emptyList(),
    onBackClick: () -> Unit = {},
) {
    var listPesan by remember { mutableStateOf<List<Pesanan>>(emptyList()) }

    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        fetchPesanan(context) { fetchedPesananList ->
            listPesan = fetchedPesananList
        }
    }
    Log.d("LISTPESAN", "${listPesan}")

    val query by remember { mutableStateOf("") }
    val filteredList = listPesan.filter {
        it.description.contains(query, ignoreCase = true)
    }
    Log.d("FILTEREDLIST", "${filteredList}")

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
                                .clickable { onBackClick() }
                        )
                        Spacer(modifier = modifier.weight(1f))
                        Text(
                            text = "Daftar Pesanan",
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
                ItemSearchBarPreview()

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    item {
                        Text(
                            text = "2024",
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                color = Coklat
                            ),
                            modifier = Modifier.padding(start = 24.dp, top = 16.dp)
                        )
                    }
                    items(filteredList.filter { it.year == 2024 }, key = { it.id }) { pesanan ->
                        BoxItemDaftarPesanan(
                            pesanan = pesanan,
                            statusColour = if (pesanan.status == "Belum Lunas") Color(0xFFBBA661).copy(alpha = 0.25f) else Color(0xFF67725F).copy(alpha = 0.25f),
                            textColor = if (pesanan.status == "Belum Lunas") Color(0xFFAC9062) else Color(0xFF67725F),
                            modifier = Modifier.clickable {
                                navController.navigate("tanda_terima/${pesanan.id}")
                            }
                        )
                    }
                    item {
                        Text(
                            text = "2023",
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                color = Coklat
                            ),
                            modifier = Modifier.padding(start = 24.dp, top = 16.dp)
                        )
                    }
                    items(filteredList.filter { it.year == 2023 }, key = { it.id }) { pesanan ->
                        BoxItemDaftarPesanan(
                            pesanan = pesanan,
                            statusColour = if (pesanan.status == "Belum Lunas") Color(0xFFBBA661).copy(alpha = 0.25f) else Color(0xFF67725F).copy(alpha = 0.25f),
                            textColor = if (pesanan.status == "Belum Lunas") Color(0xFFAC9062) else Color(0xFF67725F),
                            modifier = Modifier.clickable {
                                navController.navigate("tanda_terima/${pesanan.id}")
                            }
                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewDaftarPesanan() {
    val navController = rememberNavController()
    SilentSparkTheme {
        DaftarPesanan(
            navController = navController,
            onBackClick = {}
        )
    }
}