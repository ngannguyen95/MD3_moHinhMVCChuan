package rikkeiacademy.controller;

import rikkeiacademy.model.Product;
import rikkeiacademy.service.IProductService;
import rikkeiacademy.service.ProductServiceIMPL;

import java.util.List;

public class ProductController {
    public IProductService productService = new ProductServiceIMPL();

    public List<Product> getListproduct(){
        return productService.findAll();
    }
    // xây dựng phương thức này cả thêm mới và sửa
    public void createProduct(Product product){
        productService.save(product);
    }
    public void updateProduct(Product product){
        productService.save(product);
    }
    // phương thức show
    public Product detailProduct(int id){
       return productService.findById(id);
    }
    public void deleteProduct(int id){
        productService.deleteById(id);
    }

}
