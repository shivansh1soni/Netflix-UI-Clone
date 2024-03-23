package com.example.netflixuiclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .verticalScroll(rememberScrollState())
            ) {
                TopAppSection()
                ContentChooser()
                FeaturedMovieSection()
                NewReleases()
                WatchItAgain()
                Action()
                Drama()
            }
        }
    }
}

@Composable
fun TopAppSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp, start = 3.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.netflix_icon),
            contentDescription = "netflix_icon",
            modifier = Modifier.size(50.dp, 50.dp),
            contentScale = ContentScale.Crop
        )


        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = "search_icon",
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .padding(end = 12.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.profile_icon),
                contentDescription = "profile_icon",
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .padding(start = 6.dp, end = 12.dp)
            )
        }
    }
}

@Composable
fun ContentChooser() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "TV Shows", color = Color.LightGray, fontSize = 18.sp)
        Text(text = "Movies", color = Color.LightGray, fontSize = 18.sp)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Categories", color = Color.LightGray, fontSize = 18.sp)
            Image(
                painter = painterResource(id = R.drawable.drop_down_icon),
                contentDescription = "drop down icon"
            )
        }
    }
}

@Composable
fun FeaturedMovieSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 45.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.poster), contentDescription = "movie-poster"
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, start = 70.dp, end = 70.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Adventure", color = Color.LightGray)
            Text(text = "Thriller", color = Color.LightGray)
            Text(text = "Drama", color = Color.LightGray)
            Text(text = "Serial", color = Color.LightGray)
        }

        Row(
            modifier = Modifier
                .padding(top = 30.dp, start = 80.dp, end = 80.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.plus_icon),
                    contentDescription = "",
                    modifier = Modifier.size(20.dp, 20.dp)
                )
                Text(text = "My List", color = Color.LightGray, fontSize = 12.sp)
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = "Play", color = Color.Black, fontSize = 16.sp)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.info_icon),
                    contentDescription = "",
                    modifier = Modifier.size(20.dp, 20.dp)
                )
                Text(text = "info", color = Color.LightGray, fontSize = 12.sp)
            }

        }
    }
}

@Composable
fun NewReleases() {
    val listOfMovies = mutableListOf<MovieModel>()
    listOfMovies.add(MovieModel(R.drawable.movie1))
    listOfMovies.add(MovieModel(R.drawable.movie2))
    listOfMovies.add(MovieModel(R.drawable.movie3))
    listOfMovies.add(MovieModel(R.drawable.movie4))
    listOfMovies.add(MovieModel(R.drawable.movie5))
    listOfMovies.add(MovieModel(R.drawable.movie6))
    listOfMovies.add(MovieModel(R.drawable.movie7))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, top = 15.dp, end = 15.dp)
    ) {
        Text(
            text = "New Releases",
            fontSize = 20.sp,
            color = Color.LightGray,
            fontWeight = FontWeight.Bold
        )

        LazyRow {
            itemsIndexed(listOfMovies) { _, item ->
                MovieModelUI(image = item.image)
            }
        }
    }
}

@Composable
fun WatchItAgain() {
    val listOfMovies = mutableListOf<MovieModel>()
    listOfMovies.add(MovieModel(R.drawable.movie8))
    listOfMovies.add(MovieModel(R.drawable.movie9))
    listOfMovies.add(MovieModel(R.drawable.movie10))
    listOfMovies.add(MovieModel(R.drawable.movie11))
    listOfMovies.add(MovieModel(R.drawable.movie12))
    listOfMovies.add(MovieModel(R.drawable.movie13))
    listOfMovies.add(MovieModel(R.drawable.movie14))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, top = 15.dp, end = 15.dp)
    ) {
        Text(
            text = "Watch It Again",
            fontSize = 20.sp,
            color = Color.LightGray,
            fontWeight = FontWeight.Bold
        )

        LazyRow {
            itemsIndexed(listOfMovies) { _, item ->
                MovieModelUI(image = item.image)
            }
        }
    }
}

@Composable
fun Action() {
    val listOfMovies = mutableListOf<MovieModel>()
    listOfMovies.add(MovieModel(R.drawable.movie15))
    listOfMovies.add(MovieModel(R.drawable.movie16))
    listOfMovies.add(MovieModel(R.drawable.movie17))
    listOfMovies.add(MovieModel(R.drawable.movie18))
    listOfMovies.add(MovieModel(R.drawable.movie19))
    listOfMovies.add(MovieModel(R.drawable.movie20))
    listOfMovies.add(MovieModel(R.drawable.movie21))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, top = 15.dp, end = 15.dp)
    ) {
        Text(
            text = "Action", fontSize = 20.sp, color = Color.LightGray, fontWeight = FontWeight.Bold
        )

        LazyRow {
            itemsIndexed(listOfMovies) { _, item ->
                MovieModelUI(image = item.image)
            }
        }
    }
}

@Composable
fun Drama() {
    val listOfMovies = mutableListOf<MovieModel>()
    listOfMovies.add(MovieModel(R.drawable.movie22))
    listOfMovies.add(MovieModel(R.drawable.movie23))
    listOfMovies.add(MovieModel(R.drawable.movie24))
    listOfMovies.add(MovieModel(R.drawable.movie25))
    listOfMovies.add(MovieModel(R.drawable.movie26))
    listOfMovies.add(MovieModel(R.drawable.movie27))
    listOfMovies.add(MovieModel(R.drawable.movie28))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, top = 15.dp, end = 15.dp)
    ) {
        Text(
            text = "Drama", fontSize = 20.sp, color = Color.LightGray, fontWeight = FontWeight.Bold
        )

        LazyRow {
            itemsIndexed(listOfMovies) { _, item ->
                MovieModelUI(image = item.image)
            }
        }
    }
}

@Composable
fun MovieModelUI(image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "",
        modifier = Modifier
            .size(180.dp, 100.dp)
            .padding(end = 8.dp)
    )
}

data class MovieModel(
    val image: Int
)