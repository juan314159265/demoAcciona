
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
import com.sine95.tweetsrv.repository.HashtagsRepository;
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
public class HashtagsServiceCRUD extends ServiceCRUD< Hashtags ,Long > {

	private final Logger log = LoggerFactory.getLogger(HashtagsServiceCRUD.class);



	@Autowired
    protected EntityManager entityManager;

	@Autowired
    protected ApplicationContext appContext;

	

	
	@Autowired
	private HashtagsRepository repository;
	

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public HashtagsRepository  getRepositoryPublic(){
		return repository;
	}

	public HashtagsServiceCRUD() {
		super();
		addValidator(new HashtagsValidator(this));


		
		
	}

	@Override
	public String getCRUDName()
	{
		return "Hashtags";
	}	

	@Override
	public Result<List< Hashtags >> listByExample(Hashtags example) {

		Result<List< Hashtags >> res=new Result<>();
		try {
			Example< Hashtags > examp=Example.of(example);
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
			res.addError(new ErrorCampoObligatorio("Hashtags","id"));
			return res;
		}
		// Levantamos la Hashtags
		Result< Hashtags > rI = findWithResult(id);
		if (!rI.isOk()) return res.copyStatus(rI);
		Hashtags i = rI.getData();
		// Eliminamos la Hashtags
		try {
			res.copyStatus(delete(i));
		} catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	public Result<Page< Hashtags >> listByExample(Hashtags example, Pageable page) {

		Result<Page< Hashtags >> res=new Result<>();
		try {
			Example< Hashtags > examp=Example.of(example);
			res.setData(repository.findAll(examp,page));

		}catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	protected RepositoryBase< Hashtags , Long > getRepository()
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
	protected Hashtags findWithNull(Long id) throws IllegalArgumentException
	{
		Optional< Hashtags > optional = repository.findById(id);
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
	public Result< Hashtags > findWithResult(Long id)
	{
		Result< Hashtags > res = new Result<>();
		Hashtags o = null;
		try {
			o = findWithNull(id);
		} catch (IllegalArgumentException iae) {
			res.addError(new ErrorParamObligatorio("id"));
		} catch (Exception e) {
			res.addError(new ErrorGeneral(e));
		}
		if (o==null) res.addError(new ErrorIdNoEncontrado("Hashtags",id));
	
		res.setData(o);
		return res;
	}

	@Override
	protected Result< Hashtags > findWithResultFromObject(Hashtags obj)
	{

		return findWithResult(obj.getId());
	}
	
	



	@Override
	protected Result< Vacio > copyFieldsUpdate(Hashtags src, Hashtags dest)
	{
    	dest.hashtags(src.getHashtags());
    	dest.contador(src.getContador());

		Result< Vacio > res = new Result<>();
		res.setData(new Vacio());
		return res;
	}

    /**
     * Return a {@link List} of {@link Hashtags } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    public Result< List< Hashtags >> listByCriteria(HashtagsCrit criteria) {
				Result<List< Hashtags >> res=new Result<>();
				try {
					if (log.isInfoEnabled()) log.info("find by criteria : {}", criteria);
	        final Specification< Hashtags > specification = createSpecification(criteria);
					res.setData(repository.findAll(specification));
				}catch(Exception e)
				{
					res.addError(new ErrorGeneral(e));
				}
				return res;
    }

    /**
     * Return a {@link Page} of {@link Hashtags } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    public  Result< Page< Hashtags >> listByCriteriaPaged(HashtagsCritPaged criteria) {
			Result<Page< Hashtags >> res=new Result<>();
			try {
				HashtagsCrit crit = criteria.getCrit();
				Pageable pag = criteria.getPag();

				
				
				
        		if (log.isInfoEnabled()) log.info("find by criteria : {}, page: {}", crit, pag);
        		final Specification< Hashtags > specification = createSpecification(crit);
        		res.setData(repository.findAll(specification, pag));
			}catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
			}
			return res;
    }
/*
	@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
	@StaticMetamodel(Hashtags.class)
	public abstract class Hashtags_ {
		
		public static volatile SingularAttribute< Hashtags , Long > id;
		
		public static volatile SingularAttribute< Hashtags , String > hashtags;
		
		public static volatile SingularAttribute< Hashtags , Long > contador;
		

	}*/
    /**
     * Function to convert HashtagsCriteria to a {@link Specification}
     */
    private Specification< Hashtags > createSpecification(HashtagsCrit criteria) {
        Specification< Hashtags > specification = Specification.where(null);
        if (criteria != null) {

            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Hashtags_.id));
            }


            if (criteria.getHashtags() != null) {
                specification = specification.and(buildStringSpecification(criteria.getHashtags(), Hashtags_.hashtags));
            }


            if (criteria.getContador() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getContador(), Hashtags_.contador));
            }


        }
        return specification;
    }

