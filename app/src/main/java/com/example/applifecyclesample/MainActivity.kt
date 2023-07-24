package com.example.applifecyclesample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.applifecyclesample.ui.theme.AppLifeCycleSampleTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {

    private val tag = this::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(tag, "Activity onCreate")
        super.onCreate(savedInstanceState)
        setContent {
            AppLifeCycleSampleTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Greeting("Android")
                    EditText()
                }
            }
        }
    }

    // アプリが走った時
    override fun onStart() {
        Log.d(tag, "Activity onStart")
        super.onStart()
    }

    // アプリに戻った時
    override fun onRestart() {
        Log.d(tag, "Activity onRestart")
        super.onRestart()
    }

    // アプリに戻った時
    override fun onResume() {
        Log.d(tag, "Activity onResume")
        super.onResume()
    }

    // ホーム画面などでアプリから離れた時
    override fun onPause() {
        Log.d(tag, "Activity onPause")
        super.onPause()
    }

    // ホーム画面などでアプリから離れた時
    override fun onStop() {
        Log.d(tag, "Activity onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(tag, "Activity onDestroy")
        super.onDestroy()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditText(viewModel: MainViewModel = viewModel()) {
    val text by viewModel.textStateFlow.collectAsState()

    OutlinedTextField(
        value = text,
        onValueChange = viewModel::onTextChange,
        label = { Text("テキストを入力") },
        singleLine = true,
        modifier = Modifier.wrapContentSize()
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppLifeCycleSampleTheme {
        Greeting("Android")
    }
}