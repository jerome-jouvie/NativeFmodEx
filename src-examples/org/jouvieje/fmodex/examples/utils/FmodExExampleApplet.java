package org.jouvieje.fmodex.examples.utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JApplet;

/**
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class FmodExExampleApplet extends JApplet implements End {
	private static final long serialVersionUID = 1L;
	
	private FmodExExample example;
	private Thread thread = null;

	public void init() {
		//Instanciate the fmod example choosed
		try {
			this.example = (FmodExExample)Class.forName(getParameter("fmodExample")).newInstance();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		example.setEnd(this);

		this.setSize(example.getPanel().getSize());
		this.setContentPane(example.getPanel());
		this.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) example.stop();
			}
		});
	}

	public void start() {
		thread = new Thread(example);
		example.init();
		thread.start();
	}

	public void stop() {
		if(example != null) {
			//Attempt to stop the thread if running
			if(thread != null) {
				while(thread.isAlive()) {
					example.sendStopCommand();
				}
				thread = null;
			}
			example.stop();
		}
	}
	
	public void end() {
		
	}
}
