
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
import com.sine95.tweetsrv.repository.ConfigurationRepository;
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
public class ConfigurationServiceCRUD extends ServiceCRUD< Configuration ,Long > {

	private final Logger log = LoggerFactory.getLogger(ConfigurationServiceCRUD.class);



	@Autowired
    protected EntityManager entityManager;

	@Autowired
    protected ApplicationContext appContext;

	

	
	@Autowired
	private ConfigurationRepository repository;
	

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public ConfigurationRepository  getRepositoryPublic(){
		return repository;
	}

	public ConfigurationServiceCRUD() {
		super();
		addValidator(new ConfigurationValidator(this));


		
		
	}

	@Override
	public String getCRUDName()
	{
		return "Configuration";
	}	

	@Override
	public Result<List< Configuration >> listByExample(Configuration example) {

		Result<List< Configuration >> res=new Result<>();
		try {
			Example< Configuration > examp=Example.of(example);
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
			res.addError(new ErrorCampoObligatorio("Configuration","id"));
			return res;
		}
		// Levantamos la Configuration
		Result< Configuration > rI = findWithResult(id);
		if (!rI.isOk()) return res.copyStatus(rI);
		Configuration i = rI.getData();
		// Eliminamos la Configuration
		try {
			res.copyStatus(delete(i));
		} catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	public Result<Page< Configuration >> listByExample(Configuration example, Pageable page) {

		Result<Page< Configuration >> res=new Result<>();
		try {
			Example< Configuration > examp=Example.of(example);
			res.setData(repository.findAll(examp,page));

		}catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	protected RepositoryBase< Configuration , Long > getRepository()
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
	protected Configuration findWithNull(Long id) throws IllegalArgumentException
	{
		Optional< Configuration > optional = repository.findById(id);
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
	public Result< Configuration > findWithResult(Long id)
	{
		Result< Configuration > res = new Result<>();
		Configuration o = null;
		try {
			o = findWithNull(id);
		} catch (IllegalArgumentException iae) {
			res.addError(new ErrorParamObligatorio("id"));
		} catch (Exception e) {
			res.addError(new ErrorGeneral(e));
		}
		if (o==null) res.addError(new ErrorIdNoEncontrado("Configuration",id));
	
		res.setData(o);
		return res;
	}

	@Override
	protected Result< Configuration > findWithResultFromObject(Configuration obj)
	{

		return findWithResult(obj.getId());
	}
	
	



	@Override
	protected Result< Vacio > copyFieldsUpdate(Configuration src, Configuration dest)
	{
    	dest.keyid(src.getKeyid());
    	dest.value(src.getValue());
    	dest.type(src.getType());
    	dest.description(src.getDescription());

		Result< Vacio > res = new Result<>();
		res.setData(new Vacio());
		return res;
	}

    /**
     * Return a {@link List} of {@link Configuration } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    public Result< List< Configuration >> listByCriteria(ConfigurationCrit criteria) {
				Result<List< Configuration >> res=new Result<>();
				try {
					if (log.isInfoEnabled()) log.info("find by criteria : {}", criteria);
	        final Specification< Configuration > specification = createSpecification(criteria);
					res.setData(repository.findAll(specification));
				}catch(Exception e)
				{
					res.addError(new ErrorGeneral(e));
				}
				return res;
    }

    /**
     * Return a {@link Page} of {@link Configuration } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    public  Result< Page< Configuration >> listByCriteriaPaged(ConfigurationCritPaged criteria) {
			Result<Page< Configuration >> res=new Result<>();
			try {
				ConfigurationCrit crit = criteria.getCrit();
				Pageable pag = criteria.getPag();

				
				
				
        		if (log.isInfoEnabled()) log.info("find by criteria : {}, page: {}", crit, pag);
        		final Specification< Configuration > specification = createSpecification(crit);
        		res.setData(repository.findAll(specification, pag));
			}catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
			}
			return res;
    }
/*
	@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
	@StaticMetamodel(Configuration.class)
	public abstract class Configuration_ {
		
		public static volatile SingularAttribute< Configuration , Long > id;
		
		public static volatile SingularAttribute< Configuration , String > keyid;
		
		public static volatile SingularAttribute< Configuration , String > value;
		
		public static volatile SingularAttribute< Configuration , String > type;
		
		public static volatile SingularAttribute< Configuration , String > description;
		

	}*/
    /**
     * Function to convert ConfigurationCriteria to a {@link Specification}
     */
    private Specification< Configuration > createSpecification(ConfigurationCrit criteria) {
        Specification< Configuration > specification = Specification.where(null);
        if (criteria != null) {

            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Configuration_.id));
            }


            if (criteria.getKeyid() != null) {
                specification = specification.and(buildStringSpecification(criteria.getKeyid(), Configuration_.keyid));
            }


            if (criteria.getValue() != null) {
                specification = specification.and(buildStringSpecification(criteria.getValue(), Configuration_.value));
            }


            if (criteria.getType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getType(), Configuration_.type));
            }


