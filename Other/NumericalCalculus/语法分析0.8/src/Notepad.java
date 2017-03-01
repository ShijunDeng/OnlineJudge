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
 * �﷨��������
 * @version 0.5 2012-04-12
 * @author XiaoDeng
 */
public class Notepad {
	private static final int X_START = 40;
	private static final int Y_START = 20;
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 650;
	private static final String LINEFEED = "\r\n";// ����
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

	private File f_words;// ���ݸ�classifyWords

	private boolean hasOpened = false;
	Clipboard clipboard = null;// ����һ�����а����
	CharacterHandl h;

	public Notepad() {
		image = Toolkit.getDefaultToolkit().createImage(
				"��Դ" + File.separator + "ͼ��012.png");
		window = new MyWindow("�﷨����", image, X_START, Y_START, WIDTH, HEIGHT);
		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();// ���ϵͳ�ļ��а�
		menuBar = new JMenuBar();
		menu_file = new JMenu("�ļ� (F)");
		menu_file.setMnemonic('F');
		menu_edit = new JMenu("�༭(E)");
		menu_edit.setMnemonic('E');
		menu_check = new JMenu("���(C)");
		menu_check.setMnemonic('C');
		menu_look = new JMenu("�鿴(V)");
		menu_look.setMnemonic('V');
		menu_help = new JMenu("����(H)");
		menu_help.setMnemonic('H');
		// ��Ӳ˵�
		menuBar.add(menu_file);
		menuBar.add(menu_edit);
		menuBar.add(menu_check);
		menuBar.add(menu_look);
		menuBar.add(menu_help);
		// ����ļ��˵���
		menuItem_file_open = menu_file.add("��");
		menuItem_file_open.setAccelerator(KeyStroke.getKeyStroke("ctrl+ o"));
		menuItem_file_save = menu_file.add("����");// �˵�����ص��÷�
		menuItem_file_save.setAccelerator(KeyStroke.getKeyStroke("ctrl+ s"));
		menuItem_file_saveas = menu_file.add("���Ϊ");
		menu_file.addSeparator();
		menuItem_file_print = menu_file.add("��ӡ");
		menuItem_file_exit = menu_file.add("�˳�");
		// ��ӱ༭�˵���
		menuItem_edit_cancel = menu_edit.add("ȡ��");
		menuItem_edit_cut = menu_edit.add("����");
		menuItem_edit_copy = menu_edit.add("����");
		menuItem_edit_paste = menu_edit.add("ճ��");
		menuItem_edit_delete = menu_edit.add("ɾ��");
		menuItem_edit_search = menu_edit.add("����");
		menuItem_edit_searchNext = menu_edit.add("������һ��");
		menuItem_edit_replace = menu_edit.add("�滻");
		menuItem_edit_goto = menu_edit.add("ת��");
		menuItem_edit_selectAll = menu_edit.add("ȫѡ");
		menuItem_edit_time = menu_edit.add("ʱ��" + File.separator + "����");

		// �����˵���
		menuItem_menu_check = menu_check.add("LL(1)�ķ��б�");
		// ��ӵ����˵�
		popMenu.add(menuItem_edit_cancel);
		popMenu.add(menuItem_edit_cut);
		popMenu.add(menuItem_edit_copy);
		popMenu.add(menuItem_edit_paste);
		popMenu.addSeparator();
		popMenu.add(menuItem_edit_delete);

		chooser = new JFileChooser();

		jb1 = new JButton();
		// ����ı���

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
		// textArea.setFont(new Font("Serif",14,Font.PLAIN ));//�����ã���֪��Ϊʲô
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
		jb1.setText("���Ŵ�����");
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
		chooser.setFileView(new FileIconView(txtFilter, new ImageIcon("��Դ"
				+ File.separator + "ͼ��007.jpg")));
		chooser.setFileView(new FileIconView(javaFilter, new ImageIcon("��Դ"
				+ File.separator + "ͼ��008.jpg")));
		addAllListener();

	}

