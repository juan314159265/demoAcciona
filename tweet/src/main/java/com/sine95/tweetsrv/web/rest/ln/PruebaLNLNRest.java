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





import org.springframework.web.bind.annotation.*;



/**
* Controlador REST para la LN de PruebaLNLNService
*/
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class PruebaLNLNRest extends ControllerBase
{
  private final Logger log = LoggerFactory.getLogger(PruebaLNLNRest.class);
  @Autowired
  PruebaLNLNService service;



    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;


  
  
  

	@GetMapping("/pruebaln.Suma/{num1}/{num2}")
	@Timed

	@Transactional
	
	public ResultExt< Long> Suma(HttpServletRequest request,HttpServletResponse response, @PathVariable Long num1, @PathVariable Long num2)
	{
		
		String params=UtilParams.paramsToString("Long",num1, "Long",num2);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_PRUEBALN_Suma");
		ctx.put(Contexto.URL_SOLICITADA,"/pruebaln.Suma/{num1}/{num2}");
		Result< Long> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:Suma("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_PRUEBALN_Suma"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_PRUEBALN_Suma","/pruebaln.Suma/{num1}/{num2}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",num1, "Long",num2);
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:Suma("+params+")"+params);

				Long num1_ = num1;

				Long num2_ = num2;

				Result< Long > res_=service.Suma(num1_, num2_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:Suma("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:Suma("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST GET:Suma("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< Long > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@GetMapping("/pruebaln.Multiplicacion/{num1}/{num2}")
	@Timed

	@Transactional
	
	public ResultExt< Long> Multiplicacion(HttpServletRequest request,HttpServletResponse response, @PathVariable Long num1, @PathVariable Long num2)
	{
		
		String params=UtilParams.paramsToString("Long",num1, "Long",num2);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_PRUEBALN_Multiplicacion");
		ctx.put(Contexto.URL_SOLICITADA,"/pruebaln.Multiplicacion/{num1}/{num2}");
		Result< Long> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST GET:Multiplicacion("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_PRUEBALN_Multiplicacion"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_PRUEBALN_Multiplicacion","/pruebaln.Multiplicacion/{num1}/{num2}"));
			}
			else
			{
				params=UtilParams.paramsToString("Long",num1, "Long",num2);
				if (log.isInfoEnabled()) log.info("Verificado en REST GET:Multiplicacion("+params+")"+params);

				Long num1_ = num1;

				Long num2_ = num2;

				Result< Long > res_=service.Multiplicacion(num1_, num2_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST GET:Multiplicacion("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST GET:Multiplicacion("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST GET:Multiplicacion("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< Long > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




//Si hay que anadir metodos se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}

