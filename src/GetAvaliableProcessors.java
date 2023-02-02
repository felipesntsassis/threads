public class GetAvaliableProcessors {

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Este hardware possui " + cores + " núcleo(s) disponível(eis);");
    }
}
