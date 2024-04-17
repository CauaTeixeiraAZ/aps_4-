import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorCliente implements Runnable {
    private Socket socketCliente;
    private BufferedReader entrada;
    private PrintWriter saida;

    public ServidorCliente(Socket socketCliente) {
        this.socketCliente = socketCliente;

        try {
            entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            saida = new PrintWriter(socketCliente.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String mensagem;
            while ((mensagem = entrada.readLine()) != null) {
                System.out.println("Mensagem recebida: " + mensagem);
                // Aqui você pode processar a mensagem, por exemplo, enviá-la para todos os clientes conectados
                // ou realizar outras ações com base na mensagem recebida
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socketCliente.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para enviar uma mensagem para o cliente
    public void enviarMensagem(String mensagem) {
        saida.println(mensagem);
    }
}