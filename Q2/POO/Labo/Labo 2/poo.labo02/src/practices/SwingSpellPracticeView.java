package practices;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.*;


public class SwingSpellPracticeView extends JPanel {
	private static final long serialVersionUID = -8493715512783198945L;

	private final SpellPracticeSession session;

	private final JComboBox<String> practicers;
	private final JComboBox<String> practiceObjects;
	private final JButton practiceButton;
	private final JPanel messagesPanel;
	
	public SwingSpellPracticeView(SpellPracticeSession session) {
		super(new  GridBagLayout());
		
		this.session = session;
		
		var constraint = new GridBagConstraints();
		constraint.insets = new Insets(4, 4, 4, 4);
		
		var practicerLabel = new JLabel("Choose a practicer :");
		constraint.fill = GridBagConstraints.HORIZONTAL;		
		constraint.gridwidth = 3;
		constraint.gridx = 0;
		constraint.gridy = 0;
		
		add(practicerLabel, constraint);
		
		practicers = new JComboBox<>(); 
		constraint.gridx = 0;
		constraint.gridy = 1;
		
		add(practicers, constraint);
		
		var whatLabel = new JLabel("Choose an object :");
		constraint.fill = GridBagConstraints.HORIZONTAL;		
		constraint.gridwidth = 2;
		constraint.gridx = 3;
		constraint.gridy = 0;
		
		add(whatLabel, constraint);
		
		practiceObjects = new JComboBox<>();
		constraint.gridx = 3;
		constraint.gridy = 1;
		
		add(practiceObjects, constraint);
		
		practiceButton = new JButton("Practice");
		practiceButton.addActionListener(this::onPracticePressed);
		practiceButton.setEnabled(false);
		
		constraint.fill = GridBagConstraints.HORIZONTAL;	
		constraint.gridwidth = 5;
		constraint.gridx = 0;
		constraint.gridy = 2;
		
		add(practiceButton, constraint);
		
		messagesPanel = new JPanel();
		messagesPanel.setLayout(new BoxLayout(messagesPanel, BoxLayout.PAGE_AXIS));
		constraint.fill = GridBagConstraints.HORIZONTAL;		
		constraint.gridwidth = 5;
		constraint.gridx = 0;
		constraint.gridy = 3;
		
		add(messagesPanel, constraint);
		
		fillCombos();
	}

	private void fillCombos() {
		boolean validNames = fillNamesCombo();
		boolean validObjects = fillObjectsCombo();
		
		practiceButton.setEnabled(validNames && validObjects);
	}

	private boolean fillObjectsCombo() {
		String[] objects = session.getSpellNames();
		boolean validObjects = objects != null && objects.length > 0 && checkNoNull(objects);
		if(validObjects) {
			practiceObjects.removeAllItems();
			for(var object : objects) {
				practiceObjects.addItem(object);
			}
		} else {
			showErrorMessage("You must provide at least one practice object");
		}
		return validObjects;
	}

	private boolean fillNamesCombo() {
		String[] names = session.getWizardNames();
		boolean validNames = names != null && names.length > 0 && checkNoNull(names);
		if(validNames) {
			practicers.removeAllItems();
			for(var name : names) {
				practicers.addItem(name);
			}
		} else {
			showErrorMessage("You must provide at least one practicer");
		}
		return validNames;
	}

	private void onPracticePressed(ActionEvent ae) {
		String[] messages = this.session.practice(
					practicers.getSelectedIndex(), 
					practiceObjects.getSelectedIndex());
		
		boolean validMessages = messages != null 
				&& messages.length > 0 
				&& checkNoNull(messages);
		
		if(validMessages) {
			messagesPanel.removeAll();
			for(String msg : messages) {
				messagesPanel.add(new JLabel(msg));
			}
			fillCombos();
		} else {
			showErrorMessage("You must provide at least one message. No message can be null.");
		}
		
		this.updateUI();
	}

	private boolean checkNoNull(String[] messages) {
		return Arrays.stream(messages).allMatch(msg -> msg != null);
	}
	
	private void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, 
				message, 
				"Initialization error",
				JOptionPane.ERROR_MESSAGE);
	}
}