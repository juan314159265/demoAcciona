package com.sine95.tweetsrv.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Properties specific to Tweetsrv.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
	
	@Configuration
	public class RestSecurityConfig extends WebSecurityConfigurerAdapter {
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable();
	  }
	}	

/*	
	@Configuration
	public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

	    ...

	    // Determines if a CSRF token is required for connecting. This protects against remote
	    // sites from connecting to the application and being able to read/write data over the
	    // connection. The default is false (the token is required).
	    @Override
	    protected boolean sameOriginDisabled() {
	        return true;
	    }
	}
*/	
}
