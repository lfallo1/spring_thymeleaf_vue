package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="guru.springframework")
public class SfgThymeleafCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SfgThymeleafCourseApplication.class, args);
	}
}
