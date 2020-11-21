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
public class EventoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void deveriaDevolverListaDeEvento() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/evento").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.content[-1].nome").value("Aniversario"));
	}

	@Test
	public void deveriaDevolverEventoInserido() throws Exception {
		URI uri = new URI("/evento");
		String json = "{\r\n" + "	\"nome\": \"Aniversario\",\r\n" + "	\"data\": \"29/11/2000\",\r\n"
				+ "	\"criador\": 1,\r\n" + "	\"categoria\": \"FESTA\",\r\n" + "	\"endereco\": {\r\n"
				+ "				\"rua\": \"Rua das corticeiras\",\r\n" + "				\"numero\" : 114,\r\n"
				+ "				\"cep\": \"88063160\",\r\n" + "				\"bairro\": \"Campeche\"\r\n"
				+ "		},\r\n" + "	\"capacidadePessoas\": 1000\r\n" + "}\r\n" + "";

		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(201));
	}

	@Test
	public void deveriaDevolverEventoAlterado() throws Exception {
		String json = "{\r\n" + "	\"nome\":\"aniversarioo\",\r\n" + "	\"data\": \"29/11/2021\",\r\n"
				+ "	\"preco\": 29.3,\r\n" + "	\"categoria\": \"FESTA\",\r\n" + "	\"endereco\": {\r\n"
				+ "				\"rua\": \"Rua daSS corticeiras\",\r\n" + "				\"numero\" : 114,\r\n"
				+ "				\"cep\": \"88063160\",\r\n" + "				\"bairro\": \"Campeche\"\r\n"
				+ "		}\r\n" + "}";

		mockMvc.perform(
				MockMvcRequestBuilders.put("/evento/{id}", 2).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("aniversarioo"));
	}

//	@Test
//	public void deveriaDevolver200AoDeletarEvento() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.delete("/evento/{id}", 3))
//				.andExpect(MockMvcResultMatchers.status().is(200));
//	}

//	@Test
//	public void deveriaDevolverEventoAlterado() throws Exception {
//
//		Endereco endereco = new Endereco("Rua das corticeiras", 114, "88063160", "campeche");
//
//		Evento aniversario = new Evento();
//		aniversario.setNome("Aniversario");
//		aniversario.setCriador(new Usuario("Matheus Bruggemann Vieira", "01014310903", endereco, "nofti", "123456",
//				"matheusbvieira@hotmail.com", "48991466677", 19));
//		aniversario.setCategoria(Categoria.FESTA);
//		aniversario.setCapacidadePessoas(1000);
//
//		String string = "29/11/2000";
//		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//		Date date = format.parse(string);
//		aniversario.setData(date);
//
//		em.persist(aniversario);
//
//		URI uri = new URI("/evento");
//
//		mockMvc.perform(MockMvcRequestBuilders.get(uri))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.content").value("aniversario"));
//	}

}
