package org.example.lesson20;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    // Jira - ticket
    // Continuous Integration - Pull Request/Merge Request
    // TDD - Test Driven Development
    @Test
    public void testMultiply() {
        Calculator c = new Calculator();
        assertEquals(
                "testMultiply 4 * 3 == 12",
                12.0,
                c.multiply(4, 3),
                0.0001
        );
    }

    @Test
    public void testSubtract() {
        Calculator c = new Calculator();
        assertEquals(
                "testSubtract 4 - 3 == 1",
                1.0,
                c.subtract(4, 3),
                0.0001
        );
    }

    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        assertEquals(
                "testAdd 4 + 3 == 7",
                7.0,
                c.add(4, 3),
                0.0001
        );
    }

    @Test
    public void testDivide() {
        Calculator c = new Calculator();
        assertEquals(
                "testDivide 12 / 4 == 3",
                3,
                c.divide(12, 4),
                0.001);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testDividedByZero(){
        exception.expect(ArithmeticException.class);
        exception.expectMessage("Division by zero");
        Calculator c = new Calculator();
        c.divide(10,0);
    }

    @Before  // запускается перед каждым тестом
    public void init(){
        System.out.println("init");
    }

    @After // после каждого тестового метода
    public void tearDown(){
        System.out.println("tearDown");
    }

    @BeforeClass // выполняется однократно до всех методов класса
    public static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterClass// выполняется однократно после всех методов класса
    public static void afterAll() {
        System.out.println("afterAll");
    }
}
