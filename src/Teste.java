import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Teste {

	private static Carga carga;
	private static Passeio passeio;

	private static BDVeiculos bdVeiculos = new BDVeiculos();

	private static Leitura l = new Leitura();

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

		buttonSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuCargaBoundary.dispose();
				menuInicialGestaoBoundary();
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

				impCarga();
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

		buttonSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				menuPasseioBoundary.dispose();
				menuInicialGestaoBoundary();
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

				impPasseio();
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

	public static Passeio cadPasseio(Passeio passeio) {
		System.out.println("\n\n======================Cadastro de veiculos de Passeio======================\n\n");
		passeio.setCor(l.entDados("Cor: "));
		passeio.setMarca(l.entDados("Marca: "));
		passeio.setModelo(l.entDados("Modelo: "));
		passeio.setPlaca(l.entDados("Placa: "));
		passeio.setQtdRodas(Integer.parseInt(l.entDados("Quantidade de rodas: ")));
		passeio.setVelocMax(Float.parseFloat(l.entDados("Velocidade Maxima: ")));
		passeio.getMotor().setPotencia(Integer.parseInt(l.entDados("Potencia do motor: ")));
		passeio.getMotor().setQtdPist(Integer.parseInt(l.entDados("Quantidade de pistoes do motor: ")));
		passeio.setQtdPassageiros(Integer.parseInt(l.entDados("Quantidade de Passageiros: ")));
		return passeio;
	}

	public static Carga cadCarga(Carga carga) {
		System.out.println("\n\n======================Cadastro de veiculos de Carga======================\n\n");
		carga.setCor(l.entDados("Cor: "));
		carga.setMarca(l.entDados("Marca: "));
		carga.setModelo(l.entDados("Modelo: "));
		carga.setPlaca(l.entDados("Placa: "));
		carga.setQtdRodas(Integer.parseInt(l.entDados("Quantidade de rodas: ")));
		carga.getMotor().setPotencia(Integer.parseInt(l.entDados("Potencia do motor: ")));
		carga.getMotor().setQtdPist(Integer.parseInt(l.entDados("Quantidade de pistoes do motor: ")));
		carga.setTara(Integer.parseInt(l.entDados("Tara: ")));
		carga.setCargaMax(Integer.parseInt(l.entDados("Carga maxima: ")));
		carga.setVelocMax(Float.parseFloat(l.entDados("Velocidade Maxima: ")));
		return carga;
	}

	public static void impPasseio() {
		System.out.println("\n\t\t Imprimindo todos veiculos de passeio...");
		for (int count = 0; count < bdVeiculos.getListaPasseio().size(); count++) {
			System.out.println("Modelo do carro de passeio: " + count + "° " + "Cor: "
					+ bdVeiculos.getListaPasseio().get(count).getCor() + " " + "Marca: "
					+ bdVeiculos.getListaPasseio().get(count).getMarca() + " " + "Modelo: "
					+ bdVeiculos.getListaPasseio().get(count).getModelo() + " " + "Placa: "
					+ bdVeiculos.getListaPasseio().get(count).getPlaca() + " " + "Quantidade rodada: "
					+ bdVeiculos.getListaPasseio().get(count).getQtdRodas() + " " + "Velocidade Maxima: "
					+ bdVeiculos.getListaPasseio().get(count)
							.calcVel(bdVeiculos.getListaPasseio().get(count).getVelocMax())
					+ " " + "Potencia: " + bdVeiculos.getListaPasseio().get(count).getMotor().getPotencia() + " "
					+ "Quantidade Pist: " + bdVeiculos.getListaPasseio().get(count).getMotor().getQtdPist() + " "
					+ "Quantidade de passageiros: " + bdVeiculos.getListaPasseio().get(count).getQtdPassageiros());
		}
	}

	public static void impCarga() {
		System.out.println("\n\t\t Imprimindo todos veiculos de carga...");
		for (int count = 0; count < bdVeiculos.getListaCarga().size(); count++) {
			System.out.println("Modelo do carro de carga: " + count + "° " + "Cor: "
					+ bdVeiculos.getListaCarga().get(count).getCor() + " " + "Marca: "
					+ bdVeiculos.getListaCarga().get(count).getMarca() + " " + "Modelo: "
					+ bdVeiculos.getListaCarga().get(count).getModelo() + " " + "Placa: "
					+ bdVeiculos.getListaCarga().get(count).getPlaca() + " " + "Quantidade rodada: "
					+ bdVeiculos.getListaCarga().get(count).getQtdRodas() + " " + "Velocidade Maxima: "
					+ bdVeiculos.getListaCarga().get(count).calcVel(bdVeiculos.getListaCarga().get(count).getVelocMax())
					+ " " + "Potencia: " + bdVeiculos.getListaCarga().get(count).getMotor().getPotencia() + " "
					+ "Quantidade Pist: " + bdVeiculos.getListaCarga().get(count).getMotor().getQtdPist() + " "
					+ "Tara: " + bdVeiculos.getListaCarga().get(count).getTara() + " " + "Carga maxima: "
					+ bdVeiculos.getListaCarga().get(count).getCargaMax());

		}
	}

	public static void impUmPasseio(Passeio passeio, int i) {
		System.out.println("Modelo do carro de passeio: " + i + "° " + "Cor: " + passeio.getCor() + " " + "Marca: "
				+ passeio.getMarca() + " " + "Modelo: " + passeio.getModelo() + " " + "Placa: " + passeio.getPlaca()
				+ " " + "Quantidade rodada: " + passeio.getQtdRodas() + " " + "Velocidade Maxima: "
				+ passeio.calcVel(passeio.getVelocMax()) + " " + "Potencia: " + passeio.getMotor().getPotencia() + " "
				+ "Quantidade Pist: " + passeio.getMotor().getQtdPist() + " " + "Quantidade de passageiros: "
				+ passeio.getQtdPassageiros());
	}

	public static void impUmCarga(Carga carga, int i) {
		System.out.println("Modelo do carro de carga: " + i + "° " + "Cor: " + carga.getCor() + " " + "Marca: "
				+ carga.getMarca() + " " + "Modelo: " + carga.getModelo() + " " + "Placa: " + carga.getPlaca() + " "
				+ "Quantidade rodada: " + carga.getQtdRodas() + " " + "Velocidade Maxima: "
				+ carga.calcVel(carga.getVelocMax()) + " " + "Potencia: " + carga.getMotor().getPotencia() + " "
				+ "Quantidade Pist: " + carga.getMotor().getQtdPist() + " " + "Tara: " + carga.getTara() + " "
				+ "Carga maxima: " + carga.getCargaMax());
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

		l.entDados("\n\n\t\t NAO exise veiculo de PASSEIO com esta placa - press<ENTER>");

		return -1;
	}

	public static int existeVeiculoCargoPorPlaca(String placa) {

		for (int i = 0; i < bdVeiculos.getListaCarga().size(); i++) {
			if (bdVeiculos.getListaCarga().get(i).getPlaca().equalsIgnoreCase(placa)) {
				return i;
			}
		}

		l.entDados("\n\n\t\t NAO exise veiculo de CARGA com esta placa - press<ENTER>");

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

}
