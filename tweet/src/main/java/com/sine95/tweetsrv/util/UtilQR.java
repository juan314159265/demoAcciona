package com.sine95.tweetsrv.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class UtilQR {

	public static byte[] genQR(String code) throws WriterException, IOException
	{
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(code, BarcodeFormat.QR_CODE, 300, 300);
        
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", stream);
		return stream.toByteArray();
	}
}
