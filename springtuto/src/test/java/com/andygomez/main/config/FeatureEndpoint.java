
package com.andygomez.main.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "features")
public class FeatureEndpoint {

    private final Map<String, Feature> featureMap = 
            new ConcurrentHashMap<>();

    public FeatureEndpoint(){
        featureMap.put("Departamento", new Feature(true));
        featureMap.put("Usuario", new Feature(false));
        featureMap.put("Autenticacion", new Feature(false));
    }
    
    @ReadOperation
    public Map<String, Feature> features(){
        return featureMap;
    }
    
    public Feature feature(@Selector String featureName){
        return featureMap.get(featureName);
    }
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Feature{
        private boolean isEnable;
    }
    
}
