package com.sine95.tweetsrv.config;

import org.sine95.kernel.util.UtilJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTConfiguration {
	
	protected String modoCifrado;
	protected String password;

	public JWTConfiguration(@Value("${j314.jwt.modo_cifrado}") String modo,@Value("${j314.jwt.password}") String password )
	{
		UtilJWT.setModoCifrado(modo);
		modoCifrado=modo;
		UtilJWT.setPasswordDefecto(password);
		this.password=password;
	}

	public String getModoCifrado() {
		return modoCifrado;
	}
	
	public String getPassword()
	{
		return password;
	}
}
