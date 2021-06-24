
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
import com.sine95.tweetsrv.repository.J314UserRepository;
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




import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.UnsupportedEncodingException;
import org.sine95.kernel.base.Contexto;
import org.sine95.kernel.base.JWTTicket;
import com.sine95.tweetsrv.service.ln.CacheLNService;
import com.sine95.tweetsrv.enums.AreasCache;



@Service
//@Transactional
@SuppressWarnings("unused")
public class J314UserServiceCRUD extends ServiceCRUD< J314User ,Long > {

	private final Logger log = LoggerFactory.getLogger(J314UserServiceCRUD.class);



	@Autowired
    protected EntityManager entityManager;

	@Autowired
    protected ApplicationContext appContext;

	

	
	@Autowired
	private J314UserRepository repository;
	

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public J314UserRepository  getRepositoryPublic(){
		return repository;
	}

	public J314UserServiceCRUD() {
		super();
		addValidator(new J314UserValidator(this));


		
		
	}

	@Override
	public String getCRUDName()
	{
		return "J314User";
	}	

	@Override
	public Result<List< J314User >> listByExample(J314User example) {

		Result<List< J314User >> res=new Result<>();
		try {
			Example< J314User > examp=Example.of(example);
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
			res.addError(new ErrorCampoObligatorio("J314User","id"));
			return res;
		}
		// Levantamos la J314User
		Result< J314User > rI = findWithResult(id);
		if (!rI.isOk()) return res.copyStatus(rI);
		J314User i = rI.getData();
		// Eliminamos la J314User
		try {
			res.copyStatus(delete(i));
		} catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	public Result<Page< J314User >> listByExample(J314User example, Pageable page) {

		Result<Page< J314User >> res=new Result<>();
		try {
			Example< J314User > examp=Example.of(example);
			res.setData(repository.findAll(examp,page));

		}catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	protected RepositoryBase< J314User , Long > getRepository()
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
	protected J314User findWithNull(Long id) throws IllegalArgumentException
	{
		Optional< J314User > optional = repository.findById(id);
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
	public Result< J314User > findWithResult(Long id)
	{
		Result< J314User > res = new Result<>();
		J314User o = null;
		try {
			o = findWithNull(id);
		} catch (IllegalArgumentException iae) {
			res.addError(new ErrorParamObligatorio("id"));
		} catch (Exception e) {
			res.addError(new ErrorGeneral(e));
		}
		if (o==null) res.addError(new ErrorIdNoEncontrado("J314User",id));
	
		res.setData(o);
		return res;
	}

	@Override
	protected Result< J314User > findWithResultFromObject(J314User obj)
	{

		return findWithResult(obj.getId());
	}
	
	



	@Override
	protected Result< Vacio > copyFieldsUpdate(J314User src, J314User dest)
	{
    	dest.created_by(src.getCreated_by());
    	dest.created_date(src.getCreated_date());
    	dest.last_modified_by(src.getLast_modified_by());
    	dest.last_modified_date(src.getLast_modified_date());
    	dest.activated(src.getActivated());
    	dest.activation_key(src.getActivation_key());
    	dest.login(src.getLogin());
    	dest.email(src.getEmail());
    	dest.first_name(src.getFirst_name());
    	dest.last_name(src.getLast_name());
    	dest.image_url(src.getImage_url());
    	dest.lang_key(src.getLang_key());
    	dest.password_hash(src.getPassword_hash());
    	dest.reset_date(src.getReset_date());
    	dest.reset_key(src.getReset_key());
    	dest.tiempoSesion(src.getTiempoSesion());

		Result< Vacio > res = new Result<>();
		res.setData(new Vacio());
		return res;
	}

    /**
     * Return a {@link List} of {@link J314User } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    public Result< List< J314User >> listByCriteria(J314UserCrit criteria) {
				Result<List< J314User >> res=new Result<>();
				try {
					if (log.isInfoEnabled()) log.info("find by criteria : {}", criteria);
	        final Specification< J314User > specification = createSpecification(criteria);
					res.setData(repository.findAll(specification));
				}catch(Exception e)
				{
					res.addError(new ErrorGeneral(e));
				}
				return res;
    }

    /**
     * Return a {@link Page} of {@link J314User } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    public  Result< Page< J314User >> listByCriteriaPaged(J314UserCritPaged criteria) {
			Result<Page< J314User >> res=new Result<>();
			try {
				J314UserCrit crit = criteria.getCrit();
				Pageable pag = criteria.getPag();

				
				
				
        		if (log.isInfoEnabled()) log.info("find by criteria : {}, page: {}", crit, pag);
        		final Specification< J314User > specification = createSpecification(crit);
        		res.setData(repository.findAll(specification, pag));
			}catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
			}
			return res;
    }
/*
	@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
	@StaticMetamodel(J314User.class)
	public abstract class J314User_ {
		
		public static volatile SingularAttribute< J314User , Long > id;
		
		public static volatile SingularAttribute< J314User , String > created_by;
		
		public static volatile SingularAttribute< J314User , Date > created_date;
		
		public static volatile SingularAttribute< J314User , String > last_modified_by;
		
		public static volatile SingularAttribute< J314User , Date > last_modified_date;
		
		public static volatile SingularAttribute< J314User , null > activated;
		
		public static volatile SingularAttribute< J314User , String > activation_key;
		
		public static volatile SingularAttribute< J314User , String > login;
		
		public static volatile SingularAttribute< J314User , String > email;
		
		public static volatile SingularAttribute< J314User , String > first_name;
		
		public static volatile SingularAttribute< J314User , String > last_name;
		
		public static volatile SingularAttribute< J314User , String > image_url;
		
		public static volatile SingularAttribute< J314User , String > lang_key;
		
		public static volatile SingularAttribute< J314User , String > password_hash;
		
		public static volatile SingularAttribute< J314User , Date > reset_date;
		
		public static volatile SingularAttribute< J314User , String > reset_key;
		
		public static volatile SingularAttribute< J314User , Long > tiempoSesion;
		
		public static volatile SingularAttribute< J314User , null > authorities;
		

	}*/
    /**
     * Function to convert J314UserCriteria to a {@link Specification}
     */
    private Specification< J314User > createSpecification(J314UserCrit criteria) {
        Specification< J314User > specification = Specification.where(null);
        if (criteria != null) {

            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), J314User_.id));
            }


            if (criteria.getCreated_by() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCreated_by(), J314User_.created_by));
            }


            if (criteria.getCreated_date() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreated_date(), J314User_.created_date));
            }


            if (criteria.getLast_modified_by() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLast_modified_by(), J314User_.last_modified_by));
            }


            if (criteria.getLast_modified_date() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLast_modified_date(), J314User_.last_modified_date));
            }


            if (criteria.getActivated() != null) {
                specification = specification.and(buildSpecification(criteria.getActivated(), J314User_.activated));
            }


            if (criteria.getActivation_key() != null) {
                specification = specification.and(buildStringSpecification(criteria.getActivation_key(), J314User_.activation_key));
            }


            if (criteria.getLogin() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLogin(), J314User_.login));
            }


            if (criteria.getEmail() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEmail(), J314User_.email));
            }


            if (criteria.getFirst_name() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFirst_name(), J314User_.first_name));
            }


            if (criteria.getLast_name() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLast_name(), J314User_.last_name));
            }


            if (criteria.getImage_url() != null) {
                specification = specification.and(buildStringSpecification(criteria.getImage_url(), J314User_.image_url));
            }


            if (criteria.getLang_key() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLang_key(), J314User_.lang_key));
            }


            if (criteria.getPassword_hash() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPassword_hash(), J314User_.password_hash));
            }


            if (criteria.getReset_date() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReset_date(), J314User_.reset_date));
            }


            if (criteria.getReset_key() != null) {
                specification = specification.and(buildStringSpecification(criteria.getReset_key(), J314User_.reset_key));
            }


            if (criteria.getTiempoSesion() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTiempoSesion(), J314User_.tiempoSesion));
            }


        }
        return specification;
    }

