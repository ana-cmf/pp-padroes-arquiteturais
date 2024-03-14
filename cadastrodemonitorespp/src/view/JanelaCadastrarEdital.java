package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;;

/**
 * Janela com um formulário de cadastro de um novo edital
 */
public class JanelaCadastrarEdital extends ModeloJanelaComEditais {

    private JFormattedTextField textoFormatadoDataInicio;
    private JFormattedTextField textoFormatadoDataLimite;
    private JTextField campoDisciplinas;
    private JTextField campoVagas;
    private JTextField textFieldRanqueamento;
    private JTextField textFieldRanqueamento2;
	private JButton confirmar;
	private boolean informacoesSaoValidas;


    public TelaCadastrarEditalCoordenador(Usuario usuario) {
		super(usuario); 
        configurarLayout();
		criarCabecalho();
		logarUsuario();
		getTituloDoCabecalho().setText("ADICIONAR NOVO EDITAL:");
		adicionarPainelBranco();
		criarPainelEdital();
		setVisible(true);
    }


    /**
     * Adiciona à janela um painel com o formulário que receberá as informações do novo edital
     */
    public void criarPainelEdital() {
    	
    	adicionarMenuPrincipalCoordenador(getPainelDeInformacoes());
    	getPainelDeInformacoes().setAlignmentX(CENTER_ALIGNMENT);
    	getPainelDeInformacoes().setAlignmentY(TOP_ALIGNMENT);
    	JPanel formulario = new JPanel(false);
    	formulario.setSize(300, 450);
    	formulario.setLayout(new BoxLayout(formulario, BoxLayout.PAGE_AXIS));
    	formulario.setOpaque(false);
    	formulario.setAlignmentX(CENTER_ALIGNMENT);
		formulario.setAlignmentY(TOP_ALIGNMENT);
        formulario.add(Box.createHorizontalGlue());
		
        JLabel titulo = labelPadrao("Adicionar novo edital", 30);
        titulo.setBounds(510, 150, 200, 20);
        formulario.add(titulo);   
        try {
            MaskFormatter dataInicioFormatada = new MaskFormatter("##/##/####");
            textoFormatadoDataInicio = new JFormattedTextField(dataInicioFormatada);
            textoFormatadoDataInicio.setColumns(10);
            textoFormatadoDataInicio.setBounds(220, 40, 200, 20);
            formulario.add(criarAreaCampoFormulario("Data de ínicio das inscrições:*", textoFormatadoDataInicio));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        
        try {
            MaskFormatter dataLimiteFormatada = new MaskFormatter("##/##/####");
            textoFormatadoDataLimite = new JFormattedTextField(dataLimiteFormatada);
            textoFormatadoDataLimite.setColumns(10);
            textoFormatadoDataLimite.setBounds(220, 70, 200, 20);
            formulario.add(criarAreaCampoFormulario("Data limite para as inscrições:*",textoFormatadoDataLimite));
        } catch (ParseException e) {
            e.printStackTrace();
        }
     
        campoDisciplinas = new JTextField(20);
        campoDisciplinas.setBounds(220, 100, 200, 20);
        formulario.add(criarAreaCampoFormulario("Disciplinas: *", campoDisciplinas));
        
        campoVagas = new JTextField(20);
        campoVagas.setBounds(220, 130, 200, 20);
        formulario.add(criarAreaCampoFormulario("Vagas disponiveis para inscrição por aluno:*",campoVagas));

        JLabel ranqueamento1 = new JLabel("Valor do CRE:*");
        ranqueamento1.setBounds(10, 160, 200, 20);
        //formulario.add(ranqueamento1);
        textFieldRanqueamento = new JTextField(20);
        textFieldRanqueamento.setBounds(220, 160, 200, 20);
        formulario.add(criarAreaCampoFormulario("Valor do CRE:*",textFieldRanqueamento));
        JLabel ranqueamento2 = new JLabel("Valor da nota da disciplina:*");
        ranqueamento2.setBounds(10, 160, 200, 20);
        //formulario.add(ranqueamento2);
        textFieldRanqueamento2 = new JTextField(20);
        textFieldRanqueamento2.setBounds(220, 160, 200, 20);
        formulario.add(criarAreaCampoFormulario("Valor da nota da disciplina:*",textFieldRanqueamento2));
        
        formulario.add(Box.createHorizontalStrut(40));
        //painelDeInformacoes.add(Box.createHorizontalGlue());
        getPainelDeInformacoes().add(formulario);
        getPainelDeInformacoes().add(Box.createHorizontalGlue());
        getTelaGeral().add(getPainelDeInformacoes(), BorderLayout.CENTER);

        botaoAdicionarEdital();
        
    }
   
    /**
     * Adiciona um BoxLayout ao painel que exibirá o formulário
     */
    public void configurarPainelDeInformacoes() {
		getPainelDeInformacoes().setLayout(new BoxLayout(getPainelDeInformacoes(), BoxLayout.Y_AXIS));
    }
    
    /**
     * Adiciona à tela um botão de confirmação do cadastro do edital
     */
    public void botaoAdicionarEdital() {
		JPanel areaDosBotoes = new JPanel(false);

    	this.confirmar= new JButton("Confirmar");
    	areaDosBotoes.add(confirmar);
    	getPainelDeInformacoes().add(areaDosBotoes);
    	confirmar.addActionListener(new OuvinteBotaoAdicionarEdital());
    	}
    
    /**
     * Habilita o botão de confirmação se todos os campos estiverem preenchidos
     */
    public void habilitarBotaoConfirmar() {
		if (textoFormatadoDataInicio.getText().isBlank() || textoFormatadoDataLimite.getText().isBlank() ||
				campoDisciplinas.getText().isBlank() || campoVagas.getText().isBlank() || textFieldRanqueamento.getText().isBlank() || textFieldRanqueamento2.getText().isBlank()) 
		{
			informacoesSaoValidas = true;
			confirmar.setEnabled(false);
		}else {
			confirmar.setEnabled(true);
			informacoesSaoValidas = false;
		}
	}


	class OuvinteBotaoAdicionarEdital implements ActionListener {
    		@Override
		public void actionPerformed(ActionEvent e) {
    		String dataInicial = textoFormatadoDataInicio.getText();
    		String dataLimite = textoFormatadoDataLimite.getText();
    		String disciplinas= campoDisciplinas.getText();
    		String vagasDisponiveis = campoVagas.getText();
            String pesos1= textFieldRanqueamento.getText();
            String pesos2= textFieldRanqueamento2.getText();

                
            DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDateTime dataInicio = LocalDate.parse(dataInicial, formatar).atStartOfDay();
            LocalDateTime dataFinal = LocalDate.parse(dataLimite, formatar).atStartOfDay();
            int vagas = Integer.parseInt(vagasDisponiveis);
            float pesoCRE= Float.parseFloat(pesos1);
            float pesoDisciplina = Float.parseFloat(pesos2);
                
            LocalDateTime dataAtual = LocalDate.now().atStartOfDay();
            if(dataInicio.isBefore(dataAtual) && dataFinal.isAfter(dataInicio) ) {
            	JOptionPane.showMessageDialog(null, "Data inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }else if (pesoCRE +pesoDisciplina != 1) {
        		JOptionPane.showMessageDialog(null, "A soma dos pesos deve ser 1", "Erro", JOptionPane.ERROR_MESSAGE);
            }else {
                	
               	Persistencia persistencia = new Persistencia();
               	
               	getCentral().criarNovoEdital(dataInicio, dataFinal, disciplinas, vagas,pesoCRE, pesoDisciplina );
                	
               	try {
               		persistencia.salvarCentral(getCentral(), "central.xml");
                		
               	} catch (Exception e1) {
               		JOptionPane.showMessageDialog(null, "Erro ao carregar as informações!", "Erro", JOptionPane.ERROR_MESSAGE);
               	}
               	dispose();
               	new JanelaCoordenadorListarEditais(getUsuario());
                	
                	
            }
              
    	}
    }
}