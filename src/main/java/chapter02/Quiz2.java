package chapter02;

public class Quiz2 {
    public final int value = 4;

    public void doIt() {
        int value = 6;

        Runnable r = new Runnable() {
            public final int value = 5;

            public void run(){
                int value = 10;
                System.out.println(this.value);
            }
        };

        r.run();
    }

    public static void main(String...args) {
        Quiz2 m = new Quiz2();
        m.doIt();
    }
}
