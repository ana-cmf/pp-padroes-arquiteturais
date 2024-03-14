package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.EditalDeMonitoriaDTO;

public class ModeloJanelaComTabela extends ModeloBasicoJanela {

	private JPanel painelBranco;
	private JMenuItem menuListarEditais;
	private JMenuItem menuAdicionarEdital;
	private ArrayList<EditalDeMonitoriaDTO> listaDeEditais = new ArrayList<EditalDeMonitoriaDTO>();
	private DefaultTableModel modeloTabela;
	private JTable tabela;
	
	public void adicionarPainelBrancoNaTela() {
		
		this.painelBranco = criarPainelBrancoVazio();
		add(this.painelBranco);
		
	}
	
	public JPanel criarPainelBrancoVazio() {
		
		int largura = tamanhoDaTela().width - 5 - tamanhoDaTela().width/3;
		int altura = tamanhoDaTela().height - 75;
		
		JPanel painelBrancoVazio = new JPanel();
		painelBrancoVazio.setBounds(tamanhoDaTela().width/3, 75, largura, altura);
		painelBrancoVazio.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		painelBrancoVazio.setLayout(null);
		painelBrancoVazio.setVisible(true);
		return painelBrancoVazio;
		
	}
	
	public void tabelaEditais(){
		
		if (!getListaDeEditais().isEmpty()) {
			
			modeloTabela = new DefaultTableModel();
			modeloTabela.addColumn("Edital");
			
			for (EditalDeMonitoriaDTO editalDTO: getListaDeEditais()) {
				Object[] infoEdital= new Object[] {"Edital "+editalDTO.getNumero()};
				modeloTabela.addRow(infoEdital);
			}
			
			tabela = new JTable(modeloTabela);
			tabela.setRowSelectionAllowed(true);
			tabela.enableInputMethods(false);
			
			JScrollPane painel = new JScrollPane(tabela); 
			painel.setBounds(115, 260, 270, tamanhoDaTela().height - 350);
			painel.setBackground(adicionarCor(181,232,149));
			add(painel);
			
		} else {
			
			JLabel texto = new JLabel("Ainda não há editais cadastrados");
			texto.setFont(new Font("Arial", Font.BOLD, 16));
			texto.setBounds(15, 150, tamanhoDaTela().width/3, 50);
			add(texto);
			
		}
	}
	
	public void mostrarTituloDaTabelaDeEditaisNaTela() {
		
		if (tabela != null) {
			
			JLabel tituloDaTabelaDeEditais = new JLabel("Editais cadastrados");
			tituloDaTabelaDeEditais.setFont(new Font("Arial", Font.BOLD, 40));
			tituloDaTabelaDeEditais.setBounds(60, 140, 500, 100);
			add(tituloDaTabelaDeEditais);
			
		}
		
	}
	
	public JPanel getPainelBranco() {
		return painelBranco;
	}
	public void setPainelBranco(JPanel painelBranco) {
		this.painelBranco = painelBranco;
	}
	public JMenuItem getMenuListarEditais() {
		return menuListarEditais;
	}
	public void setMenuListarEditais(JMenuItem menuListarEditais) {
		this.menuListarEditais = menuListarEditais;
	}
	public JMenuItem getMenuAdicionarEdital() {
		return menuAdicionarEdital;
	}
	public void setMenuAdicionarEdital(JMenuItem menuAdicionarEdital) {
		this.menuAdicionarEdital = menuAdicionarEdital;
	}

	public DefaultTableModel getModeloTabela() {
		return modeloTabela;
	}
	public void setModeloTabela(DefaultTableModel modeloTabela) {
		this.modeloTabela = modeloTabela;
	}
	public JTable getTabela() {
		return tabela;
	}
	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public ArrayList<EditalDeMonitoriaDTO> getListaDeEditais() {
		return listaDeEditais;
	}

	public void setListaDeEditais(ArrayList<EditalDeMonitoriaDTO> listaDeEditais) {
		this.listaDeEditais = listaDeEditais;
	}

}
