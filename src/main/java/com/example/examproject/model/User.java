package com.example.examproject.model;

import java.util.Objects;
import java.util.List;

public class User {
    private String userName;
    private String password;
    private int userId;
    private String userEmail;
    public User() {

    }

    public User(String userName, String password, int userId, String userEmail) {
        this.userName = userName;
        this.password = password;
        this.userId = userId;
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getUserId() == user.getUserId() && Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassword(), getUserId());
    }

    public String formatProjectDetails(List<Project> projects) {
        StringBuilder builder = new StringBuilder();

        for (Project project : projects) {
            builder.append("Project Name: ").append(project.getProjectName()).append("\n");

            List<String> tasks = project.getProjectTasks();
            if (tasks.isEmpty()) {
                builder.append("  No tasks found.\n");
            } else {
                for (String task : tasks) {
                    builder.append("  Task: ").append(task).append("\n");
                }
            }
            builder.append("\n"); // Extra newline for better separation between projects
        }

        return builder.toString();
    }
}
