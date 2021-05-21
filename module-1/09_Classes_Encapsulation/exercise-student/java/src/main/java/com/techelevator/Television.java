package com.techelevator;

public class Television {


    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void turnOff(){
        this.isOn = false;
    }
    public void turnOn(){
        this.isOn = true;

    }
    public void changeChannel(int newChannel){
        // if TV is on
        if(this.isOn) {
            if (newChannel >= 3 && newChannel <= 18) {
                this.currentChannel = newChannel;
            }
        }
        //if new channel between 3 and 18
        //set current channel

    }
    public void channelUp() {
        if (this.isOn) {
            if (this.currentChannel == 18) {
                this.currentChannel = 3;
            } else {
                this.currentChannel++;
            }

        }
    }
    public void channelDown(){
        if (this.isOn){
            if(this.currentChannel == 3){
                this.currentChannel = 18;

            }
            else {
                this.currentChannel --;
            }
        }

    }
    public void raiseVolume() {
        //if tv is on
        if (this.isOn) {
            if (this.currentVolume < 10) {
                this.currentVolume++;
            }
            //increase volume by 1
            //cant be greater than 10

        }
    }
    public void lowerVolume(){
        if(this.isOn) {
            if(this.currentVolume > 0) {
                this.currentVolume--;
            }
        }

    }

}
