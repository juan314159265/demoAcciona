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


//textual
import org.sine95.kernel.base.task.ITicket;
    
//obj    
import com.sine95.tweetsrv.domain.ParamInCambiaPosTarea;
    
//obj    
import com.sine95.tweetsrv.domain.ParamOutITicket;
    
//obj    
import com.sine95.tweetsrv.domain.ParamOutTasks;
    
//enum

import com.sine95.tweetsrv.enums.ColaHilos;
    
//enum

import com.sine95.tweetsrv.enums.TareasPeriodicas;
    



import org.springframework.web.bind.annotation.*;



/**
* Controlador REST para la LN de GestionHilosLNService
*/
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class GestionHilosLNRest extends ControllerBase
{
  private final Logger log = LoggerFactory.getLogger(GestionHilosLNRest.class);
  @Autowired
  GestionHilosLNService service;



    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;


  
  
  

	@PutMapping("/gestionhilos.addHilos/{cola}/{numHilos}")
	@Timed
	
	public ResultExt< Vacio> addHilos(HttpServletRequest request,HttpServletResponse response, @PathVariable ColaHilos cola, @PathVariable Integer numHilos)
	{
		
		String params=UtilParams.paramsToString("ColaHilos",cola, "Integer",numHilos);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONHILOS_addHilos");
		ctx.put(Contexto.URL_SOLICITADA,"/gestionhilos.addHilos/{cola}/{numHilos}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:addHilos("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONHILOS_addHilos"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONHILOS_addHilos","/gestionhilos.addHilos/{cola}/{numHilos}"));
			}
			else
			{
				params=UtilParams.paramsToString("ColaHilos",cola, "Integer",numHilos);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:addHilos("+params+")"+params);

				ColaHilos cola_ = cola;

				Integer numHilos_ = numHilos;

				Result< Vacio > res_=service.addHilos(cola_, numHilos_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:addHilos("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:addHilos("+params+"). Resultado:"+res.toString());

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PutMapping("/gestionhilos.removeHilos/{cola}/{numHilos}")
	@Timed
	
	public ResultExt< Vacio> removeHilos(HttpServletRequest request,HttpServletResponse response, @PathVariable ColaHilos cola, @PathVariable Integer numHilos)
	{
		
		String params=UtilParams.paramsToString("ColaHilos",cola, "Integer",numHilos);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONHILOS_removeHilos");
		ctx.put(Contexto.URL_SOLICITADA,"/gestionhilos.removeHilos/{cola}/{numHilos}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:removeHilos("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONHILOS_removeHilos"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONHILOS_removeHilos","/gestionhilos.removeHilos/{cola}/{numHilos}"));
			}
			else
			{
				params=UtilParams.paramsToString("ColaHilos",cola, "Integer",numHilos);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:removeHilos("+params+")"+params);

				ColaHilos cola_ = cola;

				Integer numHilos_ = numHilos;

				Result< Vacio > res_=service.removeHilos(cola_, numHilos_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:removeHilos("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:removeHilos("+params+"). Resultado:"+res.toString());

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PutMapping("/gestionhilos.getListaTaskEjecutando")
	@Timed
	
	public ResultExt< List< ParamOutITicket >> getListaTaskEjecutando(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONHILOS_getListaTaskEjecutando");
		ctx.put(Contexto.URL_SOLICITADA,"/gestionhilos.getListaTaskEjecutando");
		Result< List< ParamOutITicket >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:getListaTaskEjecutando("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONHILOS_getListaTaskEjecutando"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONHILOS_getListaTaskEjecutando","/gestionhilos.getListaTaskEjecutando"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:getListaTaskEjecutando("+params+")"+params);

				Result< List< ParamOutITicket > > res_=service.getListaTaskEjecutando();
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:getListaTaskEjecutando("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:getListaTaskEjecutando("+params+"). Resultado:"+res.toString());

		ResultExt< List< ParamOutITicket > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PutMapping("/gestionhilos.getListaTaskEnCola")
	@Timed
	
	public ResultExt< List< ParamOutITicket >> getListaTaskEnCola(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONHILOS_getListaTaskEnCola");
		ctx.put(Contexto.URL_SOLICITADA,"/gestionhilos.getListaTaskEnCola");
		Result< List< ParamOutITicket >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:getListaTaskEnCola("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONHILOS_getListaTaskEnCola"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONHILOS_getListaTaskEnCola","/gestionhilos.getListaTaskEnCola"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:getListaTaskEnCola("+params+")"+params);

				Result< List< ParamOutITicket > > res_=service.getListaTaskEnCola();
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:getListaTaskEnCola("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:getListaTaskEnCola("+params+"). Resultado:"+res.toString());

		ResultExt< List< ParamOutITicket > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PutMapping("/gestionhilos.cancelaTarea/{cola}")
	@Timed
	
	public ResultExt< Vacio> cancelaTarea(HttpServletRequest request,HttpServletResponse response, @PathVariable ColaHilos cola, @RequestBody String id)
	{
		
		String params=UtilParams.paramsToString("ColaHilos",cola, "String",id);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONHILOS_cancelaTarea");
		ctx.put(Contexto.URL_SOLICITADA,"/gestionhilos.cancelaTarea/{cola}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:cancelaTarea("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONHILOS_cancelaTarea"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONHILOS_cancelaTarea","/gestionhilos.cancelaTarea/{cola}"));
			}
			else
			{
				params=UtilParams.paramsToString("ColaHilos",cola, "String",id);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:cancelaTarea("+params+")"+params);

				ColaHilos cola_ = cola;

				String id_ = id;

				Result< Vacio > res_=service.cancelaTarea(cola_, id_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:cancelaTarea("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:cancelaTarea("+params+"). Resultado:"+res.toString());

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PutMapping("/gestionhilos.cambiaPosTarea")
	@Timed
	
	public ResultExt< Vacio> cambiaPosTarea(HttpServletRequest request,HttpServletResponse response, @RequestBody ParamInCambiaPosTarea paramIn)
	{
		
		String params=UtilParams.paramsToString("ParamInCambiaPosTarea",paramIn);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONHILOS_cambiaPosTarea");
		ctx.put(Contexto.URL_SOLICITADA,"/gestionhilos.cambiaPosTarea");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:cambiaPosTarea("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONHILOS_cambiaPosTarea"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONHILOS_cambiaPosTarea","/gestionhilos.cambiaPosTarea"));
			}
			else
			{
				params=UtilParams.paramsToString("ParamInCambiaPosTarea",paramIn);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:cambiaPosTarea("+params+")"+params);

				ParamInCambiaPosTarea paramIn_ = paramIn;

				Result< Vacio > res_=service.cambiaPosTarea(paramIn_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:cambiaPosTarea("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:cambiaPosTarea("+params+"). Resultado:"+res.toString());

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PutMapping("/gestionhilos.encolaTareaTest/{cola}")
	@Timed
	
	public ResultExt< Vacio> encolaTareaTest(HttpServletRequest request,HttpServletResponse response, @PathVariable ColaHilos cola)
	{
		
		String params=UtilParams.paramsToString("ColaHilos",cola);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONHILOS_encolaTareaTest");
		ctx.put(Contexto.URL_SOLICITADA,"/gestionhilos.encolaTareaTest/{cola}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:encolaTareaTest("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONHILOS_encolaTareaTest"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONHILOS_encolaTareaTest","/gestionhilos.encolaTareaTest/{cola}"));
			}
			else
			{
				params=UtilParams.paramsToString("ColaHilos",cola);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:encolaTareaTest("+params+")"+params);

				ColaHilos cola_ = cola;

				Result< Vacio > res_=service.encolaTareaTest(cola_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:encolaTareaTest("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:encolaTareaTest("+params+"). Resultado:"+res.toString());

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PutMapping("/gestionhilos.getNumHilos/{cola}")
	@Timed
	
	public ResultExt< Integer> getNumHilos(HttpServletRequest request,HttpServletResponse response, @PathVariable ColaHilos cola)
	{
		
		String params=UtilParams.paramsToString("ColaHilos",cola);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONHILOS_getNumHilos");
		ctx.put(Contexto.URL_SOLICITADA,"/gestionhilos.getNumHilos/{cola}");
		Result< Integer> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:getNumHilos("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONHILOS_getNumHilos"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONHILOS_getNumHilos","/gestionhilos.getNumHilos/{cola}"));
			}
			else
			{
				params=UtilParams.paramsToString("ColaHilos",cola);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:getNumHilos("+params+")"+params);

				ColaHilos cola_ = cola;

				Result< Integer > res_=service.getNumHilos(cola_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:getNumHilos("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:getNumHilos("+params+"). Resultado:"+res.toString());

		ResultExt< Integer > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PutMapping("/gestionhilos.getInfoTasks")
	@Timed
	
	public ResultExt< List< ParamOutTasks >> getInfoTasks(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONHILOS_getInfoTasks");
		ctx.put(Contexto.URL_SOLICITADA,"/gestionhilos.getInfoTasks");
		Result< List< ParamOutTasks >> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:getInfoTasks("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONHILOS_getInfoTasks"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONHILOS_getInfoTasks","/gestionhilos.getInfoTasks"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:getInfoTasks("+params+")"+params);

				Result< List< ParamOutTasks > > res_=service.getInfoTasks();
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:getInfoTasks("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:getInfoTasks("+params+"). Resultado:"+res.toString());

		ResultExt< List< ParamOutTasks > > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PutMapping("/gestionhilos.execTasks/{tarea}")
	@Timed
	
	public ResultExt< Vacio> execTasks(HttpServletRequest request,HttpServletResponse response, @PathVariable TareasPeriodicas tarea)
	{
		
		String params=UtilParams.paramsToString("TareasPeriodicas",tarea);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONHILOS_execTasks");
		ctx.put(Contexto.URL_SOLICITADA,"/gestionhilos.execTasks/{tarea}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:execTasks("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONHILOS_execTasks"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONHILOS_execTasks","/gestionhilos.execTasks/{tarea}"));
			}
			else
			{
				params=UtilParams.paramsToString("TareasPeriodicas",tarea);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:execTasks("+params+")"+params);

				TareasPeriodicas tarea_ = tarea;

				Result< Vacio > res_=service.execTasks(tarea_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:execTasks("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:execTasks("+params+"). Resultado:"+res.toString());

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PutMapping("/gestionhilos.activaTask/{tarea}")
	@Timed
	
	public ResultExt< Vacio> activaTask(HttpServletRequest request,HttpServletResponse response, @PathVariable TareasPeriodicas tarea)
	{
		
		String params=UtilParams.paramsToString("TareasPeriodicas",tarea);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONHILOS_activaTask");
		ctx.put(Contexto.URL_SOLICITADA,"/gestionhilos.activaTask/{tarea}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:activaTask("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONHILOS_activaTask"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONHILOS_activaTask","/gestionhilos.activaTask/{tarea}"));
			}
			else
			{
				params=UtilParams.paramsToString("TareasPeriodicas",tarea);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:activaTask("+params+")"+params);

				TareasPeriodicas tarea_ = tarea;

				Result< Vacio > res_=service.activaTask(tarea_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:activaTask("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:activaTask("+params+"). Resultado:"+res.toString());

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PutMapping("/gestionhilos.desactivaTask/{tarea}")
	@Timed
	
	public ResultExt< Vacio> desactivaTask(HttpServletRequest request,HttpServletResponse response, @PathVariable TareasPeriodicas tarea)
	{
		
		String params=UtilParams.paramsToString("TareasPeriodicas",tarea);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_GESTIONHILOS_desactivaTask");
		ctx.put(Contexto.URL_SOLICITADA,"/gestionhilos.desactivaTask/{tarea}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST PUT:desactivaTask("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_GESTIONHILOS_desactivaTask"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_GESTIONHILOS_desactivaTask","/gestionhilos.desactivaTask/{tarea}"));
			}
			else
			{
				params=UtilParams.paramsToString("TareasPeriodicas",tarea);
				if (log.isInfoEnabled()) log.info("Verificado en REST PUT:desactivaTask("+params+")"+params);

				TareasPeriodicas tarea_ = tarea;

				Result< Vacio > res_=service.desactivaTask(tarea_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST PUT:desactivaTask("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST PUT:desactivaTask("+params+"). Resultado:"+res.toString());

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




//Si hay que anadir metodos se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}

