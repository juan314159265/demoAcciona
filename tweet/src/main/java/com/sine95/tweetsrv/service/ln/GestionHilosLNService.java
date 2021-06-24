
package com.sine95.tweetsrv.service.ln;

import org.sine95.kernel.base.errores.IError;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;


//textual
import org.sine95.kernel.base.task.ITicket;
    
//obj    
import com.sine95.tweetsrv.domain.ParamInCambiaPosTarea;
    
//obj    
import com.sine95.tweetsrv.domain.ParamOutITicket;
    
//obj    
import com.sine95.tweetsrv.domain.ParamOutTasks;
    
//enum

import com.sine95.tweetsrv.enums.ColaHilos;
    
//enum

import com.sine95.tweetsrv.enums.TareasPeriodicas;
    


import org.springframework.beans.factory.annotation.Autowired;
import org.sine95.kernel.base.Result;
import com.sine95.tweetsrv.errores.*;
import com.sine95.tweetsrv.warnings.*;
import com.sine95.tweetsrv.infos.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import org.sine95.kernel.base.*;
import com.sine95.tweetsrv.service.Config;
import com.sine95.tweetsrv.domain.validator.*;
import java.util.*;
import java.util.stream.*;


import org.sine95.kernel.base.task.ServicioTareas;
import org.sine95.kernel.base.task.TaskTest;
import org.sine95.kernel.base.task.ITask;
import java.util.Map.Entry;
import com.sine95.tweetsrv.task.Starter;


/**
* Lógica de negocio para la gestion de los Hilos de tareas asíncronas mediante Threads
*/

@SuppressWarnings("unused")
@Service

public class GestionHilosLNService extends LNService
{
  private final Logger log = LoggerFactory.getLogger(GestionHilosLNService.class);



    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;



    
    Starter starter=null;
    
    private synchronized Starter getStarter()
    {
    	if(starter==null)
    	{
    		starter=appContext.getBean(Starter.class);
    	}
    	return starter;
    }




	/**
	* Precondiciones para el metodo addHilos.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsAddHilos(Result< Vacio > res ,ColaHilos cola,Integer numHilos)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:cola Tipo:ColaHilos 

		if(cola==null)
		{
			res.addError(new ErrorParametroObligatorio("cola"));
		}


		//Param:numHilos Tipo:Integer 

		if(numHilos==null)
		{
			res.addError(new ErrorParametroObligatorio("numHilos"));
		}


		if(!( numHilos >=1 && numHilos <=100) )
		{
			res.addError(new ErrorParametroFueraDeRango("numHilos","[1,100]"));
		}

		
		
		return cache;
	}

	/**
	* Solicita incrementar un número de hilos de ejecución para procesar más tareas en paralelo
	*/




