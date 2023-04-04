package rikkeiacademy.service;

import rikkeiacademy.config.Config;
import rikkeiacademy.model.Product;

import java.util.List;

public class ProductServiceIMPL implements IProductService {
    List<Product> productList = new Config<Product>().readFromFile(Config.PATH_PRODUCT);


    @Override
    public List<Product> findAll() {
        return productList;
    }

    // thêm và update
    @Override
    public void save(Product product) {
        // trường hợp ko có id nào thì vào trường hợp create
        if (findById(product.getId()) == null) {
            productList.add(product);
        } else {
            // ngược lại thì update
            productList.set(productList.indexOf(product.getId()), product);
        }
        // đọc file product
        new Config<Product>().writeToFile(Config.PATH_PRODUCT,productList);
    }

    @Override
    public Product findById(int id) {
        for (Product pro : productList) {
            if (pro.getId() == id) {
                return pro;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (Product pro : productList) {
            if (pro.getId() == id) {
                productList.remove(pro);
                new Config<Product>().writeToFile(Config.PATH_PRODUCT, productList);
            }
        }
    }

}
