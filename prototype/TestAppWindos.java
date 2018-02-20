package prototype;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import swing2swt.layout.BoxLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.FillLayout;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class TestAppWindos {

	protected Shell shell;
	private Table table;
	/**
	 * @wbp.nonvisual location=174,259
	 */
	private final TrayItem trayItem = new TrayItem(Display.getDefault().getSystemTray(), SWT.NONE);

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TestAppWindos window = new TestAppWindos();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
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
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmTestitem = new MenuItem(menu, SWT.NONE);
		mntmTestitem.setText("TestItem");
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("New SubMenu");
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem mntmNewItem_1 = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_1.setText("New Item");
		
		MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		mntmNewItem.setText("New Item");
		
		MenuItem menuItem = new MenuItem(menu, SWT.SEPARATOR);
		menuItem.setText("testseparator");
		
		MenuItem mntmNewSubmenu_1 = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu_1.setText("New SubMenu");
		
		Menu menu_2 = new Menu(mntmNewSubmenu_1);
		mntmNewSubmenu_1.setMenu(menu_2);
		
		MenuItem mntmNewCheckbox = new MenuItem(menu, SWT.CHECK);
		mntmNewCheckbox.setText("New CheckBox");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				System.out.println("testEvent");
			}
		});
		btnNewButton.setBounds(158, 67, 75, 25);
		btnNewButton.setText("New Button");
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(285, 207, 139, 24);
		
		Browser browser = new Browser(shell, SWT.NONE);
		browser.setBounds(10, 106, 128, 110);
		
		DragSource dragSource = new DragSource(browser, DND.DROP_MOVE);
		
		CoolBar coolBar = new CoolBar(shell, SWT.FLAT);
		coolBar.setBounds(133, 129, 279, 30);
		
		Label lblSeparator = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblSeparator.setText("separator");
		lblSeparator.setBounds(138, 165, 296, 24);
		
		CLabel lblNewLabel = new CLabel(shell, SWT.NONE);
		lblNewLabel.setBounds(195, 138, 61, 21);
		lblNewLabel.setText("New Label");
		
		StyledText styledText = new StyledText(shell, SWT.BORDER);
		styledText.setBounds(316, 92, 69, 67);
		
		Link link = new Link(shell, SWT.NONE);
		link.setBounds(195, 207, 49, 15);
		link.setText("<a>TestLink</a>");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(286, 67, 138, 19);
		lblNewLabel_1.setText("New Label");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 46, 128, 45);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableCursor tableCursor = new TableCursor(table, SWT.NONE);
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(261, 10, 163, 68);
		
		ExpandBar expandBar = new ExpandBar(shell, SWT.NONE);
		expandBar.setBounds(168, 100, 128, 32);
		
		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setBounds(146, -3, 64, 64);
		
		List list_1 = new List(shell, SWT.BORDER);
		list_1.setBounds(40, -7, 71, 68);

	}
}
