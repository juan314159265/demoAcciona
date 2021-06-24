
package com.sine95.tweetsrv.errores;

import org.sine95.kernel.base.errores.*;

import java.util.*;


public class ConversorErroresRest {
   public static List<IError> convierte(List<RestError> errores)
    {
        List<IError> res=new ArrayList<>();

        for(RestError error:errores)
        {
          IError err=null;

          if("SERVER_GEN_001".equals(error.getCode()))
          {
              err=new ErrorGeneral((String)error.getParams().get("excepcion"));
          }

          if("SERVER_GEN_002".equals(error.getCode()))
          {
              err=new ErrorParamIncorrecto((String)error.getParams().get("nombre"),(String)error.getParams().get("razon"));
          }

          if("SERVER_GEN_003".equals(error.getCode()))
          {
              err=new ErrorParamObligatorio((String)error.getParams().get("nombre"));
          }

          if("SERVER_GEN_004".equals(error.getCode()))
          {
              err=new ErrorEnumeradoNoExistente((String)error.getParams().get("tipoEnumerado"),(String)error.getParams().get("valor"));
          }

          if("CLAVE_DUPLICADA".equals(error.getCode()))
          {
              err=new ErrorClaveDuplicada((String)error.getParams().get("clase"),(String)error.getParams().get("clave"));
          }

          if("SERVER_SESION_001".equals(error.getCode()))
          {
              err=new ErrorSinPermiso((String)error.getParams().get("clave"),(String)error.getParams().get("ruta"));
          }

          if("SERVER_CRUD_001".equals(error.getCode()))
          {
              err=new ErrorIdUpdateNoEncontrado((String)error.getParams().get("objeto"));
          }

          if("SERVER_CRUD_002_0".equals(error.getCode()))
          {
              err=new ErrorIdNoEncontrado((String)error.getParams().get("clase"),(String)error.getParams().get("id"));
          }

          if("SERVER_CRUD_002_1".equals(error.getCode()))
          {
              err=new ErrorIdComplejoNoEncontrado((String)error.getParams().get("clase"),(String)error.getParams().get("id"));
          }

          if("SERVER_CRUD_003".equals(error.getCode()))
          {
              err=new ErrorRelacionSinElementos((String)error.getParams().get("relacion"),(String)error.getParams().get("entidad"));
          }

          if("VAL_OBLIG".equals(error.getCode()))
          {
              err=new ErrorCampoObligatorio((String)error.getParams().get("clase"),(String)error.getParams().get("campo"));
          }

          if("VAL_CADENA_TAM_MAX".equals(error.getCode()))
          {
              err=new ErrorLongitudCampoCadena((String)error.getParams().get("clase"),(String)error.getParams().get("campo"),(String)error.getParams().get("longitud"));
          }

          if("VAL_ENTERO_MIN".equals(error.getCode()))
          {
              err=new ErrorEnteroMin((String)error.getParams().get("clase"),(String)error.getParams().get("campo"),(String)error.getParams().get("valor"));
          }

          if("VAL_ENTERO_MAX".equals(error.getCode()))
          {
              err=new ErrorEnteroMax((String)error.getParams().get("clase"),(String)error.getParams().get("campo"),(String)error.getParams().get("valor"));
          }

          if("VAL_DECIMAL_PRECISION".equals(error.getCode()))
          {
              err=new ErrorDecimalPrecision((String)error.getParams().get("clase"),(String)error.getParams().get("campo"),(String)error.getParams().get("precision"));
          }

          if("VAL_DECIMAL_ESCALA".equals(error.getCode()))
          {
              err=new ErrorDecimalEscala((String)error.getParams().get("clase"),(String)error.getParams().get("campo"),(String)error.getParams().get("escala"));
          }

          if("VAL_FORMATO".equals(error.getCode()))
          {
              err=new ErrorFormato((String)error.getParams().get("clase"),(String)error.getParams().get("campo"),(String)error.getParams().get("valor"));
          }

          if("LOGIN_NOT_VALID".equals(error.getCode()))
          {
              err=new ErrorLoginErroneo((String)error.getParams().get("login"));
          }

          if("EMAIL_001".equals(error.getCode()))
          {
              err=new ErrorEnvioCorreo((String)error.getParams().get("tipo"),(String)error.getParams().get("motivo"));
          }

          if("TASK_001".equals(error.getCode()))
          {
              err=new ErrorTareaCancelada();
          }

          if("TASK_002".equals(error.getCode()))
          {
              err=new ErrorTareaIdNoExiste((String)error.getParams().get("id"));
          }

          if("SM_TRANSITION_FORBIDDEN".equals(error.getCode()))
          {
              err=new ErrorTransicionProhibida((String)error.getParams().get("StateMachine"),(String)error.getParams().get("origin"),(String)error.getParams().get("destiny"));
          }

          if("SM_TRANSITION_FORBIDDEN_LN".equals(error.getCode()))
          {
              err=new ErrorTransicionProhibidaPorLN((String)error.getParams().get("StateMachine"),(String)error.getParams().get("origin"),(String)error.getParams().get("destiny"),(String)error.getParams().get("razon"));
          }

          if("JSON_CMP_NOT_EQUAL".equals(error.getCode()))
          {
              err=new ErrorDatumDistinto((String)error.getParams().get("clave"),(String)error.getParams().get("obj1"),(String)error.getParams().get("obj2"));
          }

          if("PARAM_RANGO".equals(error.getCode()))
          {
              err=new ErrorParametroFueraDeRango((String)error.getParams().get("parametro"),(String)error.getParams().get("rango"));
          }

          if("PARAM_OBLIG".equals(error.getCode()))
          {
              err=new ErrorParametroObligatorio((String)error.getParams().get("parametro"));
          }

          if("TASK_001".equals(error.getCode()))
          {
              err=new ErrorTareaCancelada();
          }

          if("SERVER_TX_001".equals(error.getCode()))
          {
              err=new ErrorTransaccionNoDisponible();
          }

          if("EMAIL_001".equals(error.getCode()))
          {
              err=new ErrorEnvioCorreo((String)error.getParams().get("tipo"),(String)error.getParams().get("motivo"));
          }



          if(err!=null)
          {
            res.add(err);
          }
        }
        return res;
    }
}
