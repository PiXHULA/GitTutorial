package com.alm;

public class Question {
        
        private String output;
        private String message;
        private String command;

        public Question(String output, String message, String command) {
                this.output = output;
                this.message = message;
                this.command = command;
        }

        public String getMessage() {
                return message;
        }

        public void setMessage(String message) {
                this.message = message;
        }

        public String getCommand() {
                return command;
        }

        public void setCommand(String command) {
                this.command = command;
        }

        public String getOutput() {
                return output;
        }

        public void setOutput(String output) {
                this.output = output;
        }
}
