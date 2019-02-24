package sample;

public class ActionsForThreads {

    private int number = 0;
    private boolean generateNewNumber = false;
    public int countOfExecution;

    ActionsForThreads(int count) {
        countOfExecution = count;
    }

    public synchronized void getCurrentNumber() {
        while (!generateNewNumber) {
            try {
                wait();
            }
            catch (InterruptedException exception) {
            }
        }
        generateNewNumber = false;
        System.out.println("Thread: " + Thread.currentThread().getName()
                            + " current number is " + number);
        System.out.println("left: " + countOfExecution);
        notify();
    }

    public synchronized void generateNewNumber() {
        while(generateNewNumber) {
            try {
                wait();
            }
            catch(InterruptedException exception){
            }
        }
        countOfExecution--;
        generateNewNumber = true;
        number = (int)(Math.random()*10);
        System.out.println("Thread: " + Thread.currentThread().getName()
                         + " current number is " + number);
        notify();
    }
}