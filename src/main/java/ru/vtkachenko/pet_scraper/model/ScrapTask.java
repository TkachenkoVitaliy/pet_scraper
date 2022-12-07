package ru.vtkachenko.pet_scraper.model;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@TypeDefs({
        @TypeDef(
                name = "string-array",
                typeClass = StringArrayType.class
        )
})
@Entity
@Table(name = "tasks")
public class ScrapTask extends PreliminaryTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String competitor;

    private String url;

    //TODO придумать как это нормально реализовать
    @Type(type = "string-array")
    @Column(
            name = "selectors",
            columnDefinition = "text[]"
    )
    private String[] selectors;

    public ScrapTask() {
    }

    public ScrapTask(String title, String competitor, String url, String[] selectors) {
        this.title = title;
        this.competitor = competitor;
        this.url = url;
        this.selectors = selectors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompetitor() {
        return competitor;
    }

    public void setCompetitor(String competitor) {
        this.competitor = competitor;
    }

    public String[] getSelectors() {
        return selectors;
    }

    public void setSelectors(String[] selectors) {
        this.selectors = selectors;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
