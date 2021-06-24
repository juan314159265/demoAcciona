
package com.sine95.tweetsrv.task;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.sine95.tweetsrv.service.task.*;
import com.sine95.tweetsrv.domain.ParamOutTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.sine95.kernel.base.Result;
import org.springframework.transaction.annotation.Transactional;
import com.sine95.tweetsrv.service.crud.LogTaskServiceCRUD;
import com.sine95.tweetsrv.domain.LogTask;
import org.sine95.kernel.util.UtilString;
import com.sine95.tweetsrv.enums.TareasPeriodicas;
import com.sine95.tweetsrv.enums.SiNo;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.data.domain.Page;
import com.sine95.tweetsrv.domain.TaskActivas;
import com.sine95.tweetsrv.domain.TaskActivasExt;
import com.sine95.tweetsrv.service.crud.TaskActivasServiceCRUD;
import org.sine95.kernel.util.Vacio;



@Component
@SuppressWarnings("unused")
public class Starter {
	private final Logger log = LoggerFactory.getLogger(Starter.class);

    @Autowired
    LogTaskServiceCRUD logTaskService;

    @Autowired
    protected ApplicationContext appContext;

    @Autowired
    TaskActivasServiceCRUD taskActivas;
    
    public Starter()
    {
    	
    }

    @Transactional
    public Result<Boolean> isActiva(TareasPeriodicas task)
    {
    	Result<Boolean> res=new Result<Boolean>();
    	
        TaskActivasExt tae=new TaskActivasExt();
        tae.setTarea(task);
        
        Result<Page<TaskActivas>> find = taskActivas.listByExampleExt(tae);
        if(find.isOk())
        {
        	if(find.getData()!=null)
        	{
        	
        		if(find.getData().getNumberOfElements()!=0)
        		{
	        		List<TaskActivas> content = find.getData().getContent();
	        		if(content.size()==0)
	        		{
	        			res.setData(true);
	        		}
	        		else {
	        			res.setData(content.get(0).getActiva()==SiNo.S);
	        		}
        		}
        		else
        		{
        			res.setData(true);//No hay lista
        		}
        	}
        	else {
        		res.setData(false);
        	}
        		
        }
        else {
        	res.setInfoEWI(find);
        }
        	
       
       return res;
    }

    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public Result<Vacio> activa(TareasPeriodicas task)
    {
        Result<Vacio> res=new Result<>();
        TaskActivasExt tae=new TaskActivasExt();
        tae.setTarea(task);
        
        Result<Page<TaskActivas>> find = taskActivas.listByExampleExt(tae);
        if(find.isOk())
        {
        	if(find.getData()!=null
        		&& find.getData().getNumberOfElements()==1
        	)
        	{
        		List<TaskActivas> content = find.getData().getContent();
        		if(content.size()==1)//Por defecto, si no hay registro es que está activa, así que borro las activas
        		{
        			Result<TaskActivas> delete = taskActivas.delete(content.get(0));
        			if(!delete.isOk())
        			{
        				res.copyStatus(delete);
        			}
        		}
        		
        	}
        	
        		
        }
        else {
        	res.setInfoEWI(find);
        }
        
		return res;
    }

    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public Result<Vacio> activa(TareasPeriodicas task,Boolean value)
    {
        if(value)
        {
        	return activa(task);
        }
        else {
        	return desactiva(task);
        }
    }

    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public Result<Vacio> desactiva(TareasPeriodicas task)
    {
        Result<Vacio> res=new Result<>();
        
        TaskActivasExt tae=new TaskActivasExt();
        tae.setTarea(task);
        
        Result<Page<TaskActivas>> find = taskActivas.listByExampleExt(tae);
        if(find.isOk())
        {
        	if(find.getData()!=null
        		&& !find.getData().hasContent()
        	)
        	{
        		List<TaskActivas> content = find.getData().getContent();
        		if(content.size()==0)//Por defecto, si no hay registro es que está activa, así que borro las activas
        		{
        			TaskActivas ta=new TaskActivas();
        			ta.setTarea(task);
        			ta.setActiva(SiNo.N);
        			Result<TaskActivas> insert = taskActivas.insert(ta);
        			if(!insert.isOk())
        			{
        				res.copyStatus(insert);
        			}
        		}
        		
        	}
        		
        }
        else {
        	res.setInfoEWI(find);
        }
        
		return res;
    }


    public List<ParamOutTasks> getInfo()
    {
        List<ParamOutTasks> res=new ArrayList<>();
        ParamOutTasks pot=null;
        boolean activa=false;
        Result<Boolean> activaAux=null;

        return res;
    }

    public void exec(TareasPeriodicas task)
    {
    	switch(task)
    	{

        }
    }


    @Autowired
    TareaTaskService tareaService;





}