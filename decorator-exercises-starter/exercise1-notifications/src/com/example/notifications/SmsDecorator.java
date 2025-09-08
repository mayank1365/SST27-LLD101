package com.example.notifications;

public class SmsDecorator implements Notifier {
    Notifier n;
    String num;

    public SmsDecorator(Notifier n, String num) {
        this.n = n;
        this.num = num;
    }

    @Override
    public void notify(String text) {
        n.notify(text);
        System.out.println("[SMS to " + num + "]: " + text);
    }
}