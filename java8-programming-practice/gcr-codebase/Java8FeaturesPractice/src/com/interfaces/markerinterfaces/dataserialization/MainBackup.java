//Marker Interfaces
//1. Data Serialization for Backup
//○ Scenario: Mark certain classes as Serializable for backup storage.
//○ Task: Implement marker interface for backup processing.

package com.interfaces.markerinterfaces.dataserialization;

public class MainBackup {
    public static void main(String[] args) {

        UserData user = new UserData("Krishna", 101);
        TempCache cache = new TempCache("Session123");

        processBackup(user);
        processBackup(cache);
    }

    // Backup processor checks marker interface
    static void processBackup(Object obj) {
        if (obj instanceof BackupSerializable) {
            System.out.println("Backing up object: " + obj);
        } else {
            System.out.println("Backup NOT allowed for: " + obj);
        }
    }
}

// Marked for backup
class UserData implements BackupSerializable {

    String name;
    int id;

    UserData(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return "UserData{name='" + name + "', id=" + id + "}";
    }
}

// NOT marked for backup
class TempCache {

    String sessionId;

    TempCache(String sessionId) {
        this.sessionId = sessionId;
    }

    public String toString() {
        return "TempCache{sessionId='" + sessionId + "'}";
    }
}
