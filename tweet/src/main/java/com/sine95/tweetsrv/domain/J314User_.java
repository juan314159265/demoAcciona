
package com.sine95.tweetsrv.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.math.*;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


import com.sine95.tweetsrv.enums.*;


@SuppressWarnings("unused")
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(J314User.class)
public abstract class J314User_  {

	public static volatile SingularAttribute< J314User, Long > id;	

	public static volatile SingularAttribute< J314User, String > created_by;	

	public static volatile SingularAttribute< J314User, Date > created_date;	

	public static volatile SingularAttribute< J314User, String > last_modified_by;	

	public static volatile SingularAttribute< J314User, Date > last_modified_date;	

	public static volatile SingularAttribute< J314User, SiNo > activated;	

	public static volatile SingularAttribute< J314User, String > activation_key;	

	public static volatile SingularAttribute< J314User, String > login;	

	public static volatile SingularAttribute< J314User, String > email;	

	public static volatile SingularAttribute< J314User, String > first_name;	

	public static volatile SingularAttribute< J314User, String > last_name;	

	public static volatile SingularAttribute< J314User, String > image_url;	

	public static volatile SingularAttribute< J314User, String > lang_key;	

	public static volatile SingularAttribute< J314User, String > password_hash;	

	public static volatile SingularAttribute< J314User, Date > reset_date;	

	public static volatile SingularAttribute< J314User, String > reset_key;	

	public static volatile SingularAttribute< J314User, Long > tiempoSesion;	


}

