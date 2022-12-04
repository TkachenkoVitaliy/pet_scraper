package ru.vtkachenko.pet_scraper.model;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "tag_html")
    private String tagHTML;

    public Tag() {
    }

    public Tag(Long id, String name, String tagHTML) {
        this.id = id;
        this.name = name;
        this.tagHTML = tagHTML;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagHTML() {
        return tagHTML;
    }

    public void setTagHTML(String tagHTML) {
        this.tagHTML = tagHTML;
    }
}
