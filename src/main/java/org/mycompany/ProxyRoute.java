package org.mycompany;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;

public class ProxyRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        final RouteDefinition from;
            from = from("direct:ProxyRoute");
       
        from
          .log("HOST header: ${headers.HTTP_HOST}")
          .toD("netty-http:"
                + "${headers.HTTP_SCHEME}://"
                + "${headers.HTTP_HOST}:"
                + "${headers.HTTP_PORT}");
    }

}
