package com.example.modulzaro4.dtos;

import java.time.LocalDate;

public class TaskDTO {

    private Long id;

    private String detail;

    private LocalDate deadLine;

    private String nameId;

    private String userName;

    public TaskDTO(Long id, String detail, LocalDate deadLine, String nameId, String userName) {
        this.id = id;
        this.detail = detail;
        this.deadLine = deadLine;
        this.nameId = nameId;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
