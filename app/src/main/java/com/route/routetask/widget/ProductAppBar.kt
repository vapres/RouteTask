package com.route.routetask.widget

import androidx.compose.foundation.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.route.routetask.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductAppBar() {

    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.route_signature),
                contentDescription = stringResource(R.string.route),
                alignment = Alignment.TopStart
            )
        }
    )

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ShowProductAppBar() {
    ProductAppBar()
}