package com.sine95.tweetsrv.service.ln;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.sine95.kernel.base.Contexto;
import org.sine95.kernel.base.IResult;
import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.cache.ICache;
import org.sine95.kernel.base.errores.IError;

import com.sine95.tweetsrv.errores.*;



import org.sine95.kernel.util.UtilException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sine95.tweetsrv.errores.ErrorGeneral;

//entity
import com.sine95.tweetsrv.domain.J314User;
import com.sine95.tweetsrv.service.crud.J314UserServiceCRUD;

@SuppressWarnings("unused")
@Service
public class LNService {
	
	@Autowired
	J314UserServiceCRUD j314UserService;
  	
    @Autowired
    protected CacheLNService cacheService;
    
    private ICache<J314User> cacheUsuarioPorId;
    private ICache<J314User> cacheUsuarioPorLogin;
    
    protected ICache<J314User> getCacheUsuarioPorId()
    {
    	ICache<J314User> res=cacheUsuarioPorId;
    	if(res==null)
    	{
    		Result<ICache<J314User>> cache = this.cacheService.getCacheAreaUserFromId();
    		if(cache.isOk())
    		{
    			res=cache.getData();
    			cacheUsuarioPorId=res;
    		}
    	}
		return res;
    }
    protected ICache<J314User> getCacheUsuarioPorLogin()
    {
    	ICache<J314User> res=cacheUsuarioPorLogin;
    	if(res==null)
    	{
    		Result<ICache<J314User>> cache = this.cacheService.getCacheAreaUserFromLogin();
    		if(cache.isOk())
    		{
    			res=cache.getData();
    			cacheUsuarioPorLogin=res;
    		}
    	}
		return res;
    }

    private final Logger log = LoggerFactory.getLogger(LNService.class);
	
	
	protected void preCondicionLogin(IResult<?> res, Map<String, Object> cache) {
		Result<J314User> userLogado = getUserLogado();
		if(!userLogado.isOk())
		{
			res.setInfoEWI(userLogado);
		}
		else
		{
			cache.put("userLogado",userLogado.getData());
		}
	}

	
	protected void postCondicionErrores(IResult<?> res,Set<Class<? extends IError>> erroresValidos,String params)
	{
		//Aqui se puede hacer lo que se quiera, incluyendo quitar errores
		//Hay que ver que hacemos con ello
		List<IError> erroresInvalidos=new ArrayList<IError>();
		
		for(IError error:(List<IError>)res.getErrores())
		{
			Class<? extends IError> clase=error.getClass();
			if(!erroresValidos.contains(clase))
			{
				erroresInvalidos.add(error);
			}
		}
		if(erroresInvalidos.size()>0)
		{
			//Podemos susituir errores por algún error no controlado
			//enviar un correo a un administrador
			//savar un log...
			log.error(params+"=>Errores no válidos:"+erroresInvalidos);
		}
	}
			
	

	protected String getLoginUsuarioLogado()
	{
		
		Contexto ctx=Contexto.get();
		return ctx.getAsString(Contexto.LOGIN);
		
	}

	protected Result<J314User> getUserLogado()
	{
		
		Result<J314User> res=new Result<J314User>();
		Contexto ctx=Contexto.get();
		String login = ctx.getAsString(Contexto.LOGIN);
		
		Result<J314User> resCache = getCacheUsuarioPorLogin().get(login);
		if(!resCache.isOk() || resCache.getWarnings().size()!=0)
		{
			res.copy(j314UserService.getUserFromLoginInContext());
		}
		else {
			res.copy(resCache);
		}
		return res;
	}

	

	protected Result<Long> getIdUsuarioLogado()
	{
		
		Result<Long> res = new Result<>();
		Result<J314User> userLogado = getUserLogado();
		if(userLogado.isOk())
		{
			res.setData(userLogado.getData().getId());
		}
		else {
			res.setInfoEWI(userLogado);
		}
		return res;
	}
	//--------------------------------------------
	//Métodos propios del proyecto apartir de aqui
	//--------------------------------------------
	
	
	protected Result<String> generaUrl(String urlRelativa,String urlBase)
	{
		Result<String> res = new Result<String>();
		if (urlRelativa==null)
		{
			return res.addError(new ErrorParametroObligatorio("urlRelativa"));
		}
		if (urlBase==null)
		{
			return res.addError(new ErrorParametroObligatorio("urlBase"));
		}
		if (urlBase.endsWith("/"))
		{
			if (urlRelativa.startsWith("/")) urlRelativa=urlRelativa.substring(1);
		}
		String s = urlBase+urlRelativa;
		return res.setData(s);
	}
	
}
