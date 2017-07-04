package com.emerge.ocs.rest.factories;

import com.emerge.ocs.rest.impl.OcsApiServiceImpl;
import com.emerge.ocs.rest.service.OcsApiService;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-30T12:02:01.409Z")
public class OcsApiServiceFactory {
    private final static OcsApiService service = new OcsApiServiceImpl();

    public static OcsApiService getOcsApi() {
        return service;
    }
}
