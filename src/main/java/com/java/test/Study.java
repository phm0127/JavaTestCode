package com.java.test;

public class Study {
    private StudyStatus status;
    private int limit;

    public Study (){
        this.status=StudyStatus.DRAFT;
    }
    public Study(int limit){
        if(limit<0){
            throw new IllegalArgumentException("0보다 커야한다.");
        }
        this.status=StudyStatus.DRAFT;
        this.limit=limit;
    }

    public StudyStatus getStatus() {
        return this.status;
    }

    public int getLimit() {
        return this.limit;
    }
}
