
package com.sine95.tweetsrv.service.crud.validator;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.errores.IError;
import org.sine95.kernel.base.service.IValidator;
import org.sine95.kernel.validator.ISingleValidator;
import org.sine95.kernel.validator.impl.*;

import com.sine95.tweetsrv.domain.*;
import com.sine95.tweetsrv.errores.*;
import com.sine95.tweetsrv.service.crud.J314UserAuthorityServiceCRUD;



@SuppressWarnings("unused")
public class J314UserAuthorityValidator implements IValidator< J314UserAuthority >  {

protected List<ISingleValidator> validadoresUpdate=new ArrayList<ISingleValidator>();
	protected List<ISingleValidator> validadoresInsert=new ArrayList<ISingleValidator>();
	protected Map<String,List<ISingleValidator>> validadoresInsertPorCampo=new HashMap<String, List<ISingleValidator>>();
	protected Map<String,List<ISingleValidator>> validadoresUpdatePorCampo=new HashMap<String, List<ISingleValidator>>();
	
	protected J314UserAuthorityServiceCRUD servicio = null;

	public J314UserAuthorityValidator(J314UserAuthorityServiceCRUD servicio) {
		super();

		this.servicio = servicio;

		
		
	}
	


@Override
	public List<IError> validateInsert(J314UserAuthority obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateInsertDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	@Override
	public List<IError> validateUpdate(J314UserAuthority obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateUpdateDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	

	@Override
	public List<IError> validateDelete(J314UserAuthority obj) {
		List<IError> res=new ArrayList<IError>();
		
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}
	
	private List<IError> validateUpdateDefecto(J314UserAuthority obj) {
		List<IError> res=new ArrayList<IError>();
		for(ISingleValidator valid: validadoresUpdate)
		{
			res.addAll(valid.validate(obj));
		}
		return res;
	}
	private List<IError> validateInsertDefecto(J314UserAuthority obj) {
		List<IError> res=new ArrayList<IError>();
		for(ISingleValidator valid: validadoresInsert)
		{
			res.addAll(valid.validate(obj));
		}
		return res;
	}





/*


			


			


			


*/
}
