import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Runnable {
    private ServerSocket serverSocket;
    private final int PORTA = 12345; // Porta que será usada para comunicação
  // socket é o TCP/IP

    public Servidor() {
        try {
            serverSocket = new ServerSocket(PORTA);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run()  {
        while (true) {
            try {
                // Aguarda a conexão de um cliente
                Socket socketCliente = serverSocket.accept();

                // Inicia uma nova thread para lidar com o cliente
                Thread clienteThread = new Thread(new ServidorCliente(socketCliente));
                clienteThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}