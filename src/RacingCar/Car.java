package RacingCar;

import java.util.Random;

public class Car implements Runnable{
    private String carName;

    public Car(String carName) {
        this.carName = carName;
    }


    @Override
    public void run() {
        int runDistance = 0;
        long startTime = System.currentTimeMillis();
        while (runDistance<Main.DISTANCE) {
            try {
                int speed = (new Random().nextInt(20));
                runDistance +=speed;
                String log = "|";
                int percentageTravel = (runDistance*100)/Main.DISTANCE;
                for (int i = 0; i < Main.DISTANCE; i+=Main.STEP) {
                    if(percentageTravel >=i + Main.STEP) {
                        log+="=";
                    } else if (percentageTravel >=i && percentageTravel< i + Main.STEP) {
                        log += "X";
                    } else {
                        log += "-";
                    }
                }
                log += "|";
                System.out.println("Car" + this.carName + ": " +
                        log + Math.min(Main.DISTANCE,runDistance) + "MILE");
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                System.out.println("Car " + this.carName + "broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.carName + "Finish in " +
                (endTime - startTime)/1000 + "s");
    }
}
