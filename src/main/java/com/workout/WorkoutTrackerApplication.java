package com.workout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.workout.repository")
@EntityScan("com.workout.model")
public class WorkoutTrackerApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(WorkoutTrackerApplication.class, args);
	}
	
	/** Use when running using war*/
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WorkoutTrackerApplication.class);		
	}

}
