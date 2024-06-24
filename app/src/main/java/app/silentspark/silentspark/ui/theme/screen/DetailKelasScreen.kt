package app.silentspark.silentspark.ui.theme.screen

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.silentspark.silentspark.R
import app.silentspark.silentspark.controller.ApiInterface
import app.silentspark.silentspark.controller.RetrofitInstance
import app.silentspark.silentspark.model.DetailKelas
import app.silentspark.silentspark.model.DetailKelasResponse
import app.silentspark.silentspark.model.Kelas
import app.silentspark.silentspark.ui.theme.components.detailkelas.AksesKelas
import app.silentspark.silentspark.ui.theme.components.detailkelas.Hubungi
import app.silentspark.silentspark.ui.theme.components.detailkelas.TentangGuru
import app.silentspark.silentspark.ui.theme.components.detailkelas.Tugas
import app.silentspark.silentspark.ui.theme.theme.Green
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


fun fetchDetailKelas(id:Int, context: Context, callback: (DetailKelas) -> Unit) {
    val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
    retIn.getDetailKelas(id).enqueue(object : Callback<DetailKelasResponse> {
        override fun onResponse(call: Call<DetailKelasResponse>, response: Response<DetailKelasResponse>) {
            if (response.isSuccessful) {
                val kelasResponse = response.body()
                Log.d("DetailKelasViewModel", "Kelas list: $kelasResponse")
                if (kelasResponse != null && kelasResponse.success == "OK") {
                    val kelasList = kelasResponse.data
                    Log.d("DetailKelasViewModel", "Kelas list: $kelasList")
                    callback(kelasList)
                } else {
                    Log.e("DetailKelasViewModel", "Response was not successful or success was not OK")
                    // Handle the case where success is not OK
                }
            } else {
                Log.e("DetailKelasViewModel", "Response error: ${response.errorBody()?.string()}")
                // Handle the error
            }
        }

        override fun onFailure(call: Call<DetailKelasResponse>, t: Throwable) {
            Log.e("DetailKelasViewModel", "Request failed", t)
            // Handle the failure
        }
    })
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailKelasScreen(
    navController: NavHostController,
    kelasId: Int,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
) {
    var kelas by remember { mutableStateOf<DetailKelas?>(null) }

    val context = LocalContext.current
    LaunchedEffect(key1 = kelasId) {
        fetchDetailKelas(kelasId, context) { fetchedKelasList ->
            kelas = fetchedKelasList
            Log.d("KELASDATA", "${kelas}")
            Log.d("KELASID", "${kelasId}")

        }
    }

    kelas?.let { selectedKelas ->
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
                                text = "Detail Kelas",
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
                LazyColumn(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    item {
                        Box(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            // Display image if available
                            /*
                            Image(
                                painter = painterResource(kelas.image),
                                contentDescription = "Kelas Image",
                                modifier = Modifier
                                    .height(160.dp)
                                    .width(180.dp)
                                    .clip(RoundedCornerShape(7.dp)),
                                contentScale = ContentScale.Crop
                            )
                            */
                        }
                    }
                    item {
                        Box(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            // Display information about the teacher/class
                            TentangGuru(
                                name = selectedKelas.title,
                                date = selectedKelas.description ?: "-",
                                bahasa = "Indonesia | English",
                                sesi = selectedKelas.status,
                                modifier = modifier
                            )
                        }
                    }
                    item {
                        Box(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            // Display access class component
                            AksesKelas(
                                topik = selectedKelas.topics ?: "Topik tidak tersedia",
                                linkzoom = selectedKelas.linkzoom ?: "Belum ada link zoom yang disediakan",
                                modifier = modifier
                            )
                        }
                    }
                    item {
                        Box(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            // Display assignment component
                            Tugas(
                                namatugas = "Tugas 1",
                                desctugas = stringResource(id = R.string.lorem),
                                text = "Link",
                                nilai = "nilai",
                                setText = {}
                            )
                        }
                    }
                    item {
                        Box(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            // Display contact teacher component
                            Hubungi(
                                navController = navController,
                                email = "biancasavador@gmail.com",
                                modifier = modifier
                                    .clickable {
                                        navController.navigate("rating")
                                    }
                            )
                        }
                    }
                }
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewDetailKelasScreen(){
    DetailKelasScreen(kelasId = 1, navController = rememberNavController())
}

