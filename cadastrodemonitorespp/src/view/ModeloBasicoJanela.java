package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import imagens.Imagens;

public class ModeloBasicoJanela extends JFrame {

	private JLabel tituloDoCabecalho;
	private JPanel cabecalho;
	private JMenuItem menuListarEditais;
	private JMenuItem menuAdicionarEdital;
	 
	public ModeloBasicoJanela() {
		setIconImage(Imagens.ICONE_IF_TOPO_DA_JANELA);
		setTitle("Cadastro de Monitores");
		setSize(tamanhoDaTela().width,tamanhoDaTela().height); 
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(null);
		getContentPane().setBackground(adicionarCor(181,232,149)); 
	}
	
	public Dimension tamanhoDaTela() {
		Toolkit t = Toolkit.getDefaultToolkit();
        return t.getScreenSize();
	}
	
	public Color adicionarCor(int num1, int num2, int num3) {
		float[] cor = new float[3];
		cor = Color.RGBtoHSB(num1, num2, num3, cor);
		return Color.getHSBColor(cor[0], cor[1], cor[2]);
	}
	
	public JLabel labelPadrao(String descricao, int tamanho) {
		JLabel label = new JLabel(descricao);
		label.setFont(new Font("Arial", Font.PLAIN, tamanho));
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));
		return label;
	}
	
	public void criarCabecalho(String titulo) {
			
		cabecalho = new JPanel();
		cabecalho.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		cabecalho.setLayout(null);
		cabecalho.setOpaque(false);
		
		JLabel imagem = new JLabel(Imagens.LOGO_IF_CABECALHO);
		imagem.setBounds(5, 5, 65, 65);
		cabecalho.add(imagem);
		
		tituloDoCabecalho = new JLabel(titulo);
		tituloDoCabecalho.setFont(new Font("Arial", Font.BOLD, 20));
		tituloDoCabecalho.setHorizontalAlignment(SwingConstants.CENTER);
		tituloDoCabecalho.setOpaque(false);
		tituloDoCabecalho.setBounds(getWidth()/2 - 400, 0, 800, 70);
		cabecalho.add(tituloDoCabecalho);
		
		cabecalho.setBounds(0, 0, getWidth(), 70);
		add(cabecalho);
	
	}
	
	public void adicionarMenuPrincipal() {
		
		JMenuBar barraDeMenu = new JMenuBar();
		
		this.menuListarEditais = new JMenuItem("Listar editais");
		this.menuAdicionarEdital = new JMenuItem("Adicionar edital");
		
		barraDeMenu.add(menuListarEditais);
		barraDeMenu.add(menuAdicionarEdital);
		
		class OuvinteMenu implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == menuAdicionarEdital) {
					dispose();
					new JanelaCadastrarEdital();
				} else if(e.getSource() == menuListarEditais) {
					dispose();
					new JanelaVerEditais();
				}
				
			}
			
		}
		
		OuvinteMenu ouvinteMenuPrincipal = new OuvinteMenu();
		menuListarEditais.addActionListener(ouvinteMenuPrincipal);
		menuAdicionarEdital.addActionListener(ouvinteMenuPrincipal);

		barraDeMenu.setBounds(5, 75, 270, 20);
		barraDeMenu.setVisible(true);
		add(barraDeMenu);
	}
	
	public JLabel getTituloDoCabecalho() {
		return tituloDoCabecalho;
	}
	
	public void setTituloDoCabecalho(JLabel tituloDoCabecalho) {
		this.tituloDoCabecalho = tituloDoCabecalho;
	}
	
	public JPanel getCabecalho() {
		return cabecalho;
	}
	
	public void setCabecalho(JPanel cabecalho) {
		this.cabecalho = cabecalho;
	}

	public JMenuItem getMenuAdicionarEdital() {
		return menuAdicionarEdital;
	}

	public void setMenuAdicionarEdital(JMenuItem menuAdicionarEdital) {
		this.menuAdicionarEdital = menuAdicionarEdital;
	}

}
