package io.swagger.api.factories;

import io.swagger.api.BssCustomersApiService;
import io.swagger.api.impl.BssCustomersApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-21T13:43:31.183Z")
public class BssCustomersApiServiceFactory {
    private final static BssCustomersApiService service = new BssCustomersApiServiceImpl();

    public static BssCustomersApiService getBssCustomersApi() {
        return service;
    }
}
