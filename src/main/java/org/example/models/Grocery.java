package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void startGrocery() {

        int choice;

        do {
            System.out.println("Yapılmasını istediğiniz işlemi seçiniz.");
            System.out.println("\n0: Çıkış");
            System.out.println("1: Eklemek");
            System.out.println("2: Çıkarmak");
            System.out.print("Seçiminiz: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // buffer temizleme

            switch (choice) {

                case 1:
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz: ");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;

                case 2:
                    System.out.print("Çıkarılmasını istediğiniz elemanları giriniz: ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;

                case 0:
                    System.out.println("Uygulama kapatıldı.");
                    break;

                default:
                    System.out.println("Geçersiz seçim!");
            }

        } while (choice != 0);

        scanner.close();
    }

    public static void addItems(String itemsToAdd) {

        String[] splitItems = itemsToAdd.split(",");

        for (String item : splitItems) {

            String trimmedItem = item.trim().toLowerCase();

            if (!checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            } else {
                System.out.println(trimmedItem + " zaten listede var.");
            }
        }

        printSorted();
    }

    public static void removeItems(String input) {

        String[] items = input.split(",");

        for (String item : items) {

            String trimmedItem = item.trim().toLowerCase();

            if (checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
            } else {
                System.out.println(trimmedItem + " listede yok.");
            }
        }

        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Güncel Liste: " + groceryList);
    }
}