package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.EditalDeMonitoriaController;
import dto.EditalDeMonitoriaDTO;
import dto.VagaDTO;

public class JanelaCadastrarEdital extends ModeloBasicoJanela implements ActionListener{

    
	private JButton confirmar;
	private JFormattedTextField campoDataInicial;
	private JFormattedTextField campoDataFinal;
	private JComboBox<Integer> campoMaximoDeInscricoes;
	private JComboBox<Float> campoPesoCRE;
	private JComboBox<Float> campoPesoNota;
	private EditalDeMonitoriaDTO editalDTO;
	private VagaDTO vagaDTO;
	private EditalDeMonitoriaController controller;
	private JTextField campoNomeDisciplina;
	private JComboBox<Integer> campoQuantidadeDeVagas;
	private JButton botaoOK;	


    public JanelaCadastrarEdital() {
    	criarCabecalho("Cadastro de monitores");
    	adicionarMenuPrincipal();
    	criarFormulario();
    	setVisible(true);
    }

    public void criarFormulario() {
		
		JPanel areaDoFormulario = new JPanel();
		areaDoFormulario.setLayout(null);
		areaDoFormulario.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		areaDoFormulario.setBounds(getWidth()/6, 90, 390, 800);
		areaDoFormulario.setOpaque(true);
		add(areaDoFormulario);
		
		JLabel titulo = new JLabel("Cadastrar Edital");
		titulo.setBounds(20, 15, 300, 30);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		areaDoFormulario.add(titulo);
		
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			campoDataInicial = new JFormattedTextField(mascara);
			campoDataFinal = new JFormattedTextField(mascara);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Formato de data inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		JLabel labelDataInicial = labelPadrao("Data de início:", 12);
		labelDataInicial.setBounds(20, 90, 100, 15);
		areaDoFormulario.add(labelDataInicial);
		
		campoDataInicial.setBounds(20, 105, 350, 20);
		areaDoFormulario.add(campoDataInicial);
		
		JLabel labelDataFinal = labelPadrao("Data final:", 12);
		labelDataFinal.setBounds(20, 145, 100, 15);
		areaDoFormulario.add(labelDataFinal);
	
		campoDataFinal.setBounds(20, 160, 350, 20);
		areaDoFormulario.add(campoDataFinal);
		
		JLabel labelMaximoDeInscricoes = labelPadrao("Quantidade máxima de inscrições por aluno:", 12);
		labelMaximoDeInscricoes.setBounds(20, 200, 60, 15);
		areaDoFormulario.add(labelMaximoDeInscricoes);
		
		Integer[] numeros = {1,2,3,4,5,6,7,8,9,10};
		campoMaximoDeInscricoes = new JComboBox<Integer>(numeros);
		campoMaximoDeInscricoes.setBounds(20, 215, 350, 20);
		areaDoFormulario.add(campoMaximoDeInscricoes);
		
		JLabel labelPesoCRE = labelPadrao("Peso do CRE:", 12);
		labelPesoCRE.setBounds(20, 255, 100, 15);
		areaDoFormulario.add(labelPesoCRE);
		
		Float[] numerosDecimais = {0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f};
		campoPesoCRE = new JComboBox<Float>(numerosDecimais);
		campoPesoCRE.setBounds(20, 270, 350, 20);
		areaDoFormulario.add(campoPesoCRE);
		
		JLabel labelPesoNota = labelPadrao("Peso da nota na disciplina:", 12);
		labelPesoNota.setBounds(20, 310, 250, 15);
		areaDoFormulario.add(labelPesoNota);
		
		campoPesoNota = new JComboBox<Float>(numerosDecimais);
		campoPesoNota.setBounds(20, 325, 350, 20);
		areaDoFormulario.add(campoPesoNota);
        
        confirmar = new JButton("Confirmar");
        confirmar.setBounds(20, 600, 100, 50);
        confirmar.addActionListener(this);
        
        areaDoFormulario.add(confirmar);
        
        JPanel formularioDisciplina = new JPanel();
        formularioDisciplina.setLayout(null);
        formularioDisciplina.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        formularioDisciplina.setBounds(900, 300, 390, 300);
        formularioDisciplina.setOpaque(true);
        add(formularioDisciplina);
        
        JLabel tituloFormularioDisciplina = new JLabel("Adicionar disciplina");
        tituloFormularioDisciplina.setBounds(20, 15, 300, 30);
        tituloFormularioDisciplina.setFont(new Font("Arial", Font.BOLD, 20));
        formularioDisciplina.add(tituloFormularioDisciplina);
        
        JLabel labelNomeDisciplina = labelPadrao("Nome da disciplina:", 12);
        labelNomeDisciplina.setBounds(20, 90, 350, 15);
        formularioDisciplina.add(labelNomeDisciplina);
        
        campoNomeDisciplina = new JTextField();
        campoNomeDisciplina.setBounds(20, 105, 350, 20);
        formularioDisciplina.add(campoNomeDisciplina);
        
        JLabel labelQuntidadeDeVagas = labelPadrao("Quantidade de vagas:", 12);
        labelQuntidadeDeVagas.setBounds(20, 150, 350, 15);
        formularioDisciplina.add(labelQuntidadeDeVagas);
        
        campoQuantidadeDeVagas = new JComboBox<Integer>(numeros);
        campoQuantidadeDeVagas.setBounds(20, 170, 350, 20);
        formularioDisciplina.add(campoQuantidadeDeVagas);
        
        botaoOK = new JButton("OK");
        botaoOK.setBounds(20, 250, 150, 30);
        botaoOK.addActionListener(this);
        formularioDisciplina.add(botaoOK);
	}
   
    public void habilitarBotaoConfirmar() {
    	if(!campoDataFinal.getText().isBlank() &&
    	   !campoDataInicial.getText().isBlank() &&
    	   campoPesoCRE.getSelectedItem() != null &&
    	   campoPesoNota.getSelectedItem() != null &&
    	   campoMaximoDeInscricoes.getSelectedItem() != null &&
    	   !editalDTO.getVagas().isEmpty()) {
    		
    		confirmar.setEnabled(true);
    	}
    		
    }
    
    public static void main(String[] args) {
    	JanelaCadastrarEdital j = new JanelaCadastrarEdital();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirmar) {
			
			String data = campoDataInicial.getText();
			DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime dataFormatada = LocalDate.parse(data,parser).atStartOfDay();
			
			editalDTO.setDataInicio(dataFormatada);
			
			data = campoDataFinal.getSelectedText();
			dataFormatada = LocalDate.parse(data,parser).atStartOfDay();
			
			editalDTO.setDataFinal(dataFormatada);
			
			editalDTO.setMaximoDeInscricoesPorAluno((int) campoMaximoDeInscricoes.getSelectedItem());
			editalDTO.setPesoCRE((int) campoPesoCRE.getSelectedItem());
			editalDTO.setPesoNota((int) campoPesoNota.getSelectedItem());

			controller.salvarEdital(editalDTO);
		} else if(e.getSource() == botaoOK) {
			vagaDTO = new VagaDTO();
			vagaDTO.setDisciplina(campoNomeDisciplina.getText());
			vagaDTO.setQuantidadeDeVagas((int)campoQuantidadeDeVagas.getSelectedItem());
			editalDTO.getVagas().add(vagaDTO);

		}
		
	}


}