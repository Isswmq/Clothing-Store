package org.store.dev.moonrock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.store.StoreApplication;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
@EnableEnversRepositories(basePackageClasses = StoreApplication.class)
public class AuditConfiguration {

    @Bean
    public AuditorAware<String>auditorAware() {
        return () -> Optional.of("moonrock");
    }
}
