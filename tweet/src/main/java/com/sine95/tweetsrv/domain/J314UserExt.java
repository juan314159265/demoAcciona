
package com.sine95.tweetsrv.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.*;
import java.math.*;


import com.sine95.tweetsrv.enums.*;





/**
* *Comentarios*
*/

@SuppressWarnings("unused")
public class J314UserExt  implements Serializable
{
	private static final long serialVersionUID = 1L;

	//id
	private Long id;
	private Collection< Long > id_IN;
	private Collection< Long > id_NOTIN;

	public Long getId()
	{
		return id;
	}
	public J314UserExt setId(Long _id)
	{
		id=_id;
		return this;
	}
	public Collection< Long > getId_IN()
	{
		return id_IN;
	}
	public J314UserExt setId_IN(Collection< Long > _id)
	{
		id_IN=_id;
		return this;
	}
	public Collection< Long > getId_NOTIN()
	{
		return id_NOTIN;
	}
	public J314UserExt setId_NOTIN(Collection< Long > _id)
	{
		id_NOTIN=_id;
		return this;
	}





	private Long id_DISTINCT;
	private Long id_GREATERTHAN;
	private Long id_GREATEROREQUALTHAN;
	private Long id_LESSTHAN;
	private Long id_LESSOREQUALTHAN;

	public Long getId_DISTINCT()
	{
		return id_DISTINCT;
	}
	public J314UserExt setId_DISTINCT(Long _id)
	{
		id_DISTINCT=_id;
		return this;
	}

	public Long getId_GREATERTHAN()
	{
		return id_GREATERTHAN;
	}
	public J314UserExt setId_GREATERTHAN(Long _id)
	{
		id_GREATERTHAN=_id;
		return this;
	}

	public Long getId_GREATEROREQUALTHAN()
	{
		return id_GREATEROREQUALTHAN;
	}
	public J314UserExt setId_GREATEROREQUALTHAN(Long _id)
	{
		id_GREATEROREQUALTHAN=_id;
		return this;
	}

	public Long getId_LESSTHAN()
	{
		return id_LESSTHAN;
	}
	public J314UserExt setId_LESSTHAN(Long _id)
	{
		id_LESSTHAN=_id;
		return this;
	}

	public Long getId_LESSOREQUALTHAN()
	{
		return id_LESSOREQUALTHAN;
	}
	public J314UserExt setId_LESSOREQUALTHAN(Long _id)
	{
		id_LESSOREQUALTHAN=_id;
		return this;
	}



	//created_by
	private String created_by;
	private Collection< String > created_by_IN;
	private Collection< String > created_by_NOTIN;

	public String getCreated_by()
	{
		return created_by;
	}
	public J314UserExt setCreated_by(String _created_by)
	{
		created_by=_created_by;
		return this;
	}
	public Collection< String > getCreated_by_IN()
	{
		return created_by_IN;
	}
	public J314UserExt setCreated_by_IN(Collection< String > _created_by)
	{
		created_by_IN=_created_by;
		return this;
	}
	public Collection< String > getCreated_by_NOTIN()
	{
		return created_by_NOTIN;
	}
	public J314UserExt setCreated_by_NOTIN(Collection< String > _created_by)
	{
		created_by_NOTIN=_created_by;
		return this;
	}



	private String created_by_LIKE;
	private String created_by_NOTLIKE;

	public String getCreated_by_LIKE()
	{
		return created_by_LIKE;
	}
	public J314UserExt setCreated_by_LIKE(String _created_by)
	{
		created_by_LIKE=_created_by;
		return this;
	}
	public String getCreated_by_NOTLIKE()
	{
		return created_by_NOTLIKE;
	}
	public J314UserExt setCreated_by_NOTLIKE(String _created_by)
	{
		created_by_NOTLIKE=_created_by;
		return this;
	}





	//created_date
	private Date created_date;
	private Collection< Date > created_date_IN;
	private Collection< Date > created_date_NOTIN;

	public Date getCreated_date()
	{
		return created_date;
	}
	public J314UserExt setCreated_date(Date _created_date)
	{
		created_date=_created_date;
		return this;
	}
	public Collection< Date > getCreated_date_IN()
	{
		return created_date_IN;
	}
	public J314UserExt setCreated_date_IN(Collection< Date > _created_date)
	{
		created_date_IN=_created_date;
		return this;
	}
	public Collection< Date > getCreated_date_NOTIN()
	{
		return created_date_NOTIN;
	}
	public J314UserExt setCreated_date_NOTIN(Collection< Date > _created_date)
	{
		created_date_NOTIN=_created_date;
		return this;
	}





