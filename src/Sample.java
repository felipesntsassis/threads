public class Sample {
    public static void main(String[] args) {
        Job j1 = new Job(0, 1000);
        j1.setName("Job 1");
        Job j2 = new Job(1001, 2000);
        j2.setName("Job 2");
        Job j3 = new Job(2001, 3000);
        j3.setName("Job 3");

        j1.start();
        j2.start();
        j3.start();

        try {
            j1.join();
            j2.join();
            j3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Total: " + (j1.getTotal() + j2.getTotal() + j3.getTotal()));
    }
}
