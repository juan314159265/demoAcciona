
package com.sine95.tweetsrv.service.ln;

import org.sine95.kernel.base.errores.IError;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
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
    


import org.springframework.beans.factory.annotation.Autowired;
import org.sine95.kernel.base.Result;
import com.sine95.tweetsrv.errores.*;
import com.sine95.tweetsrv.warnings.*;
import com.sine95.tweetsrv.infos.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import org.sine95.kernel.base.*;
import com.sine95.tweetsrv.service.Config;
import com.sine95.tweetsrv.domain.validator.*;
import java.util.*;
import java.util.stream.*;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import com.sine95.tweetsrv.security.AuthoritiesConstants;
import org.sine95.kernel.base.Contexto;
import org.sine95.kernel.base.JWTTicket;
import javax.servlet.http.HttpServletResponse;
import com.sine95.tweetsrv.service.MailService;
import com.sine95.tweetsrv.service.ln.GenerateFromTemplateLNService;


/**
* Logica de negocio para el login y asociados
*/

@SuppressWarnings("unused")
@Service

public class SecurityLoginLNService extends LNService
{
  private final Logger log = LoggerFactory.getLogger(SecurityLoginLNService.class);

  @Autowired
  MailService mailService;
  
  @Autowired
  GenerateFromTemplateLNService generateFromTemplateLNService;


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







	/**
	* Precondiciones para el metodo login.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsLogin(Result< ResLogin > res ,String userlogin,String password)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:userlogin Tipo:String 

		if(userlogin==null)
		{
			res.addError(new ErrorParametroObligatorio("userlogin"));
		}


		//Param:password Tipo:String 

		if(password==null)
		{
			res.addError(new ErrorParametroObligatorio("password"));
		}


		
		
		return cache;
	}

	/**
	* Realiza la función de login.Si no es valido devuelve un error ErrorLoginErroneo
	*/




