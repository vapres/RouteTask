package com.route.routetask.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.routetask.ui.theme.Poppins
import com.route.routetask.ui.theme.cardBorderColor
import com.route.routetask.ui.theme.discountTextColor
import com.route.routetask.ui.theme.textColor
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import com.route.routetask.Product
import com.route.routetask.R


@Composable
fun ProductCard(product: Product) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(width = 2.dp, color = cardBorderColor),
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(.5f)
            .height(238.dp)
    ) {
        Box(modifier = Modifier.fillMaxHeight(.5f)) {
            Image(
                painter = painterResource(id = product.drawableResId),
                contentDescription = stringResource(R.string.sneakers),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.ic_favourite),
                contentDescription = stringResource(R.string.add_to_favourite),
                modifier = Modifier
                    .fillMaxWidth(),
                alignment = Alignment.TopEnd
            )
        }

        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = stringResource(product.titleResId),
                lineHeight = 18.sp,
                color = textColor,
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "EGP ${product.priceAfterDiscount}",
                    color = textColor,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
                Spacer(Modifier.width(16.dp))
                Text(
                    text = product.originalPrice,
                    style = TextStyle(
                        textDecoration = TextDecoration.LineThrough,
                        color = discountTextColor,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp
                    )
                )
            }

            Row {
                Text(
                    text = "Review (${product.reviewRate})",
                    color = textColor,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
                Spacer(Modifier.width(4.dp))

                Image(
                    painter = painterResource(R.drawable.ic_star),
                    contentDescription = stringResource(R.string.review_star)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = stringResource(R.string.add_to_cart),
                    modifier = Modifier.fillMaxWidth(),
                    alignment = Alignment.BottomEnd
                )
            }
        }

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowProductCard() {
    ProductCard(
        Product(
            R.string.product_title,
            R.drawable.sneakers,
            4.3,
            "2000",
            "1200"
        )
    )
}