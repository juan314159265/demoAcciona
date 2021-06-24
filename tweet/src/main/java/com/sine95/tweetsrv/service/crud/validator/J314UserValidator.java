
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
import com.sine95.tweetsrv.service.crud.J314UserServiceCRUD;



@SuppressWarnings("unused")
public class J314UserValidator implements IValidator< J314User >  {

protected List<ISingleValidator> validadoresUpdate=new ArrayList<ISingleValidator>();
	protected List<ISingleValidator> validadoresInsert=new ArrayList<ISingleValidator>();
	protected Map<String,List<ISingleValidator>> validadoresInsertPorCampo=new HashMap<String, List<ISingleValidator>>();
	protected Map<String,List<ISingleValidator>> validadoresUpdatePorCampo=new HashMap<String, List<ISingleValidator>>();
	
	protected J314UserServiceCRUD servicio = null;

	public J314UserValidator(J314UserServiceCRUD servicio) {
		super();

		genValidadoresDefectoCampoId();

		genValidadoresDefectoCampoCreated_by();

		genValidadoresDefectoCampoCreated_date();

		genValidadoresDefectoCampoLast_modified_by();

		genValidadoresDefectoCampoLast_modified_date();

		genValidadoresDefectoCampoActivated();

		genValidadoresDefectoCampoActivation_key();

		genValidadoresDefectoCampoLogin();

		genValidadoresDefectoCampoEmail();

		genValidadoresDefectoCampoFirst_name();

		genValidadoresDefectoCampoLast_name();

		genValidadoresDefectoCampoImage_url();

		genValidadoresDefectoCampoLang_key();

		genValidadoresDefectoCampoPassword_hash();

		genValidadoresDefectoCampoReset_date();

		genValidadoresDefectoCampoReset_key();

		genValidadoresDefectoCampoTiempoSesion();

		this.servicio = servicio;

		
		
	}
	

		private void genValidadoresDefectoCampoId()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("J314User","id");
		
			lstUpdate.add(obligatorio);
			//lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("id", lstUpdate);
			validadoresInsertPorCampo.put("id", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoCreated_by()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("J314User","created_by");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("created_by", lstUpdate);
			validadoresInsertPorCampo.put("created_by", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoCreated_date()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("J314User","created_date");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("created_date", lstUpdate);
			validadoresInsertPorCampo.put("created_date", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoLast_modified_by()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();


			
			
			
			validadoresUpdatePorCampo.put("last_modified_by", lstUpdate);
			validadoresInsertPorCampo.put("last_modified_by", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoLast_modified_date()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();


			
			
			
			validadoresUpdatePorCampo.put("last_modified_date", lstUpdate);
			validadoresInsertPorCampo.put("last_modified_date", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoActivated()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("J314User","activated");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("activated", lstUpdate);
			validadoresInsertPorCampo.put("activated", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoActivation_key()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();


			
			
			
			validadoresUpdatePorCampo.put("activation_key", lstUpdate);
			validadoresInsertPorCampo.put("activation_key", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoLogin()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("J314User","login");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("login", lstUpdate);
			validadoresInsertPorCampo.put("login", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoEmail()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();


			
			
			
			validadoresUpdatePorCampo.put("email", lstUpdate);
			validadoresInsertPorCampo.put("email", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoFirst_name()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();


			
			
			
			validadoresUpdatePorCampo.put("first_name", lstUpdate);
			validadoresInsertPorCampo.put("first_name", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoLast_name()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();


			
			
			
			validadoresUpdatePorCampo.put("last_name", lstUpdate);
			validadoresInsertPorCampo.put("last_name", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoImage_url()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();


			
			
			
			validadoresUpdatePorCampo.put("image_url", lstUpdate);
			validadoresInsertPorCampo.put("image_url", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoLang_key()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();


			
			
			
			validadoresUpdatePorCampo.put("lang_key", lstUpdate);
			validadoresInsertPorCampo.put("lang_key", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoPassword_hash()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("J314User","password_hash");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("password_hash", lstUpdate);
			validadoresInsertPorCampo.put("password_hash", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoReset_date()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();


			
			
			
			validadoresUpdatePorCampo.put("reset_date", lstUpdate);
			validadoresInsertPorCampo.put("reset_date", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoReset_key()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();


			
			
			
			validadoresUpdatePorCampo.put("reset_key", lstUpdate);
			validadoresInsertPorCampo.put("reset_key", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoTiempoSesion()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();


			
			
			
			validadoresUpdatePorCampo.put("tiempoSesion", lstUpdate);
			validadoresInsertPorCampo.put("tiempoSesion", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}


@Override
	public List<IError> validateInsert(J314User obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateInsertDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	@Override
	public List<IError> validateUpdate(J314User obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateUpdateDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	

	@Override
	public List<IError> validateDelete(J314User obj) {
		List<IError> res=new ArrayList<IError>();
		
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}
	
	private List<IError> validateUpdateDefecto(J314User obj) {
		List<IError> res=new ArrayList<IError>();
		for(ISingleValidator valid: validadoresUpdate)
		{
			res.addAll(valid.validate(obj));
		}
		return res;
	}
	private List<IError> validateInsertDefecto(J314User obj) {
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
