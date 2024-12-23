package org.chevalier.composablecolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.chevalier.composablecolumn.ui.theme.ComposableColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposableColumnTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MyApp()
                }
            }
        }
    }
}

val cardTexts = listOf("Satu", "Dua", "Tiga", "Empat")
val containerText = listOf("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "Aenean quis aliquam tortor. Fusce magna nulla, pellentesque quis feugiat in, pretium a urna.", "Phasellus ornare ligula in est fermentum, in vestibulum ligula lobortis.",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "Aenean quis aliquam tortor. Fusce magna nulla, pellentesque quis feugiat in, pretium a urna.",)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(
                                "",

                                )
                        },
                        navigationIcon = {
                            IconButton(onClick = { /* do something */ }) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Localized description"
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = { /* do something */ }) {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "Localized description",
                                    modifier = Modifier.padding(end = 16.dp)
                                )
                            }
                        },
                    )
                }


            )
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                Text(
                    text = "Huda Chaerullah",
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 8.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 46.sp
                )
                Text(
                    text = "Jakarta",
                    modifier = Modifier.padding(horizontal = 30.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light
                )
                LazyRow(
                    contentPadding = PaddingValues(
                        start = 30.dp,
                        end = 30.dp,
                        top = 50.dp,
                        bottom = 16.dp
                    ),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(cardTexts.size) { index ->
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                            ),
                            shape = RoundedCornerShape(16.dp),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 4.dp
                            ),
                            modifier = Modifier
                                .width(150.dp)
                                .height(45.dp)
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = cardTexts[index],
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
                ExColumn("Progress", "Hi kack, ini progress saya")
                LazyColumn (
                    contentPadding = PaddingValues(horizontal = 30.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(containerText.size) { index ->
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 2.dp
                            ),
                            modifier = Modifier
                                .width(450.dp)
                                .height(150.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                contentAlignment = Alignment.Center,
                            ) {
                                Text(
                                    text = containerText[index],
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontSize = 15.sp

                                )
                            }
                        }
                    }
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun ExColumn(heading: String, keterangan: String){
    Column(
        modifier = Modifier.padding(horizontal = 30.dp, vertical = 16.dp),

        ) {
        Text(text = heading, style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            fontSize = 30.sp)

        Text(text = keterangan, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(vertical = 8.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    ComposableColumnTheme {
        MyApp()
    }
}