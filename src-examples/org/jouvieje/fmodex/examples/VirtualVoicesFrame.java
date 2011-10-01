/*===============================================================================================
Virtual Voices Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example shows the virtual channels of FMOD. The listener and sounce sources can be moved
around by clicking and dragging. Sound sources will change colour depending on whether they
are virtual or not. Red means they are real, blue means they are virtual channels.
===============================================================================================*/

package org.jouvieje.fmodex.examples;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by J�r�me JOUVIE (Jouvieje.
 * 
 * @author J�r�me JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public abstract class VirtualVoicesFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private String TITLE = "Virtual Voices Example. Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.";
	int WIDTH = 640;
	int HEIGHT = 480;

	private JPanel jContentPane = null;
	private Timer timer = null;

	public VirtualVoicesFrame() {
		super();
		initialize();
	}

	private void initialize() {
		this.setTitle(TITLE);
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	protected JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new JPanel() {
				private static final long serialVersionUID = 1L;
				
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.setColor(getJContentPane().getBackground());
					draw(g);
				}
			};
			jContentPane.setFont(new Font("Courier New", Font.PLAIN, 12));
			jContentPane.addMouseListener(new MouseAdapter(){
				public void mouseReleased(MouseEvent e) {
					VirtualVoicesFrame.this.mouseReleased(e);
				}

				public void mousePressed(MouseEvent e) {
					VirtualVoicesFrame.this.mousePressed(e);
				}
			});
			jContentPane.addMouseMotionListener(new MouseMotionAdapter(){
				public void mouseDragged(MouseEvent e) {
					VirtualVoicesFrame.this.mouseDragged(e);
				}
			});
		}
		return jContentPane;
	}

	protected Timer getTimer() {
		if(timer == null) {
			timer = new Timer(10, new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					ontimer();
				}
			});
		}
		return timer;
	}

	public abstract void ontimer();
	public abstract void draw(Graphics g);
	public abstract void mousePressed(MouseEvent e);
	public abstract void mouseReleased(MouseEvent e);
	public abstract void mouseDragged(MouseEvent e);
}