package com.mohamedabulgasem.bankinfoscanner

import android.app.*
import android.graphics.*
import com.mohamedabulgasem.bankinfoscanner.internal.*

interface BankInfoScanner {

    fun doCameraScan()

    fun doImageScan()

    class Builder(
        private val context: Activity
    ) {

        fun build() : BankInfoScanner = BankInfoScannerImpl(
            context
        )

    }

    companion object {
        fun generateQrCode(
            bankInfo: BankInfo,
            width: Int = 1024,
            height: Int = 1024
        ): Bitmap = encodeBitmap(
            bankInfo,
            width,
            height
        )
    }

}

data class BankInfo(
    val accountHolder: String,
    val accountNumber: String,
    val bankName: String?,
    val branchCode: String?
)