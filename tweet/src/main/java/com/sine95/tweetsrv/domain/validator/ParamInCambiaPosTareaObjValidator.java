
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
public class ParamInCambiaPosTareaObjValidator implements IValidatorObj< ParamInCambiaPosTarea >  {

	protected ApplicationContext appContext;

	protected List<ISingleValidator> validadores=new ArrayList<ISingleValidator>();
	
	public ParamInCambiaPosTareaObjValidator(ApplicationContext _appCont) {
		super();
		this.appContext=_appCont;

		//Es una enum:genValidadoresDefectoCampoCola();

		//campo
		genValidadoresDefectoCampoId();

		//campo
		genValidadoresDefectoCampoPos();

		
		
	}
	

		private void genValidadoresDefectoCampoCola()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			



			ISingleValidator obligatorio=new ObligatorioValidator("ParamInCambiaPosTarea","cola");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoId()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ParamInCambiaPosTarea","id", 100);
			

			lstValidator.add(cadena);





			ISingleValidator obligatorio=new ObligatorioValidator("ParamInCambiaPosTarea","id");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoPos()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			







			ISingleValidator obligatorio=new ObligatorioValidator("ParamInCambiaPosTarea","pos");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}



	@Override
	public List<IError> validate(ParamInCambiaPosTarea obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	
	
	private List<IError> validateDefecto(ParamInCambiaPosTarea obj) {
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

