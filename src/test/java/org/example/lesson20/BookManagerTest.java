package org.example.lesson20;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class BookManagerTest {
    @Test
    public void normalCheckoutTest() {
        //Mock / Заглушка - реализация класса или интерфейса
        // которая позволяет настраивать результаты вызова метода заглушаемого класа

        BookService service = Mockito.mock(BookService.class);

        //настройка поведения заглушки
        when(service.inStock(100)).thenReturn(true);
        BookManager manager = new BookManager(service);

        // хотим сдать книгу 100 пользователю 300
        manager.checkOut(100, 300);
        // расчитываем что вызовется
        // service.inStock(100)
        verify(service).inStock(100);
        // а потом вызовется
        // service.lend(100, 300)
        verify(service).lend(100, 300);

        verify(service, atLeast(1)).inStock(anyInt());
        verify(service, atMost(20)).lend(100, 300);

        // никаких больше взаимодействий с заглушкой не было
        verifyNoMoreInteractions(service);

    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void bookIsNotAvailableTest() {
        BookService service = Mockito.mock(BookService.class);
        when(service.inStock(500)).thenReturn(false);

        BookManager manager = new BookManager(service);
        try {
            manager.checkOut(500, 300);
            verify(service.inStock(500));

        } catch (Exception e) {
            System.out.println(e);
        //            exception.expect(IllegalStateException.class);
        //            exception.expectMessage("Book is not available!");
            assertThat(e, Matchers.instanceOf(IllegalStateException.class));
            assertEquals(e.getMessage(), "Book is not available!");
        }

        // метод заглушки вызывался ровно один раз
        verify(service, times(1)).inStock(500);

        // не было попытки выдать книгу - метод никогда не вызывался
        verify(service, never()).lend(anyInt(), anyInt());

        verifyNoMoreInteractions(service);
    }
}
