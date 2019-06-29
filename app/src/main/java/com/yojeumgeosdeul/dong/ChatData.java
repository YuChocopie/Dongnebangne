package com.yojeumgeosdeul.dong;

public class ChatData {

    private String name;
    private String message;
    private String botMessage;
    
    public ChatData(String name, String message, String botMessage) {
        this.name = name;
        this.message = message;
        this.botMessage = botMessage;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getBotMessage() {
        return botMessage;
    }
    
    public void setBotMessage(String botMessage) {
        this.botMessage = botMessage;
    }
}
