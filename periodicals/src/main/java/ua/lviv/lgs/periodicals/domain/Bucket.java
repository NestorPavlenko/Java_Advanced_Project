package ua.lviv.lgs.periodicals.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Bucket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Periodical periodical;

    @Column
    private Date purchaseDate;

    public Bucket(Integer id, User user, Periodical periodical, Date purchaseDate) {
        this.id = id;
        this.user = user;
        this.periodical = periodical;
        this.purchaseDate = purchaseDate;
    }

    public Bucket(User user, Periodical periodical, Date purchaseDate) {
        this.user = user;
        this.periodical = periodical;
        this.purchaseDate = purchaseDate;
    }

    public Bucket(Integer id) {
        this.id = id;
    }

    public Bucket() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Periodical getPeriodical() {
        return periodical;
    }

    public void setPeriodical(Periodical periodical) {
        this.periodical = periodical;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bucket)) return false;
        Bucket bucket = (Bucket) o;
        return Objects.equals(id, bucket.id) && Objects.equals(user, bucket.user) && Objects.equals(periodical, bucket.periodical) && Objects.equals(purchaseDate, bucket.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, periodical, purchaseDate);
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", user=" + user +
                ", periodical=" + periodical +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
