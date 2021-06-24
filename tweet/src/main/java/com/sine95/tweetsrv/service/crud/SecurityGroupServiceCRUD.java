
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
import com.sine95.tweetsrv.repository.SecurityGroupRepository;
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

import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;






import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import io.github.jhipster.service.filter.StringFilter;



@Service
//@Transactional
@SuppressWarnings("unused")
public class SecurityGroupServiceCRUD extends ServiceCRUD< SecurityGroup ,Long > {

	private final Logger log = LoggerFactory.getLogger(SecurityGroupServiceCRUD.class);



	@Autowired
    protected EntityManager entityManager;



    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;


	
	@Autowired
	private SecurityGroupRepository repository;
	

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public SecurityGroupRepository  getRepositoryPublic(){
		return repository;
	}

	public SecurityGroupServiceCRUD() {
		super();
		addValidator(new SecurityGroupValidator(this));


		
		
	}

	@Override
	public String getCRUDName()
	{
		return "SecurityGroup";
	}	

	@Override
	public Result<List< SecurityGroup >> listByExample(SecurityGroup example) {

		Result<List< SecurityGroup >> res=new Result<>();
		try {
			Example< SecurityGroup > examp=Example.of(example);
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
			res.addError(new ErrorCampoObligatorio("SecurityGroup","id"));
			return res;
		}
		// Levantamos la SecurityGroup
		Result< SecurityGroup > rI = findWithResult(id);
		if (!rI.isOk()) return res.copyStatus(rI);
		SecurityGroup i = rI.getData();
		// Eliminamos la SecurityGroup
		try {
			res.copyStatus(delete(i));
		} catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	public Result<Page< SecurityGroup >> listByExample(SecurityGroup example, Pageable page) {

		Result<Page< SecurityGroup >> res=new Result<>();
		try {
			Example< SecurityGroup > examp=Example.of(example);
			res.setData(repository.findAll(examp,page));

		}catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	protected RepositoryBase< SecurityGroup , Long > getRepository()
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
	protected SecurityGroup findWithNull(Long id) throws IllegalArgumentException
	{
		Optional< SecurityGroup > optional = repository.findById(id);
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
	public Result< SecurityGroup > findWithResult(Long id)
	{
		Result< SecurityGroup > res = new Result<>();
		SecurityGroup o = null;
		try {
			o = findWithNull(id);
		} catch (IllegalArgumentException iae) {
			res.addError(new ErrorParamObligatorio("id"));
		} catch (Exception e) {
			res.addError(new ErrorGeneral(e));
		}
		if (o==null) res.addError(new ErrorIdNoEncontrado("SecurityGroup",id));
	
		res.setData(o);
		return res;
	}

	@Override
	protected Result< SecurityGroup > findWithResultFromObject(SecurityGroup obj)
	{

		return findWithResult(obj.getId());
	}
	
	



	@Override
	protected Result< Vacio > copyFieldsUpdate(SecurityGroup src, SecurityGroup dest)
	{
    	dest.allowedgroup(src.getAllowedgroup());
    	dest.identifier(src.getIdentifier());

		Result< Vacio > res = new Result<>();
		res.setData(new Vacio());
		return res;
	}

    /**
     * Return a {@link List} of {@link SecurityGroup } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    public Result< List< SecurityGroup >> listByCriteria(SecurityGroupCrit criteria) {
				Result<List< SecurityGroup >> res=new Result<>();
				try {
					if (log.isInfoEnabled()) log.info("find by criteria : {}", criteria);
	        final Specification< SecurityGroup > specification = createSpecification(criteria);
					res.setData(repository.findAll(specification));
				}catch(Exception e)
				{
					res.addError(new ErrorGeneral(e));
				}
				return res;
    }

    /**
     * Return a {@link Page} of {@link SecurityGroup } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    public  Result< Page< SecurityGroup >> listByCriteriaPaged(SecurityGroupCritPaged criteria) {
			Result<Page< SecurityGroup >> res=new Result<>();
			try {
				SecurityGroupCrit crit = criteria.getCrit();
				Pageable pag = criteria.getPag();

				
				
				
        		if (log.isInfoEnabled()) log.info("find by criteria : {}, page: {}", crit, pag);
        		final Specification< SecurityGroup > specification = createSpecification(crit);
        		res.setData(repository.findAll(specification, pag));
			}catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
			}
			return res;
    }
/*
	@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
	@StaticMetamodel(SecurityGroup.class)
	public abstract class SecurityGroup_ {
		
		public static volatile SingularAttribute< SecurityGroup , Long > id;
		
		public static volatile SingularAttribute< SecurityGroup , String > allowedgroup;
		
		public static volatile SingularAttribute< SecurityGroup , String > identifier;
		

	}*/
    /**
     * Function to convert SecurityGroupCriteria to a {@link Specification}
     */
    private Specification< SecurityGroup > createSpecification(SecurityGroupCrit criteria) {
        Specification< SecurityGroup > specification = Specification.where(null);
        if (criteria != null) {

            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), SecurityGroup_.id));
            }


            if (criteria.getAllowedgroup() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAllowedgroup(), SecurityGroup_.allowedgroup));
            }


            if (criteria.getIdentifier() != null) {
                specification = specification.and(buildStringSpecification(criteria.getIdentifier(), SecurityGroup_.identifier));
            }


        }
        return specification;
    }

