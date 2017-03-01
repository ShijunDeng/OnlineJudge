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

/*@author:王朔
 *@time:2012-05-11
 *界面
 */
public class Client extends JFrame {
	private MusicPlayer musicPlayer;
	private JPanel jpanel1, jpanelCardBackground1, jpanelCardBackground2,
			jpanelCardBackground3;
	private JPanel headImage1, headImage2;// 头像
	private JPanel win;//
	private JButton jbutton1;
	private static Image backgroundImage;
	private static Image imageA, imageB;// 头像
	private static Image backOfCard;// 扑克背面
	private static Image imagewin;//
	private JPanel jpanelCard1, jpanelCard2;
	private static Toolkit toolkit = Toolkit.getDefaultToolkit();
	private int width = toolkit.getScreenSize().width;// 窗体的宽度
	private int height = toolkit.getScreenSize().height;// 窗体的高度
	private JMenuBar menuBar = new JMenuBar();;
	private JMenu menu_game = new JMenu("游   戏(G)");
	private JMenu menu_help = new JMenu("帮   助(H)");
	private JMenu menu_record = new JMenu("统计信息");
	private JMenu menu_game_set = new JMenu("游戏设定");
	private JMenuItem menuItem_game_exit = new JMenuItem("退出");
	private JMenuItem menuItem_help_about = new JMenuItem("关于游戏");
	private JMenuItem menuItem_help_rule = new JMenuItem("查看帮助");
	ButtonGroup groupMusic = new ButtonGroup();
	ButtonGroup groupRecord = new ButtonGroup();
	private JRadioButtonMenuItem onMusic = new JRadioButtonMenuItem("开启音乐");
	private JRadioButtonMenuItem offMusic = new JRadioButtonMenuItem("关闭音乐");
	private JRadioButtonMenuItem lookRecord = new JRadioButtonMenuItem("查看记录");
	private JRadioButtonMenuItem clearRecord = new JRadioButtonMenuItem("删除记录");
	private static final long serialVersionUID = 1L;
	private Gambler gamblerA, gamblerB, winner;
	String s;// 胜利者的提示语

