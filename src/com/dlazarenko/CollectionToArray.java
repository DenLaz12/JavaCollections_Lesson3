package com.dlazarenko;

import java.util.ArrayList;
import java.util.List;

public class CollectionToArray {

    public static void main(String[] args) {
        new CollectionToArray().run();
    }

    public void run(){

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Denys", "+48"));
        contacts.add(new Contact("Dmytro", "+38"));

        Contact[] contactsToArray = contacts.toArray(new Contact[0]);

        List<CallLog> callLogs = new ArrayList<>();
        callLogs.add(new CallLog("+48", 0, 75, CallLog.Status.Incoming));
        callLogs.add(new CallLog("+38", 0, 30, CallLog.Status.Outgoing));
        callLogs.add(new CallLog("+38", 0, 0, CallLog.Status.Missed));

        CallLog[] callLogsToArray = callLogs.toArray(new CallLog[0]);


    }
}
