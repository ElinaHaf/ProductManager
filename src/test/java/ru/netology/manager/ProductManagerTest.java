package ru.netology.manager;

import ru.netology.domein.Product;
import ru.netology.repository.ProductRepository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {


    Product product1 = new Product(11, "Моя жизнь", 12);
    Product product2 = new Product(2, "Nokia", 102);
    Product product3 = new Product(7, "Кочевник", 30);
    Product product4 = new Product(101, "Samsung", 400);
    Product product5 = new Product(10, "Nokia", 40);


    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    @Test
    public void shouldAddProducts() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);


        Product[] expected = {product1, product2, product3};
        Product[] actual = manager.getFindAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByText() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("Nokia");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByNonExistentText() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Колобок");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchBySimilarProduct() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product5);


        Product[] expected = {product2, product5};
        Product[] actual = manager.searchBy("Nokia");

        Assertions.assertArrayEquals(expected, actual);
    }

}

