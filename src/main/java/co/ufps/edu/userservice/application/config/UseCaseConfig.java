package co.ufps.edu.userservice.application.config;

import co.ufps.edu.userservice.domain.model.gateways.UserGateway;
import co.ufps.edu.userservice.domain.useCase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public UserUseCase userUseCase(UserGateway gateway){
        return new UserUseCase(gateway);
    }
}
