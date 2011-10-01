/*===============================================================================================
DSP_GAIN.DLL
Copyright (c), Firelight Technologies Pty, Ltd 2005.

===============================================================================================*/

package org.jouvieje.fmodex.examples;

import static java.lang.System.exit;
import static java.lang.System.out;
import static org.jouvieje.fmodex.defines.FMOD_INITFLAGS.FMOD_INIT_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_DEFAULT;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_LOOP_NORMAL;
import static org.jouvieje.fmodex.defines.FMOD_MODE.FMOD_SOFTWARE;
import static org.jouvieje.fmodex.defines.VERSIONS.FMOD_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_JAR_VERSION;
import static org.jouvieje.fmodex.defines.VERSIONS.NATIVEFMODEX_LIBRARY_VERSION;
import static org.jouvieje.fmodex.enumerations.FMOD_CHANNELINDEX.FMOD_CHANNEL_FREE;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;
import static org.jouvieje.fmodex.examples.DspGainWithConfigDialog.FMODGetDSPDescription;
import static org.jouvieje.fmodex.utils.BufferUtils.newByteBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.newFloatBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.newIntBuffer;
import static org.jouvieje.fmodex.utils.BufferUtils.SIZEOF_INT;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;

import org.jouvieje.fmodex.Channel;
import org.jouvieje.fmodex.DSP;
import org.jouvieje.fmodex.FmodEx;
import org.jouvieje.fmodex.Init;
import org.jouvieje.fmodex.Sound;
import org.jouvieje.fmodex.System;

import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.exceptions.InitException;
import org.jouvieje.fmodex.utils.BufferUtils;

