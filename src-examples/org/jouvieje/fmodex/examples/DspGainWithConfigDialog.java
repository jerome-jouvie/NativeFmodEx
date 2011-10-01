package org.jouvieje.fmodex.examples;

import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_ERR_INVALID_PARAM;
import static org.jouvieje.fmodex.enumerations.FMOD_RESULT.FMOD_OK;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.jouvieje.fmodex.callbacks.FMOD_DSP_CREATECALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_DSP_DIALOGCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_DSP_GETPARAMCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_DSP_READCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_DSP_RELEASECALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_DSP_RESETCALLBACK;
import org.jouvieje.fmodex.callbacks.FMOD_DSP_SETPARAMCALLBACK;
import org.jouvieje.fmodex.enumerations.FMOD_RESULT;
import org.jouvieje.fmodex.utils.BufferUtils;
import org.jouvieje.fmodex.utils.ObjectPointer;
import org.jouvieje.fmodex.structures.FMOD_DSP_DESCRIPTION;
import org.jouvieje.fmodex.structures.FMOD_DSP_PARAMETERDESC;
import org.jouvieje.fmodex.structures.FMOD_DSP_STATE;

/**
 * Based on the FMOD Ex C++ 'DSP_GAIN'.
 * Ported and adaptation to Java with NativeFmodEx by Jérôme JOUVIE (Jouvieje).
 * 
 * @author Jérôme JOUVIE (Jouvieje)
 * @site   http://jerome.jouvie.free.fr/
 * @mail   jerome.jouvie@gmail.com
 */
public class DspGainWithConfigDialog {
	/*
	 * FMODGetDSPDescription is mandantory for every fmod plugin.  This is the symbol the registerplugin function searches for.
	 * Must be declared with F_API to make it export as stdcall.
	 * MUST BE EXTERN'ED AS C!  C++ functions will be mangled incorrectly and not load in fmod.
	 */
	public static FMOD_DSP_DESCRIPTION FMODGetDSPDescription() {
		if(dspparam == null) {
			dspparam = FMOD_DSP_PARAMETERDESC.allocate(1);
			dspparam[0].setMin(0.0f);
			dspparam[0].setMax(1.0f);
			dspparam[0].setDefaultVal(1.0f);
			dspparam[0].setName("Level");
			dspparam[0].setLabel("%");
			dspparam[0].setDescription("Gain level");
		}

		if(dspgaindesc == null) {
			dspgaindesc = FMOD_DSP_DESCRIPTION.allocate();
			dspgaindesc.setName("FMOD gain example"); //name
			dspgaindesc.setVersion(0x00010000); //version 0xAAAABBBB   A = major, B = minor.
			dspgaindesc.setChannels(0); // 0 = we can filter whatever you throw at us.  To be most user friendly, always write a filter like this.
			dspgaindesc.setCreate(dspcreate);
			dspgaindesc.setRelease(dsprelease);
			dspgaindesc.setReset(dspreset);
			dspgaindesc.setRead(dspread);
			dspgaindesc.setSetPosition(null); //This is for if you want to allow the plugin to seek, which doesnt really make sense in a gain filter so we'll just leave it out.
			dspgaindesc.setParamDesc(dspparam); //pointer to the parameter list definition.
			dspgaindesc.setSetParameter(dspsetparam);
			dspgaindesc.setGetParameter(dspgetparam);
			dspgaindesc.setConfig(dialog);
			dspgaindesc.setConfigWidth(dialogWidth);
			dspgaindesc.setConfigHeight(dialogHeight);
		}

		return dspgaindesc;
	}

	static class dspgain_state {
		float gain;
	}

	private static FMOD_DSP_DIALOGCALLBACK dialog = new FMOD_DSP_DIALOGCALLBACK(){
		public FMOD_RESULT FMOD_DSP_DIALOGCALLBACK(FMOD_DSP_STATE dsp, Component hwnd, int show) {
			if(hwnd instanceof Container) {
				Container container = (Container)hwnd;
				if(show == 1) {
					container.add(getDialogPanel(dsp));
				}
				else {
					container.remove(getDialogPanel(dsp));
				}
				return FMOD_OK;
			}
			return FMOD_ERR_INVALID_PARAM;
		}
	};
	private static JPanel dialogPanel = null;
	private static JLabel gainLabel = null;
	private static JLabel valueLabel = null;
	private static JLabel unitLabel = null;
	private final static int dialogWidth = 160;
	private final static int dialogHeight = 60;

