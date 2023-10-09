package com.example.geektrust.Service;

import java.util.List;
// import java.util.concurrent.Flow.Subscription;

import com.example.geektrust.Repository.ISubsRepository;
import com.example.geektrust.Entity.*;

public class SubsService {
    private final ISubsRepository subsRepository;

    public SubsService(ISubsRepository subsRepository){
        this.subsRepository = subsRepository;
    }
    public Subscription startSubsription(String date){
        Subscription subs = new Subscription(date);
        return subsRepository.startSubscription(subs);
    }
    public void addSubscription(String category, String plan){
        subsRepository.addSubscription(category, plan);
    }
    public void addTopup(String devices, int months){
        subsRepository.addTopup(devices, months);
    }
    public List<String> printRenewal(){
        return subsRepository.printRenewal();
    }
    public boolean isPresent(String category){
        return subsRepository.isPresent(category);
    }
    public boolean isTopup(){
        return subsRepository.isTopup();
    }
}
