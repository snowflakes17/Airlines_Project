package com.project.users;

public interface User {
    void logout();
    void findFlight();
    void bookFlight();
    void pay();
    void cancelFlight();
    void changeUsername(String newUsername);
    void changePass(String newPass);
    void showTrips();
    boolean isAdmin();
    String getFullname();
    int getUserid();
}
