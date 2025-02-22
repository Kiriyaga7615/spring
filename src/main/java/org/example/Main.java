package org.example;

import org.example.model.Cart;
import org.example.repositorz.ProductRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        Cart cart = new Cart();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Показать все товары");
            System.out.println("2. Добавить товар в корзину");
            System.out.println("3. Удалить товар из корзины");
            System.out.println("4. Показать корзину");
            System.out.println("5. Выход");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Товары в наличии:");
                    productRepository.getAllProducts().forEach(System.out::println);
                    break;

                case 2:
                    System.out.println("Введите id товара, который хотите добавить в корзину:");
                    Long addProductId = scanner.nextLong();
                    productRepository.getProductById(addProductId)
                            .ifPresentOrElse(cart::addProduct,
                                    () -> System.out.println("Товар с таким id не найден"));
                    break;

                case 3:
                    System.out.println("Введите id товара, который хотите удалить из корзины:");
                    Long removeProductId = scanner.nextLong();
                    cart.removeProduct(removeProductId);
                    break;

                case 4:
                    System.out.println("Товары в корзине:");
                    cart.getProducts().forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Выход...");
                    return;

                default:

                    System.out.println("Некорректный ввод.");
            }
        }
    }
}