            if (criteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescription(), Configuration_.description));
            }


        }
        return specification;
    }

// Metodos para gestionar las relaciones


	//@Override
	public void preInsert(Configuration data) {
		
		
	}

	//@Override
	public void preUpdate(Configuration data,Configuration userData,Result< Configuration > res) {
		
			
	}

	//@Override
	public void preDelete(Configuration data) {
		
		
	}

	@Override
	public void postInsert(Configuration data) {
		
		Config.reset();
		
	}

	@Override
	public void postUpdate(Configuration data) {
		
		Config.reset();
			
	}

	@Override
	public void postDelete(Configuration data) {
		
		Config.reset();
		
	}

// LN DE CRUD

// FIN DE LN DE CRUD

	@Autowired
	EntityManager em;
	public Result<Page< Configuration >> listByExampleExt(ConfigurationExt obj/*, Pageable page*/)
	{
		Result<Page< Configuration >> res= new Result<>();
		String from=" FROM  Configuration AS obj ";
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

		if(obj.getKeyid()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ8",obj.getKeyid());
			sbWhere.append(" obj.keyid = :OBJ8 ");
		}
		if(obj.getKeyid_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ9",obj.getKeyid_IN());
			sbWhere.append(" obj.keyid IN :OBJ9 ");
		}
		if(obj.getKeyid_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ10",obj.getKeyid_NOTIN());
			sbWhere.append(" obj.keyid NOT IN :OBJ10 ");
		}

		if(obj.getKeyid_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ11",obj.getKeyid_LIKE());
			sbWhere.append(" obj.keyid LIKE :OBJ11 ");
		}
		if(obj.getKeyid_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ12",obj.getKeyid_NOTLIKE());
			sbWhere.append(" obj.keyid NOT LIKE :OBJ12 ");
		}

		if(obj.getValue()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ13",obj.getValue());
			sbWhere.append(" obj.value = :OBJ13 ");
		}
		if(obj.getValue_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ14",obj.getValue_IN());
			sbWhere.append(" obj.value IN :OBJ14 ");
		}
		if(obj.getValue_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ15",obj.getValue_NOTIN());
			sbWhere.append(" obj.value NOT IN :OBJ15 ");
		}

		if(obj.getValue_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ16",obj.getValue_LIKE());
			sbWhere.append(" obj.value LIKE :OBJ16 ");
		}
		if(obj.getValue_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ17",obj.getValue_NOTLIKE());
			sbWhere.append(" obj.value NOT LIKE :OBJ17 ");
		}

		if(obj.getType()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ18",obj.getType());
			sbWhere.append(" obj.type = :OBJ18 ");
		}
		if(obj.getType_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ19",obj.getType_IN());
			sbWhere.append(" obj.type IN :OBJ19 ");
		}
		if(obj.getType_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ20",obj.getType_NOTIN());
			sbWhere.append(" obj.type NOT IN :OBJ20 ");
		}

		if(obj.getType_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ21",obj.getType_LIKE());
			sbWhere.append(" obj.type LIKE :OBJ21 ");
		}
		if(obj.getType_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ22",obj.getType_NOTLIKE());
			sbWhere.append(" obj.type NOT LIKE :OBJ22 ");
		}

		if(obj.getDescription()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ23",obj.getDescription());
			sbWhere.append(" obj.description = :OBJ23 ");
		}
		if(obj.getDescription_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ24",obj.getDescription_IN());
			sbWhere.append(" obj.description IN :OBJ24 ");
		}
		if(obj.getDescription_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ25",obj.getDescription_NOTIN());
			sbWhere.append(" obj.description NOT IN :OBJ25 ");
		}

		if(obj.getDescription_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ26",obj.getDescription_LIKE());
			sbWhere.append(" obj.description LIKE :OBJ26 ");
		}
		if(obj.getDescription_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ27",obj.getDescription_NOTLIKE());
			sbWhere.append(" obj.description NOT LIKE :OBJ27 ");
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
		Query query = em.createQuery(sQuery,Configuration.class);
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
			List< Configuration > lista=(List< Configuration >)query.getResultList();
			int num = lista.size();
	
			Page< Configuration > page=new org.sine95.kernel.base.PageBase< Configuration >(num,obj.getMaxElemsPerPage(),obj.getPage(),lista);
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
