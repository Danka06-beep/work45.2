package com.company;

public class User {
    String ip;
    String id;
    String fio;
    String address;

    public User(String ip, String id, String fio, String address) {
        this.ip = ip;
        this.id = id;
        this.fio = fio;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User" + "id=" + id + ", ip='" + ip + '\'' + ", fio='" + fio + '\'' + ", address='" + address ;
    }
}
