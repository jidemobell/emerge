package com.emerge.ocs.rest.api;

import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class Bootstrap extends HttpServlet {
  @Override
  public void init(ServletConfig config) throws ServletException {
    Info info = new Info()
      .title("Swagger Server")
      .description("Specification of Service Control REST API for Emerge Online Charging System")
      .termsOfService("")
      .contact(new Contact()
        .email("jorge.patrao@smarttank-solutions.com"))
      .license(new License()
        .name("")
        .url(""));

//    ServletContext context = config.getServletContext();
    Swagger swagger = new Swagger().info(info);

    new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
  }
}
