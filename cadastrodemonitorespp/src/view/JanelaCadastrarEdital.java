package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import dto.EditalDeMonitoriaDTO;
import dto.VagaDTO;

public class JanelaCadastrarEdital extends ModeloBasicoJanela implements FocusListener, ActionListener{

    
	private JButton confirmar;
	private JFormattedTextField campoDataInicial;
	private JFormattedTextField campoDataFinal;
	private JComboBox campoMaximoDeInscricoes;
	private JComboBox<Float> campoPesoCRE;
	private JComboBox<Float> campoPesoNota;
	private EditalDeMonitoriaDTO editalDTO;
	private VagaDTO vagaDTO;
	private JButton adicionarDisciplina;
	private Object controller;
	


    public JanelaCadastrarEdital() {
    	criarCabecalho("Cadastro de monitores");
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
		
		campoDataInicial.addFocusListener(this);
		campoDataFinal.addFocusListener(this);
		campoMaximoDeInscricoes.addFocusListener(this);
        campoPesoCRE.addFocusListener(this);
        campoPesoNota.addFocusListener(this);
        
        confirmar = new JButton("Confirmar");
        confirmar.setBounds(20, 600, 100, 50);
        confirmar.setEnabled(false);
        confirmar.addActionListener(this);
        
        adicionarDisciplina = new JButton("Adicionar disciplina");
        adicionarDisciplina.setBounds(20, 370, 150, 30);
        
        areaDoFormulario.add(confirmar);
        areaDoFormulario.add(adicionarDisciplina);
        
	}
    
    public boolean tudoEstaPreenchido() {
    	return !campoDataFinal.getText().isBlank() &&
    	   !campoDataInicial.getText().isBlank() &&
    	   campoPesoCRE.getSelectedItem() != null &&
    	   campoPesoNota.getSelectedItem() != null &&
    	   campoMaximoDeInscricoes.getSelectedItem() != null;
    		
    }
    
    public void habilitarBotaoConfirmar() {
    	if(tudoEstaPreenchido()) {
    		confirmar.setEnabled(true);
    	}
    }
    
    public static void main(String[] args) {
    	JanelaCadastrarEdital j = new JanelaCadastrarEdital();
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		habilitarBotaoConfirmar();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirmar) {
			controller.
		}
		
	}

}