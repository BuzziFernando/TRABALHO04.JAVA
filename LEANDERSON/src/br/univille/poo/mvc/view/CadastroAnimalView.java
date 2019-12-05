package br.univille.poo.mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.univille.poo.mvc.control.CadastroAnimalControl;
import br.univille.poo.mvc.model.AnimalModel;
import br.univille.poo.mvc.util.Observer;
import br.univille.poo.mvc.util.Subject;

public class CadastroAnimalView extends JFrame implements Observer{

	private AnimalModel model;
	private CadastroAnimalControl control;
	private JTextField CodigoTextFild;
	private JTextField RacaTextField;
	private JTextField EspecieTextField;
	private JTextField AnimalTextField;
	private JButton    salvarButton;
	private JButton    cancelarButton;
	private JButton    novoButton;
	private JButton    deletarButton;
	private JLabel statusLabel;
	
	public CadastroAnimalView() {
		setSize(400,280);
		setTitle("Cadastro de Animais");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildLayout();
	}
	
	public void setModel(AnimalModel model) {
		this.model = model;
	}
	
	public void setControl(CadastroAnimalControl control) {
		this.control = control;
	}

	private void buildLayout() {
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());
		
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(BorderFactory.createCompoundBorder(
				
				  BorderFactory.createEmptyBorder(20, 20, 0, 20)
				, BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Cadastrar Animais")
						,BorderFactory.createEmptyBorder(10, 10, 10, 10))));

	
		
		CodigoTextFild = new JTextField(20);
		CodigoTextFild.setEnabled(false);
		EspecieTextField = new JTextField(20);
		RacaTextField = new JTextField(20);
		RacaTextField = new JTextField(20);
		AnimalTextField = new JTextField(20);
		
		
		
		salvarButton = new JButton("Salvar");
		salvarButton.setToolTipText("Salvar as alteraÃ§oes");
		salvarButton.addActionListener(e -> salvar());
		
		cancelarButton = new JButton("Cancelar");
		novoButton = new JButton("Novo");
		novoButton.setToolTipText("Criar novo Raça de Animais");
		novoButton.addActionListener(e -> novo());
		deletarButton = new JButton("Deletar");
		deletarButton.setToolTipText("Excluir Raça de Animais");
		deletarButton.setEnabled(true);
		deletarButton.addActionListener(e -> deletar());
		

		JLabel l = new JLabel("Codigo",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(60,16));
		panel.add(l);
		panel.add(CodigoTextFild);
		
		l = new JLabel("Especie",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(60,16));
		panel.add(l);
		panel.add(EspecieTextField);
		l = new JLabel("Raça",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(60,16));
		panel.add(l);
		panel.add(RacaTextField);
		l = new JLabel("Animal",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(60,16));
		panel.add(l);
		panel.add(AnimalTextField);
		l = new JLabel();
		l.setPreferredSize(new Dimension(60,16));
		panel.add(l);
		panel.add(novoButton);
		panel.add(salvarButton);
		panel.add(deletarButton);
		
		JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statusPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
		statusLabel = new JLabel("Cadastre um novo Raça de Animal");
		statusPanel.add(statusLabel);
		
		
		root.add(statusPanel,BorderLayout.SOUTH);
		root.add(panel,BorderLayout.CENTER);
		
		add(root);
	}
	
	private void exibirDados() {
		RacaTextField.setText(Long.toString(model.getId()));
		EspecieTextField.setText(model.getEspecie());
		AnimalTextField.setText(model.getAnimal());
		RacaTextField.setText(model.getRaca());
	}
	
	
	private void salvar() {
		control.salvar();
	}
	
	private void deletar() {
		control.deletar();
	}
	
	private void novo() {
		control.novo();
	}

	public JButton getBotaoDeletar() {
		return deletarButton;
	}

	public void setMensagemStatusBar(String text) {
		statusLabel.setText(text);
	}

	@Override
	public void update(Subject s, Object o) {
		model = (AnimalModel) o;
		exibirDados();
	}
	
	public String getRaça() {
		return RacaTextField.getText();
	}
	
	public String getAnimal() {
		return AnimalTextField.getText();
	}
	
	public String getEspecie() {
		return EspecieTextField.getText();
	}
	
}
