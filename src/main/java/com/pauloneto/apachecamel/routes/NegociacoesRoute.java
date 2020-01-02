package com.pauloneto.apachecamel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class NegociacoesRoute extends RouteBuilder {

    private static final String URI_NEGOCIACOES_SEVICE = "http4://argentumws-spring.herokuapp.com/negociacoes";

    @Override
    public void configure() throws Exception {
        from("timer://negociacoes?fixedRate=true&delay=1s&period=360s")
            .to(URI_NEGOCIACOES_SEVICE)
            .convertBodyTo(String.class)
            .log("${body}")
            .setHeader(Exchange.FILE_NAME,constant("negociacoes.xml"))
        .to("file:negociacoes");
    }
}