// Metodos para gestionar las relaciones

// Campo de relacion. Nombre: authorities; Tipo: MAN; Navegacion: M; Entidad remota: J314UserAuthority
				
	public Result<List< J314UserAuthority >> getListAuthorities(Long id) 
	{
		Result<List< J314UserAuthority >> res=new Result<>();

		Result< J314User > ro = findWithResult(id);
		if (ro.isOk())
			res.setData(ro.getData().getAuthorities());
		return res;
	}
	
	public Result<List< RelJ314UserAuthority >> getListRelAuthorities(Long id)
	{
		Result<List< RelJ314UserAuthority >> res=new Result<>();

		Result<List< J314UserAuthority >> rlo=getListAuthorities(id);
		if (rlo.isOk()) 
		{
			List< J314UserAuthority > lo = rlo.getData();
			res.setData(
				lo.stream().map(o->new RelJ314UserAuthority(o)).collect(Collectors.toList())
			);
		}
		return res;
	}

	public Result< J314User > setAuthorities(Long id, List< J314UserAuthority > authorities)
	{

		Result< J314User > res=findWithResult(id);
		if (res.isOk())
		{
			J314User obj = res.getData();
			obj.setAuthorities(authorities);
			try {
				repository.save(obj);
			}
			catch (Exception e)
			{
				res.addError(new ErrorGeneral(e));
			}
		}
		return res;
	}

	public Result< J314User > addAuthority(Long id, J314Authority j314Authority)
	{

		Result< J314User > res=findWithResult(id);
		if (res.isOk())
		{
			J314User obj = res.getData();
			obj.addAuthority(j314Authority);
			try {
				repository.save(obj);
			}
			catch (Exception e)
			{
				res.addError(new ErrorGeneral(e));
			}
		}
		return res;
	}
	
	public Result< J314User > removeAuthority(Long id, J314Authority j314Authority)
	{

		Result< J314User > res=findWithResult(id);
		if (res.isOk())
		{
			J314User obj = res.getData();
			obj.removeAuthority(j314Authority);
			try {
				repository.save(obj);
			}
			catch (Exception e)
			{
				res.addError(new ErrorGeneral(e));
			}
		}
		return res;
	}