/**
 * Based on the FMOD Ex C++ 'DSP_GAIN'.
 * Ported and adaptation to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje).
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class DspGainMainWithConfigDialog extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		/*
		 * NativeFmodEx Init
		 */
		try {
			Init.loadLibraries();
		}
		catch(InitException e) {
			out.printf("NativeFmodEx error! %s\n", e.getMessage());
			exit(1);
		}

		/*
		 * Checking NativeFmodEx version
		 */
		if(NATIVEFMODEX_LIBRARY_VERSION != NATIVEFMODEX_JAR_VERSION) {
			JOptionPane.showMessageDialog(null, String.format(
					"Error!  NativeFmodEx library version (%08x) is different to jar version (%08x)\n",
					NATIVEFMODEX_LIBRARY_VERSION, NATIVEFMODEX_JAR_VERSION), "ERROR", JOptionPane.ERROR_MESSAGE);
			exit(0);
		}

		/*==================================================*/

		DspGainMainWithConfigDialog dspGainViewer = new DspGainMainWithConfigDialog();
		dspGainViewer.setVisible(true);
	}

	/*
	 * structures
	 */
	class PluginParam {
		Plugin plugin;
		int index;
		FloatBuffer min = newFloatBuffer(1);
		FloatBuffer max = newFloatBuffer(1);

		ByteBuffer paramname = newByteBuffer(32);
		ByteBuffer label = newByteBuffer(32);
		ByteBuffer valuestr = newByteBuffer(32);
		FloatBuffer value = newFloatBuffer(1);
	}

	class Plugin {
		DSP dsp = new DSP();
		ByteBuffer name = newByteBuffer(32);
		IntBuffer version = newIntBuffer(1);
		IntBuffer numparams = newIntBuffer(1);
		Vector<PluginParam> params = new Vector<PluginParam>();
		boolean configactive = false;

		//Visual
		IntBuffer configwidth = newIntBuffer(1);
		IntBuffer configheight = newIntBuffer(1);
	}

	private System system = new System();
	private Sound sound = new Sound();
	private Channel channel = new Channel();
	private Plugin plugin = new Plugin();

	public DspGainMainWithConfigDialog() {
		super();
		initializeFmodEx();
		initializeGUI();
	}

	private void errorCheck(FMOD_RESULT result) {
		if(result != FMOD_OK) {
			out.printf("FMOD error! (%d) %s\n", result.asInt(), FmodEx.FMOD_ErrorString(result));
			exit(1);
		}
	}

	private void initializeFmodEx() {
		FMOD_RESULT result;
		int version;

		ByteBuffer buffer = newByteBuffer(SIZEOF_INT);

		/*
		 * Global Settings
		 */
		result = FmodEx.System_Create(system);
		errorCheck(result);

		result = system.getVersion(buffer.asIntBuffer());
		errorCheck(result);
		version = buffer.getInt(0);

		if(version < FMOD_VERSION) {
			out.printf("Error!  You are using an old version of FMOD %08x.  This program requires %08x\n", version,
					FMOD_VERSION);
			exit(0);
		}

		result = system.init(32, FMOD_INIT_NORMAL, null);
		errorCheck(result);

		/**
		 * Create DspGain Plugin
		 */
		DSP dspGain = new DSP();
		result = system.createDSP(FMODGetDSPDescription(), dspGain);
		errorCheck(result);

		plugin.dsp = dspGain;

		/*
		 * Plugin informations
		 */
		plugin.dsp.getInfo(plugin.name, plugin.version, null, plugin.configwidth, plugin.configheight);

		/*
		 * Parameters informations
		 */
		plugin.dsp.getNumParameters(plugin.numparams);
		for(int i = 0; i < plugin.numparams.get(0); i++) {
			PluginParam param = new PluginParam();
			param.plugin = plugin;
			param.index = i;

			plugin.dsp.getParameterInfo(i, param.paramname, param.label, null, 0, param.min, param.max);
			plugin.dsp.getParameter(i, param.value, param.valuestr, 32);

			plugin.params.add(param);
		}

		/**
		 * Create and play the sound in loop
		 */
		result = system.createSound("Media/wave.mp3", FMOD_DEFAULT | FMOD_SOFTWARE | FMOD_LOOP_NORMAL, null, sound);
		errorCheck(result);
		result = system.playSound(FMOD_CHANNEL_FREE, sound, false, channel);
		errorCheck(result);
	}
	
	private void stop() {
		/*
		 * Shut down
		 */
		FMOD_RESULT result = sound.release();
		errorCheck(result);
		result = system.close();
		errorCheck(result);
		result = system.release();
		errorCheck(result);
	}
	
	/* GUI */
	private JPanel dspGainPanel = null;
	private JPanel buttons = null;
	private JCheckBox active = null;
	private JButton config = null;
	private JPanel parameters = null;
	private JPanel configDialogContainer = null;
	private void initializeGUI() {
		this.setTitle("DspGainViewer");
		this.setSize(240, 220);
		this.setLocationRelativeTo(null);
		this.setContentPane(getDspGainPanel());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				stop();
			}
		});
	}
	private JPanel getDspGainPanel() {
		if(dspGainPanel == null) {
			dspGainPanel = new JPanel();
			dspGainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DspGainPanel",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			dspGainPanel.setLayout(new BoxLayout(dspGainPanel, BoxLayout.Y_AXIS));
			dspGainPanel.add(getButtons());
			dspGainPanel.add(getParameters());
			dspGainPanel.add(getConfigDialogContainer());
		}
		return dspGainPanel;
	}
	private JPanel getButtons() {
		if(buttons == null) {
			buttons = new JPanel();
			buttons.add(getActive());
			buttons.add(getConfig());
		}
		return buttons;
	}
	private JCheckBox getActive() {
		if(active == null) {
			active = new JCheckBox();
			active.setText("Active");
			active.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e) {
					if(active.isSelected()) system.addDSP(plugin.dsp, null);
					else plugin.dsp.remove();
				}
			});
		}
		return active;
	}
	private JButton getConfig() {
		if(config == null) {
			config = new JButton();
			config.setText("Config");
			config.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(!plugin.dsp.isNull()) {
						if(plugin.configactive) {
							getConfigDialogContainer().setVisible(false);
							plugin.dsp.showConfigDialog(getConfigDialogContainer(), false);
							plugin.configactive = false;
						}
						else {
							plugin.dsp.showConfigDialog(getConfigDialogContainer(), true);
							plugin.configactive = true;
							getConfigDialogContainer().setVisible(true);
						}
						//Force a little ...
						getConfigDialogContainer().validate();
						getConfigDialogContainer().repaint();
					}
				}
			});
		}
		return config;
	}
	private JPanel getParameters() {
		if(parameters == null) {
			parameters = new JPanel();
			parameters.setLayout(new GridBagLayout());

			final float FLOAT_TO_INT = 1000.f;

			for(int i = 0; i < plugin.params.size(); i++) {
				final PluginParam pluginParam = plugin.params.get(i);

				JLabel paramName = new JLabel();
				paramName.setText(BufferUtils.toString(pluginParam.paramname));

				final JLabel paramValue = new JLabel(BufferUtils.toString(pluginParam.valuestr) + " "
						+ BufferUtils.toString(pluginParam.label));

				final JSlider slider = new JSlider();
				slider.setMinimum((int)(pluginParam.min.get(0) * FLOAT_TO_INT));
				slider.setMaximum((int)(pluginParam.max.get(0) * FLOAT_TO_INT));
				slider.setValue((int)(pluginParam.value.get(0) * FLOAT_TO_INT));
				slider.addChangeListener(new javax.swing.event.ChangeListener(){
					public void stateChanged(javax.swing.event.ChangeEvent e) {
						if(slider.getValueIsAdjusting()) {
							pluginParam.value.put(0, slider.getValue() / FLOAT_TO_INT);

							pluginParam.plugin.dsp.getParameterInfo(pluginParam.index, null, pluginParam.label, null,
									0, null, null);
							pluginParam.plugin.dsp.setParameter(pluginParam.index, pluginParam.value.get(0));
							pluginParam.plugin.dsp.getParameter(pluginParam.index, null, pluginParam.valuestr, 32);

							paramValue.setText(BufferUtils.toString(pluginParam.valuestr) + " "
									+ BufferUtils.toString(pluginParam.label));
						}
					}
				});

				GridBagConstraints constraint3 = new GridBagConstraints();
				constraint3.gridx = 2;
				constraint3.gridy = i;
				GridBagConstraints constraint2 = new GridBagConstraints();
				constraint2.fill = GridBagConstraints.BOTH;
				constraint2.gridx = 1;
				constraint2.gridy = i;
				constraint2.weightx = 1;
				GridBagConstraints constraint1 = new GridBagConstraints();
				constraint1.gridx = 0;
				constraint1.gridy = i;
				parameters.add(paramName, constraint1);
				parameters.add(slider, constraint2);
				parameters.add(paramValue, constraint3);
			}
		}
		return parameters;
	}
	private JPanel getConfigDialogContainer() {
		if(configDialogContainer == null) {
			configDialogContainer = new JPanel();
			Dimension dimension = new Dimension(plugin.configwidth.get(0), plugin.configheight.get(0));
			configDialogContainer.setMinimumSize(dimension);
			configDialogContainer.setPreferredSize(dimension);
			configDialogContainer.setMaximumSize(dimension);
			configDialogContainer.setVisible(false);
		}
		return configDialogContainer;
	}
} //  @jve:decl-index=0:visual-constraint="10,10"
