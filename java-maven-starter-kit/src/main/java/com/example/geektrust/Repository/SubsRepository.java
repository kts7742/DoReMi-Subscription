package com.example.geektrust.Repository;
import java.util.ArrayList;
import java.util.List;

import com.example.geektrust.Entity.Subscription;
import com.example.geektrust.Repository.RepositoryHelper.RepositoryHelper;

public class SubsRepository implements ISubsRepository{
    private final List<Subscription> slist;
    RepositoryHelper repositoryHelper;
    public SubsRepository(){
        slist = new ArrayList<>();
        repositoryHelper = new RepositoryHelper();
    }

    @Override
    public Subscription startSubscription(Subscription subscription){
        Subscription subs = new Subscription(subscription.getDate());
        slist.add(subs);
        return subs;
    }

    @Override
    public void addSubscription(String category, String plan){
        slist.get(0).setSubscription(category, plan);
    }

    @Override
    public void addTopup(String devices, int months){
        slist.get(0).setTopup(devices, months);
    }

    @Override
    public List<String> printRenewal(){
       List<String> ans = repositoryHelper.printRenewalHelp(slist);
       return ans;
    }

    @Override
    public boolean isPresent(String category){
        return slist.get(0).isPresent(category);
    }

    @Override
    public boolean isTopup(){
        return slist.get(0).isTopup();
    }

}
