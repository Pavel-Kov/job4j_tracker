package ru.job4j.tracker.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Сказаки", 100);
        Book book2 = new Book("Стихи", 80);
        Book book3 = new Book("Clean code", 200);
        Book book4 = new Book("Рассказы", 500);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        for (Book book : books) {
            System.out.println(
                    "Название книги: " + book.getName() + ", "
                    + "Кол-во страниц: " + book.getPage());
        }

        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;

        for (Book book : books) {
            System.out.println(
                    "Название книги: " + book.getName() + ", "
                            + "Кол-во страниц: " + book.getPage());
        }

        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(
                        "Название книги: " + book.getName() + ", "
                                + "Кол-во страниц: " + book.getPage());
            }
        }

    }
}
