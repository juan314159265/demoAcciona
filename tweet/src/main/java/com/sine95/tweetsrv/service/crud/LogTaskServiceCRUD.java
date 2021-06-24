
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
import com.sine95.tweetsrv.repository.LogTaskRepository;
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
public class LogTaskServiceCRUD extends ServiceCRUD< LogTask ,Long > {

	private final Logger log = LoggerFactory.getLogger(LogTaskServiceCRUD.class);



	@Autowired
    protected EntityManager entityManager;

	@Autowired
    protected ApplicationContext appContext;

	

	
	@Autowired
	private LogTaskRepository repository;
	

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public LogTaskRepository  getRepositoryPublic(){
		return repository;
	}

	public LogTaskServiceCRUD() {
		super();
		addValidator(new LogTaskValidator(this));


		
		
	}

	@Override
	public String getCRUDName()
	{
		return "LogTask";
	}	

	@Override
	public Result<List< LogTask >> listByExample(LogTask example) {

		Result<List< LogTask >> res=new Result<>();
		try {
			Example< LogTask > examp=Example.of(example);
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
			res.addError(new ErrorCampoObligatorio("LogTask","id"));
			return res;
		}
		// Levantamos la LogTask
		Result< LogTask > rI = findWithResult(id);
		if (!rI.isOk()) return res.copyStatus(rI);
		LogTask i = rI.getData();
		// Eliminamos la LogTask
		try {
			res.copyStatus(delete(i));
		} catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	public Result<Page< LogTask >> listByExample(LogTask example, Pageable page) {

		Result<Page< LogTask >> res=new Result<>();
		try {
			Example< LogTask > examp=Example.of(example);
			res.setData(repository.findAll(examp,page));

		}catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	protected RepositoryBase< LogTask , Long > getRepository()
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
	protected LogTask findWithNull(Long id) throws IllegalArgumentException
	{
		Optional< LogTask > optional = repository.findById(id);
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
	public Result< LogTask > findWithResult(Long id)
	{
		Result< LogTask > res = new Result<>();
		LogTask o = null;
		try {
			o = findWithNull(id);
		} catch (IllegalArgumentException iae) {
			res.addError(new ErrorParamObligatorio("id"));
		} catch (Exception e) {
			res.addError(new ErrorGeneral(e));
		}
		if (o==null) res.addError(new ErrorIdNoEncontrado("LogTask",id));
	
		res.setData(o);
		return res;
	}

	@Override
	protected Result< LogTask > findWithResultFromObject(LogTask obj)
	{

		return findWithResult(obj.getId());
	}
	
	



	@Override
	protected Result< Vacio > copyFieldsUpdate(LogTask src, LogTask dest)
	{
    	dest.horaInicio(src.getHoraInicio());
    	dest.horaFin(src.getHoraFin());
    	dest.clase(src.getClase());
    	dest.metodo(src.getMetodo());
    	dest.errores(src.getErrores());
    	dest.warnings(src.getWarnings());
    	dest.infos(src.getInfos());

		Result< Vacio > res = new Result<>();
		res.setData(new Vacio());
		return res;
	}

    /**
     * Return a {@link List} of {@link LogTask } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    public Result< List< LogTask >> listByCriteria(LogTaskCrit criteria) {
				Result<List< LogTask >> res=new Result<>();
				try {
					if (log.isInfoEnabled()) log.info("find by criteria : {}", criteria);
	        final Specification< LogTask > specification = createSpecification(criteria);
					res.setData(repository.findAll(specification));
				}catch(Exception e)
				{
					res.addError(new ErrorGeneral(e));
				}
				return res;
    }

    /**
     * Return a {@link Page} of {@link LogTask } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    public  Result< Page< LogTask >> listByCriteriaPaged(LogTaskCritPaged criteria) {
			Result<Page< LogTask >> res=new Result<>();
			try {
				LogTaskCrit crit = criteria.getCrit();
				Pageable pag = criteria.getPag();

				
				
				
        		if (log.isInfoEnabled()) log.info("find by criteria : {}, page: {}", crit, pag);
        		final Specification< LogTask > specification = createSpecification(crit);
        		res.setData(repository.findAll(specification, pag));
			}catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
			}
			return res;
    }
/*
	@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
	@StaticMetamodel(LogTask.class)
	public abstract class LogTask_ {
		
		public static volatile SingularAttribute< LogTask , Long > id;
		
		public static volatile SingularAttribute< LogTask , Date > horaInicio;
		
		public static volatile SingularAttribute< LogTask , Date > horaFin;
		
		public static volatile SingularAttribute< LogTask , String > clase;
		
		public static volatile SingularAttribute< LogTask , String > metodo;
		
		public static volatile SingularAttribute< LogTask , String > errores;
		
		public static volatile SingularAttribute< LogTask , String > warnings;
		
		public static volatile SingularAttribute< LogTask , String > infos;
		

	}*/
    /**
     * Function to convert LogTaskCriteria to a {@link Specification}
     */
    private Specification< LogTask > createSpecification(LogTaskCrit criteria) {
        Specification< LogTask > specification = Specification.where(null);
        if (criteria != null) {

            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), LogTask_.id));
            }


            if (criteria.getHoraInicio() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getHoraInicio(), LogTask_.horaInicio));
            }


            if (criteria.getHoraFin() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getHoraFin(), LogTask_.horaFin));
            }


            if (criteria.getClase() != null) {
                specification = specification.and(buildStringSpecification(criteria.getClase(), LogTask_.clase));
            }


            if (criteria.getMetodo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMetodo(), LogTask_.metodo));
            }


            if (criteria.getErrores() != null) {
                specification = specification.and(buildStringSpecification(criteria.getErrores(), LogTask_.errores));
            }


            if (criteria.getWarnings() != null) {
                specification = specification.and(buildStringSpecification(criteria.getWarnings(), LogTask_.warnings));
            }


            if (criteria.getInfos() != null) {
                specification = specification.and(buildStringSpecification(criteria.getInfos(), LogTask_.infos));
            }


        }
        return specification;
    }

