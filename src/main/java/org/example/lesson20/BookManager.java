package org.example.lesson20;

public class BookManager {
    private BookService service;

    public BookManager(BookService service) {
        this.service = service;
    }

    public void checkOut(int bookId, int memberId) {
        if(service.inStock(bookId)) {
            service.lend(bookId, memberId);
        } else {
            throw new IllegalStateException("Book is not available!");
        }
    }
}
