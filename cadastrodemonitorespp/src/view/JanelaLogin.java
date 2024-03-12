package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import ouvintes.BotaoLoginEntrar;
import ouvintes.OuvinteBotaoCadastrar;

/**
 * Janela de login
 */
public class JanelaLogin extends ModeloBasicoJanela {
	
	private JPasswordField campoDeSenha;
	private JTextField campoDeEmail;
	private JButton botaoEntrar;
	
	public JTextField getCampoDeEmail( ){
		return campoDeEmail;	
	}
	public void setCampoDeEmail(JTextField campoDeEmail) {
		this.campoDeEmail=campoDeEmail;
	} 

	public JPasswordField getCampoDeSenha( ){  
		return campoDeSenha;	
	}
	public void setCampoDeSenha(JPasswordField campoDeSenha) {
		this.campoDeSenha=campoDeSenha;
	}
	

	public JanelaLogin(){
		criarCabecalho("Cadastro de monitores - Login");
		configurarFormulario();
		setVisible(true);
		repaint();
	}
	
	/**
	 * Cria campos de formulário solicitando as informações de login e os adiciona na janela.
	 * Também adiciona na tela um botão que dá acesso à tela de cadastro de alunos.
	 */
	public void configurarFormulario() {
	
		class OuvinteAvisoCampoObrigatorio implements KeyListener{
			//private JanelaCadastroCoordenador janela;
				@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				JTextField campo = (JTextField) e.getSource();
				String conteudo;
				
				if (campo instanceof JPasswordField) {
					
					conteudo = new String(((JPasswordField) campo).getPassword());
					
				} else {
					conteudo = campo.getText().trim();
				}
				
				if (conteudo.isEmpty()) {
					Border linhaVermelha = BorderFactory.createLineBorder(Color.RED);
					campo.setBorder(linhaVermelha);
				} else {
					campo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				}
				
				habilitarBotaoEntrar();
				
			}
				@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		}
		
		OuvinteAvisoCampoObrigatorio ouvinteBordaVermelha = new OuvinteAvisoCampoObrigatorio();
			
		//Caixa de texto e-mail//
		JLabel email = new JLabel("Email*");
		email.setBounds(510, 150, 200, 20);		    
		JTextField campoEmail = new JTextField();
	    campoEmail.setBounds(580,153,200,20);
	    campoEmail.addKeyListener(ouvinteBordaVermelha);
	       
	    //Caixa de texto senha//
	    JLabel senha = new JLabel("Senha*");
		senha.setBounds(510, 200, 120, 20);
		JPasswordField campoSenha = new JPasswordField();
		campoSenha.setBounds(580, 203, 200, 20);
		campoSenha.addKeyListener(ouvinteBordaVermelha);

		setCampoDeSenha(campoSenha);
		setCampoDeEmail(campoEmail);
		    
		    //botões//
		JButton entrar = new JButton("Confirmar");
		this.botaoCadastrar = entrar;
		BotaoLoginEntrar clique = new BotaoLoginEntrar(this);
		entrar.addActionListener(clique);
		entrar.setBounds(510, 260, 110, 30);
		entrar.setEnabled(false);
		this.botaoEntrar = entrar;
		    
		    JButton botaoCadastrar = new JButton("Cadastre-se");
		    OuvinteBotaoCadastrar ouvinteCadastrar = new OuvinteBotaoCadastrar(this);
		    botaoCadastrar.addActionListener(ouvinteCadastrar);
		    botaoCadastrar.setBounds(680, 260, 110, 30);
		      
		      add(email);
		      add(getCampoDeEmail());
		      add(senha);
		      add(getCampoDeSenha());
		      add(entrar);
		      add(botaoCadastrar);
		      
		      JPanel painelDeInformacoes = new JPanel(false);
				painelDeInformacoes.setSize(500, 500);
				painelDeInformacoes.setOpaque(false);
				painelDeInformacoes.setVisible(true);
				painelDeInformacoes.setLayout((LayoutManager) new BoxLayout(painelDeInformacoes, BoxLayout.PAGE_AXIS));
				painelDeInformacoes.setAlignmentX(CENTER_ALIGNMENT);
				painelDeInformacoes.setAlignmentY(TOP_ALIGNMENT);
				getTelaGeral().add(painelDeInformacoes, BorderLayout.CENTER);
				
				JPanel texto = new JPanel(false);
				texto.setSize(489,635);
				//texto.setLayout(null);
				texto.setAlignmentX(CENTER_ALIGNMENT);
				//texto.setAlignmentY(TOP_ALIGNMENT);
			
				texto.setVisible(true);
				painelDeInformacoes.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
				painelDeInformacoes.add(texto);
			}
	
	/**
	 * Habilita o botão de confirmação do login se os campos estiverem preenchidos
	 */
	public void habilitarBotaoEntrar() {
		String senha = new String(campoDeSenha.getPassword());
		if (!campoDeEmail.getText().isBlank() && !senha.isBlank()) {
			botaoEntrar.setEnabled(true);
		} else {
			botaoEntrar.setEnabled(false);
		}
	}
}