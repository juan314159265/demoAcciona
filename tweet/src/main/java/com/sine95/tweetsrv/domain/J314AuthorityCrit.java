
package com.sine95.tweetsrv.domain;

import java.io.Serializable;
import java.util.List;
import io.github.jhipster.service.filter.*;
import org.sine95.kernel.base.filter.*;




@SuppressWarnings("unused")
public class J314AuthorityCrit implements Serializable {
	private static final long serialVersionUID = 1L;

	private StringFilter name;

	public J314AuthorityCrit setName(StringFilter valor)
	{
		this.name=valor;
		return this;
	}
	
	public J314AuthorityCrit name(StringFilter valor)
	{
		this.name=valor;
		return this;
	}
	
	public StringFilter getName(){
		return this.name;
	}
	
	public StringFilter name(){
		return this.name;
	}

    @Override
    public String toString() {
        return "J314Authority{" +
        "name=" + getName() +
        
        "}";
    }

//Si hay que annadir metodos se incluyen aqui, 
//se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}
