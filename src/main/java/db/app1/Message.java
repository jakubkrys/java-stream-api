package db.app1;

public class Message {

    private String sender;
    private String title;
    private String description;

    public Message(String sender, String title, String description) {
        this.sender = sender;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "db.app1.Message{" +
                "sender='" + sender + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSender() {
        return sender;
    }
}
