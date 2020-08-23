package com.mohamedabulgasem.bankinfoqrcodesample

import android.annotation.*
import android.content.*
import android.graphics.*
import android.os.*
import android.view.*
import androidx.appcompat.app.*
import com.google.zxing.*
import com.google.zxing.common.*
import com.google.zxing.integration.android.IntentIntegrator.*
import com.mohamedabulgasem.bankinfoqrcode.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val bankInfoScanner: BankInfoQrCode by lazy {
        BankInfoQrCode.Builder(this)
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onScanButtonClicked(v: View) {
        bankInfoScanner.doCameraScan()
    }

    fun onGenerateButtonClicked(v: View) {
        val qrCodeBitmap = BankInfoQrCode.generateQrCode(
            BankInfo(
                accountHolder = "M A F Abulgasem\n",
                accountNumber = "123456789012345",
                bankName = "Absa",
                branchCode = "139558"
            )
        )
        qrCodeImageView.setImageBitmap(qrCodeBitmap)
        contentTextView.text = decodeQrCode(qrCodeBitmap)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        val result = parseActivityResult(requestCode, resultCode, data)
        when {
            result == null -> super.onActivityResult(requestCode, resultCode, data)
            result.contents == null -> contentTextView.text =
                "Ops you've cancelled the operation ... Try scanning again!"
            else -> contentTextView.text = "QR code content:\n\n${result.contents}"
        }
    }

    private fun decodeQrCode(bitmap: Bitmap): String {
        val source = RGBLuminanceSource(
            bitmap.width,
            bitmap.height,
            bitmap.pixels
        )
        val binaryBitmap = BinaryBitmap(HybridBinarizer(source))
        val reader = MultiFormatReader()
        val result = reader.decode (binaryBitmap)
        return result.text
    }

    private val Bitmap.pixels: IntArray
        get() {
            val pixels = IntArray(width * height)
            getPixels(pixels, 0, width, 0, 0, width, height)
            return pixels
        }

}