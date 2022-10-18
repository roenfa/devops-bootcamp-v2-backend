package fundacionjala.backend.springdemo;

import fundacionjala.backend.springdemo.repositories.UserRepository;
import fundacionjala.backend.springdemo.repositories.UserRepositoryImpl;
import fundacionjala.backend.springdemo.services.UserService;
import fundacionjala.backend.springdemo.services.UserServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfiguration {
    @Bean(name = "userRepository")
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public UserRepository getUserRepository() {
        return new UserRepositoryImpl();
    }

    @Bean(name = "userService")
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public UserService getUserService() {
        UserServiceImpl service = new UserServiceImpl();
        service.setRepo(this.getUserRepository());

        return service;
    }

}
