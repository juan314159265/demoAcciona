
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
import com.sine95.tweetsrv.service.crud.TweetsServiceCRUD;



@SuppressWarnings("unused")
public class TweetsValidator implements IValidator< Tweets >  {

protected List<ISingleValidator> validadoresUpdate=new ArrayList<ISingleValidator>();
	protected List<ISingleValidator> validadoresInsert=new ArrayList<ISingleValidator>();
	protected Map<String,List<ISingleValidator>> validadoresInsertPorCampo=new HashMap<String, List<ISingleValidator>>();
	protected Map<String,List<ISingleValidator>> validadoresUpdatePorCampo=new HashMap<String, List<ISingleValidator>>();
	
	protected TweetsServiceCRUD servicio = null;

	public TweetsValidator(TweetsServiceCRUD servicio) {
		super();

		genValidadoresDefectoCampoId();

		genValidadoresDefectoCampoUsuario();

		genValidadoresDefectoCampoTexto();

		genValidadoresDefectoCampoLocalizacion();

		genValidadoresDefectoCampoValidacion();

		this.servicio = servicio;

		
		
	}
	

		private void genValidadoresDefectoCampoId()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("Tweets","id");
		
			lstUpdate.add(obligatorio);
			//lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("id", lstUpdate);
			validadoresInsertPorCampo.put("id", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoUsuario()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("Tweets","usuario");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("usuario", lstUpdate);
			validadoresInsertPorCampo.put("usuario", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoTexto()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("Tweets","texto");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("texto", lstUpdate);
			validadoresInsertPorCampo.put("texto", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoLocalizacion()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("Tweets","localizacion");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("localizacion", lstUpdate);
			validadoresInsertPorCampo.put("localizacion", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}

		private void genValidadoresDefectoCampoValidacion()
		{
			List<ISingleValidator> lstUpdate=new ArrayList<ISingleValidator>();
			List<ISingleValidator> lstInsert=new ArrayList<ISingleValidator>();

			ISingleValidator obligatorio=new ObligatorioValidator("Tweets","validacion");
		
			lstUpdate.add(obligatorio);
			lstInsert.add(obligatorio);


			
			
			
			validadoresUpdatePorCampo.put("validacion", lstUpdate);
			validadoresInsertPorCampo.put("validacion", lstInsert);
			validadoresUpdate.addAll(lstUpdate);
			validadoresInsert.addAll(lstInsert);
		}


@Override
	public List<IError> validateInsert(Tweets obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateInsertDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	@Override
	public List<IError> validateUpdate(Tweets obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateUpdateDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	

	@Override
	public List<IError> validateDelete(Tweets obj) {
		List<IError> res=new ArrayList<IError>();
		
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}
	
	private List<IError> validateUpdateDefecto(Tweets obj) {
		List<IError> res=new ArrayList<IError>();
		for(ISingleValidator valid: validadoresUpdate)
		{
			res.addAll(valid.validate(obj));
		}
		return res;
	}
	private List<IError> validateInsertDefecto(Tweets obj) {
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
