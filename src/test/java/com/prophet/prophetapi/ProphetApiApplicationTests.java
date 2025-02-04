package com.prophet.prophetapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"spring.datasource.url="})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
class ProphetApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
