import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter saida;

    public void iniciar() {
        try {
            socket = new Socket("localhost", 12345);
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            saida = new PrintWriter(socket.getOutputStream(), true);

            // Lógica para enviar mensagens ao servidor
            BufferedReader leitorConsole = new BufferedReader(new InputStreamReader(System.in));
            String mensagem;
            while ((mensagem = leitorConsole.readLine()) != null) {
                // Envia a mensagem para o servidor
                saida.println(mensagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para receber mensagens do servidor
    public void receberMensagem() {
        try {
            String mensagem;
            while ((mensagem = entrada.readLine()) != null) {
                // Lógica para lidar com a mensagem recebida do servidor
                System.out.println("Mensagem recebida do servidor: " + mensagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}