package wangshuo.program;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

/*@author:��˷
 *@time:2012-05-11
 *����
 */
public class Client extends JFrame {
	private MusicPlayer musicPlayer;
	private JPanel jpanel1, jpanelCardBackground1, jpanelCardBackground2,
			jpanelCardBackground3;
	private JPanel headImage1, headImage2;// ͷ��
	private JPanel win;//
	private JButton jbutton1;
	private static Image backgroundImage;
	private static Image imageA, imageB;// ͷ��
	private static Image backOfCard;// �˿˱���
	private static Image imagewin;//
	private JPanel jpanelCard1, jpanelCard2;
	private static Toolkit toolkit = Toolkit.getDefaultToolkit();
	private int width = toolkit.getScreenSize().width;// ����Ŀ��
	private int height = toolkit.getScreenSize().height;// ����ĸ߶�
	private JMenuBar menuBar = new JMenuBar();;
	private JMenu menu_game = new JMenu("��   Ϸ(G)");
	private JMenu menu_help = new JMenu("��   ��(H)");
	private JMenu menu_record = new JMenu("ͳ����Ϣ");
	private JMenu menu_game_set = new JMenu("��Ϸ�趨");
	private JMenuItem menuItem_game_exit = new JMenuItem("�˳�");
	private JMenuItem menuItem_help_about = new JMenuItem("������Ϸ");
	private JMenuItem menuItem_help_rule = new JMenuItem("�鿴����");
	ButtonGroup groupMusic = new ButtonGroup();
	ButtonGroup groupRecord = new ButtonGroup();
	private JRadioButtonMenuItem onMusic = new JRadioButtonMenuItem("��������");
	private JRadioButtonMenuItem offMusic = new JRadioButtonMenuItem("�ر�����");
	private JRadioButtonMenuItem lookRecord = new JRadioButtonMenuItem("�鿴��¼");
	private JRadioButtonMenuItem clearRecord = new JRadioButtonMenuItem("ɾ����¼");
	private static final long serialVersionUID = 1L;
	private Gambler gamblerA, gamblerB, winner;
	String s;// ʤ���ߵ���ʾ��

