package com.empiregroup.myapplication.entities;

public class DashModel {



    String name;
    String desc;
    String count;

    public DashModel() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }
    //public DashModel(String Name, String Desc) {
      //  this.name = Name;
        //this.desc = Desc;
    //}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
