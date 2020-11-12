package com.projeto.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projeto.estrutura.util.VariaveisProjeto;
import com.projeto.model.models.Usuario;
import com.projeto.model.service.UsuarioService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UsuarioGUI extends JFrame {
	//private static final long serialVersionID = 2;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JRadioButton rdBtnAdmin;
	private JRadioButton rdBtnAtivo;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnSair;
	private JLabel lblCodigo;
	private JTextField txtId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioGUI frame = new UsuarioGUI();
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
	public UsuarioGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(47, 57, 36, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(93, 54, 226, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(93, 85, 226, 20);
		contentPane.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(47, 88, 36, 14);
		contentPane.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(47, 116, 36, 14);
		contentPane.add(lblSenha);
		
		rdBtnAdmin = new JRadioButton("Admin");
		rdBtnAdmin.setBounds(93, 157, 60, 23);
		contentPane.add(rdBtnAdmin);
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(47, 187, 89, 23);
		contentPane.add(btnIncluir);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(146, 187, 89, 23);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(245, 187, 89, 23);
		contentPane.add(btnExcluir);
		
		rdBtnAtivo = new JRadioButton("Ativo");
		rdBtnAtivo.setBounds(175, 157, 60, 23);
		contentPane.add(rdBtnAtivo);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(93, 116, 226, 20);
		contentPane.add(txtSenha);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(146, 228, 89, 23);
		contentPane.add(btnSair);
		
		lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(47, 28, 36, 14);
		contentPane.add(lblCodigo);
		
		txtId = new JTextField();
		txtId.setBounds(93, 25, 43, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		createEvents();
	}
	
	private Usuario pegarDadosUsuario() {
		Usuario usuario = new Usuario();
		if(!"".equals(txtId.getText()))
			usuario.setId(Integer.valueOf(txtId.getText()));
		usuario.setUsername(txtNome.getText());
		usuario.setEmail(txtEmail.getText());
		usuario.setPassword(new String(txtSenha.getPassword()));
		if(rdBtnAdmin.isSelected())
			usuario.setAdmin(true);
		else
			usuario.setAdmin(false);
		if(rdBtnAtivo.isSelected())
			usuario.setAtivo(true);
		else
			usuario.setAtivo(true);
		
		return usuario;
	}
	
	protected void incluirUsuario() {
		Usuario usuario = pegarDadosUsuario();
		UsuarioService usuarioService = new UsuarioService();
		usuarioService.save(usuario);
	}
	
	private void buscarUsuario() {
		Usuario usuario = new Usuario();
		if(VariaveisProjeto.digitacaoCampo(txtId.getText())) {
			txtId.requestFocus();
		} else {
			Integer id = Integer.valueOf(txtId.getText());
			UsuarioService usuarioService = new UsuarioService();
			usuario = usuarioService.findById(id);
			txtNome.setText(usuario.getUsername());
			txtEmail.setText(usuario.getEmail());
			txtSenha.setText(usuario.getPassword());
			rdBtnAdmin.setSelected(usuario.isAdmin());
			rdBtnAtivo.setSelected(usuario.isAtivo());
		}
	}
	
	protected void alterarUsuario() {
		Usuario usuario = pegarDadosUsuario();
		UsuarioService usuarioService = new UsuarioService();
		usuarioService.update(usuario);
	}
	
	private void createEvents() {
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluirUsuario();
			}
		});
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarUsuario();
			}
		});
		txtId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarUsuario();
			}
		});
	}
}
