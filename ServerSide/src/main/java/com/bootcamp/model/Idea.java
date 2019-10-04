package com.bootcamp.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hackathonideas")
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "SUMMARY")
    private String summary;

    @Column(name = "DETAILS")
    private String details;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "TEAM_MEMBERS")
    private String teamMembers;

    @Column(name = "LIKES")
    private int likes;

    @Column(name = "HACKATHON_ID")
    private int hackathonId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HACKATHON_ID", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Hackathon hackathon;

    public Hackathon getHackathon() {
        return hackathon;
    }

    public int getHackathonId() {
        return hackathonId;
    }

    public void setHackathonId(int hackathonId) {
        this.hackathonId = hackathonId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(String teamMembers) {
        this.teamMembers = teamMembers;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Idea idea = (Idea) o;
        return hackathonId == idea.hackathonId &&
                Objects.equals(summary, idea.summary) &&
                Objects.equals(details, idea.details) &&
                Objects.equals(category, idea.category) &&
                Objects.equals(teamMembers, idea.teamMembers) &&
                Objects.equals(likes, idea.likes) &&
                Objects.equals(hackathon, idea.hackathon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(summary, details, category, teamMembers, likes);
    }
}
