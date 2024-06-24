package app.silentspark.silentspark.viewmodel
//
//import android.util.Log
//import androidx.compose.runtime.mutableStateListOf
//import androidx.lifecycle.ViewModel
//import app.silentspark.silentspark.controller.ApiInterface
//import app.silentspark.silentspark.controller.RetrofitInstance
//import app.silentspark.silentspark.model.Kelas
//import app.silentspark.silentspark.model.KelasResponse
//import app.silentspark.silentspark.model.ResponseFormat
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class KelasViewModel : ViewModel() {
//    private val _kelasList = mutableStateListOf<Kelas>()
//    val kelasList: List<Kelas> get() = _kelasList
//
//    init {
//        fetchKelasData()
//    }
//
//    private fun fetchKelasData() {
//        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
//        retIn.getKelas().enqueue(object : Callback<KelasResponse> {
//            override fun onResponse(call: Call<ResponseFormat>, response: Response<KelasResponse>) {
//                if (response.isSuccessful) {
//                    val kelasResponse = response.body()
//                    if (kelasResponse != null && kelasResponse.success == "OK") {
//                        val kelasList = kelasResponse.data
//                        // Log the list of classes
//                        Log.d("KelasViewModel", "Kelas list: $kelasList")
//                    } else {
//                        Log.e("KelasViewModel", "Response was not successful or success was not OK")
//                    }
//                } else {
//                    Log.e("KelasViewModel", "Response error: ${response.errorBody()?.string()}")
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseFormat>, t: Throwable) {
//                Log.e("KelasViewModel", "Request failed", t)
//            }
//        })
//    }
//}
