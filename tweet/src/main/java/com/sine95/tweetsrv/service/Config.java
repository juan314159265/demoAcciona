package com.sine95.tweetsrv.service;

import org.springframework.context.ApplicationContext;
import org.sine95.kernel.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sine95.tweetsrv.service.ln.CacheLNService;
import org.sine95.kernel.base.cache.ICache;

import com.sine95.tweetsrv.service.crud.ConfigurationServiceCRUD;
import com.sine95.tweetsrv.domain.Configuration;


@Service
public class Config {

	@Autowired
	ConfigurationServiceCRUD service;

	@Autowired
	ApplicationContext appCon;
	
	public enum Claves{

		emailNotif_user
,
		emailNotif_password
,
		emailNotif_mailserver
,
		MailStartUp_IdCorreo
,
		MailStartUp_Tos
,
		MailStartUp_Ccs
,
		MailStartUp_Bccs
,
		MailStartUp_From
,
		MailStartUp_Subject
,
		MailStartUp_Content
,
		MaxNumHashTags
,
		TiempoEnSecParaCambioTicketAntesFinSesion
,
		NumMinSuscriptoresUsuarioParaPersistir
,
		IdiomasPermitidosParaPersistir
,
		pruebaString
,
		PruebaInt
,
		PruebaLong
        
	}
	
	protected static ICache<Configuration> cache=null;
	
	protected ICache<Configuration> getData()
	{	
		if(cache==null)
		{
			CacheLNService cacheService=appCon.getBean(CacheLNService.class);
			Result<ICache<Configuration>> res = cacheService.getCacheAreaConfiguration();
			if(res.isOk())
			{
				cache=res.getData();
			}
		}
		return cache;
		
	}
	
	/**
	Usuario para acceder al servidor de correos
	*/
	public String getEmailNotif_userAsString()
	{
		Configuration res = getData().get(Claves.emailNotif_user.toString()).getData();
		
		return res.getValue();
	}
	public String getEmailNotif_user()
	{

		return getEmailNotif_userAsString();

	}

	/**
	Contraseña para acceder al servidor de correos
	*/
	public String getEmailNotif_passwordAsString()
	{
		Configuration res = getData().get(Claves.emailNotif_password.toString()).getData();
		
		return res.getValue();
	}
	public String getEmailNotif_password()
	{

		return getEmailNotif_passwordAsString();

	}

	/**
	Servidor de correos para el envío de notificaciones / avisos a los usuarios
	*/
	public String getEmailNotif_mailserverAsString()
	{
		Configuration res = getData().get(Claves.emailNotif_mailserver.toString()).getData();
		
		return res.getValue();
	}
	public String getEmailNotif_mailserver()
	{

		return getEmailNotif_mailserverAsString();

	}

	/**
	Identificador de correo
	*/
	public String getMailStartUp_IdCorreoAsString()
	{
		Configuration res = getData().get(Claves.MailStartUp_IdCorreo.toString()).getData();
		
		return res.getValue();
	}
	public String getMailStartUp_IdCorreo()
	{

		return getMailStartUp_IdCorreoAsString();

	}

	/**
	Separado por comas
	*/
	public String getMailStartUp_TosAsString()
	{
		Configuration res = getData().get(Claves.MailStartUp_Tos.toString()).getData();
		
		return res.getValue();
	}
	public String getMailStartUp_Tos()
	{

		return getMailStartUp_TosAsString();

	}

	/**
	Separado por comas
	*/
	public String getMailStartUp_CcsAsString()
	{
		Configuration res = getData().get(Claves.MailStartUp_Ccs.toString()).getData();
		
		return res.getValue();
	}
	public String getMailStartUp_Ccs()
	{

		return getMailStartUp_CcsAsString();

	}

	/**
	Separado por comas
	*/
	public String getMailStartUp_BccsAsString()
	{
		Configuration res = getData().get(Claves.MailStartUp_Bccs.toString()).getData();
		
		return res.getValue();
	}
	public String getMailStartUp_Bccs()
	{

		return getMailStartUp_BccsAsString();

	}