	static private int count = 0;// ��Ĵ���
	private Record reco;
	int[][] record = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
			{ 0, 0, 0 }, { 0, 0, 0 } };// ÿ����ʤ��ƽ����
	static {
		backgroundImage = toolkit.getImage("resource" + File.separator
				+ "images" + File.separator + "����001.jpg");
		imageA = toolkit.getImage("resource" + File.separator + "images"
				+ File.separator + "ͷ��001.jpg");
		imageB = toolkit.getImage("resource" + File.separator + "images"
				+ File.separator + "ͷ��002.jpg");
		backOfCard = toolkit.getImage("resource" + File.separator + "images"
				+ File.separator + "�˿��Ʊ���001.jpg");
		imagewin = toolkit.createImage("resource" + File.separator + "images"
				+ File.separator + "��̬����001.gif");
	}

	public Client() {
		super("С��Ϸ--��˶");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("����������۵�ԭ��" + e);
		}
		setBounds(width / 15, height / 15, (int) (width / 1.2),
				(int) (height / 1.2));
		setIconImage(Toolkit.getDefaultToolkit().createImage(
				"resource" + File.separator + "images" + File.separator
						+ "ͼ��1.gif"));

		try {
			URL url = new File("resource" + File.separator + "music"
					+ File.separator + "��������002.wav").toURI().toURL();
			musicPlayer = new MusicPlayer(url);
			musicPlayer.play();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		setResizable(false);
		init();
		addMyListener();
		setVisible(true);
		new Thread(new PaintThread()).start();
	}

	private void init() {
		menu_game.add(menu_record);
		menu_game.add(menu_game_set);
		menu_game.addSeparator();
		menu_game.add(menuItem_game_exit);
		menu_help.add(menuItem_help_rule);
		menu_help.add(menuItem_help_about);
		menuBar.add(menu_game);
		menuBar.add(menu_help);
		groupMusic.add(onMusic);
		groupMusic.add(offMusic);
		groupRecord.add(lookRecord);
		lookRecord.setSelected(true);
		groupRecord.add(clearRecord);
		menu_record.add(lookRecord);
		menu_record.add(clearRecord);
		menu_game_set.add(onMusic);
		menu_game_set.add(offMusic);
		offMusic.setSelected(true);
		this.setJMenuBar(menuBar);

		jpanel1 = new JPanel() {
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				g.drawImage(backgroundImage, 0, 0, width, height, this);

			}
		};

		jpanelCardBackground1 = new JPanel() {
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				for (int i = 0; i < 3; i++) {
					draw(g, backOfCard, 0, 10 + 30 * i);
				}

			}
		};

		jpanelCardBackground2 = new JPanel() {
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				for (int i = 0; i < 3; i++) {
					draw(g, backOfCard, 0, 10 + 30 * i);
				}

			}
		};
		jpanelCardBackground3 = new JPanel() {
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				for (int i = 0; i < 20; i++) {
					draw(g, backOfCard, 10 + 20 * i, 0);
				}
			}
		};

		headImage1 = new JPanel() {
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				draw(g, imageA, 0, 0);
			}
		};
		jpanel1.add(headImage1);
		headImage1.setBounds(width / 7, height / 20, 200, 200);
		headImage1.setVisible(true);

		headImage2 = new JPanel() {
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				draw(g, imageB, 0, 0);

			}
		};
		jpanel1.add(headImage2);
		headImage2.setBounds(width * 15 / 25, height / 20, 200, 200);

		win = new JPanel() {
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				draw(g, imagewin, 0, 0);
			}

		};

		jpanel1.add(win);
		win.setBounds(width * 7 / 25, height / 20, 370, 135);
		win.setVisible(false);

		jpanel1.setLayout(null);
		jbutton1 = new JButton("��  ��");
		jbutton1.setFont(new Font("Serif", Font.BOLD, 16));
		jpanel1.add(jbutton1);
		jbutton1.setBounds((int) (width / 2.5), (int) (height * 0.6),
				width / 15, height / 20);

		jpanel1.add(jpanelCardBackground1);
		jpanelCardBackground1.setBounds(width / 25, height / 20, 110, 220);
		jpanelCardBackground1.setVisible(false);

		jpanel1.add(jpanelCardBackground2);
		jpanelCardBackground2.setBounds(width * 18 / 25, height / 20, 110, 220);
		jpanelCardBackground2.setVisible(false);

		jpanel1.add(jpanelCardBackground3);
		jpanelCardBackground3.setBounds(width / 5, height * 1 / 3, 500, 150);
		jpanelCardBackground3.setVisible(false);

		add(jpanel1);

	}

	private void addMyListener() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		jbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("��  ��")) {
					jbutton1.setText("��  ��");
					win.setVisible(false);
					headImage1.setBounds(width / 7, height / 20, 200, 200);
					headImage2
							.setBounds(width * 15 / 25, height / 20, 200, 200);
					jpanelCardBackground1.setVisible(true);
					jpanelCardBackground2.setVisible(true);
					jpanelCardBackground3.setVisible(true);
					if (jpanelCard1 != null && jpanelCard2 != null) {
						jpanel1.remove(jpanelCard1);
						jpanel1.remove(jpanelCard2);
					}
					final Cards cA = new Cards();
					final Cards cB = new Cards();
					Card c;
					// ����
					Cards cards = new Cards();// ��¼�����ظ�
					for (int i = 0; i < 6; i++) {
						c = new Card();
						if (false == cards.exsit(c)) {
							cards.putCard(c);
							if (i % 2 == 0) {
								cA.putCard(c);
							} else {
								cB.putCard(c);
							}
						} else {
							i--;
						}
					}

					gamblerA = new Gambler(1, cA, imageA);
					gamblerB = new Gambler(2, cB, imageB);
					jpanelCard1 = new JPanel() {
						private static final long serialVersionUID = 1L;

						protected void paintComponent(Graphics g) {
							for (int i = 0, j = cA.getSize() - 1; i < cA
									.getSize() && j >= 0; i++, j--) {
								draw(g, cA.getCard(j).getImage(), 0,
										10 + 30 * i);
							}

						}
					};

					jpanelCard2 = new JPanel() {
						private static final long serialVersionUID = 1L;

						protected void paintComponent(Graphics g) {
							for (int i = 0, j = cB.getSize() - 1; i < cB
									.getSize() && j >= 0; i++, j--) {
								draw(g, cB.getCard(j).getImage(), 0,
										10 + 30 * i);
							}

						}
					};

					jpanel1.add(jpanelCard1);
					jpanelCard1.setBounds(width / 25, height / 20, 110, 220);
					jpanelCard1.setVisible(false);

					jpanel1.add(jpanelCard2);
					jpanelCard2.setBounds(width * 18 / 25, height / 20, 110,
							220);
					jpanelCard2.setVisible(false);

					winner();

				} else if (e.getActionCommand().equals("��  ��")) {
					count++;
					jbutton1.setText("��  ��");
					jpanelCard1.setVisible(true);
					jpanelCard2.setVisible(true);
					jpanelCardBackground1.setVisible(false);
					jpanelCardBackground2.setVisible(false);
					jpanelCardBackground3.setVisible(false);
					if (winner == gamblerA) {
						win.setVisible(true);
						headImage1.setBounds(width * 9 / 25, height / 20 + 140,
								200, 200);
					} else if (winner == gamblerB) {
						win.setVisible(true);
						headImage2.setBounds(width * 9 / 25, height / 20 + 140,
								200, 200);
					} else {
						win.setVisible(true);
						headImage1.setBounds(width * 8 / 25, height / 20 + 140,
								200, 200);
						headImage2.setBounds(width * 10 / 25 + 20,
								height / 20 + 140, 200, 200);
					}
					winner = null;
				}// else if����
			}
		});// jbutton1

		menuItem_game_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});// menuItem_game_exit

		onMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musicPlayer.stop();// �ڲ��ž�Ҫ�ر�
				musicPlayer.play();
			}
		});// onMusic

		offMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musicPlayer.stop();
			}
		});// offMusic

		lookRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reco = new Record(record, count);
				reco.lookRecord();
				count = 0;
				record = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
						{ 0, 0, 0 }, { 0, 0, 0 } };// ÿ����ʤ��ƽ����

			}
		});// lookRecord

		clearRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,
						"��ȷ��Ҫ�����Ϸ��¼��?\n(�˲����޷��ָ�!)", "����",
						JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
					reco = new Record(record, count);
					reco.clearRecord();
					count = 0;
					record = new int[][] { { 0, 0, 0 }, { 0, 0, 0 },
							{ 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };// ÿ����ʤ��ƽ����

				}
			}
		});// clearRecord
		menuItem_help_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"�汾1.0 wangshuo\n����˶����  ���˱�������Ȩ��\n��ӭ��ҶԱ���Ϸ�������",
						"������Ϸ", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menuItem_help_rule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Rule();
			}
		});
	}// addMyListener

	// �ж�˭��ʤ����
	public void winner() {
		gamblerA.getCards().judge();
		gamblerB.getCards().judge();
		int IDA = gamblerA.getCards().getID();
		int IDB = gamblerB.getCards().getID();
		int[] detailIDA = gamblerA.getCards().getDetailID();
		int[] detailIDB = gamblerB.getCards().getDetailID();
		switch (IDA) {
		case Cards.VALUEOFTONGHUA:// AΪͬ��˳
			if (IDB == Cards.VALUEOFTONGHUA) {// AΪͬ��˳BΪͬ��˳���Ƚ�������
				if (detailIDA[0] == detailIDB[0]) {
					winner = null;//
					record[0][1]++;
				} else if (detailIDA[0] == Cards.MAXOFTONGHUA) {
					winner = gamblerA;// Aʤ
					record[0][0]++;
				} else if (detailIDB[0] == Cards.MAXOFTONGHUA) {
					winner = gamblerB;// Aʤ
					record[0][2]++;
				} else {
					if (detailIDA[1] == detailIDB[1]) {
						winner = null;// ƽ��
						record[0][1]++;
					} else if (detailIDA[1] > detailIDB[1]) {
						winner = gamblerA;// Aʤ
						record[0][0]++;
					} else {
						winner = gamblerB;
						record[0][2]++;
					}
				}
			} else {
				winner = gamblerA;// Aʤ
				record[0][0]++;
			}
			break;

		case Cards.VALUEOFSHUNZI:// AΪ˳��

			if (IDB == Cards.VALUEOFTONGHUA) {// AΪ˳��BΪͬ��˳
				record[1][2]++;
				winner = gamblerB;
			} else if (IDB == Cards.VALUEOFSHUNZI) {// AΪ˳��BΪ˳�ӣ��Ƚ�������
				if (detailIDA[0] == detailIDB[0]) {
					winner = null;// ƽ��
					record[1][1]++;
				} else if (detailIDA[0] > detailIDB[0]) {
					winner = gamblerA;// Aʤ
					record[1][0]++;
				} else {
					winner = gamblerB;
					record[1][2]++;
				}
			} else {
				winner = gamblerA;// Aʤ
				record[1][0]++;
			}
			break;
		case Cards.VALUEOFTONGDIAN:// AΪͬ�����
			if (IDB == Cards.VALUEOFTONGHUA || IDB == Cards.VALUEOFSHUNZI) {// AΪͬ�����,BΪͬ��˳����˳��
				winner = gamblerB;
				record[2][2]++;
			} else if (IDB == Cards.VALUEOFTONGDIAN) {// AΪͬ�����,BΪͬ�����
				if (detailIDA[0] == detailIDB[0]) {
					winner = null;// ƽ��
					record[2][1]++;
				} else if (detailIDA[0] > detailIDB[0]) {
					winner = gamblerA;// Aʤ
					record[2][0]++;
				} else {
					winner = gamblerB;
					record[2][2]++;
				}
			} else {
				winner = gamblerA;// Aʤ
				record[2][0]++;
			}
			break;
		case Cards.VALUEOFDUIZI:// AΪ����

			if (IDB == Cards.VALUEOFTONGHUA || IDB == Cards.VALUEOFSHUNZI
					|| IDB == Cards.VALUEOFTONGDIAN) {// AΪ����,BΪͬ��˳����˳�ӻ���ͬ�����
				winner = gamblerB;
				record[3][2]++;
			} else if (IDB == Cards.VALUEOFDUIZI) {// AΪ����,BҲ�Ƕ���
				//
				if (detailIDA[0] == detailIDB[0]) {
					// ���ӵ�ֵ��ȣ��Ƚϵ�����
					if (detailIDA[1] == detailIDB[1]) {
						winner = null;// ƽ��
						record[3][1]++;
					} else if (detailIDA[1] > detailIDB[1]) {
						winner = gamblerA;// Aʤ
						record[3][0]++;
					} else {
						winner = gamblerB;
						record[3][2]++;
					}
				} else if (detailIDA[0] > detailIDB[0]) {
					winner = gamblerA;// Aʤ
					record[3][0]++;
				} else {
					winner = gamblerB;
					record[3][2]++;
				}
			} else {
				winner = gamblerA;// Aʤ
				record[3][0]++;
			}
			break;
		case Cards.VALUEOFBUTONGSEZAPAI:
			if (IDB == Cards.VALUEOFTONGHUA || IDB == Cards.VALUEOFSHUNZI
					|| IDB == Cards.VALUEOFTONGDIAN
					|| IDB == Cards.VALUEOFDUIZI) {// AΪ��ͬ��ɫ����,BΪͬ��˳����˳�ӻ���ͬ����ƻ��߶���
				winner = gamblerB;
				record[4][2]++;
			} else if (detailIDA[0] == detailIDB[0]) {
				if (IDB == Cards.VALUEOFBUTONGSEZAPAI) {
					winner = null;// ƽ��
					record[4][1]++;
				} else {
					winner = gamblerA;// Aʤ:������ͬ����ͬ��ɫ�Ļ�ʤ
					record[4][0]++;
				}
			} else if (detailIDA[0] > detailIDB[0]) {
				winner = gamblerA;// Aʤ
				record[4][0]++;
			} else {
				winner = gamblerB;
				record[4][2]++;
			}
			break;
		case Cards.VALUEOFTONGSEZAPAI:
			if (IDB == Cards.VALUEOFTONGHUA || IDB == Cards.VALUEOFSHUNZI
					|| IDB == Cards.VALUEOFTONGDIAN
					|| IDB == Cards.VALUEOFDUIZI) {// AΪͬ��ɫ����,BΪͬ��˳����˳�ӻ���ͬ����ƻ��߶���
				winner = gamblerB;
				record[4][2]++;
			} else if (detailIDA[0] == detailIDB[0]) {
				if (IDB == Cards.VALUEOFTONGSEZAPAI) {
					winner = null;// ƽ��:ͬɫ�����ҵ�����ͬ
					record[4][1]++;
				} else {
					winner = gamblerB;// A��:������ͬ����ͬ��ɫ�Ļ�ʤ
					record[4][2]++;
				}
			} else if (detailIDA[0] > detailIDB[0]) {
				winner = gamblerA;// Aʤ
				record[4][0]++;
			} else {
				winner = gamblerB;
				record[4][2]++;
			}

			break;
		default:
			JOptionPane.showMessageDialog(null, "�޷�������ڲ�����!", "����",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	public void draw(Graphics g, Image image, int xPos, int yPos) {

		g.drawImage(image, xPos, yPos, null);

	}

	public static void main(String args[]) {
		new Client();
	}

	// ���߳�
	private class PaintThread implements Runnable {

		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}// Client

