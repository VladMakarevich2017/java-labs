package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import model.MainModel;

public class MainFrame {
	
	private MainModel model;
	private Label massLabel1;
	private Text massText1;
	private Label massLabel2;
	private Text massText2;
	private Label speedLabel1;
	private Text speedText1;
	private Label speedLabel2;
	private Text speedText2;
	private Label infoLabel;
	private Button calculateButton;
	private Label resultLabel;

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public void run() {
		try {
			open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MainFrame(MainModel model) {
		this.model = model;
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		GridLayout layout = new GridLayout();
		shell = new Shell();
		shell.setLayout(layout);
		layout.numColumns = 4;
		layout.marginHeight = 7;
		layout.marginWidth = 7;
 		createContents();
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell.setText("KPP laba 1");
		massLabel1 = new Label(shell, SWT.NONE);
		massLabel1.setText("Масса");
		GridData gridData = new GridData();
		massLabel1.setLayoutData(gridData);
		
		massText1 = new Text(shell, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		massText1.setLayoutData(gridData);
		
		massLabel2 = new Label(shell, SWT.NONE);
		massLabel2.setText("Масса");
		gridData = new GridData();
		massLabel2.setLayoutData(gridData);
		
		massText2 = new Text(shell, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		massText2.setLayoutData(gridData);
		
		speedLabel1 = new Label(shell, SWT.NONE);
		speedLabel1.setText("Скорость");
		gridData = new GridData();
		speedLabel1.setLayoutData(gridData);
		
		speedText1 = new Text(shell, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		speedText1.setLayoutData(gridData);
		
		speedLabel2 = new Label(shell, SWT.NONE);
		speedLabel2.setText("Скорость");
		gridData = new GridData();
		speedLabel2.setLayoutData(gridData);
		
		speedText2 = new Text(shell, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		speedText2.setLayoutData(gridData);
		
		infoLabel = new Label(shell, SWT.NONE);
		infoLabel.setText("Скорость после столкновения:");
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		infoLabel.setLayoutData(gridData);
		
		resultLabel = new Label(shell, SWT.NONE);
		resultLabel.setText("         ");
		gridData = new GridData();
		resultLabel.setLayoutData(gridData);

		calculateButton = new Button(shell, SWT.PUSH);
		calculateButton.setText("       Посчитать       ");
		gridData = new GridData();
		calculateButton.setLayoutData(gridData);
		calculateButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				String[] strArray = {massText1.getText(), massText2.getText(), speedText1.getText(), speedText2.getText()};
				if(model.isValidation(strArray)) {
					int mass1 = Integer.parseInt(massText1.getText());
					int mass2 = Integer.parseInt(massText2.getText());
					int speed1 = Integer.parseInt(speedText1.getText());
					int speed2 = Integer.parseInt(speedText2.getText());
					int result = model.calculateResultSpeed(mass1, mass2, speed1, speed2);
					resultLabel.setText(Integer.toString(result));
				} else {
					resultLabel.setText("");
				}
				resetTextFields();
			}
		});
	}
	
	public void addCalculateListener(SelectionAdapter sel) {
		calculateButton.addSelectionListener(sel);
	}
	
	public void resetTextFields() {
		massText1.setText("");
		massText2.setText("");
		speedText1.setText("");
		speedText2.setText("");
	}
	

}
