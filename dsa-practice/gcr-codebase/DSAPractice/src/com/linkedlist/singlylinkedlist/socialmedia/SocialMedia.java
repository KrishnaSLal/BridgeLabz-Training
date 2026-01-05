package com.linkedlist.singlylinkedlist.socialmedia;

public class SocialMedia {

    private UserNode head;

    public static class UserNode {
        public int userId;
        public String name;
        public int age;
        public FriendNode friendsHead;
        public UserNode next;

        public UserNode(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friendsHead = null;
            this.next = null;
        }
    }

    public static class FriendNode {
        public int friendId;
        public FriendNode next;
        public FriendNode(int friendId) {
            this.friendId = friendId;
            this.next = null;
        }
    }

    public UserNode findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addUser(int userId, String name, int age) {
        UserNode user = new UserNode(userId, name, age);
        if (head == null) head = user;
        else {
            UserNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = user;
        }
        System.out.println("User added: " + name);
    }

    public void addFriend(int userId1, int userId2) {
        UserNode u1 = findUserById(userId1);
        UserNode u2 = findUserById(userId2);
        if (u1 == null || u2 == null) {
            System.out.println("User(s) not found.");
            return;
        }
        if (!isFriend(u1, userId2)) u1.friendsHead = addFriendNode(u1.friendsHead, userId2);
        if (!isFriend(u2, userId1)) u2.friendsHead = addFriendNode(u2.friendsHead, userId1);
        System.out.println("Friend connection added.");
    }

    private boolean isFriend(UserNode user, int friendId) {
        FriendNode temp = user.friendsHead;
        while (temp != null) {
            if (temp.friendId == friendId) return true;
            temp = temp.next;
        }
        return false;
    }

    private FriendNode addFriendNode(FriendNode head, int friendId) {
        FriendNode node = new FriendNode(friendId);
        if (head == null) return node;
        FriendNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = node;
        return head;
    }

    public void removeFriend(int userId1, int userId2) {
        UserNode u1 = findUserById(userId1);
        UserNode u2 = findUserById(userId2);
        if (u1 == null || u2 == null) {
            System.out.println("User(s) not found.");
            return;
        }
        u1.friendsHead = removeFriendNode(u1.friendsHead, userId2);
        u2.friendsHead = removeFriendNode(u2.friendsHead, userId1);
        System.out.println("Friend connection removed.");
    }

    private FriendNode removeFriendNode(FriendNode head, int friendId) {
        if (head == null) return null;
        if (head.friendId == friendId) return head.next;
        FriendNode temp = head;
        while (temp.next != null) {
            if (temp.next.friendId == friendId) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public void displayFriends(UserNode user) {
        if (user.friendsHead == null) {
            System.out.println("No friends.");
            return;
        }
        System.out.print("Friends: ");
        FriendNode temp = user.friendsHead;
        while (temp != null) {
            System.out.print("P" + temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void displayUser(UserNode user) {
        System.out.println("ID: " + user.userId + ", Name: " + user.name + ", Age: " + user.age);
        displayFriends(user);
    }

    public void countFriends() {
        UserNode temp = head;
        while (temp != null) {
            int count = 0;
            FriendNode f = temp.friendsHead;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println(temp.name + " has " + count + " friend(s).");
            temp = temp.next;
        }
    }

    public void displayAllUsers() {
        UserNode temp = head;
        while (temp != null) {
            displayUser(temp);
            temp = temp.next;
        }
    }

    public void mutualFriends(int userId1, int userId2) {
        UserNode u1 = findUserById(userId1);
        UserNode u2 = findUserById(userId2);
        if (u1 == null || u2 == null) {
            System.out.println("User(s) not found.");
            return;
        }
        System.out.print("Mutual Friends: ");
        FriendNode f1 = u1.friendsHead;
        boolean found = false;
        while (f1 != null) {
            if (isFriend(u2, f1.friendId)) {
                System.out.print("P" + f1.friendId + " ");
                found = true;
            }
            f1 = f1.next;
        }
        if (!found) System.out.println("None");
        else System.out.println();
    }

    public void searchByName(String name) {
        UserNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                displayUser(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("User not found!");
    }
}

