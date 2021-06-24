
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
public class ParamOutTasksObjValidator implements IValidatorObj< ParamOutTasks >  {

	protected ApplicationContext appContext;

	protected List<ISingleValidator> validadores=new ArrayList<ISingleValidator>();
	
	public ParamOutTasksObjValidator(ApplicationContext _appCont) {
		super();
		this.appContext=_appCont;

		//Es una enum:genValidadoresDefectoCampoTarea();

		//Es una enum:genValidadoresDefectoCampoActivo();

		//campo
		genValidadoresDefectoCampoPeriodicidad();

		//campo
		genValidadoresDefectoCampoInfo();

		
		
	}
	

		private void genValidadoresDefectoCampoTarea()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			



			ISingleValidator obligatorio=new ObligatorioValidator("ParamOutTasks","tarea");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoActivo()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			



			ISingleValidator obligatorio=new ObligatorioValidator("ParamOutTasks","activo");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoPeriodicidad()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ParamOutTasks","periodicidad", 80);
			

			lstValidator.add(cadena);




		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoInfo()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ParamOutTasks","info", 10000);
			

			lstValidator.add(cadena);




		


			
			
			
			
			validadores.addAll(lstValidator);
		}



	@Override
	public List<IError> validate(ParamOutTasks obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	
	
	private List<IError> validateDefecto(ParamOutTasks obj) {
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

