package com.projeto.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projeto.estrutura.util.VariaveisProjeto;
import com.projeto.model.models.Endereco;
import com.projeto.model.service.EnderecoService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class EnderecoGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -887712134785091732L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	JButton btnIncluir;
	JButton btnAlterar;
	JButton btnExcluir;
	JButton btnSair;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnderecoGUI frame = new EnderecoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EnderecoGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(47, 62, 74, 14);
		contentPane.add(lblCodigo);
		
		txtId = new JTextField();
		
		txtId.setBounds(153, 59, 62, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(47, 87, 74, 14);
		contentPane.add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(153, 90, 250, 20);
		contentPane.add(txtRua);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(47, 131, 74, 14);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(153, 128, 364, 20);
		contentPane.add(txtBairro);
		
		JLabel lblNumero = new JLabel("Nº");
		lblNumero.setBounds(426, 93, 23, 14);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(459, 90, 58, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(47, 172, 87, 14);
		contentPane.add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(153, 169, 364, 20);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(126, 225, 89, 23);
		contentPane.add(btnIncluir);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(258, 225, 89, 23);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(385, 225, 89, 23);
		contentPane.add(btnExcluir);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(258, 275, 89, 23);
		contentPane.add(btnSair);
		createEvents();
	}
	
	private void createEvents() {
		txtId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarEndereco();
			}
		});
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluirEndereco();
			}
		});
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarEndereco();
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirEndereco();
			}
		});
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	private Endereco getEndereco() {
		Endereco endereco = new Endereco();
		if(!"".equals(txtId.getText()))
			endereco.setId(Integer.valueOf(txtId.getText()));
		endereco.setRua(txtRua.getText());
		endereco.setNumero(Integer.valueOf(txtNumero.getText()));
		endereco.setBairro(txtBairro.getText());
		if(!"".equals(txtComplemento.getText()))
			endereco.setComplemento(txtComplemento.getText());
		return endereco;
	}
	
	protected void incluirEndereco() {
		Endereco endereco = this.getEndereco();
		EnderecoService enderecoService = new EnderecoService();
		enderecoService.save(endereco);
	}
	
	private void buscarEndereco() {
		Endereco endereco = new Endereco();
		if(VariaveisProjeto.digitacaoCampo(txtId.getText())) {
			txtId.requestFocus();
		} else {
			Integer id = Integer.valueOf(txtId.getText());
			EnderecoService enderecoService = new EnderecoService();
			endereco = enderecoService.findById(id);
			txtRua.setText(endereco.getRua());
			txtNumero.setText(endereco.getNumero().toString());
			txtBairro.setText(endereco.getBairro());
			txtComplemento.setText(endereco.getComplemento());
		}
	}
	
	protected void alterarEndereco() {
		Endereco endereco = this.getEndereco();
		EnderecoService enderecoService = new EnderecoService();
		enderecoService.update(endereco);
	}
	
	protected void excluirEndereco() {
		Endereco endereco = this.getEndereco();
		EnderecoService enderecoService = new EnderecoService();
		enderecoService.delete(endereco);
	}
}
