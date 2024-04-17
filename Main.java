public class Main {
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        Cliente cliente = new Cliente();

        // Iniciar servidor em uma thread separada
        Thread servidorThread = new Thread(servidor);
        servidorThread.start();

        // Iniciar cliente
        cliente.iniciar();
    }
}