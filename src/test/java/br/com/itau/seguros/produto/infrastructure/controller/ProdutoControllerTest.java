package br.com.itau.seguros.produto.infrastructure.controller;

import br.com.itau.seguros.produto.fixture.ProdutoFixture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Profile("!prod")
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveRetornarOProdutoCriadoComStatus200() throws Exception {

        var createProdutoRequest = ProdutoFixture.createProdutoRequest();

        this.mockMvc.perform(
            post("/produtos")
            .contentType(APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(createProdutoRequest)))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Seguro de Vida Individual")));
    }

    @Test
    void deveRetornar404AoTentarBuscarUmProdutoQueNaoExisteUsandoOId() throws Exception {

        this.mockMvc.perform(
             get("/produtos/165a5d3fc74fd750c7bb919a8X"))
            .andDo(print())
            .andExpect(status().isNotFound());
    }

    @Test
    void deveRetornar200AoTentarRecuperarUmaListaDeProdutos() throws Exception {

        this.mockMvc.perform(
             get("/produtos"))
            .andDo(print())
            .andExpect(status().isOk());
    }
}
