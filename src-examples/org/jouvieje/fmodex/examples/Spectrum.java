package org.jouvieje.fmodex.examples;

import static java.lang.System.exit;
import static java.lang.System.out;
import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_2D;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_SOFTWARE;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_MODORDER;
import static org.jouvieje.fmodex.defines.FMOD_TIMEUNIT.FMOD_TIMEUNIT_MS;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_DSP_FFT_WINDOW.FMOD_DSP_FFT_WINDOW_TRIANGLE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.newFloatBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.newIntBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;

import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.System;

import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.exceptions.InitException;

/**
 * Based on FMOD Ex C++ example. Ported to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje.
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class Spectrum extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public final static int GRAPHICWINDOW_WIDTH = 128;
	public final static int GRAPHICWINDOW_HEIGHT = 50;
	private Dimension plotDimension = new Dimension(GRAPHICWINDOW_WIDTH, GRAPHICWINDOW_HEIGHT);

	private JPanel jContentPane = null;
	private JPanel analyserPanel = null;
	private JPanel spectrum = null;
	private JPanel osciloscope = null;
	private JPanel filePanel = null;
	private JPanel filePanel1 = null;
	private JTextField filePath = null;
	private JPanel buttonPanel = null;
	private JButton open = null;
	private JButton playStop = null;
	private JButton pause = null;
	private JPanel progressP = null;
	private JProgressBar progressBar = null;

	public Spectrum() {
		super();
		initialize();
	}

	private void initialize() {
		this.setTitle("Spectrum");
		this.setSize(320, 220);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setContentPane(getJContentPane());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BoxLayout(jContentPane, BoxLayout.Y_AXIS));
			jContentPane.add(getAnalyserPanel());
			jContentPane.add(getFilePanel());
		}
		return jContentPane;
	}

	private JPanel getAnalyserPanel() {
		if(analyserPanel == null) {
			GridBagConstraints constraintSpectrum = new GridBagConstraints();
			constraintSpectrum.anchor = GridBagConstraints.CENTER;
			constraintSpectrum.gridx = 0;
			constraintSpectrum.gridy = 0;
			constraintSpectrum.weightx = 1;
			constraintSpectrum.weighty = 1;
			GridBagConstraints constraintOsciloscope = new GridBagConstraints();
			constraintSpectrum.anchor = GridBagConstraints.CENTER;
			constraintOsciloscope.gridx = 1;
			constraintOsciloscope.gridy = 0;
			constraintOsciloscope.weightx = 1;
			constraintOsciloscope.weighty = 1;
			analyserPanel = new JPanel();
			analyserPanel.setLayout(new GridBagLayout());
			analyserPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analyser",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			analyserPanel.setPreferredSize(new java.awt.Dimension(450, 160));
			analyserPanel.add(getSpectrum(), constraintSpectrum);
			analyserPanel.add(getOsciloscope(), constraintOsciloscope);
		}
		return analyserPanel;
	}

	protected JPanel getSpectrum() {
		if(spectrum == null) {
			spectrum = new JPanel();
			spectrum.setBackground(java.awt.Color.black);
			spectrum.setMinimumSize(plotDimension);
			spectrum.setPreferredSize(plotDimension);
			spectrum.setMaximumSize(plotDimension);
		}
		return spectrum;
	}

	protected JPanel getOsciloscope() {
		if(osciloscope == null) {
			osciloscope = new JPanel();
			osciloscope.setBackground(java.awt.Color.black);
			osciloscope.setMinimumSize(plotDimension);
			osciloscope.setPreferredSize(plotDimension);
			osciloscope.setMaximumSize(plotDimension);
		}
		return osciloscope;
	}

	private JPanel getFilePanel() {
		if(filePanel == null) {
			filePanel = new JPanel();
			filePanel.setLayout(new BoxLayout(filePanel, BoxLayout.Y_AXIS));
			filePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Audio file to play",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			filePanel.setMaximumSize(new java.awt.Dimension(2000, 110));
			filePanel.setPreferredSize(new java.awt.Dimension(450, 110));
			filePanel.setMinimumSize(new java.awt.Dimension(450, 110));
			filePanel.add(getFilePanel1());
			filePanel.add(getButtonPanel());
			filePanel.add(getProgressP());
		}
		return filePanel;
	}

	private JPanel getFilePanel1() {
		if(filePanel1 == null) {
			filePanel1 = new JPanel();
			filePanel1.setLayout(new BorderLayout());
			filePanel1.add(getFilePath(), BorderLayout.CENTER);
			filePanel1.add(getOpen(), BorderLayout.EAST);
		}
		return filePanel1;
	}

	protected JTextField getFilePath() {
		if(filePath == null) {
			filePath = new JTextField();
			filePath.setEditable(false);
		}
		return filePath;
	}

	private JButton getOpen() {
		if(open == null) {
			open = new JButton();
			open.setText("...");
			open.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e) {
					open();
				}
			});
		}
		return open;
	}

	private JPanel getButtonPanel() {
		if(buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.add(getPlayStop());
			buttonPanel.add(getPause());
		}
		return buttonPanel;
	}

	protected JButton getPlayStop() {
		if(playStop == null) {
			playStop = new JButton();
			playStop.setText("Play");
			playStop.setPreferredSize(new Dimension(80, 24));
			playStop.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e) {
					playStop();
				}
			});
		}
		return playStop;
	}

	protected JButton getPause() {
		if(pause == null) {
			pause = new JButton();
			pause.setText("Pause");
			pause.setPreferredSize(new Dimension(80, 24));
			pause.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e) {
					pause();
				}
			});
		}
		return pause;
	}

	private JPanel getProgressP() {
		if(progressP == null) {
			progressP = new JPanel();
			progressP.setLayout(new BorderLayout());
			progressP.add(getProgressBar(), java.awt.BorderLayout.CENTER);
		}
		return progressP;
	}

	protected JProgressBar getProgressBar() {
		if(progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setMinimum(0);
			progressBar.setMaximum(1000);
			progressBar.setPreferredSize(new Dimension(100, 22));
			progressBar.addMouseListener(new java.awt.event.MouseAdapter(){
				public void mousePressed(java.awt.event.MouseEvent e) {
					int position = (int)(e.getX() / (float)getProgressBar().getSize().width * getProgressBar()
							.getMaximum());
					position = Math.min(position, getProgressBar().getMaximum());

					updateProgression(position);
				}
			});
			progressBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter(){
				public void mouseDragged(java.awt.event.MouseEvent e) {
					int position = (int)(e.getX() / (float)getProgressBar().getSize().width * getProgressBar()
							.getMaximum());
					position = Math.min(position, getProgressBar().getMaximum());

					updateProgression(position);
				}
			});
		}
		return progressBar;
	}

	private Timer timer = null; //  @jve:decl-index=0:

	protected Timer getTimer() {
		if(timer == null) {
			timer = new Timer(10, new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					updateGui();
				}
			});
		}
		return timer;
	}

	private JFileChooser musicChooser = null; //  @jve:decl-index=0:visual-constraint="16,317"

	protected JFileChooser getMusicChooser() {
		if(musicChooser == null) {
			musicChooser = new JFileChooser();
			musicChooser.setMultiSelectionEnabled(false);
			musicChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			musicChooser.removeChoosableFileFilter(musicChooser.getFileFilter());
			musicChooser.addChoosableFileFilter(new FileFilter(){
				public String getDescription() {
					return "All audio files (*.*))";
				}

				public boolean accept(File f) {
					return true;
				}
			});
		}
		return musicChooser;
	}

	/*END OF THE GUI*/

	/*
	 * Globals
	 */
	System gSystem = new System(); //  @jve:decl-index=0:
	Sound gSound = new Sound();
	Channel gChannel = new Channel();
	Sound gSoundRecord = new Sound();
	Channel gChannelRecord = new Channel();

	private void errorCheck(FMOD_RESULT result) {
		if(result != FMOD_OK) {
			String errstring = String.format("FMOD error! (%d)\n%s", result.asInt(), FmodEx.FMOD_ErrorString(result));
			JOptionPane.showMessageDialog(this, errstring, "FMOD error!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean initializeFmodEx() {
		FMOD_RESULT result;
		int version;

		/* Initialise FMOD */
		result = FmodEx.System_Create(gSystem);
		errorCheck(result);

		IntBuffer buffer = newIntBuffer(1);
		result = gSystem.getVersion(buffer);
		errorCheck(result);
		version = buffer.get(0);

		if(version < FMOD_VERSION) {
			JOptionPane.showMessageDialog(this, "INCORRECT DLL VERSION!!", "FMOD ERROR", JOptionPane.ERROR_MESSAGE);
		}

		/* Initialize FMOD. */
		result = gSystem.init(32, FMOD_INIT_NORMAL, null);
		errorCheck(result);
		if(result != FMOD_OK) {
			return false;
		}

		/* Create window and graphics */
		this.getTimer().start();
		this.setVisible(true);

		return true;
	}

	protected void open() {
		/* Display the Open dialog box. */
		int choice = getMusicChooser().showOpenDialog(this);

		if(choice == JFileChooser.APPROVE_OPTION) {
			File file = getMusicChooser().getSelectedFile();

			FMOD_RESULT result;

			if(!gSound.isNull()) {
				if(!gChannel.isNull()) {
					gChannel.stop();
					gChannel = new Channel();
					getPlayStop().setText("Play");
				}
				gSound.release();
			}
			result = gSystem.createStream(file.getPath(), FMOD_2D | FMOD_SOFTWARE, null, gSound);
			errorCheck(result);

			getFilePath().setText(file.getPath());
		}
	}

	protected void playStop() {
		boolean isplaying = false;

		if(!gChannel.isNull()) {
			ByteBuffer buffer = newByteBuffer(1);
			gChannel.isPlaying(buffer);
			isplaying = buffer.get(0) != 0;
		}

		if(isplaying || gSound.isNull()) {
			if(!gChannel.isNull()) {
				gChannel.stop();
				gChannel = new Channel();
			}
			getPlayStop().setText("Play");
		}
		else {
			gSystem.playSound(FMOD_CHANNEL_FREE, gSound, false, gChannel);
			getPlayStop().setText("Stop");
		}
	}

	protected void pause() {
		if(!gChannel.isNull()) {
			ByteBuffer paused = newByteBuffer(1);

			gChannel.getPaused(paused);
			if(paused.get(0) != 0) {
				gChannel.setPaused(false);
				getPause().setText("Pause");
			}
			else {
				gChannel.setPaused(true);
				getPause().setText("UnPause");
			}
		}
	}

	protected void updateProgression(int position) {
		if(!gSound.isNull() && !gChannel.isNull()) {
			FMOD_RESULT result;
			IntBuffer length = newIntBuffer(1);

			result = gSound.getLength(length, FMOD_TIMEUNIT_MODORDER);
			if(result != FMOD_OK) {
				gSound.getLength(length, FMOD_TIMEUNIT_MS);
			}

			int currentPosition = (int)(position * length.get(0) / 1000.0f);

			result = gChannel.setPosition(currentPosition, FMOD_TIMEUNIT_MODORDER);
			if(result != FMOD_OK) {
				gChannel.setPosition(currentPosition, FMOD_TIMEUNIT_MS);
			}
		}
	}

	private ByteBuffer bufferGui = newByteBuffer(SIZEOF_INT);

	protected void updateGui() {
		gSystem.update();

		plotSpectrum(true);
		plotOscilliscope();

		if(!gChannel.isNull()) {
			FMOD_RESULT result;
			int currTime, length;
			boolean playing;

			result = gChannel.getPosition(bufferGui.asIntBuffer(), FMOD_TIMEUNIT_MODORDER);
			if(result != FMOD_OK) {
				gChannel.getPosition(bufferGui.asIntBuffer(), FMOD_TIMEUNIT_MS);
			}
			currTime = bufferGui.getInt(0);

			result = gSound.getLength(bufferGui.asIntBuffer(), FMOD_TIMEUNIT_MODORDER);
			if(result != FMOD_OK) {
				gSound.getLength(bufferGui.asIntBuffer(), FMOD_TIMEUNIT_MS);
			}
			length = bufferGui.getInt(0);

			getProgressBar().setValue((int)((float)currTime / (float)length * 1000.0f));

			gChannel.isPlaying(bufferGui);
			playing = bufferGui.get(0) != 0;
			if(!playing) {
				gChannel = new Channel();
				getPlayStop().setText("Play");
			}
		}
	}

	private FloatBuffer[] spectrumBuffer = new FloatBuffer[8];
	private int spectrumBufferLength = 0;
	private IntBuffer numChannels = newIntBuffer(1);
	private int grey = 0x404040;

	private void plotSpectrum(boolean uselog) {
		FMOD_RESULT result = gSystem.getSoftwareFormat(null, null, numChannels, null, null, null);
		if(result != FMOD_OK) {
			return;
		}
		if(spectrumBufferLength < numChannels.get(0)) {
			for(int i = spectrumBufferLength; i < numChannels.get(0); i++) {
				spectrumBuffer[i] = newFloatBuffer(512);
			}
			spectrumBufferLength = numChannels.get(0);
		}

		//Draw spectrum offscreen
		BufferedImage image = new BufferedImage(GRAPHICWINDOW_WIDTH, GRAPHICWINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);

		/*
		 * Draw a black square with grey lines through it.
		 */
		for(int x = 0; x < GRAPHICWINDOW_WIDTH; x++) {
			for(int y = 0; y < 30; y++) {
				image.setRGB(x, GRAPHICWINDOW_HEIGHT * y / 30, grey);
			}
		}
		for(int x = 0; x < GRAPHICWINDOW_WIDTH; x += 64) {
			for(int y = 0; y < GRAPHICWINDOW_HEIGHT; y++) {
				image.setRGB(x, y, grey);
			}
		}

		float max = 0;
		for(int i = 0; i < numChannels.get(0); i++) {
			//returns an array of 512 floats
			result = gSystem.getSpectrum(spectrumBuffer[i], 512, i, FMOD_DSP_FFT_WINDOW_TRIANGLE);
			if(result != FMOD_OK) {
				return;
			}

			{
				for(int j = 0; j < 512; j++) {
					if(spectrumBuffer[i].get(j) > max) {
						max = spectrumBuffer[i].get(j);
					}
				}
			}

			if(max > 0.0001f) {
				/*
				 * Spectrum graphic is 256 entries wide, and the spectrum is 512 entries.
				 * The upper band of frequencies at 44khz is pretty boring (ie 11-22khz), so we are only
				 * going to display the first 256 frequencies, or (0-11khz)
				 */
				for(int x = 0; x < 512; x++) {
					float val, db;
					int y;

					val = spectrumBuffer[i].get(x);

					if(uselog) {
						/*
						 * 1.0   = 0db
						 * 0.5   = -6db
						 * 0.25  = -12db
						 * 0.125 = -24db
						 */
						db = 10.0f * (float)Math.log10(val) * 2.0f;

						val = db;
						if(val < -150) {
							val = -150;
						}

						val /= -150.0f;
						val = 1.0f - val;

						y = (int)(val * GRAPHICWINDOW_HEIGHT);
					}
					else {
						y = (int)(val / max * GRAPHICWINDOW_HEIGHT);
					}

					if(y >= GRAPHICWINDOW_HEIGHT) {
						y = GRAPHICWINDOW_HEIGHT - 1;
					}

					for(int j = 0; j < y; j++) {
						int r, g, b;

						r = (j << 1);
						g = 0xFF - (j << 1);
						b = 0x1F;

						image.setRGB(x * GRAPHICWINDOW_WIDTH / 512, GRAPHICWINDOW_HEIGHT - 1 - j, (r << 16) + (g << 8)
								+ b);
					}
				}
			}
		}

		//Draw the spectrum on the screen
		getSpectrum().getGraphics().drawImage(image, 0, 0, null);
	}

	private FloatBuffer oscBuffer = newFloatBuffer(GRAPHICWINDOW_WIDTH);
	private int oscColor = 0xffffaf;

	private void plotOscilliscope() {
		float xoff, step;

		FMOD_RESULT result = gSystem.getSoftwareFormat(null, null, numChannels, null, null, null);
		if(result != FMOD_OK) {
			return;
		}

		//Draw spectrum offscreen
		BufferedImage image = new BufferedImage(GRAPHICWINDOW_WIDTH, GRAPHICWINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);

		for(int channel = 0; channel < numChannels.get(0); channel++) {
			gSystem.getWaveData(oscBuffer, GRAPHICWINDOW_WIDTH, channel);

			/*
			 * xoff is the x position that is scaled lookup of the dsp block according to the graphical
			 * window size.
			 */
			xoff = 0;
			step = 1;

			for(int i = 0; i < GRAPHICWINDOW_WIDTH - 1; i++) {
				int x, y, y2;

				x = (int)xoff;
				y = (int)((oscBuffer.get(x) + 1.0f) / 2.0f * GRAPHICWINDOW_HEIGHT);
				y2 = (int)((oscBuffer.get(x + (int)step) + 1.0f) / 2.0f * GRAPHICWINDOW_HEIGHT);

				y = y < 0 ? 0 : y >= GRAPHICWINDOW_HEIGHT ? GRAPHICWINDOW_HEIGHT - 1 : y;
				y2 = y2 < 0 ? 0 : y2 >= GRAPHICWINDOW_HEIGHT ? GRAPHICWINDOW_HEIGHT - 1 : y2;

				if(y > y2) {
					int tmp = y;
					y = y2;
					y2 = tmp;
				}

				for(int j = y; j <= y2; j++) {
					image.setRGB(i, j, oscColor);
				}

				xoff += step;
			}
		}

		//Draw the oscilloscope on the screen
		getOsciloscope().getGraphics().drawImage(image, 0, 0, null);
	}

	public static void main(String[] args) {
		/* NativeFmodEx Init */
		try {
			Init.loadLibraries();
		}
		catch(InitException e) {
			out.printf("NativeFmodEx error! %s\n", e.getMessage());
			exit(1);
		}

		/* Checking NativeFmodEx version */
		if(NATIVEFMODEX_LIBRARY_VERSION != NATIVEFMODEX_JAR_VERSION) {
			out.printf("Error!  NativeFmodEx library version (%08x) is different to jar version (%08x)\n",
					NATIVEFMODEX_LIBRARY_VERSION, NATIVEFMODEX_JAR_VERSION);
			exit(0);
		}

		/*==================================================*/

		Spectrum spectrum = new Spectrum();
		if(!spectrum.initializeFmodEx()) {
			exit(0);
		}
	}
} //  @jve:decl-index=0:visual-constraint="10,10"