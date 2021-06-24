
package com.sine95.tweetsrv.domain.validator;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.errores.IError;
import org.sine95.kernel.base.service.IValidatorObj;
import org.sine95.kernel.validator.ISingleValidator;
import org.sine95.kernel.validator.impl.*;
import org.springframework.context.ApplicationContext;
import com.sine95.tweetsrv.domain.*;

import com.sine95.tweetsrv.errores.*;
import com.sine95.tweetsrv.warnings.*;
import com.sine95.tweetsrv.infos.*;



@SuppressWarnings("unused")
public class In_GestionTweets_TweetsMasUsadosObjValidator implements IValidatorObj< In_GestionTweets_TweetsMasUsados >  {

	protected ApplicationContext appContext;

	protected List<ISingleValidator> validadores=new ArrayList<ISingleValidator>();
	
	public In_GestionTweets_TweetsMasUsadosObjValidator(ApplicationContext _appCont) {
		super();
		this.appContext=_appCont;

		//campo
		genValidadoresDefectoCampoMaxHashtags();

		
		
	}
	

		private void genValidadoresDefectoCampoMaxHashtags()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			






		


			
			
			
			
			validadores.addAll(lstValidator);
		}



	@Override
	public List<IError> validate(In_GestionTweets_TweetsMasUsados obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	
	
	private List<IError> validateDefecto(In_GestionTweets_TweetsMasUsados obj) {
		List<IError> res=new ArrayList<IError>();
		for(ISingleValidator valid: validadores)
		{
			res.addAll(valid.validate(obj));
		}
		return res;
	}
	





/*


*/
}

