
package com.sine95.tweetsrv.warnings;

import org.sine95.kernel.base.errores.*;

import java.util.*;


public class ConversorWarningsRest {
   public static List<IWarning> convierte(List<RestError> errores)
    {
        List<IWarning> res=new ArrayList<>();

        for(RestError error:errores)
        {
          IWarning err=null;

          if("WAR_EMAIL_001".equals(error.getCode()))
          {
              err=new WarningEnvioCorreo((String)error.getParams().get("tipo"),(String)error.getParams().get("motivo"));
          }

          if("MAIL_NOT_SEND".equals(error.getCode()))
          {
              err=new WarningCorreoNoEnviado((String)error.getParams().get("tipo"));
          }

          if("CACHE_VALOR_NULO".equals(error.getCode()))
          {
              err=new WarningCacheElValorEsNulo((String)error.getParams().get("clave"));
          }

          if("CACHE_CLAVE_NO_ENCONTRADA".equals(error.getCode()))
          {
              err=new WarningCacheClaveNoEncontrada((String)error.getParams().get("clave"));
          }



          if(err!=null)
          {
            res.add(err);
          }
        }
        return res;
    }
}
