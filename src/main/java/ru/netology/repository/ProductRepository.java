package ru.netology.repository;

import ru.netology.product.Product;

public class ProductRepository {
    private Product[] product = new Product[0];

    public void add(Product products) {
        Product[] tmp = new Product[product.length + 1];
        for (int i = 0; i < product.length; i++) {
            tmp[i] = product[i];
        }
        tmp[tmp.length - 1] = products;
        product = tmp;
    }

    public Product[] findAllProduct() {
        return product;
    }

    public void remove(int id) {
        Product[] tmp = new Product[product.length - 1];
        int ind = 0;
        for (Product products : product) {
            if (products.getId() != id) {
                tmp[ind] = products;
                ind++;
            }
        }
        product = tmp;

    }

    public Product findId(int id) {
        for (Product products : product) {
            if (products.getId() == id) {
                return products;
            }
        }
return null;
    }
}




