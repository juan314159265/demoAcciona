
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
import com.sine95.tweetsrv.repository.J314AuthorityRepository;
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
public class J314AuthorityServiceCRUD extends ServiceCRUD< J314Authority ,String > {

	private final Logger log = LoggerFactory.getLogger(J314AuthorityServiceCRUD.class);



	@Autowired
    protected EntityManager entityManager;

	@Autowired
    protected ApplicationContext appContext;

	

	
	@Autowired
	private J314AuthorityRepository repository;
	

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public J314AuthorityRepository  getRepositoryPublic(){
		return repository;
	}

	public J314AuthorityServiceCRUD() {
		super();
		addValidator(new J314AuthorityValidator(this));


		
		
	}

	@Override
	public String getCRUDName()
	{
		return "J314Authority";
	}	

	@Override
	public Result<List< J314Authority >> listByExample(J314Authority example) {

		Result<List< J314Authority >> res=new Result<>();
		try {
			Example< J314Authority > examp=Example.of(example);
			res.setData(repository.findAll(examp));

		}catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}
	
	public Result<Vacio> delete(String id) {
		Result<Vacio> res=new Result<>();
		if (id==null) {
			res.addError(new ErrorCampoObligatorio("J314Authority","id"));
			return res;
		}
		// Levantamos la J314Authority
		Result< J314Authority > rI = findWithResult(id);
		if (!rI.isOk()) return res.copyStatus(rI);
		J314Authority i = rI.getData();
		// Eliminamos la J314Authority
		try {
			res.copyStatus(delete(i));
		} catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	public Result<Page< J314Authority >> listByExample(J314Authority example, Pageable page) {

		Result<Page< J314Authority >> res=new Result<>();
		try {
			Example< J314Authority > examp=Example.of(example);
			res.setData(repository.findAll(examp,page));

		}catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	protected RepositoryBase< J314Authority , String > getRepository()
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
	protected J314Authority findWithNull(String id) throws IllegalArgumentException
	{
		Optional< J314Authority > optional = repository.findById(id);
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
	public Result< J314Authority > findWithResult(String id)
	{
		Result< J314Authority > res = new Result<>();
		J314Authority o = null;
		try {
			o = findWithNull(id);
		} catch (IllegalArgumentException iae) {
			res.addError(new ErrorParamObligatorio("id"));
		} catch (Exception e) {
			res.addError(new ErrorGeneral(e));
		}
		if (o==null) res.addError(new ErrorIdNoEncontrado("J314Authority",id));
	
		res.setData(o);
		return res;
	}

	@Override
	protected Result< J314Authority > findWithResultFromObject(J314Authority obj)
	{

		return findWithResult(obj.getName());
	}
	
	



	@Override
	protected Result< Vacio > copyFieldsUpdate(J314Authority src, J314Authority dest)
	{

		Result< Vacio > res = new Result<>();
		res.setData(new Vacio());
		return res;
	}

    /**
     * Return a {@link List} of {@link J314Authority } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    public Result< List< J314Authority >> listByCriteria(J314AuthorityCrit criteria) {
				Result<List< J314Authority >> res=new Result<>();
				try {
					if (log.isInfoEnabled()) log.info("find by criteria : {}", criteria);
	        final Specification< J314Authority > specification = createSpecification(criteria);
					res.setData(repository.findAll(specification));
				}catch(Exception e)
				{
					res.addError(new ErrorGeneral(e));
				}
				return res;
    }

    /**
     * Return a {@link Page} of {@link J314Authority } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    public  Result< Page< J314Authority >> listByCriteriaPaged(J314AuthorityCritPaged criteria) {
			Result<Page< J314Authority >> res=new Result<>();
			try {
				J314AuthorityCrit crit = criteria.getCrit();
				Pageable pag = criteria.getPag();

				
				
				
        		if (log.isInfoEnabled()) log.info("find by criteria : {}, page: {}", crit, pag);
        		final Specification< J314Authority > specification = createSpecification(crit);
        		res.setData(repository.findAll(specification, pag));
			}catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
			}
			return res;
    }
/*
	@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
	@StaticMetamodel(J314Authority.class)
	public abstract class J314Authority_ {
		
		public static volatile SingularAttribute< J314Authority , String > name;
		
		public static volatile SingularAttribute< J314Authority , null > users;
		

	}*/
    /**
     * Function to convert J314AuthorityCriteria to a {@link Specification}
     */
    private Specification< J314Authority > createSpecification(J314AuthorityCrit criteria) {
        Specification< J314Authority > specification = Specification.where(null);
        if (criteria != null) {

            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), J314Authority_.name));
            }


        }
        return specification;
    }

