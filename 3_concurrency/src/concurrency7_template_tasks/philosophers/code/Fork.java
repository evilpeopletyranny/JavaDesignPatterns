package concurrency7_template_tasks.philosophers.code;

public class Fork {
    private final int id;

    public Fork(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
