package co.genecoin.qrcode.model

import java.io.ByteArrayOutputStream;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


object ZXingHelper {
    fun getQRCodeImage(text: String?, width: Int, height: Int): ByteArray? {
        return try {
            val qrCodeWriter = QRCodeWriter()
            val bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height)
            val byteArrayOutputStream = ByteArrayOutputStream()
            MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream)
            byteArrayOutputStream.toByteArray()
        } catch (e: Exception) {
            null
        }
    }
}