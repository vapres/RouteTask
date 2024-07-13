package com.route.routetask.utils.fragments.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.route.routetask.R
import com.route.routetask.ui.theme.Poppins
import com.route.routetask.ui.theme.blue
import com.route.routetask.ui.theme.grey
import com.route.routetask.widget.ProductsList

@Composable
fun SearchScreen(vm: SearchViewModel = viewModel()) {

    val focusManager = LocalFocusManager.current

    Column(modifier = Modifier.fillMaxSize()) {

        Row(
            modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = vm.searchQuery,
                onValueChange = {
                    vm.searchQuery = it
                },

                placeholder = {
                    Text(
                        text = "what do you search for?", fontSize = 14.sp, fontFamily = Poppins,
                        fontWeight = FontWeight.Light, color = grey,
                    )
                },

                leadingIcon = {
                    Image(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = stringResource(R.string.search_icon),
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .clickable {
                                vm.getProductBySearch()
                                focusManager.clearFocus()
                            }
                    )
                },

                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),

                keyboardActions = KeyboardActions(
                    onSearch = {
                        vm.getProductBySearch()
                        focusManager.clearFocus()
                    }
                ),

                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = blue,
                    unfocusedBorderColor = blue,
                ),
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                singleLine = true
            )
            
        }

        vm.getProductBySearch()
        ProductsList(vm.searchedProductsList)
    }


}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ShowSearchScreen() {
    SearchScreen()
}