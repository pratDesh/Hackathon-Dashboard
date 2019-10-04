package com.bootcamp.dto;

import java.util.List;

public class HackathonDTO {

    private int id;
    private String eventName;
    private String moOffice;
    private String dateConducted;
    private int totalIdeas;
    private List<IdeaDTO> ideaDTOs;

    public List<IdeaDTO> getIdeaDTOs() {
        return ideaDTOs;
    }

    public void setIdeaDTOs(List<IdeaDTO> ideaDTOs) {
        this.ideaDTOs = ideaDTOs;
    }

    public int getId() {
        return id;
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
}
