package com.mohamedabulgasem.bankinfoscanner.internal

import android.app.*
import com.google.zxing.integration.android.*
import com.google.zxing.integration.android.IntentIntegrator.*
import com.mohamedabulgasem.bankinfoscanner.*

internal class BankInfoScannerImpl(
    context: Activity
) : BankInfoScanner {

    private val intentIntegrator: IntentIntegrator by lazy {
        IntentIntegrator(context).apply {
            setDesiredBarcodeFormats(QR_CODE)
            setOrientationLocked(false)
            setPrompt("Scan QR code")
            setBeepEnabled(false)
            /*setCameraId(0)
            setBarcodeImageEnabled(true)*/
        }
    }

    override fun doCameraScan() {
        intentIntegrator.initiateScan()
    }

    override fun doImageScan() {
        TODO("Not yet implemented")
    }

}