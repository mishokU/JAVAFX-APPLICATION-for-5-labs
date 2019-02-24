package sample;

public class WritingThread implements Runnable {

    ActionsForThreads action;
    WritingThread(ActionsForThreads action) {
        this.action = action;
    }

    public void run() {
        while(action.countOfExecution > 0){
            action.generateNewNumber();
        }
    }
}