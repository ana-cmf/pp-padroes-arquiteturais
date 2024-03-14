package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import imagens.Imagens;

/**
 * A janela com as configurações básicas de todas as janelas e reúne alguns métodos utilizados pelas outras janelas
 * Todas as janelas herdam desta janela.
 */
public class ModeloJanela extends JFrame {
	
	private JLabel tituloDoCabecalho;
	private JPanel telaGeral;
	private JPanel cabecalho;
	
	public ModeloJanela() {
	
		setIconImage(Imagens.ICONE_IF_TOPO_DA_JANELA);
		setTitle("Cadastro de Monitores");
		//setSize(700,700);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);	
	}
	 
	/**
	 * Identifica o tamanho do monitor em que o sistema é exibido e configura o tamanho da janela com as dimensões dessa tela
	 */
	public void pegarResolucao() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension dimensao = t.getScreenSize();
        this.setBounds(0, 0, (dimensao.width + 5), (dimensao.height - 38));
    }
	
	public Dimension tamanhoDaTela() {
		Toolkit t = Toolkit.getDefaultToolkit();
        return t.getScreenSize();
	}
	/**
	 * Adiciona um BorderLyout à janela e configura a cor verde do plano de fundo 
	 */
	public void configurarLayout() {
		JPanel telaGeral = (JPanel) getContentPane();
		telaGeral.setLayout(new BorderLayout(40,0));
		telaGeral.setBackground(adicionarCor(181, 232, 149));// adiciona a cor a tela geral//
		this.telaGeral = telaGeral;

	}
	
	/**
	 * Cria um cabeçalho na janela com o logo do IFPB
	 */
	public void criarCabecalho() {
		
		//painel do cabeçalho
		cabecalho = new JPanel();
		cabecalho.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		cabecalho.setBackground(adicionarCor(181,232,149));// adiciona cor ao cabecalho//		
		//Logo do IF no cabeçalho
		JLabel imagem = new JLabel(Imagens.LOGO_IF_CABECALHO);
		imagem.setBounds(5, 5, 80, 80);
		cabecalho.add(imagem);
		//Título no cabeçalho
		tituloDoCabecalho = new JLabel();
		tituloDoCabecalho.setFont(new Font("Arial", Font.BOLD, 20));
		//tituloDoCabecalho.setOpaque(false);
		tituloDoCabecalho.setBounds(200, 0, 100, 50);
		cabecalho.add(tituloDoCabecalho);
		cabecalho.setBounds(0, 0, tamanhoDaTela().width, 70);
		add(cabecalho);

	}
	/**
	 * Converte um código RGB em um objeto Color
	 * @param num1 intensidade do vermelho na cor
	 * @param num2 intensidade do verde na cor
	 * @param num3 intensidade do azul na cor 
	 * @return A cor cujo código foi informado
	 */
	public Color adicionarCor(int num1, int num2, int num3) {
		float[] cor = new float[3];
		cor = Color.RGBtoHSB(num1, num2, num3, cor);
		return Color.getHSBColor(cor[0], cor[1], cor[2]);
	}
	
	/**
	 * Cria um label com fonte padronizada
	 * @param descricao o texto que aparecerá no label
	 * @param tamanho o tamanho da fonte
	 * @return o label com as configurações
	 */
	public JLabel labelPadrao(String descricao, int tamanho) {
		JLabel label = new JLabel(descricao);
		label.setFont(new Font("Arial", Font.PLAIN, tamanho));
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));
		return label;
	}

	/**
	 * Cria um painel padronizado com um campo de texto e um label descrevendo o campo
	 * 
	 * @param descricao o texto que aparecerá no label que acompanha o campo 
	 * @param campo o campo de texto
	 * 
	 * @return o painel com o campo de texto e o label
	 */
	public JPanel criarAreaCampoFormulario(String descricao, JTextField campo) {
		JPanel areaCampo = new JPanel();
		areaCampo.setLayout(new BoxLayout(areaCampo, BoxLayout.Y_AXIS));
		JLabel label = labelPadrao(descricao, 12);
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		areaCampo.setAlignmentX(CENTER_ALIGNMENT);
		areaCampo.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
		areaCampo.add(label);
		areaCampo.add(campo);
		areaCampo.setMinimumSize(new Dimension(30, 100));
		return areaCampo;
	}
	
	public JPanel getCabecalho() {
		return cabecalho;
	}
	
	
	public void setCabecalho(JPanel cabecalho) {
		this.cabecalho = cabecalho;
	}
	
	
	public JLabel getTituloDoCabecalho() {
		return tituloDoCabecalho;
	}
	
	
	public void setTituloDoCabecalho(JLabel tituloDoCabecalho) {
		this.tituloDoCabecalho = tituloDoCabecalho;
	}

	public JPanel getTelaGeral() {
		return telaGeral;
	}


	public void setTelaGeral(JPanel telaGeral) {
		this.telaGeral = telaGeral;
	}

	public static void main(String[] args) {
		ModeloJanela x = new ModeloJanela();
		x.criarCabecalho();
		x.setVisible(true);
	}
 }