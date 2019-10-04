package com.bootcamp.dto;

import javax.validation.constraints.NotEmpty;

public class IdeaDTO {

    private int id;

    @NotEmpty(message = "Idea Summary cannot be Empty")
    private String summary;

    @NotEmpty(message = "Idea Details cannot be Empty")
    private String details;

    @NotEmpty(message = "Category cannot be Empty")
    private String category;

    @NotEmpty(message = "Team Members cannot be Empty")
    private String teamMembers;

    private int likes;

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
}
