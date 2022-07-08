package com.dlazarenko;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run(){
        Queue<Contact> contactQueue = new LinkedList<>();
        contactQueue.offer(new Contact("Denys", "+48"));
        contactQueue.add(new Contact(null, "+38"));
        contactQueue.add(new Contact("Denys", "+48"));
        contactQueue.add(new Contact(null, "+38"));

        List<Contact> contactResult = new LinkedList<>();

        for (Contact contact : contactQueue) {
            if (contact.name != null){
                contactResult.add(contact);
            }
        }

        Deque<CallLog> callLogDeque = new LinkedList<>();
        callLogDeque.addFirst(new CallLog("+38", 0, 65, CallLog.Status.Outgoing));
        callLogDeque.add(new CallLog("+48", 0, 25, CallLog.Status.Incoming));
        callLogDeque.add(new CallLog("+1", 0, 0, CallLog.Status.Missed));
        callLogDeque.add(new CallLog("+38", 0, 5, CallLog.Status.Outgoing));
        callLogDeque.addLast(new CallLog("+7", 0, 75, CallLog.Status.Outgoing));
        callLogDeque.getLast();

        List<CallLog> callLogResult = new LinkedList<>();

        for (CallLog callLog : callLogDeque) {
            if(callLog.status != CallLog.Status.Missed
                    && callLog.status != CallLog.Status.Incoming){
                callLogResult.add(callLog);
            }
        }
    }
}
