import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JLabel labelCoordenadas;
    private JTextField campoCoordenadas;
    private JButton botaoLogin;

    public Login() {
        setTitle("Login - Salesópolis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new BorderLayout());

        labelCoordenadas = new JLabel("Digite as coordenadas de Salesópolis:");
        campoCoordenadas = new JTextField();
        botaoLogin = new JButton("Login");

        // Adiciona um ActionListener para o botão de login
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String coordenadasDigitadas = campoCoordenadas.getText();
                // Verifica se as coordenadas estão corretas
                if (coordenadasDigitadas.equalsIgnoreCase("45.8461° S, 121.4671° W")) {
                    // Se as coordenadas estiverem corretas, permite o acesso
                    abrirChat();
                } else {
                    // Caso contrário, exibe uma mensagem de erro
                    JOptionPane.showMessageDialog(Login.this, "Coordenadas incorretas. Acesso negado.",
                            "Erro de Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel painelCentro = new JPanel();
        painelCentro.setLayout(new GridLayout(2, 1));
        painelCentro.add(labelCoordenadas);
        painelCentro.add(campoCoordenadas);

        add(painelCentro, BorderLayout.CENTER);
        add(botaoLogin, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Método para abrir a interface gráfica do chat se as coordenadas estiverem corretas
    private void abrirChat() {
        InterfaceGrafica interfaceGrafica = new InterfaceGrafica();
        dispose(); // Fecha a janela de login
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();
            }
        });
    }
}
