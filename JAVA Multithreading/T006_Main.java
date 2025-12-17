public class T006_Main {
    public static void main(String[] args) {
        T006_SetPriority l = new T006_SetPriority("Low Priority Thread");
        T006_SetPriority m = new T006_SetPriority("Medium Priority Thread");
        T006_SetPriority h = new T006_SetPriority("High Priority Thread");

        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);

        l.start();
        m.start();
        h.start();
    }
}