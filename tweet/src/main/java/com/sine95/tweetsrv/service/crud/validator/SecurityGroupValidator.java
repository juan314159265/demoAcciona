
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
import com.sine95.tweetsrv.service.crud.SecurityGroupServiceCRUD;



@SuppressWarnings("unused")
public class SecurityGroupValidator implements IValidator< SecurityGroup >  {

protected List<ISingleValidator> validadoresUpdate=new ArrayList<ISingleValidator>();
	protected List<ISingleValidator> validadoresInsert=new ArrayList<ISingleValidator>();
	protected Map<String,List<ISingleValidator>> validadoresInsertPorCampo=new HashMap<String, List<ISingleValidator>>();
	protected Map<String,List<ISingleValidator>> validadoresUpdatePorCampo=new HashMap<String, List<ISingleValidator>>();
	
	protected SecurityGroupServiceCRUD servicio = null;

	public SecurityGroupValidator(SecurityGroupServiceCRUD servicio) {
		super();

		genValidadoresDefectoCampoId();

		genValidadoresDefectoCampoAllowedgroup();

		genValidadoresDefectoCampoIdentifier();

		this.servicio = servicio;

		
		
	}
	

		private void genValidadoresDefectoCampoId()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("SecurityGroup","id");
		
			lstUpdate.add(obligatorio);
			//lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("id", lstUpdate);
			validadoresInsertPorCampo.put("id", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoAllowedgroup()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("SecurityGroup","allowedgroup");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("allowedgroup", lstUpdate);
			validadoresInsertPorCampo.put("allowedgroup", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoIdentifier()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("SecurityGroup","identifier");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("identifier", lstUpdate);
			validadoresInsertPorCampo.put("identifier", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}


@Override
	public List<IError> validateInsert(SecurityGroup obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateInsertDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	@Override
	public List<IError> validateUpdate(SecurityGroup obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateUpdateDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	

	@Override
	public List<IError> validateDelete(SecurityGroup obj) {
		List<IError> res=new ArrayList<IError>();
		
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}
	
	private List<IError> validateUpdateDefecto(SecurityGroup obj) {
		List<IError> res=new ArrayList<IError>();
		for(ISingleValidator valid: validadoresUpdate)
		{
			res.addAll(valid.validate(obj));
		}
		return res;
	}
	private List<IError> validateInsertDefecto(SecurityGroup obj) {
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
