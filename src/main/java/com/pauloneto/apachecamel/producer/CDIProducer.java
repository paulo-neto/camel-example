package com.pauloneto.apachecamel.producer;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.annotation.PreDestroy;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CDIProducer {

    private CamelContext camelContext;

    @Produces
    public Logger crateLogger(InjectionPoint injectionPoint){
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

    @Produces
    public CamelContext createDefaultCamelContext(){
        camelContext = new DefaultCamelContext();
        return camelContext;
    }

    @PreDestroy
    public void destoy(){
        if(camelContext != null){
            try {
                camelContext.stop();
            } catch (Exception e) {
                Logger.getLogger(CDIProducer.class.getName()).log(Level.SEVERE, ExceptionUtils.getRootCauseMessage(e));
            }
        }
    }
}
