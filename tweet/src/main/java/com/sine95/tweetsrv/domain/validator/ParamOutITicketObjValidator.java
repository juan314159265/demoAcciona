
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
public class ParamOutITicketObjValidator implements IValidatorObj< ParamOutITicket >  {

	protected ApplicationContext appContext;

	protected List<ISingleValidator> validadores=new ArrayList<ISingleValidator>();
	
	public ParamOutITicketObjValidator(ApplicationContext _appCont) {
		super();
		this.appContext=_appCont;

		//Es una enum:genValidadoresDefectoCampoCola();

		//campo
		genValidadoresDefectoCampoId();

		//campo
		genValidadoresDefectoCampoInfo();

		//campo
		genValidadoresDefectoCampoPos();

		//campo
		genValidadoresDefectoCampoStatus();

		
		
	}
	

		private void genValidadoresDefectoCampoCola()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			



			ISingleValidator obligatorio=new ObligatorioValidator("ParamOutITicket","cola");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoId()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ParamOutITicket","id", 100);
			

			lstValidator.add(cadena);





			ISingleValidator obligatorio=new ObligatorioValidator("ParamOutITicket","id");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoInfo()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ParamOutITicket","info", 10000);
			

			lstValidator.add(cadena);




		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoPos()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			







			ISingleValidator obligatorio=new ObligatorioValidator("ParamOutITicket","pos");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoStatus()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ParamOutITicket","status", 80);
			

			lstValidator.add(cadena);





			ISingleValidator obligatorio=new ObligatorioValidator("ParamOutITicket","status");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}



	@Override
	public List<IError> validate(ParamOutITicket obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	
	
	private List<IError> validateDefecto(ParamOutITicket obj) {
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

