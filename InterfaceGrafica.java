import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGrafica extends JFrame {
    private JTextArea areaMensagens;
    private JTextField campoTexto;
    private JButton botaoEnviar;
    private JButton botaoEmoticonPositivo;
    private JButton botaoEmoticonNegativo;

    public InterfaceGrafica() {
        setTitle("Chat - Rio Tietê");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        areaMensagens = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaMensagens);
        add(scrollPane, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel();
        painelInferior.setLayout(new BorderLayout());

        campoTexto = new JTextField();
        botaoEnviar = new JButton("Enviar");
        botaoEmoticonPositivo = new JButton("👍");
        botaoEmoticonNegativo = new JButton("👎");

        // Adiciona um ActionListener para o botão de emoticon positivo
        botaoEmoticonPositivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoTexto.setText(campoTexto.getText() + " 👍");
            }
        });

        // Adiciona um ActionListener para o botão de emoticon negativo
        botaoEmoticonNegativo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoTexto.setText(campoTexto.getText() + " 👎");
            }
        });

        painelInferior.add(campoTexto, BorderLayout.CENTER);
        painelInferior.add(botaoEnviar, BorderLayout.EAST);
        painelInferior.add(botaoEmoticonPositivo, BorderLayout.WEST);
        painelInferior.add(botaoEmoticonNegativo, BorderLayout.WEST); // Adicionado como o mesmo lado do positivo

        add(painelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Método para adicionar mensagens à área de mensagens
    public void adicionarMensagem(String mensagem) {
        areaMensagens.append(mensagem + "\n");
    }

    // Método para obter o texto digitado no campo de texto
    public String getTextoDigitado() {
        return campoTexto.getText();
    }

    // Método para limpar o campo de texto
    public void limparCampoTexto() {
        campoTexto.setText("");
    }
}