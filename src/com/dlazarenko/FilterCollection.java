package com.dlazarenko;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.function.Predicate;

public class FilterCollection {

    public static void main(String[] args) {
        new FilterCollection().run();
    }
    public void run(){
        Predicate<Contact> contactPredicate = new Predicate<Contact>() {
            @Override
            public boolean test(Contact contact) {
                return contact.name != null;
            }
        };

        Predicate <CallLog> callLogPredicate = x -> x.duration > 30;

        Collection<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Denys", "+48"));
        contacts.add(new Contact(null, "+38"));

        Collection<CallLog> callLogs = new ArrayList<>();
        callLogs.add(new CallLog("+48", 0, 25, CallLog.Status.Outgoing));
        callLogs.add(new CallLog("+48", 0, 85, CallLog.Status.Incoming));
        callLogs.add(new CallLog("+38", 0, 35, CallLog.Status.Outgoing));

        Collection<Contact> resultFilterContacts = filterContact(contacts, contactPredicate);
        Collection<CallLog> resultFilterCallLogs = filterContact(callLogs, callLogPredicate);
    }

    public static  <T> Collection<T> filterContact (
            Collection<T> item, Predicate<T> predicate){
        Collection<T> result = new ArrayList<>();
        for (T value : item) {
            if(predicate.test(value)){
                result.add(value);
            }
        }
        return result;
    }
}
