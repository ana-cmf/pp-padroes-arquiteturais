package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TelaCadastroCoordenador extends ModeloBasicoJanela {
	
	private JButton botaoConfirmar;
	private JTextField nome;
	private JTextField sobrenome;
	private JTextField email;
	private JTextField confirmarEmail;
	private JPasswordField senha;
	private JPasswordField confirmarSenha;

	public TelaCadastroCoordenador() {
		criarCabecalho("Cadastro do coordenador");
		criarFormulario();
		setVisible(true);
	}
	
	public void criarFormulario() {
		
		JPanel areaDoFormulario = new JPanel();
		areaDoFormulario.setLayout(null);
		areaDoFormulario.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		areaDoFormulario.setBounds(570, 90, 390, 500);
		areaDoFormulario.setOpaque(true);
		add(areaDoFormulario);
		
		JLabel mensagemInicial = labelPadrao("Para iniciar o sistema, cadastre o coordenador.", 14);
		mensagemInicial.setBounds(52, 10, 305, 20);
		areaDoFormulario.add(mensagemInicial);
		
		JLabel aviso = labelPadrao("Os campos marcados com * devem ser preenchidos obrigatoriamente.", 11);;
		aviso.setBounds(18, 50, 375, 20);
		areaDoFormulario.add(aviso);
		
		JLabel labelNome = labelPadrao("Nome *", 12);
		labelNome.setBounds(20, 90, 60, 15);
		areaDoFormulario.add(labelNome);
		
		JTextField campoNome = new JTextField();
		campoNome.setBounds(20, 105, 350, 20);
		areaDoFormulario.add(campoNome);
		
		JLabel labelSobrenome = labelPadrao("Sobrenome *", 12);
		labelSobrenome.setBounds(20, 145, 70, 15);
		areaDoFormulario.add(labelSobrenome);
		
		JTextField campoSobrenome = new JTextField();
		campoSobrenome.setBounds(20, 160, 350, 20);
		areaDoFormulario.add(campoSobrenome);
		
		JLabel labelEmail = labelPadrao("Email *", 12);
		labelEmail.setBounds(20, 200, 60, 15);
		areaDoFormulario.add(labelEmail);
		
		JTextField campoEmail = new JTextField();
		campoEmail.setBounds(20, 215, 350, 20);
		areaDoFormulario.add(campoEmail);
		
		JLabel labelConfirmarEmail = labelPadrao("Confirme o email *", 12);
		labelConfirmarEmail.setBounds(20, 255, 100, 15);
		areaDoFormulario.add(labelConfirmarEmail);
		
		JTextField campoConfirmarEmail = new JTextField();
		campoConfirmarEmail.setBounds(20, 270, 350, 20);
		areaDoFormulario.add(campoConfirmarEmail);
		
		JLabel labelSenha = labelPadrao("Senha * (pelo menos 8 caracteres)", 12);
		labelSenha.setBounds(20, 310, 250, 15);
		areaDoFormulario.add(labelSenha);
		
		JPasswordField campoSenha = new JPasswordField();
		campoSenha.setBounds(20, 325, 350, 20);
		areaDoFormulario.add(campoSenha);
		
		JLabel labelConfirmarSenha = labelPadrao("Confirmar senha *", 12);
		labelConfirmarSenha.setBounds(20, 365, 100, 15);
		areaDoFormulario.add(labelConfirmarSenha);
		
		JPasswordField campoConfirmarSenha = new JPasswordField();
		campoConfirmarSenha.setBounds(20, 380, 350, 20);
		areaDoFormulario.add(campoConfirmarSenha);
		
		JButton botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.setBounds(145, 440, 100, 30);
		botaoConfirmar.setEnabled(false);
		areaDoFormulario.add(botaoConfirmar);
		
		//OuvinteCampoSomenteLetras ouvinteLetras = new OuvinteCampoSomenteLetras();
		//campoNome.addKeyListener(ouvinteLetras);
		//campoSobrenome.addKeyListener(ouvinteLetras);
		
		class OuvinteCampoObrigatorio implements FocusListener {

			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void focusLost(FocusEvent e) {
				JTextField campo = (JTextField) e.getSource();
				String conteudo;
				
				if (campo instanceof JPasswordField) {
					
					conteudo = new String(((JPasswordField) campo).getPassword());
					
					if (conteudo.length() < 8 || conteudo.isEmpty()) {
						Border linhaVermelha = BorderFactory.createLineBorder(Color.RED);
						campo.setBorder(linhaVermelha);
					} else {
						campo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
					
				} else {
						
					if (campo.getText().isBlank()) {
						Border linhaVermelha = BorderFactory.createLineBorder(Color.RED);
						campo.setBorder(linhaVermelha);
					} else {
						campo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
				}	
				
				habilitarBotaoConfirmar();
				
			}
			
		}
		
		OuvinteCampoObrigatorio campoObrigatorio = new OuvinteCampoObrigatorio();
		campoNome.addFocusListener(campoObrigatorio);
		campoSobrenome.addFocusListener(campoObrigatorio);
		campoEmail.addFocusListener(campoObrigatorio);
        campoConfirmarEmail.addFocusListener(campoObrigatorio);
        campoNome.addFocusListener(campoObrigatorio);
        campoSobrenome.addFocusListener(campoObrigatorio);
        campoSenha.addFocusListener(campoObrigatorio);
        campoConfirmarSenha.addFocusListener(campoObrigatorio);
        
        class OuvinteBotaoConfirmar implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				try {
					cadastrarCoordenador();
				} catch (Exception e1) {
		            JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
        	
        }
        
        botaoConfirmar.addActionListener(new OuvinteBotaoConfirmar());
		
		this.nome = campoNome;
        this.sobrenome = campoSobrenome;
        this.email = campoEmail;
        this.confirmarEmail = campoConfirmarEmail;
        this.senha = campoSenha;
        this.confirmarSenha = campoConfirmarSenha;
        this.botaoConfirmar = botaoConfirmar;
        
	}
	
	/**
	 * Habilita o botão de confirmação da tela se todos os campos estiverem preenchidos
	 */

	
	public void cadastrarCoordenador() throws Exception {
		
		String email = getEmail().getText().trim();
		
		String confirmacaoEmail = getConfirmarEmail().getText().trim();
		String conteudoSenha = new String(getSenha().getPassword());
		String confirmacaoSenha = new String(getConfirmarSenha().getPassword());
		
		if (!conteudoSenha.equals(confirmacaoSenha)) {
			throw new Exception("A senha e a confirmação estão diferentes!");
		}
		if (!email.equals(confirmacaoEmail)) {
			throw new Exception("O email e a confirmação estão diferentes!");
		}

		//Coordenador coord = Coordenador.getInstancia();
		//coord.setNome(getNome().getText().trim());
		//coord.setSobrenome(getSobrenome().getText().trim());
		//coord.setEmail(email);
		//coord.setSenha(conteudoSenha.trim());
	
		dispose();
		new JanelaLogin();
	}

	public JButton getBotaoConfirmar() {
		return botaoConfirmar;
	}

	public void setBotaoConfirmar(JButton botaoConfirmar) {
		this.botaoConfirmar = botaoConfirmar;
	}

	public JTextField getNome() {
		return nome;
	}

	public void setNome(JTextField nome) {
		this.nome = nome;
	}

	public JTextField getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(JTextField sobrenome) {
		this.sobrenome = sobrenome;
	}

	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	public JTextField getConfirmarEmail() {
		return confirmarEmail;
	}

	public void setConfirmarEmail(JTextField confirmarEmail) {
		this.confirmarEmail = confirmarEmail;
	}

	public JPasswordField getSenha() {
		return senha;
	}

	public void setSenha(JPasswordField senha) {
		this.senha = senha;
	}

	public JPasswordField getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(JPasswordField confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	
	public static void main(String[] args) {
		TelaCadastroCoordenador x = new TelaCadastroCoordenador();
	}
}
