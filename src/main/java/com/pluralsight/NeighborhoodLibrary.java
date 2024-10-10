package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    public static void main(String[] args) {

        Book[] inventory = new Book[20];
        inventory[0] = new Book("0786965601", "Player's Handbook. 5th Edition");
        inventory[1] = new Book("1338111002", "City of Ghosts");
        inventory[2] = new Book("1538725428", "Play Nice: The Rise, Fall, and Future Of Blizzard Entertainment");
        inventory[3] = new Book("1338111043", "Tunnel of Bones (City of Ghosts)");
        inventory[4] = new Book("1538725428", "Cemetery Boys");

        while (true) {

            System.out.print("Hello, welcome to your neighborhood library!\n\n" +
                    "1) Show Available Books - Shows books in the library's inventory that can be checked out\n" +
                    "2) Show Checked Out Books - Shows books checked out from the library's inventory\n" +
                    "3) Exit - Exits the application\n" +
                    "Enter: ");

            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                // Show Available Books
                case 1:
                    listBooks(inventory);
                    continue;
                // Show Checked Out Books
                case 2:
                    continue;
                // Exit
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid input!");
                    continue;
            }
        }
    }

    public static void listBooks(Book[] books) {
        System.out.println("-----");
        for (Book book : books) {
            if (book != null && !book.isCheckedOut()) {
                System.out.println(book);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        System.out.println("-----");
    }

}
