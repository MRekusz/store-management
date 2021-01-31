import api.ProductService;
import api.UserRegisterLoginFacade;
import entity.Boots;
import entity.Cloth;
import entity.Product;
import facade.UserRegisterLoginFacadeImplementation;
import service.ProductServiceImplementation;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public void startMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Zaloguj się");
        System.out.println("2 - Zarejestruj się");
        System.out.println("0 - Wyjdź");
    }

    public static void loggedMenu(){
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Dodaj nowy product");
        System.out.println("0 - Wyloguj się");
    }

    public static void productTypeMenu() {
        System.out.println("1 - Dodaj buty");
        System.out.println("2 - Dodaj ubrania");
        System.out.println("3 - Inne");
    }

    public static Product createOtherProduct() {
        String productName, color;
        Float price, weight;
        Integer count;
        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Color: ");
        color = scanner.next();

        System.out.println("Count: ");
        count = scanner.nextInt();

        return new Product(1, productName, price, weight, color, count);
    }

    public static Boots createBootsProduct(){
        String productName, color;
        Double price, weight;
        Integer count, size;
        Boolean isNaturalSkin;

        System.out.println("Product name");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextDouble();

        System.out.println("Weight: ");
        weight = scanner.nextDouble();

        System.out.println("Color: ");
        color = scanner.next();

        System.out.println("Count: ");
        count = scanner.nextInt();

        System.out.println("Size: ");
        size = scanner.nextInt();

        System.out.println("Is natural skin: ");
        isNaturalSkin = scanner.nextBoolean();


        return new Boots(1, productName, price, weight, color, count, size, isNaturalSkin);
    }

    public static Product createClothProduct() {
        String productName, color, size, material;
        Float price, weight;
        Integer count;

        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Color: ");
        color = scanner.next();

        System.out.println("Count: ");
        count = scanner.nextInt();

        System.out.println("Size: ");
        size = scanner.next();

        System.out.println("Material: ");
        material = scanner.next();


        return new Cloth(1, productName, price, weight, color, count, size, material);
    }

    public static void main(String[] args) {

        UserRegisterLoginFacade userFacade = UserRegisterLoginFacadeImplementation.getInstance();
        ProductService productService = ProductServiceImplementation.getInstance();
        boolean appOn = true;
        boolean loggedOn = false;
        int read;




    }
}
