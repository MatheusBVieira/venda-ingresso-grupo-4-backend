package com.example.vendaIngressos.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(value = "test")
public class UsuarioControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void deveriaDevolverListaDeUsuario() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/usuario").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers
						.jsonPath("$.content[-1].nomeCompleto").value("Matheus Bruggemann Vieira"));
	}

	@Test
	public void deveriaDevolverUsuarioInserido() throws Exception {
		URI uri = new URI("/usuario");
		String json = "{\r\n" + "		\"nomeCompleto\": \"Matheus Bruggemann Vieira\",\r\n"
				+ "		\"cpf\": \"01014320703\",\r\n" + "		\"endereco\": {\r\n"
				+ "				\"rua\": \"Rua das corticeiras\",\r\n" + "				\"numero\" : 114,\r\n"
				+ "				\"cep\": \"88063160\",\r\n" + "				\"bairro\": \"Campeche\"\r\n"
				+ "		},\r\n" + "		\"username\": \"itfon\",\r\n"
				+ "		\"email\": \"matheusbvieira@email.com\",\r\n" + "		\"telefone\": \"48991466677\",\r\n"
				+ "		\"idade\": 19\r\n" + "}";

		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(201));
	}

	@Test
	public void deveriaDevolverUsuarioAlterado() throws Exception {
		String json = "{\r\n" + "		\"nomeCompleto\": \"Matheus\",\r\n" + "		\"endereco\": {\r\n"
				+ "				\"rua\": \"Rua das corticeiras\",\r\n" + "				\"numero\" : 114,\r\n"
				+ "				\"cep\": \"88063160\",\r\n" + "				\"bairro\": \"Campeche\"\r\n"
				+ "		},\r\n" + "		\"email\": \"matheus@email.com\",\r\n"
				+ "		\"telefone\": \"48991466677\",\r\n" + "		\"idade\": 19\r\n" + "}";

		mockMvc.perform(
				MockMvcRequestBuilders.put("/usuario/{id}", 2).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.nomeCompleto").value("Matheus"));
	}

}