	public Result< Vacio > addHilos(ColaHilos cola,Integer numHilos)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("cola",cola,"numHilos",numHilos);
		if (log.isInfoEnabled()) log.info("Entrando en GestionHilosService.addHilos ("+_params_+")");
		Map<String,Object> cache=preConditionsAddHilos( res , cola, numHilos );
		if(res.isOk())
		{
			try

			{


				
				getST(cola).addNewHilos(numHilos);
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionHilosServiceCRUD.addHilos ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionHilosServiceCRUD.addHilos ("+UtilParams.paramsToString("cola",cola,"numHilos",numHilos)+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo removeHilos.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsRemoveHilos(Result< Vacio > res ,ColaHilos cola,Integer numHilos)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:cola Tipo:ColaHilos 

		if(cola==null)
		{
			res.addError(new ErrorParametroObligatorio("cola"));
		}


		//Param:numHilos Tipo:Integer 

		if(numHilos==null)
		{
			res.addError(new ErrorParametroObligatorio("numHilos"));
		}


		if(!( numHilos >=1 && numHilos <=100) )
		{
			res.addError(new ErrorParametroFueraDeRango("numHilos","[1,100]"));
		}

		
		
		return cache;
	}

	/**
	* Solicita decrementar un número de hilos de ejecución para procesar más tareas en paralelo. No permite menos de 1 activo
	*/




	public Result< Vacio > removeHilos(ColaHilos cola,Integer numHilos)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("cola",cola,"numHilos",numHilos);
		if (log.isInfoEnabled()) log.info("Entrando en GestionHilosService.removeHilos ("+_params_+")");
		Map<String,Object> cache=preConditionsRemoveHilos( res , cola, numHilos );
		if(res.isOk())
		{
			try

			{


				
				getST(cola).removeHilos(numHilos);
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionHilosServiceCRUD.removeHilos ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionHilosServiceCRUD.removeHilos ("+UtilParams.paramsToString("cola",cola,"numHilos",numHilos)+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo getListaTaskEjecutando.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsGetListaTaskEjecutando(Result< List <ParamOutITicket> > res )
	{
		Map<String,Object> cache=new HashMap<>();

		
		
		return cache;
	}

	/**
	* Devuelve la lista de los Tickets de las tareas que se están ejecutando actualmente.
	*/




	public Result< List <ParamOutITicket> > getListaTaskEjecutando()
	{
		Result< List <ParamOutITicket> > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en GestionHilosService.getListaTaskEjecutando ("+_params_+")");
		Map<String,Object> cache=preConditionsGetListaTaskEjecutando( res  );
		if(res.isOk())
		{
			try

			{


				
				@SuppressWarnings("rawtypes")
				Map<ColaHilos, List<ITicket>> mTickets= ServicioTareas.getMapExecutingTickets();
				List<ParamOutITicket> lst = toOut(mTickets);
				res.setData(lst);
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionHilosServiceCRUD.getListaTaskEjecutando ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionHilosServiceCRUD.getListaTaskEjecutando ("+UtilParams.paramsToString()+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo getListaTaskEnCola.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsGetListaTaskEnCola(Result< List <ParamOutITicket> > res )
	{
		Map<String,Object> cache=new HashMap<>();

		
		
		return cache;
	}

	/**
	* Devuelve la lista de los Tickets de las tareas que se están pendientes de ejecución.
	*/




	public Result< List <ParamOutITicket> > getListaTaskEnCola()
	{
		Result< List <ParamOutITicket> > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en GestionHilosService.getListaTaskEnCola ("+_params_+")");
		Map<String,Object> cache=preConditionsGetListaTaskEnCola( res  );
		if(res.isOk())
		{
			try

			{


				
				@SuppressWarnings("rawtypes")
				Map<ColaHilos, List<ITicket>> mTickets= ServicioTareas.getMapTicketsInQueue();
				List<ParamOutITicket> cola = toOut(mTickets);
				res.setData(cola);
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionHilosServiceCRUD.getListaTaskEnCola ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionHilosServiceCRUD.getListaTaskEnCola ("+UtilParams.paramsToString()+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo cancelaTarea.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsCancelaTarea(Result< Vacio > res ,ColaHilos cola,String id)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:cola Tipo:ColaHilos 

		if(cola==null)
		{
			res.addError(new ErrorParametroObligatorio("cola"));
		}


		//Param:id Tipo:String 

		if(id==null)
		{
			res.addError(new ErrorParametroObligatorio("id"));
		}


		
		
		return cache;
	}

	/**
	* Cancela la tarea que se le indica con el id. Si está en cola se desencola y si no se solicita su parada.
	*/




	public Result< Vacio > cancelaTarea(ColaHilos cola,String id)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("cola",cola,"id",id);
		if (log.isInfoEnabled()) log.info("Entrando en GestionHilosService.cancelaTarea ("+_params_+")");
		Map<String,Object> cache=preConditionsCancelaTarea( res , cola, id );
		if(res.isOk())
		{
			try

			{


				
				ITicket ticket = getST(cola).getTicketPorId(id);
				if(ticket==null)
				{
					res.addError(new ErrorTareaIdNoExiste(id));
				}
				else {
					ticket.cancel();
				}
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionHilosServiceCRUD.cancelaTarea ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionHilosServiceCRUD.cancelaTarea ("+UtilParams.paramsToString("cola",cola,"id",id)+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo cambiaPosTarea.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsCambiaPosTarea(Result< Vacio > res ,ParamInCambiaPosTarea paramIn)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:paramIn Tipo:ParamInCambiaPosTarea 

		if(paramIn==null)
		{
			res.addError(new ErrorParametroObligatorio("paramIn"));
		}


		if( paramIn !=null )
		{
			ParamInCambiaPosTareaObjValidator val=new ParamInCambiaPosTareaObjValidator(appContext);
			res.addErrores(val.validate(paramIn));
		}

		
		
		return cache;
	}

	/**
	* Cambiar la pos (posición en la cola de espera hasta la ejecución) de la tarea seleccionada.
	*/




	public Result< Vacio > cambiaPosTarea(ParamInCambiaPosTarea paramIn)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("paramIn",paramIn);
		if (log.isInfoEnabled()) log.info("Entrando en GestionHilosService.cambiaPosTarea ("+_params_+")");
		Map<String,Object> cache=preConditionsCambiaPosTarea( res , paramIn );
		if(res.isOk())
		{
			try

			{


				
				ITicket ticket = getST(paramIn.getCola()).getTicketPorId(paramIn.getId());
				if(ticket==null)
				{
					res.addError(new ErrorTareaIdNoExiste(paramIn.getId()));
				}
				else {
					ticket.setPos(paramIn.getPos());
				}
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionHilosServiceCRUD.cambiaPosTarea ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionHilosServiceCRUD.cambiaPosTarea ("+UtilParams.paramsToString("paramIn",paramIn)+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo encolaTareaTest.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsEncolaTareaTest(Result< Vacio > res ,ColaHilos cola)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:cola Tipo:ColaHilos 

		if(cola==null)
		{
			res.addError(new ErrorParametroObligatorio("cola"));
		}


		
		
		return cache;
	}

	/**
	* Añade una tarea de Tipo Test (de prueba) para poder hacer pruebas diectamente, no tiene apenas coste (salvo el hilo, porque tiene una espera de un segundo).
	*/




	public Result< Vacio > encolaTareaTest(ColaHilos cola)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("cola",cola);
		if (log.isInfoEnabled()) log.info("Entrando en GestionHilosService.encolaTareaTest ("+_params_+")");
		Map<String,Object> cache=preConditionsEncolaTareaTest( res , cola );
		if(res.isOk())
		{
			try

			{


				
				ITask<String> test=new TaskTest("Test");
				ServicioTareas st = getST(cola);
				st.addJob(test);
				log.debug("Numero de tareas ejecutandose:"+st.getExecutingTickets().size());
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionHilosServiceCRUD.encolaTareaTest ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionHilosServiceCRUD.encolaTareaTest ("+UtilParams.paramsToString("cola",cola)+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo getNumHilos.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsGetNumHilos(Result< Integer > res ,ColaHilos cola)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:cola Tipo:ColaHilos 

		if(cola==null)
		{
			res.addError(new ErrorParametroObligatorio("cola"));
		}


		
		
		return cache;
	}

	/**
	* Devuelve el número de hilos activos en el momento.
	*/




	public Result< Integer > getNumHilos(ColaHilos cola)
	{
		Result< Integer > res=new Result<>();
		String _params_=UtilParams.paramsToString("cola",cola);
		if (log.isInfoEnabled()) log.info("Entrando en GestionHilosService.getNumHilos ("+_params_+")");
		Map<String,Object> cache=preConditionsGetNumHilos( res , cola );
		if(res.isOk())
		{
			try

			{


				
				int numHilosActivos = getST(cola).getNumHilosActivos();
				res.setData(numHilosActivos);
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionHilosServiceCRUD.getNumHilos ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionHilosServiceCRUD.getNumHilos ("+UtilParams.paramsToString("cola",cola)+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo getInfoTasks.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsGetInfoTasks(Result< List <ParamOutTasks> > res )
	{
		Map<String,Object> cache=new HashMap<>();

		
		
		return cache;
	}

	/**
	* Devuelve la lista de task periodicas que tenemos definidas.
	*/




	public Result< List <ParamOutTasks> > getInfoTasks()
	{
		Result< List <ParamOutTasks> > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en GestionHilosService.getInfoTasks ("+_params_+")");
		Map<String,Object> cache=preConditionsGetInfoTasks( res  );
		if(res.isOk())
		{
			try

			{


				
				res.setData(getStarter().getInfo());
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionHilosServiceCRUD.getInfoTasks ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionHilosServiceCRUD.getInfoTasks ("+UtilParams.paramsToString()+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo execTasks.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsExecTasks(Result< Vacio > res ,TareasPeriodicas tarea)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:tarea Tipo:TareasPeriodicas 

		if(tarea==null)
		{
			res.addError(new ErrorParametroObligatorio("tarea"));
		}


		
		
		return cache;
	}

	/**
	* Ejecuta la tarea indicada.
	*/




	public Result< Vacio > execTasks(TareasPeriodicas tarea)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("tarea",tarea);
		if (log.isInfoEnabled()) log.info("Entrando en GestionHilosService.execTasks ("+_params_+")");
		Map<String,Object> cache=preConditionsExecTasks( res , tarea );
		if(res.isOk())
		{
			try

			{


				
				getStarter().exec(tarea);
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionHilosServiceCRUD.execTasks ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionHilosServiceCRUD.execTasks ("+UtilParams.paramsToString("tarea",tarea)+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo activaTask.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsActivaTask(Result< Vacio > res ,TareasPeriodicas tarea)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:tarea Tipo:TareasPeriodicas 

		if(tarea==null)
		{
			res.addError(new ErrorParametroObligatorio("tarea"));
		}


		
		
		return cache;
	}

	/**
	* Activa para su ejecución la tarea indicada
	*/




	public Result< Vacio > activaTask(TareasPeriodicas tarea)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("tarea",tarea);
		if (log.isInfoEnabled()) log.info("Entrando en GestionHilosService.activaTask ("+_params_+")");
		Map<String,Object> cache=preConditionsActivaTask( res , tarea );
		if(res.isOk())
		{
			try

			{


				
				res=getStarter().activa(tarea);
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionHilosServiceCRUD.activaTask ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionHilosServiceCRUD.activaTask ("+UtilParams.paramsToString("tarea",tarea)+"). Result:"+res.toString());


		return res;
	}



	/**
	* Precondiciones para el metodo desactivaTask.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsDesactivaTask(Result< Vacio > res ,TareasPeriodicas tarea)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:tarea Tipo:TareasPeriodicas 

		if(tarea==null)
		{
			res.addError(new ErrorParametroObligatorio("tarea"));
		}


		
		
		return cache;
	}

	/**
	* Desactiva para su ejecución la tarea indicada
	*/




	public Result< Vacio > desactivaTask(TareasPeriodicas tarea)
	{
		Result< Vacio > res=new Result<>();
		String _params_=UtilParams.paramsToString("tarea",tarea);
		if (log.isInfoEnabled()) log.info("Entrando en GestionHilosService.desactivaTask ("+_params_+")");
		Map<String,Object> cache=preConditionsDesactivaTask( res , tarea );
		if(res.isOk())
		{
			try

			{


				
				res=getStarter().desactiva(tarea);
				

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en GestionHilosServiceCRUD.desactivaTask ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de GestionHilosServiceCRUD.desactivaTask ("+UtilParams.paramsToString("tarea",tarea)+"). Result:"+res.toString());


		return res;
	}



	private ServicioTareas getST(ColaHilos cola) {
		return ServicioTareas.getInstance(cola);
	}
	@SuppressWarnings("rawtypes")
	private List<ParamOutITicket> toOut(ColaHilos cola,List<ITicket> tickets) {
		List<ParamOutITicket> lst=new ArrayList<>();
		
		for(ITicket ticket:tickets)
		{
			ParamOutITicket out=new ParamOutITicket();
			out.setCola(cola);
			out.setId(ticket.getId());
			out.setInfo(ticket.getInfo());
			out.setPos(ticket.getPos());
			out.setStatus(ticket.getStatus().toString());
			lst.add(out);
		}
		return lst;
	}
	@SuppressWarnings("rawtypes")
	private List<ParamOutITicket> toOut(Map<ColaHilos, List<ITicket>> mTickets) {
		
		List<ParamOutITicket> res=new ArrayList<>();
		for(Entry<ColaHilos, List<ITicket>> entry:mTickets.entrySet())
		{
			res.addAll(toOut(entry.getKey(),entry.getValue()));
		}
		return res;
	}


/*


*/
}

