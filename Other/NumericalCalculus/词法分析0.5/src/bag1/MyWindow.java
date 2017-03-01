package bag1;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFrame;

/*
 * �ҵĴ���
 */
class MyWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private String title;
	private Image image;// ����ͼ��

	public MyWindow(String title, Image image) {
		super(title);
		this.title = title;
		this.image = image;
		Toolkit.getDefaultToolkit();
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		Toolkit.getDefaultToolkit();
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds(width / 4, height / 6, width / 2, height / 2);
		setVisible(true);
		setIconImage(image);
		addMyListener();
	}

	public MyWindow(String title, Image image, int a_x, int a_y, int a_width,
			int a_height) {
		super(title);
		this.title = title;
		this.image = image;

		setBounds(a_x, a_y, a_width, a_height);
		setVisible(true);
		setIconImage(image);
		addMyListener();
	}

	public MyWindow(int a_x, int a_y, int a_width, int a_height) {
		super("MyWindow");
		this.title = "MyWindow";
		this.image = null;

		setBounds(a_x, a_y, a_width, a_height);
		setVisible(true);
		setIconImage(image);
		addMyListener();
	}

	public MyWindow() {
		super("MyWindow");
		this.title = "MyWindow";
		this.image = null;
		Toolkit.getDefaultToolkit();
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		Toolkit.getDefaultToolkit();
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds(width / 4, height / 6, width / 2, height / 2);
		setIconImage(Toolkit.getDefaultToolkit().createImage(
				"��Դ" + File.separator + "ͼ��016.jpg"));
		setVisible(true);
		addMyListener();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	private void addMyListener() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}