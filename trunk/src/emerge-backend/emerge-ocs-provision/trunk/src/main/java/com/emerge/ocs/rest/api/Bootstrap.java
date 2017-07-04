package com.emerge.ocs.rest.api;

import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Bootstrap extends HttpServlet {

    /**
     *
     * @param config Config from swagger
     * @throws ServletException
     */
    @Override
    public final void init(final ServletConfig config) throws ServletException {
        Info info = new Info()
                .title("Swagger Server")
                .description("Specification of Provision REST API "
                        + "for Emerge Online Charging System")
                .termsOfService("")
                .contact(new Contact()
                        .email("jorge.patrao@smarttank-solutions.com"))
                .license(new License()
                        .name("")
                        .url(""));

//    ServletContext context = config.getServletContext();
        Swagger swagger = new Swagger().info(info);

        new SwaggerContextService().withServletConfig(config)
                .updateSwagger(swagger);
    }
}
