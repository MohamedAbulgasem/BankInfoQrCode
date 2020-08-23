package com.mohamedabulgasem.bankinfoqrcode

import android.app.*
import android.graphics.*
import com.mohamedabulgasem.bankinfoqrcode.internal.*

interface BankInfoQrCode {

    fun doCameraScan()

    fun doImageScan()

    class Builder(
        private val context: Activity
    ) {

        fun build() : BankInfoQrCode = BankInfoQrCodeImpl(
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