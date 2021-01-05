package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public int getPrintedCopies() {
        return printedCopies;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPurchasability() {
        return purchasability;
    }

    public int[] getChapters() {
        return chapters;
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

        /* JSONObject из json-строки строки */
        JSONObject jsonAuthor = new JSONObject("{"
                + "\"name\":\"Jones\","
                + "\"sex\":\"female\","
                + "\"language\":\"english\","
                + "\"age\":33"
                + "}");

        /* JSONArray из ArrayList */
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        JSONArray jsonChapters = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Book book = new Book(2000, "Tales",
                new Author("Smith", "male", "english", 33),
                true, 1, 2, 3);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("printedCopies", book.getPrintedCopies());
        jsonObject.put("title", book.getTitle());
        jsonObject.put("author", jsonAuthor);
        jsonObject.put("purchasability", book.isPurchasability());
        jsonObject.put("chapters", book.getChapters());

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект book в json-строку */
        System.out.println(new JSONObject(book).toString());
    }
}
