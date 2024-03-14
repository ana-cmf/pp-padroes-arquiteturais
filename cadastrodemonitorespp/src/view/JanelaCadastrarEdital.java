package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import dto.EditalDTO;;

/**
 * Janela com um formulário de cadastro de um novo edital
 */
public class JanelaCadastrarEdital extends ModeloJanelaComTabela {

    private JFormattedTextField textoFormatadoDataInicio;
    private JFormattedTextField textoFormatadoDataLimite;
    private JTextField campoDisciplinas;
    private JTextField campoVagas;
    private JTextField textFieldRanqueamento;
    private JTextField textFieldRanqueamento2;
	private JButton confirmar;
	private boolean informacoesSaoValidas;


    public JanelaCadastrarEdital() {
    	criarCabecalho("Cadastro de monitores");
    	adicionarPainelBrancoNaTela();	
    }


    class OuvinteBotaoAdicionarEdital implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String dataInicial = textoFormatadoDataInicio.getText();
            String dataLimite = textoFormatadoDataLimite.getText();
            String disciplinas = campoDisciplinas.getText();
            String vagasDisponiveis = campoVagas.getText();
            String pesos1 = textFieldRanqueamento.getText();
            String pesos2 = textFieldRanqueamento2.getText();

            DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDateTime dataInicio = LocalDate.parse(dataInicial, formatar).atStartOfDay();
            LocalDateTime dataFinal = LocalDate.parse(dataLimite, formatar).atStartOfDay();
            int vagas = Integer.parseInt(vagasDisponiveis);
            float pesoCRE = Float.parseFloat(pesos1);
            float pesoDisciplina = Float.parseFloat(pesos2);

            // Verificações de validade das datas e dos pesos
            // Aqui, adicione sua lógica para validação

            // Usando o DTO
            EditalDTO editalDTO = new EditalDTO(dataInicio, dataFinal, disciplinas, vagas, pesoCRE, pesoDisciplina);
            
            // Simulação de um método que irá processar o DTO
            // Note: Você precisará implementar esse método na sua lógica de negócio
            processarEditalDTO(editalDTO);
        }

        private void processarEditalDTO(EditalDTO editalDTO) {
            // Aqui você iria adicionar a lógica para processar o DTO,
            // como salvar as informações no banco de dados ou enviar para um servidor.
            // Por exemplo: persistencia.salvarEdital(editalDTO);
        }
    }
    
    public static void main(String[] args) {
    	JanelaCadastrarEdital j = new JanelaCadastrarEdital();
	}

}