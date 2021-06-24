package com.sine95.tweetsrv.web.rest.ln;

import com.sine95.tweetsrv.domain.*;
import com.sine95.tweetsrv.service.*;
import com.sine95.tweetsrv.service.crud.*;
import com.sine95.tweetsrv.service.ln.*;
import com.sine95.tweetsrv.*;
import java.util.*;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import org.sine95.kernel.base.web.rest.ControllerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.sine95.kernel.base.Contexto;
import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.ResultExt;
import com.sine95.tweetsrv.errores.*;
import com.sine95.tweetsrv.warnings.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import com.codahale.metrics.annotation.Timed;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;


//entity
import com.sine95.tweetsrv.domain.Tweets;
import com.sine95.tweetsrv.domain.TweetsCrit;
import com.sine95.tweetsrv.domain.TweetsCritPaged;
import com.sine95.tweetsrv.service.crud.TweetsServiceCRUD;

//import com.sine95.tweetsrv.domain.TweetsExt;
import com.sine95.tweetsrv.domain.TweetsExt;

//entity
import com.sine95.tweetsrv.domain.Hashtags;
import com.sine95.tweetsrv.domain.HashtagsCrit;
import com.sine95.tweetsrv.domain.HashtagsCritPaged;
import com.sine95.tweetsrv.service.crud.HashtagsServiceCRUD;

//import com.sine95.tweetsrv.domain.HashtagsExt;
import com.sine95.tweetsrv.domain.HashtagsExt;

//enum

import com.sine95.tweetsrv.enums.SiNo;
    



import org.springframework.web.bind.annotation.*;



/**
* Controlador REST para la LN de ClienteTwitterLNService
*/
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class ClienteTwitterLNRest extends ControllerBase
{
  private final Logger log = LoggerFactory.getLogger(ClienteTwitterLNRest.class);
  @Autowired
  ClienteTwitterLNService service;



    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;

    @Autowired
    protected TweetsServiceCRUD tweetsService;

    @Autowired
    protected HashtagsServiceCRUD hashtagsService;


  
  
  

	@PutMapping("/clientetwitter.SendTwit/{texto}")
	@Timed
	
	public ResultExt< Vacio> SendTwit(HttpServletRequest request,HttpServletResponse response, @PathVariable String texto)
	{
		
		String params=UtilParams.paramsToString("String",texto);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_CLIENTETWITTER_SendTwit");
		ctx.put(Contexto.URL_SOLICITADA,"/clientetwitter.SendTwit/{texto}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:SendTwit("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_CLIENTETWITTER_SendTwit"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_CLIENTETWITTER_SendTwit","/clientetwitter.SendTwit/{texto}"));
			}
			else
			{
				params=UtilParams.paramsToString("String",texto);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:SendTwit("+params+")"+params);

				String texto_ = texto;

				Result< Vacio > res_=service.SendTwit(texto_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:SendTwit("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:SendTwit("+params+"). Resultado:"+res.toString());

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




//Si hay que anadir metodos se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}

