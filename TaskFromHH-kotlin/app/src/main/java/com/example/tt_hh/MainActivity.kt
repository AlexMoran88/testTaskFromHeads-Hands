package com.example.tt_hh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.tt_hh.ui.theme.TT_HHTheme

class MainActivity : ComponentActivity() {
    private val viewModel : MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TT_HHTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Column(modifier = Modifier.padding(top = 12.dp, start = 12.dp, end = 12.dp)) {
                        AppContent(viewModel)
                        if (viewModel.showTextFlag){
                            Text(
                                text = getSortedArray(viewModel.n),
                                style = MaterialTheme.typography.subtitle2,
                                textAlign = TextAlign.Start,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 15.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AppContent(model: MyViewModel) {
    Column {
        TextField(
            value = when (model.n) {
                0 -> ""
                else -> model.n.toString()
            },
            onValueChange = { raw ->
                model.onNChange(raw.toIntOrNull() ?: 0)
            },
            label = { Text(text = stringResource(id = R.string.enterN)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
        )
        Button(onClick = { model.switchShowTextFlag() }) {
            Text(text = stringResource(id = R.string.see_result))
        }
    }
}