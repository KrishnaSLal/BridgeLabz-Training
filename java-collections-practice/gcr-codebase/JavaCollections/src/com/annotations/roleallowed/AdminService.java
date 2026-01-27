package com.annotations.roleallowed;

@RoleAllowed("ADMIN")
public class AdminService {

    public void deleteUser() {
        System.out.println("User deleted successfully!");
    }
}
