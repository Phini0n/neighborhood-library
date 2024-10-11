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

        System.out.println("Hello, welcome to your neighborhood library!\n");
        while (true) {
            System.out.print("""
                    Main Menu
                    1) Show Available Books - Shows books in the library's inventory that can be checked out
                    2) Show Checked Out Books - Shows books checked out from the library's inventory
                    X) Exit - Exits the application
                    Enter:\s""");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input.toUpperCase()) {
                // Show Available Books
                case "1":
                    listBooks(inventory, true, scanner);
                    continue;
                // Show Checked Out Books
                case "2":
                    listBooks(inventory, false, scanner);
                    continue;
                // Exit
                case "X":
                    System.out.println("Goodbye!");
                    scanner.close();
                    break;
                default:
                    System.out.println("\nInvalid input!\n");
                    continue;
            }
            break;
        }
    }

    public static void listBooks(Book[] books, boolean isCheckOut, Scanner scanner) {
        System.out.println("-----");

        //Prints Books that aren't checked out and begins check in process
        if (isCheckOut) {
            System.out.println("Available Books: ");
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

            promptCheckInCheckout(books, isCheckOut, scanner);
        }
        // Prints Books that are checked out and begins check out process
        else {
            System.out.println("Checked Out Books: ");
            for (Book book : books) {
                if (book != null && book.isCheckedOut()) {
                    System.out.println(book);
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }

            System.out.println("-----");

            promptCheckInCheckout(books, isCheckOut, scanner);
        }
    }

    public static void promptCheckInCheckout(Book[] books, boolean isCheckOut, Scanner scanner) {
        String operation = isCheckOut ? "check out" : "check in";
        System.out.print("Would you like to " + operation + " a book?\n" +
                "C) Continue\n" +
                "X) Return to Main Menu\n" +
                "Enter: ");
        String s = scanner.nextLine();
        switch (s.toUpperCase()) {
            case "C" :
                // If we're checking out, pass to checkOutBook Method.
                if (isCheckOut) {
                    checkOutBook(books, scanner);
                // Else, we pass to checkInBook Method.
                } else {
                    checkInBook(books, scanner);
                }
            break;
            case "X":
                System.out.println("\nReturning to main menu...\n");
                break;
            default:
                System.out.println("\nError, invalid input! Returning to Main Menu...\n");
                break;
        }
    }

    public static void checkOutBook(Book[] books, Scanner scanner) {
        System.out.print("Enter your Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter a book ID: ");
        String bookID = scanner.nextLine();

        // Replaces leading zeros in ID and subtracts by 1 to get the inventory's index.
        Book checkedOutBook = books[Integer.parseInt(bookID.replaceFirst("^0+(?!$)", "")) - 1];

        // Checks if book entered is available to check out
        if (checkedOutBook.isCheckedOut()) {
            System.out.println("\nSorry, that book is not available.\n");
        } else {
            checkedOutBook.checkOut(name);
            System.out.println("\n" + checkedOutBook.getTitle() + " is checked out!\n");
        }
    }

    public static void checkInBook(Book[] books, Scanner scanner) {
        System.out.print("Enter the book ID: ");
        String bookID = scanner.nextLine();

        // Replaces leading zeros in ID and subtracts by 1 to get the inventory's index.
        Book checkedInBook = books[Integer.parseInt(bookID.replaceFirst("^0+(?!$)", "")) - 1];

        // Checks if book entered is checked in or not
        if (!checkedInBook.isCheckedOut())
        {
            System.out.println("\nThat book is not checked out!\n");
        } else {
            checkedInBook.checkIn();
            System.out.println("\n" + checkedInBook.getTitle() + " is checked in!\n");
        }
    }
}
