package app.silentspark.silentspark.ui.theme.components

import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import app.silentspark.silentspark.R
import androidx.compose.runtime.*
import app.silentspark.silentspark.ui.theme.theme.AbuBiruTua
import app.silentspark.silentspark.ui.theme.theme.Abuabu
import app.silentspark.silentspark.ui.theme.theme.putih


@Composable
fun ItemSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    active: Boolean,
    onActiveChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
                .padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(54.dp)
                    .background(
                        color = putih,
                        shape = RoundedCornerShape(size = 4.dp)
                    ),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = Abuabu,
                        modifier = Modifier.padding(start = 16.dp, end = 8.dp)
                    )

                    BasicTextField(
                        value = query,
                        onValueChange = {
                            onQueryChange(it)
                            onSearch()
                        },
                        textStyle = TextStyle(
                            color = AbuBiruTua,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular))
                        ),
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp)
                    )

                    if (query.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.search),
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontSize = 14.sp,
                                color = AbuBiruTua
                            ),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }
        }
    }
}
@Composable
@Preview(showBackground = false)
fun ItemSearchBarPreview() {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    ItemSearchBar(
        query = query,
        onQueryChange = { query = it },
        onSearch = { println("Searching for $query") },
        active = active,
        onActiveChange = { active = it },

        )
}