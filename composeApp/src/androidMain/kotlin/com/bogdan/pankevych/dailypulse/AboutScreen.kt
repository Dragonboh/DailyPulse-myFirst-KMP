package com.bogdan.pankevych.dailypulse

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen(
    closeButtonClick: () -> Unit,
) {
    Column {
        Toolbar(closeButtonClick = closeButtonClick)
        ContentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(
    closeButtonClick: () -> Unit,
) {
    TopAppBar(title = {
        Text("About Device")
    },
        navigationIcon = {
            IconButton(onClick = closeButtonClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "About Device Button"
                )
            }
        }
    )
}

@Composable
private fun ContentView() {
//    val vm = AboutScreenVM()
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(AboutScreenVM().getItems()) { row ->
            RowView(title = row.first, subtitle = row.second)
        }
    }
}


@Composable
private fun RowView(
    title: String,
    subtitle: String,
) {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyLarge,
        )
    }

    HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
}

