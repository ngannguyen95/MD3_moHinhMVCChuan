package rikkeiacademy.view;

import rikkeiacademy.config.Config;
import rikkeiacademy.controller.CategoryController;
import rikkeiacademy.controller.ProductController;
import rikkeiacademy.model.Category;
import rikkeiacademy.model.Product;

import javax.naming.ldap.Control;
import java.util.List;

public class ProductView {
    ProductController productController = new ProductController();
    List<Product> productList = productController.getListproduct();

    CategoryController categoryController = new CategoryController();
    List<Category> categoryList = categoryController.getListCategory();

    public void showProduct() {
        System.out.println("**********PRODUCT************");
        System.out.println("---ID---PRODUCT NAME---PRICE---CATERORY");
        for (Product product : productList) {
            System.out.println("---" + product.getId() + "---" + product.getProductName() + "---" + product.getPrice() + "---" + product.getCategory().getName());
        }
    }

    public void createProduct() {
        Product product = new Product();
        if (productList.size() == 0) {
            product.setId(1);
        } else {
            product.setId(productList.get(productList.size() - 1).getId() + 1);
        }
        System.out.print("Nhập vảo tên sản phẩm: ");
        product.setProductName(Config.scanner().nextLine());
        System.out.println("Nhập vào giá sản phẩm: ");
        product.setPrice(Config.scanner().nextFloat());
        for (Category cata : categoryList) {
            System.out.println(cata);
        }
        System.out.println("Chọn Catagory theo id:");
        int id = Config.scanner().nextInt();
        for (Category cata : categoryList) {
            if (cata.getId() == id) {
                product.setCategory(cata);
            }
        }
        productController.createProduct(product);
    }

    public void updateProduct() {
        while (true) {
            System.out.print("Nhập vào id cần sửa: ");
            int id = Config.scanner().nextInt();
            if (productController.detailProduct(id) == null) {
                System.out.println("Id không tồn tại, vui lòng nhập lại!!");
            } else {

                System.out.println("Nhập vào tên cần sửa: ");
                String productName = Config.scanner().nextLine();
                System.out.println("Nhập  vào giá cần sửa:");
                Float price = Config.scanner().nextFloat();

                for (Category c : categoryList) {
                    System.out.println(c);
                }
                Category category = null;
                System.out.println("Nhập vào id Caterory cần sửa:  ");
                int idUpdate = Config.scanner().nextInt();
                for (Category cata : categoryList) {
                    if (cata.getId() == idUpdate) {
                        category = cata;
                    }
                }
                Product product = new Product(id, productName, price, category);
                productController.updateProduct(product);
            }
        }
    }

}
