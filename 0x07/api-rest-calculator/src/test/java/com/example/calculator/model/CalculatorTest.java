package com.example.calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

@DisplayName("Calculator Test")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // Testes para o método sum
    @Test
    @DisplayName("Deve somar dois números positivos corretamente")
    void sumTest() {
        Double result = calculator.sum(5.0, 3.0);
        assertEquals(8.0, result);
    }

    @Test
    @DisplayName("Deve somar números negativos corretamente")
    void testSumNegativeNumbers() {
        Double result = calculator.sum(-5.0, -3.0);
        assertEquals(-8.0, result);
    }

    @Test
    @DisplayName("Deve somar número positivo e negativo corretamente")
    void testSumPositiveAndNegative() {
        Double result = calculator.sum(5.0, -3.0);
        assertEquals(2.0, result);
    }

    @Test
    @DisplayName("Deve lançar exceção quando number1 for null na soma")
    void numbersNullSumTest() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            calculator.sum(null, 3.0);
        });
        assertEquals("Número 1 e número 2 são obrigatórios.", exception.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando number2 for null na soma")
    void testSumWithNull2() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            calculator.sum(3.0, null);
        });
        assertEquals("Número 1 e número 2 são obrigatórios.", exception.getMessage());
    }

    // Testes para o método sub
    @Test
    @DisplayName("Deve subtrair dois números positivos corretamente")
    void subTest() {
        Double result = calculator.sub(10.0, 3.0);
        assertEquals(7.0, result);
    }

    @Test
    @DisplayName("Deve subtrair números negativos corretamente")
    void testSubNegativeNumbers() {
        Double result = calculator.sub(-5.0, -3.0);
        assertEquals(-2.0, result);
    }

    @Test
    @DisplayName("Deve subtrair resultando em número negativo")
    void testSubResultingNegative() {
        Double result = calculator.sub(3.0, 5.0);
        assertEquals(-2.0, result);
    }

    @Test
    @DisplayName("Deve lançar exceção quando number1 for null na subtração")
    void testSubWithNull1() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            calculator.sub(null, 3.0);
        });
        assertEquals("Número 1 e número 2 são obrigatórios.", exception.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando number2 for null na subtração")
    void testSubWithNull2() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            calculator.sub(3.0, null);
        });
        assertEquals("Número 1 e número 2 são obrigatórios.", exception.getMessage());
    }

    // Testes para o método divide
    @Test
    @DisplayName("Deve dividir dois números positivos corretamente")
    void divideTest() {
        Double result = calculator.divide(10.0, 2.0);
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Deve dividir números com resultado decimal")
    void testDivideWithDecimalResult() {
        Double result = calculator.divide(7.0, 2.0);
        assertEquals(3.5, result);
    }

    @Test
    @DisplayName("Deve dividir número negativo por positivo")
    void testDivideNegativeByPositive() {
        Double result = calculator.divide(-10.0, 2.0);
        assertEquals(-5.0, result);
    }

    @Test
    @DisplayName("Deve lançar exceção quando dividir por zero")
    void divisionByZeroTest() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10.0, 0.0);
        });
        assertEquals("Divisão por zero não é permitido.", exception.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando number1 for null na divisão")
    void testDivideWithNull1() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            calculator.divide(null, 3.0);
        });
        assertEquals("Número 1 e número 2 são obrigatórios.", exception.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando number2 for null na divisão")
    void testDivideWithNull2() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            calculator.divide(3.0, null);
        });
        assertEquals("Número 1 e número 2 são obrigatórios.", exception.getMessage());
    }

    // Testes para o método factorial
    @Test
    @DisplayName("Deve calcular fatorial de 0 corretamente")
    void testFactorialZero() {
        Integer result = calculator.factorial(0);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Deve calcular fatorial de 1 corretamente")
    void testFactorialOne() {
        Integer result = calculator.factorial(1);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Deve calcular fatorial de 5 corretamente")
    void factorialTest() {
        Integer result = calculator.factorial(5);
        assertEquals(120, result);
    }

    @Test
    @DisplayName("Deve calcular fatorial de 7 corretamente")
    void testFactorialSeven() {
        Integer result = calculator.factorial(7);
        assertEquals(5040, result);
    }

    @Test
    @DisplayName("Deve lançar exceção quando factorial for null")
    void testFactorialWithNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            calculator.factorial(null);
        });
        assertEquals("Número é obrigatório.", exception.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção para fatorial de número negativo")
    void testFactorialNegativeNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorial(-5);
        });
        assertEquals("Fatorial não pode ser calculado para números negativos.", exception.getMessage());
    }

    // Testes para o método integerToBinary
    @Test
    @DisplayName("Deve converter 1 para binário corretamente")
    void testIntegerToBinaryOne() {
        Integer result = calculator.integerToBinary(1);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Deve converter 5 para binário corretamente")
    void integerToBinaryTest() {
        Integer result = calculator.integerToBinary(5);
        assertEquals(101, result);
    }

    @Test
    @DisplayName("Deve converter 20 para binário corretamente")
    void testIntegerToBinaryTwenty() {
        Integer result = calculator.integerToBinary(20);
        assertEquals(10100, result);
    }

    @Test
    @DisplayName("Deve converter 0 para binário corretamente")
    void testIntegerToBinaryZero() {
        Integer result = calculator.integerToBinary(0);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Deve lançar exceção quando integer for null na conversão para binário")
    void testIntegerToBinaryWithNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            calculator.integerToBinary(null);
        });
        assertEquals("Número é obrigatório.", exception.getMessage());
    }

    // Testes para o método integerToHexadecimal
    @Test
    @DisplayName("Deve converter 1 para hexadecimal corretamente")
    void testIntegerToHexadecimalOne() {
        String result = calculator.integerToHexadecimal(1);
        assertEquals("1", result);
    }

    @Test
    @DisplayName("Deve converter 55 para hexadecimal corretamente")
    void integerToHexadecimalTest() {
        String result = calculator.integerToHexadecimal(55);
        assertEquals("37", result);
    }

    @Test
    @DisplayName("Deve converter 170 para hexadecimal corretamente")
    void testIntegerToHexadecimalOneSeventyZero() {
        String result = calculator.integerToHexadecimal(170);
        assertEquals("AA", result);
    }

    @Test
    @DisplayName("Deve converter 255 para hexadecimal corretamente")
    void testIntegerToHexadecimalTwoFiftyFive() {
        String result = calculator.integerToHexadecimal(255);
        assertEquals("FF", result);
    }

    @Test
    @DisplayName("Deve converter 0 para hexadecimal corretamente")
    void testIntegerToHexadecimalZero() {
        String result = calculator.integerToHexadecimal(0);
        assertEquals("0", result);
    }

    @Test
    @DisplayName("Deve lançar exceção quando integer for null na conversão para hexadecimal")
    void testIntegerToHexadecimalWithNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            calculator.integerToHexadecimal(null);
        });
        assertEquals("Número é obrigatório.", exception.getMessage());
    }

    // Testes para o método calculeDayBetweenDate
    @Test
    @DisplayName("Deve calcular dias entre datas corretamente - exemplo 1")
    void calculeDayBetweenDateTest() {
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        LocalDate date2 = LocalDate.of(2020, 3, 29);
        int result = calculator.calculeDayBetweenDate(date1, date2);
        assertEquals(14, result);
    }

    @Test
    @DisplayName("Deve calcular dias entre datas corretamente - ordem inversa")
    void testCalculeDayBetweenDateReversed() {
        LocalDate date1 = LocalDate.of(2020, 3, 29);
        LocalDate date2 = LocalDate.of(2020, 3, 15);
        int result = calculator.calculeDayBetweenDate(date1, date2);
        assertEquals(14, result);
    }

    @Test
    @DisplayName("Deve retornar 0 para datas iguais")
    void testCalculeDayBetweenSameDates() {
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        LocalDate date2 = LocalDate.of(2020, 3, 15);
        int result = calculator.calculeDayBetweenDate(date1, date2);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Deve calcular dias entre datas em anos diferentes")
    void testCalculeDayBetweenDateDifferentYears() {
        LocalDate date1 = LocalDate.of(2020, 12, 31);
        LocalDate date2 = LocalDate.of(2021, 1, 1);
        int result = calculator.calculeDayBetweenDate(date1, date2);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Deve lançar exceção quando date1 for null")
    void testCalculeDayBetweenDateWithNull1() {
        LocalDate date2 = LocalDate.of(2020, 3, 15);
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            calculator.calculeDayBetweenDate(null, date2);
        });
        assertEquals("As duas datas são obrigatórias.", exception.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando date2 for null")
    void testCalculeDayBetweenDateWithNull2() {
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            calculator.calculeDayBetweenDate(date1, null);
        });
        assertEquals("As duas datas são obrigatórias.", exception.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando ambas as datas forem null")
    void testCalculeDayBetweenDateWithBothNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            calculator.calculeDayBetweenDate(null, null);
        });
        assertEquals("As duas datas são obrigatórias.", exception.getMessage());
    }
}