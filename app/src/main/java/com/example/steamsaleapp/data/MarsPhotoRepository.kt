package com.example.steamsaleapp.data

import com.example.steamsaleapp.model.MarsPhoto
import com.example.steamsaleapp.network.MarsApiService

/**
 * Repository interface to fetch Mars photos.
 */
interface MarsPhotosRepository {
    /** Fetches list of [MarsPhoto] from marsAPI. */
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

class NetworkMarsPhotosRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository {
    /** Fetches list of [MarsPhoto] from marsAPI. */
    override suspend fun getMarsPhotos(): List<MarsPhoto> = marsApiService.getPhotos()
}