	/**
	Desde
	*/
	public String getMailStartUp_FromAsString()
	{
		Configuration res = getData().get(Claves.MailStartUp_From.toString()).getData();
		
		return res.getValue();
	}
	public String getMailStartUp_From()
	{

		return getMailStartUp_FromAsString();

	}

	/**
	Init
	*/
	public String getMailStartUp_SubjectAsString()
	{
		Configuration res = getData().get(Claves.MailStartUp_Subject.toString()).getData();
		
		return res.getValue();
	}
	public String getMailStartUp_Subject()
	{

		return getMailStartUp_SubjectAsString();

	}

	/**
	Init
	*/
	public String getMailStartUp_ContentAsString()
	{
		Configuration res = getData().get(Claves.MailStartUp_Content.toString()).getData();
		
		return res.getValue();
	}
	public String getMailStartUp_Content()
	{

		return getMailStartUp_ContentAsString();

	}

	/**
	Máximo de hashtags
	*/
	public String getMaxNumHashTagsAsString()
	{
		Configuration res = getData().get(Claves.MaxNumHashTags.toString()).getData();
		
		return res.getValue();
	}
	public Integer getMaxNumHashTags()
	{

        return Integer.parseInt(getMaxNumHashTagsAsString(),10);

	}

	/**
	PruebaInt
	*/
	public String getTiempoEnSecParaCambioTicketAntesFinSesionAsString()
	{
		Configuration res = getData().get(Claves.TiempoEnSecParaCambioTicketAntesFinSesion.toString()).getData();
		
		return res.getValue();
	}
	public Integer getTiempoEnSecParaCambioTicketAntesFinSesion()
	{

        return Integer.parseInt(getTiempoEnSecParaCambioTicketAntesFinSesionAsString(),10);

	}

	/**
	Solo se deben persistir aquellos tweets cuyos usuarios superen un número N de seguidores (default 1500).
	*/
	public String getNumMinSuscriptoresUsuarioParaPersistirAsString()
	{
		Configuration res = getData().get(Claves.NumMinSuscriptoresUsuarioParaPersistir.toString()).getData();
		
		return res.getValue();
	}
	public Long getNumMinSuscriptoresUsuarioParaPersistir()
	{

        return Long.parseLong(getNumMinSuscriptoresUsuarioParaPersistirAsString(),10);

	}

	/**
	Solo se deben persistir aquellos tweets cuyo idioma esté en una lista de idiomas permitidos (default español, francés, italiano).
	*/
	public String getIdiomasPermitidosParaPersistirAsString()
	{
		Configuration res = getData().get(Claves.IdiomasPermitidosParaPersistir.toString()).getData();
		
		return res.getValue();
	}
	public String getIdiomasPermitidosParaPersistir()
	{

		return getIdiomasPermitidosParaPersistirAsString();

	}

	/**
	PruebaString prueba1
	*/
	public String getPruebaStringAsString()
	{
		Configuration res = getData().get(Claves.pruebaString.toString()).getData();
		
		return res.getValue();
	}
	public String getPruebaString()
	{

		return getPruebaStringAsString();

	}

	/**
	PruebaInt
	*/
	public String getPruebaIntAsString()
	{
		Configuration res = getData().get(Claves.PruebaInt.toString()).getData();
		
		return res.getValue();
	}
	public Integer getPruebaInt()
	{

        return Integer.parseInt(getPruebaIntAsString(),10);

	}

	/**
	PruebaLong
	*/
	public String getPruebaLongAsString()
	{
		Configuration res = getData().get(Claves.PruebaLong.toString()).getData();
		
		return res.getValue();
	}
	public Long getPruebaLong()
	{

        return Long.parseLong(getPruebaLongAsString(),10);

	}
        

	public String get(String clave)
	{
		return getData().get(clave).getData().getValue();
	}

	public static void reset()
	{
		cache.reset();
	}
}

