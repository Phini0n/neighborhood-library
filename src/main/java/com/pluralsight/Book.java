package com.pluralsight;

public class Book {
    // Properties
    private static int bookCount = 0000;
    private String id; // Auto-generated by the bookCount. Cannot be set by anything else.
    private String isbn;
    private String title;
    private boolean isCheckedOut = false;
    private String checkedOutTo;

    // Constructor, Getter & Setters
    public Book(String isbn, String title) {
        bookCount++;
        id = String.format("%04d", bookCount);
        this.isbn = isbn;
        this.title = title;
    }

    public static int getBookCount() { return bookCount; }

    public String getId() { return id; }

    public String getIsbn() { return isbn; }

    public String getTitle() { return title; }

    public boolean isCheckedOut() { return isCheckedOut; }

    public String getCheckedOutTo() { return checkedOutTo; }

    public void setIsbn(String isbn) { this.isbn = isbn; }

    public void setTitle(String title) { this.title = title; }

    public void setCheckedOut(boolean checkedOut) { isCheckedOut = checkedOut; }

    public void setCheckedOutTo(String checkedOutTo) { this.checkedOutTo = checkedOutTo; }

    // Methods
    public void checkOut (String name) {
        this.checkedOutTo = name;
        this.isCheckedOut = true;
    }

    public void checkIn() {
        this.checkedOutTo = "";
        this.isCheckedOut = false;
    }

    @Override
    public String toString() {
        if (isCheckedOut) {
            return "ID: " + id + " | ISBN: " + isbn + " | Title: " + title + " | Checked Out To: " + checkedOutTo;
        } else {
            return "ID: " + id + " | ISBN: " + isbn + "|  Title: " + title;
        }
    }
}

