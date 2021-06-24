package com.sine95.tweetsrv.config;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//JPimport org.zalando.problem.ProblemModule;
//JPimport org.zalando.problem.validation.ConstraintViolationProblemModule;

@Configuration
public class JacksonConfiguration {

    /*
     * Support for Hibernate types in Jackson.
     */
    @Bean
    public Hibernate5Module hibernate5Module() {
        return new Hibernate5Module();
    }

    /*
     * Jackson Afterburner module to speed up serialization/deserialization.
     */
    @Bean
    public AfterburnerModule afterburnerModule() {
        return new AfterburnerModule();
    }

    /*
     * Module for serialization/deserialization of RFC7807 Problem.
     */
    //JP 
    /*
    @Bean
    ProblemModule problemModule() {
        return new ProblemModule();
    }
*/
    /*
     * Module for serialization/deserialization of ConstraintViolationProblem.
     */
    //JP
    /*
    @Bean
    ConstraintViolationProblemModule constraintViolationProblemModule() {
        return new ConstraintViolationProblemModule();
    }
    */

}
