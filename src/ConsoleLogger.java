public class ConsoleLogger implements Observer {
    private Subject dial;
    private String log;

    public ConsoleLogger(Subject dial) {
        this.dial = dial;
        dial.registerObserver(this);
    }

    @Override
    public void update(String log) {
        this.log = log;
        display();
    }

    private void display() {
        System.out.println(log);
    }
    
}
