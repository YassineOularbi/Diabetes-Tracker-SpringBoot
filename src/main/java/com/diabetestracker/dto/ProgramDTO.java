package com.diabetestracker.dto;

import java.sql.Time;
import java.time.LocalDateTime;

public class ProgramDTO {
    private Long programId;
    private String exerciceName;
    private Long sugarEffect;
    private Long levelMax;
    private Long levelMin;
    private String note;
    private String picture;
    private Long userId;
    private Time duration;
    private Long bloodSugarBefore;
    private Long bloodSugarAfter;
    private Double glycemieValue;
    private LocalDateTime glycemieDate;
    private String glycemieUnit;

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public String getExerciceName() {
        return exerciceName;
    }

    public void setExerciceName(String exerciceName) {
        this.exerciceName = exerciceName;
    }

    public Long getSugarEffect() {
        return sugarEffect;
    }

    public void setSugarEffect(Long sugarEffect) {
        this.sugarEffect = sugarEffect;
    }

    public Long getLevelMax() {
        return levelMax;
    }

    public void setLevelMax(Long levelMax) {
        this.levelMax = levelMax;
    }

    public Long getLevelMin() {
        return levelMin;
    }

    public void setLevelMin(Long levelMin) {
        this.levelMin = levelMin;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Long getBloodSugarBefore() {
        return bloodSugarBefore;
    }

    public void setBloodSugarBefore(Long bloodSugarBefore) {
        this.bloodSugarBefore = bloodSugarBefore;
    }

    public Long getBloodSugarAfter() {
        return bloodSugarAfter;
    }

    public void setBloodSugarAfter(Long bloodSugarAfter) {
        this.bloodSugarAfter = bloodSugarAfter;
    }

    public Double getGlycemieValue() {
        return glycemieValue;
    }

    public void setGlycemieValue(Double glycemieValue) {
        this.glycemieValue = glycemieValue;
    }

    public LocalDateTime getGlycemieDate() {
        return glycemieDate;
    }

    public void setGlycemieDate(LocalDateTime glycemieDate) {
        this.glycemieDate = glycemieDate;
    }

    public String getGlycemieUnit() {
        return glycemieUnit;
    }

    public void setGlycemieUnit(String glycemieUnit) {
        this.glycemieUnit = glycemieUnit;
    }
}
