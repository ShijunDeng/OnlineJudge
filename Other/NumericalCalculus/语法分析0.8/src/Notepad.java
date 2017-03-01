import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import javax.swing.text.BadLocationException;

/*
 * 语法分析界面
 * @version 0.5 2012-04-12
 * @author XiaoDeng
 */
public class Notepad {
	private static final int X_START = 40;
	private static final int Y_START = 20;
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 650;
	private static final String LINEFEED = "\r\n";// 换行
	private MyWindow window;
	private Image image;
	private JMenuBar menuBar;
	private JMenu menu_file;
	private JMenu menu_edit;
	private JMenu menu_check;
	private JMenu menu_look;
	private JMenu menu_help;
	private JPopupMenu popMenu = new JPopupMenu();

	private JMenuItem menuItem_file_save;
	private JMenuItem menuItem_file_open;
	private JMenuItem menuItem_file_saveas;
	@SuppressWarnings("unused")
	private JMenuItem menuItem_file_print;
	@SuppressWarnings("unused")
	private JMenuItem menuItem_file_exit;

	private JMenuItem menuItem_edit_cancel;
	private JMenuItem menuItem_edit_cut;
	private JMenuItem menuItem_edit_copy;
	private JMenuItem menuItem_edit_paste;
	private JMenuItem menuItem_edit_delete;
	@SuppressWarnings("unused")
	private JMenuItem menuItem_edit_search;
	@SuppressWarnings("unused")
	private JMenuItem menuItem_edit_replace;
	private JMenuItem menuItem_edit_selectAll;
	@SuppressWarnings("unused")
	private JMenuItem menuItem_edit_searchNext;
	@SuppressWarnings("unused")
	private JMenuItem menuItem_edit_goto;
	private JMenuItem menuItem_edit_time;
	private JMenuItem menuItem_menu_check;
	private JPanel jpanel_window;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JTextArea jtExpression;
	private JTextArea jtProcess;
	private JTextArea jtFirstFollow;
	private JTextArea jtSelect;
	private JTextArea jtAnalyse;
	private JButton jb1;
	private JFileChooser chooser;

	private File f_words;// 传递给classifyWords

	private boolean hasOpened = false;
	Clipboard clipboard = null;// 定义一个剪切板对象
	CharacterHandl h;

