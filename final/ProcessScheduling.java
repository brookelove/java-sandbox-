import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessScheduling {
    static PQ[] data = new PQ[10]; // created a priority quueue to hold all of the elemets at size 10
    // each iteration fo the while loop represents what occurs one time unit
    // must inrement teh current time in each iteration
    // while Q.length && D.length are !== 0// whle loop runs until every time until
    // Q is empty
    // if D != 0 grab a proceewss from the D that has the earliest arival time
    // i arival time of p <= current tom e
    // remive p from D and inset int Q
    // if Q is not empty
    // execute the top prcess in Q for one time step
    // update the wait times of all prcocess in Q

    // public static void trackTime() {
    // System.out.println("Arrival = " + info.getId());
    // System.out.println("Duration = " + info.getDuration());
    // System.out.println("Run time left = " + info.getDuration());
    // System.out.println("at time " + info.getArrivalTime());
    // }
    public static void executeProcess(PQ currP) {
        int runT = currP.getDuration();
        int atTime = currP.getArrivalTime();
        System.out.println("Run time left = " + runT);
        System.out.println(" at time " + atTime);
        while (runT != 0) {
            System.out.println("Execute process ID:" + currP.getId() + ", at time " + atTime + " Remaining: " + runT);
            runT--;
            atTime++;
        }
        // System.out.println(currP);
        // need to check if the next priority queue is equal to the next one
    }

    public static void getLowest() {
        int min = data[0].getPriority();
        ;
        for (int i = 0; i < data.length; i++) {
            if (data[i].getPriority() < min) {

            }
        }
    }

    public static void runProcess() {
        int i = 0;
        int runT = data[i].getDuration();
        // int atTime = data[i].getArrivalTime();

        while (data.length != i) {
            if (runT == 0) {
                System.out.println("Finished running Process id = " + data[i].getId());
            } else {
                System.out.println("Now running Process id = " + data[i].getId());
                System.out.println("Arrival = " + data[i].getArrivalTime());
                System.out.println("Durraion = " + data[i].getDuration());
                // System.out.println("Arrival = " + runT);
                // System.out.println("Arrival = " + atTime);
                executeProcess(data[i]);
                i++;
            }
        }
    }
    // public static void runningProcess() {
    // int i = 0;
    // int maxT = 30;
    // int runTimeL = data[i].getDuration();
    // int rutArrive = data[i].getArrivalTime();
    // System.out.println("\nMaximum wait time = " + maxT
    // +"n");while(data.length!=i)

    // {
    // getLowest();
    // System.out.println("Now running Process id = " + data[i].getId());
    // // if (data[i].getArrivalTime() < i) {
    // System.out.println("Arrival = " + data[i].getId());
    // System.out.println("Duration = " + data[i].getDuration());
    // System.out.println("Run time left = " + data[i].getDuration());
    // System.out.println("at time " + data[i].getArrivalTime());

    // // }
    // for(int j = 0; j < data[i].getDuration(); j++) {
    // System.out.println("Executed process ID:"+ data[i].getId() + ", at time " +
    // "")
    // }
    // System.out.println(data[i]);
    // i++;
    // }

    // }

    public static void main(String[] args) {
        try { // grab the list out of the calll
            Scanner fileInput = new Scanner(new File("process_scheduling_input.txt"));
            int index = 0;
            while (fileInput.hasNext()) {
                String line = fileInput.nextLine();
                String[] splitLine = line.split(" ");
                int id = Integer.parseInt(splitLine[0]);
                int priority = Integer.parseInt(splitLine[1]);
                int duration = Integer.parseInt(splitLine[2]);
                int arrivalT = Integer.parseInt(splitLine[3]);
                PQ new_item = new PQ(id, priority, duration, arrivalT);
                data[index] = new_item;
                index++;
            }
            fileInput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("All the Proceses In the Priority Queue\n");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
        runProcess();

    }
}