package com.emerge.ocs.rest.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import io.swagger.util.Json;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

@Provider
@Produces({MediaType.APPLICATION_JSON})
public class JacksonJsonProvider extends JacksonJaxbJsonProvider {
    private static final ObjectMapper commonMapper = Json.mapper();

    public JacksonJsonProvider() {
        try {
            super.setMapper(commonMapper);
        } catch(Exception e) {
            
        }
    }
}