package com.example.vendaIngressos;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.vendaIngressos.controller.EventoControllerTest;
import com.example.vendaIngressos.controller.UsuarioControllerTest;

@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({ EventoControllerTest.class, UsuarioControllerTest.class })
class VendaIngressosApplicationTests {

	@Test
	void contextLoads() throws Exception {
	}

}
