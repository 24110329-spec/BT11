package vn.ute.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating_24110329 {

    @EmbeddedId
    private RatingId_24110329 id = new RatingId_24110329();

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "review_text", length = 1000)
    private String review_text;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("userid")
    @JoinColumn(name = "userid", nullable = false)
    private User_24110329 user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("bookid")
    @JoinColumn(name = "bookid", nullable = false)
    private Book_24110329 book;

    public Rating_24110329() {
    }

    public RatingId_24110329 getId() {
        return id;
    }

    public void setId(RatingId_24110329 id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public User_24110329 getUser() {
        return user;
    }

    public void setUser(User_24110329 user) {
        this.user = user;
    }

    public Book_24110329 getBook() {
        return book;
    }

    public void setBook(Book_24110329 book) {
        this.book = book;
    }
}
