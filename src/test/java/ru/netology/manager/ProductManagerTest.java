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

public class ProductManagerTest {

    ProductRepository repo = Mockito.mock(ProductRepository.class);
    ProductManager managerMockito = new ProductManager();

    ProductManager managerNothing = new ProductManager();
    ProductManager managerOneProduct = new ProductManager();
    ProductManager managerAll = new ProductManager();
    Product book1 = new Book(1, "Книга 1", 100, "Иванов И.И.");
    Product book2 = new Book(2, "Книга 2", 200, "Петров И.И");
    Product book3 = new Book(3, "Книга 4 ", 543, "Сидоров В.В");

    Product phone1 = new SmartPhone(4, "Sam1", 1000, "Samsung");
    Product phone2 = new SmartPhone(5, "Sam2", 5000, "Samsung");
    Product phone3 = new SmartPhone(6, "Sam3", 4000, "Samsung");

    @BeforeEach
    void setup() {
        managerOneProduct.add(book1);
        managerAll.add(book1);
        managerAll.add(book2);
        managerAll.add(book3);
        managerAll.add(phone1);
        managerAll.add(phone2);
        managerAll.add(phone3);
    }

    @Test
    void shouldAddRepositoryEmpty() {
        Product[] expect = new Product[]{phone1};
        managerNothing.add(phone1);
        assertArrayEquals(expect, managerNothing.findAllProduct());
    }

    @Test
    void shouldAddRepositoryOneItem() {
        Product[] expect = new Product[]{
                book1,
                phone1};
        managerOneProduct.add(phone1);
        assertArrayEquals(expect, managerOneProduct.findAllProduct());
    }

    @Test
    void shouldAddRepositoryAll() {
        Product book10 = new Book(7, "Книга7", 230, "Иванов С.С");
        Product[] expect = new Product[]{
                book1, book2, book3, phone1, phone2, phone3, book10};
        managerAll.add(book10);
        assertArrayEquals(expect, managerAll.findAllProduct());
    }

    @Test
    void shouldDeleteIdRepositoryOne() {
        int id = 1;
        Product[] expect = new Product[0];
        managerOneProduct.remove(id);
        assertArrayEquals(expect, managerOneProduct.findAllProduct());

    }

    @Test
    void shouldDeleteIdRepositoryAll() {
        int idBook = 2;
        int idPhone = 5;
        Product[] expect = new Product[]{
                book1, book3, phone1, phone3};
        managerAll.remove(idBook);
        managerAll.remove(idPhone);

        assertArrayEquals(expect, managerAll.findAllProduct());

    }

    @Test
    void shouldMatchTrue() {
        assertTrue(managerNothing.matches(phone2, "Sam2"));


    }

    @Test
    void shouldMatchFalse() {
        assertFalse(managerNothing.matches(phone2, "Sam3"));
    }

    @Test
    void shouldSearchBy() {
        Product[] returnEmpty = new Product[0];
        doReturn(returnEmpty).when(repo).findAllProduct();
        Product[] expect = new Product[0];
        assertArrayEquals(expect, managerMockito.searchBy(""));
    }


}


