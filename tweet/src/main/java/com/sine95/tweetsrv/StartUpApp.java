package com.sine95.tweetsrv;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;

import org.apache.commons.io.IOUtils;
import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.cache.ICache;
import org.sine95.kernel.base.task.ServicioTareas;
import org.sine95.kernel.util.Vacio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.sine95.tweetsrv.repository.UtilDB;
import com.sine95.tweetsrv.config.StartAppConfiguration;
import com.sine95.tweetsrv.enums.AreasCache;
import com.sine95.tweetsrv.enums.ContingenciaCorreo;
import com.sine95.tweetsrv.service.Config;
import com.sine95.tweetsrv.service.MailService;
import com.sine95.tweetsrv.service.ln.CacheLNService;
import com.sine95.tweetsrv.service.ln.ClienteTwitterLNService;
import com.sine95.tweetsrv.service.ln.GestionTweetsLNService;

@Component
public class StartUpApp implements ApplicationListener<ContextRefreshedEvent>{

	private final Logger log = LoggerFactory.getLogger(StartUpApp.class);
	
	private StringBuilder mensajeEnCorreo=null;
	
	private String ln=System.lineSeparator();
	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		log.info("Se ha iniciado la Applicacion");
		
		
		ApplicationContext appCon = event.getApplicationContext();
		StartAppConfiguration sac=appCon.getBean(StartAppConfiguration.class);
		
		UtilDB utilDB=appCon.getBean(UtilDB.class);
		
		
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			URL uFile = classLoader.getResource("ConfigurationData.json");
			InputStream openStream = uFile.openStream();
			String contenido=IOUtils.toString(openStream,"UTF-8" );
			
			utilDB.insert(contenido);
			
		} catch (IOException | ParseException e) {

			e.printStackTrace();
			System.exit(128);
		}
		
		if("S".equalsIgnoreCase(sac.getExecuteInit()))
		{
			mensajeEnCorreo=new StringBuilder();
			MailService mail = appCon.getBean(MailService.class);
		
			resetCache(appCon);
			//Inicializacion
			initServicioTareas();
		
			Config config = appCon.getBean(Config.class);
		
			Result<Vacio> sendEmail = envioCorreo(mail, config);
			
			log.info("Resultado envio correo de arranque  de App:"+sendEmail.toString());
			
			// Arrancamos el servicio que enlaza con Twitter
			ClienteTwitterLNService clienteTwitterService = appCon.getBean(ClienteTwitterLNService.class);
			clienteTwitterService.InitCli();
			boolean end = false;
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader (isr);
			while (!end) {
				String texto;
				try {
					texto = br.readLine();
					if (texto.equals("Q")) {
						end = true;
					} else {
						clienteTwitterService.SendTwit(texto);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		}
			}
		}
		
		
	}

	private void initServicioTareas() {
		mensajeEnCorreo.append(ln);
		mensajeEnCorreo.append("Servicio Tareas:"+ln);
		mensajeEnCorreo.append("================"+ln);
		ServicioTareas st = ServicioTareas.getInstance();
		mensajeEnCorreo.append("NumHilos:"+st.getNumHilosActivos()+ln);
	}
	
	private Result<Vacio> envioCorreo(MailService mail, Config config) {
		ContingenciaCorreo contingencia = ContingenciaCorreo.ERROR;
		String[] adjuntos=new String[] {};
		byte[][] dataAdjuntos=null;
		String content=config.getMailStartUp_Content();
		String idCorreo =config.getMailStartUp_IdCorreo();
		String[] tos=null;
		if(config.getMailStartUp_Tos()!=null)
		{
			tos=config.getMailStartUp_Tos().split(",");
		}
		String[] ccs=null;
		if(config.getMailStartUp_Ccs()!=null)
		{
			ccs=config.getMailStartUp_Ccs().split(",");
		}
		String[] bccs=null;
		if(config.getMailStartUp_Bccs()!=null)
		{
			bccs = config.getMailStartUp_Bccs().split(",");
		}
		String from=config.getMailStartUp_From();
		String subject=config.getMailStartUp_Subject();
		boolean isMultipart=false;
		boolean isHtml=false;
		
		Result<Vacio> sendEmail = mail.sendEmail(
				idCorreo, 
				tos, 
				ccs, 
				bccs, 
				from, 
				subject, 
				content+mensajeEnCorreo.toString(), 
				isMultipart,
				isHtml, 
				adjuntos, 
				dataAdjuntos, 
				contingencia);
		return sendEmail;
	}
	private void resetCache(ApplicationContext appCon) {
		StartAppConfiguration startAppConfig = appCon.getBean(StartAppConfiguration.class);
		
		if(startAppConfig.getResetCache())
		{
			mensajeEnCorreo.append(ln);
			mensajeEnCorreo.append("Reset de Caches:"+ln);
			mensajeEnCorreo.append("================"+ln);
			CacheLNService caches=appCon.getBean(CacheLNService.class);
			AreasCache[] listValues = AreasCache.values();
			if(startAppConfig.getLstAreasCacheReset()!=null)
			{
				listValues=startAppConfig.getLstAreasCacheReset();
			}
			for(AreasCache area:listValues)
			{
				Result<ICache<Object>> cache = caches.getArea(area);
				if(cache.isOk())
				{
					cache.getData().reset();
					mensajeEnCorreo.append("Reseteado cache:"+area+ln);
				}
			}
		}
	}

}
