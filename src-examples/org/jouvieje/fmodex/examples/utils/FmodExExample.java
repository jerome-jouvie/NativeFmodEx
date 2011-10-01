package org.jouvieje.fmodex.examples.utils;

import javax.swing.JPanel;

/**
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public interface FmodExExample extends Runnable {
	public void setEnd(End end);
	public String getTitle();
	public JPanel getPanel();
	public void init();
	public void stop();
	public boolean isRunning();
	public void sendStopCommand();
}
