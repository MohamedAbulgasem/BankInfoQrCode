package com.mohamedabulgasem.bankinfoscanner.internal

import android.graphics.*
import com.google.zxing.*
import com.journeyapps.barcodescanner.*
import com.mohamedabulgasem.bankinfoscanner.*

internal fun encodeBitmap(
    bankInfo: BankInfo,
    width: Int,
    height: Int
): Bitmap = BarcodeEncoder()
    .encodeBitmap(
        bankInfo.toString(),
        BarcodeFormat.QR_CODE,
        width,
        height
    )
