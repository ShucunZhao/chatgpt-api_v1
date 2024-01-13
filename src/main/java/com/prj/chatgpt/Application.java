package com.prj.chatgpt; //Define the package of the class.

// Import the necessary classes and interfaces for the class.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @SpringBootApplication: This annotation is a convenience for adding all the typical configurations needed to start a Spring application.
 * It encompasses features like @Configuration, @EnableAutoConfiguration, @ComponentScan, etc.
 * @RestController: This is a special type of @Controller that includes the @ResponseBody annotation.
 * This means that the objects returned by the methods are directly written to the HTTP response body, not resolved through a view resolver.
 */
@SpringBootApplication
@RestController
public class Application {

    // Create an instance of a logger to log information about the application, based on org.slf4j.Logger interface.
    private Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        // Entry point of the Java program. It starts the Spring application.
        SpringApplication.run(Application.class, args);
    }

    /**
     * @GetMapping("/verify") defines a method to handle HTTP GET requests to the path /verify.
     * The verify method receives a token string parameter, logs the token, and returns different HTTP statuses based on a condition.
     * If the token equals "success," it returns an HTTP 200 (OK) status; otherwise, it returns an HTTP 400 (BAD REQUEST) status.
     */
    @GetMapping("/verify")
    public ResponseEntity<String> verify(String token){
        logger.info("Authentication token: {}", token);
        if("success".equals(token)){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * Another @GetMapping handles GET requests to the path /success.
     * The success method returns a simple string message.
     */
    @GetMapping("/success")
    public String success(){
        return "Test successfully by ShucunZhao.";
    }
}
