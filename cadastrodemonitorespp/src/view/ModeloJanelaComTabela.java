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

import controller.CoordenadorController;
import dto.UsuarioDTO;

public class ModeloJanelaComTabela extends ModeloBasicoJanela implements ActionListener{

	private UsuarioDTO usuarioDTO;
	private CoordenadorController coordenadorController;
	
	private JPanel painelBranco;
	
	private JMenuItem menuListarEditais;
	private JMenuItem menuAdicionarEdital;
	private JMenuItem menuListarAlunos;
	
	private DefaultTableModel modeloTabela;
	private JTable tabela;
	
	public void logarUsuario() {
		JPanel informacoesUsuario = new JPanel(false);
		informacoesUsuario.setOpaque(false);
		informacoesUsuario.setLayout(new BoxLayout(informacoesUsuario, BoxLayout.Y_AXIS));
		
		JLabel nomeUsuario = labelPadrao(getUsuarioDTO().getNome()+" "+getUsuarioDTO().getSobrenome(), 12);
		nomeUsuario.setAlignmentX(SwingConstants.RIGHT);
		
		JLabel emailUsuario = labelPadrao(getUsuarioDTO().getEmail(), 12);
		emailUsuario.setAlignmentX(SwingConstants.RIGHT);
		
		informacoesUsuario.add(nomeUsuario);
		informacoesUsuario.add(emailUsuario);
		
		
		informacoesUsuario.add(Box.createVerticalGlue());
		informacoesUsuario.setBounds(getWidth() - 300, 10, 280, 50);
		informacoesUsuario.setVisible(true);
		getCabecalho().add(informacoesUsuario);

	}
	
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
	
	public void adicionarMenuPrincipalCoordenador() {
		
		JMenuBar barraDeMenu = new JMenuBar();
		
		this.menuListarEditais = new JMenuItem("Listar editais");
		this.menuAdicionarEdital = new JMenuItem("Adicionar edital");
		this.menuListarAlunos = new JMenuItem("Listar alunos");
		
		barraDeMenu.add(menuListarEditais);
		barraDeMenu.add(menuAdicionarEdital);
		barraDeMenu.add(menuListarAlunos);
		
		
		menuListarEditais.addActionListener(this);
		menuAdicionarEdital.addActionListener(this);
		menuListarAlunos.addActionListener(this);


		barraDeMenu.setBounds(5, 75, 270, 20);
		barraDeMenu.setVisible(true);
		add(barraDeMenu);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == menuListarEditais) {
			
			coordenadorController.abrirTelaDeListarEditais();
			
		}
		
		if(e.getSource() == menuAdicionarEdital) {
			
			coordenadorController.abrirTelaDeListarEditais();;
			
		}
		
		if(e.getSource() == menuListarAlunos) {
			
			coordenadorController.abrirTelaDeListarAlunos();;

		}
		
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
