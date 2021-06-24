package com.sine95.tweetsrv;

import org.sine95.kernel.base.task.ServicioTareas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;


@Component
public class StopApp implements ApplicationListener<ContextClosedEvent >{

	private final Logger log = LoggerFactory.getLogger(StopApp.class);
	
	
	
	@Override
	public void onApplicationEvent(ContextClosedEvent  event) {
		log.info("App refrescada ");
		stopServicioTareas();
		
		log.info("Fin App refrescada ");
	}

	private void stopServicioTareas() {
		ServicioTareas.shutdownAll();
	}
	
		
}
