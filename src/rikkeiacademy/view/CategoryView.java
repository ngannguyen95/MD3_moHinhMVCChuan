package rikkeiacademy.view;

import rikkeiacademy.config.Config;
import rikkeiacademy.controller.CategoryController;
import rikkeiacademy.model.Category;

import java.util.List;

public class CategoryView {
    CategoryController categoryController = new CategoryController();
    List<Category> categoryList = categoryController.getListCategory();

    public void showFormCategoryList() {
        System.out.println("----------TABLE CATEGORY------------");
        System.out.println("----ID----NAME----");
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println("----" + categoryList.get(i).getId() + "----" + categoryList.get(i).getName() + "----");
        }
        System.out.println("Enter the back to return Menu: ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Navbar();
        }
    }

    public void formCreateCategory() {
        while (true) {
            int id = 0;
            if (categoryList.size() == 0) {
                id = 1;
            } else {
                id = categoryList.get(categoryList.size() - 1).getId() + 1;
            }
            System.out.println("Enter the name: ");
            String name = Config.scanner().nextLine();
            Category category = new Category(id, name);
            categoryController.createCategoryToDB(category);
            System.out.println("Create Succsess!!");
            System.out.println("Enter the any key to continur or Enter the back to return Menu");
            // trở về menu
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new Navbar();
                break;
            }
        }
    }

    public void formUpdateCategory() {
        while (true) {
            System.out.println("Enter the id to update:");
            int id = Config.scanner().nextInt();
            if (categoryController.detailCategory(id) == null) {
                System.out.println("Id not found!please try again ");
            } else {
                System.out.println("Enter the name:");
                String name = Config.scanner().nextLine();
                Category category = new Category(id, name);
                System.out.println("Update succsess");
                System.out.println("Enter the any key to continur or Enter the back to return Menu");
                // trở về menu
                String backMenu = Config.scanner().nextLine();
                if (backMenu.equalsIgnoreCase("back")) {
                    new Navbar();
                    break;
                }
            }
        }
    }

    public void deleteCategory() {
        while (true){
            System.out.println("Enter the id to delete: ");
            int id=Config.scanner().nextInt();
            if (categoryController.detailCategory(id)==null){
                System.out.println("Id not found!please try again");
            }else {
                categoryController.deleteCategory(id);
                System.out.println("Delete succsess");
            }
            System.out.println("Enter the any key to continur or Enter the back to return Menu");
            // trở về menu
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new Navbar();
                break;
            }
        }

    }


}