	private Date created_date_DISTINCT;
	private Date created_date_GREATERTHAN;
	private Date created_date_GREATEROREQUALTHAN;
	private Date created_date_LESSTHAN;
	private Date created_date_LESSOREQUALTHAN;

	public Date getCreated_date_DISTINCT()
	{
		return created_date_DISTINCT;
	}
	public J314UserExt setCreated_date_DISTINCT(Date _created_date)
	{
		created_date_DISTINCT=_created_date;
		return this;
	}

	public Date getCreated_date_GREATERTHAN()
	{
		return created_date_GREATERTHAN;
	}
	public J314UserExt setCreated_date_GREATERTHAN(Date _created_date)
	{
		created_date_GREATERTHAN=_created_date;
		return this;
	}

	public Date getCreated_date_GREATEROREQUALTHAN()
	{
		return created_date_GREATEROREQUALTHAN;
	}
	public J314UserExt setCreated_date_GREATEROREQUALTHAN(Date _created_date)
	{
		created_date_GREATEROREQUALTHAN=_created_date;
		return this;
	}

	public Date getCreated_date_LESSTHAN()
	{
		return created_date_LESSTHAN;
	}
	public J314UserExt setCreated_date_LESSTHAN(Date _created_date)
	{
		created_date_LESSTHAN=_created_date;
		return this;
	}

	public Date getCreated_date_LESSOREQUALTHAN()
	{
		return created_date_LESSOREQUALTHAN;
	}
	public J314UserExt setCreated_date_LESSOREQUALTHAN(Date _created_date)
	{
		created_date_LESSOREQUALTHAN=_created_date;
		return this;
	}



	//last_modified_by
	private String last_modified_by;
	private Collection< String > last_modified_by_IN;
	private Collection< String > last_modified_by_NOTIN;

	public String getLast_modified_by()
	{
		return last_modified_by;
	}
	public J314UserExt setLast_modified_by(String _last_modified_by)
	{
		last_modified_by=_last_modified_by;
		return this;
	}
	public Collection< String > getLast_modified_by_IN()
	{
		return last_modified_by_IN;
	}
	public J314UserExt setLast_modified_by_IN(Collection< String > _last_modified_by)
	{
		last_modified_by_IN=_last_modified_by;
		return this;
	}
	public Collection< String > getLast_modified_by_NOTIN()
	{
		return last_modified_by_NOTIN;
	}
	public J314UserExt setLast_modified_by_NOTIN(Collection< String > _last_modified_by)
	{
		last_modified_by_NOTIN=_last_modified_by;
		return this;
	}

	private boolean last_modified_by_ISNOTNULL;
	private boolean last_modified_by_ISNULL;

	public boolean getLast_modified_by_ISNOTNULL()
	{
		return last_modified_by_ISNOTNULL;
	}
	public J314UserExt setLast_modified_by_ISNOTNULL(boolean _last_modified_by)
	{
		last_modified_by_ISNOTNULL=_last_modified_by;
		return this;
	}
	public boolean getLast_modified_by_ISNULL()
	{
		return last_modified_by_ISNULL;
	}
	public J314UserExt setLast_modified_by_ISNULL(boolean _last_modified_by)
	{
		last_modified_by_ISNULL=_last_modified_by;
		return this;
	}



	private String last_modified_by_LIKE;
	private String last_modified_by_NOTLIKE;

	public String getLast_modified_by_LIKE()
	{
		return last_modified_by_LIKE;
	}
	public J314UserExt setLast_modified_by_LIKE(String _last_modified_by)
	{
		last_modified_by_LIKE=_last_modified_by;
		return this;
	}
	public String getLast_modified_by_NOTLIKE()
	{
		return last_modified_by_NOTLIKE;
	}
	public J314UserExt setLast_modified_by_NOTLIKE(String _last_modified_by)
	{
		last_modified_by_NOTLIKE=_last_modified_by;
		return this;
	}





	//last_modified_date
	private Date last_modified_date;
	private Collection< Date > last_modified_date_IN;
	private Collection< Date > last_modified_date_NOTIN;