// HASTA AQUI Campo de relacion. Nombre authorities; Tipo: MAN; Navegacion: M; Entidad remota: J314UserAuthority


	//@Override
	public void preInsert(J314User data) {
		
		if(data.getPassword_hash().length()<100)
		{
			try {
				data.setPassword_hash(UtilPass.getPassHasheado(data.getPassword_hash()));
			} catch (InvalidKeyException | JsonProcessingException | UnsupportedEncodingException
					| NoSuchAlgorithmException e) {
				
			}
		}
		Contexto ctx = Contexto.get();
		data.setCreated_by(ctx.getAsString(Contexto.LOGIN));
		data.setCreated_date(new Date());
		data.setLast_modified_by(ctx.getAsString(Contexto.LOGIN));
		data.setLast_modified_date(new Date());
		
	}

	//@Override
	public void preUpdate(J314User data,J314User userData,Result< J314User > res) {
		
		if(data.getPassword_hash().length()<100)
		{
			try {
				data.setPassword_hash(UtilPass.getPassHasheado(data.getPassword_hash()));
			} catch (InvalidKeyException | JsonProcessingException | UnsupportedEncodingException
					| NoSuchAlgorithmException e) {
				res.addError(new ErrorGeneral(e));
			}
		}
		Contexto ctx = Contexto.get();
		
		data.setLast_modified_by(ctx.getAsString(Contexto.LOGIN));
		data.setLast_modified_date(new Date());
			
	}

	//@Override
	public void preDelete(J314User data) {
		
		
	}

	@Override
	public void postInsert(J314User data) {
		
		reset();
		
	}

	@Override
	public void postUpdate(J314User data) {
		
		reset();
			
	}

	@Override
	public void postDelete(J314User data) {
		
		reset();
		
	}

