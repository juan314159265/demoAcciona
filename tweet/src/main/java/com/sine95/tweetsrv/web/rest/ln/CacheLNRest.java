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
import com.sine95.tweetsrv.domain.Configuration;
import com.sine95.tweetsrv.domain.ConfigurationCrit;
import com.sine95.tweetsrv.domain.ConfigurationCritPaged;
import com.sine95.tweetsrv.service.crud.ConfigurationServiceCRUD;

//import com.sine95.tweetsrv.domain.ConfigurationExt;
import com.sine95.tweetsrv.domain.ConfigurationExt;

//entity
import com.sine95.tweetsrv.domain.J314User;
import com.sine95.tweetsrv.domain.J314UserCrit;
import com.sine95.tweetsrv.domain.J314UserCritPaged;
import com.sine95.tweetsrv.service.crud.J314UserServiceCRUD;

//import com.sine95.tweetsrv.domain.J314UserExt;
import com.sine95.tweetsrv.domain.J314UserExt;

//enum

import com.sine95.tweetsrv.enums.AreasCache;
    



import org.springframework.web.bind.annotation.*;



/**
* Controlador REST para la LN de CacheLNService
*/
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class CacheLNRest extends ControllerBase
{
  private final Logger log = LoggerFactory.getLogger(CacheLNRest.class);
  @Autowired
  CacheLNService service;



    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;

    @Autowired
    protected ConfigurationServiceCRUD configurationService;

    @Autowired
    protected J314UserServiceCRUD j314UserService;


  
  
  

	@PostMapping("/cache.resetArea/{area}")
	@Timed
	
	public ResultExt< Vacio> resetArea(HttpServletRequest request,HttpServletResponse response, @PathVariable AreasCache area)
	{
		
		String params=UtilParams.paramsToString("AreasCache",area);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_CACHE_resetArea");
		ctx.put(Contexto.URL_SOLICITADA,"/cache.resetArea/{area}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:resetArea("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_CACHE_resetArea"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_CACHE_resetArea","/cache.resetArea/{area}"));
			}
			else
			{
				params=UtilParams.paramsToString("AreasCache",area);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:resetArea("+params+")"+params);

				AreasCache area_ = area;

				Result< Vacio > res_=service.resetArea(area_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:resetArea("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:resetArea("+params+"). Resultado:"+res.toString());

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PostMapping("/cache.getAllArea/{area}")
	@Timed
	
	public ResultExt< Map< String,String >> getAllArea(HttpServletRequest request,HttpServletResponse response, @PathVariable AreasCache area)
	{
		
		String params=UtilParams.paramsToString("AreasCache",area);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_CACHE_getAllArea");
		ctx.put(Contexto.URL_SOLICITADA,"/cache.getAllArea/{area}");
		Result< Map< String,String >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getAllArea("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_CACHE_getAllArea"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_CACHE_getAllArea","/cache.getAllArea/{area}"));
			}
			else
			{
				params=UtilParams.paramsToString("AreasCache",area);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getAllArea("+params+")"+params);

				AreasCache area_ = area;

				Result< Map< String,String > > res_=service.getAllArea(area_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:getAllArea("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:getAllArea("+params+"). Resultado:"+res.toString());

		ResultExt< Map< String,String > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




//Si hay que anadir metodos se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}