	private void addAllListener() {
		// ��
		menuItem_file_open.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				open();
			}// actionPerformed
		});

		// ����
		menuItem_file_save.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				save();
			}// actionPerformed

		});

		// ���Ϊ
		menuItem_file_saveas.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				saveAs();
			}// actionPerformed
		});

		// ���ı������������popMenu
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
					JOptionPane.showMessageDialog(textArea, "�ڽ��д˷����ǰ���ȱ����ļ�!",
							"����", JOptionPane.WARNING_MESSAGE);
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
						stjtSelect += " SELECT ( " + key[0] + "��" + key[1]
								+ " ) = { "
								+ h.getmSelect().get(key).MytoString()
								+ " }\r\n";
						jtSelect.append(stjtSelect);
						stjtSelect = "";
					}
					if (h.isLL1 == false) {
						jtSelect.append("���ķ�����LL(1)�ķ�");
					} else
						jtSelect.append("\n\t���ķ���LL(1)�ķ�");
				}
			}// actionPerformed

		});
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (h == null || jtExpression.getText() == null
						|| jtExpression.getText().equals("")) {
					JOptionPane.showMessageDialog(jpanel_window, "�����Ҫ�����ķ��Ŵ�!",
							"��ʾ", JOptionPane.INFORMATION_MESSAGE);
				} else {
					jtProcess.setText("\t�Է��Ŵ�" + jtExpression.getText().trim()
							+ "�ķ�������\r\n");
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

				String temp = textArea.getSelectedText();// �������϶�ѡȡ���ı�
				StringSelection text = new StringSelection(temp);// �Ѵ����е��ı����ݸ�
																	// text ����
				clipboard.setContents(text, null);// ���ı�������а���
				int start = textArea.getSelectionStart();// ��ȡѡ���ı��Ŀ�ʼλ��
				int end = textArea.getSelectionEnd();// ��ȡѡ���ı��Ľ���λ��
				textArea.replaceRange("", start, end);// ѡ�е�������""�滻

			}

		});
		menuItem_edit_copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = textArea.getSelectedText();// �������϶�ѡȡ���ı�
				StringSelection text = new StringSelection(temp);// �Ѵ����е��ı����ݸ�
																	// text ����
				clipboard.setContents(text, null);// ���ı�������а���

			}

		});
		menuItem_edit_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				String temp = textArea.getSelectedText();// �������϶�ѡȡ���ı�
				int start = textArea.getSelectionStart();
				int end = textArea.getSelectionEnd();
				textArea.replaceRange("", start, end);// ѡ�е�������""�滻
			}

		});
		menuItem_edit_paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transferable contexts = clipboard.getContents(this);// ��ȡ���а��е�����
				DataFlavor flavor = DataFlavor.stringFlavor;// ���а�ķ��ϵͳ�ı�׼���
				if (contexts.isDataFlavorSupported(flavor))// �жϷ��java�Ƿ����
				{
					try {
						String str = (String) contexts.getTransferData(flavor);
						int n = textArea.getCaretPosition();// ����ı��й���λ��
						textArea.replaceRange(str, n, n);// �滻�������λ�õ��ı�

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
			// ȷ���ļ���׺��
			if (fileTypeDescription.equalsIgnoreCase("�ı��ļ�(*.txt)")) {
				int flag = chooser.getSelectedFile().getName().lastIndexOf(".");
				flag = (flag < 0 ? chooser.getSelectedFile().getName().length()
						: flag);// ��һ���Ҳ����������flagΪ-1
				fileType = fileTypeDescription.substring(6, 10);
				saveName = chooser.getSelectedFile().getName()
						.substring(0, flag)
						+ fileType;
			} else if (fileTypeDescription.equalsIgnoreCase("javaԴ�ļ�(*.java)")) {
				int flag = chooser.getSelectedFile().getName().lastIndexOf("."); // ��һ���Ҳ����������flagΪ-1
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
							"���ļ��Ѵ��ڣ�ȷ��Ҫ������", "��ʾ",
							JOptionPane.OK_CANCEL_OPTION);
					if (result1 == JOptionPane.OK_OPTION) {
						// ��ͬ�����ļ���ֱ���޸�
						writeInFile(f_words);
					} else {
						// ʲôҲ����
					}
				} else {
					f_words.createNewFile();
					writeInFile(f_words);
				}
				if (result1 == JOptionPane.OK_OPTION) {
					// �ܽ��е���һ����˵����Ϣ����ɹ�������ɹ�����ʾ��Ϣ
					JOptionPane.showMessageDialog(chooser, "�ļ�����ɹ���", "��ʾ",
							JOptionPane.INFORMATION_MESSAGE);
					// ����Ϣ���
					fileTypeDescription = null;
					fileType = null;
				}

			} catch (FileNotFoundException fe) {
				JOptionPane.showMessageDialog(chooser, "��ָ��Ŀ¼��û���ҵ��ļ���", "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(chooser, "�޸��ļ�����", "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}// if(result==JFileChooser.APPROVE_OPTION)
	}// save

	private void saveAs() {
		chooser.setCurrentDirectory(new File("."));
		int result = chooser.showDialog(window, "���Ϊ");
		int result1 = 0;
		if (result == JFileChooser.APPROVE_OPTION) {
			f_words = null;
			String fileTypeDescription = chooser.getFileFilter()
					.getDescription();
			String fileType = null;
			String saveName = null;
			// ȷ���ļ���׺��
			if (fileTypeDescription.equalsIgnoreCase("�ı��ļ�(*.txt)")) {
				int flag = chooser.getSelectedFile().getName().lastIndexOf(".");
				flag = (flag < 0 ? chooser.getSelectedFile().getName().length()
						: flag);// ��һ���Ҳ����������flagΪ-1
				fileType = fileTypeDescription.substring(6, 10);
				saveName = chooser.getSelectedFile().getName()
						.substring(0, flag)
						+ fileType;
			} else if (fileTypeDescription.equalsIgnoreCase("javaԴ�ļ�(*.java)")) {
				int flag = chooser.getSelectedFile().getName().lastIndexOf("."); // ��һ���Ҳ����������flagΪ-1
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
							"���ļ��Ѵ��ڣ�ȷ��Ҫ������", "��ʾ",
							JOptionPane.OK_CANCEL_OPTION);
					if (result1 == JOptionPane.OK_OPTION) {
						// ��ͬ�����ļ���ֱ���޸�
						writeInFile(f_words);
					} else {

					}
				} else {
					f_words.createNewFile();
					writeInFile(f_words);
				}
				if (result1 == JOptionPane.OK_OPTION) {
					// �ܽ��е���һ����˵����Ϣ����ɹ�������ɹ�����ʾ��Ϣ
					JOptionPane.showMessageDialog(chooser, "�ļ�����ɹ���", "��ʾ",
							JOptionPane.INFORMATION_MESSAGE);
					// ����Ϣ���
					fileTypeDescription = null;
					fileType = null;
				}

			} catch (FileNotFoundException fe) {
				JOptionPane.showMessageDialog(chooser, "��ָ��Ŀ¼��û���ҵ��ļ���", "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(chooser, "�޸��ļ�����", "��ʾ",
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
				JOptionPane.showMessageDialog(window, "�ļ�û���ҵ��������²�����", "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);
				// fe.printStackTrace();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(window, "�ļ���������������ѡ��", "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);
				// closeEditor();
				// ie.printStackTrace();
			}
		}
	}// open

	public static void main(String... args) {
		new Notepad();
	}
}// Notepad����

class JavaFileFilter extends FileFilter {
	public String getDescription() {
		return "javaԴ�ļ�(*.java)";
	}

	public boolean accept(File file) {
		String name = file.getName();
		return name.toLowerCase().endsWith(".java");
	}
}

class TxtFileFilter extends FileFilter {
	public String getDescription() {
		return "�ı��ļ�(*.txt)";
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
