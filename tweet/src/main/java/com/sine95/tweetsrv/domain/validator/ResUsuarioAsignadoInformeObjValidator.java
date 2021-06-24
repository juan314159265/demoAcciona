
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
public class ResUsuarioAsignadoInformeObjValidator implements IValidatorObj< ResUsuarioAsignadoInforme >  {

	protected ApplicationContext appContext;

	protected List<ISingleValidator> validadores=new ArrayList<ISingleValidator>();
	
	public ResUsuarioAsignadoInformeObjValidator(ApplicationContext _appCont) {
		super();
		this.appContext=_appCont;

		//campo
		genValidadoresDefectoCampoIduser();

		//campo
		genValidadoresDefectoCampoLogin();

		//campo
		genValidadoresDefectoCampoUserfirstname();

		//campo
		genValidadoresDefectoCampoUserlastname();

		//campo
		genValidadoresDefectoCampoId_informe();

		//campo
		genValidadoresDefectoCampoNombreinforme();

		//campo
		genValidadoresDefectoCampoDescripcion();

		//Es una enum:genValidadoresDefectoCampoEdita();

		
		
	}
	

		private void genValidadoresDefectoCampoIduser()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			







			ISingleValidator obligatorio=new ObligatorioValidator("ResUsuarioAsignadoInforme","iduser");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoLogin()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ResUsuarioAsignadoInforme","login", 50);
			

			lstValidator.add(cadena);





			ISingleValidator obligatorio=new ObligatorioValidator("ResUsuarioAsignadoInforme","login");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoUserfirstname()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ResUsuarioAsignadoInforme","userfirstname", 50);
			

			lstValidator.add(cadena);




		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoUserlastname()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ResUsuarioAsignadoInforme","userlastname", 50);
			

			lstValidator.add(cadena);




		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoId_informe()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			







			ISingleValidator obligatorio=new ObligatorioValidator("ResUsuarioAsignadoInforme","id_informe");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoNombreinforme()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ResUsuarioAsignadoInforme","nombreinforme", 200);
			

			lstValidator.add(cadena);





			ISingleValidator obligatorio=new ObligatorioValidator("ResUsuarioAsignadoInforme","nombreinforme");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoDescripcion()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			


            ISingleValidator cadena=new CadenaValidator("ResUsuarioAsignadoInforme","descripcion", 2000);
			

			lstValidator.add(cadena);




		


			
			
			
			
			validadores.addAll(lstValidator);
		}

		private void genValidadoresDefectoCampoEdita()
		{
			List<ISingleValidator> lstValidator=new ArrayList<ISingleValidator>();			



			ISingleValidator obligatorio=new ObligatorioValidator("ResUsuarioAsignadoInforme","edita");
		
			lstValidator.add(obligatorio);
		


			
			
			
			
			validadores.addAll(lstValidator);
		}



	@Override
	public List<IError> validate(ResUsuarioAsignadoInforme obj) {
		List<IError> res=new ArrayList<IError>();
		
		res.addAll(validateDefecto(obj));
		//Realizar las comprobaciones que sean necesarias
		
		return res;
	}

	
	
	private List<IError> validateDefecto(ResUsuarioAsignadoInforme obj) {
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