// Metodos para gestionar las relaciones

// Campo de relacion. Nombre: users; Tipo: MAN; Navegacion: N; Entidad remota: J314UserAuthority
				
	public Result<List< J314UserAuthority >> getListUsers(String name) 
	{
		Result<List< J314UserAuthority >> res=new Result<>();

		Result< J314Authority > ro = findWithResult(name);
		if (ro.isOk())
			res.setData(ro.getData().getUsers());
		return res;
	}
	
	public Result<List< RelJ314UserAuthority >> getListRelUsers(String name)
	{
		Result<List< RelJ314UserAuthority >> res=new Result<>();

		Result<List< J314UserAuthority >> rlo=getListUsers(name);
		if (rlo.isOk()) 
		{
			List< J314UserAuthority > lo = rlo.getData();
			res.setData(
				lo.stream().map(o->new RelJ314UserAuthority(o)).collect(Collectors.toList())
			);
		}
		return res;
	}

// HASTA AQUI Campo de relacion. Nombre users; Tipo: MAN; Navegacion: N; Entidad remota: J314UserAuthority


	//@Override
	public void preInsert(J314Authority data) {
		
		
	}

	//@Override
	public void preUpdate(J314Authority data,J314Authority userData,Result< J314Authority > res) {
		
			
	}

	//@Override
	public void preDelete(J314Authority data) {
		
		
	}

	@Override
	public void postInsert(J314Authority data) {
		
		
	}

	@Override
	public void postUpdate(J314Authority data) {
		
			
	}

	@Override
	public void postDelete(J314Authority data) {
		
		
	}

// LN DE CRUD

// FIN DE LN DE CRUD

	@Autowired
	EntityManager em;
	public Result<Page< J314Authority >> listByExampleExt(J314AuthorityExt obj/*, Pageable page*/)
	{
		Result<Page< J314Authority >> res= new Result<>();
		String from=" FROM  J314Authority AS obj ";
		String head=new String("SELECT obj "+from);
		Map<String,Object> params=new HashMap<>();
		//where
		String where;
		StringBuilder sbWhere=new StringBuilder("");


		if(obj.getName()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ0",obj.getName());
			sbWhere.append(" obj.name = :OBJ0 ");
		}
		if(obj.getName_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ1",obj.getName_IN());
			sbWhere.append(" obj.name IN :OBJ1 ");
		}
		if(obj.getName_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ2",obj.getName_NOTIN());
			sbWhere.append(" obj.name NOT IN :OBJ2 ");
		}

		if(obj.getName_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ3",obj.getName_LIKE());
			sbWhere.append(" obj.name LIKE :OBJ3 ");
		}
		if(obj.getName_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ4",obj.getName_NOTLIKE());
			sbWhere.append(" obj.name NOT LIKE :OBJ4 ");
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
		Query query = em.createQuery(sQuery,J314Authority.class);
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
			List< J314Authority > lista=(List< J314Authority >)query.getResultList();
			int num = lista.size();
	
			Page< J314Authority > page=new org.sine95.kernel.base.PageBase< J314Authority >(num,obj.getMaxElemsPerPage(),obj.getPage(),lista);
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
