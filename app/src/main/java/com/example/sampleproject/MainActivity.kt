package com.example.sampleproject

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.sampleproject.ui.theme.SampleProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //val username = remember { mutableStateOf(TextFieldValue("Username")) }
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val context = LocalContext.current
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        // Don't copy.
        Column(Modifier.width(IntrinsicSize.Max)) {
            Spacer(modifier = Modifier.height(30.dp))
            Card(
                modifier = Modifier
                    .size(70.dp)
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
                text = stringResource(id = R.string.news),
                fontSize = 30.sp,
                lineHeight = 116.sp
            )
            Text(
                text = "Aplikasi Berita dengan jetpack compose",
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = username.value,
                onValueChange = { username.value = it },
                label = { Text("username") },
                modifier = Modifier.width(400.dp)
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("password") },
                modifier = Modifier.width(400.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                textAlign = TextAlign.End,
                modifier = Modifier.align(alignment = Alignment.End)
                    .clickable() {
                        context.startActivity(Intent(context,LupaActivity::class.java))
                        //Toast.makeText(context,"Lupa password",Toast.LENGTH_SHORT).show()
                    },
                text = "Lupa Password ?",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = {
                    if(username.value == "admin" && password.value == "admin")  context.startActivity(Intent(context,HomeActivity::class.java)) else Toast.makeText(context,"Gagal username bukan ${username.value}",Toast.LENGTH_SHORT).show()

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Text("Masuk")
            }
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "My App"
)
@Composable
fun GreetingPreview() {
    SampleProjectTheme {
        Greeting("Android")
    }
}