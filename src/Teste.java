import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Teste {

	private static BDVeiculos bdVeiculos = new BDVeiculos();

	private static int yAltura = 800;
	private static int xLargura = 600;

	public static void main(String args[]) {

		menuInicialGestaoBoundary();

	}

	private static void menuInicialGestaoBoundary() {
		Color azulClaro = new Color(51, 153, 255);
		JFrame menuInicialBoundary = new JFrame("Gestão de Veiculos");
		JButton buttonPasseio = new JButton("Passeio");
		JButton buttonCargar = new JButton("Cargar");
		menuInicialBoundary.setLayout(null);
		menuInicialBoundary.setSize(yAltura, xLargura);
		menuInicialBoundary.setVisible(true);
		menuInicialBoundary.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		buttonPasseio.setBounds(350, 150, 100, 50);
		buttonCargar.setBounds(350, 225, 100, 50);
		buttonCargar.setBackground(Color.green);
		buttonPasseio.setBackground(azulClaro);
		menuInicialBoundary.add(buttonPasseio);
		menuInicialBoundary.add(buttonCargar);

		buttonPasseio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuInicialBoundary.dispose();
				menuVeiculoPasseioBoundary();
			}
		});

		buttonCargar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuInicialBoundary.dispose();
				menuVeiculoCargaBoundary();
			}
		});
	}

	private static void menuVeiculoCargaBoundary() {
		JButton buttonCadastrar = new JButton("Cadastrar");
		JButton buttonConsulExc = new JButton("Consultar/Excluir pela placa");
		JButton buttonImprExc = new JButton("Imprimir Todos/Excluir todos");
		JButton buttonSair = new JButton("Sair");

		JFrame menuCargaBoundary = new JFrame("Veiculos de Carga");
		menuCargaBoundary.setLayout(null);
		menuCargaBoundary.setSize(yAltura, xLargura);
		menuCargaBoundary.setVisible(true);
		menuCargaBoundary.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		buttonCadastrar.setBackground(Color.green);
		buttonCadastrar.setBounds(300, 150, 200, 50);
		buttonConsulExc.setBackground(Color.green);
		buttonConsulExc.setBounds(300, 225, 200, 50);
		buttonImprExc.setBackground(Color.green);
		buttonImprExc.setBounds(300, 300, 200, 50);
		buttonSair.setBackground(Color.red);
		buttonSair.setBounds(300, 375, 200, 50);

		menuCargaBoundary.add(buttonCadastrar);
		menuCargaBoundary.add(buttonConsulExc);
		menuCargaBoundary.add(buttonImprExc);
		menuCargaBoundary.add(buttonSair);

		buttonCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuCargaBoundary.dispose();
				cadastrarCargaBoundary();
			}
		});

		buttonConsulExc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuCargaBoundary.dispose();
				consultExclCargaBoundary();

			}
		});

		buttonImprExc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuCargaBoundary.dispose();
				imprimirExcluirCargaBoundary();
			}
		});

		buttonSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuCargaBoundary.dispose();
				menuInicialGestaoBoundary();
			}
		});
	}

	protected static void imprimirExcluirCargaBoundary() {
		JButton buttonImprimir = new JButton("Imprimir todos");
		JButton buttonExcluir = new JButton("Excluir todos");
		JButton buttonSair = new JButton("Sair");

		JFrame imprimirExclCargaBoundary = new JFrame("Imprimir / Excluir todos - Veiculos Carga");
		imprimirExclCargaBoundary.setLayout(null);
		imprimirExclCargaBoundary.setSize(yAltura, xLargura);
		imprimirExclCargaBoundary.setVisible(true);
		imprimirExclCargaBoundary.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		String columnNames[] = { "Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Veloc. Max.", "Qtd. Pist",
				"Pôtencia", "Tara", "Carga Max." };

		Object[][] dados = new Object[bdVeiculos.getListaCarga().size()][10];

		JTable tabela = new JTable(dados, columnNames);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 40, 720, 400);
		scrollPane.setViewportView(tabela);

		imprimirExclCargaBoundary.add(scrollPane);

		JLabel inferior = new JLabel();
		inferior.setLayout(new GridLayout(1, 4, 20, 0));
		inferior.setBounds(30, 480, 500, 19);

		inferior.add(buttonImprimir);
		inferior.add(buttonExcluir);
		inferior.add(buttonSair);

		imprimirExclCargaBoundary.add(inferior);

		buttonImprimir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				imprimirTodosCargaTabela(imprimirExclCargaBoundary, columnNames, dados);
			}
		});

		buttonExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bdVeiculos.getListaCarga().clear();
				JOptionPane.showMessageDialog(null, "Todos veiculos de carga foram excluidos",
						"Operação realizada com sucesso", JOptionPane.INFORMATION_MESSAGE);
				imprimirExclCargaBoundary.dispose();
				imprimirExcluirCargaBoundary();

			}
		});

		buttonSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				imprimirExclCargaBoundary.dispose();
				menuVeiculoCargaBoundary();
			}
		});
	}

	protected static void consultExclCargaBoundary() {
		JButton buttonConsultar = new JButton("Consultar");
		JButton buttonExcluir = new JButton("Excluir");
		JButton buttonSair = new JButton("Sair");

		JFrame consultarExcluirCargaBoundary = new JFrame("Consultar/Excluir pela placa - Veiculo de Carga");
		consultarExcluirCargaBoundary.setLayout(null);
		consultarExcluirCargaBoundary.setSize(yAltura, xLargura);
		consultarExcluirCargaBoundary.setVisible(true);
		consultarExcluirCargaBoundary.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JLabel lblPlaca = new JLabel("Informe a placa:");
		lblPlaca.setForeground(Color.red);
		lblPlaca.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPlaca.setBounds(30, 40, 150, 20);
		consultarExcluirCargaBoundary.add(lblPlaca);

		JTextField txtPlaca = new JTextField();
		txtPlaca.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtPlaca.setBounds(180, 40, 146, 19);
		consultarExcluirCargaBoundary.add(txtPlaca);

		JLabel lblTara = new JLabel("Tara:");
		lblTara.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblTara.setBounds(30, 70, 150, 20);
		consultarExcluirCargaBoundary.add(lblTara);

		JTextField txtTara = new JTextField();
		txtTara.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtTara.setBounds(180, 70, 146, 19);
		consultarExcluirCargaBoundary.add(txtTara);

		JLabel lblCargaMax = new JLabel("Carga Max.:");
		lblCargaMax.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCargaMax.setBounds(30, 100, 150, 20);
		consultarExcluirCargaBoundary.add(lblCargaMax);

		JTextField txtCargaMax = new JTextField();
		txtCargaMax.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtCargaMax.setBounds(180, 100, 146, 19);
		consultarExcluirCargaBoundary.add(txtCargaMax);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblMarca.setBounds(30, 130, 150, 20);
		consultarExcluirCargaBoundary.add(lblMarca);

		JTextField txtMarca = new JTextField();
		txtMarca.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtMarca.setBounds(180, 130, 146, 19);
		consultarExcluirCargaBoundary.add(txtMarca);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblModelo.setBounds(30, 160, 150, 20);
		consultarExcluirCargaBoundary.add(lblModelo);

		JTextField txtModelo = new JTextField();
		txtModelo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtModelo.setBounds(180, 160, 146, 19);
		consultarExcluirCargaBoundary.add(txtModelo);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCor.setBounds(30, 190, 150, 20);
		consultarExcluirCargaBoundary.add(lblCor);

		JTextField txtCor = new JTextField();
		txtCor.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtCor.setBounds(180, 190, 146, 19);
		consultarExcluirCargaBoundary.add(txtCor);

		JLabel lblQtdRodas = new JLabel("Qtd. Rodas:");
		lblQtdRodas.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblQtdRodas.setBounds(30, 220, 150, 20);
		consultarExcluirCargaBoundary.add(lblQtdRodas);

		JTextField txtQtdRodas = new JTextField();
		txtQtdRodas.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtQtdRodas.setBounds(180, 220, 146, 19);
		consultarExcluirCargaBoundary.add(txtQtdRodas);

		JLabel lblVelocidadeMax = new JLabel("Velocidade Max:");
		lblVelocidadeMax.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblVelocidadeMax.setBounds(30, 250, 150, 20);
		consultarExcluirCargaBoundary.add(lblVelocidadeMax);

		JTextField txtVelocidadeMax = new JTextField();
		txtVelocidadeMax.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtVelocidadeMax.setBounds(180, 250, 146, 19);
		consultarExcluirCargaBoundary.add(txtVelocidadeMax);

		JLabel lblQtdPistoes = new JLabel("Qtd. Pistoes:");
		lblQtdPistoes.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblQtdPistoes.setBounds(30, 280, 150, 20);
		consultarExcluirCargaBoundary.add(lblQtdPistoes);

		JTextField txtQtdPistoes = new JTextField();
		txtQtdPistoes.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtQtdPistoes.setBounds(180, 280, 146, 19);
		consultarExcluirCargaBoundary.add(txtQtdPistoes);

		JLabel lblPotencia = new JLabel("Potencia:");
		lblPotencia.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPotencia.setBounds(30, 310, 150, 20);
		consultarExcluirCargaBoundary.add(lblPotencia);

		JTextField txtPotencia = new JTextField();
		txtPotencia.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtPotencia.setBounds(180, 310, 146, 19);
		consultarExcluirCargaBoundary.add(txtPotencia);

		JLabel inferior = new JLabel();
		inferior.setLayout(new GridLayout(1, 4, 20, 0));
		inferior.setBounds(30, 480, 500, 19);

		inferior.add(buttonConsultar);
		inferior.add(buttonExcluir);
		inferior.add(buttonSair);

		consultarExcluirCargaBoundary.add(inferior);

		txtCargaMax.setEditable(false);
		txtTara.setEditable(false);
		txtCor.setEditable(false);
		txtMarca.setEditable(false);
		txtModelo.setEditable(false);
		txtPotencia.setEditable(false);
		txtQtdPistoes.setEditable(false);
		txtQtdRodas.setEditable(false);
		txtVelocidadeMax.setEditable(false);

		buttonConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = existeVeiculoCargoPorPlaca(txtPlaca.getText());
				if (index != -1) {
					colocarCamposConsulExcluirCarga(txtTara, txtCargaMax, txtMarca, txtModelo, txtCor, txtQtdRodas,
							txtVelocidadeMax, txtQtdPistoes, txtPotencia, index);
				}

			}
		});

		buttonExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = existeVeiculoCargoPorPlaca(txtPlaca.getText());

				if (index != -1) {
					bdVeiculos.getListaCarga().remove(index);
					JOptionPane.showMessageDialog(null,
							"Veiculo de Carga com placa: " + txtPlaca.getText() + " foi excluido.",
							"Excluido com sucesso", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		buttonSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				consultarExcluirCargaBoundary.dispose();
				menuVeiculoCargaBoundary();
			}
		});
	}

	private static void cadastrarCargaBoundary() {
		JButton buttonCadastrar = new JButton("Cadastrar");
		JButton buttonLimpar = new JButton("Limpar");
		JButton buttonNovo = new JButton("Novo");
		JButton buttonSair = new JButton("Sair");

		JFrame cadCargaBoundary = new JFrame("Cadastro de Carga");
		cadCargaBoundary.setLayout(null);
		cadCargaBoundary.setSize(yAltura, xLargura);
		cadCargaBoundary.setVisible(true);
		cadCargaBoundary.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JLabel lblTara = new JLabel("Tara:");
		lblTara.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblTara.setBounds(30, 40, 150, 20);
		cadCargaBoundary.add(lblTara);

		JTextField txtTara = new JTextField();
		txtTara.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtTara.setBounds(180, 40, 146, 19);
		cadCargaBoundary.add(txtTara);

		JLabel lblCargaMax = new JLabel("Carga Max.:");
		lblCargaMax.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCargaMax.setBounds(30, 70, 150, 20);
		cadCargaBoundary.add(lblCargaMax);

		JTextField txtCargaMax = new JTextField();
		txtCargaMax.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtCargaMax.setBounds(180, 70, 146, 19);
		cadCargaBoundary.add(txtCargaMax);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPlaca.setBounds(30, 100, 150, 20);
		cadCargaBoundary.add(lblPlaca);

		JTextField txtPlaca = new JTextField();
		txtPlaca.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtPlaca.setBounds(180, 100, 146, 19);
		cadCargaBoundary.add(txtPlaca);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblMarca.setBounds(30, 130, 150, 20);
		cadCargaBoundary.add(lblMarca);

		JTextField txtMarca = new JTextField();
		txtMarca.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtMarca.setBounds(180, 130, 146, 19);
		cadCargaBoundary.add(txtMarca);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblModelo.setBounds(30, 160, 150, 20);
		cadCargaBoundary.add(lblModelo);

		JTextField txtModelo = new JTextField();
		txtModelo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtModelo.setBounds(180, 160, 146, 19);
		cadCargaBoundary.add(txtModelo);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCor.setBounds(30, 190, 150, 20);
		cadCargaBoundary.add(lblCor);

		JTextField txtCor = new JTextField();
		txtCor.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtCor.setBounds(180, 190, 146, 19);
		cadCargaBoundary.add(txtCor);

		JLabel lblQtdRodas = new JLabel("Qtd. Rodas:");
		lblQtdRodas.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblQtdRodas.setBounds(30, 220, 150, 20);
		cadCargaBoundary.add(lblQtdRodas);

		JTextField txtQtdRodas = new JTextField();
		txtQtdRodas.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtQtdRodas.setBounds(180, 220, 146, 19);
		cadCargaBoundary.add(txtQtdRodas);

		JLabel lblVelocidadeMax = new JLabel("Velocidade Max:");
		lblVelocidadeMax.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblVelocidadeMax.setBounds(30, 250, 150, 20);
		cadCargaBoundary.add(lblVelocidadeMax);

		JTextField txtVelocidadeMax = new JTextField();
		txtVelocidadeMax.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtVelocidadeMax.setBounds(180, 250, 146, 19);
		cadCargaBoundary.add(txtVelocidadeMax);

		JLabel lblQtdPistoes = new JLabel("Qtd. Pistoes:");
		lblQtdPistoes.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblQtdPistoes.setBounds(30, 280, 150, 20);
		cadCargaBoundary.add(lblQtdPistoes);

		JTextField txtQtdPistoes = new JTextField();
		txtQtdPistoes.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtQtdPistoes.setBounds(180, 280, 146, 19);
		cadCargaBoundary.add(txtQtdPistoes);

		JLabel lblPotencia = new JLabel("Potencia:");
		lblPotencia.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPotencia.setBounds(30, 310, 150, 20);
		cadCargaBoundary.add(lblPotencia);

		JTextField txtPotencia = new JTextField();
		txtPotencia.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtPotencia.setBounds(180, 310, 146, 19);
		cadCargaBoundary.add(txtPotencia);

		JLabel inferior = new JLabel();
		inferior.setLayout(new GridLayout(1, 4, 20, 0));
		inferior.setBounds(30, 480, 500, 19);

		inferior.add(buttonCadastrar);
		inferior.add(buttonLimpar);
		inferior.add(buttonNovo);
		inferior.add(buttonSair);

		cadCargaBoundary.add(inferior);

		buttonCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean avancar = true;
				Carga carga = new Carga();

				try {
					carga.setCor(txtCor.getText());
					carga.setMarca(txtMarca.getText());
					carga.setModelo(txtModelo.getText());
					carga.setPlaca(txtPlaca.getText());
					carga.setQtdRodas(Integer.parseInt(txtQtdRodas.getText()));
					carga.setVelocMax(Float.parseFloat(txtVelocidadeMax.getText()));
					carga.getMotor().setPotencia(Integer.parseInt(txtPotencia.getText()));
					carga.getMotor().setQtdPist(Integer.parseInt(txtQtdPistoes.getText()));
					carga.setCargaMax(Integer.parseInt(txtCargaMax.getText()));
					carga.setTara(Integer.parseInt(txtTara.getText()));
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null,
							"Informe apenas numeros inteiros nos campos exigidos: " + nfe.getMessage(),
							" Formato errado numerico", JOptionPane.ERROR_MESSAGE);
					avancar = false;
				}

				try {
					verificaVelocidadeMax(carga.getVelocMax());
				} catch (VelocException e1) {
					carga.setVelocMax(90);
				}

				try {
					verificaPlacaCarga(carga);
				} catch (VeicExistException e2) {
					avancar = false;
				}

				if (avancar) {
					bdVeiculos.getListaCarga().add(carga);
					JOptionPane.showMessageDialog(null, "Veiculo de Carga armazenado!",
							"Cadastro Realizado com sucesso", JOptionPane.INFORMATION_MESSAGE);

					txtCor.setEditable(false);
					txtMarca.setEditable(false);
					txtModelo.setEditable(false);
					txtPlaca.setEditable(false);
					txtPotencia.setEditable(false);
					txtCargaMax.setEditable(false);
					txtQtdPistoes.setEditable(false);
					txtQtdRodas.setEditable(false);
					txtVelocidadeMax.setEditable(false);
					txtTara.setEditable(false);
				}

			}
		});

		buttonLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limparCamposCadCarga(txtTara, txtCargaMax, txtPlaca, txtMarca, txtModelo, txtCor, txtQtdRodas,
						txtVelocidadeMax, txtQtdPistoes, txtPotencia);
			}
		});

		buttonNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limparCamposCadCarga(txtTara, txtCargaMax, txtPlaca, txtMarca, txtModelo, txtCor, txtQtdRodas,
						txtVelocidadeMax, txtQtdPistoes, txtPotencia);
				txtCor.setEditable(true);
				txtMarca.setEditable(true);
				txtModelo.setEditable(true);
				txtPlaca.setEditable(true);
				txtPotencia.setEditable(true);
				txtCargaMax.setEditable(true);
				txtQtdPistoes.setEditable(true);
				txtQtdRodas.setEditable(true);
				txtVelocidadeMax.setEditable(true);
				txtTara.setEditable(true);
			}
		});

		buttonSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cadCargaBoundary.dispose();
				menuVeiculoCargaBoundary();
			}
		});

	}

	private static void menuVeiculoPasseioBoundary() {
		JButton buttonCadastrar = new JButton("Cadastrar");
		JButton buttonConsulExc = new JButton("Consultar/Excluir pela placa");
		JButton buttonImprExc = new JButton("Imprimir Todos/Excluir todos");
		JButton buttonSair = new JButton("Sair");

		JFrame menuPasseioBoundary = new JFrame("Veiculos de Passeio");
		menuPasseioBoundary.setLayout(null);
		menuPasseioBoundary.setSize(yAltura, xLargura);
		menuPasseioBoundary.setVisible(true);
		menuPasseioBoundary.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Color azulClaro = new Color(51, 153, 255);

		buttonCadastrar.setBackground(azulClaro);
		buttonCadastrar.setBounds(300, 150, 200, 50);
		buttonConsulExc.setBackground(azulClaro);
		buttonConsulExc.setBounds(300, 225, 200, 50);
		buttonImprExc.setBackground(azulClaro);
		buttonImprExc.setBounds(300, 300, 200, 50);
		buttonSair.setBackground(Color.red);
		buttonSair.setBounds(300, 375, 200, 50);

		menuPasseioBoundary.add(buttonCadastrar);
		menuPasseioBoundary.add(buttonConsulExc);
		menuPasseioBoundary.add(buttonImprExc);
		menuPasseioBoundary.add(buttonSair);

		buttonCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuPasseioBoundary.dispose();
				cadastrarPasseioBoundary();
			}
		});

		buttonConsulExc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuPasseioBoundary.dispose();
				consultExclPasseioBoundary();
			}
		});

		buttonImprExc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuPasseioBoundary.dispose();
				imprimirExcluirPasseioBoundary();
			}
		});

		buttonSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuPasseioBoundary.dispose();
				menuInicialGestaoBoundary();
			}
		});
	}

	private static void imprimirExcluirPasseioBoundary() {
		JButton buttonImprimir = new JButton("Imprimir todos");
		JButton buttonExcluir = new JButton("Excluir todos");
		JButton buttonSair = new JButton("Sair");

		JFrame imprimirExclPasseioBoundary = new JFrame("Imprimir / Excluir todos - Veiculos Passeio");
		imprimirExclPasseioBoundary.setLayout(null);
		imprimirExclPasseioBoundary.setSize(yAltura, xLargura);
		imprimirExclPasseioBoundary.setVisible(true);
		imprimirExclPasseioBoundary.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		String columnNames[] = { "Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Veloc. Max.", "Qtd. Pist",
				"Pôtencia", "Qtd. Passageiros" };

		Object[][] dados = new Object[bdVeiculos.getListaPasseio().size()][9];

		JTable tabela = new JTable(dados, columnNames);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 40, 720, 400);
		scrollPane.setViewportView(tabela);

		imprimirExclPasseioBoundary.add(scrollPane);

		JLabel inferior = new JLabel();
		inferior.setLayout(new GridLayout(1, 4, 20, 0));
		inferior.setBounds(30, 480, 500, 19);

		inferior.add(buttonImprimir);
		inferior.add(buttonExcluir);
		inferior.add(buttonSair);

		imprimirExclPasseioBoundary.add(inferior);

		buttonImprimir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				imprimirTodosPasseiosTabela(imprimirExclPasseioBoundary, columnNames, dados);
			}
		});

		buttonExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bdVeiculos.getListaPasseio().clear();
				JOptionPane.showMessageDialog(null, "Todos veiculos de passeio foram excluidos",
						"Operação realizada com sucesso", JOptionPane.INFORMATION_MESSAGE);
				imprimirExclPasseioBoundary.dispose();
				imprimirExcluirPasseioBoundary();
			}
		});

		buttonSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				imprimirExclPasseioBoundary.dispose();
				menuVeiculoPasseioBoundary();

			}
		});

	}

	protected static void consultExclPasseioBoundary() {
		JButton buttonConsultar = new JButton("Consultar");
		JButton buttonExcluir = new JButton("Excluir");
		JButton buttonSair = new JButton("Sair");

		JFrame consultarExcluirPasseioBoundary = new JFrame("Consultar/Excluir pela placa - Veiculo Passeio");
		consultarExcluirPasseioBoundary.setLayout(null);
		consultarExcluirPasseioBoundary.setSize(yAltura, xLargura);
		consultarExcluirPasseioBoundary.setVisible(true);
		consultarExcluirPasseioBoundary.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JLabel lblPlaca = new JLabel("Informe a placa:");
		lblPlaca.setForeground(Color.red);
		lblPlaca.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPlaca.setBounds(30, 40, 150, 20);
		consultarExcluirPasseioBoundary.add(lblPlaca);

		JTextField txtPlaca = new JTextField();
		txtPlaca.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtPlaca.setBounds(180, 40, 146, 19);
		consultarExcluirPasseioBoundary.add(txtPlaca);

		JLabel lblQtdPassageiros = new JLabel("Qtd. Passageiros:");
		lblQtdPassageiros.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblQtdPassageiros.setBounds(30, 70, 150, 20);
		consultarExcluirPasseioBoundary.add(lblQtdPassageiros);

		JTextField txtQtdPassageiros = new JTextField();
		txtQtdPassageiros.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtQtdPassageiros.setBounds(180, 70, 146, 19);
		consultarExcluirPasseioBoundary.add(txtQtdPassageiros);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblMarca.setBounds(30, 100, 150, 20);
		consultarExcluirPasseioBoundary.add(lblMarca);

		JTextField txtMarca = new JTextField();
		txtMarca.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtMarca.setBounds(180, 100, 146, 19);
		consultarExcluirPasseioBoundary.add(txtMarca);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblModelo.setBounds(30, 130, 150, 20);
		consultarExcluirPasseioBoundary.add(lblModelo);

		JTextField txtModelo = new JTextField();
		txtModelo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtModelo.setBounds(180, 130, 146, 19);
		consultarExcluirPasseioBoundary.add(txtModelo);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCor.setBounds(30, 160, 150, 20);
		consultarExcluirPasseioBoundary.add(lblCor);

		JTextField txtCor = new JTextField();
		txtCor.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtCor.setBounds(180, 160, 146, 19);
		consultarExcluirPasseioBoundary.add(txtCor);

		JLabel lblQtdRodas = new JLabel("Qtd. Rodas:");
		lblQtdRodas.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblQtdRodas.setBounds(30, 190, 150, 20);
		consultarExcluirPasseioBoundary.add(lblQtdRodas);

		JTextField txtQtdRodas = new JTextField();
		txtQtdRodas.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtQtdRodas.setBounds(180, 190, 146, 19);
		consultarExcluirPasseioBoundary.add(txtQtdRodas);

		JLabel lblVelocidadeMax = new JLabel("Velocidade Max:");
		lblVelocidadeMax.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblVelocidadeMax.setBounds(30, 220, 150, 20);
		consultarExcluirPasseioBoundary.add(lblVelocidadeMax);

		JTextField txtVelocidadeMax = new JTextField();
		txtVelocidadeMax.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtVelocidadeMax.setBounds(180, 220, 146, 19);
		consultarExcluirPasseioBoundary.add(txtVelocidadeMax);

		JLabel lblQtdPistoes = new JLabel("Qtd. Pistoes:");
		lblQtdPistoes.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblQtdPistoes.setBounds(30, 250, 150, 20);
		consultarExcluirPasseioBoundary.add(lblQtdPistoes);

		JTextField txtQtdPistoes = new JTextField();
		txtQtdPistoes.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtQtdPistoes.setBounds(180, 250, 146, 19);
		consultarExcluirPasseioBoundary.add(txtQtdPistoes);

		JLabel lblPotencia = new JLabel("Potencia:");
		lblPotencia.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPotencia.setBounds(30, 280, 150, 20);
		consultarExcluirPasseioBoundary.add(lblPotencia);

		JTextField txtPotencia = new JTextField();
		txtPotencia.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtPotencia.setBounds(180, 280, 146, 19);
		consultarExcluirPasseioBoundary.add(txtPotencia);

		JLabel inferior = new JLabel();
		inferior.setLayout(new GridLayout(1, 4, 20, 0));
		inferior.setBounds(30, 480, 500, 19);

		inferior.add(buttonConsultar);
		inferior.add(buttonExcluir);
		inferior.add(buttonSair);

		consultarExcluirPasseioBoundary.add(inferior);

		txtCor.setEditable(false);
		txtMarca.setEditable(false);
		txtModelo.setEditable(false);
		txtPotencia.setEditable(false);
		txtQtdPassageiros.setEditable(false);
		txtQtdPistoes.setEditable(false);
		txtQtdRodas.setEditable(false);
		txtVelocidadeMax.setEditable(false);

		buttonConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = 0;
				index = existeVeiculoPasseioPorPlaca(txtPlaca.getText());
				if (index != -1) {
					colocarCamposConsulExcluirPasseio(txtQtdPassageiros, txtMarca, txtModelo, txtCor, txtQtdRodas,
							txtVelocidadeMax, txtQtdPistoes, txtPotencia, index);
				}
			}
		});

		buttonExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = 0;
				index = existeVeiculoPasseioPorPlaca(txtPlaca.getText());

				if (index != -1) {
					colocarCamposConsulExcluirPasseio(txtQtdPassageiros, txtMarca, txtModelo, txtCor, txtQtdRodas,
							txtVelocidadeMax, txtQtdPistoes, txtPotencia, index);
					bdVeiculos.getListaPasseio().remove(index);
					JOptionPane.showMessageDialog(null,
							"Veiculo de Passeio com placa: " + txtPlaca.getText() + " foi excluido.",
							"Excluido com sucesso", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		buttonSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				consultarExcluirPasseioBoundary.dispose();
				menuVeiculoPasseioBoundary();
			}
		});

	}

	private static void cadastrarPasseioBoundary() {

		JButton buttonCadastrar = new JButton("Cadastrar");
		JButton buttonLimpar = new JButton("Limpar");
		JButton buttonNovo = new JButton("Novo");
		JButton buttonSair = new JButton("Sair");

		JFrame cadPasseioBoundary = new JFrame("Cadastro de Passeio");
		cadPasseioBoundary.setLayout(null);
		cadPasseioBoundary.setSize(yAltura, xLargura);
		cadPasseioBoundary.setVisible(true);
		cadPasseioBoundary.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JLabel lblQtdPassageiros = new JLabel("Qtd. Passageiros:");
		lblQtdPassageiros.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblQtdPassageiros.setBounds(30, 40, 150, 20);
		cadPasseioBoundary.add(lblQtdPassageiros);

		JTextField txtQtdPassageiros = new JTextField();
		txtQtdPassageiros.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtQtdPassageiros.setBounds(180, 40, 146, 19);
		cadPasseioBoundary.add(txtQtdPassageiros);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPlaca.setBounds(30, 70, 150, 20);
		cadPasseioBoundary.add(lblPlaca);

		JTextField txtPlaca = new JTextField();
		txtPlaca.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtPlaca.setBounds(180, 70, 146, 19);
		cadPasseioBoundary.add(txtPlaca);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblMarca.setBounds(30, 100, 150, 20);
		cadPasseioBoundary.add(lblMarca);

		JTextField txtMarca = new JTextField();
		txtMarca.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtMarca.setBounds(180, 100, 146, 19);
		cadPasseioBoundary.add(txtMarca);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblModelo.setBounds(30, 130, 150, 20);
		cadPasseioBoundary.add(lblModelo);

		JTextField txtModelo = new JTextField();
		txtModelo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtModelo.setBounds(180, 130, 146, 19);
		cadPasseioBoundary.add(txtModelo);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCor.setBounds(30, 160, 150, 20);
		cadPasseioBoundary.add(lblCor);

		JTextField txtCor = new JTextField();
		txtCor.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtCor.setBounds(180, 160, 146, 19);
		cadPasseioBoundary.add(txtCor);

		JLabel lblQtdRodas = new JLabel("Qtd. Rodas:");
		lblQtdRodas.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblQtdRodas.setBounds(30, 190, 150, 20);
		cadPasseioBoundary.add(lblQtdRodas);

		JTextField txtQtdRodas = new JTextField();
		txtQtdRodas.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtQtdRodas.setBounds(180, 190, 146, 19);
		cadPasseioBoundary.add(txtQtdRodas);

		JLabel lblVelocidadeMax = new JLabel("Velocidade Max:");
		lblVelocidadeMax.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblVelocidadeMax.setBounds(30, 220, 150, 20);
		cadPasseioBoundary.add(lblVelocidadeMax);

		JTextField txtVelocidadeMax = new JTextField();
		txtVelocidadeMax.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtVelocidadeMax.setBounds(180, 220, 146, 19);
		cadPasseioBoundary.add(txtVelocidadeMax);

		JLabel lblQtdPistoes = new JLabel("Qtd. Pistoes:");
		lblQtdPistoes.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblQtdPistoes.setBounds(30, 250, 150, 20);
		cadPasseioBoundary.add(lblQtdPistoes);

		JTextField txtQtdPistoes = new JTextField();
		txtQtdPistoes.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtQtdPistoes.setBounds(180, 250, 146, 19);
		cadPasseioBoundary.add(txtQtdPistoes);

		JLabel lblPotencia = new JLabel("Potencia:");
		lblPotencia.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPotencia.setBounds(30, 280, 150, 20);
		cadPasseioBoundary.add(lblPotencia);

		JTextField txtPotencia = new JTextField();
		txtPotencia.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtPotencia.setBounds(180, 280, 146, 19);
		cadPasseioBoundary.add(txtPotencia);

		JLabel inferior = new JLabel();
		inferior.setLayout(new GridLayout(1, 4, 20, 0));
		inferior.setBounds(30, 480, 500, 19);

		inferior.add(buttonCadastrar);
		inferior.add(buttonLimpar);
		inferior.add(buttonNovo);
		inferior.add(buttonSair);

		cadPasseioBoundary.add(inferior);

		buttonCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean avancar = true;
				Passeio passeio = new Passeio();

				try {
					passeio.setCor(txtCor.getText());
					passeio.setMarca(txtMarca.getText());
					passeio.setModelo(txtModelo.getText());
					passeio.setPlaca(txtPlaca.getText());
					passeio.setQtdRodas(Integer.parseInt(txtQtdRodas.getText()));
					passeio.setVelocMax(Float.parseFloat(txtVelocidadeMax.getText()));
					passeio.getMotor().setPotencia(Integer.parseInt(txtPotencia.getText()));
					passeio.getMotor().setQtdPist(Integer.parseInt(txtQtdPistoes.getText()));
					passeio.setQtdPassageiros(Integer.parseInt(txtQtdPassageiros.getText()));
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null,
							"Informe apenas numeros inteiros nos campos exigidos: " + nfe.getMessage(),
							" Formato errado numerico", JOptionPane.ERROR_MESSAGE);
					avancar = false;
				}

				try {
					verificaVelocidadeMax(passeio.getVelocMax());
				} catch (VelocException e1) {
					passeio.setVelocMax(100);
				}

				try {
					verificaPlacaPasseio(passeio);
				} catch (VeicExistException e2) {
					avancar = false;
				}

				if (avancar) {
					bdVeiculos.getListaPasseio().add(passeio);
					JOptionPane.showMessageDialog(null, "Veiculo de Passeio armazenado!",
							"Cadastro Realizado com sucesso", JOptionPane.INFORMATION_MESSAGE);

					txtCor.setEditable(false);
					txtMarca.setEditable(false);
					txtModelo.setEditable(false);
					txtPlaca.setEditable(false);
					txtPotencia.setEditable(false);
					txtQtdPassageiros.setEditable(false);
					txtQtdPistoes.setEditable(false);
					txtQtdRodas.setEditable(false);
					txtVelocidadeMax.setEditable(false);
				}
			}
		});

		buttonLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limparCamposCadPasseio(txtQtdPassageiros, txtPlaca, txtMarca, txtModelo, txtCor, txtQtdRodas,
						txtVelocidadeMax, txtQtdPistoes, txtPotencia);
			}
		});

		buttonNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtCor.setEditable(true);
				txtMarca.setEditable(true);
				txtModelo.setEditable(true);
				txtPlaca.setEditable(true);
				txtPotencia.setEditable(true);
				txtQtdPassageiros.setEditable(true);
				txtQtdPistoes.setEditable(true);
				txtQtdRodas.setEditable(true);
				txtVelocidadeMax.setEditable(true);

				limparCamposCadPasseio(txtQtdPassageiros, txtPlaca, txtMarca, txtModelo, txtCor, txtQtdRodas,
						txtVelocidadeMax, txtQtdPistoes, txtPotencia);
			}
		});

		buttonSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cadPasseioBoundary.dispose();
				menuVeiculoPasseioBoundary();
			}
		});

	}

	private static void verificaVelocidadeMax(float velocMax) throws VelocException {

		if (velocMax < 80 || velocMax > 110) {
			throw new VelocException();
		}

	}

	public static void verificaPlacaPasseio(Passeio passeio) throws VeicExistException {
		for (int i = 0; i < bdVeiculos.getListaPasseio().size(); i++) {
			if (bdVeiculos.getListaPasseio().get(i).getPlaca().equalsIgnoreCase(passeio.getPlaca())) {
				throw new VeicExistException();
			}
		}
	}

	public static void verificaPlacaCarga(Carga carga) throws VeicExistException {

		for (int i = 0; i < bdVeiculos.getListaCarga().size(); i++) {
			if (bdVeiculos.getListaCarga().get(i).getPlaca().equalsIgnoreCase(carga.getPlaca())) {
				throw new VeicExistException();
			}
		}
	}

	public static int existeVeiculoPasseioPorPlaca(String placa) {

		for (int i = 0; i < bdVeiculos.getListaPasseio().size(); i++) {
			if (bdVeiculos.getListaPasseio().get(i).getPlaca().equalsIgnoreCase(placa)) {
				return i;
			}
		}

		JOptionPane.showMessageDialog(null, "NAO exise veiculo de PASSEIO com esta placa: " + placa, "Placa invalida",
				JOptionPane.ERROR_MESSAGE);

		return -1;
	}

	public static int existeVeiculoCargoPorPlaca(String placa) {

		for (int i = 0; i < bdVeiculos.getListaCarga().size(); i++) {
			if (bdVeiculos.getListaCarga().get(i).getPlaca().equalsIgnoreCase(placa)) {
				return i;
			}
		}

		JOptionPane.showMessageDialog(null, "NAO exise veiculo de Carga com esta placa: " + placa, "Placa invalida",
				JOptionPane.ERROR_MESSAGE);

		return -1;
	}

	private static void limparCamposCadPasseio(JTextField txtQtdPassageiros, JTextField txtPlaca, JTextField txtMarca,
			JTextField txtModelo, JTextField txtCor, JTextField txtQtdRodas, JTextField txtVelocidadeMax,
			JTextField txtQtdPistoes, JTextField txtPotencia) {
		txtCor.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtPlaca.setText("");
		txtPotencia.setText("");
		txtQtdPassageiros.setText("");
		txtQtdPistoes.setText("");
		txtQtdRodas.setText("");
		txtVelocidadeMax.setText("");
	}

	private static void limparCamposCadCarga(JTextField txtTara, JTextField txtCargaMax, JTextField txtPlaca,
			JTextField txtMarca, JTextField txtModelo, JTextField txtCor, JTextField txtQtdRodas,
			JTextField txtVelocidadeMax, JTextField txtQtdPistoes, JTextField txtPotencia) {
		txtCor.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtPlaca.setText("");
		txtPotencia.setText("");
		txtCargaMax.setText("");
		txtTara.setText("");
		txtQtdPistoes.setText("");
		txtQtdRodas.setText("");
		txtVelocidadeMax.setText("");
	}

	private static void colocarCamposConsulExcluirPasseio(JTextField txtQtdPassageiros, JTextField txtMarca,
			JTextField txtModelo, JTextField txtCor, JTextField txtQtdRodas, JTextField txtVelocidadeMax,
			JTextField txtQtdPistoes, JTextField txtPotencia, int index) {
		Passeio passeio = bdVeiculos.getListaPasseio().get(index);
		txtQtdPassageiros.setText(Integer.toString(passeio.getQtdPassageiros()));
		txtMarca.setText(passeio.getMarca());
		txtModelo.setText(passeio.getModelo());
		txtCor.setText(passeio.getCor());
		txtQtdRodas.setText(Integer.toString(passeio.getQtdRodas()));
		txtVelocidadeMax.setText(Float.toString(passeio.getVelocMax()));
		txtQtdPistoes.setText(Integer.toString(passeio.getMotor().getQtdPist()));
		txtPotencia.setText(Integer.toString(passeio.getMotor().getPotencia()));
	}

	private static void colocarCamposConsulExcluirCarga(JTextField txtTara, JTextField txtCargaMax, JTextField txtMarca,
			JTextField txtModelo, JTextField txtCor, JTextField txtQtdRodas, JTextField txtVelocidadeMax,
			JTextField txtQtdPistoes, JTextField txtPotencia, int index) {
		Carga carga = bdVeiculos.getListaCarga().get(index);
		txtCargaMax.setText(Integer.toString(carga.getCargaMax()));
		txtTara.setText(Integer.toString(carga.getTara()));
		txtCor.setText(carga.getCor());
		txtMarca.setText(carga.getMarca());
		txtModelo.setText(carga.getModelo());
		txtPotencia.setText(Integer.toString(carga.getQtdRodas()));
		txtQtdPistoes.setText(Integer.toString(carga.getMotor().getQtdPist()));
		txtQtdRodas.setText(Integer.toString(carga.getQtdRodas()));
		txtVelocidadeMax.setText(Float.toString(carga.getVelocMax()));
	}

	private static void imprimirTodosPasseiosTabela(JFrame imprimirExclPasseioBoundary, String[] columnNames,
			Object[][] dados) {
		for (int x = 0; x < bdVeiculos.getListaPasseio().size(); x++) {
			dados[x][0] = bdVeiculos.getListaPasseio().get(x).getPlaca();
			dados[x][1] = bdVeiculos.getListaPasseio().get(x).getMarca();
			dados[x][2] = bdVeiculos.getListaPasseio().get(x).getModelo();
			dados[x][3] = bdVeiculos.getListaPasseio().get(x).getCor();
			dados[x][4] = bdVeiculos.getListaPasseio().get(x).getQtdRodas();
			dados[x][5] = bdVeiculos.getListaPasseio().get(x).getVelocMax();
			dados[x][6] = bdVeiculos.getListaPasseio().get(x).getMotor().getQtdPist();
			dados[x][7] = bdVeiculos.getListaPasseio().get(x).getMotor().getPotencia();
			dados[x][8] = bdVeiculos.getListaPasseio().get(x).getQtdPassageiros();
		}

		JTable tabela = new JTable(dados, columnNames);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 40, 720, 400);
		scrollPane.setViewportView(tabela);

		imprimirExclPasseioBoundary.add(scrollPane);
	}

	private static void imprimirTodosCargaTabela(JFrame imprimirExclCargaBoundary, String[] columnNames,
			Object[][] dados) {
		for (int x = 0; x < bdVeiculos.getListaCarga().size(); x++) {
			dados[x][0] = bdVeiculos.getListaCarga().get(x).getPlaca();
			dados[x][1] = bdVeiculos.getListaCarga().get(x).getMarca();
			dados[x][2] = bdVeiculos.getListaCarga().get(x).getModelo();
			dados[x][3] = bdVeiculos.getListaCarga().get(x).getCor();
			dados[x][4] = bdVeiculos.getListaCarga().get(x).getQtdRodas();
			dados[x][5] = bdVeiculos.getListaCarga().get(x).getVelocMax();
			dados[x][6] = bdVeiculos.getListaCarga().get(x).getMotor().getQtdPist();
			dados[x][7] = bdVeiculos.getListaCarga().get(x).getMotor().getPotencia();
			dados[x][8] = bdVeiculos.getListaCarga().get(x).getTara();
			dados[x][9] = bdVeiculos.getListaCarga().get(x).getCargaMax();
		}

		JTable tabela = new JTable(dados, columnNames);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 40, 720, 400);
		scrollPane.setViewportView(tabela);

		imprimirExclCargaBoundary.add(scrollPane);
	}

}
