package com.junwooyeom.bookapplication.data.mapper

import com.junwooyeom.bookapplication.domain.model.Image
import com.junwooyeom.bookapplication.domain.model.Volume
import com.junwooyeom.bookapplication.network.model.ImageDto
import com.junwooyeom.bookapplication.network.model.VolumeDto

fun VolumeDto.toVolume(): Volume =
    Volume(
        title,
        subTitle,
        authors,
        publisher,
        published,
        description,
        categories,
        links.toImages()
    )

fun ImageDto.toImages(): Image =
    Image(
        smallThumbnail,
        thumbnail
    )