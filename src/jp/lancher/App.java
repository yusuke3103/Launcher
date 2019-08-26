package jp.lancher;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

import jp.lancher.client.ui.MainFrame;
import jp.lancher.utils.MessageUtil;

public class App {

	public static MainFrame mainFrame;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					this.setTray();

					mainFrame = new MainFrame();
					mainFrame.setVisible(true);

				} catch (Exception e) {
					MessageUtil.showMessage("異常終了:" + e.getMessage());
				}
			}

			private void setTray() throws Exception {

				SystemTray tray = SystemTray.getSystemTray();
				PopupMenu popup = new PopupMenu();

				URL url = ClassLoader.getSystemResource("icon.png");
				Image image = Toolkit.getDefaultToolkit().createImage(url);

				TrayIcon icon = new TrayIcon(image, "Lancher", popup);
				icon.setImageAutoSize(true);

				MenuItem setting = new MenuItem("設定");
				setting.setActionCommand("SETTING");
				setting.addActionListener(new IActionListener());

				MenuItem exit = new MenuItem("終了");
				exit.setActionCommand("EXIT");

				popup.add(setting);
				popup.add(exit);

			}
		});
	}
}

class IActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("SETTING")) {
			JFrame f = new JFrame();
			f.setVisible(true);
		}

	}
}