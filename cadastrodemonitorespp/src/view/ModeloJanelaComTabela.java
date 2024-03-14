package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import dto.UsuarioDTO;

public class ModeloJanelaComTabela extends ModeloBasicoJanela {

	private UsuarioDTO usuarioDTO;
	private JPanel painelBranco;
	private JMenuItem menuListarEditais;
	private JMenuItem menuAdicionarEdital;
	private JMenuItem menuListarAlunos;
	
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
	
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}
	public void setUsuarioDTO(UsuarioDTO usuario) {
		this.usuarioDTO = usuario;
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
	public JMenuItem getMenuListarAlunos() {
		return menuListarAlunos;
	}
	public void setMenuListarAlunos(JMenuItem menuListarAlunos) {
		this.menuListarAlunos = menuListarAlunos;
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

}
