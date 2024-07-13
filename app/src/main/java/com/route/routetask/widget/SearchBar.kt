package com.route.routetask.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.routetask.R
import com.route.routetask.ui.theme.Poppins
import com.route.routetask.ui.theme.blue
import com.route.routetask.ui.theme.grey

@Composable
fun SearchBar(onBarClick: (() -> Unit)? = null) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 8.dp)
            .height(50.dp)

    ) {
        Row(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(30.dp))
                .border(1.dp, blue, shape = RoundedCornerShape(30.dp)) // Add border here
                .padding(16.dp)
                .fillMaxWidth(.85f)
                .clickable {
                    if (onBarClick != null)
                        onBarClick()
                },

            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = stringResource(R.string.search_icon),
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "what do you search for?",
                fontSize = 14.sp, fontFamily = Poppins,
                fontWeight = FontWeight.Light, color = grey,

                )
        }

        Image(
            painter = painterResource(R.drawable.ic_cart),
            contentDescription = stringResource(R.string.cart_icon),
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowSearchBar() {
    SearchBar({})
}