	public Date getLast_modified_date()
	{
		return last_modified_date;
	}
	public J314UserExt setLast_modified_date(Date _last_modified_date)
	{
		last_modified_date=_last_modified_date;
		return this;
	}
	public Collection< Date > getLast_modified_date_IN()
	{
		return last_modified_date_IN;
	}
	public J314UserExt setLast_modified_date_IN(Collection< Date > _last_modified_date)
	{
		last_modified_date_IN=_last_modified_date;
		return this;
	}
	public Collection< Date > getLast_modified_date_NOTIN()
	{
		return last_modified_date_NOTIN;
	}
	public J314UserExt setLast_modified_date_NOTIN(Collection< Date > _last_modified_date)
	{
		last_modified_date_NOTIN=_last_modified_date;
		return this;
	}

	private boolean last_modified_date_ISNOTNULL;
	private boolean last_modified_date_ISNULL;

	public boolean getLast_modified_date_ISNOTNULL()
	{
		return last_modified_date_ISNOTNULL;
	}
	public J314UserExt setLast_modified_date_ISNOTNULL(boolean _last_modified_date)
	{
		last_modified_date_ISNOTNULL=_last_modified_date;
		return this;
	}
	public boolean getLast_modified_date_ISNULL()
	{
		return last_modified_date_ISNULL;
	}
	public J314UserExt setLast_modified_date_ISNULL(boolean _last_modified_date)
	{
		last_modified_date_ISNULL=_last_modified_date;
		return this;
	}





	private Date last_modified_date_DISTINCT;
	private Date last_modified_date_GREATERTHAN;
	private Date last_modified_date_GREATEROREQUALTHAN;
	private Date last_modified_date_LESSTHAN;
	private Date last_modified_date_LESSOREQUALTHAN;

	public Date getLast_modified_date_DISTINCT()
	{
		return last_modified_date_DISTINCT;
	}
	public J314UserExt setLast_modified_date_DISTINCT(Date _last_modified_date)
	{
		last_modified_date_DISTINCT=_last_modified_date;
		return this;
	}

	public Date getLast_modified_date_GREATERTHAN()
	{
		return last_modified_date_GREATERTHAN;
	}
	public J314UserExt setLast_modified_date_GREATERTHAN(Date _last_modified_date)
	{
		last_modified_date_GREATERTHAN=_last_modified_date;
		return this;
	}

	public Date getLast_modified_date_GREATEROREQUALTHAN()
	{
		return last_modified_date_GREATEROREQUALTHAN;
	}
	public J314UserExt setLast_modified_date_GREATEROREQUALTHAN(Date _last_modified_date)
	{
		last_modified_date_GREATEROREQUALTHAN=_last_modified_date;
		return this;
	}

	public Date getLast_modified_date_LESSTHAN()
	{
		return last_modified_date_LESSTHAN;
	}
	public J314UserExt setLast_modified_date_LESSTHAN(Date _last_modified_date)
	{
		last_modified_date_LESSTHAN=_last_modified_date;
		return this;
	}

	public Date getLast_modified_date_LESSOREQUALTHAN()
	{
		return last_modified_date_LESSOREQUALTHAN;
	}
	public J314UserExt setLast_modified_date_LESSOREQUALTHAN(Date _last_modified_date)
	{
		last_modified_date_LESSOREQUALTHAN=_last_modified_date;
		return this;
	}



	//activated
	private SiNo activated;
	private Collection< SiNo > activated_IN;
	private Collection< SiNo > activated_NOTIN;

	public SiNo getActivated()
	{
		return activated;
	}
	public J314UserExt setActivated(SiNo _activated)
	{
		activated=_activated;
		return this;
	}
	public Collection< SiNo > getActivated_IN()
	{
		return activated_IN;
	}
	public J314UserExt setActivated_IN(Collection< SiNo > _activated)
	{
		activated_IN=_activated;
		return this;
	}
	public Collection< SiNo > getActivated_NOTIN()
	{
		return activated_NOTIN;
	}
	public J314UserExt setActivated_NOTIN(Collection< SiNo > _activated)
	{
		activated_NOTIN=_activated;
		return this;
	}







	//activation_key
	private String activation_key;
	private Collection< String > activation_key_IN;
	private Collection< String > activation_key_NOTIN;

	public String getActivation_key()
	{
		return activation_key;
	}
	public J314UserExt setActivation_key(String _activation_key)
	{
		activation_key=_activation_key;
		return this;
	}
	public Collection< String > getActivation_key_IN()
	{
		return activation_key_IN;
	}
	public J314UserExt setActivation_key_IN(Collection< String > _activation_key)
	{
		activation_key_IN=_activation_key;
		return this;
	}
	public Collection< String > getActivation_key_NOTIN()
	{
		return activation_key_NOTIN;
	}
	public J314UserExt setActivation_key_NOTIN(Collection< String > _activation_key)
	{
		activation_key_NOTIN=_activation_key;
		return this;
	}

