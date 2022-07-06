package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domein.Product;
import ru.netology.exceptions.NotFoundException;


public class ProductRepositoryTest {

    Product product1 = new Product(11, "Моя жизнь", 12);
    Product product2 = new Product(2, "Nokia", 102);
    Product product3 = new Product(7, "Кочевник", 30);
    Product product4 = new Product(101, "Samsung", 400);

    @Test
    public void shouldSaveItems() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.getFindAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdItems() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        repo.removeById(product2.getId());

        Product[] expected = {product1, product3};
        Product[] actual = repo.getFindAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdAllItems() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        repo.removeById(product1.getId());
        repo.removeById(product2.getId());
        repo.removeById(product3.getId());


        Product[] expected = {};
        Product[] actual = repo.getFindAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        repo.removeById(2);

        Product[] expected = {product1, product3};
        Product[] actual = repo.getFindAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdWithException() {
        ProductRepository repo = new ProductRepository();

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(17);
        });

    }


}