// Metodos para gestionar las relaciones


	//@Override
	public void preInsert(LogTask data) {
		
		
	}

	//@Override
	public void preUpdate(LogTask data,LogTask userData,Result< LogTask > res) {
		
			
	}

	//@Override
	public void preDelete(LogTask data) {
		
		
	}

	@Override
	public void postInsert(LogTask data) {
		
		
	}

	@Override
	public void postUpdate(LogTask data) {
		
			
	}

	@Override
	public void postDelete(LogTask data) {
		
		
	}

// LN DE CRUD

// FIN DE LN DE CRUD

	@Autowired
	EntityManager em;
	public Result<Page< LogTask >> listByExampleExt(LogTaskExt obj/*, Pageable page*/)
	{
		Result<Page< LogTask >> res= new Result<>();
		String from=" FROM  LogTask AS obj ";
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

		if(obj.getHoraInicio()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ8",obj.getHoraInicio());
			sbWhere.append(" obj.horaInicio = :OBJ8 ");
		}
		if(obj.getHoraInicio_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ9",obj.getHoraInicio_IN());
			sbWhere.append(" obj.horaInicio IN :OBJ9 ");
		}
		if(obj.getHoraInicio_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ10",obj.getHoraInicio_NOTIN());
			sbWhere.append(" obj.horaInicio NOT IN :OBJ10 ");
		}

		if(obj.getHoraInicio_DISTINCT()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ11",obj.getHoraInicio_DISTINCT());
			sbWhere.append(" obj.horaInicio <> :OBJ11 ");
		}
	
		if(obj.getHoraInicio_GREATERTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ12",obj.getHoraInicio_GREATERTHAN());
			sbWhere.append(" obj.horaInicio > :OBJ12 ");
		}
	
		if(obj.getHoraInicio_GREATEROREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ13",obj.getHoraInicio_GREATEROREQUALTHAN());
			sbWhere.append(" obj.horaInicio >= :OBJ13 ");
		}
	
		if(obj.getHoraInicio_LESSTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ14",obj.getHoraInicio_LESSTHAN());
			sbWhere.append(" obj.horaInicio < :OBJ14 ");
		}
	
		if(obj.getHoraInicio_LESSOREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ15",obj.getHoraInicio_LESSOREQUALTHAN());
			sbWhere.append(" obj.horaInicio <= :OBJ15 ");
		}

		if(obj.getHoraFin()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ16",obj.getHoraFin());
			sbWhere.append(" obj.horaFin = :OBJ16 ");
		}
		if(obj.getHoraFin_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ17",obj.getHoraFin_IN());
			sbWhere.append(" obj.horaFin IN :OBJ17 ");
		}
		if(obj.getHoraFin_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ18",obj.getHoraFin_NOTIN());
			sbWhere.append(" obj.horaFin NOT IN :OBJ18 ");
		}

		if(obj.getHoraFin_ISNOTNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.horaFin IS NOT NULL ");
		}
		if(obj.getHoraFin_ISNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.horaFin IS NULL ");
		}

		if(obj.getHoraFin_DISTINCT()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ19",obj.getHoraFin_DISTINCT());
			sbWhere.append(" obj.horaFin <> :OBJ19 ");
		}
	
		if(obj.getHoraFin_GREATERTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ20",obj.getHoraFin_GREATERTHAN());
			sbWhere.append(" obj.horaFin > :OBJ20 ");
		}
	
		if(obj.getHoraFin_GREATEROREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ21",obj.getHoraFin_GREATEROREQUALTHAN());
			sbWhere.append(" obj.horaFin >= :OBJ21 ");
		}
	
		if(obj.getHoraFin_LESSTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ22",obj.getHoraFin_LESSTHAN());
			sbWhere.append(" obj.horaFin < :OBJ22 ");
		}
	
		if(obj.getHoraFin_LESSOREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ23",obj.getHoraFin_LESSOREQUALTHAN());
			sbWhere.append(" obj.horaFin <= :OBJ23 ");
		}

		if(obj.getClase()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ24",obj.getClase());
			sbWhere.append(" obj.clase = :OBJ24 ");
		}
		if(obj.getClase_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ25",obj.getClase_IN());
			sbWhere.append(" obj.clase IN :OBJ25 ");
		}
		if(obj.getClase_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ26",obj.getClase_NOTIN());
			sbWhere.append(" obj.clase NOT IN :OBJ26 ");
		}

		if(obj.getClase_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ27",obj.getClase_LIKE());
			sbWhere.append(" obj.clase LIKE :OBJ27 ");
		}
		if(obj.getClase_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ28",obj.getClase_NOTLIKE());
			sbWhere.append(" obj.clase NOT LIKE :OBJ28 ");
		}

		if(obj.getMetodo()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ29",obj.getMetodo());
			sbWhere.append(" obj.metodo = :OBJ29 ");
		}
		if(obj.getMetodo_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ30",obj.getMetodo_IN());
			sbWhere.append(" obj.metodo IN :OBJ30 ");
		}
		if(obj.getMetodo_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ31",obj.getMetodo_NOTIN());
			sbWhere.append(" obj.metodo NOT IN :OBJ31 ");
		}

		if(obj.getMetodo_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ32",obj.getMetodo_LIKE());
			sbWhere.append(" obj.metodo LIKE :OBJ32 ");
		}
		if(obj.getMetodo_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ33",obj.getMetodo_NOTLIKE());
			sbWhere.append(" obj.metodo NOT LIKE :OBJ33 ");
		}

		if(obj.getErrores()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ34",obj.getErrores());
			sbWhere.append(" obj.errores = :OBJ34 ");
		}
		if(obj.getErrores_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ35",obj.getErrores_IN());
			sbWhere.append(" obj.errores IN :OBJ35 ");
		}
		if(obj.getErrores_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ36",obj.getErrores_NOTIN());
			sbWhere.append(" obj.errores NOT IN :OBJ36 ");
		}

		if(obj.getErrores_ISNOTNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.errores IS NOT NULL ");
		}
		if(obj.getErrores_ISNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.errores IS NULL ");
		}

		if(obj.getErrores_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ37",obj.getErrores_LIKE());
			sbWhere.append(" obj.errores LIKE :OBJ37 ");
		}
		if(obj.getErrores_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ38",obj.getErrores_NOTLIKE());
			sbWhere.append(" obj.errores NOT LIKE :OBJ38 ");
		}

		if(obj.getWarnings()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ39",obj.getWarnings());
			sbWhere.append(" obj.warnings = :OBJ39 ");
		}
		if(obj.getWarnings_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ40",obj.getWarnings_IN());
			sbWhere.append(" obj.warnings IN :OBJ40 ");
		}
		if(obj.getWarnings_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ41",obj.getWarnings_NOTIN());
			sbWhere.append(" obj.warnings NOT IN :OBJ41 ");
		}

		if(obj.getWarnings_ISNOTNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.warnings IS NOT NULL ");
		}
		if(obj.getWarnings_ISNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.warnings IS NULL ");
		}

		if(obj.getWarnings_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ42",obj.getWarnings_LIKE());
			sbWhere.append(" obj.warnings LIKE :OBJ42 ");
		}
		if(obj.getWarnings_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ43",obj.getWarnings_NOTLIKE());
			sbWhere.append(" obj.warnings NOT LIKE :OBJ43 ");
		}

		if(obj.getInfos()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ44",obj.getInfos());
			sbWhere.append(" obj.infos = :OBJ44 ");
		}
		if(obj.getInfos_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ45",obj.getInfos_IN());
			sbWhere.append(" obj.infos IN :OBJ45 ");
		}
		if(obj.getInfos_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ46",obj.getInfos_NOTIN());
			sbWhere.append(" obj.infos NOT IN :OBJ46 ");
		}

		if(obj.getInfos_ISNOTNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.infos IS NOT NULL ");
		}
		if(obj.getInfos_ISNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.infos IS NULL ");
		}

		if(obj.getInfos_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ47",obj.getInfos_LIKE());
			sbWhere.append(" obj.infos LIKE :OBJ47 ");
		}
		if(obj.getInfos_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ48",obj.getInfos_NOTLIKE());
			sbWhere.append(" obj.infos NOT LIKE :OBJ48 ");
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
		Query query = em.createQuery(sQuery,LogTask.class);
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
			List< LogTask > lista=(List< LogTask >)query.getResultList();
			int num = lista.size();
	
			Page< LogTask > page=new org.sine95.kernel.base.PageBase< LogTask >(num,obj.getMaxElemsPerPage(),obj.getPage(),lista);
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
