package com.example.MyAppleStore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "price")
    private int price;
    @Column(name = "city")
    private String city;
    @Column(name = "author")
    private String author;
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product") //TODO CascadeType.ALL - удаляем сразу все фотографии при удалении товара ; mappedBy = "product" - отсылаемся на продукт в изображении и создастся ID
private List<Image> images = new ArrayList<>();
private Long previewImageId;
private LocalDateTime dateofCreated; // знать, когда был создан товар
    @PrePersist
    private void init() {
        dateofCreated = LocalDateTime.now();
    }
    public void addImageToProduct(Image image) {
        image.setProduct(this);
        images.add(image);
    }
}
