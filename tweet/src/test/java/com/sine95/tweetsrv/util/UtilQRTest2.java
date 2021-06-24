package com.sine95.tweetsrv.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.google.zxing.WriterException;

class UtilQRTest2 {

	@Test
	void testGenQR() {
		try {
			byte[] arrbyte=UtilQR.genQR("Hola Mundo");
			byte[] comp= {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 1, 44, 0, 0, 1, 44, 1, 0, 0, 0, 0, 81, 6, -77, -40, 0, 0, 1, 22, 73, 68, 65, 84, 120, -38, -19, -38, 65, 14, -125, 32, 16, -123, 97, 88, 121, 12, -113, -86, 71, -11, 8, 93, -70, -110, -126, 12, 78, 77, -115, -70, -112, 33, 109, 126, 22, 77, 109, -65, -82, 38, -52, 27, 72, 93, -72, -77, 94, 14, 6, -125, -63, 96, -80, -97, 98, -77, -109, -43, -57, -121, -79, -97, 125, 24, -27, 3, 15, -77, 99, -7, 41, -118, -14, -88, -17, 96, -122, 108, 76, -123, -55, 117, -110, -118, -91, -38, -63, -102, 48, 45, 22, -84, 33, 91, -36, 48, 57, 88, 35, 86, 26, -41, 18, -65, -19, -62, 101, 127, -125, 85, 96, 91, -120, -49, -2, 86, -42, -61, 42, 48, 93, -102, -33, -89, 115, 47, -84, 2, -53, 77, 74, -86, 35, 61, 75, 39, 43, -104, 17, 75, 123, -92, 75, -55, -111, 95, -126, -92, -55, -9, -79, 2, 86, -113, -91, -107, 68, 46, 81, -118, -113, 48, -59, -126, -83, 113, 14, -77, 98, 113, -113, 12, 98, 87, -31, -73, -97, 6, -104, 25, 75, 3, -108, -100, -21, 100, -53, 124, 88, -104, 21, -45, 16, 47, 101, -109, 102, 6, -77, 99, -121, 3, -19, 65, -54, -64, -86, -78, -19, 112, 87, -90, 40, 105, 92, 48, 91, 54, -70, -3, -11, 70, 73, 14, 88, 3, 86, 70, -87, 50, -33, -62, 90, 48, 61, 96, -72, -85, 123, 114, -40, -13, 76, 27, -41, -112, 79, 20, -57, -59, -126, 85, 100, -69, 16, -49, 87, -81, 107, -9, 58, -53, 122, -40, -61, -116, -65, 67, -64, 96, 48, 24, -20, 111, -40, 27, 116, -105, -32, -92, -45, 39, -127, -16, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
			//System.out.println(arrbyte);
			assertArrayEquals(comp, arrbyte);
			/*
			File f=new File("C:/proyectos/pruebaQR.png");
			FileOutputStream fos=new FileOutputStream(f);
			fos.write(arrbyte);
			fos.close();
			*/
			/*
			arrbyte=UtilQR.genQR("14542");
			File f=new File("C:/proyectos/pruebaQR_14542.png");
			FileOutputStream fos=new FileOutputStream(f);
			fos.write(arrbyte);
			fos.close();
			*/
		} catch (WriterException e) {
			
			e.printStackTrace();
			fail("Error, ha levantado excepcion "+e);
		} catch (IOException e) {
			
			e.printStackTrace();
			fail("Error, ha levantado excepcion "+e);
		}
		//System.out.println("Fin");
	}

}