	private boolean activation_key_ISNOTNULL;
	private boolean activation_key_ISNULL;

	public boolean getActivation_key_ISNOTNULL()
	{
		return activation_key_ISNOTNULL;
	}
	public J314UserExt setActivation_key_ISNOTNULL(boolean _activation_key)
	{
		activation_key_ISNOTNULL=_activation_key;
		return this;
	}
	public boolean getActivation_key_ISNULL()
	{
		return activation_key_ISNULL;
	}
	public J314UserExt setActivation_key_ISNULL(boolean _activation_key)
	{
		activation_key_ISNULL=_activation_key;
		return this;
	}



	private String activation_key_LIKE;
	private String activation_key_NOTLIKE;

	public String getActivation_key_LIKE()
	{
		return activation_key_LIKE;
	}
	public J314UserExt setActivation_key_LIKE(String _activation_key)
	{
		activation_key_LIKE=_activation_key;
		return this;
	}
	public String getActivation_key_NOTLIKE()
	{
		return activation_key_NOTLIKE;
	}
	public J314UserExt setActivation_key_NOTLIKE(String _activation_key)
	{
		activation_key_NOTLIKE=_activation_key;
		return this;
	}





	//login
	private String login;
	private Collection< String > login_IN;
	private Collection< String > login_NOTIN;

	public String getLogin()
	{
		return login;
	}
	public J314UserExt setLogin(String _login)
	{
		login=_login;
		return this;
	}
	public Collection< String > getLogin_IN()
	{
		return login_IN;
	}
	public J314UserExt setLogin_IN(Collection< String > _login)
	{
		login_IN=_login;
		return this;
	}
	public Collection< String > getLogin_NOTIN()
	{
		return login_NOTIN;
	}
	public J314UserExt setLogin_NOTIN(Collection< String > _login)
	{
		login_NOTIN=_login;
		return this;
	}



	private String login_LIKE;
	private String login_NOTLIKE;

	public String getLogin_LIKE()
	{
		return login_LIKE;
	}
	public J314UserExt setLogin_LIKE(String _login)
	{
		login_LIKE=_login;
		return this;
	}
	public String getLogin_NOTLIKE()
	{
		return login_NOTLIKE;
	}
	public J314UserExt setLogin_NOTLIKE(String _login)
	{
		login_NOTLIKE=_login;
		return this;
	}





	//email
	private String email;
	private Collection< String > email_IN;
	private Collection< String > email_NOTIN;

	public String getEmail()
	{
		return email;
	}
	public J314UserExt setEmail(String _email)
	{
		email=_email;
		return this;
	}
	public Collection< String > getEmail_IN()
	{
		return email_IN;
	}
	public J314UserExt setEmail_IN(Collection< String > _email)
	{
		email_IN=_email;
		return this;
	}
	public Collection< String > getEmail_NOTIN()
	{
		return email_NOTIN;
	}
	public J314UserExt setEmail_NOTIN(Collection< String > _email)
	{
		email_NOTIN=_email;
		return this;
	}

	private boolean email_ISNOTNULL;
	private boolean email_ISNULL;

	public boolean getEmail_ISNOTNULL()
	{
		return email_ISNOTNULL;
	}
	public J314UserExt setEmail_ISNOTNULL(boolean _email)
	{
		email_ISNOTNULL=_email;
		return this;
	}
	public boolean getEmail_ISNULL()
	{
		return email_ISNULL;
	}
	public J314UserExt setEmail_ISNULL(boolean _email)
	{
		email_ISNULL=_email;
		return this;
	}



	private String email_LIKE;
	private String email_NOTLIKE;

	public String getEmail_LIKE()
	{
		return email_LIKE;
	}
	public J314UserExt setEmail_LIKE(String _email)
	{
		email_LIKE=_email;
		return this;
	}
	public String getEmail_NOTLIKE()
	{
		return email_NOTLIKE;
	}
	public J314UserExt setEmail_NOTLIKE(String _email)
	{
		email_NOTLIKE=_email;
		return this;
	}





	//first_name
	private String first_name;
	private Collection< String > first_name_IN;
	private Collection< String > first_name_NOTIN;

