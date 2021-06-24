
package com.sine95.tweetsrv.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import org.sine95.kernel.base.cache.UtilRedis;


@Configuration
public class RedisConfiguration {


    private String app;

    private String url;

    private Integer port;

    private String pass;

    private Integer maxTotal;

    private Integer maxIdle;

    private Integer minIdle;

    private Boolean testOnBorrow;

    private Boolean testOnReturn;

    private Boolean testWhileIdle;

    private Integer minEvictableIdleTimeInSecs;

    private Integer timeBetweenEvictionRunsInSecs;

    private Integer numTestsPerEvictionRun;

    private Boolean blockWhenExhausted;



  public  RedisConfiguration (

    @Value("${redis.app}") String app 

    ,@Value("${redis.url}") String url 

    ,@Value("${redis.port}") Integer port 

    ,@Value("${redis.pass}") String pass 

    ,@Value("${redis.maxTotal}") Integer maxTotal 

    ,@Value("${redis.maxIdle}") Integer maxIdle 

    ,@Value("${redis.minIdle}") Integer minIdle 

    ,@Value("${redis.testOnBorrow}") Boolean testOnBorrow 

    ,@Value("${redis.testOnReturn}") Boolean testOnReturn 

    ,@Value("${redis.testWhileIdle}") Boolean testWhileIdle 

    ,@Value("${redis.minEvictableIdleTimeInSecs}") Integer minEvictableIdleTimeInSecs 

    ,@Value("${redis.timeBetweenEvictionRunsInSecs}") Integer timeBetweenEvictionRunsInSecs 

    ,@Value("${redis.numTestsPerEvictionRun}") Integer numTestsPerEvictionRun 

    ,@Value("${redis.blockWhenExhausted}") Boolean blockWhenExhausted 

  )
  {

    this.app=app;

    this.url=url;

    this.port=port;

    this.pass=pass;

    this.maxTotal=maxTotal;

    this.maxIdle=maxIdle;

    this.minIdle=minIdle;

    this.testOnBorrow=testOnBorrow;

    this.testOnReturn=testOnReturn;

    this.testWhileIdle=testWhileIdle;

    this.minEvictableIdleTimeInSecs=minEvictableIdleTimeInSecs;

    this.timeBetweenEvictionRunsInSecs=timeBetweenEvictionRunsInSecs;

    this.numTestsPerEvictionRun=numTestsPerEvictionRun;

    this.blockWhenExhausted=blockWhenExhausted;


    
    UtilRedis.set(this);
    


  }


    public String getApp()
    {
      return this.app;
    }

    public String getUrl()
    {
      return this.url;
    }

    public Integer getPort()
    {
      return this.port;
    }

    public String getPass()
    {
      return this.pass;
    }

    public Integer getMaxTotal()
    {
      return this.maxTotal;
    }

    public Integer getMaxIdle()
    {
      return this.maxIdle;
    }

    public Integer getMinIdle()
    {
      return this.minIdle;
    }

    public Boolean getTestOnBorrow()
    {
      return this.testOnBorrow;
    }

    public Boolean getTestOnReturn()
    {
      return this.testOnReturn;
    }

    public Boolean getTestWhileIdle()
    {
      return this.testWhileIdle;
    }

    public Integer getMinEvictableIdleTimeInSecs()
    {
      return this.minEvictableIdleTimeInSecs;
    }

    public Integer getTimeBetweenEvictionRunsInSecs()
    {
      return this.timeBetweenEvictionRunsInSecs;
    }

    public Integer getNumTestsPerEvictionRun()
    {
      return this.numTestsPerEvictionRun;
    }

    public Boolean getBlockWhenExhausted()
    {
      return this.blockWhenExhausted;
    }





}
