

package com.sine95.tweetsrv.service.ln.impl.cache;

import org.sine95.kernel.base.cache.ConversorCache;




import java.util.*;
import org.sine95.kernel.util.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sine95.tweetsrv.domain.Configuration;

import java.io.IOException;


public class SecurityConversor implements ConversorCache< Set<String> > {

	@Override
	public Object convertFromObjToCacheData(Set<String> datum) {
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
	public Set<String> convertCacheDataToObj(Object datum) {
		Set<String> res=null;
		
		try {
			res=JSON.parse((String)datum, Set.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res=null;
		}
        
		return res;
	}

}


