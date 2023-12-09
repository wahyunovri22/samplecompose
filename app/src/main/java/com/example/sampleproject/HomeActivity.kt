package com.example.sampleproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleproject.ui.theme.SampleProjectTheme
import java.util.Stack

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Surface( modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .size(100.dp)
                    .testTag("circle"),
                shape = CircleShape,
            ) {
                Image(
                    painterResource(R.drawable.compose),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    //modifier = Modifier.fillMaxSize()
                    modifier = Modifier.fillMaxSize()
                )
            }
            Text(
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.home),
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    SampleProjectTheme {
        Greeting2("Android")
    }
}