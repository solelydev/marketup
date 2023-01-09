package tososomaru.wb.ads;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    @Value("${wb.x-supplier-id-external}")
    String id;
    @Value("${wb.WILDAUTHNEW_V3}")
    String token;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
