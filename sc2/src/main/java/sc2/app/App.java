package sc2.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;


@SpringBootApplication
@ComponentScan("sc2")
@EntityScan(basePackages = "sc2.models")
@Controller("sc2.controllers")

public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}