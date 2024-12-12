import java.util.LinkedList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class WaitingListManager {

    private Queue<String> waitingListQueue;
    private Set<String> waitingListSet;

    public WaitingListManager() {
        waitingListQueue = new LinkedList<>();
        waitingListSet = new HashSet<>();
    }

    public void addPerson(String name) {
        if (waitingListSet.contains(name)) {
            System.out.println(name + " is already in the waiting list.");
        } else {
            waitingListQueue.add(name);
            waitingListSet.add(name);
            System.out.println(name + " has been added to the waiting list.");
        }
    }

    public String servePerson() {
        if (waitingListQueue.isEmpty()) {
            return "The waiting list is empty.";
        }
        String person = waitingListQueue.poll();
        waitingListSet.remove(person);
        return person + " has been served and removed from the waiting list.";
    }

    public boolean isPersonInList(String name) {
        return waitingListSet.contains(name);
    }

    public int waitingListSize() {
        return waitingListQueue.size();
    }

    public void displayWaitingList() {
        if (waitingListQueue.isEmpty()) {
            System.out.println("The waiting list is empty.");
        } else {
            System.out.println("Waiting List:");
            for (String person : waitingListQueue) {
                System.out.println(person);
            }
        }
    }

    public static void main(String[] args) {
        WaitingListManager manager = new WaitingListManager();
        
        manager.addPerson("Alice");
        manager.addPerson("Bob");
        manager.addPerson("Alice");
        
        manager.displayWaitingList();
        
        System.out.println(manager.servePerson());
        manager.displayWaitingList();
        
        System.out.println(manager.isPersonInList("Bob"));
        System.out.println(manager.isPersonInList("Alice"));
        
        System.out.println("Waiting List Size: " + manager.waitingListSize());
        
        manager.addPerson("Charlie");
        manager.displayWaitingList();
    }
}
