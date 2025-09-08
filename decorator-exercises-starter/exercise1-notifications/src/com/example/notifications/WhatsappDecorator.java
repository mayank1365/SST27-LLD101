package com.example.notifications;

public class WhatsAppDecorator implements Notifier {
    Notifier n;
    String user;

    public WhatsAppDecorator(Notifier n, String user) {
        this.n = n;
        this.user = user;
    }

    @Override
    public void notify(String text) {
        System.out.println("[WHATSAPP]: " + user + " " + text);
    }
}