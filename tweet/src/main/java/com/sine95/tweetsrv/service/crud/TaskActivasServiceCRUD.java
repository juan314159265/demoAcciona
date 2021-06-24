
package com.sine95.tweetsrv.service.crud;

import java.util.*;
import java.util.stream.Collectors;

import com.sine95.tweetsrv.service.crud.validator.*;

import org.sine95.kernel.util.*;
import org.sine95.kernel.base.repository.RepositoryBase;
import org.sine95.kernel.base.service.ServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.sine95.tweetsrv.domain.*;
//import com.sine95.tweetsrv.repository.*;
//import com.sine95.tweetsrv.service.crud.*;
import com.sine95.tweetsrv.domain.*;
import com.sine95.tweetsrv.errores.*;
import org.sine95.kernel.base.Result;
import com.sine95.tweetsrv.repository.TaskActivasRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sine95.tweetsrv.service.Config;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.context.ApplicationContext;
import javax.persistence.EntityManager;
//import com.sine95.tweetsrv.domain.*; // for static metamodels







@Service
//@Transactional
@SuppressWarnings("unused")
public class TaskActivasServiceCRUD extends ServiceCRUD< TaskActivas ,Long > {

	private final Logger log = LoggerFactory.getLogger(TaskActivasServiceCRUD.class);



	@Autowired
    protected EntityManager entityManager;

	@Autowired
    protected ApplicationContext appContext;

	

	
	@Autowired
	private TaskActivasRepository repository;
	

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public TaskActivasRepository  getRepositoryPublic(){
		return repository;
	}

	public TaskActivasServiceCRUD() {
		super();
		addValidator(new TaskActivasValidator(this));


		
		
	}

	@Override
	public String getCRUDName()
	{
		return "TaskActivas";
	}	

	@Override
	public Result<List< TaskActivas >> listByExample(TaskActivas example) {

		Result<List< TaskActivas >> res=new Result<>();
		try {
			Example< TaskActivas > examp=Example.of(example);
			res.setData(repository.findAll(examp));

		}catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}
	
