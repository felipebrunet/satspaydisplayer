package com.icripto.lnbitspost.service

import com.icripto.lnbitspost.model.InvoiceData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RestApi {

    @Headers("Content-Type: application/json")
    @POST("satspay/api/v1/charge?api-key=149e50e346754b9695178a011ddd05e4")
    fun addUser(@Body invoiceData: InvoiceData): Call<InvoiceData>
}
