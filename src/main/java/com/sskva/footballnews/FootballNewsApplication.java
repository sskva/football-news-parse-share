package com.sskva.footballnews;

import com.sskva.footballnews.logic.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories
@SpringBootApplication
public class FootballNewsApplication {


	public static void main(String[] args) throws Exception {


		ApplicationContext context = SpringApplication.run(FootballNewsApplication.class);
		Processor processor = context.getBean(Processor.class);

		processor.start();
	}
}

