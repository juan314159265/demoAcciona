
package com.sine95.tweetsrv.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.sine95.tweetsrv.enums.AreasCache;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class StartAppConfiguration {


    private Boolean resetCache;

    private String cachesToReset;

    private String executeInit;

    private String modeTest;


    private AreasCache []lstAreasCacheReset;

  public  StartAppConfiguration (

    @Value("${StartApp.resetCache}") Boolean resetCache 

    ,@Value("${StartApp.cachesToReset}") String cachesToReset 

    ,@Value("${StartApp.executeInit}") String executeInit 

    ,@Value("${StartApp.modeTest}") String modeTest 

  )
  {

    this.resetCache=resetCache;

    this.cachesToReset=cachesToReset;

    this.executeInit=executeInit;

    this.modeTest=modeTest;


    
    
    String [] partes=cachesToReset.split(",");
    List<AreasCache> lst=new ArrayList<>();
    for(String strArea:partes)
    {
    	lst.add(AreasCache.valueOf(strArea));
    }
    lstAreasCacheReset=new AreasCache[lst.size()];
    lstAreasCacheReset=lst.toArray(lstAreasCacheReset);
    


  }


    public Boolean getResetCache()
    {
      return this.resetCache;
    }

    public String getCachesToReset()
    {
      return this.cachesToReset;
    }

    public String getExecuteInit()
    {
      return this.executeInit;
    }

    public String getModeTest()
    {
      return this.modeTest;
    }



	public AreasCache[] getLstAreasCacheReset() {
		return lstAreasCacheReset;
	}
    


}
