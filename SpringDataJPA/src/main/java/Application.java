import org.ion.springjpa.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackageClasses = User.class)
@ComponentScan("org.ion.springjpa")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
