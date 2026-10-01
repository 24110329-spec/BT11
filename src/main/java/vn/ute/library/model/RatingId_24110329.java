package vn.ute.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Khóa chính kép của bảng rating: userid + bookid.
 */
@Embeddable
public class RatingId_24110329 implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "userid")
    private Long userid;

    @Column(name = "bookid")
    private Long bookid;

    public RatingId_24110329() {
    }

    public RatingId_24110329(Long userid, Long bookid) {
        this.userid = userid;
        this.bookid = bookid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RatingId_24110329)) return false;
        RatingId_24110329 that = (RatingId_24110329) o;
        return Objects.equals(userid, that.userid)
                && Objects.equals(bookid, that.bookid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, bookid);
    }
}
