package wangshuo.program;

import javax.media.*;
import java.io.*;
import java.net.URL;
/*@author:��˷
 *@time:2012-05-11
 * ��������
 */
class MusicPlayer implements ControllerListener {
	// ���Ŷ���
	private Player player;
	private URL url;
	private boolean play = true;

	public MusicPlayer(URL url) {

		this.url = url;

	}

	// ���ŷ���
	public void play() {
		try {
			player = Manager.createPlayer(url);
		} catch (NoPlayerException e) {
			e.printStackTrace();
			System.out.println("���ܲ��Ŵ��ļ���");
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		if (player == null) {
			System.out.println("�����ļ�Ϊ�գ�");
			return;
		}
		player.addControllerListener(this);
		player.prefetch();
		if (play == true)
			player.start();
	}

	public void controllerUpdate(ControllerEvent e) {
		if (e instanceof EndOfMediaEvent) {
			this.play();
		}
	}

	public void stop() {
		player.stop();
	}

	public void setPlayer(boolean b) {
		this.play = b;
	}
}
