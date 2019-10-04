package com.bootcamp.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hackathon_details")
public class Hackathon {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "EVENT_NAME")
    private String eventName;

    @Column(name = "MO_OFFICE")
    private String moOffice;

    @Column(name = "DATE_CONDUCTED")
    private String dateConducted;

    @Column(name = "TOTAL_IDEAS")
    private int totalIdeas;


    @OneToMany(targetEntity = Idea.class, cascade = CascadeType.ALL, mappedBy = "hackathon", fetch = FetchType.LAZY)
    private List<Idea> ideas;


    public int getId() {
        return id;
    }

    public List<Idea> getIdeas() {
        return ideas;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


    public String getMoOffice() {
        return moOffice;
    }

    public void setMoOffice(String moOffice) {
        this.moOffice = moOffice;
    }


    public String getDateConducted() {
        return dateConducted;
    }

    public void setDateConducted(String dateConducted) {
        this.dateConducted = dateConducted;
    }


    public int getTotalIdeas() {
        return totalIdeas;
    }

    public void setTotalIdeas(int totalIdeas) {
        this.totalIdeas = totalIdeas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hackathon hackathon = (Hackathon) o;
        return totalIdeas == hackathon.totalIdeas &&
                Objects.equals(eventName, hackathon.eventName) &&
                Objects.equals(moOffice, hackathon.moOffice) &&
                Objects.equals(dateConducted, hackathon.dateConducted) &&
                Objects.equals(ideas, hackathon.ideas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName, moOffice, dateConducted, totalIdeas, ideas);
    }
}
