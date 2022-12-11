package ru.vtkachenko.pet_scraper.scrap_task.model;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import ru.vtkachenko.pet_scraper.city.model.City;
import ru.vtkachenko.pet_scraper.contractor.model.Contractor;
import ru.vtkachenko.pet_scraper.nomenclature.model.Nomenclature;

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

    @ManyToOne
    @JoinColumn(name = "nomenclature_id")
    private Nomenclature nomenclature;

    @ManyToOne
    @JoinColumn(name = "contractor_id")
    private Contractor contractor;

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

    private Boolean active;

    public ScrapTask() {
    }

    public ScrapTask(Nomenclature nomenclature, Contractor contractor, City city, String url, String[] selectors,
                     Boolean active) {
        this.nomenclature = nomenclature;
        this.contractor = contractor;
        this.city = city;
        this.url = url;
        this.selectors = selectors;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String[] getSelectors() {
        return selectors;
    }

    @Override
    public void setSelectors(String[] selectors) {
        this.selectors = selectors;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
