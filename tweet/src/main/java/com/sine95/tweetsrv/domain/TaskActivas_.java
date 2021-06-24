
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
@StaticMetamodel(TaskActivas.class)
public abstract class TaskActivas_  {

	public static volatile SingularAttribute< TaskActivas, Long > id;	

	public static volatile SingularAttribute< TaskActivas, TareasPeriodicas > tarea;	

	public static volatile SingularAttribute< TaskActivas, SiNo > activa;	


}

