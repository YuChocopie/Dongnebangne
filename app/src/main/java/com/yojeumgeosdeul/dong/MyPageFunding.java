package com.yojeumgeosdeul.dong;

import com.dinuscxj.progressbar.CircleProgressBar;

public class MyPageFunding {

    private String place;
    private String goal;
    private String funding;
    private String myFunding;
    private String people;
    private String progress;
    private CircleProgressBar circleProgressBar;


    public MyPageFunding(String place, String goal, String funding, String myFunding, String people, String progress, CircleProgressBar circleProgressBar) {
        this.place = place;
        this.goal = goal;
        this.funding = funding;
        this.myFunding = myFunding;
        this.people = people;
        this.progress = progress;
        this.circleProgressBar = circleProgressBar;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getMyFunding() {
        return myFunding;
    }

    public void setMyFunding(String myFunding) {
        this.myFunding = myFunding;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public CircleProgressBar getCircleProgressBar() {
        return circleProgressBar;
    }

    public void setCircleProgressBar(CircleProgressBar circleProgressBar) {
        this.circleProgressBar = circleProgressBar;
    }
}