	public Result<Vacio> delete(Long id) {
		Result<Vacio> res=new Result<>();
		if (id==null) {
			res.addError(new ErrorCampoObligatorio("TaskActivas","id"));
			return res;
		}
		// Levantamos la TaskActivas
		Result< TaskActivas > rI = findWithResult(id);
		if (!rI.isOk()) return res.copyStatus(rI);
		TaskActivas i = rI.getData();
		// Eliminamos la TaskActivas
		try {
			res.copyStatus(delete(i));
		} catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	public Result<Page< TaskActivas >> listByExample(TaskActivas example, Pageable page) {

		Result<Page< TaskActivas >> res=new Result<>();
		try {
			Example< TaskActivas > examp=Example.of(example);
			res.setData(repository.findAll(examp,page));

		}catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	protected RepositoryBase< TaskActivas , Long > getRepository()
	{
		return repository;
	}

	/**
	 * Busca una instancia de la entidad por su id
	 * Si el id es nulo lanza una IllegalArgumentException
	 * Si no encuentra la instancia devuelve un null 
	 * @param id Identificador de la instancia
	 * @return La instancia de la entidad o null si no la encuentra
	 */
	protected TaskActivas findWithNull(Long id) throws IllegalArgumentException
	{
		Optional< TaskActivas > optional = repository.findById(id);
		if (!optional.isPresent()) return null;
		return optional.get();
	}

	/**
	 * Busca una instancia de la entidad por su id y lo devuelve en un Result<...>
	 * Si el id es nulo, devuelve un ErrorCampoObligatorio
	 * Si no encuentra la instancia, devuelve un ErrorIdNoEncontrado 
	 * @param id Identificador de la instancia
	 * @return Siempre devuelve un result, con la instancia de la entidad si la encuentra encontrada o null en caso contrario
	 */
	public Result< TaskActivas > findWithResult(Long id)
	{
		Result< TaskActivas > res = new Result<>();
		TaskActivas o = null;
		try {
			o = findWithNull(id);
		} catch (IllegalArgumentException iae) {
			res.addError(new ErrorParamObligatorio("id"));
		} catch (Exception e) {
			res.addError(new ErrorGeneral(e));
		}
		if (o==null) res.addError(new ErrorIdNoEncontrado("TaskActivas",id));
	
		res.setData(o);
		return res;
	}

	@Override
	protected Result< TaskActivas > findWithResultFromObject(TaskActivas obj)
	{

		return findWithResult(obj.getId());
	}
	
	



	@Override
	protected Result< Vacio > copyFieldsUpdate(TaskActivas src, TaskActivas dest)
	{
    	dest.tarea(src.getTarea());
    	dest.activa(src.getActiva());

		Result< Vacio > res = new Result<>();
		res.setData(new Vacio());
		return res;
	}

    /**
     * Return a {@link List} of {@link TaskActivas } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    public Result< List< TaskActivas >> listByCriteria(TaskActivasCrit criteria) {
				Result<List< TaskActivas >> res=new Result<>();
				try {
					if (log.isInfoEnabled()) log.info("find by criteria : {}", criteria);
	        final Specification< TaskActivas > specification = createSpecification(criteria);
					res.setData(repository.findAll(specification));
				}catch(Exception e)
				{
					res.addError(new ErrorGeneral(e));
				}
				return res;
    }

    /**
     * Return a {@link Page} of {@link TaskActivas } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    public  Result< Page< TaskActivas >> listByCriteriaPaged(TaskActivasCritPaged criteria) {
			Result<Page< TaskActivas >> res=new Result<>();
			try {
				TaskActivasCrit crit = criteria.getCrit();
				Pageable pag = criteria.getPag();

				
				
				
        		if (log.isInfoEnabled()) log.info("find by criteria : {}, page: {}", crit, pag);
        		final Specification< TaskActivas > specification = createSpecification(crit);
        		res.setData(repository.findAll(specification, pag));
			}catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
			}
			return res;
    }
/*
	@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
	@StaticMetamodel(TaskActivas.class)
	public abstract class TaskActivas_ {
		
		public static volatile SingularAttribute< TaskActivas , Long > id;
		
		public static volatile SingularAttribute< TaskActivas , null > tarea;
		
		public static volatile SingularAttribute< TaskActivas , null > activa;
		

	}*/
    /**
     * Function to convert TaskActivasCriteria to a {@link Specification}
     */
    private Specification< TaskActivas > createSpecification(TaskActivasCrit criteria) {
        Specification< TaskActivas > specification = Specification.where(null);
        if (criteria != null) {

            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), TaskActivas_.id));
            }


            if (criteria.getTarea() != null) {
                specification = specification.and(buildSpecification(criteria.getTarea(), TaskActivas_.tarea));
            }


            if (criteria.getActiva() != null) {
                specification = specification.and(buildSpecification(criteria.getActiva(), TaskActivas_.activa));
            }


        }
        return specification;
    }

// Metodos para gestionar las relaciones


	//@Override
	public void preInsert(TaskActivas data) {
		
		
	}

	//@Override
	public void preUpdate(TaskActivas data,TaskActivas userData,Result< TaskActivas > res) {
		
			
	}

	//@Override
	public void preDelete(TaskActivas data) {
		
		
	}

	@Override
	public void postInsert(TaskActivas data) {
		
		
	}

	@Override
	public void postUpdate(TaskActivas data) {
		
			
	}

	@Override
	public void postDelete(TaskActivas data) {
		
		
	}

// LN DE CRUD