	public Notepad() {
		image = Toolkit.getDefaultToolkit().createImage(
				"资源" + File.separator + "图标012.png");
		window = new MyWindow("语法分析", image, X_START, Y_START, WIDTH, HEIGHT);
		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();// 获得系统的剪切板
		menuBar = new JMenuBar();
		menu_file = new JMenu("文件 (F)");
		menu_file.setMnemonic('F');
		menu_edit = new JMenu("编辑(E)");
		menu_edit.setMnemonic('E');
		menu_check = new JMenu("检测(C)");
		menu_check.setMnemonic('C');
		menu_look = new JMenu("查看(V)");
		menu_look.setMnemonic('V');
		menu_help = new JMenu("帮助(H)");
		menu_help.setMnemonic('H');
		// 添加菜单
		menuBar.add(menu_file);
		menuBar.add(menu_edit);
		menuBar.add(menu_check);
		menuBar.add(menu_look);
		menuBar.add(menu_help);
		// 添加文件菜单项
		menuItem_file_open = menu_file.add("打开");
		menuItem_file_open.setAccelerator(KeyStroke.getKeyStroke("ctrl+ o"));
		menuItem_file_save = menu_file.add("保存");// 菜单项独特的用法
		menuItem_file_save.setAccelerator(KeyStroke.getKeyStroke("ctrl+ s"));
		menuItem_file_saveas = menu_file.add("另存为");
		menu_file.addSeparator();
		menuItem_file_print = menu_file.add("打印");
		menuItem_file_exit = menu_file.add("退出");
		// 添加编辑菜单项
		menuItem_edit_cancel = menu_edit.add("取消");
		menuItem_edit_cut = menu_edit.add("剪切");
		menuItem_edit_copy = menu_edit.add("复制");
		menuItem_edit_paste = menu_edit.add("粘贴");
		menuItem_edit_delete = menu_edit.add("删除");
		menuItem_edit_search = menu_edit.add("查找");
		menuItem_edit_searchNext = menu_edit.add("查找下一个");
		menuItem_edit_replace = menu_edit.add("替换");
		menuItem_edit_goto = menu_edit.add("转到");
		menuItem_edit_selectAll = menu_edit.add("全选");
		menuItem_edit_time = menu_edit.add("时间" + File.separator + "日期");

		// 分析菜单项
		menuItem_menu_check = menu_check.add("LL(1)文法判别");
		// 添加弹出菜单
		popMenu.add(menuItem_edit_cancel);
		popMenu.add(menuItem_edit_cut);
		popMenu.add(menuItem_edit_copy);
		popMenu.add(menuItem_edit_paste);
		popMenu.addSeparator();
		popMenu.add(menuItem_edit_delete);

		chooser = new JFileChooser();

		jb1 = new JButton();
		// 添加文本域

		jpanel_window = new JPanel();
		textArea = new JTextArea();

		jtProcess = new JTextArea();
		jtFirstFollow = new JTextArea();
		jtAnalyse = new JTextArea();
		jtSelect = new JTextArea();
		jtExpression = new JTextArea();

		jtProcess.setEditable(false);
		jtExpression.setEditable(true);
		jtFirstFollow.setEditable(false);
		jtAnalyse.setEditable(false);
		jtSelect.setEditable(false);
		// textArea.setFont(new Font("Serif",14,Font.PLAIN ));//不能用，不知道为什么
		textArea.setEditable(true);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane = new JScrollPane(textArea,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		JScrollPane scro_jtExpression = new JScrollPane(jtExpression,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JScrollPane scro_jtFirstFollow = new JScrollPane(jtFirstFollow,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JScrollPane scro_jtProcess = new JScrollPane(jtProcess,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JScrollPane scro_jtSelect = new JScrollPane(jtSelect,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JScrollPane scro_jtAnalyse = new JScrollPane(jtAnalyse,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		int width = window.getWidth();
		int height = window.getHeight();
		jpanel_window.setLayout(null);
		jpanel_window.add(scrollPane);
		scrollPane.setBounds(0, 0, width / 3, height / 3);
		jpanel_window.add(scro_jtExpression);
		scro_jtExpression.setBounds(width / 3, 0, width / 5, height / 5);
		jpanel_window.add(jb1);
		jb1.setBounds(width * 13 / 30, height * 1 / 5, width / 10, height / 15);
		// jb1.setFont(new Font("Serif",14,Font.BOLD));
		jb1.setText("符号串分析");
		jpanel_window.add(scro_jtProcess);
		scro_jtProcess.setBounds(width * 8 / 15, 0, width * 7 / 15, height / 3);
		// scro_jtProcess.setBackground(Color.PINK);
		jpanel_window.add(scro_jtFirstFollow);
		scro_jtFirstFollow.setBounds(0, height / 3, width / 3,
				height * 7 / 12 - 10);
		jpanel_window.add(scro_jtSelect);
		scro_jtSelect.setBounds(width / 3, height / 3, width / 3,
				height * 7 / 12 - 10);
		jpanel_window.add(scro_jtAnalyse);
		scro_jtAnalyse.setBounds(width * 2 / 3, height / 3, width / 3,
				height * 7 / 12 - 10);

		window.add(jpanel_window);

		menuBar.setBackground(Color.cyan);
		window.setJMenuBar(menuBar);
		window.setVisible(true);

		TxtFileFilter txtFilter = new TxtFileFilter();
		JavaFileFilter javaFilter = new JavaFileFilter();
		chooser.addChoosableFileFilter(txtFilter);
		chooser.addChoosableFileFilter(javaFilter);
		chooser.setFileView(new FileIconView(txtFilter, new ImageIcon("资源"
				+ File.separator + "图标007.jpg")));
		chooser.setFileView(new FileIconView(javaFilter, new ImageIcon("资源"
				+ File.separator + "图标008.jpg")));
		addAllListener();

	}

	private void addAllListener() {
		// 打开
		menuItem_file_open.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				open();
			}// actionPerformed
		});

		// 保存
		menuItem_file_save.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				save();
			}// actionPerformed

		});

		// 另存为
		menuItem_file_saveas.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				saveAs();
			}// actionPerformed
		});

		// 是文本域监听，不是popMenu
		textArea.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popMenu.show(e.getComponent(), e.getPoint().x,
							e.getPoint().y);
				}

			}

		});

		menuItem_menu_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textArea.equals("") || f_words == null) {
					JOptionPane.showMessageDialog(textArea, "在进行此法检测前请先保存文件!",
							"警告", JOptionPane.WARNING_MESSAGE);
				}

				else if (false == hasOpened) {
					save();
					hasOpened = true;
				}
				if (hasOpened == true) {
					writeInFile(f_words);
					h = new CharacterHandl(f_words);
					h.start();

					String stjtFirstFollow = "\tFIRST\t\tFOLLOW\r\n";
					jtFirstFollow.setText(stjtFirstFollow);
					stjtFirstFollow = "";
					for (int i = 0; i < h.getStartS().getSize(); i++) {
						stjtFirstFollow += h.getStartS().get(i);
						stjtFirstFollow += "\t";
						stjtFirstFollow += h.getmFirst()
								.get(h.getStartS().get(i)).MytoString();
						stjtFirstFollow += "\t\t";
						stjtFirstFollow += h.getmFollow()
								.get(h.getStartS().get(i)).MytoString();
						stjtFirstFollow += "\r\n";
						jtFirstFollow.append(stjtFirstFollow);
						stjtFirstFollow = "";
					}

					String stjtSelect = "\t\tSELECT\r\n";
					jtSelect.setText(stjtSelect);
					stjtSelect = "";
					String[] key;
					for (int i = 0; i < h.getKeyOfSelect().size(); i++) {
						key = h.getKeyOfSelect().get(i);
						stjtSelect += " SELECT ( " + key[0] + "→" + key[1]
								+ " ) = { "
								+ h.getmSelect().get(key).MytoString()
								+ " }\r\n";
						jtSelect.append(stjtSelect);
						stjtSelect = "";
					}
					if (h.isLL1 == false) {
						jtSelect.append("该文法不是LL(1)文法");
					} else
						jtSelect.append("\n\t该文法是LL(1)文法");
				}
			}// actionPerformed

		});
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (h == null || jtExpression.getText() == null
						|| jtExpression.getText().equals("")) {
					JOptionPane.showMessageDialog(jpanel_window, "请给出要分析的符号串!",
							"提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					jtProcess.setText("\t对符号串" + jtExpression.getText().trim()
							+ "的分析过程\r\n");
					LexicalAnalysis analysis = new LexicalAnalysis(h,
							jtExpression.getText().trim());
					analysis.startAnalyse();
					jtProcess.append(analysis.getToString());
				}

			}

		});

		menuItem_edit_time.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				textArea.insert((new Date()).toLocaleString(), 0);
			}

		});

		menuItem_edit_cut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String temp = textArea.getSelectedText();// 获得鼠标拖动选取的文本
				StringSelection text = new StringSelection(temp);// 把待剪切的文本传递给
																	// text 对象
				clipboard.setContents(text, null);// 将文本放入剪切板中
				int start = textArea.getSelectionStart();// 获取选中文本的开始位置
				int end = textArea.getSelectionEnd();// 获取选中文本的结束位置
				textArea.replaceRange("", start, end);// 选中的区域用""替换

			}

		});
		menuItem_edit_copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = textArea.getSelectedText();// 获得鼠标拖动选取的文本
				StringSelection text = new StringSelection(temp);// 把待剪切的文本传递给
																	// text 对象
				clipboard.setContents(text, null);// 将文本放入剪切板中

			}

		});
		menuItem_edit_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				String temp = textArea.getSelectedText();// 获得鼠标拖动选取的文本
				int start = textArea.getSelectionStart();
				int end = textArea.getSelectionEnd();
				textArea.replaceRange("", start, end);// 选中的区域用""替换
			}

		});
		menuItem_edit_paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transferable contexts = clipboard.getContents(this);// 获取剪切板中的内容
				DataFlavor flavor = DataFlavor.stringFlavor;// 剪切板的风格（系统的标准风格）
				if (contexts.isDataFlavorSupported(flavor))// 判断风格java是否可用
				{
					try {
						String str = (String) contexts.getTransferData(flavor);
						int n = textArea.getCaretPosition();// 获得文本中光标的位置
						textArea.replaceRange(str, n, n);// 替换光标所在位置的文本

					} catch (Exception ee) {
					}
				}

			}

		});
		menuItem_edit_selectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.selectAll();
			}

		});
	}// addAllListener

	private void writeInFile(File file) {
		String swrite = "";
		textArea.append("\0");
		for (int i = 0; i < textArea.getLineCount(); i++) {
			try {
				swrite += textArea.getText(textArea // getText(int offset,int
													// length)
						.getLineStartOffset(i), textArea.getLineEndOffset(i)
						- textArea.getLineStartOffset(i) - 1);
				swrite += "\n";
			} catch (BadLocationException ex) {
				ex.printStackTrace();
			}
		}

		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file, false);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(swrite);
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void save() {
		chooser.setCurrentDirectory(new File("."));
		int result = chooser.showSaveDialog(window);
		int result1 = 0;
		if (result == JFileChooser.APPROVE_OPTION) {
			f_words = null;
			String fileTypeDescription = chooser.getFileFilter()
					.getDescription();
			String fileType = null;
			String saveName = null;
			// 确定文件后缀名
			if (fileTypeDescription.equalsIgnoreCase("文本文件(*.txt)")) {
				int flag = chooser.getSelectedFile().getName().lastIndexOf(".");
				flag = (flag < 0 ? chooser.getSelectedFile().getName().length()
						: flag);// 第一次找不到的情况下flag为-1
				fileType = fileTypeDescription.substring(6, 10);
				saveName = chooser.getSelectedFile().getName()
						.substring(0, flag)
						+ fileType;
			} else if (fileTypeDescription.equalsIgnoreCase("java源文件(*.java)")) {
				int flag = chooser.getSelectedFile().getName().lastIndexOf("."); // 第一次找不到的情况下flag为-1
				flag = (flag < 0 ? chooser.getSelectedFile().getName().length()
						: flag);
				fileType = fileTypeDescription.substring(9, 14);
				saveName = chooser.getSelectedFile().getName()
						.substring(0, flag)
						+ fileType;
			}

			f_words = new File(chooser.getCurrentDirectory(), saveName);
			try {
				if (f_words != null && f_words.exists()) {
					result1 = JOptionPane.showConfirmDialog(chooser,
							"该文件已存在，确定要覆盖吗？", "提示",
							JOptionPane.OK_CANCEL_OPTION);
					if (result1 == JOptionPane.OK_OPTION) {
						// 有同名的文件，直接修改
						writeInFile(f_words);
					} else {
						// 什么也不做
					}
				} else {
					f_words.createNewFile();
					writeInFile(f_words);
				}
				if (result1 == JOptionPane.OK_OPTION) {
					// 能进行到这一步，说明信息保存成功，保存成功后，提示信息
					JOptionPane.showMessageDialog(chooser, "文件保存成功！", "提示",
							JOptionPane.INFORMATION_MESSAGE);
					// 将信息清空
					fileTypeDescription = null;
					fileType = null;
				}

			} catch (FileNotFoundException fe) {
				JOptionPane.showMessageDialog(chooser, "在指定目录下没有找到文件！", "提示",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(chooser, "修改文件出错！", "提示",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}// if(result==JFileChooser.APPROVE_OPTION)
	}// save

	private void saveAs() {
		chooser.setCurrentDirectory(new File("."));
		int result = chooser.showDialog(window, "另存为");
		int result1 = 0;
		if (result == JFileChooser.APPROVE_OPTION) {
			f_words = null;
			String fileTypeDescription = chooser.getFileFilter()
					.getDescription();
			String fileType = null;
			String saveName = null;
			// 确定文件后缀名
			if (fileTypeDescription.equalsIgnoreCase("文本文件(*.txt)")) {
				int flag = chooser.getSelectedFile().getName().lastIndexOf(".");
				flag = (flag < 0 ? chooser.getSelectedFile().getName().length()
						: flag);// 第一次找不到的情况下flag为-1
				fileType = fileTypeDescription.substring(6, 10);
				saveName = chooser.getSelectedFile().getName()
						.substring(0, flag)
						+ fileType;
			} else if (fileTypeDescription.equalsIgnoreCase("java源文件(*.java)")) {
				int flag = chooser.getSelectedFile().getName().lastIndexOf("."); // 第一次找不到的情况下flag为-1
				flag = (flag < 0 ? chooser.getSelectedFile().getName().length()
						: flag);
				fileType = fileTypeDescription.substring(9, 14);
				saveName = chooser.getSelectedFile().getName()
						.substring(0, flag)
						+ fileType;
			}

			f_words = new File(chooser.getCurrentDirectory(), saveName);
			try {
				if (f_words.exists()) {
					result1 = JOptionPane.showConfirmDialog(chooser,
							"该文件已存在，确定要覆盖吗？", "提示",
							JOptionPane.OK_CANCEL_OPTION);
					if (result1 == JOptionPane.OK_OPTION) {
						// 有同名的文件，直接修改
						writeInFile(f_words);
					} else {

					}
				} else {
					f_words.createNewFile();
					writeInFile(f_words);
				}
				if (result1 == JOptionPane.OK_OPTION) {
					// 能进行到这一步，说明信息保存成功，保存成功后，提示信息
					JOptionPane.showMessageDialog(chooser, "文件保存成功！", "提示",
							JOptionPane.INFORMATION_MESSAGE);
					// 将信息清空
					fileTypeDescription = null;
					fileType = null;
				}

			} catch (FileNotFoundException fe) {
				JOptionPane.showMessageDialog(chooser, "在指定目录下没有找到文件！", "提示",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(chooser, "修改文件出错！", "提示",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}// if(result==JFileChooser.APPROVE_OPTION)

	}// saveas

	private void open() {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		chooser.setCurrentDirectory(new File("."));
		int result = chooser.showOpenDialog(window);
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		if (result == JFileChooser.APPROVE_OPTION) {
			f_words = chooser.getSelectedFile();
			String contents = "";
			try {
				fileReader = new FileReader(f_words);
				bufferedReader = new BufferedReader(fileReader);
				while (bufferedReader.ready()) {
					contents += bufferedReader.readLine();
					contents += LINEFEED;
				}
				bufferedReader.close();
				fileReader.close();
				textArea.setText(null);
				textArea.setText(contents);
				hasOpened = true;
				menuItem_file_saveas.setEnabled(true);
			} catch (FileNotFoundException fe) {
				JOptionPane.showMessageDialog(window, "文件没有找到！请重新操作！", "提示",
						JOptionPane.INFORMATION_MESSAGE);
				// fe.printStackTrace();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(window, "文件操作出错！请重新选择！", "提示",
						JOptionPane.INFORMATION_MESSAGE);
				// closeEditor();
				// ie.printStackTrace();
			}
		}
	}// open

	public static void main(String... args) {
		new Notepad();
	}
}// Notepad结束

class JavaFileFilter extends FileFilter {
	public String getDescription() {
		return "java源文件(*.java)";
	}

	public boolean accept(File file) {
		String name = file.getName();
		return name.toLowerCase().endsWith(".java");
	}
}

class TxtFileFilter extends FileFilter {
	public String getDescription() {
		return "文本文件(*.txt)";
	}

	public boolean accept(File file) {
		String name = file.getName();
		return name.toLowerCase().endsWith(".txt");
	}
}

class FileIconView extends FileView {
	private FileFilter filter;
	private Icon icon;

	public FileIconView(FileFilter a_filter, Icon a_icon) {
		filter = a_filter;
		icon = a_icon;
	}

	public FileFilter getFilter() {
		return filter;
	}

	public Icon getIcon(File file) {
		if (!file.isDirectory() && filter.accept(file))
			return icon;
		else
			return null;
	}

}
