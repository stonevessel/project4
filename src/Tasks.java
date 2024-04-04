public class Tasks {
     int priority = 0;
     String title="";
     String task="";

    public Tasks(int priority, String title, String task) {
        this.priority = priority;
        this.title = title;
        this.task = task;
    }

    public Tasks(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "priority=" + priority +
                ", title='" + title + '\'' +
                ", task='" + task + '\'' +
                '}';
    }
}
