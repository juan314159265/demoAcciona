package com.sine95.tweetsrv.service.ln.impl.cache;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.cache.AutoFind;
import org.springframework.context.ApplicationContext;

import com.sine95.tweetsrv.service.crud.SecurityGroupServiceCRUD;

public class SecurityAutoFind implements AutoFind<Set<String>> {
	
	private ApplicationContext appContext;
	private SecurityGroupServiceCRUD seguridad;

	public SecurityAutoFind(ApplicationContext appContext)
	{
		this.appContext = appContext;
		this.seguridad=this.appContext.getBean(SecurityGroupServiceCRUD.class);
		
	}

	/** 
	 * Atención este metodo no debería llegar a ser llamado, por si acaso ocurrieselo implemento con el init
	 */
	@Override
	public Result<Set<String>> find(Object clave) {
		Result<Set<String>> res=new Result<Set<String>>();
		
		Result<Map<Object, Set<String>>> init = this.init();
		if(init.isOk())
		{
			res.setData(init.getData().get(clave));
		}
		else {
			res.setInfoEWI(init);
		}
		
		return res;
	}

	@Override
	public Result<Map<Object, Set<String>>> init() {
		Result<Map<Object, Set<String>>> res=new Result<Map<Object,Set<String>>>();
		Result<Map<String,Set<String>>> findAllRestAuthorized = seguridad.findAllRestAuthorized();
		if(findAllRestAuthorized.isOk())
		{
			Map<String, Set<String>> data = findAllRestAuthorized.getData();
			for(Entry<String, Set<String>> datum:data.entrySet())
			{
				data.put(datum.getKey(),datum.getValue());
			}
			res.setData((Map<Object, Set<String>>)(Object)data);
		}
		else {
			res.setInfoEWI(findAllRestAuthorized);
		}
		
		return res;
	}

}
