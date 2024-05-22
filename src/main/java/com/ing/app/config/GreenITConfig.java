package com.ing.app.config;

import com.ing.app.util.GreenITConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreenITConfig {

    @Bean
    public Runtime runtime() {
        return Runtime.getRuntime();
    }

    @Bean
    public String fileLocation() {
        return System.getenv("GREEN_IT") + GreenITConstants.FILE_NAME;
    }
}
