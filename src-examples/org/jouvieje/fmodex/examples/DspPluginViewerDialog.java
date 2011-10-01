/*===============================================================================================
DSP Plugin Viewer Example
Copyright (c), Firelight Technologies Pty, Ltd 2004-2010.

This example ....
===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.enumerations.FMOD_OUTPUTTYPE.FMOD_OUTPUTTYPE_ALSA;
import static org.jouvieje.fmodex.enumerations.FMOD_OUTPUTTYPE.FMOD_OUTPUTTYPE_ASIO;
import static org.jouvieje.fmodex.enumerations.FMOD_OUTPUTTYPE.FMOD_OUTPUTTYPE_COREAUDIO;
import static org.jouvieje.fmodex.enumerations.FMOD_OUTPUTTYPE.FMOD_OUTPUTTYPE_DSOUND;
import static org.jouvieje.fmodex.enumerations.FMOD_OUTPUTTYPE.FMOD_OUTPUTTYPE_ESD;
import static org.jouvieje.fmodex.enumerations.FMOD_OUTPUTTYPE.FMOD_OUTPUTTYPE_NOSOUND;
import static org.jouvieje.fmodex.enumerations.FMOD_OUTPUTTYPE.FMOD_OUTPUTTYPE_OSS;
import static org.jouvieje.fmodex.enumerations.FMOD_OUTPUTTYPE.FMOD_OUTPUTTYPE_WINMM;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import org.jouvieje.fmodex.enumerations.FMOD_OUTPUTTYPE;
import org.jouvieje.libloader.LibLoader;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class DspPluginViewerDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private FMOD_OUTPUTTYPE outputType = null;

	private JPanel jContentPane = null; //  @jve:decl-index=0:visual-constraint="10,10"
	private JRadioButton asioButton = null;
	private JRadioButton winButton = null;
	private JRadioButton dsButton = null;
	private JButton okButton = null;
	private JButton cancelButton = null;

	public DspPluginViewerDialog() {
		super((Frame)null, true);
		initialize();
	}

	private void initialize() {
		this.setSize(283, 160);
		this.setTitle("Select your output");
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(getJContentPane());
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				outputType = null;
			}
		});
	}

	private JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setSize(257, 139);

			ButtonGroup group = new ButtonGroup();
			group.add(getDsButton());
			group.add(getWinButton());
			group.add(getAsioButton());

			jContentPane.add(getDsButton());
			jContentPane.add(getWinButton());
			if(LibLoader.getPlatform() != LibLoader.PLATFORM_MAC) {
				jContentPane.add(getAsioButton());
			}
			jContentPane.add(getOkButton());
			jContentPane.add(getCancelButton());
		}
		return jContentPane;
	}

	private JRadioButton getAsioButton() {
		if(asioButton == null) {
			asioButton = new JRadioButton();
			switch (LibLoader.getPlatform()) {
				case LibLoader.PLATFORM_WINDOWS:
					asioButton.setText("ASIO low latency");
					break;
				case LibLoader.PLATFORM_LINUX:
					asioButton.setText("ALSA (Advanced Linux Sound Architecture)");
					break;
				case LibLoader.PLATFORM_MAC:
					asioButton.setText("No Sound");
					asioButton.setVisible(false);
					asioButton.setEnabled(false);
					break;
			}
			asioButton.setBounds(10, 80, 125, 24);
			asioButton.addChangeListener(new javax.swing.event.ChangeListener(){
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					refreshOutputType();
				}
			});
		}
		return asioButton;
	}

	private JRadioButton getWinButton() {
		if(winButton == null) {
			winButton = new JRadioButton();
			switch (LibLoader.getPlatform()) {
				case LibLoader.PLATFORM_WINDOWS:
					winButton.setText("WinMM");
					break;
				case LibLoader.PLATFORM_LINUX:
					winButton.setText("ESD (Enlightment Sound Deamon)");
					break;
				case LibLoader.PLATFORM_MAC:
					winButton.setText("Macintosh CoreAudio");
					break;
			}
			winButton.setBounds(10, 50, 70, 24);
			winButton.addChangeListener(new javax.swing.event.ChangeListener(){
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					refreshOutputType();
				}
			});
		}
		return winButton;
	}

	private JRadioButton getDsButton() {
		if(dsButton == null) {
			dsButton = new JRadioButton();
			switch (LibLoader.getPlatform()) {
				case LibLoader.PLATFORM_WINDOWS:
					dsButton.setText("DirectSound");
					break;
				case LibLoader.PLATFORM_LINUX:
					dsButton.setText("OSS (Open Sound System)");
					break;
				case LibLoader.PLATFORM_MAC:
					dsButton.setText("Mac SoundManager");
					break;
			}
			dsButton.setSelected(true);
			dsButton.setBounds(10, 20, 100, 24);
			dsButton.addChangeListener(new javax.swing.event.ChangeListener(){
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					refreshOutputType();
				}
			});
		}
		return dsButton;
	}

	private JButton getOkButton() {
		if(okButton == null) {
			okButton = new JButton();
			okButton.setText("Ok");
			okButton.setBounds(155, 30, 90, 29);
			okButton.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e) {
					refreshOutputType();
					DspPluginViewerDialog.this.dispose();
				}
			});
		}
		return okButton;
	}

	private JButton getCancelButton() {
		if(cancelButton == null) {
			cancelButton = new JButton();
			cancelButton.setText("Cancel");
			cancelButton.setBounds(155, 70, 90, 26);
			cancelButton.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e) {
					outputType = null;
					DspPluginViewerDialog.this.dispose();
				}
			});
		}
		return cancelButton;
	}

	private void refreshOutputType() {
		switch (LibLoader.getPlatform()) {
			case LibLoader.PLATFORM_WINDOWS:
				if(getDsButton().isSelected()) {
					outputType = FMOD_OUTPUTTYPE_DSOUND;
					return;
				}
				else if(getWinButton().isSelected()) {
					outputType = FMOD_OUTPUTTYPE_WINMM;
					return;
				}
				else if(getAsioButton().isSelected()) {
					outputType = FMOD_OUTPUTTYPE_ASIO;
					return;
				}
				break;
			case LibLoader.PLATFORM_LINUX:
				if(getDsButton().isSelected()) {
					outputType = FMOD_OUTPUTTYPE_OSS;
					return;
				}
				else if(getWinButton().isSelected()) {
					outputType = FMOD_OUTPUTTYPE_ESD;
					return;
				}
				else if(getAsioButton().isSelected()) {
					outputType = FMOD_OUTPUTTYPE_ALSA;
					return;
				}
				break;
			case LibLoader.PLATFORM_MAC:
				if(getDsButton().isSelected()) {
					outputType = FMOD_OUTPUTTYPE_COREAUDIO;
					return;
				}
				else if(getWinButton().isSelected()) {
					outputType = FMOD_OUTPUTTYPE_NOSOUND;
					return;
				}
				break;
		}
	}

	protected FMOD_OUTPUTTYPE getOutputType() {
		return outputType;
	}
} //  @jve:decl-index=0:visual-constraint="10,10"