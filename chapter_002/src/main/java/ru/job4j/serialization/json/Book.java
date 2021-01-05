package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Book {
    private final int printedCopies;
    private final String title;
    private final Author author;
    private final boolean purchasability;
    private final int[] chapters;

    public Book(int printedCopies, String title, Author author, boolean purchasability, int... chapters) {
        this.printedCopies = printedCopies;
        this.title = title;
        this.author = author;
        this.purchasability = purchasability;
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "Book{"
                + "printedCopies=" + printedCopies
                + ", title='" + title + '\''
                + ", author=" + author
                + ", purchasability=" + purchasability
                + ", chapters=" + Arrays.toString(chapters)
                + '}';
    }

    public static void main(String[] args) {
        final Book book = new Book(2000, "Tales", new Author("Smith", "male", "english", 33), true, 1, 2, 3);

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(book));

        final String bookJson =
                "{"
                        + "\"printedCopies\":300,"
                        + "\"title\":\"Stories\","
                        + "\"author\":"
                        + "{"
                        + "\"name\":\"Jones\","
                        + "\"sex\":\"female\","
                        + "\"language\":\"english\","
                        + "\"age\":33"
                        + "},"
                        + "\"purchasability\":false,"
                        + "\"chapters\":[1, 2, 3, 4]"
                        + "}";
        final Book bookMod = gson.fromJson(bookJson, Book.class);
        System.out.println(bookMod);
    }
}
