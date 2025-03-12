
package com.example.models;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "summary")
    private String summary;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "pageCount")
    private int pageCount;
    @Column(name = "isReserved")
    private boolean isReserved = false; // Pridėtas rezervavimo statusas

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "reserved_by_user_id", nullable = true) // Pridėta rezervacijos informacija
    private User reservedBy;

    // Constructors
    public Book() {}

    public Book(String title, String summary, String isbn, String imageUrl, int pageCount, Category category) {
        this.title = title;
        this.summary = summary;
        this.isbn = isbn;
        this.imageUrl = imageUrl;
        this.pageCount = pageCount;
        this.category = category;
    }

    // Getters and Setters
    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public User getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(User reservedBy) {
        this.reservedBy = reservedBy;
    }
}


import javax.validation.constraints.NotNull;

@NotNull
private String title;

@NotNull
private String isbn;

private int pages;
