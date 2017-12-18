package com.houseman.housemanbe.helper;

public final class Constants {

    public enum MessageType {

        SUCCSESS("succsess"),
        ERROR("danger"),
        WARNING("warning"),
        INFO("info");

        private final String name;

        MessageType(String name) {
            this.name = name;

        }

        public String getName() {
            return name;
        }

    }
}
