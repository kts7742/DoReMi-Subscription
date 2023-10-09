package com.example.geektrust.Repository;

import java.util.List;

import com.example.geektrust.Entity.Subscription;

public interface ISubsRepository {
    public Subscription startSubscription(Subscription subscription);
    public void addSubscription(String category, String plan);
    public void addTopup(String devices, int months);
    public List<String> printRenewal();
    public boolean isPresent(String category);
    public boolean isTopup();
}