	@Transactional
	public Result< ResLogin > login(String userlogin,String password)
	{
		Result< ResLogin > res=new Result<>();
		String _params_=UtilParams.paramsToString("userlogin",userlogin,"password",password);
		if (log.isInfoEnabled()) log.info("Entrando en SecurityLoginService.login ("+_params_+")");
		Map<String,Object> cache=preConditionsLogin( res , userlogin, password );
		if(res.isOk())
		{
			try

			{


				
				Contexto ctx=Contexto.get();
				
				J314UserExt obj=new J314UserExt();
				obj.setLogin(userlogin);
				Result<Page<J314User>> lista = j314UserService.listByExampleExt(obj);
				if(lista.isOk()==false || lista.getData().getNumberOfElements()!=1)
				{
					res.addError(new ErrorLoginErroneo(userlogin));
				}
				else {
					
					Date fechaActual=new Date();
					long tiempoSesion=2*60*60;
					
					String passCode=UtilPass.getPassHasheado(password);
					J314User user = lista.getData().getContent().get(0);
					if(user.getTiempoSesion()!=null)
					{
						tiempoSesion=user.getTiempoSesion();
					}
					System.out.println("Pass BBDD"+user.getPassword_hash());
					
					System.out.println("passCode:"+passCode);
					
					
					if(user.getPassword_hash().equals(passCode) && user.getActivated()==SiNo.S)
					{
						//si lo es crear el ticket y meterlo en el response
						JWTTicket ticket=new JWTTicket();
						ticket.setLogin(user.getLogin());
						ticket.setIdSesion(UUID.randomUUID().toString());
						ticket.setNombre(user.getFirst_name());
						ticket.setApe1(user.getLast_name());
						ticket.setApe2("");
						ticket.setDateLogin(fechaActual);
						ticket.setDateSessionExpires(new Date(fechaActual.getTime()+(1000*tiempoSesion)));
						ticket.setEmail(user.getEmail());
						ticket.setImageUrl(user.getImage_url());
						ticket.setLangKey(user.getLang_key());
						ticket.setAddTiempoEnSesion(tiempoSesion*1000);
						
						
						
						
						
						List<J314UserAuthority> authorities = user.getAuthorities();
						
						List<String> listaGrupos = new ArrayList<String>();
						for(J314UserAuthority auth:authorities)
						{
							listaGrupos.add(auth.getAuthority().getName());
						}
						
						/*List<String> listaGrupos=new ArrayList<String>();
						listaGrupos.add("PUBLIC");
						listaGrupos.add("USER,");
						listaGrupos.add("ADMIN");
						listaGrupos.add("SWAGGER");
						listaGrupos.add("MOVIL");
						String [] arrGrupos=null;
						*/
						if(!listaGrupos.contains("PUBLIC"))
						{
							listaGrupos.add("PUBLIC");
						}
						
						ticket.setGrupos(listaGrupos);
						
						ctx.put("ticket",ticket);
						//Result<Set<String>> todosPermisos = securityGroupService.findAllAutorized(listaGrupos);
						
						//if(todosPermisos.isOk())
						//{
							//String[] permisos=new String[todosPermisos.getData().size()];
							//permisos=todosPermisos.getData().toArray(permisos);
							List<String> permisos=new ArrayList<String>();
							//permisos.addAll(todosPermisos.getData());
							ResLogin data = new ResLogin();
							data.email(user.getEmail())
							.first_name(user.getFirst_name())
							.last_name(user.getLast_name())
							.image_url(user.getImage_url())
							.lang_key(user.getLang_key())
							.login(user.getLogin())
							//.permisos((permisos))
							.grupos((listaGrupos))
							;
							if(user.getReset_date()!=null && fechaActual.getTime()>user.getReset_date().getTime())
							{
								data.setChange_pass(SiNo.S);
							}
							else {
								data.setChange_pass(SiNo.N);
							}
							
							res.setData(data);
							
							HttpServletResponse response=ctx.getAs("response");
							
							response.setHeader("Autorization", UtilJWT.getTicket(ticket));
							
						/*}
						else
						{
							res.addError(new ErrorLoginErroneo(userlogin));
						}*/
						
						ctx.put(Contexto.SKIP_RECALCULATE_SESSION_EXPIRES,true);
					}
					else {
						res.addError(new ErrorSinPermiso(ctx.getAsString(Contexto.CLAVE_SEGURIDAD),ctx.getAsString(Contexto.URL_SOLICITADA)));
					}
					
				}
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en SecurityLoginServiceCRUD.login ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de SecurityLoginServiceCRUD.login ("+UtilParams.paramsToString("userlogin",userlogin,"password",password)+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de SecurityLoginServiceCRUD.login ("+UtilParams.paramsToString("userlogin",userlogin,"password",password)+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo logout.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsLogout(Result< Vacio > res )
	{
		Map<String,Object> cache=new HashMap<>();

		
		
		return cache;
	}

	/**
	* Devuelve los permisos para el grupo PUBLIC es decir todo lo accesible sin login
	*/




	@Transactional
	public Result< Vacio > logout()
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en SecurityLoginService.logout ("+_params_+")");
		Map<String,Object> cache=preConditionsLogout( res  );
		if(res.isOk())
		{
			try

			{


				
				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en SecurityLoginServiceCRUD.logout ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de SecurityLoginServiceCRUD.logout ("+UtilParams.paramsToString()+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de SecurityLoginServiceCRUD.logout ("+UtilParams.paramsToString()+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo createUser.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsCreateUser(Result< J314User > res ,J314User user)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:user Tipo:J314User 

		if(user==null)
		{
			res.addError(new ErrorParametroObligatorio("user"));
		}


		
		J314UserExt userExt=new J314UserExt();
		userExt.setLogin(user.getLogin());
		Result<Page<J314User>> listUser = j314UserService.listByExampleExt(userExt);
		if(listUser.isOk())
		{
			if(listUser.getData().getNumberOfElements()>0)
			{
				res.addError(new ErrorLoginErroneo(user.getLogin()));
			}
		}
		else
		{
			res.setInfoEWI(listUser);
		}
		
		return cache;
	}

	/**
	* Realiza la creacion del usuario. Error login duplicado
	*/




	@Transactional
	public Result< J314User > createUser(J314User user)
	{
		Result< J314User > res=new Result<>();
		String _params_=UtilParams.paramsToString("user",user);
		if (log.isInfoEnabled()) log.info("Entrando en SecurityLoginService.createUser ("+_params_+")");
		Map<String,Object> cache=preConditionsCreateUser( res , user );
		if(res.isOk())
		{
			try

			{


				
				res=j314UserService.insert(user);
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en SecurityLoginServiceCRUD.createUser ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de SecurityLoginServiceCRUD.createUser ("+UtilParams.paramsToString("user",user)+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de SecurityLoginServiceCRUD.createUser ("+UtilParams.paramsToString("user",user)+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo updateUser.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsUpdateUser(Result< J314User > res ,J314User user)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:user Tipo:J314User 

		if(user==null)
		{
			res.addError(new ErrorParametroObligatorio("user"));
		}


		
		
		return cache;
	}

	/**
	* Realiza la modificación del usuario.
	*/




	@Transactional
	public Result< J314User > updateUser(J314User user)
	{
		Result< J314User > res=new Result<>();
		String _params_=UtilParams.paramsToString("user",user);
		if (log.isInfoEnabled()) log.info("Entrando en SecurityLoginService.updateUser ("+_params_+")");
		Map<String,Object> cache=preConditionsUpdateUser( res , user );
		if(res.isOk())
		{
			try

			{


				
				res=j314UserService.update(user);
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en SecurityLoginServiceCRUD.updateUser ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de SecurityLoginServiceCRUD.updateUser ("+UtilParams.paramsToString("user",user)+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de SecurityLoginServiceCRUD.updateUser ("+UtilParams.paramsToString("user",user)+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo deleteUser.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsDeleteUser(Result< Vacio > res ,String login)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:login Tipo:String 

		if(login==null)
		{
			res.addError(new ErrorParametroObligatorio("login"));
		}


		
		buscarUserDesdeLogin(res,cache);
		
		return cache;
	}

	/**
	* Realiza el borrado del usuario.
	*/




	@Transactional
	public Result< Vacio > deleteUser(String login)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("login",login);
		if (log.isInfoEnabled()) log.info("Entrando en SecurityLoginService.deleteUser ("+_params_+")");
		Map<String,Object> cache=preConditionsDeleteUser( res , login );
		if(res.isOk())
		{
			try

			{


				
				J314User user=(J314User) cache.get("user");
				j314UserService.delete(user);
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en SecurityLoginServiceCRUD.deleteUser ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de SecurityLoginServiceCRUD.deleteUser ("+UtilParams.paramsToString("login",login)+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de SecurityLoginServiceCRUD.deleteUser ("+UtilParams.paramsToString("login",login)+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo changePass.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsChangePass(Result< Vacio > res ,String login,String passOld,String passNew)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:login Tipo:String 

		if(login==null)
		{
			res.addError(new ErrorParametroObligatorio("login"));
		}


		//Param:passOld Tipo:String 

		if(passOld==null)
		{
			res.addError(new ErrorParametroObligatorio("passOld"));
		}


		//Param:passNew Tipo:String 

		if(passNew==null)
		{
			res.addError(new ErrorParametroObligatorio("passNew"));
		}


		
		buscarUserDesdeLogin(res, cache);
		
		return cache;
	}

	/**
	* Cambia la password, si el passOld no valida contra la hash da un error ErrorSinPermiso.
	*/




	@Transactional
	public Result< Vacio > changePass(String login,String passOld,String passNew)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("login",login,"passOld",passOld,"passNew",passNew);
		if (log.isInfoEnabled()) log.info("Entrando en SecurityLoginService.changePass ("+_params_+")");
		Map<String,Object> cache=preConditionsChangePass( res , login, passOld, passNew );
		if(res.isOk())
		{
			try

			{


				
				Contexto ctx=Contexto.get();
				J314User user=(J314User) cache.get("user");
				if(login.equals(ctx.getAsString(Contexto.LOGIN)))
				{
					if(UtilPass.getPassHasheado(passOld).equals(user.getPassword_hash()))
					{
						
						String passHasheado = UtilPass.getPassHasheado(passNew);
						log.debug("Nuevo pass cambiado:"+passHasheado);
						user.setPassword_hash(passNew);
						user.setReset_date(null);
						Result<J314User> update = j314UserService.update(user);
						if(!update.isOk())
						{
							res.setInfoEWI(update);
						}
					}
					else
					{
						res.addError(new ErrorSinPermiso(ctx.getAsString(Contexto.CLAVE_SEGURIDAD), ctx.getAsString(Contexto.URL_SOLICITADA)));
					}
				}
				else {
					res.addError(new ErrorSinPermiso(ctx.getAsString(Contexto.CLAVE_SEGURIDAD), ctx.getAsString(Contexto.URL_SOLICITADA)));
				}
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en SecurityLoginServiceCRUD.changePass ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de SecurityLoginServiceCRUD.changePass ("+UtilParams.paramsToString("login",login,"passOld",passOld,"passNew",passNew)+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de SecurityLoginServiceCRUD.changePass ("+UtilParams.paramsToString("login",login,"passOld",passOld,"passNew",passNew)+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo getInfoUser.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsGetInfoUser(Result< InfoUser > res )
	{
		Map<String,Object> cache=new HashMap<>();

		
		buscarUserDesdeLogin(res,cache);
		
		return cache;
	}

	/**
	* Obtenemos los datos que el usuario puede cambiar por sí mismo
	*/




	@Transactional
	public Result< InfoUser > getInfoUser()
	{
		Result< InfoUser > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en SecurityLoginService.getInfoUser ("+_params_+")");
		Map<String,Object> cache=preConditionsGetInfoUser( res  );
		if(res.isOk())
		{
			try

			{


				
				J314User user=(J314User) cache.get("user");
				InfoUser info = toInfoUser(user);
				res.setData(info);
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en SecurityLoginServiceCRUD.getInfoUser ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de SecurityLoginServiceCRUD.getInfoUser ("+UtilParams.paramsToString()+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de SecurityLoginServiceCRUD.getInfoUser ("+UtilParams.paramsToString()+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo setInfoUser.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsSetInfoUser(Result< InfoUser > res ,InfoUser info)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:info Tipo:InfoUser 

		if(info==null)
		{
			res.addError(new ErrorParametroObligatorio("info"));
		}


		if( info !=null )
		{
			InfoUserObjValidator val=new InfoUserObjValidator(appContext);
			res.addErrores(val.validate(info));
		}

		
		buscarUserDesdeLogin(res, cache);
		
		return cache;
	}

	/**
	* Obtenemos los datos que el usuario puede cambiar por sí mismo
	*/




	@Transactional
	public Result< InfoUser > setInfoUser(InfoUser info)
	{
		Result< InfoUser > res=new Result<>();
		String _params_=UtilParams.paramsToString("info",info);
		if (log.isInfoEnabled()) log.info("Entrando en SecurityLoginService.setInfoUser ("+_params_+")");
		Map<String,Object> cache=preConditionsSetInfoUser( res , info );
		if(res.isOk())
		{
			try

			{


				
				J314User user=(J314User) cache.get("user");
				user.setEmail(info.getEmail());
				user.setFirst_name(info.getFirst_name());
				user.setImage_url( info.getImage_url());
				user.setLang_key( info.getLang_key());
				user.setLast_name( info.getLast_name());
				
				Result<J314User> resAux = j314UserService.update(user);
				if(resAux.isOk()) {
					res.setData(toInfoUser(resAux.getData()));
				}
				else
				{
					res.setInfoEWI(resAux);
				}
					
				
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en SecurityLoginServiceCRUD.setInfoUser ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de SecurityLoginServiceCRUD.setInfoUser ("+UtilParams.paramsToString("info",info)+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de SecurityLoginServiceCRUD.setInfoUser ("+UtilParams.paramsToString("info",info)+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo resetPass.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsResetPass(Result< Vacio > res ,String login)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:login Tipo:String 

		if(login==null)
		{
			res.addError(new ErrorParametroObligatorio("login"));
		}


		
		buscarUserDesdeLogin(res,cache,login);
		
		return cache;
	}

	/**
	* Resetea el pass y envia correo
	*/




	@Transactional
	public Result< Vacio > resetPass(String login)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("login",login);
		if (log.isInfoEnabled()) log.info("Entrando en SecurityLoginService.resetPass ("+_params_+")");
		Map<String,Object> cache=preConditionsResetPass( res , login );
		if(res.isOk())
		{
			try

			{


				
				J314User user=(J314User) cache.get("user");
				
				String newPass = UUID.randomUUID().toString();
				user.setPassword_hash(newPass);
				//Esto para que cambie el password cuando entre
				user.setReset_date(new Date());
				Result<J314User> resAux = j314UserService.update(user);
				if(!resAux.isOk())
				{
					res.setInfoEWI(resAux);
				}
				else
				{
					//Envio correo
					Map<String,Object> map=new HashMap<String, Object>();
					map.put("password",newPass);
					Result<String> resTemplate = generateFromTemplateLNService.GenerateFromWithJSON("correos/common/resetPassword_"+user.getLang_key()+".html", JSON.stringify(map));
					if(resTemplate.isOk())
					{
						Result<Vacio> resMail = mailService.sendEmail(
							"resetPassword",
							user.getEmail(), 
							"Reset", 
							resTemplate.getData(), 
							false, 
							true
							);
						if(!resMail.isOk())
						{
							res.setInfoEWI(resMail);
						}
					}
					else
					{
						res.setInfoEWI(resTemplate);
					}
				}
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en SecurityLoginServiceCRUD.resetPass ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de SecurityLoginServiceCRUD.resetPass ("+UtilParams.paramsToString("login",login)+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de SecurityLoginServiceCRUD.resetPass ("+UtilParams.paramsToString("login",login)+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



//Si hay que annadir metodos se incluyen aqui, se recomienda utilizar este tipo de comentario para no interferir con el DELETE
	
	private InfoUser toInfoUser(J314User user) {
		InfoUser info=new InfoUser();
		info.setEmail(user.getEmail());
		info.setFirst_name(user.getFirst_name());
		info.setImage_url(user.getImage_url());
		info.setLang_key(user.getLang_key());
		info.setLast_name(user.getLast_name());
		info.setLogin(user.getLogin());
		return info;
	}
	private void buscarUserDesdeLogin(IResult<?> res, Map<String, Object> cache) {
		Contexto ctx=Contexto.get();
		
		buscarUserDesdeLogin(res,cache,ctx.getAsString(Contexto.LOGIN));
	}
	private void buscarUserDesdeLogin(IResult<?> res, Map<String, Object> cache,String login) {
		if(res.isOk())
		{
			
			Result<J314User> resAux = j314UserService.getUserFromLogin(login);
			if(resAux.isOk())
			{
				cache.put("user", resAux.getData());
			}
		}
	}



/*


	


		





				List<String> listaGrupos=new ArrayList<String>();
				listaGrupos.add(AuthoritiesConstants.PUBLIC);
				Result<Set<String>> todosPermisos = securityGroupService.findAllAutorized(listaGrupos);
				List<String> dataRes=new ArrayList<String>();
				dataRes.addAll(todosPermisos.getData());
				res.setData(dataRes);
				res.copyStatus(todosPermisos);
				


*/
}

