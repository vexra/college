package com.example.homescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homescreen.ui.theme.HomeScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun Weather(temperature: String, location: String, lastUpdated: String, modifier: Modifier) {
    val weatherIcon = painterResource(R.drawable.sunny_partly_cloudy)
    val mapMarkIcon = painterResource(R.drawable.map_mark_icon)

    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ){
        Image (
            painter = weatherIcon,
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )

        Text(
            text = temperature,
            fontSize = 64.sp,
            color = Color.White,
            fontWeight = FontWeight.Light
        )
    }

    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ){
        Image (
            painter = mapMarkIcon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = location,
            fontSize = 20.sp,
            color = Color.White
        )
    }

    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = lastUpdated,
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Light
        )
    }
}

@Composable
fun GoogleSearchInput(modifier: Modifier = Modifier) {
    val googleSearchInput = painterResource(R.drawable.google_search_input)

    Row (
        modifier = Modifier.fillMaxWidth()
    ) {
        Image (
            painter = googleSearchInput,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun AppMenu(logo: Painter, title: String, modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image (
            painter = logo,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(72.dp)
        )

        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Light
        )
    }
}

@Composable
fun Menus (modifier: Modifier = Modifier) {
    val galaxyStore = painterResource(R.drawable.galaxy_store)
    val gallery = painterResource(R.drawable.gallery)
    val playStore = painterResource(R.drawable.play_store)
    val googleFolder = painterResource(R.drawable.google_folder)
    
    val telephone = painterResource(R.drawable.telephone)
    val message = painterResource(R.drawable.message)
    val browser = painterResource(R.drawable.samsung_internet_browser)
    val camera = painterResource(R.drawable.camera)

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        AppMenu(galaxyStore, "Galaxy Store")
        AppMenu(gallery, "Gallery")
        AppMenu(playStore, "Play Store")
        AppMenu(googleFolder, "Google")
    }

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        AppMenu(telephone, "")
        AppMenu(message, "")
        AppMenu(browser, "")
        AppMenu(camera, "")
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val wallpaper = painterResource(R.drawable.wallpaper)

    Box(modifier = Modifier.fillMaxSize()) {
        Image (
            painter = wallpaper,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column (
            verticalArrangement = Arrangement.Bottom,
            modifier = modifier.fillMaxSize()
        ) {
            Weather(
                temperature = "31°",
                location = "Pelita",
                lastUpdated = "3/15, 11:46 AM",
                modifier = Modifier
            )

            GoogleSearchInput()

            Menus()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreenTheme {
        HomeScreen()
    }
}