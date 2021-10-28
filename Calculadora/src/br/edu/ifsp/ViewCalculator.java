package br.edu.ifsp;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ViewCalculator extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel painel;
	private JTextArea textview_output;
	private JButton button_zerar;
	private JButton button_multiplicar;
	private JButton button_dividir;
	private JButton button_somar;
	private JButton button_subtrair;
	private JButton button_calcular;
	private JButton button_ponto;
	private JButton button_limpar;
	private JButton button_potencia;
	private JButton _0;
	private JButton _1;
	private JButton _2;
	private JButton _3;
	private JButton _4;
	private JButton _5;
	private JButton _6;
	private JButton _7;
	private JButton _8;
	private JButton _9;
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	private String tela;
	private int operacao;

	public ViewCalculator() {
		super("Calculadora");
		initComponents();
		insertComponents();
		configure();
	}

	
	private void initComponents() {
		painel = new JPanel();
		textview_output = new JTextArea();
		textview_output.setLineWrap(true);
		textview_output.setEditable(false);
		textview_output.setFont(new Font("Arial Black", Font.PLAIN, 24));
		button_zerar = new JButton("C");
		button_multiplicar = new JButton("*");
		button_dividir = new JButton("/");
		button_somar = new JButton("+");
		button_subtrair = new JButton("-");
		button_calcular = new JButton("=");
		button_ponto = new JButton(".");
		button_limpar = new JButton("CE");
		button_potencia = new JButton("^");
		_0 = new JButton("0");
		_1 = new JButton("1");
		_2 = new JButton("2");
		_3 = new JButton("3");
		_4 = new JButton("4");
		_5 = new JButton("5");
		_6 = new JButton("6");
		_7 = new JButton("7");
		_8 = new JButton("8");
		_9 = new JButton("9");
		layout = new GridBagLayout();
		constraints = new GridBagConstraints();
		button_zerar.addActionListener(this);
		button_multiplicar.addActionListener(this);
		button_dividir.addActionListener(this);
		button_somar.addActionListener(this);
		button_subtrair.addActionListener(this);
		button_calcular.addActionListener(this);
		button_ponto.addActionListener(this);
		button_limpar.addActionListener(this);
		button_potencia.addActionListener(this);
		_0.addActionListener(this);
		_1.addActionListener(this);
		_2.addActionListener(this);
		_3.addActionListener(this);
		_4.addActionListener(this);
		_5.addActionListener(this);
		_6.addActionListener(this);
		_7.addActionListener(this);
		_8.addActionListener(this);
		_9.addActionListener(this);		
	}
	

	private void configure() {
		setResizable(true);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}


	private void insertComponents() {
		int iColunm = 0;
		int iLine = 0;
		painel.setLayout(layout);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 0.5;
		constraints.weighty = 0.5;
		constraints.gridx = iLine;
		constraints.gridy = iColunm;
		constraints.gridwidth = 4;
		constraints.gridheight = 1;		
		painel.add(textview_output, constraints);
		constraints.gridx = iLine;
		iColunm += 1;
		constraints.gridy = iColunm;
		constraints.gridwidth = 1;
		painel.add(button_potencia, constraints);
		iLine += 1;
		constraints.gridx = iLine;
		painel.add(button_dividir, constraints);
		iLine += 1;
		constraints.gridx = iLine;
		painel.add(button_limpar, constraints);
		iLine += 1;
		constraints.gridx = iLine;		
		painel.add(button_zerar, constraints);		
		iLine = 0;
		iColunm += 1;
		constraints.gridx = iLine;
		constraints.gridy = iColunm;
		painel.add(_7, constraints);
		iLine += 1;
		constraints.gridx = iLine;
		painel.add(_8, constraints);
		iLine += 1;
		constraints.gridx = iLine;
		painel.add(_9, constraints);
		iLine += 1;
		constraints.gridx = iLine;
		painel.add(button_multiplicar, constraints);
		iLine = 0;
		iColunm += 1;
		constraints.gridx = iLine;
		constraints.gridy = iColunm;
		painel.add(_4, constraints);
		iLine += 1;
		constraints.gridx = iLine;
		painel.add(_5, constraints);
		iLine += 1;
		constraints.gridx = iLine;
		painel.add(_6, constraints);
		iLine += 1;
		constraints.gridx = iLine;
		painel.add(button_subtrair, constraints);
		iLine = 0;
		iColunm += 1;
		constraints.gridx = iLine;
		constraints.gridy = iColunm;
		painel.add(_1, constraints);
		iLine += 1;
		constraints.gridx = iLine;
		painel.add(_2, constraints);
		iLine += 1;
		constraints.gridx = iLine;
		painel.add(_3, constraints);
		iLine += 1;
		constraints.gridx = iLine;
		painel.add(button_somar, constraints);
		iLine = 0;
		iColunm += 1;
		constraints.gridx = iLine;
		constraints.gridy = iColunm;
		painel.add(_0, constraints);
		iLine += 1;
		constraints.gridx = iLine;
		painel.add(button_ponto, constraints);
		iLine += 1;
		constraints.gridx = iLine;
		constraints.gridwidth = 2;
		painel.add(button_calcular, constraints);
		add(painel);
	}

	private void atualizar(String numero) {
		 if(tela == null || tela.equals("0")){
	         tela = numero;
	     } else {
	    	 tela = tela+numero;
	     }
	     textview_output.setText(tela);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == button_zerar) {
			zerar();
			return;
		} 
		if (source == button_multiplicar) {
			contar(Constants.MULTIPLICACAO);
			return;
		} 
		if (source == button_dividir) {
			contar(Constants.DIVISAO);
			return;
		}
		if (source == button_somar) {
			contar(Constants.ADICAO);
			return;
		}
		if (source == button_subtrair) {
			contar(Constants.SUBTRACAO);
			return;
		} 
		if (source == button_calcular) {
			contar(Constants.RESULTADO);
			return;
		}
		if (source == button_ponto) {
			atualizar(".");
			return;
		}
		if (source == button_limpar) {
			limpar();
			textview_output.setText(String.format("%.2f", Float.parseFloat(tela)));
			return;
		}
		if (source == button_potencia) {
			contar(Constants.POTENCIA);
			return;
		}
		if (source == _0) {
			atualizar("0");
			return;
		} 
		if (source == _1) {
			atualizar("1");
			return;
		}
		if (source == _2) {
			atualizar("2");
			return;
		}
		if (source == _3) {
			atualizar("3");
			return;
		} 
		if (source == _4) {
			atualizar("4");
			return;
		}
		if (source == _5) {
			atualizar("5");
			return;
		}
		if (source == _6) {
			atualizar("6");
			return;
		}
		if (source == _7) {
			atualizar("7");
			return;
		}
		if (source == _8) {
			atualizar("8");
			return;
		}
		if (source == _9) {
		  atualizar("9");
		  return;
		}
	}

	private void limpar() {
		tela = "0";
	}

	private void contar(int constante) {
		 try{
	            if(tela == null || tela.equals(".")){
	                atualizar("0");
	            }
	            if(operacao != Constants.NULO){
	                tela = String.valueOf(Calculator.getInstance().calcular(operacao, Float.parseFloat(tela)));
	            } else {
	                tela = String.valueOf(Calculator.getInstance().calcular(constante, Float.parseFloat(tela)));
	            }
	        } catch (NumberFormatException ex){
	            zerar();
	            JOptionPane.showMessageDialog(null, "Apenas um ponto por conta");
	        }

	        operacao = constante;
	        textview_output.setText(tela);
	        tela = "0";
	    }

	private void zerar() {
		Calculator.getInstance().c();
        operacao = 0;
        limpar();
        textview_output.setText(String.format("%.2f", Calculator.getInstance().calcular(Constants.NULO, (Float.parseFloat(tela)))));
	}

}