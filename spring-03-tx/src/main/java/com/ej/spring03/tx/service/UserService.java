package com.ej.spring03.tx.service;


public interface UserService {
    public void checkout(String username, Integer bookId, Integer buyNum) throws InterruptedException;
}
