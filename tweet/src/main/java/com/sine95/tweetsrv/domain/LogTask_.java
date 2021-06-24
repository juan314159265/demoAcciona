
package com.sine95.tweetsrv.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.math.*;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;



@SuppressWarnings("unused")
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LogTask.class)
public abstract class LogTask_  {

	public static volatile SingularAttribute< LogTask, Long > id;	

	public static volatile SingularAttribute< LogTask, Date > horaInicio;	

	public static volatile SingularAttribute< LogTask, Date > horaFin;	

	public static volatile SingularAttribute< LogTask, String > clase;	

	public static volatile SingularAttribute< LogTask, String > metodo;	

	public static volatile SingularAttribute< LogTask, String > errores;	

	public static volatile SingularAttribute< LogTask, String > warnings;	

	public static volatile SingularAttribute< LogTask, String > infos;	


}

