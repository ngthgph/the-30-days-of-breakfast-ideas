package com.example.the30daysofbreakfastideasapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.the30daysofbreakfastideasapp.model.Breakfast
import com.example.the30daysofbreakfastideasapp.model.BreakfastIdeas.ideas
import com.example.the30daysofbreakfastideasapp.ui.theme.The30DaysOfBreakfastIdeasAppTheme

@Composable
fun IdeasList(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(ideas){
            IdeaItem(idea = it)
        }
    }
}

@Composable
fun IdeaItem(
    idea: Breakfast,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .padding(
                start = dimensionResource(id = R.dimen.padding_medium),
                end = dimensionResource(id = R.dimen.padding_medium),
                top = dimensionResource(id = R.dimen.padding_large)),
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.card_elevation))
    ) {
        IdeaInformation(dayRes = idea.dayRes, nameRes = idea.nameRes)
        IdeaImage(imageRes = idea.imageRes, nameRes = idea.nameRes)
    }
}

@Composable
fun IdeaImage(
    @DrawableRes imageRes: Int,
    @StringRes nameRes: Int,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = imageRes), 
        contentDescription = stringResource(id = nameRes),
        modifier = modifier
            .padding(
                start = dimensionResource(id = R.dimen.padding_large),
                end = dimensionResource(id = R.dimen.padding_large),
                top = dimensionResource(id = R.dimen.padding_small),
                bottom = dimensionResource(id = R.dimen.padding_large),
            )
            .fillMaxWidth()
            .size(dimensionResource(id = R.dimen.image_size)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun IdeaInformation(
    @StringRes dayRes: Int,
    @StringRes nameRes: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = dayRes),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.padding_large),
                    end = dimensionResource(id = R.dimen.padding_large),
                    top = dimensionResource(id = R.dimen.padding_medium),
                    bottom = dimensionResource(id = R.dimen.padding_small),
            )
        )
        Text(
            text = stringResource(id = nameRes),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.padding_large),
                    end = dimensionResource(id = R.dimen.padding_large),
                    top = dimensionResource(id = R.dimen.padding_small),
                    bottom = dimensionResource(id = R.dimen.padding_small),
            )
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun Preview() {
    The30DaysOfBreakfastIdeasAppTheme {
        IdeasList()
    }
}