	public String getFirst_name()
	{
		return first_name;
	}
	public J314UserExt setFirst_name(String _first_name)
	{
		first_name=_first_name;
		return this;
	}
	public Collection< String > getFirst_name_IN()
	{
		return first_name_IN;
	}
	public J314UserExt setFirst_name_IN(Collection< String > _first_name)
	{
		first_name_IN=_first_name;
		return this;
	}
	public Collection< String > getFirst_name_NOTIN()
	{
		return first_name_NOTIN;
	}
	public J314UserExt setFirst_name_NOTIN(Collection< String > _first_name)
	{
		first_name_NOTIN=_first_name;
		return this;
	}

	private boolean first_name_ISNOTNULL;
	private boolean first_name_ISNULL;

	public boolean getFirst_name_ISNOTNULL()
	{
		return first_name_ISNOTNULL;
	}
	public J314UserExt setFirst_name_ISNOTNULL(boolean _first_name)
	{
		first_name_ISNOTNULL=_first_name;
		return this;
	}
	public boolean getFirst_name_ISNULL()
	{
		return first_name_ISNULL;
	}
	public J314UserExt setFirst_name_ISNULL(boolean _first_name)
	{
		first_name_ISNULL=_first_name;
		return this;
	}



	private String first_name_LIKE;
	private String first_name_NOTLIKE;

	public String getFirst_name_LIKE()
	{
		return first_name_LIKE;
	}
	public J314UserExt setFirst_name_LIKE(String _first_name)
	{
		first_name_LIKE=_first_name;
		return this;
	}
	public String getFirst_name_NOTLIKE()
	{
		return first_name_NOTLIKE;
	}
	public J314UserExt setFirst_name_NOTLIKE(String _first_name)
	{
		first_name_NOTLIKE=_first_name;
		return this;
	}





	//last_name
	private String last_name;
	private Collection< String > last_name_IN;
	private Collection< String > last_name_NOTIN;

	public String getLast_name()
	{
		return last_name;
	}
	public J314UserExt setLast_name(String _last_name)
	{
		last_name=_last_name;
		return this;
	}
	public Collection< String > getLast_name_IN()
	{
		return last_name_IN;
	}
	public J314UserExt setLast_name_IN(Collection< String > _last_name)
	{
		last_name_IN=_last_name;
		return this;
	}
	public Collection< String > getLast_name_NOTIN()
	{
		return last_name_NOTIN;
	}
	public J314UserExt setLast_name_NOTIN(Collection< String > _last_name)
	{
		last_name_NOTIN=_last_name;
		return this;
	}

	private boolean last_name_ISNOTNULL;
	private boolean last_name_ISNULL;

	public boolean getLast_name_ISNOTNULL()
	{
		return last_name_ISNOTNULL;
	}
	public J314UserExt setLast_name_ISNOTNULL(boolean _last_name)
	{
		last_name_ISNOTNULL=_last_name;
		return this;
	}
	public boolean getLast_name_ISNULL()
	{
		return last_name_ISNULL;
	}
	public J314UserExt setLast_name_ISNULL(boolean _last_name)
	{
		last_name_ISNULL=_last_name;
		return this;
	}



	private String last_name_LIKE;
	private String last_name_NOTLIKE;

	public String getLast_name_LIKE()
	{
		return last_name_LIKE;
	}
	public J314UserExt setLast_name_LIKE(String _last_name)
	{
		last_name_LIKE=_last_name;
		return this;
	}
	public String getLast_name_NOTLIKE()
	{
		return last_name_NOTLIKE;
	}
	public J314UserExt setLast_name_NOTLIKE(String _last_name)
	{
		last_name_NOTLIKE=_last_name;
		return this;
	}





	//image_url
	private String image_url;
	private Collection< String > image_url_IN;
	private Collection< String > image_url_NOTIN;

	public String getImage_url()
	{
		return image_url;
	}
	public J314UserExt setImage_url(String _image_url)
	{
		image_url=_image_url;
		return this;
	}
	public Collection< String > getImage_url_IN()
	{
		return image_url_IN;
	}
	public J314UserExt setImage_url_IN(Collection< String > _image_url)
	{
		image_url_IN=_image_url;
		return this;
	}
	public Collection< String > getImage_url_NOTIN()
	{
		return image_url_NOTIN;
	}
	public J314UserExt setImage_url_NOTIN(Collection< String > _image_url)
	{
		image_url_NOTIN=_image_url;
		return this;
	}

	private boolean image_url_ISNOTNULL;
	private boolean image_url_ISNULL;

	public boolean getImage_url_ISNOTNULL()
	{
		return image_url_ISNOTNULL;
	}
	public J314UserExt setImage_url_ISNOTNULL(boolean _image_url)
	{
		image_url_ISNOTNULL=_image_url;
		return this;
	}
	public boolean getImage_url_ISNULL()
	{
		return image_url_ISNULL;
	}
	public J314UserExt setImage_url_ISNULL(boolean _image_url)
	{
		image_url_ISNULL=_image_url;
		return this;
	}



