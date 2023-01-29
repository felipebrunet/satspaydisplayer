package com.icripto.lnbitspost

import com.icripto.lnbitspost.builder.ServiceBuilder
import com.icripto.lnbitspost.model.InvoiceData
import com.icripto.lnbitspost.service.RestApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {
    fun getInvoice (invoiceData: InvoiceData, onResult: (InvoiceData?) -> Unit) {
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addUser(invoiceData).enqueue(
            object : Callback<InvoiceData> {
                override fun onFailure(call: Call<InvoiceData>, t: Throwable) {
                    onResult(null)
                }

                override fun onResponse(call: Call<InvoiceData>, response: Response<InvoiceData>) {
                    val invoice = response.body()
                    onResult(invoice)
                }
            }
        )
    }
}
