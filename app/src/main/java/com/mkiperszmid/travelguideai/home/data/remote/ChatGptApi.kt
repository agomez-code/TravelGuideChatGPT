package com.mkiperszmid.travelguideai.home.data.remote

import com.mkiperszmid.travelguideai.home.data.remote.dto.ChatResponseDto
import com.mkiperszmid.travelguideai.home.data.remote.dto.ChatRequestDto
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatGptApi {
    companion object {
        const val BASE_URL = "https://api.openai.com/v1/chat/"
    }

    @POST("completions")
    suspend fun getTravelInformation(@Body body: ChatRequestDto): ChatResponseDto
}
