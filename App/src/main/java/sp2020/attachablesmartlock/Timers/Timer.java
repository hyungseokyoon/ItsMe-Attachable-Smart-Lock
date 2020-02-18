package sp2020.attachablesmartlock.Timers;

public class Timer {
    private BoundedCounter hours;
    private BoundedCounter minutes;
    private BoundedCounter seconds;
   
    public Timer(int hoursAtBeginning, int minutesAtBeginning, int secondsAtBeginning) {

        // 3 counters are created, for hours minutes and seconds.
        this.hours = new BoundedCounter(23);
        this.minutes = new BoundedCounter(59);
        this.seconds = new BoundedCounter(59);

        hours.setValue(hoursAtBeginning);
        minutes.setValue(minutesAtBeginning);
        seconds.setValue(secondsAtBeginning);
    }
    
    public void tickUp() {
        // Timer advances by one second
        this.seconds.increase();
        if(this.seconds.getValue() == 0) {
            this.minutes.increase();
            if(this.minutes.getValue()==0) {
                this.hours.increase();
            }
        }
    }

    public void tickDown() {
        // Timer goes down by one second
        this.seconds.decrease();
        if(this.seconds.getValue() == 59) {
            this.minutes.decrease();
            if(this.minutes.getValue() == 59) {
                this.hours.decrease();
            }
        }
    }

    public int getTimeInSeconds() {
        return this.seconds.getValue() + this.minutes.getValue()*60 + this.hours.getValue()*60*60;
    }


    
    public String toString() {
        // returns the string representation
        return this.hours + ":" + this.minutes + ":" + this.seconds;
    }
}
