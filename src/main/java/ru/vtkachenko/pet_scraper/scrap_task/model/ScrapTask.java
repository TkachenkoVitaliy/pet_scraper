package ru.vtkachenko.pet_scraper.scrap_task.model;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import ru.vtkachenko.pet_scraper.city.model.City;
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

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

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

    public ScrapTask(String title, String competitor, City city, String url, String[] selectors) {
        this.title = title;
        this.competitor = competitor;
        this.city = city;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
