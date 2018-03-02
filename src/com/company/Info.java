package com.company;

public class Info {

    private String taskName;
    private String dueDate;
    private String details;
    private String dateCompleted;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

//    public Info(String taskName, String dueDate, String details) {
//        this.taskName = taskName;
//        this.dueDate = dueDate;
//        this.details = details;
//    }
}
