package sample;

public class GetNumberFromThread implements Runnable {

    ActionsForThreads action;
    GetNumberFromThread(ActionsForThreads action) {
        this.action = action;
    }

    public void run() {
        while(action.countOfExecution > 0) {
            action.getCurrentNumber();
        }
    }
}
