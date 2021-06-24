
package com.sine95.tweetsrv.service.ln.impl.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.cache.AutoFind;

import com.sine95.tweetsrv.domain.Configuration;
import com.sine95.tweetsrv.domain.ConfigurationPoj;
import com.sine95.tweetsrv.service.crud.ConfigurationServiceCRUD;


import com.sine95.tweetsrv.warnings.WarningCacheClaveNoEncontrada;

import org.springframework.context.ApplicationContext;

public class ConfigurationAutoFind implements AutoFind< Configuration > {
	
	private ApplicationContext appContext;
	private com.sine95.tweetsrv.service.crud.ConfigurationServiceCRUD service;
	private EntityManager entityManager;

	public ConfigurationAutoFind(ApplicationContext appContext)
	{
		this.appContext = appContext;
		service=this.appContext.getBean(com.sine95.tweetsrv.service.crud.ConfigurationServiceCRUD.class);
		entityManager=this.appContext.getBean(EntityManager.class);
		
	}
    @Override
	public Result< Configuration > find(Object clave) {
		Result< Configuration > res=new Result< Configuration >();

		Configuration example=new Configuration();
		
		example.setKeyid((String)clave);

		Result<List< Configuration >> listByExample = service.listByExample(example);
		if(listByExample.isOk() && listByExample.getData().size()==1)
		{
			Configuration data = listByExample.getData().get(0);
			data=ConfigurationPoj.getModel(new ConfigurationPoj(data));
			
			res.setData(data);
		}
		else {
			res.addWarning(new WarningCacheClaveNoEncontrada(clave));
		}

		return res;
	}

	@Override
	public Result<Map<Object, Configuration >> init() {

        Result<Map<Object, Configuration >> res=new Result<Map<Object, Configuration >>();
		Map<Object, Configuration > map = new HashMap<Object, Configuration >();
		
		
		Result<List< Configuration >> findAll = service.findAll();
		if(findAll.isOk())
		{
			for(Configuration datum:findAll.getData())
			{
				datum=ConfigurationPoj.getModel(new ConfigurationPoj(datum));
				map.put(datum.getKeyid(), datum);
			}
			res.setData(map);
		}
		else
		{
			res.setInfoEWI(findAll);
		}
		
	

       return res;
    }
}
