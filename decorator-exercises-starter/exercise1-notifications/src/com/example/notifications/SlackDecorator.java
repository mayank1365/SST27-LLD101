package com.example.notifications;

public class SlackDecorator implements Notifier {
    Notifier n;
    String user;

    public SlackDecorator(Notifier n, String user) {
        this.n = n;
        this.user = user;
    }

    @Override
    public void notify(String text) {
        n.notify(text);
        System.out.println("[SLACK]: " + text);
    }
}