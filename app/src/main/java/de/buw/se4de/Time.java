package de.buw.se4de;

public class Time {
    long days_ = 0, hours_ = 0, minuets_ = 0;

    Time(long days, long hours, long minuets){
        days_ = days;
        hours_ = hours % 24;
        minuets_ = minuets % 60;
    }

}