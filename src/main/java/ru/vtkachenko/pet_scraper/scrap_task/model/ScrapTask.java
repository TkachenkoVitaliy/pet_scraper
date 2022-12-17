package ru.vtkachenko.pet_scraper.scrap_task.model;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.*;
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
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
