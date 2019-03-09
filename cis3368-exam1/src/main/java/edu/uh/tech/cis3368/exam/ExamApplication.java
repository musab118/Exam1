package edu.uh.tech.cis3368.exam;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Collectors;

@SpringBootApplication
public class ExamApplication implements CommandLineRunner {


	@Autowired
	ServerRepository serverRepository;

	@Autowired
	ExamService examService;

	private ConfigurableApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}


	@Override
	public void run(String... args){
		examService.createData();
		BigDecimal sum = examService.calculateTotalRunningCost ();
		System.out.println(sum);


	}




}