// FIN DE LN DE CRUD

	@Autowired
	EntityManager em;
	public Result<Page< TaskActivas >> listByExampleExt(TaskActivasExt obj/*, Pageable page*/)
	{
		Result<Page< TaskActivas >> res= new Result<>();
		String from=" FROM  TaskActivas AS obj ";
		String head=new String("SELECT obj "+from);
		Map<String,Object> params=new HashMap<>();
		//where
		String where;
		StringBuilder sbWhere=new StringBuilder("");


		if(obj.getId()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ0",obj.getId());
			sbWhere.append(" obj.id = :OBJ0 ");
		}
		if(obj.getId_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ1",obj.getId_IN());
			sbWhere.append(" obj.id IN :OBJ1 ");
		}
		if(obj.getId_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ2",obj.getId_NOTIN());
			sbWhere.append(" obj.id NOT IN :OBJ2 ");
		}

		if(obj.getId_DISTINCT()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ3",obj.getId_DISTINCT());
			sbWhere.append(" obj.id <> :OBJ3 ");
		}
	
		if(obj.getId_GREATERTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ4",obj.getId_GREATERTHAN());
			sbWhere.append(" obj.id > :OBJ4 ");
		}
	
		if(obj.getId_GREATEROREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ5",obj.getId_GREATEROREQUALTHAN());
			sbWhere.append(" obj.id >= :OBJ5 ");
		}
	
		if(obj.getId_LESSTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ6",obj.getId_LESSTHAN());
			sbWhere.append(" obj.id < :OBJ6 ");
		}
	
		if(obj.getId_LESSOREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ7",obj.getId_LESSOREQUALTHAN());
			sbWhere.append(" obj.id <= :OBJ7 ");
		}

		if(obj.getTarea()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ8",obj.getTarea());
			sbWhere.append(" obj.tarea = :OBJ8 ");
		}
		if(obj.getTarea_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ9",obj.getTarea_IN());
			sbWhere.append(" obj.tarea IN :OBJ9 ");
		}
		if(obj.getTarea_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ10",obj.getTarea_NOTIN());
			sbWhere.append(" obj.tarea NOT IN :OBJ10 ");
		}

		if(obj.getActiva()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ11",obj.getActiva());
			sbWhere.append(" obj.activa = :OBJ11 ");
		}
		if(obj.getActiva_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ12",obj.getActiva_IN());
			sbWhere.append(" obj.activa IN :OBJ12 ");
		}
		if(obj.getActiva_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ13",obj.getActiva_NOTIN());
			sbWhere.append(" obj.activa NOT IN :OBJ13 ");
		}

		if(sbWhere.length()>0){
			 where=" WHERE "+sbWhere.toString();
		}
		else where="";
		//orderby
		String orderby;
		StringBuilder sbOrderby=new StringBuilder("");
		if(obj.getOrderBy()!=null)
		{
			for(String orden:obj.getOrderBy())
			{
				if(sbOrderby.length()>0) sbOrderby.append(",");
				if(orden.contains(":"))
				{
					String [] partes=orden.split(":");
					sbOrderby.append(partes[0]);
					if("A".equalsIgnoreCase(partes[1])
						|| "ASC".equalsIgnoreCase(partes[1])
					)
					{
						sbOrderby.append("ASC");
					}
					else{
						sbOrderby.append("DESC");
					}
				}
				else {
					sbOrderby.append(orden).append(" ASC");
				}
			}
		}

		if(sbOrderby.length()>0) orderby=" ORDER BY "+sbOrderby.toString();
		else orderby="";
		
		String sQuery = head+where+orderby;
		Query query = em.createQuery(sQuery,TaskActivas.class);
//		Query queryNUM = em.createQuery("Select count(obj) "+from+where);
		if(params.size()>0)
		{
			for(String key:params.keySet())
			{
				query.setParameter(key, params.get(key));
//				queryNUM.setParameter(key, params.get(key));
			}
		}
		try {
//			int num=(int) queryNUM.getSingleResult();
			@SuppressWarnings("unchecked")
			List< TaskActivas > lista=(List< TaskActivas >)query.getResultList();
			int num = lista.size();
	
			Page< TaskActivas > page=new org.sine95.kernel.base.PageBase< TaskActivas >(num,obj.getMaxElemsPerPage(),obj.getPage(),lista);
			res.setData(page);
		}catch(Throwable t)
		{
			res.addError(new ErrorGeneral(t));
			if (log.isErrorEnabled()) log.error("Error por Excepcion. Excepcion:"+UtilException.printStackTrace(t));
		}
		return res;
	}




/*


*/
}
