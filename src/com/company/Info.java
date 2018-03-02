package com.company;

/**This seems like your Task object, so it should be called Task, and should have a constructor that requires all of these things to be made (
 * that way you don't have tasks that have no parameters, such as a task object that doesn't have a name, date, or detail) */
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
}
