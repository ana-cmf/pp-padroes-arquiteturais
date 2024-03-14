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

public class JanelaVerEditais extends ModeloJanelaComTabela implements ActionListener, ListSelectionListener{
	
	private EditalDeMonitoriaDTO editalSelecionado;
	private JMenuItem editarEdital;
	private JLabel tituloDoPainelBranco;
	private JButton clonarEdital;
	private JButton encerrarEdital;
	private JButton excluirEdital;
	private EditalDeMonitoriaController controller;
	
	public JanelaVerEditais() {
		this.controller = new EditalDeMonitoriaController();
		this.controller.setJanelaVerEditais(this);
		criarCabecalho("Cadastro de monitores");
		adicionarMenuPrincipal();
		tabelaEditais();
		mostrarTituloDaTabelaDeEditaisNaTela();
		adicionarPainelBrancoNaTela();
		mostrarDetalhesDoEditalNoPainelBranco();
		setVisible(true);
	}
	
	public JanelaVerEditais(EditalDeMonitoriaDTO editalSelecionado, ArrayList<EditalDeMonitoriaDTO> listaDeEditais) {
		this.editalSelecionado = editalSelecionado;
		setListaDeEditais(listaDeEditais);
		this.controller = new EditalDeMonitoriaController();
		this.controller.setJanelaVerEditais(this);
		criarCabecalho("Cadastro de monitores");
		adicionarMenuPrincipal();
		tabelaEditais();
		mostrarTituloDaTabelaDeEditaisNaTela();
		adicionarPainelBrancoNaTela();
		mostrarDetalhesDoEditalNoPainelBranco();
		setVisible(true);
	}
	
	
	public void criarMenuDoEditalSelecionadoNoPainelBranco() {
		
		JMenuBar menuDoEdital = new JMenuBar();
			
		JMenuItem verEdital = new JMenuItem("Ver edital");
		verEdital.setEnabled(false);
		
		editarEdital = new JMenuItem("Editar edital");
		editarEdital.addActionListener(this);

		menuDoEdital.add(verEdital);
		menuDoEdital.add(editarEdital);
		menuDoEdital.setBounds(5, 5, 150, 20);
		getPainelBranco().add(menuDoEdital);
			
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == editarEdital) {
			dispose();
			//abrir tela de edição
		}else if(e.getSource() == clonarEdital) {
			controller.clonarEdital(editalSelecionado);
			atualizarJanela();
		}else if(e.getSource() == excluirEdital) {
			try {
				controller.excluirEdital(editalSelecionado);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Erro ao carregar dados. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
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
		
		if(getListaDeEditais().isEmpty()) {
			tituloDoPainelBranco.setText("Não há editais para mostrar");			
		}else {
			tituloDoPainelBranco.setText("Detalhes do edital");
			
			if(editalSelecionado == null) {
				editalSelecionado = getListaDeEditais().get(0);
			}
			
			mostrarDetalhesDoEditalNoPainelBranco();
		}
		tituloDoPainelBranco.setFont(new Font("Arial", Font.BOLD, 14));
		tituloDoPainelBranco.setBounds(getPainelBranco().getWidth()/3, 30, getPainelBranco().getWidth()/3, 40);
		getPainelBranco().add(tituloDoPainelBranco);
		repaint();
	}
	
	public void mostrarDetalhesDoEditalNoPainelBranco() {
		
		DateTimeFormatter formatoDaData = DateTimeFormatter.ofPattern("d/M/y");
		
		String numero = "Número: " + editalSelecionado.getNumero();
		String dataInicial = "Data de início: " + editalSelecionado.getDataInicio().toLocalDate().format(formatoDaData);
		String dataFinal = "Data final: ";
		String pesoNota = "Peso da nota na disciplina: " + editalSelecionado.getPesoNota();
		String pesoCRE = "Peso do CRE: " + editalSelecionado.getPesoCRE();
		String maximoDeInscricoesPorAluno = "Máximo de inscrições por aluno: " + editalSelecionado.getMaximoDeInscricoesPorAluno();
		
		if(editalSelecionado.getDataEmQueEncerrou() == null) {
			dataFinal = dataFinal + editalSelecionado.getDataEmQueEncerrou().toLocalDate().format(formatoDaData);
		} else {
			dataFinal = dataFinal + editalSelecionado.getDataFinal().toLocalDate().format(formatoDaData);
		}
		
		JTextArea informacoesDoEdital = new JTextArea(
				numero + "\n" +
				dataInicial + "\n"+
				dataFinal + "\n" +
				pesoNota + "\n" +
				pesoCRE + "\n" +
				maximoDeInscricoesPorAluno + "\n"
				);
		informacoesDoEdital.setBounds(5, 70, 1000, 380);
		informacoesDoEdital.setEditable(false);
		informacoesDoEdital.setCaretColor(getPainelBranco().getBackground());
		informacoesDoEdital.setDisabledTextColor(Color.black);
		informacoesDoEdital.setBackground(getPainelBranco().getBackground());
		getPainelBranco().add(informacoesDoEdital);
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
		
		areaDosBotoes.setBounds(5, getPainelBranco().getHeight() - 80, getPainelBranco().getWidth() - 10, 80);
		areaDosBotoes.setVisible(true);
		
		getPainelBranco().add(areaDosBotoes);
	}
	
	public void adicionarOuvinteNaTabela() {
		
		if(getTabela()!= null) {
			getTabela().getSelectionModel().addListSelectionListener(this);
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

	public JMenuItem getEditarEdital() {
		return editarEdital;
	}

	public void setEditarEdital(JMenuItem editarEdital) {
		this.editarEdital = editarEdital;
	}

	public JLabel getTituloDoPainelBranco() {
		return tituloDoPainelBranco;
	}

	public void setTituloDoPainelBranco(JLabel tituloDoPainelBranco) {
		this.tituloDoPainelBranco = tituloDoPainelBranco;
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
