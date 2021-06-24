
package com.sine95.tweetsrv.service.task.Tarea;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import com.sine95.tweetsrv.TweetsrvApp;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.sine95.kernel.base.Result;
import com.sine95.tweetsrv.errores.*;
import com.sine95.tweetsrv.warnings.*;
import com.sine95.tweetsrv.infos.*;
import com.sine95.tweetsrv.service.Config;
import com.sine95.tweetsrv.repository.UtilDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sine95.kernel.util.*;
import org.sine95.kernel.base.test.*;
import java.util.*;
import org.sine95.kernel.base.Contexto;
import java.io.*;
import java.util.*;
import org.springframework.context.ApplicationContext;


//entity
import com.sine95.tweetsrv.domain.J314User;
import com.sine95.tweetsrv.domain.J314UserCrit;
import com.sine95.tweetsrv.domain.J314UserCritPaged;
import com.sine95.tweetsrv.service.crud.J314UserServiceCRUD;

//import com.sine95.tweetsrv.domain.J314UserExt;
import com.sine95.tweetsrv.domain.J314UserExt;


//service
import com.sine95.tweetsrv.service.ln.GestionHilosLNService;
    


import com.sine95.tweetsrv.service.task.TareaTaskService;




/**
* Logica de negocio para las tareas automáticas
*/

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TweetsrvApp.class)
@Transactional
public class TareaTaskServiceTest extends BaseTest
{



    @Autowired
    protected  Config config;

    @Autowired
    protected ApplicationContext appContext;

    @Autowired
    protected J314UserServiceCRUD j314UserService;

    
    protected GestionHilosLNService gestionHilosService;

    protected synchronized GestionHilosLNService getGestionHilosLNService()
    {
      if(gestionHilosService==null)
      {
        gestionHilosService=appContext.getBean(GestionHilosLNService.class);
      }
      return gestionHilosService;
    }


    @Autowired
    protected TareaTaskService serviceLN;

    @Autowired
    protected UtilDB udb;

    @Before
    public void init(){
      
      
    }


//Si hay que annadir metodos se incluyen aqui, se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}
