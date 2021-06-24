
package com.sine95.tweetsrv.infos;

import org.sine95.kernel.base.errores.*;

import java.util.*;


public class ConversorInfosRest {
   public static List<IInfo> convierte(List<RestError> errores)
    {
        List<IInfo> res=new ArrayList<>();

        for(RestError error:errores)
        {
          IInfo err=null;

          if("EMAIL_SEND_BIENVENIDA".equals(error.getCode()))
          {
              err=new InfoEnvioCorreoBienvenida();
          }



          if(err!=null)
          {
            res.add(err);
          }
        }
        return res;
    }
}