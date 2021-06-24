
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
import com.sine95.tweetsrv.repository.J314UserAuthorityRepository;
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






import org.sine95.kernel.util.JSON;

//Repository relacionado
import com.sine95.tweetsrv.repository.J314AuthorityRepository;

//Repository relacionado
import com.sine95.tweetsrv.repository.J314UserRepository;


@Service
//@Transactional
@SuppressWarnings("unused")
public class J314UserAuthorityServiceCRUD extends ServiceCRUD< J314UserAuthority ,J314UserAuthorityId > {

	private final Logger log = LoggerFactory.getLogger(J314UserAuthorityServiceCRUD.class);



	@Autowired
    protected EntityManager entityManager;

	@Autowired
    protected ApplicationContext appContext;

	

	
	@Autowired
	private J314UserAuthorityRepository repository;
	
	@Autowired
	private J314AuthorityRepository j314authority_repository;
	
	@Autowired
	private J314UserRepository j314user_repository;
	

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public J314UserAuthorityRepository  getRepositoryPublic(){
		return repository;
	}

	public J314UserAuthorityServiceCRUD() {
		super();
		addValidator(new J314UserAuthorityValidator(this));


		
		
	}

	@Override
	public String getCRUDName()
	{
		return "J314UserAuthority";
	}	

	@Override
	public Result<List< J314UserAuthority >> listByExample(J314UserAuthority example) {

		Result<List< J314UserAuthority >> res=new Result<>();
		try {
			Example< J314UserAuthority > examp=Example.of(example);
			res.setData(repository.findAll(examp));

		}catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}
	
