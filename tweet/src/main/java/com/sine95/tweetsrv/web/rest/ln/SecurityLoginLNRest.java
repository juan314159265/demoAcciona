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
import com.sine95.tweetsrv.domain.J314User;
import com.sine95.tweetsrv.domain.J314UserCrit;
import com.sine95.tweetsrv.domain.J314UserCritPaged;
import com.sine95.tweetsrv.service.crud.J314UserServiceCRUD;

//import com.sine95.tweetsrv.domain.J314UserExt;
import com.sine95.tweetsrv.domain.J314UserExt;

//entity
import com.sine95.tweetsrv.domain.J314UserAuthority;
import com.sine95.tweetsrv.domain.J314UserAuthorityCrit;
import com.sine95.tweetsrv.domain.J314UserAuthorityCritPaged;
import com.sine95.tweetsrv.service.crud.J314UserAuthorityServiceCRUD;

//entity
import com.sine95.tweetsrv.domain.SecurityGroup;
import com.sine95.tweetsrv.domain.SecurityGroupCrit;
import com.sine95.tweetsrv.domain.SecurityGroupCritPaged;
import com.sine95.tweetsrv.service.crud.SecurityGroupServiceCRUD;

//import com.sine95.tweetsrv.domain.SecurityGroupExt;
import com.sine95.tweetsrv.domain.SecurityGroupExt;

//obj    
import com.sine95.tweetsrv.domain.ResLogin;
    
//obj    
import com.sine95.tweetsrv.domain.InfoUser;
    
//enum

import com.sine95.tweetsrv.enums.SiNo;
    



import org.springframework.web.bind.annotation.*;



/**
* Controlador REST para la LN de SecurityLoginLNService
*/
@RestController
@RequestMapping("/api")
@SuppressWarnings("unused")
public class SecurityLoginLNRest extends ControllerBase
{
  private final Logger log = LoggerFactory.getLogger(SecurityLoginLNRest.class);
  @Autowired
  SecurityLoginLNService service;



    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;

    @Autowired
    protected J314UserServiceCRUD j314UserService;

    @Autowired
    protected J314UserAuthorityServiceCRUD j314UserAuthorityService;

    @Autowired
    protected SecurityGroupServiceCRUD securityGroupService;


  
  
  

	@PostMapping("/securitylogin.login/{userlogin}/{password}")
	@Timed

	@Transactional
	
