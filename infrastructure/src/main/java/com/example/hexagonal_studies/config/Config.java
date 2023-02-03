package com.example.hexagonal_studies.config;

import com.example.hexagonal_studies.user.UserBackOfficeService;
import com.example.hexagonal_studies.user.port.api.UserBackOfficeApiPort;
import com.example.hexagonal_studies.user.port.spi.UserSpiPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    UserBackOfficeApiPort userPort(final UserSpiPort userSpiPort) {
        return new UserBackOfficeService(userSpiPort);
    }
}
