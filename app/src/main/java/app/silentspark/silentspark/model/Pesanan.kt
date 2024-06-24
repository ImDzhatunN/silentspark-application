package app.silentspark.silentspark.model

data class Pesanan(
    val id : Int,
    val date : String,
    val month : String,
    val metodepembayaran : String,
    val status : String,
    val year:   Int,
    val description: String
)
