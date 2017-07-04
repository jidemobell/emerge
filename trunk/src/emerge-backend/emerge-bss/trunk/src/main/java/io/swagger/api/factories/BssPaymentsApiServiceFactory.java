package io.swagger.api.factories;

import io.swagger.api.BssPaymentsApiService;
import io.swagger.api.impl.BssPaymentsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-21T13:41:49.775Z")
public class BssPaymentsApiServiceFactory {
    private final static BssPaymentsApiService service = new BssPaymentsApiServiceImpl();

    public static BssPaymentsApiService getBssPaymentsApi() {
        return service;
    }
}
