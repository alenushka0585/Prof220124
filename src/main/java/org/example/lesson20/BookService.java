package org.example.lesson20;

public interface BookService {
    //проверять доступна ли книга для выдачи
    boolean inStock (int bookId);

    //выдаем книгу пользователю
    void lend (int bookId, int memberId);
}