	public Result<Vacio> delete(J314UserAuthorityId id) {
		Result<Vacio> res=new Result<>();
		if (id==null) {
			res.addError(new ErrorCampoObligatorio("J314UserAuthority","id"));
			return res;
		}
		// Levantamos la J314UserAuthority
		Result< J314UserAuthority > rI = findWithResult(id);
		if (!rI.isOk()) return res.copyStatus(rI);
		J314UserAuthority i = rI.getData();
		// Eliminamos la J314UserAuthority
		try {
			res.copyStatus(delete(i));
		} catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	public Result<Page< J314UserAuthority >> listByExample(J314UserAuthority example, Pageable page) {

		Result<Page< J314UserAuthority >> res=new Result<>();
		try {
			Example< J314UserAuthority > examp=Example.of(example);
			res.setData(repository.findAll(examp,page));

		}catch(Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}

	@Override
	protected RepositoryBase< J314UserAuthority , J314UserAuthorityId > getRepository()
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
	protected J314UserAuthority findWithNull(J314UserAuthorityId id) throws IllegalArgumentException
	{
		Optional< J314UserAuthority > optional = repository.findById(id);
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
	public Result< J314UserAuthority > findWithResult(J314UserAuthorityId id)
	{
		Result< J314UserAuthority > res = new Result<>();
		J314UserAuthority o = null;
		try {
			o = findWithNull(id);
		} catch (IllegalArgumentException iae) {
			res.addError(new ErrorParamObligatorio("id"));
		} catch (Exception e) {
			res.addError(new ErrorGeneral(e));
		}
		if (o==null) res.addError(new ErrorIdNoEncontrado("J314UserAuthority",id));
	
		res.setData(o);
		return res;
	}

	@Override
	protected Result< J314UserAuthority > findWithResultFromObject(J314UserAuthority obj)
	{

		return findWithResult(obj.getId());
	}
	
	



	@Override
	protected Result< Vacio > copyFieldsUpdate(J314UserAuthority src, J314UserAuthority dest)
	{

		Result< Vacio > res = new Result<>();
		res.setData(new Vacio());
		return res;
	}

    /**
     * Return a {@link List} of {@link J314UserAuthority } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    public Result< List< J314UserAuthority >> listByCriteria(J314UserAuthorityCrit criteria) {
				Result<List< J314UserAuthority >> res=new Result<>();
				try {
					if (log.isInfoEnabled()) log.info("find by criteria : {}", criteria);
	        final Specification< J314UserAuthority > specification = createSpecification(criteria);
					res.setData(repository.findAll(specification));
				}catch(Exception e)
				{
					res.addError(new ErrorGeneral(e));
				}
				return res;
    }

    /**
     * Return a {@link Page} of {@link J314UserAuthority } which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    public  Result< Page< J314UserAuthority >> listByCriteriaPaged(J314UserAuthorityCritPaged criteria) {
			Result<Page< J314UserAuthority >> res=new Result<>();
			try {
				J314UserAuthorityCrit crit = criteria.getCrit();
				Pageable pag = criteria.getPag();

				
				
				
        		if (log.isInfoEnabled()) log.info("find by criteria : {}, page: {}", crit, pag);
        		final Specification< J314UserAuthority > specification = createSpecification(crit);
        		res.setData(repository.findAll(specification, pag));
			}catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
			}
			return res;
    }
/*
	@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
	@StaticMetamodel(J314UserAuthority.class)
	public abstract class J314UserAuthority_ {
		
		public static volatile SingularAttribute< J314UserAuthority , Long > usuario;
		
		public static volatile SingularAttribute< J314UserAuthority , String > authority;
		

	}*/
    /**
     * Function to convert J314UserAuthorityCriteria to a {@link Specification}
     */
    private Specification< J314UserAuthority > createSpecification(J314UserAuthorityCrit criteria) {
        Specification< J314UserAuthority > specification = Specification.where(null);
        if (criteria != null) {

        }
        return specification;
    }

// Metodos para gestionar las relaciones

	public Result<Vacio> delete(Long authoritiesId, String usersId) {
		J314UserAuthorityId id = null;
		try {
			id = new J314UserAuthorityId(authoritiesId, usersId);
		}catch(Exception e)
		{
			Result<Vacio> res=new Result<>();
			res.addError(new ErrorGeneral(e));
			return res;
		}
		return delete(id);
	}
	
	public Result<List<Map<String,Object>>> getRelacion(J314UserAuthority ejemplo)
	{
		Result<List<Map<String, Object>>> res=new Result<>();
		Result<List< J314UserAuthority >> resAux = listByExample(ejemplo);
		if(resAux.isOk())
		{
			try {
	  		List<Map<String, Object>> data=new ArrayList<>();
	  		for(J314UserAuthority datum:resAux.getData())
	  		{
	  			Map<String, Object> map = JSON.toMap(datum);
	
					
	
	  			data.add(map);
	  		}
			res.setData(data);
			}catch(Exception e)
			{
				res.addError(new ErrorGeneral(e));
			}
		}
		else
		{
			res.addErrores(resAux.getErrores());
			res.addWarnings(resAux.getWarnings());
		}
		return res;
	}


	/**
	 * Crea una instancia de la relación a partir del id de cada uno de los extremos y un objeto propio de relacion.

	 * @param usuarioId
	 * @param authorityId
	 * @param obj
	 * @return Un result con la instancia creada o null en caso de ocurrir algún problema. Los errores posibles son:
	 *  - ErrorParamObligatorio si alguno de los id o la instancia de la relación son null
	 *  - ErrorIdNoEncontrado si no se puede recuperar la instacia asociada a alguno de los ids de los extremos
	 *  - ErrorGeneral en caso de lanzarse alguna excepción
	 */
	public Result< J314UserAuthority > create(Long usuarioId, String authorityId, J314UserAuthority obj)
	{
		Result< J314UserAuthority > res = new Result<>();
		if (obj == null) return res.addError(new ErrorParamObligatorio("obj"));
		J314UserAuthority _obj = null;
		try {

			if (usuarioId == null) return res.addError(new ErrorParamObligatorio("usuarioId"));
			Optional< J314User > usuario = j314user_repository.findById(usuarioId);
			if (!usuario.isPresent()) return res.addError(new ErrorIdNoEncontrado("J314User",usuarioId));


			if (authorityId == null) return res.addError(new ErrorParamObligatorio("authorityId"));
			Optional< J314Authority > authority = j314authority_repository.findById(authorityId);
			if (!authority.isPresent()) return res.addError(new ErrorIdNoEncontrado("J314Authority",authorityId));


			_obj = new J314UserAuthority(usuario.get(), authority.get());

			repository.save(_obj);
		} catch(Exception e)
		{
			return res.addError(new ErrorGeneral(e));
		}

		res.setData(_obj);
		return res;
	}

	/**
	 * Elimina una instancia de la relación a partir del id de cada uno de los extremos.

	 * @param usuarioId

	 * @param authorityId

	 * @return Un result vacío. Los errores posibles son:
	 *  - ErrorParamObligatorio si alguno de los id es null
	 *  - ErrorIdNoEncontrado si no se puede recuperar la instacia asociada a alguno de los ids de los extremos
	 *  - ErrorGeneral en caso de lanzarse alguna excepción
	 */
	public Result< Vacio > remove(Long usuarioId, String authorityId)
	{
		Result< Vacio > res = new Result<>();

		if (usuarioId == null) return res.addError(new ErrorParamObligatorio("usuarioId"));

		if (authorityId == null) return res.addError(new ErrorParamObligatorio("authorityId"));

		J314UserAuthorityId id = new J314UserAuthorityId(usuarioId, authorityId);
		try {
			repository.deleteById(id);
		} catch (Exception e)
		{
			res.addError(new ErrorGeneral(e));
		}
		return res;
	}
	
	/**
	 * Obtiene una instancia de la relación a partir del id de cada uno de los extremos.

	 * @param usuarioId

	 * @param authorityId

	 * @return Un result con la instancia o con un null si hubo algún problema. Los errores posibles son:
	 *  - ErrorParamObligatorio si alguno de los id es null
	 *  - ErrorIdNoEncontrado si no se puede recuperar la instacia asociada a alguno de los ids de los extremos
	 *  - ErrorGeneral en caso de lanzarse alguna excepción
	 */
	public Result< J314UserAuthority > get(Long usuarioId, String authorityId)
	{
		Result< J314UserAuthority > res = new Result<>();

		if (usuarioId == null) return res.addError(new ErrorParamObligatorio("usuarioId"));

		if (authorityId == null) return res.addError(new ErrorParamObligatorio("authorityId"));

		J314UserAuthorityId id = new J314UserAuthorityId(usuarioId, authorityId);
		return findWithResult(id);
	}
	
	/**
	 * Establece nuevos valores de una de la relación a partir del id de cada uno de los extremos y un objeto 
	 * propio de relacion, sin id, es decir que sólo contiene los información de los atributos propios de la relación.

	 * @param usuarioId
	 * @param authorityId
	 * @param obj
	 * @return Un result con la instancia creada o null en caso de ocurrir algún problema. Los errores posibles son:
	 *  - ErrorParamObligatorio si alguno de los id o la instancia de la relación son null
	 *  - ErrorIdNoEncontrado si no se puede recuperar la instacia asociada a alguno de los ids de los extremos
	 *  - ErrorGeneral en caso de lanzarse alguna excepción
	 */
	public Result< J314UserAuthority > update(Long usuarioId, String authorityId, J314UserAuthority obj)
	{
		if (obj == null) return new Result< J314UserAuthority >().addError(new ErrorParamObligatorio("obj"));
		J314UserAuthorityId id = new J314UserAuthorityId(usuarioId, authorityId);
		obj.setId(id);
		return super.update(obj);
	}





// Campo de relacion. Nombre: usuario; Tipo: MAN; Navegacion: A; Entidad remota: J314User

	public Result< J314User > getUsuario(Long usuario, String authority)
	{
		Result< J314User > res=new Result<>();
		Result < J314UserAuthority > ro = get(usuario,authority);
		if (ro.isOk()) {
			res.setData(ro.getData().getUsuario());
		}
		return res;
	}

// HASTA AQUI Campo de relacion. Nombre usuario; Tipo: MAN; Navegacion: A; Entidad remota: J314User

// Campo de relacion. Nombre: authority; Tipo: MAN; Navegacion: A; Entidad remota: J314Authority

	public Result< J314Authority > getAuthority(Long usuario, String authority)
	{
		Result< J314Authority > res=new Result<>();
		Result < J314UserAuthority > ro = get(usuario,authority);
		if (ro.isOk()) {
			res.setData(ro.getData().getAuthority());
		}
		return res;
	}

// HASTA AQUI Campo de relacion. Nombre authority; Tipo: MAN; Navegacion: A; Entidad remota: J314Authority


	//@Override
	public void preInsert(J314UserAuthority data) {
		
		
	}

	//@Override
	public void preUpdate(J314UserAuthority data,J314UserAuthority userData,Result< J314UserAuthority > res) {
		
			
	}

	//@Override
	public void preDelete(J314UserAuthority data) {
		
		
	}

	@Override
	public void postInsert(J314UserAuthority data) {
		
		
	}

	@Override
	public void postUpdate(J314UserAuthority data) {
		
			
	}

	@Override
	public void postDelete(J314UserAuthority data) {
		
		
	}

// LN DE CRUD

// FIN DE LN DE CRUD




/*


*/
}
