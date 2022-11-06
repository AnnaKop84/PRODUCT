package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.product.Book;
import ru.netology.product.SmartPhone;
import ru.netology.product.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Product book1 = new Book(1, "Книга 1", 100, "Иванов И.И.");
    Product book2 = new Book(2, "Книга 2", 200, "Петров И.И");
    Product book3 = new Book(3, "Книга 4 ", 543, "Сидоров В.В");

    Product phone1 = new SmartPhone(4, "Sam1", 1000, "Samsung");
    Product phone2 = new SmartPhone(5, "Sam2", 5000, "Samsung");
    Product phone3 = new SmartPhone(6, "Sam3", 4000, "Samsung");

    @BeforeEach
    void setup() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(phone1);
        repository.add(phone2);
        repository.add(phone3);
    }

    @Test
    void shouldFindIdTrue() {
        Product expect = book3;
        int id = 3;
        assertEquals(expect, repository.findId(id));
    }

    @Test
    void shouldFindIdFalse() {

        int id = 32;
        assertNull(repository.findId(id));
    }

    @Test
    void shouldRemoveId() {
        Product[] expect = new Product[]{
                book1, book2, book3, phone1, phone3};
        int id = 5;
        repository.remove(id);
        assertArrayEquals(expect, repository.findAllProduct());
    }

    @Test
    void shouldAddProduct() {
        Product book4 = new Book(7, "Книга4", 400, "Петров П.О");
        Product[] expect = new Product[]{
                book1, book2, book3, phone1, phone2, phone3, book4};
        repository.add(book4);
        assertArrayEquals(expect, repository.findAllProduct());
    }
}


