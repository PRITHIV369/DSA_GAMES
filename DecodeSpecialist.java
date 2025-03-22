import java.util.*;
public class DecodeSpecialist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> normalMessages = new LinkedList<>();
        PriorityQueue<String> priorityMessages = new PriorityQueue<>();
        Map<String, String> hints = new HashMap<>();
        int score = 0;
        normalMessages.add("Retrieve Access Code");
        hints.put("Retrieve Access Code", "Hint: You need this before disabling security.");
        normalMessages.add("Disable Security System");
        hints.put("Disable Security System", "Hint: Only after retrieving the access code.");
        priorityMessages.add("Emergency Override Activated");
        hints.put("Emergency Override Activated", "Hint: Immediate action required!");
        normalMessages.add("Escape the Facility");
        hints.put("Escape the Facility", "Hint: Do this after disabling security.");
        while (!normalMessages.isEmpty() || !priorityMessages.isEmpty()) {
            System.out.println("\nChoose action: 1. Process Normal 2. Process Priority 3. Show Hints 4. Quit");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    if (!normalMessages.isEmpty()) {
                        String message = normalMessages.poll();
                        System.out.println("Processed: " + message);
                        score += 10;
                    } else {
                        System.out.println("No normal messages left!");
                        score -= 5;
                    }
                    break;
                case 2:
                    if (!priorityMessages.isEmpty()) {
                        String message = priorityMessages.poll();
                        System.out.println("Processed Priority: " + message);
                        score += 20;
                    } else {
                        System.out.println("No priority messages left!");
                        score -= 10;
                    }
                    break;
                case 3:
                    System.out.println("Hints:");
                    for (String key : hints.keySet()) {
                        System.out.println(key + " - " + hints.get(key));
                    }
                    break;
                case 4:
                    System.out.println("Mission Aborted.");
                    System.out.println("Final Score: " + score);
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        System.out.println("All messages decoded. Mission Accomplished!");
        System.out.println("Final Score: " + score);
    }
}
