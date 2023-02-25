import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessScheduling {
    static PQ[] pqs = new PQ[10];
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

    public static void main(String[] args) {
        try {
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
                pqs[index] = new_item;
                index++;
            }
            fileInput.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.print("All the Proceses In the Priority Queue\n");
        for (int i = 0; i < pqs.length; i++) {
            System.out.println(pqs[i]);
        }

    }
}