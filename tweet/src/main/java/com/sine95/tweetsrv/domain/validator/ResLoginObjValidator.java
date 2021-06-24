
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
public class ResLoginObjValidator implements IValidatorObj< ResLogin >  {

	protected ApplicationContext appContext;

	protected List<ISingleValidator> validadores=new ArrayList<ISingleValidator>();
	
	public ResLoginObjValidator(ApplicationContext _appCont) {
		super();
		this.appContext=_appCont;

		//campo
		genValidadoresDefectoCampoLogin();

		//campo
		genValidadoresDefectoCampoEmail();

		//campo
		genValidadoresDefectoCampoFirst_name();

		//campo
		genValidadoresDefectoCampoLast_name();

		//campo
		genValidadoresDefectoCampoImage_url();

		//campo
		genValidadoresDefectoCampoLang_key();

		//Es una enum:genValidadoresDefectoCampoChange_pass();

		//campo
		genValidadoresDefectoCampoGrupos();

		
		
	}
	

		private void genValidadoresDefectoCampoLogin()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ResLogin","login", 50);
			

			lstValidator.add(cadena);





			ISingleValidator obligatorio=new ObligatorioValidator("ResLogin","login");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoEmail()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ResLogin","email", 254);
			

			lstValidator.add(cadena);




		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoFirst_name()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ResLogin","first_name", 50);
			

			lstValidator.add(cadena);




		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoLast_name()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ResLogin","last_name", 50);
			

			lstValidator.add(cadena);




		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoImage_url()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ResLogin","image_url", 256);
			

			lstValidator.add(cadena);




		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoLang_key()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ResLogin","lang_key", 6);
			

			lstValidator.add(cadena);




		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoChange_pass()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			



			ISingleValidator obligatorio=new ObligatorioValidator("ResLogin","change_pass");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoGrupos()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ResLogin","grupos", 50);
			

			lstValidator.add(cadena);




		


			
			
			
			
			validadores.addAll(lstValidator);
		}



	@Override
	public List<IError> validate(ResLogin obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	
	
	private List<IError> validateDefecto(ResLogin obj) {
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

