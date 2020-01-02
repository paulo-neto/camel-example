package com.pauloneto.apachecamel.scheduler;

import com.pauloneto.apachecamel.routes.NegociacoesRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

@Startup
@Singleton
public class StartCamelProcess {

    private static final String TIMER_NAME = "TIMER_CAMEL_PROCESS";

    @Resource
    private TimerService timerService;

    @Inject
    private Logger logger;

    @Inject
    private CamelContext camelContext;

    @PostConstruct
    public void init(){
        ScheduleExpression expression = configurarScheduleExpression();
        TimerConfig config = new TimerConfig(TIMER_NAME, false);
        this.timerService.createCalendarTimer(expression, config);
        logger.info(String.format("[IniciarJobs] - Configuração do @TimeOut: %s",expression));
    }

    @Timeout
    public void initSparkProcess(){
        try {
            camelContext.addRoutes(new NegociacoesRoute());
            camelContext.start();
        } catch (Exception e) {
            logger.log(Level.SEVERE, ExceptionUtils.getRootCauseMessage(e));
        }
    }

    private ScheduleExpression configurarScheduleExpression() {
        return new ScheduleExpression().dayOfMonth("*").hour("*").minute("*/1");// expression default
    }
}
