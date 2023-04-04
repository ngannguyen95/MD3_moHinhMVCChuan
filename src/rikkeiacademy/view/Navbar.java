package rikkeiacademy.view;

import rikkeiacademy.config.Config;

public class Navbar {
    public Navbar() {
        System.out.println("****************CATEGORY NAME***************");
        System.out.println("1.Show list Category");
        System.out.println("2.Create Category");
        System.out.println("3.Update Category");
        System.out.println("4. Delete Category");
        int choise = Config.scanner().nextInt();
        switch (choise) {
            case 1:
                new CategoryView().showFormCategoryList();
                break;
            case 2:
                new CategoryView().formCreateCategory();
                break;
            case 3:
                new CategoryView().formUpdateCategory();
                break;
            case 4:
                new CategoryView().deleteCategory();
                break;

        }
    }

    public static void productManager() {
        while (true) {
            System.out.println("**********PRODUCT MANAGEMENT *************");
            System.out.println("1.Show List Product");
            System.out.println("2.Create Product");
            System.out.println("3.Update Product");
            System.out.println(" Nhập vào lựa chọn: ");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    new ProductView().showProduct();
                    break;
                case 2:
                    new ProductView().createProduct();
                    break;
                case 3:
                    new ProductView().updateProduct();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Navbar.productManager();
    }
}
