package com.techelevator;

public class HomeworkAssignment {

    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    public HomeworkAssignment(int possibleMarks, String submitterName){
       this.possibleMarks = possibleMarks;
       this.submitterName = submitterName;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }


    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
        double percent = (double) earnedMarks / (double) possibleMarks;
        if(percent >= .90){
            letterGrade = "A";

        } else if (percent >= .80){
            letterGrade = "B";
        }
        else if (percent >= .70){
            letterGrade = "C";
        }
        else if (percent >= .60){
            letterGrade = "D";
        } else letterGrade = "F";
        }


    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        return letterGrade;
    }
}
