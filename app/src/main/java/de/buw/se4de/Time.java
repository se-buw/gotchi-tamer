package de.buw.se4de;

public class Time {
    long days_ = 0, hours_ = 0, minutes_ = 0;

    Time(long days, long hours, long minutes){
        days_ = days;
        hours_ = hours % 24;
        minutes_ = minutes % 60;
    }

}