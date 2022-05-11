package Common;

import com.github.javafaker.Faker;

import java.util.Random;

public class RestUtil {
    String author;
    String quote;
    int quoteId;

    public static String getQuotes() {
        Random random = new Random();
        String[] quotes = {"Never let your schooling interfere with your education.",
                "All we have to decide is what to do with the time that is given us.",
                "It matters not what someone is born, but what they grow to be.",
                "Not all those who wander are lost."};
         String quote = quotes[random.nextInt(quotes.length)];
        return quote;
    }

    public void setQuotes(String quote) {
        this.quote = quote;
    }

    public static String getAuthor() {
        Faker faker = new Faker();
        String author = faker.book().author();
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }
}
