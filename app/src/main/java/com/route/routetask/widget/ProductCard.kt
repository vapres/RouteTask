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
import androidx.compose.ui.text.style.TextOverflow
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.route.routetask.R
import com.route.routetask.model.Product
import kotlin.math.round


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductCard(product: Product) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(width = 2.dp, color = cardBorderColor),
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(.5f)
            .height(240.dp)
    ) {
        Box(modifier = Modifier.fillMaxHeight(.5f)) {
            GlideImage(
                model = product.thumbnail,
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
                text = product.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = textColor,
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )

            Text(
                text = product.description,
                lineHeight = 18.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = textColor,
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )


            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "EGP ${round((product.price - (product.price * product.discountPercentage / 100))*100.0)/100.0}",
                    color = textColor,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
                Spacer(Modifier.width(16.dp))
                Text(
                    text = "${product.price}",
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
                    text = "Review (${product.rating})",
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
