package ru.netology.manager;

import ru.netology.product.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository = new ProductRepository();

    public void add(Product productAdd) {
        repository.add(productAdd);
    }

    public Product[] findAllProduct() {
        return repository.findAllProduct();
    }

    public void remove(int id) {
        repository.remove(id);
    }

    public Product[] searchBy(String text) {
        Product[] results = new Product[0];
        for (Product products : repository.findAllProduct()) {
            if (matches(products, text)) {
                Product[] tmp = new Product[results.length + 1];
                int i=0;
                for (Product result:results) {
                    tmp[i] = result;
                    i++;
                }
                tmp[results.length]=products;
                results = tmp;
            }
        }
        return results;


    }


    public boolean matches(Product products, String search) {
        if (products.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}

