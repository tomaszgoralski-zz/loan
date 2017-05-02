package tech.valuestream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.TestPropertySource;

@SpringBootApplication
@TestPropertySource("/test.properties")
public class TestRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestRunner.class, args);
    }
}