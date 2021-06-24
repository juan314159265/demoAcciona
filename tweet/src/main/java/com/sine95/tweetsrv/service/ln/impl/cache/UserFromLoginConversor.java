

package com.sine95.tweetsrv.service.ln.impl.cache;

import org.sine95.kernel.base.cache.ConversorCache;


import com.sine95.tweetsrv.domain.J314User;



import org.sine95.kernel.util.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import com.sine95.tweetsrv.domain.J314User;


public class UserFromLoginConversor implements ConversorCache< J314User > {

	@Override
	public Object convertFromObjToCacheData(J314User datum) {
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
	public J314User convertCacheDataToObj(Object datum) {
		J314User res=null;
		
		try {
			res=JSON.parse((String)datum, J314User.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res=null;
		}
        
		return res;
	}

}


