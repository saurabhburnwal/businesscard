package com.example.businesscard

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0x489C73A3))
    ) {
        MainContent(
        stringResource(id = R.string.full_name),
        stringResource(id = R.string.title),
        )
    }
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Footer(
            stringResource(id = R.string.phone_number),
            stringResource(id = R.string.social_media_handle),
            stringResource(id = R.string.email_id)
        )
    }
}
@Composable
private fun MainContent(
    fullName: String,
    title: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painterResource(id = R.drawable.ic_banner_foreground),
            contentDescription = null,
            modifier = Modifier
                .width(125.dp)
                .height(100.dp)
        )
        Text(
            text = fullName,
            fontSize = 24.sp,
        )
        Text(
            text = title,
            fontSize = 16.sp,
        )
    }
}

@Composable
private fun Footer(
    mobile: String,
    handle: String,
    email: String
) {
    Column {
        Row {
            Icon(
                Icons.Filled.Call,
                contentDescription = "Call Icon.",
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = mobile,
                modifier = Modifier.padding(4.dp)
            )
        }
        Row {
            Icon(
                Icons.Filled.AccountCircle,
                contentDescription = "Account Icon",
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = handle,
                modifier = Modifier.padding(8.dp)
            )
        }
        Row {
            Icon(
                Icons.Filled.Email,
                contentDescription = "Mail Icon",
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = email,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}