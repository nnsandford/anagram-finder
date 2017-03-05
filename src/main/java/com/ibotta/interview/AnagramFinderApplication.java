package com.ibotta.interview;

import com.ibotta.interview.vo.Word;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@SpringBootApplication
public class AnagramFinderApplication {

	@Value("classpath:dictionary.txt")
	private Resource resource;

	public static void main(String[] args)
	{
		SpringApplication.run(AnagramFinderApplication.class, args);
	}

	@Bean
	public Map<String, List<Word>> dictionary()
	{
		try
		{
			return new BufferedReader(new InputStreamReader(resource.getInputStream()))
					.lines()
					.map(Word::new)
					.collect(groupingBy(Word::getKey));
		}
		catch (IOException e)
		{
			return new HashMap<>();
		}
	}
}
