package jp.lancher.client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import jp.lancher.client.models.TabItemModel;

public class Button extends JButton {

	private TabItemModel TabItemModel = null;

	public Button(TabItemModel item) {
		this.TabItemModel = item;

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				execute();
			}

			private void execute() {
				try {
					String os = System.getProperty("os.name");
					String[] cmd = new String[3];
					if (os.equals("Mac OS X")) {
						cmd[0] = "/bin/sh";
						cmd[1] = "-c";
						cmd[2] = "\"open $0\"".replace("$0", item.getPath());
					} else {
						cmd[0] = "cmd";
						cmd[1] = "/c";
						cmd[2] = item.getPath();
					}
					Runtime runtime = Runtime.getRuntime(); // ランタイムオブジェクトを取得する
					runtime.exec(cmd); // 指定したコマンドを実行する
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