// LN DE CRUD

// FIN DE LN DE CRUD

	@Autowired
	EntityManager em;
	public Result<Page< J314User >> listByExampleExt(J314UserExt obj/*, Pageable page*/)
	{
		Result<Page< J314User >> res= new Result<>();
		String from=" FROM  J314User AS obj ";
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

		if(obj.getCreated_by()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ8",obj.getCreated_by());
			sbWhere.append(" obj.created_by = :OBJ8 ");
		}
		if(obj.getCreated_by_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ9",obj.getCreated_by_IN());
			sbWhere.append(" obj.created_by IN :OBJ9 ");
		}
		if(obj.getCreated_by_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ10",obj.getCreated_by_NOTIN());
			sbWhere.append(" obj.created_by NOT IN :OBJ10 ");
		}

		if(obj.getCreated_by_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ11",obj.getCreated_by_LIKE());
			sbWhere.append(" obj.created_by LIKE :OBJ11 ");
		}
		if(obj.getCreated_by_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ12",obj.getCreated_by_NOTLIKE());
			sbWhere.append(" obj.created_by NOT LIKE :OBJ12 ");
		}

		if(obj.getCreated_date()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ13",obj.getCreated_date());
			sbWhere.append(" obj.created_date = :OBJ13 ");
		}
		if(obj.getCreated_date_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ14",obj.getCreated_date_IN());
			sbWhere.append(" obj.created_date IN :OBJ14 ");
		}
		if(obj.getCreated_date_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ15",obj.getCreated_date_NOTIN());
			sbWhere.append(" obj.created_date NOT IN :OBJ15 ");
		}

		if(obj.getCreated_date_DISTINCT()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ16",obj.getCreated_date_DISTINCT());
			sbWhere.append(" obj.created_date <> :OBJ16 ");
		}
	
		if(obj.getCreated_date_GREATERTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ17",obj.getCreated_date_GREATERTHAN());
			sbWhere.append(" obj.created_date > :OBJ17 ");
		}
	
		if(obj.getCreated_date_GREATEROREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ18",obj.getCreated_date_GREATEROREQUALTHAN());
			sbWhere.append(" obj.created_date >= :OBJ18 ");
		}
	
		if(obj.getCreated_date_LESSTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ19",obj.getCreated_date_LESSTHAN());
			sbWhere.append(" obj.created_date < :OBJ19 ");
		}
	
		if(obj.getCreated_date_LESSOREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ20",obj.getCreated_date_LESSOREQUALTHAN());
			sbWhere.append(" obj.created_date <= :OBJ20 ");
		}

		if(obj.getLast_modified_by()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ21",obj.getLast_modified_by());
			sbWhere.append(" obj.last_modified_by = :OBJ21 ");
		}
		if(obj.getLast_modified_by_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ22",obj.getLast_modified_by_IN());
			sbWhere.append(" obj.last_modified_by IN :OBJ22 ");
		}
		if(obj.getLast_modified_by_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ23",obj.getLast_modified_by_NOTIN());
			sbWhere.append(" obj.last_modified_by NOT IN :OBJ23 ");
		}

		if(obj.getLast_modified_by_ISNOTNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.last_modified_by IS NOT NULL ");
		}
		if(obj.getLast_modified_by_ISNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.last_modified_by IS NULL ");
		}

		if(obj.getLast_modified_by_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ24",obj.getLast_modified_by_LIKE());
			sbWhere.append(" obj.last_modified_by LIKE :OBJ24 ");
		}
		if(obj.getLast_modified_by_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ25",obj.getLast_modified_by_NOTLIKE());
			sbWhere.append(" obj.last_modified_by NOT LIKE :OBJ25 ");
		}

		if(obj.getLast_modified_date()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ26",obj.getLast_modified_date());
			sbWhere.append(" obj.last_modified_date = :OBJ26 ");
		}
		if(obj.getLast_modified_date_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ27",obj.getLast_modified_date_IN());
			sbWhere.append(" obj.last_modified_date IN :OBJ27 ");
		}
		if(obj.getLast_modified_date_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ28",obj.getLast_modified_date_NOTIN());
			sbWhere.append(" obj.last_modified_date NOT IN :OBJ28 ");
		}

		if(obj.getLast_modified_date_ISNOTNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.last_modified_date IS NOT NULL ");
		}
		if(obj.getLast_modified_date_ISNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.last_modified_date IS NULL ");
		}

		if(obj.getLast_modified_date_DISTINCT()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ29",obj.getLast_modified_date_DISTINCT());
			sbWhere.append(" obj.last_modified_date <> :OBJ29 ");
		}
	
		if(obj.getLast_modified_date_GREATERTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ30",obj.getLast_modified_date_GREATERTHAN());
			sbWhere.append(" obj.last_modified_date > :OBJ30 ");
		}
	
		if(obj.getLast_modified_date_GREATEROREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ31",obj.getLast_modified_date_GREATEROREQUALTHAN());
			sbWhere.append(" obj.last_modified_date >= :OBJ31 ");
		}
	
		if(obj.getLast_modified_date_LESSTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ32",obj.getLast_modified_date_LESSTHAN());
			sbWhere.append(" obj.last_modified_date < :OBJ32 ");
		}
	
		if(obj.getLast_modified_date_LESSOREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ33",obj.getLast_modified_date_LESSOREQUALTHAN());
			sbWhere.append(" obj.last_modified_date <= :OBJ33 ");
		}

		if(obj.getActivated()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ34",obj.getActivated());
			sbWhere.append(" obj.activated = :OBJ34 ");
		}
		if(obj.getActivated_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ35",obj.getActivated_IN());
			sbWhere.append(" obj.activated IN :OBJ35 ");
		}
		if(obj.getActivated_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ36",obj.getActivated_NOTIN());
			sbWhere.append(" obj.activated NOT IN :OBJ36 ");
		}

		if(obj.getActivation_key()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ37",obj.getActivation_key());
			sbWhere.append(" obj.activation_key = :OBJ37 ");
		}
		if(obj.getActivation_key_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ38",obj.getActivation_key_IN());
			sbWhere.append(" obj.activation_key IN :OBJ38 ");
		}
		if(obj.getActivation_key_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ39",obj.getActivation_key_NOTIN());
			sbWhere.append(" obj.activation_key NOT IN :OBJ39 ");
		}

		if(obj.getActivation_key_ISNOTNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.activation_key IS NOT NULL ");
		}
		if(obj.getActivation_key_ISNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.activation_key IS NULL ");
		}

		if(obj.getActivation_key_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ40",obj.getActivation_key_LIKE());
			sbWhere.append(" obj.activation_key LIKE :OBJ40 ");
		}
		if(obj.getActivation_key_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ41",obj.getActivation_key_NOTLIKE());
			sbWhere.append(" obj.activation_key NOT LIKE :OBJ41 ");
		}

		if(obj.getLogin()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ42",obj.getLogin());
			sbWhere.append(" obj.login = :OBJ42 ");
		}
		if(obj.getLogin_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ43",obj.getLogin_IN());
			sbWhere.append(" obj.login IN :OBJ43 ");
		}
		if(obj.getLogin_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ44",obj.getLogin_NOTIN());
			sbWhere.append(" obj.login NOT IN :OBJ44 ");
		}

		if(obj.getLogin_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ45",obj.getLogin_LIKE());
			sbWhere.append(" obj.login LIKE :OBJ45 ");
		}
		if(obj.getLogin_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ46",obj.getLogin_NOTLIKE());
			sbWhere.append(" obj.login NOT LIKE :OBJ46 ");
		}

		if(obj.getEmail()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ47",obj.getEmail());
			sbWhere.append(" obj.email = :OBJ47 ");
		}
		if(obj.getEmail_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ48",obj.getEmail_IN());
			sbWhere.append(" obj.email IN :OBJ48 ");
		}
		if(obj.getEmail_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ49",obj.getEmail_NOTIN());
			sbWhere.append(" obj.email NOT IN :OBJ49 ");
		}

		if(obj.getEmail_ISNOTNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.email IS NOT NULL ");
		}
		if(obj.getEmail_ISNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.email IS NULL ");
		}

		if(obj.getEmail_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ50",obj.getEmail_LIKE());
			sbWhere.append(" obj.email LIKE :OBJ50 ");
		}
		if(obj.getEmail_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ51",obj.getEmail_NOTLIKE());
			sbWhere.append(" obj.email NOT LIKE :OBJ51 ");
		}

		if(obj.getFirst_name()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ52",obj.getFirst_name());
			sbWhere.append(" obj.first_name = :OBJ52 ");
		}
		if(obj.getFirst_name_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ53",obj.getFirst_name_IN());
			sbWhere.append(" obj.first_name IN :OBJ53 ");
		}
		if(obj.getFirst_name_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ54",obj.getFirst_name_NOTIN());
			sbWhere.append(" obj.first_name NOT IN :OBJ54 ");
		}

		if(obj.getFirst_name_ISNOTNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.first_name IS NOT NULL ");
		}
		if(obj.getFirst_name_ISNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.first_name IS NULL ");
		}

		if(obj.getFirst_name_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ55",obj.getFirst_name_LIKE());
			sbWhere.append(" obj.first_name LIKE :OBJ55 ");
		}
		if(obj.getFirst_name_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ56",obj.getFirst_name_NOTLIKE());
			sbWhere.append(" obj.first_name NOT LIKE :OBJ56 ");
		}

		if(obj.getLast_name()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ57",obj.getLast_name());
			sbWhere.append(" obj.last_name = :OBJ57 ");
		}
		if(obj.getLast_name_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ58",obj.getLast_name_IN());
			sbWhere.append(" obj.last_name IN :OBJ58 ");
		}
		if(obj.getLast_name_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ59",obj.getLast_name_NOTIN());
			sbWhere.append(" obj.last_name NOT IN :OBJ59 ");
		}

		if(obj.getLast_name_ISNOTNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.last_name IS NOT NULL ");
		}
		if(obj.getLast_name_ISNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.last_name IS NULL ");
		}

		if(obj.getLast_name_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ60",obj.getLast_name_LIKE());
			sbWhere.append(" obj.last_name LIKE :OBJ60 ");
		}
		if(obj.getLast_name_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ61",obj.getLast_name_NOTLIKE());
			sbWhere.append(" obj.last_name NOT LIKE :OBJ61 ");
		}

		if(obj.getImage_url()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ62",obj.getImage_url());
			sbWhere.append(" obj.image_url = :OBJ62 ");
		}
		if(obj.getImage_url_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ63",obj.getImage_url_IN());
			sbWhere.append(" obj.image_url IN :OBJ63 ");
		}
		if(obj.getImage_url_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ64",obj.getImage_url_NOTIN());
			sbWhere.append(" obj.image_url NOT IN :OBJ64 ");
		}

		if(obj.getImage_url_ISNOTNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.image_url IS NOT NULL ");
		}
		if(obj.getImage_url_ISNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.image_url IS NULL ");
		}

		if(obj.getImage_url_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ65",obj.getImage_url_LIKE());
			sbWhere.append(" obj.image_url LIKE :OBJ65 ");
		}
		if(obj.getImage_url_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ66",obj.getImage_url_NOTLIKE());
			sbWhere.append(" obj.image_url NOT LIKE :OBJ66 ");
		}

		if(obj.getLang_key()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ67",obj.getLang_key());
			sbWhere.append(" obj.lang_key = :OBJ67 ");
		}
		if(obj.getLang_key_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ68",obj.getLang_key_IN());
			sbWhere.append(" obj.lang_key IN :OBJ68 ");
		}
		if(obj.getLang_key_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ69",obj.getLang_key_NOTIN());
			sbWhere.append(" obj.lang_key NOT IN :OBJ69 ");
		}

		if(obj.getLang_key_ISNOTNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.lang_key IS NOT NULL ");
		}
		if(obj.getLang_key_ISNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.lang_key IS NULL ");
		}

		if(obj.getLang_key_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ70",obj.getLang_key_LIKE());
			sbWhere.append(" obj.lang_key LIKE :OBJ70 ");
		}
		if(obj.getLang_key_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ71",obj.getLang_key_NOTLIKE());
			sbWhere.append(" obj.lang_key NOT LIKE :OBJ71 ");
		}

		if(obj.getPassword_hash()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ72",obj.getPassword_hash());
			sbWhere.append(" obj.password_hash = :OBJ72 ");
		}
		if(obj.getPassword_hash_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ73",obj.getPassword_hash_IN());
			sbWhere.append(" obj.password_hash IN :OBJ73 ");
		}
		if(obj.getPassword_hash_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ74",obj.getPassword_hash_NOTIN());
			sbWhere.append(" obj.password_hash NOT IN :OBJ74 ");
		}

		if(obj.getPassword_hash_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ75",obj.getPassword_hash_LIKE());
			sbWhere.append(" obj.password_hash LIKE :OBJ75 ");
		}
		if(obj.getPassword_hash_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ76",obj.getPassword_hash_NOTLIKE());
			sbWhere.append(" obj.password_hash NOT LIKE :OBJ76 ");
		}

		if(obj.getReset_date()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ77",obj.getReset_date());
			sbWhere.append(" obj.reset_date = :OBJ77 ");
		}
		if(obj.getReset_date_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ78",obj.getReset_date_IN());
			sbWhere.append(" obj.reset_date IN :OBJ78 ");
		}
		if(obj.getReset_date_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ79",obj.getReset_date_NOTIN());
			sbWhere.append(" obj.reset_date NOT IN :OBJ79 ");
		}

		if(obj.getReset_date_ISNOTNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.reset_date IS NOT NULL ");
		}
		if(obj.getReset_date_ISNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.reset_date IS NULL ");
		}

		if(obj.getReset_date_DISTINCT()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ80",obj.getReset_date_DISTINCT());
			sbWhere.append(" obj.reset_date <> :OBJ80 ");
		}
	
		if(obj.getReset_date_GREATERTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ81",obj.getReset_date_GREATERTHAN());
			sbWhere.append(" obj.reset_date > :OBJ81 ");
		}
	
		if(obj.getReset_date_GREATEROREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ82",obj.getReset_date_GREATEROREQUALTHAN());
			sbWhere.append(" obj.reset_date >= :OBJ82 ");
		}
	
		if(obj.getReset_date_LESSTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ83",obj.getReset_date_LESSTHAN());
			sbWhere.append(" obj.reset_date < :OBJ83 ");
		}
	
		if(obj.getReset_date_LESSOREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ84",obj.getReset_date_LESSOREQUALTHAN());
			sbWhere.append(" obj.reset_date <= :OBJ84 ");
		}

		if(obj.getReset_key()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ85",obj.getReset_key());
			sbWhere.append(" obj.reset_key = :OBJ85 ");
		}
		if(obj.getReset_key_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ86",obj.getReset_key_IN());
			sbWhere.append(" obj.reset_key IN :OBJ86 ");
		}
		if(obj.getReset_key_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ87",obj.getReset_key_NOTIN());
			sbWhere.append(" obj.reset_key NOT IN :OBJ87 ");
		}

		if(obj.getReset_key_ISNOTNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.reset_key IS NOT NULL ");
		}
		if(obj.getReset_key_ISNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.reset_key IS NULL ");
		}

		if(obj.getReset_key_LIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ88",obj.getReset_key_LIKE());
			sbWhere.append(" obj.reset_key LIKE :OBJ88 ");
		}
		if(obj.getReset_key_NOTLIKE()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ89",obj.getReset_key_NOTLIKE());
			sbWhere.append(" obj.reset_key NOT LIKE :OBJ89 ");
		}

		if(obj.getTiempoSesion()!=null) 
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ90",obj.getTiempoSesion());
			sbWhere.append(" obj.tiempoSesion = :OBJ90 ");
		}
		if(obj.getTiempoSesion_IN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ91",obj.getTiempoSesion_IN());
			sbWhere.append(" obj.tiempoSesion IN :OBJ91 ");
		}
		if(obj.getTiempoSesion_NOTIN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ92",obj.getTiempoSesion_NOTIN());
			sbWhere.append(" obj.tiempoSesion NOT IN :OBJ92 ");
		}

		if(obj.getTiempoSesion_ISNOTNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.tiempoSesion IS NOT NULL ");
		}
		if(obj.getTiempoSesion_ISNULL())
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			
			sbWhere.append(" obj.tiempoSesion IS NULL ");
		}

		if(obj.getTiempoSesion_DISTINCT()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ93",obj.getTiempoSesion_DISTINCT());
			sbWhere.append(" obj.tiempoSesion <> :OBJ93 ");
		}
	
		if(obj.getTiempoSesion_GREATERTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ94",obj.getTiempoSesion_GREATERTHAN());
			sbWhere.append(" obj.tiempoSesion > :OBJ94 ");
		}
	
		if(obj.getTiempoSesion_GREATEROREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ95",obj.getTiempoSesion_GREATEROREQUALTHAN());
			sbWhere.append(" obj.tiempoSesion >= :OBJ95 ");
		}
	
		if(obj.getTiempoSesion_LESSTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ96",obj.getTiempoSesion_LESSTHAN());
			sbWhere.append(" obj.tiempoSesion < :OBJ96 ");
		}
	
		if(obj.getTiempoSesion_LESSOREQUALTHAN()!=null)
		{
			if(sbWhere.length()>0) sbWhere.append(" AND ");
			params.put("OBJ97",obj.getTiempoSesion_LESSOREQUALTHAN());
			sbWhere.append(" obj.tiempoSesion <= :OBJ97 ");
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
		Query query = em.createQuery(sQuery,J314User.class);
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
			List< J314User > lista=(List< J314User >)query.getResultList();
			int num = lista.size();
	
			Page< J314User > page=new org.sine95.kernel.base.PageBase< J314User >(num,obj.getMaxElemsPerPage(),obj.getPage(),lista);
			res.setData(page);
		}catch(Throwable t)
		{
			res.addError(new ErrorGeneral(t));
			if (log.isErrorEnabled()) log.error("Error por Excepcion. Excepcion:"+UtilException.printStackTrace(t));
		}
		return res;
	}


	public void reset()
	{
		CacheLNService cache=appContext.getBean(CacheLNService.class);
		cache.resetArea(AreasCache.UserFromId);
		cache.resetArea(AreasCache.UserFromLogin);
	}
	public Result<J314User> getUserFromLogin(String login)
	{
		Result<J314User> res=new Result<J314User>();
		J314User userExt=new J314User();
		
		userExt.setLogin(login);
		Result<List<J314User>> lista = listByExample(userExt);
		if(lista.isOk() && lista.getData().size()==1)
		{
			res.setData(lista.getData().get(0));
		}
		else
		{
			res.addError(new ErrorIdNoEncontrado(J314User.class.getName(), login));
		}
		return res;
	}
	public Result<J314User> getUserFromLoginInContext()
	{
		Contexto ctx=Contexto.get();
		return getUserFromLogin(ctx.getAsString(Contexto.LOGIN));
	}


/*


*/
}
