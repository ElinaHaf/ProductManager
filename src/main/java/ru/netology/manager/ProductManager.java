package ru.netology.manager;

import ru.netology.domein.Product;
import ru.netology.repository.ProductRepository;


public class ProductManager {

    protected ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);

    }

    public Product[] getFindAll() {
        Product[] all = repo.getFindAll();
        return all;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];

        for (Product product : repo.getFindAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }

    }
}

