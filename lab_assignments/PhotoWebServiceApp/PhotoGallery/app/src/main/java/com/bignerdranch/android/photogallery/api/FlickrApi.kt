package com.bignerdranch.android.photogallery.api

import retrofit2.http.GET

private const val API_KEY = "091ee4435955aa7276e99617ec6a1f30"

interface FlickrApi {
    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
            "&api_key=$API_KEY" +
            "&format=json" +
            "&nojsoncallback=1" +
            "&extras=url_s"
    )
    suspend fun fetchPhotos(): FlickrResponse
}