	public ResultExt< ResLogin> login(HttpServletRequest request,HttpServletResponse response, @PathVariable String userlogin, @PathVariable String password)
	{
		
		String params=UtilParams.paramsToString("String",userlogin, "String",password);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_SECURITYLOGIN_login");
		ctx.put(Contexto.URL_SOLICITADA,"/securitylogin.login/{userlogin}/{password}");
		Result< ResLogin> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:login("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_SECURITYLOGIN_login"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_SECURITYLOGIN_login","/securitylogin.login/{userlogin}/{password}"));
			}
			else
			{
				params=UtilParams.paramsToString("String",userlogin, "String",password);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:login("+params+")"+params);

				String userlogin_ = userlogin;

				String password_ = password;

				Result< ResLogin > res_=service.login(userlogin_, password_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:login("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:login("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:login("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< ResLogin > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PostMapping("/securitylogin.logout")
	@Timed

	@Transactional
	
	public ResultExt< Vacio> logout(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_SECURITYLOGIN_logout");
		ctx.put(Contexto.URL_SOLICITADA,"/securitylogin.logout");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:logout("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_SECURITYLOGIN_logout"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_SECURITYLOGIN_logout","/securitylogin.logout"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:logout("+params+")"+params);

				Result< Vacio > res_=service.logout();
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:logout("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:logout("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:logout("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PostMapping("/securitylogin.createUser")
	@Timed

	@Transactional
	
	public ResultExt< J314User> createUser(HttpServletRequest request,HttpServletResponse response, @RequestBody J314UserPoj user)
	{
		
		String params=UtilParams.paramsToString("J314UserPoj",user);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_SECURITYLOGIN_createUser");
		ctx.put(Contexto.URL_SOLICITADA,"/securitylogin.createUser");
		Result< J314User> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:createUser("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_SECURITYLOGIN_createUser"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_SECURITYLOGIN_createUser","/securitylogin.createUser"));
			}
			else
			{
				params=UtilParams.paramsToString("J314UserPoj",user);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:createUser("+params+")"+params);

				J314User user_ = J314UserPoj.getModel(user);

				Result< J314User > res_=service.createUser(user_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:createUser("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:createUser("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:createUser("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< J314User > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PostMapping("/securitylogin.updateUser")
	@Timed

	@Transactional
	
	public ResultExt< J314User> updateUser(HttpServletRequest request,HttpServletResponse response, @RequestBody J314UserPoj user)
	{
		
		String params=UtilParams.paramsToString("J314UserPoj",user);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_SECURITYLOGIN_updateUser");
		ctx.put(Contexto.URL_SOLICITADA,"/securitylogin.updateUser");
		Result< J314User> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:updateUser("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_SECURITYLOGIN_updateUser"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_SECURITYLOGIN_updateUser","/securitylogin.updateUser"));
			}
			else
			{
				params=UtilParams.paramsToString("J314UserPoj",user);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:updateUser("+params+")"+params);

				J314User user_ = J314UserPoj.getModel(user);

				Result< J314User > res_=service.updateUser(user_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:updateUser("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:updateUser("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:updateUser("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< J314User > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PostMapping("/securitylogin.deleteUser")
	@Timed

	@Transactional
	
	public ResultExt< Vacio> deleteUser(HttpServletRequest request,HttpServletResponse response, @RequestBody String login)
	{
		
		String params=UtilParams.paramsToString("String",login);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_SECURITYLOGIN_deleteUser");
		ctx.put(Contexto.URL_SOLICITADA,"/securitylogin.deleteUser");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:deleteUser("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_SECURITYLOGIN_deleteUser"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_SECURITYLOGIN_deleteUser","/securitylogin.deleteUser"));
			}
			else
			{
				params=UtilParams.paramsToString("String",login);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:deleteUser("+params+")"+params);

				String login_ = login;

				Result< Vacio > res_=service.deleteUser(login_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:deleteUser("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:deleteUser("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:deleteUser("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PostMapping("/securitylogin.changePass/{login}/{passOld}/{passNew}")
	@Timed

	@Transactional
	
	public ResultExt< Vacio> changePass(HttpServletRequest request,HttpServletResponse response, @PathVariable String login, @PathVariable String passOld, @PathVariable String passNew)
	{
		
		String params=UtilParams.paramsToString("String",login, "String",passOld, "String",passNew);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_SECURITYLOGIN_changePass");
		ctx.put(Contexto.URL_SOLICITADA,"/securitylogin.changePass/{login}/{passOld}/{passNew}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:changePass("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_SECURITYLOGIN_changePass"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_SECURITYLOGIN_changePass","/securitylogin.changePass/{login}/{passOld}/{passNew}"));
			}
			else
			{
				params=UtilParams.paramsToString("String",login, "String",passOld, "String",passNew);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:changePass("+params+")"+params);

				String login_ = login;

				String passOld_ = passOld;

				String passNew_ = passNew;

				Result< Vacio > res_=service.changePass(login_, passOld_, passNew_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:changePass("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:changePass("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:changePass("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PostMapping("/securitylogin.getInfoUser")
	@Timed

	@Transactional
	
	public ResultExt< InfoUser> getInfoUser(HttpServletRequest request,HttpServletResponse response)
	{
		
		String params=UtilParams.paramsToString();

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_SECURITYLOGIN_getInfoUser");
		ctx.put(Contexto.URL_SOLICITADA,"/securitylogin.getInfoUser");
		Result< InfoUser> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:getInfoUser("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_SECURITYLOGIN_getInfoUser"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_SECURITYLOGIN_getInfoUser","/securitylogin.getInfoUser"));
			}
			else
			{
				params=UtilParams.paramsToString();
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:getInfoUser("+params+")"+params);

				Result< InfoUser > res_=service.getInfoUser();
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:getInfoUser("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:getInfoUser("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:getInfoUser("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< InfoUser > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PostMapping("/securitylogin.setInfoUser")
	@Timed

	@Transactional
	
	public ResultExt< InfoUser> setInfoUser(HttpServletRequest request,HttpServletResponse response, @RequestBody InfoUser info)
	{
		
		String params=UtilParams.paramsToString("InfoUser",info);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_SECURITYLOGIN_setInfoUser");
		ctx.put(Contexto.URL_SOLICITADA,"/securitylogin.setInfoUser");
		Result< InfoUser> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:setInfoUser("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_SECURITYLOGIN_setInfoUser"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_SECURITYLOGIN_setInfoUser","/securitylogin.setInfoUser"));
			}
			else
			{
				params=UtilParams.paramsToString("InfoUser",info);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:setInfoUser("+params+")"+params);

				InfoUser info_ = info;

				Result< InfoUser > res_=service.setInfoUser(info_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:setInfoUser("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:setInfoUser("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:setInfoUser("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< InfoUser > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}



	@PostMapping("/securitylogin.resetPass/{login}")
	@Timed

	@Transactional
	
	public ResultExt< Vacio> resetPass(HttpServletRequest request,HttpServletResponse response, @PathVariable String login)
	{
		
		String params=UtilParams.paramsToString("String",login);

		Contexto ctx = Contexto.init();
		ctx.put(Contexto.REQUEST,request);
		ctx.put(Contexto.RESPONSE,response);
		ctx.put(Contexto.CLAVE_SEGURIDAD,"REST_LN_SECURITYLOGIN_resetPass");
		ctx.put(Contexto.URL_SOLICITADA,"/securitylogin.resetPass/{login}");
		Result< Vacio> res=new Result<>();
		if (log.isInfoEnabled()) log.info("Entrada en REST POST:resetPass("+params+")"+params);
		
		try
		{
			if(!verificaPermisos("REST_LN_SECURITYLOGIN_resetPass"))
			{
				res.addError(new ErrorSinPermiso("REST_LN_SECURITYLOGIN_resetPass","/securitylogin.resetPass/{login}"));
			}
			else
			{
				params=UtilParams.paramsToString("String",login);
				if (log.isInfoEnabled()) log.info("Verificado en REST POST:resetPass("+params+")"+params);

				String login_ = login;

				Result< Vacio > res_=service.resetPass(login_);
				res.setInfoEWI(res_);

				res=res_;

			}
			addTiempoSesion();
		}	catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
			if (log.isErrorEnabled()) log.error("Error en REST POST:resetPass("+params+"). Excepcion:"+UtilException.printStackTrace(e));
		}
		if (log.isInfoEnabled()) log.info("Salida de REST POST:resetPass("+params+"). Resultado:"+res.toString());

		if (!res.isOk())
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorGeneral(t));
				if (log.isErrorEnabled()) log.error("Error en REST POST:resetPass("+params+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}

		ResultExt< Vacio > resFin=new ResultExt<>(res,ctx.getAs("ticketStr"));
		Contexto.close();
		return resFin;
	}




//Si hay que anadir metodos se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}

