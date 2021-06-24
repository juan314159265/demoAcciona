
package com.sine95.tweetsrv.service.ln.impl.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.sine95.kernel.base.Result;
import org.sine95.kernel.base.cache.AutoFind;

import com.sine95.tweetsrv.domain.J314User;
import com.sine95.tweetsrv.domain.J314UserPoj;
import com.sine95.tweetsrv.service.crud.J314UserServiceCRUD;


import com.sine95.tweetsrv.warnings.WarningCacheClaveNoEncontrada;

import org.springframework.context.ApplicationContext;

public class UserFromIdAutoFind implements AutoFind< J314User > {
	
	private ApplicationContext appContext;
	private com.sine95.tweetsrv.service.crud.J314UserServiceCRUD service;
	private EntityManager entityManager;

	public UserFromIdAutoFind(ApplicationContext appContext)
	{
		this.appContext = appContext;
		service=this.appContext.getBean(com.sine95.tweetsrv.service.crud.J314UserServiceCRUD.class);
		entityManager=this.appContext.getBean(EntityManager.class);
		
	}
    @Override
	public Result< J314User > find(Object clave) {
		Result< J314User > res=new Result< J314User >();

		J314User example=new J314User();

		example.setId(Long.parseLong(clave.toString(),10));	

		Result<List< J314User >> listByExample = service.listByExample(example);
		if(listByExample.isOk() && listByExample.getData().size()==1)
		{
			J314User data = listByExample.getData().get(0);
			data=J314UserPoj.getModel(new J314UserPoj(data));
			
			res.setData(data);
		}
		else {
			res.addWarning(new WarningCacheClaveNoEncontrada(clave));
		}

		return res;
	}

	@Override
	public Result<Map<Object, J314User >> init() {

        Result<Map<Object, J314User >> res=new Result<Map<Object, J314User >>();
		Map<Object, J314User > map = new HashMap<Object, J314User >();
		
		
		Result<List< J314User >> findAll = service.findAll();
		if(findAll.isOk())
		{
			for(J314User datum:findAll.getData())
			{
				datum=J314UserPoj.getModel(new J314UserPoj(datum));
				map.put(datum.getId(), datum);
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
