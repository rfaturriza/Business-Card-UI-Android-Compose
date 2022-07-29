package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard(
                        "Rizky Faturriza",
                        "Mobile Engineer",
                        "085211011002",
                        "rfaturriza@gmail.com",
                        "@rfaturriza"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, title: String, numberPhone: String, email: String, social: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        NameCard(name = name, title = title)
        ContactInformation(numberPhone = numberPhone, email = email, social = social)
    }
}

@Composable
fun NameCard(name: String, title: String) {
    val image = painterResource(id = R.drawable.my)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
    ) {
        Box(modifier = Modifier.height(200.dp)){
            Image(painter = image, contentDescription = "myPhoto")
        }
        Text(
            text = name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
        )
    }
}

@Composable
fun ContactInformation(numberPhone: String, email: String, social: String) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 80.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(imageVector = Icons.Rounded.Phone, contentDescription = null)
            Text(text = numberPhone)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 80.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(imageVector = Icons.Rounded.Place, contentDescription = null)
            Text(text = social)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 80.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(imageVector = Icons.Rounded.Email, contentDescription = null)
            Text(text = email)
        }
        Spacer(modifier = Modifier.padding(bottom = 50.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard(
            "Rizky Faturriza",
            "Mobile Engineer",
            "085211011002",
            "rfaturriza@gmail.com",
            "@rfaturriza"
        )
    }
}