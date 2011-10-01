package org.jouvieje.fmodex.examples.utils;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class FmodExExampleFrame extends JFrame implements End {
	private static final long serialVersionUID = 1L;
	private final FmodExExample example;
	private final Thread thread;

	public FmodExExampleFrame(FmodExExample example) {
		super();
		this.example = example;
		this.thread = new Thread(example);
		
		initialize();
		this.setVisible(true);

		example.setEnd(this);
		this.example.init();
		this.thread.start();
	}

	protected void initialize() {
		this.setTitle(example.getTitle());
		this.setSize(example.getPanel().getSize());
//		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setContentPane(example.getPanel());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				new Thread() {	//Avoid to freeze the GUI
					public void run() {
						stopExample();
					}
				};
			}
		});
	}
	
	private void stopExample() {
		//Attempt to stop the thread if running
		if(thread != null) {
			while(thread.isAlive()) {
				example.sendStopCommand();
			}
		}
		example.stop();
	}
	
	public void end() {
		try {
			System.exit(0);
		} catch(SecurityException e) {}
	}
}
