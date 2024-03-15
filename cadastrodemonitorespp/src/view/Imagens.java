package view;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Imagens {

	public static final Image ICONE_IF_TOPO_DA_JANELA = Toolkit.getDefaultToolkit().getImage(Imagens.class.getResource("/logo-ifpb-11x16.png"));

	public static final ImageIcon LOGO_IF_CABECALHO = new ImageIcon(Imagens.class.getResource("/ifpbnovo.png"));
}