	private String image_url_LIKE;
	private String image_url_NOTLIKE;

	public String getImage_url_LIKE()
	{
		return image_url_LIKE;
	}
	public J314UserExt setImage_url_LIKE(String _image_url)
	{
		image_url_LIKE=_image_url;
		return this;
	}
	public String getImage_url_NOTLIKE()
	{
		return image_url_NOTLIKE;
	}
	public J314UserExt setImage_url_NOTLIKE(String _image_url)
	{
		image_url_NOTLIKE=_image_url;
		return this;
	}





	//lang_key
	private String lang_key;
	private Collection< String > lang_key_IN;
	private Collection< String > lang_key_NOTIN;

	public String getLang_key()
	{
		return lang_key;
	}
	public J314UserExt setLang_key(String _lang_key)
	{
		lang_key=_lang_key;
		return this;
	}
	public Collection< String > getLang_key_IN()
	{
		return lang_key_IN;
	}
	public J314UserExt setLang_key_IN(Collection< String > _lang_key)
	{
		lang_key_IN=_lang_key;
		return this;
	}
	public Collection< String > getLang_key_NOTIN()
	{
		return lang_key_NOTIN;
	}
	public J314UserExt setLang_key_NOTIN(Collection< String > _lang_key)
	{
		lang_key_NOTIN=_lang_key;
		return this;
	}

	private boolean lang_key_ISNOTNULL;
	private boolean lang_key_ISNULL;

	public boolean getLang_key_ISNOTNULL()
	{
		return lang_key_ISNOTNULL;
	}
	public J314UserExt setLang_key_ISNOTNULL(boolean _lang_key)
	{
		lang_key_ISNOTNULL=_lang_key;
		return this;
	}
	public boolean getLang_key_ISNULL()
	{
		return lang_key_ISNULL;
	}
	public J314UserExt setLang_key_ISNULL(boolean _lang_key)
	{
		lang_key_ISNULL=_lang_key;
		return this;
	}



	private String lang_key_LIKE;
	private String lang_key_NOTLIKE;

	public String getLang_key_LIKE()
	{
		return lang_key_LIKE;
	}
	public J314UserExt setLang_key_LIKE(String _lang_key)
	{
		lang_key_LIKE=_lang_key;
		return this;
	}
	public String getLang_key_NOTLIKE()
	{
		return lang_key_NOTLIKE;
	}
	public J314UserExt setLang_key_NOTLIKE(String _lang_key)
	{
		lang_key_NOTLIKE=_lang_key;
		return this;
	}





	//password_hash
	private String password_hash;
	private Collection< String > password_hash_IN;
	private Collection< String > password_hash_NOTIN;

	public String getPassword_hash()
	{
		return password_hash;
	}
	public J314UserExt setPassword_hash(String _password_hash)
	{
		password_hash=_password_hash;
		return this;
	}
	public Collection< String > getPassword_hash_IN()
	{
		return password_hash_IN;
	}
	public J314UserExt setPassword_hash_IN(Collection< String > _password_hash)
	{
		password_hash_IN=_password_hash;
		return this;
	}
	public Collection< String > getPassword_hash_NOTIN()
	{
		return password_hash_NOTIN;
	}
	public J314UserExt setPassword_hash_NOTIN(Collection< String > _password_hash)
	{
		password_hash_NOTIN=_password_hash;
		return this;
	}



	private String password_hash_LIKE;
	private String password_hash_NOTLIKE;

	public String getPassword_hash_LIKE()
	{
		return password_hash_LIKE;
	}
	public J314UserExt setPassword_hash_LIKE(String _password_hash)
	{
		password_hash_LIKE=_password_hash;
		return this;
	}
	public String getPassword_hash_NOTLIKE()
	{
		return password_hash_NOTLIKE;
	}
	public J314UserExt setPassword_hash_NOTLIKE(String _password_hash)
	{
		password_hash_NOTLIKE=_password_hash;
		return this;
	}





	//reset_date
	private Date reset_date;
	private Collection< Date > reset_date_IN;
	private Collection< Date > reset_date_NOTIN;

