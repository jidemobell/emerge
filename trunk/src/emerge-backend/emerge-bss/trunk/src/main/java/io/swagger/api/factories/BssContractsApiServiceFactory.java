package io.swagger.api.factories;

import io.swagger.api.BssContractsApiService;
import io.swagger.api.impl.BssContractsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-21T13:42:52.506Z")
public class BssContractsApiServiceFactory {
    private final static BssContractsApiService service = new BssContractsApiServiceImpl();

    public static BssContractsApiService getBssApi() {
        return service;
    }
}
