package com.scgapps.mobile.api.calendar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Validated
public class Task{

        @JsonProperty("id")
        private Long id = null;

        @JsonProperty("assignerUserId")
        private Integer assignerUserId = null;

        @JsonProperty("taskDate")
        private String taskDate = null;

        @JsonProperty("notify")
        private List<Integer> notify = new ArrayList<>();

        @JsonProperty("description")
        private String details = null;

        @JsonProperty("type")
        private Integer type = null;

        @JsonProperty("primaryAccount")
        private Integer primaryAccount = null;

        @JsonProperty("project")
        private Integer project = null;

        @JsonProperty("reminder")
        private Integer reminder = null;

        public Task assignerUserId(Integer assignerUserId) {
            this.assignerUserId = assignerUserId;
            return this;
        }

        /**
         * Get assignerUserId
         * @return assignerUserId
         **/

        public Integer getAssignerUserId() {
            return assignerUserId;
        }

        public void setAssignerUserId(Integer assignerUserId) {
            this.assignerUserId = assignerUserId;
        }

        public Task taskDate(String taskDate) {
            this.taskDate = taskDate;
            return this;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
         * Get taskDate
         * @return taskDate
         **/

        public String getTaskDate() {
            return taskDate;
        }

        public void setTaskDate(String taskDate) {
            this.taskDate = taskDate;
        }

        public Task notify(List<Integer> notify) {
            this.notify = notify;
            return this;
        }

        public Task addNotifyItem(Integer notifyItem) {
            this.notify.add(notifyItem);
            return this;
        }

        /**
         * Get notify
         * @return notify
         **/

        public List<Integer> getNotify() {
            return notify;
        }

        public void setNotify(List<Integer> notify) {
            this.notify = notify;
        }


        public Task type(Integer type) {
            this.type = type;
            return this;
        }

        /**
         * Get type
         * @return type
         **/

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Task primaryAccount(Integer primaryAccount) {
            this.primaryAccount = primaryAccount;
            return this;
        }

        /**
         * Get primaryAccount
         * @return primaryAccount
         **/

        public Integer getPrimaryAccount() {
            return primaryAccount;
        }

        public void setPrimaryAccount(Integer primaryAccount) {
            this.primaryAccount = primaryAccount;
        }

        public Task project(Integer project) {
            this.project = project;
            return this;
        }

        /**
         * Get project
         * @return project
         **/

        public Integer getProject() {
            return project;
        }

        public void setProject(Integer project) {
            this.project = project;
        }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Task reminder(Integer reminder) {
            this.reminder = reminder;
            return this;
        }

        /**
         * Get reminder
         * @return reminder
         **/

        public Integer getReminder() {
            return reminder;
        }

        public void setReminder(Integer reminder) {
            this.reminder = reminder;
        }


        @Override
        public boolean equals(java.lang.Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Task tasks = (Task) o;
            return Objects.equals(this.assignerUserId, tasks.assignerUserId) &&
                    Objects.equals(this.taskDate, tasks.taskDate) &&
                    Objects.equals(this.notify, tasks.notify) &&
                    Objects.equals(this.details, tasks.details) &&
                    Objects.equals(this.type, tasks.type) &&
                    Objects.equals(this.primaryAccount, tasks.primaryAccount) &&
                    Objects.equals(this.project, tasks.project) &&
                    Objects.equals(this.reminder, tasks.reminder);
        }

        @Override
        public int hashCode() {
            return Objects.hash(assignerUserId, taskDate, notify, details, type, primaryAccount, project, reminder);
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class Tasks {\n");

            sb.append("    assignerUserId: ").append(toIndentedString(assignerUserId)).append("\n");
            sb.append("    taskDate: ").append(toIndentedString(taskDate)).append("\n");
            sb.append("    notify: ").append(toIndentedString(notify)).append("\n");
            sb.append("    details: ").append(toIndentedString(details)).append("\n");
            sb.append("    type: ").append(toIndentedString(type)).append("\n");
            sb.append("    primaryAccount: ").append(toIndentedString(primaryAccount)).append("\n");
            sb.append("    project: ").append(toIndentedString(project)).append("\n");
            sb.append("    reminder: ").append(toIndentedString(reminder)).append("\n");
            sb.append("}");
            return sb.toString();
        }

        /**
         * Convert the given object to string with each line indented by 4 spaces
         * (except the first line).
         */
        private String toIndentedString(java.lang.Object o) {
            if (o == null) {
                return "null";
            }
            return o.toString().replace("\n", "\n    ");
        }

}