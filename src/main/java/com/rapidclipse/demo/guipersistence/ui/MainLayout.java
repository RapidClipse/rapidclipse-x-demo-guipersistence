
package com.rapidclipse.demo.guipersistence.ui;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import com.flowingcode.vaadin.addons.ironicons.IronIcons;
import com.rapidclipse.framework.server.ui.persistence.GuiPersistence;
import com.rapidclipse.framework.server.ui.persistence.PersistFlag;
import com.rapidclipse.framework.server.ui.persistence.PersistValueFlag;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PageConfigurator;


/**
 *
 */
@Route("")
public class MainLayout extends VerticalLayout implements PageConfigurator
{
	private final static String PREFERENCES_KEY = "gui-persistence-data";

	/**
	 *
	 */
	public MainLayout()
	{
		super();

		this.initUI();

		this.cmdLoad.setEnabled(this.preferences().get(MainLayout.PREFERENCES_KEY, null) != null);
	}
	
	private Preferences preferences()
	{
		return Preferences.userNodeForPackage(MainLayout.class);
	}

	/**
	 * Event handler delegate method for the {@link Button} {@link #cmdSave}.
	 *
	 * @see ComponentEventListener#onComponentEvent(ComponentEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void cmdSave_onClick(final ClickEvent<Button> event)
	{
		final Preferences preferences = this.preferences();
		preferences.put(MainLayout.PREFERENCES_KEY, GuiPersistence.save(this, "demo"));
		
		try
		{
			preferences.flush();
		}
		catch(final BackingStoreException e)
		{
			e.printStackTrace();
		}
		
		this.cmdLoad.setEnabled(true);
	}

	/**
	 * Event handler delegate method for the {@link Button} {@link #cmdLoad}.
	 *
	 * @see ComponentEventListener#onComponentEvent(ComponentEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void cmdLoad_onClick(final ClickEvent<Button> event)
	{
		GuiPersistence.load(this, "demo", this.preferences().get(MainLayout.PREFERENCES_KEY, null));
	}

	@Override
	public void configurePage(final InitialPageSettings settings)
	{
		settings.addLink("shortcut icon", "frontend/images/favicon.ico");
		settings.addFavIcon("icon", "frontend/images/favicon256.png", "256x256");
	}

	/* WARNING: Do NOT edit!<br>The content of this method is always regenerated by the UI designer. */
	// <generated-code name="initUI">
	private void initUI()
	{
		this.horizontalLayout = new HorizontalLayout();
		this.cmdSave          = new Button();
		this.cmdLoad          = new Button();
		this.textField        = new TextField();
		this.textArea         = new TextArea();
		this.numberField      = new NumberField();
		this.checkbox         = new Checkbox();
		this.datePicker       = new DatePicker();
		this.timePicker       = new TimePicker();

		this.cmdSave.setText("Save");
		this.cmdSave.setIcon(IronIcons.SAVE.create());
		this.cmdLoad.setEnabled(false);
		this.cmdLoad.setText("Load");
		this.cmdLoad.setIcon(IronIcons.OPEN_IN_BROWSER.create());
		this.textField.setId("textField");
		PersistFlag.set(this.textField, true);
		PersistValueFlag.set(this.textField, true);
		this.textArea.setId("textArea");
		PersistFlag.set(this.textArea, true);
		PersistValueFlag.set(this.textArea, true);
		this.numberField.setId("numberField");
		PersistFlag.set(this.numberField, true);
		PersistValueFlag.set(this.numberField, true);
		this.checkbox.setLabel("Checkbox");
		this.checkbox.setId("checkbox");
		PersistFlag.set(this.checkbox, true);
		PersistValueFlag.set(this.checkbox, true);
		this.datePicker.setId("datePicker");
		PersistFlag.set(this.datePicker, true);
		PersistValueFlag.set(this.datePicker, true);
		this.timePicker.setId("timePicker");
		PersistFlag.set(this.timePicker, true);
		PersistValueFlag.set(this.timePicker, true);

		this.cmdSave.setSizeUndefined();
		this.cmdLoad.setSizeUndefined();
		this.horizontalLayout.add(this.cmdSave, this.cmdLoad);
		this.horizontalLayout.setSizeUndefined();
		this.textField.setSizeUndefined();
		this.textArea.setSizeUndefined();
		this.numberField.setSizeUndefined();
		this.checkbox.setSizeUndefined();
		this.datePicker.setSizeUndefined();
		this.timePicker.setSizeUndefined();
		this.add(this.horizontalLayout, this.textField, this.textArea, this.numberField, this.checkbox, this.datePicker,
			this.timePicker);
		this.setSizeFull();

		this.cmdSave.addClickListener(this::cmdSave_onClick);
		this.cmdLoad.addClickListener(this::cmdLoad_onClick);
	} // </generated-code>

	// <generated-code name="variables">
	private Checkbox         checkbox;
	private Button           cmdSave, cmdLoad;
	private DatePicker       datePicker;
	private TextArea         textArea;
	private NumberField      numberField;
	private HorizontalLayout horizontalLayout;
	private TimePicker       timePicker;
	private TextField        textField;
	// </generated-code>

}
