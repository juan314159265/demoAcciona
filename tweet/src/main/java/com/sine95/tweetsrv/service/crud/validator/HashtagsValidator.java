
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
import com.sine95.tweetsrv.service.crud.HashtagsServiceCRUD;



@SuppressWarnings("unused")
public class HashtagsValidator implements IValidator< Hashtags >  {

protected List<ISingleValidator> validadoresUpdate=new ArrayList<ISingleValidator>();
	protected List<ISingleValidator> validadoresInsert=new ArrayList<ISingleValidator>();
	protected Map<String,List<ISingleValidator>> validadoresInsertPorCampo=new HashMap<String, List<ISingleValidator>>();
	protected Map<String,List<ISingleValidator>> validadoresUpdatePorCampo=new HashMap<String, List<ISingleValidator>>();
	
	protected HashtagsServiceCRUD servicio = null;

	public HashtagsValidator(HashtagsServiceCRUD servicio) {
		super();

		genValidadoresDefectoCampoId();

		genValidadoresDefectoCampoHashtags();

		genValidadoresDefectoCampoContador();

		this.servicio = servicio;

		
		
	}
	

		private void genValidadoresDefectoCampoId()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("Hashtags","id");
		
			lstUpdate.add(obligatorio);
			//lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("id", lstUpdate);
			validadoresInsertPorCampo.put("id", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoHashtags()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("Hashtags","hashtags");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("hashtags", lstUpdate);
			validadoresInsertPorCampo.put("hashtags", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoContador()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("Hashtags","contador");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("contador", lstUpdate);
			validadoresInsertPorCampo.put("contador", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}


@Override
	public List<IError> validateInsert(Hashtags obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateInsertDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	@Override
	public List<IError> validateUpdate(Hashtags obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateUpdateDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	

	@Override
	public List<IError> validateDelete(Hashtags obj) {
		List<IError> res=new ArrayList<IError>();
		
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}
	
	private List<IError> validateUpdateDefecto(Hashtags obj) {
		List<IError> res=new ArrayList<IError>();
		for(ISingleValidator valid: validadoresUpdate)
		{
			res.addAll(valid.validate(obj));
		}
		return res;
	}
	private List<IError> validateInsertDefecto(Hashtags obj) {
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