	static private int count = 0;// 玩的次数
	private Record reco;
	int[][] record = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
			{ 0, 0, 0 }, { 0, 0, 0 } };// 每种牌胜、平、负
	static {
		backgroundImage = toolkit.getImage("resource" + File.separator
				+ "images" + File.separator + "背景001.jpg");
		imageA = toolkit.getImage("resource" + File.separator + "images"
				+ File.separator + "头像001.jpg");
		imageB = toolkit.getImage("resource" + File.separator + "images"
				+ File.separator + "头像002.jpg");
		backOfCard = toolkit.getImage("resource" + File.separator + "images"
				+ File.separator + "扑克牌背面001.jpg");
		imagewin = toolkit.createImage("resource" + File.separator + "images"
				+ File.separator + "动态背景001.gif");
	}

	public Client() {
		super("小游戏--王硕");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("不能设置外观的原因：" + e);
		}
		setBounds(width / 15, height / 15, (int) (width / 1.2),
				(int) (height / 1.2));
		setIconImage(Toolkit.getDefaultToolkit().createImage(
				"resource" + File.separator + "images" + File.separator
						+ "图标1.gif"));

		try {
			URL url = new File("resource" + File.separator + "music"
					+ File.separator + "背景音乐002.wav").toURI().toURL();
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
		jbutton1 = new JButton("发  牌");
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
				if (e.getActionCommand().equals("发  牌")) {
					jbutton1.setText("开  牌");
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
					// 发牌
					Cards cards = new Cards();// 记录避免重复
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

				} else if (e.getActionCommand().equals("开  牌")) {
					count++;
					jbutton1.setText("发  牌");
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
				}// else if开牌
			}
		});// jbutton1

		menuItem_game_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});// menuItem_game_exit

		onMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musicPlayer.stop();// 在播放就要关闭
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
						{ 0, 0, 0 }, { 0, 0, 0 } };// 每种牌胜、平、负

			}
		});// lookRecord

		clearRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,
						"您确定要清空游戏记录吗?\n(此操作无法恢复!)", "警告",
						JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
					reco = new Record(record, count);
					reco.clearRecord();
					count = 0;
					record = new int[][] { { 0, 0, 0 }, { 0, 0, 0 },
							{ 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };// 每种牌胜、平、负

				}
			}
		});// clearRecord
		menuItem_help_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"版本1.0 wangshuo\n由王硕开发  本人保留所有权利\n欢迎大家对本游戏提出建议",
						"关于游戏", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menuItem_help_rule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Rule();
			}
		});
	}// addMyListener

	// 判断谁是胜利者
	public void winner() {
		gamblerA.getCards().judge();
		gamblerB.getCards().judge();
		int IDA = gamblerA.getCards().getID();
		int IDB = gamblerB.getCards().getID();
		int[] detailIDA = gamblerA.getCards().getDetailID();
		int[] detailIDB = gamblerB.getCards().getDetailID();
		switch (IDA) {
		case Cards.VALUEOFTONGHUA:// A为同花顺
			if (IDB == Cards.VALUEOFTONGHUA) {// A为同花顺B为同花顺，比较最大的牌
				if (detailIDA[0] == detailIDB[0]) {
					winner = null;//
					record[0][1]++;
				} else if (detailIDA[0] == Cards.MAXOFTONGHUA) {
					winner = gamblerA;// A胜
					record[0][0]++;
				} else if (detailIDB[0] == Cards.MAXOFTONGHUA) {
					winner = gamblerB;// A胜
					record[0][2]++;
				} else {
					if (detailIDA[1] == detailIDB[1]) {
						winner = null;// 平局
						record[0][1]++;
					} else if (detailIDA[1] > detailIDB[1]) {
						winner = gamblerA;// A胜
						record[0][0]++;
					} else {
						winner = gamblerB;
						record[0][2]++;
					}
				}
			} else {
				winner = gamblerA;// A胜
				record[0][0]++;
			}
			break;

		case Cards.VALUEOFSHUNZI:// A为顺子

			if (IDB == Cards.VALUEOFTONGHUA) {// A为顺子B为同花顺
				record[1][2]++;
				winner = gamblerB;
			} else if (IDB == Cards.VALUEOFSHUNZI) {// A为顺子B为顺子，比较最大的牌
				if (detailIDA[0] == detailIDB[0]) {
					winner = null;// 平局
					record[1][1]++;
				} else if (detailIDA[0] > detailIDB[0]) {
					winner = gamblerA;// A胜
					record[1][0]++;
				} else {
					winner = gamblerB;
					record[1][2]++;
				}
			} else {
				winner = gamblerA;// A胜
				record[1][0]++;
			}
			break;
		case Cards.VALUEOFTONGDIAN:// A为同点的牌
			if (IDB == Cards.VALUEOFTONGHUA || IDB == Cards.VALUEOFSHUNZI) {// A为同点的牌,B为同花顺或者顺子
				winner = gamblerB;
				record[2][2]++;
			} else if (IDB == Cards.VALUEOFTONGDIAN) {// A为同点的牌,B为同点的牌
				if (detailIDA[0] == detailIDB[0]) {
					winner = null;// 平局
					record[2][1]++;
				} else if (detailIDA[0] > detailIDB[0]) {
					winner = gamblerA;// A胜
					record[2][0]++;
				} else {
					winner = gamblerB;
					record[2][2]++;
				}
			} else {
				winner = gamblerA;// A胜
				record[2][0]++;
			}
			break;
		case Cards.VALUEOFDUIZI:// A为对子

			if (IDB == Cards.VALUEOFTONGHUA || IDB == Cards.VALUEOFSHUNZI
					|| IDB == Cards.VALUEOFTONGDIAN) {// A为对子,B为同花顺或者顺子或者同点的牌
				winner = gamblerB;
				record[3][2]++;
			} else if (IDB == Cards.VALUEOFDUIZI) {// A为对子,B也是对子
				//
				if (detailIDA[0] == detailIDB[0]) {
					// 对子的值相等，比较单字牌
					if (detailIDA[1] == detailIDB[1]) {
						winner = null;// 平局
						record[3][1]++;
					} else if (detailIDA[1] > detailIDB[1]) {
						winner = gamblerA;// A胜
						record[3][0]++;
					} else {
						winner = gamblerB;
						record[3][2]++;
					}
				} else if (detailIDA[0] > detailIDB[0]) {
					winner = gamblerA;// A胜
					record[3][0]++;
				} else {
					winner = gamblerB;
					record[3][2]++;
				}
			} else {
				winner = gamblerA;// A胜
				record[3][0]++;
			}
			break;
		case Cards.VALUEOFBUTONGSEZAPAI:
			if (IDB == Cards.VALUEOFTONGHUA || IDB == Cards.VALUEOFSHUNZI
					|| IDB == Cards.VALUEOFTONGDIAN
					|| IDB == Cards.VALUEOFDUIZI) {// A为不同花色杂牌,B为同花顺或者顺子或者同点的牌或者对子
				winner = gamblerB;
				record[4][2]++;
			} else if (detailIDA[0] == detailIDB[0]) {
				if (IDB == Cards.VALUEOFBUTONGSEZAPAI) {
					winner = null;// 平局
					record[4][1]++;
				} else {
					winner = gamblerA;// A胜:点数相同，不同花色的获胜
					record[4][0]++;
				}
			} else if (detailIDA[0] > detailIDB[0]) {
				winner = gamblerA;// A胜
				record[4][0]++;
			} else {
				winner = gamblerB;
				record[4][2]++;
			}
			break;
		case Cards.VALUEOFTONGSEZAPAI:
			if (IDB == Cards.VALUEOFTONGHUA || IDB == Cards.VALUEOFSHUNZI
					|| IDB == Cards.VALUEOFTONGDIAN
					|| IDB == Cards.VALUEOFDUIZI) {// A为同花色杂牌,B为同花顺或者顺子或者同点的牌或者对子
				winner = gamblerB;
				record[4][2]++;
			} else if (detailIDA[0] == detailIDB[0]) {
				if (IDB == Cards.VALUEOFTONGSEZAPAI) {
					winner = null;// 平局:同色杂牌且点数相同
					record[4][1]++;
				} else {
					winner = gamblerB;// A负:点数相同，不同花色的获胜
					record[4][2]++;
				}
			} else if (detailIDA[0] > detailIDB[0]) {
				winner = gamblerA;// A胜
				record[4][0]++;
			} else {
				winner = gamblerB;
				record[4][2]++;
			}

			break;
		default:
			JOptionPane.showMessageDialog(null, "无法处理的内部错误!", "警告",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	public void draw(Graphics g, Image image, int xPos, int yPos) {

		g.drawImage(image, xPos, yPos, null);

	}

	public static void main(String args[]) {
		new Client();
	}

	// 起线程
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