	public Date getReset_date()
	{
		return reset_date;
	}
	public J314UserExt setReset_date(Date _reset_date)
	{
		reset_date=_reset_date;
		return this;
	}
	public Collection< Date > getReset_date_IN()
	{
		return reset_date_IN;
	}
	public J314UserExt setReset_date_IN(Collection< Date > _reset_date)
	{
		reset_date_IN=_reset_date;
		return this;
	}
	public Collection< Date > getReset_date_NOTIN()
	{
		return reset_date_NOTIN;
	}
	public J314UserExt setReset_date_NOTIN(Collection< Date > _reset_date)
	{
		reset_date_NOTIN=_reset_date;
		return this;
	}

	private boolean reset_date_ISNOTNULL;
	private boolean reset_date_ISNULL;

	public boolean getReset_date_ISNOTNULL()
	{
		return reset_date_ISNOTNULL;
	}
	public J314UserExt setReset_date_ISNOTNULL(boolean _reset_date)
	{
		reset_date_ISNOTNULL=_reset_date;
		return this;
	}
	public boolean getReset_date_ISNULL()
	{
		return reset_date_ISNULL;
	}
	public J314UserExt setReset_date_ISNULL(boolean _reset_date)
	{
		reset_date_ISNULL=_reset_date;
		return this;
	}





	private Date reset_date_DISTINCT;
	private Date reset_date_GREATERTHAN;
	private Date reset_date_GREATEROREQUALTHAN;
	private Date reset_date_LESSTHAN;
	private Date reset_date_LESSOREQUALTHAN;

	public Date getReset_date_DISTINCT()
	{
		return reset_date_DISTINCT;
	}
	public J314UserExt setReset_date_DISTINCT(Date _reset_date)
	{
		reset_date_DISTINCT=_reset_date;
		return this;
	}

	public Date getReset_date_GREATERTHAN()
	{
		return reset_date_GREATERTHAN;
	}
	public J314UserExt setReset_date_GREATERTHAN(Date _reset_date)
	{
		reset_date_GREATERTHAN=_reset_date;
		return this;
	}

	public Date getReset_date_GREATEROREQUALTHAN()
	{
		return reset_date_GREATEROREQUALTHAN;
	}
	public J314UserExt setReset_date_GREATEROREQUALTHAN(Date _reset_date)
	{
		reset_date_GREATEROREQUALTHAN=_reset_date;
		return this;
	}

	public Date getReset_date_LESSTHAN()
	{
		return reset_date_LESSTHAN;
	}
	public J314UserExt setReset_date_LESSTHAN(Date _reset_date)
	{
		reset_date_LESSTHAN=_reset_date;
		return this;
	}

	public Date getReset_date_LESSOREQUALTHAN()
	{
		return reset_date_LESSOREQUALTHAN;
	}
	public J314UserExt setReset_date_LESSOREQUALTHAN(Date _reset_date)
	{
		reset_date_LESSOREQUALTHAN=_reset_date;
		return this;
	}



	//reset_key
	private String reset_key;
	private Collection< String > reset_key_IN;
	private Collection< String > reset_key_NOTIN;

	public String getReset_key()
	{
		return reset_key;
	}
	public J314UserExt setReset_key(String _reset_key)
	{
		reset_key=_reset_key;
		return this;
	}
	public Collection< String > getReset_key_IN()
	{
		return reset_key_IN;
	}
	public J314UserExt setReset_key_IN(Collection< String > _reset_key)
	{
		reset_key_IN=_reset_key;
		return this;
	}
	public Collection< String > getReset_key_NOTIN()
	{
		return reset_key_NOTIN;
	}
	public J314UserExt setReset_key_NOTIN(Collection< String > _reset_key)
	{
		reset_key_NOTIN=_reset_key;
		return this;
	}

	private boolean reset_key_ISNOTNULL;
	private boolean reset_key_ISNULL;

	public boolean getReset_key_ISNOTNULL()
	{
		return reset_key_ISNOTNULL;
	}
	public J314UserExt setReset_key_ISNOTNULL(boolean _reset_key)
	{
		reset_key_ISNOTNULL=_reset_key;
		return this;
	}
	public boolean getReset_key_ISNULL()
	{
		return reset_key_ISNULL;
	}
	public J314UserExt setReset_key_ISNULL(boolean _reset_key)
	{
		reset_key_ISNULL=_reset_key;
		return this;
	}



	private String reset_key_LIKE;
	private String reset_key_NOTLIKE;

	public String getReset_key_LIKE()
	{
		return reset_key_LIKE;
	}
	public J314UserExt setReset_key_LIKE(String _reset_key)
	{
		reset_key_LIKE=_reset_key;
		return this;
	}
	public String getReset_key_NOTLIKE()
	{
		return reset_key_NOTLIKE;
	}
	public J314UserExt setReset_key_NOTLIKE(String _reset_key)
	{
		reset_key_NOTLIKE=_reset_key;
		return this;
	}





