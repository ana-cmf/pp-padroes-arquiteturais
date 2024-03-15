package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.EditalDeMonitoriaController;
import dto.EditalDeMonitoriaDTO;
import dto.VagaDTO;

public class JanelaVerEditais extends ModeloJanelaComTabela implements ActionListener{
	
	private EditalDeMonitoriaDTO editalSelecionado;
	private JButton clonarEdital;
	private JButton encerrarEdital;
	private JButton excluirEdital; 
	private EditalDeMonitoriaController controller;
	private JPanel painel;
	
	public JanelaVerEditais() {
		this.controller = new EditalDeMonitoriaController();
		this.controller.setJanelaVerEditais(this);
		try {
			setListaDeEditais(controller.buscarEditais());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao carregar as informações!", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		criarCabecalho("Cadastro de monitores");
		adicionarMenuPrincipal();
		tabelaEditais();
		adicionarOuvinteNaTabela();	
		
		if(!getListaDeEditais().isEmpty()) {
			this.editalSelecionado = getListaDeEditais().get(0);
			mostrarDetalhesDoEditalNoPainelBranco();
		}
		
		mostrarTituloDaTabelaDeEditaisNaTela();
		criarBotoesDoEditalNoPainelBranco();
		mostrarTituloDoPainelBranco();
		setVisible(true);
	}
	
	public JanelaVerEditais(EditalDeMonitoriaDTO editalSelecionado, ArrayList<EditalDeMonitoriaDTO> listaDeEditais) {
		this.editalSelecionado = editalSelecionado;
		setListaDeEditais(listaDeEditais);
		this.controller = new EditalDeMonitoriaController();
		this.controller.setJanelaVerEditais(this);
		try {
			setListaDeEditais(controller.buscarEditais());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao carregar as informações!", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		criarCabecalho("Cadastro de monitores");
		adicionarMenuPrincipal();
		tabelaEditais();
		mostrarDetalhesDoEditalNoPainelBranco();
		criarBotoesDoEditalNoPainelBranco();
		mostrarTituloDoPainelBranco();
		setVisible(true);
	}
	
	
	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clonarEdital) {
			try {
				controller.clonarEdital(editalSelecionado);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Erro ao carregar as informações!", "Erro", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			atualizarJanela();
		}else if(e.getSource() == excluirEdital) {
			try {
				controller.excluirEdital(editalSelecionado);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			atualizarJanela();
		}else if(e.getSource() == encerrarEdital) {
			try {
				controller.encerrarEditalAntesDoTempo(editalSelecionado);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Erro ao carregar dados. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			atualizarJanela();
		}
	}
	
	public void mostrarTituloDoPainelBranco() {
		JLabel tituloDoPainelBranco; 
		if(getListaDeEditais().isEmpty()) {
			tituloDoPainelBranco = new JLabel("Não há editais para mostrar");			
		}else {
			tituloDoPainelBranco = new JLabel("Detalhes do edital");
			
			if(editalSelecionado == null) {
				editalSelecionado = getListaDeEditais().get(0);
			}
			
			mostrarDetalhesDoEditalNoPainelBranco();
		}
		tituloDoPainelBranco.setFont(new Font("Arial", Font.BOLD, 14));
		tituloDoPainelBranco.setBounds(getWidth(), 30, painel.getWidth()/3, 40);
		painel.add(tituloDoPainelBranco);
		repaint();
	}
	
	public void mostrarDetalhesDoEditalNoPainelBranco() {
		
		DateTimeFormatter formatoDaData = DateTimeFormatter.ofPattern("d/M/y");
		
		String dataInicial = "Data de início: " + editalSelecionado.getDataInicio().toLocalDate().format(formatoDaData);
		String dataFinal = "Data final: ";
		String pesoNota = "Peso da nota na disciplina: " + editalSelecionado.getPesoNota();
		String pesoCRE = "Peso do CRE: " + editalSelecionado.getPesoCRE();
		String maximoDeInscricoesPorAluno = "Máximo de inscrições por aluno: " + editalSelecionado.getMaximoDeInscricoesPorAluno();
		String infoVagas = "";
		for (VagaDTO vaga: editalSelecionado.getVagas()) {
			infoVagas += vaga.getDisciplina()+" - "+vaga.getQuantidadeDeVagas()+" vagas\n";
		}
		
		if(editalSelecionado.getDataEmQueEncerrou() != null) {
			dataFinal = dataFinal + editalSelecionado.getDataEmQueEncerrou().toLocalDate().format(formatoDaData);
		} else {
			dataFinal = dataFinal + editalSelecionado.getDataFinal().toLocalDate().format(formatoDaData);
		}
		
		JTextArea informacoesDoEdital = new JTextArea(
				dataInicial + "\n"+
				dataFinal + "\n" +
				pesoNota + "\n" +
				pesoCRE + "\n" +
				maximoDeInscricoesPorAluno + "\n" +
				infoVagas
				);
		informacoesDoEdital.setBounds(5, 70, 1000, 380);
		informacoesDoEdital.setEditable(false);
		informacoesDoEdital.setCaretColor(informacoesDoEdital.getBackground());
		informacoesDoEdital.setDisabledTextColor(Color.black);
		informacoesDoEdital.setOpaque(false);
		painel = criarPainelBrancoVazio();
		painel.add(informacoesDoEdital);
		add(painel);
		repaint();
	}
	
	public void criarBotoesDoEditalNoPainelBranco() {

		JPanel areaDosBotoes = new JPanel(false);
		
		JButton clonarEdital = new JButton("Clonar edital");
		clonarEdital.addActionListener(this);
		this.clonarEdital = clonarEdital;
		
		JButton encerrarEdital = new JButton("Encerrar edital");
		this.encerrarEdital = encerrarEdital;
		encerrarEdital.addActionListener(this);
		encerrarEdital.setVisible(editalSelecionado.getDataFinal().isBefore(LocalDateTime.now()) &&
								  editalSelecionado.getDataEmQueEncerrou() == null);
		
		JButton excluirEdital = new JButton("Excluir edital");
		excluirEdital.addActionListener(this);
		this.excluirEdital = excluirEdital;
		
		areaDosBotoes.add(clonarEdital);
		areaDosBotoes.add(encerrarEdital);
		areaDosBotoes.add(excluirEdital);
		
		areaDosBotoes.setBounds(5, painel.getHeight() - 80, painel.getWidth() - 10, 80);
		areaDosBotoes.setVisible(true);
		
		painel.add(areaDosBotoes);
	}
	
	public void adicionarOuvinteNaTabela() {
		
		if (getTabela()!= null) {
			
			class OuvinteTabela implements ListSelectionListener{
				
				public void valueChanged(ListSelectionEvent e) {
					int index = getTabela().getSelectedRow();
					EditalDeMonitoriaDTO edital = getListaDeEditais().get(index);
					setEditalSelecionado(edital);
					atualizarJanela();
					}
					
			}
				
			getTabela().getSelectionModel().addListSelectionListener(new OuvinteTabela());
		}
		
		
	}
	
	public void valueChanged(ListSelectionEvent e) {
		int index = getTabela().getSelectedRow();
		setEditalSelecionado(getListaDeEditais().get(index));
		atualizarJanela();
				
	}

	public void atualizarJanela() {
		new JanelaVerEditais(editalSelecionado, getListaDeEditais());
		dispose();
	}
	
	public EditalDeMonitoriaDTO getEditalSelecionado() {
		return editalSelecionado;
	}

	public void setEditalSelecionado(EditalDeMonitoriaDTO editalSelecionado) {
		this.editalSelecionado = editalSelecionado;
	}


	public JButton getExcluirEdital() {
		return excluirEdital;
	}

	public void setExcluirEdital(JButton excluirEdital) {
		this.excluirEdital = excluirEdital;
	}

	public JButton getClonarEdital() {
		return clonarEdital;
	}

	public void setClonarEdital(JButton clonarEdital) {
		this.clonarEdital = clonarEdital;
	}

	public JButton getEncerrarEdital() {
		return encerrarEdital;
	}

	public void setEncerrarEdital(JButton encerrarEdital) {
		this.encerrarEdital = encerrarEdital;
	}

	

}
