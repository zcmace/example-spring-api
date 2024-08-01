package com.prophet.prophetapi.config;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("my.secret")
@Getter
@Setter
public class SecretProperties {

    private String property;
    
}