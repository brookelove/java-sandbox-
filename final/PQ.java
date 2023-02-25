
public class PQ {
    private int id;
    private int priority;
    private int duration;
    private int arrivalTime;

    public PQ() {
    }

    public PQ(int id, int priority, int duration, int arrivalTime) {
        this.id = id;
        this.priority = priority;
        this.duration = duration;
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public int getDuration() {
        return duration;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public String toString() {
        String c = "\tId = " + id +
                "\tPriority = " + priority +
                "\tDurration = " + duration + "\tArrival Time = " + arrivalTime;

        return c;
    }

}
