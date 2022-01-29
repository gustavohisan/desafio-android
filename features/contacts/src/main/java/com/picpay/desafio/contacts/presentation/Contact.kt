package com.picpay.desafio.contacts.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.placeholder
import com.picpay.desafio.contacts.R
import com.picpay.desafio.contacts.model.Contact as ContactData

/**
 * Composable function used to compose a Contact with its data.
 *
 * @param contactData the data of the contact
 */
@Composable
internal fun Contact(contactData: ContactData) {
    val image = rememberImagePainter(data = contactData.image)
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 12.dp)
                .size(52.dp)
                .clip(CircleShape)
                .placeholder(
                    visible = (image.state is ImagePainter.State.Success).not(),
                    color = Color.LightGray,
                    highlight = PlaceholderHighlight.fade(Color.White)
                ),
            painter = image,
            contentDescription = stringResource(id = R.string.contact_picture_description) + contactData.name
        )
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = contactData.username,
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "@" + contactData.name,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}

@Preview
@Composable
private fun ContactPreview() {
    Contact(contactData = ContactData(image = "", name = "Preview", id = 0, username = "Preview"))
}