	private static JPanel getDialogPanel(FMOD_DSP_STATE dsp) {
		if(dialogPanel == null) {
			dialogPanel = new JPanel();
			dialogPanel.setMinimumSize(new Dimension(dialogWidth, dialogHeight));
			dialogPanel.setPreferredSize(new Dimension(dialogWidth, dialogHeight));
			dialogPanel.setMaximumSize(new Dimension(dialogWidth, dialogHeight));
			dialogPanel.setBackground(Color.WHITE);
			dialogPanel.setBorder(new TitledBorder("DSP Gain - Config Dialog"));
			dialogPanel.add(getGainLabel());
			dialogPanel.add(getValueLabel(dsp));
			dialogPanel.add(getUnitLabel());
		}
		return dialogPanel;
	}
	private static JLabel getGainLabel() {
		if(gainLabel == null) {
			gainLabel = new JLabel("Gain = ");
			gainLabel.setForeground(Color.BLACK);
		}
		return gainLabel;
	}
	private static JLabel getValueLabel(FMOD_DSP_STATE dsp) {
		if(valueLabel == null) {
			valueLabel = new JLabel();
			dspgain_state state = (dspgain_state)ObjectPointer.asObjectPointer(dsp.getPluginData()).getObject();
			valueLabel.setText(String.format("%.02f", state.gain * 100.0f));
			valueLabel.addPropertyChangeListener("text", new PropertyChangeListener(){
				public void propertyChange(PropertyChangeEvent evt) {
					String value = (String)evt.getNewValue();
					int rgb = 255 - (int)(2.55f * Float.parseFloat(value.replace(",", ".")));
					Color color = new Color(rgb, rgb, rgb);
					valueLabel.setForeground(color);
					getUnitLabel().setForeground(color);
				}
			});
		}
		return valueLabel;
	}
	private static JLabel getUnitLabel() {
		if(unitLabel == null) {
			unitLabel = new JLabel(" %");
			unitLabel.setForeground(Color.BLACK);
		}
		return unitLabel;
	}

	/*
	 * DSP Parameter list.
	 */
	private static FMOD_DSP_PARAMETERDESC[] dspparam = null;

	private static FMOD_DSP_DESCRIPTION dspgaindesc = null;

	private static FMOD_DSP_CREATECALLBACK dspcreate = new FMOD_DSP_CREATECALLBACK(){
		public FMOD_RESULT FMOD_DSP_CREATECALLBACK(FMOD_DSP_STATE dsp) {
			/*
			 * If we were allocating memory for buffers etc, it would be done in this function.
			 */
			dspgain_state state = new dspgain_state();

			state.gain = dspparam[0].getDefaultVal();

			dsp.setPluginData(ObjectPointer.allocate(state));

			return FMOD_OK;
		}
	};

	private static FMOD_DSP_RELEASECALLBACK dsprelease = new FMOD_DSP_RELEASECALLBACK(){
		public FMOD_RESULT FMOD_DSP_RELEASECALLBACK(FMOD_DSP_STATE dsp) {
			ObjectPointer op = ObjectPointer.asObjectPointer(dsp.getPluginData());

			/*
			 * If memory was allocated in create, it would be freed in this function.
			 */
			op.release();

			return FMOD_OK;
		}
	};

	private static FMOD_DSP_RESETCALLBACK dspreset = new FMOD_DSP_RESETCALLBACK(){
		public FMOD_RESULT FMOD_DSP_RESETCALLBACK(FMOD_DSP_STATE dsp) {
			dspgain_state state = (dspgain_state)ObjectPointer.asObjectPointer(dsp.getPluginData()).getObject();

			/*
			 * This isnt really needed here.  It is used to reset a filter back to it's default state.
			 */

			state.gain = dspparam[0].getDefaultVal();

			return FMOD_OK;
		}
	};

	/*
	 * This callback does the work.  Modify data from inbuffer and send it to outbuffer.
	 */
	private static FMOD_DSP_READCALLBACK dspread = new FMOD_DSP_READCALLBACK(){
		public FMOD_RESULT FMOD_DSP_READCALLBACK(FMOD_DSP_STATE dsp, FloatBuffer inbuffer, FloatBuffer outbuffer,
				int length, int inchannels, int outchannels) {
			dspgain_state state = (dspgain_state)ObjectPointer.asObjectPointer(dsp.getPluginData()).getObject();
			int channels = inchannels; //outchannels and inchannels will always be the same because this is a flexible filter.

			for(int i = 0; i < length; i++) {
				for(int j = 0; j < channels; j++) {
					outbuffer.put(i * channels + j, inbuffer.get(i * channels + j) * state.gain);
				}
			}

			return FMOD_OK;
		}
	};

	/*
	 * This callback is for when the user sets a parameter.  It is automatically clamped between 0 and 1.
	 */
	private static FMOD_DSP_SETPARAMCALLBACK dspsetparam = new FMOD_DSP_SETPARAMCALLBACK(){
		public FMOD_RESULT FMOD_DSP_SETPARAMCALLBACK(FMOD_DSP_STATE dsp, int index, float value) {
			dspgain_state state = (dspgain_state)ObjectPointer.asObjectPointer(dsp.getPluginData()).getObject();

			switch(index) {
				case 0: {
					state.gain = value;
					getValueLabel(dsp).setText(String.format("%.02f", value * 100.0f));
					break;
				}
			}
			return FMOD_OK;
		}
	};

	/*
	 * This callback is for when the user gets a parameter.  The label for our only parameter is percent,
	 * so when the string is requested print it out as 0 to 100.
	 */
	private static FMOD_DSP_GETPARAMCALLBACK dspgetparam = new FMOD_DSP_GETPARAMCALLBACK(){
		public FMOD_RESULT FMOD_DSP_GETPARAMCALLBACK(FMOD_DSP_STATE dsp, int index, FloatBuffer value,
				ByteBuffer valuestr) {
			dspgain_state state = (dspgain_state)ObjectPointer.asObjectPointer(dsp.getPluginData()).getObject();

			switch(index) {
				case 0: {
					value.put(state.gain);

					String s = String.format("%.02f", state.gain * 100.0f); //our units are '%', so print it out as 0 to 100.
					BufferUtils.putString(valuestr, s);
					BufferUtils.putNullTerminal(valuestr);
				}
			}

			return FMOD_OK;
		}
	};
}