package bag1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import javax.swing.text.BadLocationException;

/*
 * �ʷ���������
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
	private JMenuItem menuItem_file_print;
	private JMenuItem menuItem_file_exit;

	private JMenuItem menuItem_edit_cancel;
	private JMenuItem menuItem_edit_cut;
	private JMenuItem menuItem_edit_copy;
	private JMenuItem menuItem_edit_paste;
	private JMenuItem menuItem_edit_delete;
	private JMenuItem menuItem_edit_search;
	private JMenuItem menuItem_edit_replace;
	private JMenuItem menuItem_edit_selectAll;
	private JMenuItem menuItem_edit_searchNext;
	private JMenuItem menuItem_edit_goto;
	private JMenuItem menuItem_edit_time;
	private JMenuItem menuItem_menu_check;
	private JPanel jpanel_textArea;
	private JPanel jpanel_jtKINOS;
	private JPanel jpanel_window;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JTextArea jtK;
	private JTextArea jtS;
	private JTextArea jtN;
	private JTextArea jtO;
	private JTextArea jtI;

	private JFileChooser chooser;

	private File f_words;// ���ݸ�classifyWords
	private ClassifyWords classifyWords;

	private boolean hasOpened = false;
	Clipboard clipboard = null;// ����һ�����а����

	public Notepad() {
		image = Toolkit.getDefaultToolkit().createImage(
				"��Դ" + File.separator + "ͼ��012.png");
		window = new MyWindow("�ʷ�����", image, X_START, Y_START, WIDTH, HEIGHT);
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
		menuItem_menu_check = menu_check.add("�ʷ�����");
		// ��ӵ����˵�
		popMenu.add(menuItem_edit_cancel);
		popMenu.add(menuItem_edit_cut);
		popMenu.add(menuItem_edit_copy);
		popMenu.add(menuItem_edit_paste);
		popMenu.addSeparator();
		popMenu.add(menuItem_edit_delete);

		chooser = new JFileChooser();
		// ����ı���
		jpanel_textArea = new JPanel();
		jpanel_jtKINOS = new JPanel();
		jpanel_window = new JPanel();
		textArea = new JTextArea();

		jtS = new JTextArea();
		jtN = new JTextArea();
		jtI = new JTextArea();
		jtO = new JTextArea();
		jtK = new JTextArea();

		jtS.setEditable(false);
		jtK.setEditable(false);
		jtN.setEditable(false);
		jtI.setEditable(false);
		jtO.setEditable(false);
		// textArea.setFont(new Font("Serif",14,Font.PLAIN ));//�����ã���֪��Ϊʲô
		textArea.setEditable(true);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane = new JScrollPane(textArea,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		jpanel_textArea.setLayout(new BorderLayout());
		jpanel_textArea.add(scrollPane, BorderLayout.CENTER);

		JScrollPane scro_jtK = new JScrollPane(jtK,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JScrollPane scro_jtN = new JScrollPane(jtN,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JScrollPane scro_jtS = new JScrollPane(jtS,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JScrollPane scro_jtO = new JScrollPane(jtO,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JScrollPane scro_jtI = new JScrollPane(jtI,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		jpanel_jtKINOS.setLayout(new GridLayout(1, 6));
		jpanel_jtKINOS.add(scro_jtK);
		jpanel_jtKINOS.add(scro_jtI);
		jpanel_jtKINOS.add(scro_jtN);
		jpanel_jtKINOS.add(scro_jtO);
		jpanel_jtKINOS.add(scro_jtS);

		jpanel_window.setLayout(new GridLayout(2, 1));
		jpanel_window.add(jpanel_textArea);
		jpanel_window.add(jpanel_jtKINOS);
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
				if (textArea.equals("")||f_words==null) {
					JOptionPane.showMessageDialog(textArea, "�ڽ��д˷����ǰ���ȱ����ļ�!", "����",
							JOptionPane.WARNING_MESSAGE);
				}

				else if (false == hasOpened) {
					save();
					hasOpened = true;
				}
				if (hasOpened == true) {

					writeInFile(f_words);
					classifyWords = new ClassifyWords(f_words);
					classifyWords.classify();
					classifyWords.writeIntoFile();
					jtK.setText(classifyWords.getsK());
					jtK.append(LINEFEED + "��������"
							+ classifyWords.getKeyWords().size() + "���ؼ���");
					jtI.setText(classifyWords.getsI());
					jtI.append(LINEFEED + "��������"
							+ classifyWords.getIdentifiers().size() + "����ʶ��");
					jtN.setText(classifyWords.getsN());
					jtN.append(LINEFEED + "��������"
							+ classifyWords.getNumber().size() + "������");
					jtO.setText(classifyWords.getsO());
					jtO.append(LINEFEED + "��������"
							+ classifyWords.getOperator().size() + "��������");
					jtS.setText(classifyWords.getsS());
					jtS.append(LINEFEED + "��������"
							+ classifyWords.getSeparator().size() + "���ؼ���");

				}

			}

		});

		menuItem_file_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result1;
				result1 = JOptionPane.showConfirmDialog(chooser, "ȷ�����Ķ����浽"
						+ f_words.getAbsolutePath() + "��", "��ʾ",
						JOptionPane.OK_CANCEL_OPTION);
				if (result1 == JOptionPane.OK_OPTION) {
					writeInFile(f_words);
					System.exit(0);
				} else {

				}
			}

		});

		menuItem_edit_time.addActionListener(new ActionListener() {
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
				if (f_words.exists()) {
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
