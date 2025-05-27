import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class RegistrarParking {
    private static int count = 0;
    private final int carId;

    public RegistrarParking() {
        this.carId = ++count;
    }

    public int getCarId() {
        return carId;
    }
    
}
class ParkingPool {
    private final Queue<RegistrarParking> queue = new LinkedList<>();

    public synchronized void addCar(RegistrarParking car) {
        queue.add(car);
        notifyAll();
    }

    public synchronized RegistrarParking getCar() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.poll();
    }
}

class ParkingAgent extends Thread {
    private final String agentName;
    private final ParkingPool parkingPool;

    public ParkingAgent(String name, ParkingPool pool) {
        this.agentName = name;
        this.parkingPool = pool;
    }

    @Override
    public void run() {
        while (true) {
            try {
                RegistrarParking car = parkingPool.getCar();
                System.out.println(agentName + " parked Car #" + car.getCarId());
                Thread.sleep(1000); // Simulate time to park the car
            } catch (InterruptedException e) {
                System.out.println(agentName + " interrupted.");
                break;
            }
        }
    }
}
public class MainClass {
    public static void main(String[] args) {
        ParkingPool pool = new ParkingPool();

        // Start parking agents
        new ParkingAgent("Valet-1", pool).start();
        new ParkingAgent("Valet-2", pool).start();
        new ParkingAgent("Valet-3", pool).start();

        Scanner scanner = new Scanner(System.in);
        int carCount = 0;
        while (carCount < 10) {
            System.out.println("Press Enter to register a car for parking...");
            scanner.nextLine();

            RegistrarParking car = new RegistrarParking();
            pool.addCar(car);
            System.out.println("Car #" + car.getCarId() + " registered for parking.");

            carCount++;
        }

        scanner.close();
        System.out.println("All cars registered. Parking in progress...");
    }
}