	//tiempoSesion
	private Long tiempoSesion;
	private Collection< Long > tiempoSesion_IN;
	private Collection< Long > tiempoSesion_NOTIN;

	public Long getTiempoSesion()
	{
		return tiempoSesion;
	}
	public J314UserExt setTiempoSesion(Long _tiempoSesion)
	{
		tiempoSesion=_tiempoSesion;
		return this;
	}
	public Collection< Long > getTiempoSesion_IN()
	{
		return tiempoSesion_IN;
	}
	public J314UserExt setTiempoSesion_IN(Collection< Long > _tiempoSesion)
	{
		tiempoSesion_IN=_tiempoSesion;
		return this;
	}
	public Collection< Long > getTiempoSesion_NOTIN()
	{
		return tiempoSesion_NOTIN;
	}
	public J314UserExt setTiempoSesion_NOTIN(Collection< Long > _tiempoSesion)
	{
		tiempoSesion_NOTIN=_tiempoSesion;
		return this;
	}

	private boolean tiempoSesion_ISNOTNULL;
	private boolean tiempoSesion_ISNULL;

	public boolean getTiempoSesion_ISNOTNULL()
	{
		return tiempoSesion_ISNOTNULL;
	}
	public J314UserExt setTiempoSesion_ISNOTNULL(boolean _tiempoSesion)
	{
		tiempoSesion_ISNOTNULL=_tiempoSesion;
		return this;
	}
	public boolean getTiempoSesion_ISNULL()
	{
		return tiempoSesion_ISNULL;
	}
	public J314UserExt setTiempoSesion_ISNULL(boolean _tiempoSesion)
	{
		tiempoSesion_ISNULL=_tiempoSesion;
		return this;
	}





	private Long tiempoSesion_DISTINCT;
	private Long tiempoSesion_GREATERTHAN;
	private Long tiempoSesion_GREATEROREQUALTHAN;
	private Long tiempoSesion_LESSTHAN;
	private Long tiempoSesion_LESSOREQUALTHAN;

	public Long getTiempoSesion_DISTINCT()
	{
		return tiempoSesion_DISTINCT;
	}
	public J314UserExt setTiempoSesion_DISTINCT(Long _tiempoSesion)
	{
		tiempoSesion_DISTINCT=_tiempoSesion;
		return this;
	}

	public Long getTiempoSesion_GREATERTHAN()
	{
		return tiempoSesion_GREATERTHAN;
	}
	public J314UserExt setTiempoSesion_GREATERTHAN(Long _tiempoSesion)
	{
		tiempoSesion_GREATERTHAN=_tiempoSesion;
		return this;
	}

	public Long getTiempoSesion_GREATEROREQUALTHAN()
	{
		return tiempoSesion_GREATEROREQUALTHAN;
	}
	public J314UserExt setTiempoSesion_GREATEROREQUALTHAN(Long _tiempoSesion)
	{
		tiempoSesion_GREATEROREQUALTHAN=_tiempoSesion;
		return this;
	}

	public Long getTiempoSesion_LESSTHAN()
	{
		return tiempoSesion_LESSTHAN;
	}
	public J314UserExt setTiempoSesion_LESSTHAN(Long _tiempoSesion)
	{
		tiempoSesion_LESSTHAN=_tiempoSesion;
		return this;
	}

	public Long getTiempoSesion_LESSOREQUALTHAN()
	{
		return tiempoSesion_LESSOREQUALTHAN;
	}
	public J314UserExt setTiempoSesion_LESSOREQUALTHAN(Long _tiempoSesion)
	{
		tiempoSesion_LESSOREQUALTHAN=_tiempoSesion;
		return this;
	}



	private String orderby[];

	public String [] getOrderBy()
	{
		return orderby;
	}

	public J314UserExt setOrderBy(String[] order)
	{
		orderby=order;
		return this;
	}

	private Integer maxElemsPerPage=10;
	private Integer page=0;

	public Integer  getMaxElemsPerPage()
	{
		return maxElemsPerPage;
	}

	public J314UserExt setMaxElemsPerPage(Integer max)
	{
		maxElemsPerPage=max;
		return this;
	}
	public Integer  getPage()
	{
		return page;
	}

	public J314UserExt setPage(Integer page)
	{
		this.page=page;
		return this;
	}





/*


*/
}