// Metodos para gestionar las relaciones


	//@Override
	public void preInsert(Hashtags data) {
		
		
	}

	//@Override
	public void preUpdate(Hashtags data,Hashtags userData,Result< Hashtags > res) {
		
			
	}

	//@Override
	public void preDelete(Hashtags data) {
		
		
	}

	@Override
	public void postInsert(Hashtags data) {
		
		
	}

	@Override
	public void postUpdate(Hashtags data) {
		
			
	}

	@Override
	public void postDelete(Hashtags data) {
		
		
	}

// LN DE CRUD

// FIN DE LN DE CRUD

	@Autowired
	EntityManager em;
	public Result<Page< Hashtags >> listByExampleExt(HashtagsExt obj/*, Pageable page*/)
	{
		Result<Page< Hashtags >> res= new Result<>();
		String from=" FROM  Hashtags AS obj ";
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

		if(obj.getHashtags()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ8",obj.getHashtags());
			sbWhere.append(" obj.hashtags = :OBJ8 ");
		}
		if(obj.getHashtags_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ9",obj.getHashtags_IN());
			sbWhere.append(" obj.hashtags IN :OBJ9 ");
		}
		if(obj.getHashtags_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ10",obj.getHashtags_NOTIN());
			sbWhere.append(" obj.hashtags NOT IN :OBJ10 ");
		}

		if(obj.getHashtags_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ11",obj.getHashtags_LIKE());
			sbWhere.append(" obj.hashtags LIKE :OBJ11 ");
		}
		if(obj.getHashtags_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ12",obj.getHashtags_NOTLIKE());
			sbWhere.append(" obj.hashtags NOT LIKE :OBJ12 ");
		}

		if(obj.getContador()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ13",obj.getContador());
			sbWhere.append(" obj.contador = :OBJ13 ");
		}
		if(obj.getContador_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ14",obj.getContador_IN());
			sbWhere.append(" obj.contador IN :OBJ14 ");
		}
		if(obj.getContador_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ15",obj.getContador_NOTIN());
			sbWhere.append(" obj.contador NOT IN :OBJ15 ");
		}

		if(obj.getContador_DISTINCT()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ16",obj.getContador_DISTINCT());
			sbWhere.append(" obj.contador <> :OBJ16 ");
		}
	
		if(obj.getContador_GREATERTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ17",obj.getContador_GREATERTHAN());
			sbWhere.append(" obj.contador > :OBJ17 ");
		}
	
		if(obj.getContador_GREATEROREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ18",obj.getContador_GREATEROREQUALTHAN());
			sbWhere.append(" obj.contador >= :OBJ18 ");
		}
	
		if(obj.getContador_LESSTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ19",obj.getContador_LESSTHAN());
			sbWhere.append(" obj.contador < :OBJ19 ");
		}
	
		if(obj.getContador_LESSOREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ20",obj.getContador_LESSOREQUALTHAN());
			sbWhere.append(" obj.contador <= :OBJ20 ");
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
		Query query = em.createQuery(sQuery,Hashtags.class);
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
			List< Hashtags > lista=(List< Hashtags >)query.getResultList();
			int num = lista.size();
	
			Page< Hashtags > page=new org.sine95.kernel.base.PageBase< Hashtags >(num,obj.getMaxElemsPerPage(),obj.getPage(),lista);
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
