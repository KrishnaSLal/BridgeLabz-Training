package com.linkedlist.singlylinkedlist.socialmedia;

import java.util.ArrayList;

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendsHead; // linked list of friends
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendsHead = null;
        this.next = null;
    }
}
