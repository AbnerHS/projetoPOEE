package com.projeto.view.Usuario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projeto.estrutura.util.VariaveisProjeto;
import com.projeto.model.models.Departamento;
import com.projeto.model.models.Usuario;
import com.projeto.model.service.UsuarioService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class UsuarioGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JRadioButton rdBtnAdmin;
	private JRadioButton rdBtnAtivo;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnSair;
	private JLabel checkNome;
	private JLabel checkEmail;
	private JLabel checkSenha;
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
		setBounds(100, 100, 439, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(47, 57, 61, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				boolean status = verificaDigitacao(txtNome);
				mudaStatusCheck(status, checkNome);
			}
		});
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					boolean status = verificaDigitacao(txtNome);
					mudaStatusCheck(status, checkNome);
					if(status)
						txtEmail.requestFocus();
				}
			}
		});
		txtNome.setBounds(118, 57, 226, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				boolean status = verificaDigitacao(txtEmail);
				mudaStatusCheck(status, checkEmail);
			}
		});
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					boolean status = verificaDigitacao(txtEmail);
					mudaStatusCheck(status, checkEmail);
					if(status)
						txtSenha.requestFocus();
				}
			}
		});
		txtEmail.setColumns(10);
		txtEmail.setBounds(118, 88, 226, 20);
		contentPane.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(47, 88, 61, 14);
		contentPane.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(47, 122, 61, 14);
		contentPane.add(lblSenha);
		
		rdBtnAdmin = new JRadioButton("Admin");
		rdBtnAdmin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					rdBtnAtivo.requestFocus();
			}
		});
		rdBtnAdmin.setBounds(93, 157, 80, 23);
		contentPane.add(rdBtnAdmin);
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/projeto/estrutura/imagens/application_form_add.png")));
		btnIncluir.setBounds(47, 187, 108, 23);
		contentPane.add(btnIncluir);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/projeto/estrutura/imagens/application_form_edit.png")));
		btnAlterar.setBounds(165, 187, 104, 23);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/projeto/estrutura/imagens/application_delete.png")));
		btnExcluir.setBounds(279, 187, 103, 23);
		contentPane.add(btnExcluir);
		
		rdBtnAtivo = new JRadioButton("Ativo");
		rdBtnAtivo.setBounds(190, 157, 60, 23);
		contentPane.add(rdBtnAtivo);
		
		txtSenha = new JPasswordField();
		txtSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				boolean status = verificaDigitacao(txtSenha);
				mudaStatusCheck(status, checkSenha);
			}
		});
		txtSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					boolean status = verificaDigitacao(txtSenha);
					mudaStatusCheck(status, checkSenha);
					if(status)
						rdBtnAdmin.requestFocus();
				}
			}
		});
		txtSenha.setBounds(118, 119, 226, 20);
		contentPane.add(txtSenha);
		
		btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/projeto/estrutura/imagens/sair.png")));
		btnSair.setBounds(146, 228, 89, 23);
		contentPane.add(btnSair);
		
		lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(47, 28, 61, 14);
		contentPane.add(lblCodigo);
		
		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					buscarUsuario();
					txtNome.requestFocus();
			}
		});
		txtId.setBounds(118, 28, 43, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		checkNome = new JLabel("");
		checkNome.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
		checkNome.setBounds(354, 57, 28, 23);
		contentPane.add(checkNome);
		
		checkEmail = new JLabel("");
		checkEmail.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
		checkEmail.setBounds(354, 85, 28, 23);
		contentPane.add(checkEmail);
		
		checkSenha = new JLabel("");
		checkSenha.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
		checkSenha.setBounds(354, 113, 28, 23);
		contentPane.add(checkSenha);
		limpaTextoCampo();
		createEvents();
		desabilitaCheckCampo();
	}
	
	private boolean verificaDigitacao(JTextField txt) {
		if(VariaveisProjeto.digitacaoCampo(txt.getText()))
			return false;
		else
			return true;
	}
	
	private void mudaStatusCheck(boolean status, JLabel check) {
		check.setVisible(true);
		if(status)
			check.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
		else
			check.setIcon(new ImageIcon(UsuarioGUI.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
	}
	
	private void desabilitaCheckCampo() {
		checkNome.setVisible(false);
		checkEmail.setVisible(false);
		checkSenha.setVisible(false);
	}
	
	private Usuario pegarDadosUsuario() {
		Usuario usuario = new Usuario();
		usuario.setId(VariaveisProjeto.convertToInteger(txtId.getText()));
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
		Integer toReturn = 0;
		Departamento departamento = new Departamento();
		departamento.setId(1L);
		Usuario usuario = pegarDadosUsuario();
		usuario.setDepartamento(departamento);
		UsuarioService usuarioService = new UsuarioService();
		toReturn = usuarioService.save(usuario);
		if(toReturn == VariaveisProjeto.NOME_CAMPO_VAZIO) {
			mudaStatusCheck(false, checkNome);
			showMensagem("Erro na digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		if(toReturn == VariaveisProjeto.ERRO_INCLUSAO) {
			showMensagem("Erro na inclusão verifique com seu administrador!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		if(toReturn == VariaveisProjeto.INCLUSAO_REALIZADA) {
			showMensagem("Inclusão do registro realizda com sucesso!", "OK", JOptionPane.OK_OPTION);
			limpaTextoCampo();
			usuario = new Usuario();
		}
	}
	
	private void showMensagem(String mensagem, String status, int option) {
		JOptionPane.showMessageDialog(null, mensagem, status, option);
	}
	
	private void buscarUsuario() {
		Usuario usuario = new Usuario();
		if(VariaveisProjeto.digitacaoCampo(txtId.getText())) {
			txtId.requestFocus();
			return;
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
		Integer toReturn = 0;
		Usuario usuario = pegarDadosUsuario();
		Departamento departamento = new Departamento();
		departamento.setId(1L);
		usuario.setDepartamento(departamento);
		UsuarioService usuarioService = new UsuarioService();
		toReturn = usuarioService.update(usuario);
		if(toReturn == VariaveisProjeto.NOME_CAMPO_VAZIO) {
			mudaStatusCheck(false, checkNome);
			showMensagem("Erro na digitação, verifique!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		if(toReturn == VariaveisProjeto.ERRO_INCLUSAO) {
			showMensagem("Erro na alteração, verifique com seu administrador!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		if(toReturn == VariaveisProjeto.INCLUSAO_REALIZADA) {
			showMensagem("Alteração do registro realizda com sucesso!", "OK", JOptionPane.OK_OPTION);
			limpaTextoCampo();
			usuario = new Usuario();
		}
	}
	
	protected void excluirUsuario() {
		Integer toReturn = 0;
		Usuario usuario = pegarDadosUsuario();
		UsuarioService usuarioService = new UsuarioService();
		toReturn = usuarioService.delete(usuario);
		if(toReturn == VariaveisProjeto.ERRO_INCLUSAO) {
			showMensagem("Erro na exclusão, verifique com seu administrador!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		if(toReturn == VariaveisProjeto.INCLUSAO_REALIZADA) {
			showMensagem("Exclusão do registro realizda com sucesso!", "OK", JOptionPane.OK_OPTION);
			limpaTextoCampo();
			usuario = new Usuario();
		}
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
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});
		txtId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarUsuario();
			}
		});
	}
	
	private void limpaTextoCampo() {
		txtId.setText(VariaveisProjeto.LIMPA_CAMPO);
		txtNome.setText(VariaveisProjeto.LIMPA_CAMPO);
		txtEmail.setText(VariaveisProjeto.LIMPA_CAMPO);
		txtSenha.setText(VariaveisProjeto.LIMPA_CAMPO);
		rdBtnAdmin.setSelected(false);
		rdBtnAtivo.setSelected(false);
	}
}
