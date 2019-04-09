package com.boraji.tutorial.spring.model;


import com.boraji.tutorial.spring.parser.LocalDateDeserializer;
import com.boraji.tutorial.spring.parser.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "place")
    private String place;

    @Column(name = "date_from")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateFrom;

    @Column(name = "date_to")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateTo;

    @Column(name = "position")
    private String position;

    private Experience() {
    }

    public Long getId() {
        return id;
    }

    public String getPlace() {
        return place;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public String getPosition() {
        return position;
    }

    public static class Builder {
        private Experience newExperience;

        public Builder() {
            newExperience = new Experience();
        }

        public Builder withId(Long id) {
            newExperience.id = id;
            return this;
        }

        public Builder withPlace(String place) {
            newExperience.place = place;
            return this;
        }

        public Builder withDateFrom(LocalDate dateFrom) {
            newExperience.dateFrom = dateFrom;
            return this;
        }

        public Builder withDateTo(LocalDate dateTo) {
            newExperience.dateTo = dateTo;
            return this;
        }

        public Builder withPosition(String position) {
            newExperience.position = position;
            return this;
        }

        public Experience build() {
            return newExperience;
        }
    }

}
