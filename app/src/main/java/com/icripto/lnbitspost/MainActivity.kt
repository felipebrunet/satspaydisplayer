package com.icripto.lnbitspost

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.icripto.lnbitspost.model.InvoiceData


const val urlSite = "https://lnbits.icripto.cl/"
const val urlPago = "https://lnbits.icripto.cl/satspay"
const val apiKey = "149e50e346754b9695178a011ddd05e4"
const val lnWalletId = "485dd2ed0cad49cb8e1ffcebe8fdcf8b"
const val onChainWalletId = "XLtdyJvwKYBHYxiVbPEhNX"


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datosPago = findViewById<TextView>(R.id.datos_pago)
        val apiService = RestApiService()
        val invoiceData = InvoiceData(
            amount = 100,
            balance = null,
            completelink = "https://icripto.cl",
            completelinktext = "Gracias",
            description = "Restaurant",
            id = null,
            lnbitswallet = lnWalletId,
            onchainwallet = onChainWalletId,
            onchainaddress = null,
            paid = null,
            payment_hash = null,
            payment_request = null,
            time = 20,
            time_elapsed = null,
            time_left = null,
            timestamp = null,
            user = null,
            webhook = "https://icripto.cl"
        )

        apiService.getInvoice(invoiceData) {
            if (it?.id != null) {
//                datosPago.text = "Ok, el id es ${it.id}"
                startActivity(Intent.parseUri("$urlPago/${it.id}", 0))

            } else {
                datosPago.text = "Error registering new user"
            }
        }




    }
}