// Metodos para gestionar las relaciones


	//@Override
	public void preInsert(SecurityGroup data) {
		
		
	}

	//@Override
	public void preUpdate(SecurityGroup data,SecurityGroup userData,Result< SecurityGroup > res) {
		
			
	}

	//@Override
	public void preDelete(SecurityGroup data) {
		
		
	}

	@Override
	public void postInsert(SecurityGroup data) {
		
		
	}

	@Override
	public void postUpdate(SecurityGroup data) {
		
			
	}

	@Override
	public void postDelete(SecurityGroup data) {
		
		
	}

// LN DE CRUD


	/**
	* Precondiciones para el metodo findAllAutorized.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsFindAllAutorized(Result< Set <String> > res ,List<String> authorities)
	{
		Map<String,Object> cache=new HashMap<>();

		//Param:authorities Tipo:String 


		
		
		return cache;
	}

	/**
	* Son las claves que un usuario tiene en función de sus grupos.
	* Este método Devuelve todas las claves de seguridad que tiene el conjunto de grupos pasados por par?metro.
	*/




	@Transactional
	public Result< Set <String> > findAllAutorized(List<String> authorities)
	{
		Result< Set <String> > res=new Result<>();
		String _params_=UtilParams.paramsToString("authorities",authorities);
		if (log.isInfoEnabled()) log.info("Entrando en SecurityGroupService.findAllAutorized ("+_params_+")");
		Map<String,Object> cache=preConditionsFindAllAutorized( res , authorities );
		if(res.isOk())
		{
			try

			{


				
			//Desarrolle entre estas marcas y NO las toque
			//En serio, NO TOCAR las marcas!!!!!
			Set<String> conjunto=new TreeSet<>();

    		List<SecurityGroup> resAux = repository.findAll(new Specification<SecurityGroup>() {


					@Override
					public Predicate toPredicate(Root<SecurityGroup> root, CriteriaQuery<?> query,
							CriteriaBuilder criteriaBuilder) {
						Expression<String> exp=root.get(SecurityGroup_.allowedgroup);
    					query.where(exp.in(authorities));
						return null;
					}
    			});
    		for (SecurityGroup securityGroup : resAux) {
    			if(securityGroup.getIdentifier().startsWith("VISIBLE") || securityGroup.getIdentifier().startsWith("EXECUTABLE"))
    			{
    				conjunto.add(securityGroup.getIdentifier());
    			}
    		}
    		res.setData(conjunto);
			

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en SecurityGroupServiceCRUD.findAllAutorized ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de SecurityGroupServiceCRUD.findAllAutorized ("+UtilParams.paramsToString("authorities",authorities)+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de SecurityGroupServiceCRUD.findAllAutorized ("+UtilParams.paramsToString("authorities",authorities)+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}



	/**
	* Precondiciones para el metodo findAllRestAuthorized.
	* El Map devuelto sirve para introducir los objetos que se hayan buscado
	* y no tener que repetir la busqueda. 
	*/
	
	
	private Map<String,Object> preConditionsFindAllRestAuthorized(Result< Map <String,Set<String>> > res )
	{
		Map<String,Object> cache=new HashMap<>();

		
		
		return cache;
	}

	/**
	* Claves disponibles en los rest
	* Este método Devuelve todas las claves de seguridad que comienzan por REST_ para cachear con el conjunto de grupos que lo soportan, apoyo a la seguridad
	*/




	@Transactional
	public Result< Map <String,Set<String>> > findAllRestAuthorized()
	{
		Result< Map <String,Set<String>> > res=new Result<>();
		String _params_=UtilParams.paramsToString();
		if (log.isInfoEnabled()) log.info("Entrando en SecurityGroupService.findAllRestAuthorized ("+_params_+")");
		Map<String,Object> cache=preConditionsFindAllRestAuthorized( res  );
		if(res.isOk())
		{
			try

			{


				
			//Desarrolle entre estas marcas y NO las toque
			//En serio, NO TOCAR las marcas!!!!!
			Map<String, Set<String>> resAux=new HashMap<String, Set<String>>();

			SecurityGroupCrit crit=new SecurityGroupCrit();
			crit.identifier(new StringFilter().setContains("REST_"));
			Result<List<SecurityGroup>> resListByCriteria = listByCriteria(crit);
			if(resListByCriteria.isOk())
			{
				if(resListByCriteria.getData()==null || resListByCriteria.getData().size()==0)
				{
					log.error("Error en el acceso a la seguridad en los REST:no devuelve datos");
				}
				else
				{
					for(SecurityGroup sec:resListByCriteria.getData())
					{
						Set<String> set = resAux.get(sec.getIdentifier());
						if(set==null)
						{
							set=new HashSet<String>();
							resAux.put(sec.getIdentifier(), set);
						}
						set.add(sec.getAllowedgroup());
					}
				}
				res.setData(resAux);
			}
			else
			{
				log.error("Error en el acceso a la seguridad en los REST");
				log.error(resListByCriteria.getErrores().toString());
			}

			

			}
			catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
				if (log.isErrorEnabled()) log.error("Error en SecurityGroupServiceCRUD.findAllRestAuthorized ("+_params_+"). Excepcion:"+UtilException.printStackTrace(e));
			}
		}
		if (log.isInfoEnabled()) log.info("Salida de SecurityGroupServiceCRUD.findAllRestAuthorized ("+UtilParams.paramsToString()+"). Result:"+res.toString());

		if (!res.isOk())	
		{
			try {	
				TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
			}catch(Throwable t)
			{
				res.addError(new ErrorTransaccionNoDisponible());
				if (log.isErrorEnabled()) log.error("Error de Transaccion de SecurityGroupServiceCRUD.findAllRestAuthorized ("+UtilParams.paramsToString()+"). Excepcion:"+UtilException.printStackTrace(t));
			}
		}


		return res;
	}


// FIN DE LN DE CRUD

	@Autowired
	EntityManager em;
	public Result<Page< SecurityGroup >> listByExampleExt(SecurityGroupExt obj/*, Pageable page*/)
	{
		Result<Page< SecurityGroup >> res= new Result<>();
		String from=" FROM  SecurityGroup AS obj ";
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

		if(obj.getAllowedgroup()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ8",obj.getAllowedgroup());
			sbWhere.append(" obj.allowedgroup = :OBJ8 ");
		}
		if(obj.getAllowedgroup_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ9",obj.getAllowedgroup_IN());
			sbWhere.append(" obj.allowedgroup IN :OBJ9 ");
		}
		if(obj.getAllowedgroup_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ10",obj.getAllowedgroup_NOTIN());
			sbWhere.append(" obj.allowedgroup NOT IN :OBJ10 ");
		}

		if(obj.getAllowedgroup_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ11",obj.getAllowedgroup_LIKE());
			sbWhere.append(" obj.allowedgroup LIKE :OBJ11 ");
		}
		if(obj.getAllowedgroup_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ12",obj.getAllowedgroup_NOTLIKE());
			sbWhere.append(" obj.allowedgroup NOT LIKE :OBJ12 ");
		}

		if(obj.getIdentifier()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ13",obj.getIdentifier());
			sbWhere.append(" obj.identifier = :OBJ13 ");
		}
		if(obj.getIdentifier_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ14",obj.getIdentifier_IN());
			sbWhere.append(" obj.identifier IN :OBJ14 ");
		}
		if(obj.getIdentifier_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ15",obj.getIdentifier_NOTIN());
			sbWhere.append(" obj.identifier NOT IN :OBJ15 ");
		}

		if(obj.getIdentifier_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ16",obj.getIdentifier_LIKE());
			sbWhere.append(" obj.identifier LIKE :OBJ16 ");
		}
		if(obj.getIdentifier_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ17",obj.getIdentifier_NOTLIKE());
			sbWhere.append(" obj.identifier NOT LIKE :OBJ17 ");
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
		Query query = em.createQuery(sQuery,SecurityGroup.class);
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
			List< SecurityGroup > lista=(List< SecurityGroup >)query.getResultList();
			int num = lista.size();
	
			Page< SecurityGroup > page=new org.sine95.kernel.base.PageBase< SecurityGroup >(num,obj.getMaxElemsPerPage(),obj.getPage(),lista);
			res.setData(page);
		}catch(Throwable t)
		{
			res.addError(new ErrorGeneral(t));
			if (log.isErrorEnabled()) log.error("Error por Excepcion. Excepcion:"+UtilException.printStackTrace(t));
		}
		return res;
	}




/*


				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				
				
				


				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				


				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				
				
				


				//Desarrolle entre estas marcas y NO las toque
				//En serio, NO TOCAR las marcas!!!!!
				


*/
}
