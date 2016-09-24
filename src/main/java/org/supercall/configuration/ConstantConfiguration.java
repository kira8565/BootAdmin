package org.supercall.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "constant")
@Repository
public class ConstantConfiguration {
    @NotNull
    @Valid
    private String isDev;

    public String getIsDev() {
        return isDev;
    }

    public void setIsDev(String isDev) {
        this.isDev = isDev;
    }
}
