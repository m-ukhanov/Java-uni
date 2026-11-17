package ua.opnu;

public class BookData implements Comparable<BookData> {

    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    public double getRating() {
        return reviews == 0 ? 0 : total/reviews;
    }

    @Override
    public int compareTo(BookData other) {
        int result = Double.compare(other.getRating(), this.getRating());

        if (result!=0) {
            return result;
        }

        return title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return this.title + " (" + author + ") - " + this.getRating();
    }
}
