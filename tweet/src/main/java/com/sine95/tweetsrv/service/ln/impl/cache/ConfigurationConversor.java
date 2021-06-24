
package com.sine95.tweetsrv.service.ln.impl.cache;

import org.sine95.kernel.base.cache.ConversorCache;


import com.sine95.tweetsrv.domain.Configuration;



import org.sine95.kernel.util.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;


public class ConfigurationConversor implements ConversorCache< Configuration > {

	@Override
	public Object convertFromObjToCacheData(Configuration datum) {
		Object res=null;
		
		try {
			res=JSON.stringify(datum);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			res=null;
		}
        
		return res;
	}

	@Override
	public Configuration convertCacheDataToObj(Object datum) {
		Configuration res=null;
		
		try {
			res=JSON.parse((String)datum, Configuration.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res=null;
		}
        
		return res;
	}

}

