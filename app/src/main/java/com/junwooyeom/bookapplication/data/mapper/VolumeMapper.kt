package com.junwooyeom.bookapplication.data.mapper

import com.junwooyeom.bookapplication.domain.model.Volume
import com.junwooyeom.bookapplication.network.model.VolumeDto

fun VolumeDto.toVolume(): Volume =
    Volume(
        title,
        subTitle,
        authors,
        publisher,
        published,
        description
    )