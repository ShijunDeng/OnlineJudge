import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.TextField;

import javax.swing.JOptionPane;

public class Face extends Frame {

	List<TextField> text = new ArrayList<TextField>();
	List<TextField> text2 = new ArrayList<TextField>();
	List<Label> label = new ArrayList<Label>();
	TextField f1, f2;
	Button b1, b2, b3;
	Panel p1, p2, p3, p4, p5;
	Label l1, l2, l3;
	int m, n;
	double[][] cof;// 系数
	double[][] con;// 常数

	public Face() {
		setTitle("直角三角形分解法--decomposeByDoolittle--对应解方程");
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds(width / 8, height / 8, width * 4 / 5, height * 4 / 5);
		setVisible(true);
		setVisible(true);
		f1 = new TextField();
		f2 = new TextField();
		b1 = new Button("计算");
		b2 = new Button("清空");
		b3 = new Button("确定");
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		p5 = new Panel();

		l1 = new Label("请给定矩阵的行列");
		l2 = new Label("×");
		l3 = new Label();
		init();
		addMyListener();
	}

	private void init() {
		p1.setLayout(new FlowLayout());
		p2.setLayout(new FlowLayout());
		p5.add(b1);
		p5.add(b2);
		p1.add(l1);
		p1.add(f1);
		p1.add(l2);
		p1.add(f2);
		p1.add(b3);
		p3.setLayout(null);
		p3.add(p1);
		p1.setBounds(10, 10, this.getWidth() - 50, this.getHeight() / 18);

		p3.add(p2);
		p2.setBounds(10, this.getHeight() * 2 / 18, this.getWidth() - 50,
				this.getHeight() * 11 / 18);

		p3.add(p4);
		p4.setBounds(10, this.getHeight() * 14 / 18, this.getWidth() - 50,
				this.getHeight() / 18);
		p3.add(p5);
		p5.setBounds(10, this.getHeight() * 15 / 18, this.getWidth() - 50,
				this.getHeight() / 18);
		this.add(p3);

	}

	private void addMyListener() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b3.setEnabled(false);
				if (f1 == null || f2 == null || f1.getText().equals("")
						|| f2.getText().equals("")) {
					JOptionPane.showMessageDialog(p1, "计算之前请给出行列值！!", "提示",
							JOptionPane.INFORMATION_MESSAGE);
					b3.setEnabled(true);
				} else {
					m = Integer.parseInt(f1.getText());
					n = Integer.parseInt(f2.getText());
					if (m * n <= 0) {
						JOptionPane.showMessageDialog(p1, "行列值必须为大于零的整数!",
								"提示", JOptionPane.INFORMATION_MESSAGE);
						f1.setText("");
						f2.setText("");
						b3.setEnabled(true);
					}

					else {

						p2.setLayout(new GridLayout(m, 2 * n + 1, 20, 20));
						p4.setLayout(new GridLayout(1, 2 * n + 1, 20, 20));
						for (int i = 1; i <= m; i++)
							for (int j = 1; j <= n + 1; j++) {
								TextField t = new TextField();
								t.setBackground(Color.PINK);
							 
								p2.add(t);
								text.add(t);

								t.setVisible(true);
								if (j <= n - 1) {
									Label l = new Label("X" + j + "+");
									label.add(l);
									l.setForeground(Color.BLUE);
									p2.add(l);
								}
								if (j == n) {
									Label l = new Label("X" + j + "=");
									l.setForeground(Color.BLUE);
									label.add(l);
									p2.add(l);
								}
							}

						for (int j = 1; j <= n; j++) {
							Label l = new Label("X" + j + "=");
							p4.add(l);
							TextField t = new TextField();
							t.setEditable(false);
							t.setFocusable(false);
							t.setBackground(Color.YELLOW);
							p4.add(t);
							text2.add(t);
						}

						p3.validate();
						p4.validate();
					}

				}
			}

		});

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cof = new double[m][n];
				con = new double[m][1];
				int k = 0;
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n + 1; j++) {

						if (j < n) {
							String snum = text.get(i * n + j + k).getText()
									.trim();
							if (snum.equals("")) {
								JOptionPane.showMessageDialog(p3, (i + 1) + "行"
										+ (j + 1) + "列请给出完整的值！", "提示",
										JOptionPane.INFORMATION_MESSAGE);
								return;
							} else if (false == isNumber(snum)) {
								JOptionPane.showMessageDialog(p3, (i + 1) + "行"
										+ (j + 1) + "列存在不合法数据！", "提示",
										JOptionPane.INFORMATION_MESSAGE);
								return;
							} else
								cof[i][j] = Float.parseFloat(snum);
						} else if (j == n) {
							String cnum = text.get(i * n + j + k).getText();
							if (cnum.equals("")) {
								JOptionPane.showMessageDialog(p3, (i + 1) + "行"
										+ (j + 1) + "列请给出完整的值！", "提示",
										JOptionPane.INFORMATION_MESSAGE);
								return;
							} else if (false == isNumber(cnum)) {

								JOptionPane.showMessageDialog(p3, (i + 1) + "行"
										+ (j + 1) + "列存在不合法数据！", "提示",
										JOptionPane.INFORMATION_MESSAGE);
								return;
							} else
								con[i][0] = Float.parseFloat(cnum);
						}
					}
				k++;
				}
 

				SolveEquation su = new SolveEquation(new Matrix(m, n, cof), new Matrix(m,
						1, con));
				su.solve();
				System.out.println("直角三角形分解法--decomposeByDoolittle--对应解方程：");
				su.getCoefficientMatrix().printMatrix();
				su.getConstantMatrix().printMatrix();
				System.out.println("L：");
				su.getTRi().getDTri().printMatrix();
				System.out.println("U：");
				su.getTRi().UTri.printMatrix();
				System.out.println("解");
				su.getIntermediateMartrix().printMatrix();
				for (int j = 0; j < n; j++) {

					text2.get(j).setText(
							String.valueOf(su.getIntermediateMartrix().getElementAt(//现在的解在临时常矩阵里面
									j + 1, 1)));
				}

			}

		});
		
		//清空
		b2.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<text.size();i++)
					text.get(i).setText("");
				for(int i=0;i<text2.size();i++)
					text2.get(i).setText("");
			}
			
		});
	}

	/*
	 * 判断是不是数
	 */
	private boolean isNumber(String s) {
		char[] c = s.toCharArray();
		for (char cc : c)
			if (false == isNumber(cc) && cc != '.'&&cc!='-'&&cc!='/')
				return false;
		return true;
	}

	public boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}

	public static void main(String[] args) {

		new Face();

	}

}
