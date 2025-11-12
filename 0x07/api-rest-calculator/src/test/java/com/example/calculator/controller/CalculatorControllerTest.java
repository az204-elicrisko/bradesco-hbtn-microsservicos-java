package com.example.calculator.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(CalculatorController.class)
@DisplayName("Calculator Controller Test")
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Testes para o endpoint welcome
    @Test
    @DisplayName("Deve retornar mensagem de boas-vindas")
    void messageWelcome() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/welcome"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Bem vindo à CALCULATOR API REST."));
    }

    // Testes para o endpoint addNumbers
    @Test
    @DisplayName("Deve somar dois números positivos")
    void addNumbers() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/addNumbers")
                        .param("number1", "10.5")
                        .param("number2", "5.3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("10,50 + 5,30 = 15,80"));
    }

    @Test
    @DisplayName("Deve somar números com resultado zero")
    void addNumbersResultZero() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/addNumbers")
                        .param("number1", "5")
                        .param("number2", "-5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("5,00 + -5,00 = 0,00"));
    }

    @Test
    @DisplayName("Deve retornar erro quando number1 for nulo na soma")
    void testAddNumbersWithNullNumber1() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/addNumbers")
                        .param("number2", "5"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Deve retornar erro quando number2 for nulo na soma")
    void testAddNumbersWithNullNumber2() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/addNumbers")
                        .param("number1", "5"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // Testes para o endpoint subNumbers
    @Test
    @DisplayName("Deve subtrair dois números corretamente")
    void subNumbers() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/subNumbers")
                        .param("number1", "10")
                        .param("number2", "3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("10,00 - 3,00 = 7,00"));
    }

    @Test
    @DisplayName("Deve subtrair resultando em número negativo")
    void testSubNumbersNegativeResult() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/subNumbers")
                        .param("number1", "3")
                        .param("number2", "5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("3,00 - 5,00 = -2,00"));
    }

    @Test
    @DisplayName("Deve retornar erro quando parâmetros forem nulos na subtração")
    void testSubNumbersWithNullParams() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/subNumbers")
                        .param("number1", "5"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // Testes para o endpoint divideNumbers
    @Test
    @DisplayName("Deve dividir dois números corretamente")
    void divideNumbers() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/divideNumbers")
                        .param("number1", "10")
                        .param("number2", "2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("10,00 ÷ 2,00 = 5,00"));
    }

    @Test
    @DisplayName("Deve dividir com resultado decimal")
    void testDivideNumbersDecimal() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/divideNumbers")
                        .param("number1", "7")
                        .param("number2", "2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("7,00 ÷ 2,00 = 3,50"));
    }

    @Test
    @DisplayName("Deve retornar erro ao dividir por zero")
    void testDivideByZero() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/divideNumbers")
                        .param("number1", "10")
                        .param("number2", "0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Erro: Divisão por zero não é permitido."));
    }

    @Test
    @DisplayName("Deve retornar erro quando parâmetros forem nulos na divisão")
    void testDivideNumbersWithNullParams() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/divideNumbers")
                        .param("number1", "5"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // Testes para o endpoint factorial
    @Test
    @DisplayName("Deve calcular fatorial de 5")
    void factorial() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/factorial")
                        .param("factorial", "5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("5! = 120"));
    }

    @Test
    @DisplayName("Deve calcular fatorial de 0")
    void testFactorial0() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/factorial")
                        .param("factorial", "0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("0! = 1"));
    }

    @Test
    @DisplayName("Deve retornar erro para fatorial de número negativo")
    void testFactorialNegative() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/factorial")
                        .param("factorial", "-5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Erro: Fatorial não pode ser calculado para números negativos."));
    }

    @Test
    @DisplayName("Deve retornar erro quando parâmetro factorial for nulo")
    void testFactorialWithNullParam() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/factorial"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // Testes para o endpoint calculeDayBetweenDate
    @Test
    @DisplayName("Deve calcular dias entre duas datas")
    void calculeDayBetweenDate() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/calculeDayBetweenDate")
                        .param("localDate1", "2020-03-15")
                        .param("localDate2", "2020-03-29"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Número de dias entre 2020-03-15 e 2020-03-29: 14 dias"));
    }

    @Test
    @DisplayName("Deve calcular dias entre datas em ordem inversa")
    void testCalculeDayBetweenDateReversed() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/calculeDayBetweenDate")
                        .param("localDate1", "2020-03-29")
                        .param("localDate2", "2020-03-15"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Número de dias entre 2020-03-29 e 2020-03-15: 14 dias"));
    }

    @Test
    @DisplayName("Deve retornar 0 para datas iguais")
    void testCalculeDayBetweenSameDates() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/calculeDayBetweenDate")
                        .param("localDate1", "2020-03-15")
                        .param("localDate2", "2020-03-15"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Número de dias entre 2020-03-15 e 2020-03-15: 0 dias"));
    }

    @Test
    @DisplayName("Deve retornar erro para formato de data inválido")
    void testCalculeDayBetweenDateInvalidFormat() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/calculeDayBetweenDate")
                        .param("localDate1", "2020/03/15")
                        .param("localDate2", "2020-03-29"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Deve retornar erro quando parâmetros de data forem nulos")
    void testCalculeDayBetweenDateWithNullParams() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/calculeDayBetweenDate")
                        .param("localDate1", "2020-03-15"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // Testes para o endpoint integerToBinary
    @Test
    @DisplayName("Deve converter 5 para binário")
    void integerToBinary() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/integerToBinary")
                        .param("number1", "5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Número 5 em binário: 101"));
    }

    @Test
    @DisplayName("Deve converter 1 para binário")
    void testIntegerToBinary1() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/integerToBinary")
                        .param("number1", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Número 1 em binário: 1"));
    }

    @Test
    @DisplayName("Deve converter 20 para binário")
    void testIntegerToBinary20() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/integerToBinary")
                        .param("number1", "20"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Número 20 em binário: 10100"));
    }

    @Test
    @DisplayName("Deve converter 0 para binário")
    void testIntegerToBinary0() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/integerToBinary")
                        .param("number1", "0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Número 0 em binário: 0"));
    }

    @Test
    @DisplayName("Deve retornar erro quando parâmetro for nulo na conversão para binário")
    void testIntegerToBinaryWithNullParam() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/integerToBinary"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // Testes para o endpoint integerToHexadecimal
    @Test
    @DisplayName("Deve converter 1 para hexadecimal")
    void testIntegerToHexadecimal1() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/integerToHexadecimal")
                        .param("number1", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Número 1 em hexadecimal: 1"));
    }

    @Test
    @DisplayName("Deve converter 55 para hexadecimal")
    void integerToHexadecimal() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/integerToHexadecimal")
                        .param("number1", "55"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Número 55 em hexadecimal: 37"));
    }

    @Test
    @DisplayName("Deve converter 170 para hexadecimal")
    void testIntegerToHexadecimal170() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/integerToHexadecimal")
                        .param("number1", "170"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Número 170 em hexadecimal: AA"));
    }

    @Test
    @DisplayName("Deve converter 255 para hexadecimal")
    void testIntegerToHexadecimal255() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/integerToHexadecimal")
                        .param("number1", "255"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Número 255 em hexadecimal: FF"));
    }

    @Test
    @DisplayName("Deve converter 0 para hexadecimal")
    void testIntegerToHexadecimal0() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/integerToHexadecimal")
                        .param("number1", "0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Número 0 em hexadecimal: 0"));
    }

    @Test
    @DisplayName("Deve retornar erro quando parâmetro for nulo na conversão para hexadecimal")
    void testIntegerToHexadecimalWithNullParam() throws Exception {
        mockMvc.perform(get("/calculator-api/calculator/integerToHexadecimal"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}