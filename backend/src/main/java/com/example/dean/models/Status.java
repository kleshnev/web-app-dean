package com.example.dean.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {
        @JsonProperty("active")
        ACTIVE("Active"),

        @JsonProperty("inactive")
        INACTIVE("Inactive"),

        @JsonProperty("inProgress")
        IN_PROGRESS("In Progress");

        private final String displayName;

        Status(String displayName) {
                this.displayName = displayName;
        }

        public String getDisplayName() {
                return displayName;
        }
}
