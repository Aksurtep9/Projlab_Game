package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Canvas extends JPanel{
	/**the current field on display*/
	private Field f;
	
	/**unique id*/
	private static final long serialVersionUID = -3199843376415906925L;
	
	/**The number of neighbours.*/
	protected int verticesNum=0;
	
	/**The component on which the drawings happen.*/
	protected Graphics graphics;
	
	/**The visual representer of the enemy virologist if there is any.*/
	protected EnemyView enemy;
	
	/**The visual representer of the equipment if there is any.*/
	protected EquipmentView equipment;
	
	/**The visual representer of the materials if there is any.*/
	protected MaterialView material;
	
	/**The visual representer of the genCode if there is any.*/
	protected GenCodeView genCode;
	
	/**The visual representer of the Bear dancer virologist if there is any.*/
	protected BearView bear;
	
	/**The visual representer of the field where the virologist stands*/
	protected View field;
	
	/**The buttons the user interacts with.*/
	protected JButton[] buttons;
	
	
	/**
	 * default constructor
	 */
	public Canvas(int vert,Field f) {
		
		verticesNum = vert;
		buttons = new JButton[8];
		for(int i = 0; i < buttons.length; i++) {
			String name=Integer.toString(i+1);
			buttons[i] = new JButton(name);
			this.add(buttons[i]);
			buttons[i].addActionListener(new NumberButtonPressed());
		}
		this.f=f;
		enemy = new EnemyView();
		equipment = new EquipmentView();
		material = new MaterialView();
		genCode = new GenCodeView();
		bear = new BearView();
		
		for(int i = 7; i>=verticesNum; i--) {
			buttons[i].setVisible(false);
		}
	}
	
	/**
	 * Responsible for adding the buttons representing the choice which way the user want to move.
	 */
	public void Draw(int vertices) {
		
		switch(vertices) {
		case 3:
			buttons[0].setBounds(200, 350, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(350, 400, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 300, 150, 100);
			buttons[2].setVisible(true);
			
			
			break;
		case 4:
			buttons[0].setBounds(350, 100, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(600, 350, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 600, 150, 100);
			buttons[2].setVisible(true);
			buttons[3].setBounds(100, 600, 150, 100);
			buttons[3].setVisible(true);
			break;
		case 5:
			buttons[0].setBounds(450, 150, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(400, 400, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 500, 150, 100);
			buttons[2].setVisible(true);
			buttons[3].setBounds(300, 400, 150, 100);
			buttons[3].setVisible(true);
			buttons[4].setBounds(250, 150, 150, 100);
			buttons[4].setVisible(true);
			break;
		case 6:
			buttons[0].setBounds(450, 150, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(400, 400, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 500, 150, 100);
			buttons[2].setVisible(true);
			buttons[3].setBounds(300, 400, 150, 100);
			buttons[3].setVisible(true);
			buttons[4].setBounds(250, 150, 150, 100);
			buttons[4].setVisible(true);
			buttons[5].setBounds(350, 150, 150, 100);
			buttons[5].setVisible(true);
			break;
		case 7:
			buttons[0].setBounds(450, 150, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(400, 400, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 500, 150, 100);
			buttons[2].setVisible(true);
			buttons[3].setBounds(300, 400, 150, 100);
			buttons[3].setVisible(true);
			buttons[4].setBounds(250, 150, 150, 100);
			buttons[4].setVisible(true);
			buttons[5].setBounds(350, 150, 150, 100);
			buttons[5].setVisible(true);
			buttons[6].setBounds(150, 150, 150, 100);
			buttons[6].setVisible(true);
			break;
		case 8:
			buttons[0].setBounds(450, 150, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(400, 400, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 500, 150, 100);
			buttons[2].setVisible(true);
			buttons[3].setBounds(300, 400, 150, 100);
			buttons[3].setVisible(true);
			buttons[4].setBounds(250, 150, 150, 100);
			buttons[4].setVisible(true);
			buttons[5].setBounds(350, 150, 150, 100);
			buttons[5].setVisible(true);
			buttons[6].setBounds(150, 150, 150, 100);
			buttons[6].setVisible(true);
			buttons[7].setBounds(150, 400, 150, 100);
			buttons[7].setVisible(true);
			break;
		default:
			break;
			
		}

	}
	
	/**
	 * Action listener for numbered buttons. This method selects the field on which the virologist will move to.
	 * @param e button event
	 */
	public class NumberButtonPressed implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			/**iterates through the list of buttons*/
			for(int i = 0; i < buttons.length; i++) {
				/**if the i-the button was pressed...*/
				if(buttons[i] == e.getSource() && Game.getActionCount() > 0  && !Game.getCurrentPlayer().isBear()) {
					/**...the attribute "f" gets set to the i-th neighbour of the current "f" field*/
					f = f.GetNeighbours().get(i);
					Virologist v = Game.getCurrentPlayer();
					v.Move(f);
					Game.decreaseActioncount();
				}
			}
			repaint();
		}
	}
	
	/**
	 * sets the field of the canvas to the field given as parameter
	 * @param f field
	 */
	public void setField(Field f) {
		this.f=f;
	}
	
	/**
	 * Redraws the field, and draws genetic codes/ etc. in it, if needed.
	 * @param g graphics
	 * @param f field
	 */
	public void Refresh(Graphics g,Field f) {
		this.f=f;
		int prevVerticesNum=0;
		
		if(buttons!=null) {
			prevVerticesNum=verticesNum;
		}	
		verticesNum = f.GetNeighbours().size();

		if(verticesNum<prevVerticesNum) {
			for(int i=prevVerticesNum; i>verticesNum; --i) {
				buttons[i-1].setVisible(false);
			}
		} else if(prevVerticesNum<verticesNum) {
			for(int i=prevVerticesNum;i<verticesNum; ++i) {
				buttons[i].setVisible(true);
			}
		}
		
        
		/**drawing the field according to its type, because every
		 * child of Field looks different*/
		int lab=0;
		switch(f.toString()) {
			case "Warehouse":
			{
				field = new WarehouseView(verticesNum);
				lab=1;
				break;
			}
			case "Shelter":
			{
				field = new ShelterView(verticesNum);
				break;
			}
			case "Laboratory":
			{
				field = new LaborView(verticesNum);
				lab=2;
				break;
			}
			default:
			{
				field = new FieldView(verticesNum);
				break;
			}
		}
		field.Draw(graphics, new Point(300, 300));
		thingsPaint(g);
		/**if the field is a lab, draws a genetic code on it, 
		 * if it is a warehouse, draws a material on it*/
		if(lab==1)
			material.Draw(g, new Point(470,490));
		else if(lab==2)
			genCode.Draw(g, new Point(470,480));
	}
	
	/**
	 * Method responsible for displaying the different things on a field
	 * @param g graphics
	 */
	public void thingsPaint(Graphics g) {
		int virocount=0;
		int eq=0;
		for(Thing t : f.GetThings())
		{
			/**if there is a virologist on the field, we increment the counter, but
			 * the enemy icon should only be displayed, if there are
			 * at least two virologists on the field*/
			if(t.toString().contains("Virologist"))
				virocount++;
			else if(t.toString().contains("Axe") || t.toString().contains("Cloak") || t.toString().contains("Sack") || t.toString().contains("Gloves"))
				eq++;
		}
		
		Virologist player = Game.getCurrentPlayer();
		
		ArrayList<Virologist> enemies = new ArrayList<>();
		for(Thing item: player.GetField().GetThings()) {
			if(item.toString().contains("Virologist")) {
				Virologist vir = (Virologist) item;
				if(!vir.getName().equals(player.getName()))
					enemies.add(vir);
			}
		}
		
		if(virocount>0) {
			for(Virologist v : enemies) {
				if(v.isBear()) {
					bear.Draw(g, new Point(500,500));
				}else {
					enemy.Draw(g, new Point(430,430));
				}
			}	
		}
		if(eq>0)
			equipment.Draw(g, new Point(370, 440));
	}
	
	/**
	 * Responsible for drawing the elements on this field.
	 * @param g graphics
	 */
	public void paintComponent(Graphics g) {
		graphics=g;
		super.paintComponent(graphics);
		Refresh(graphics,f);
		g.setColor(new Color(255, 0, 0));
		g.fillOval(550, 550, 30,30);
		
		g.setColor(new Color(0,150,0));
		g.setFont(new Font("Arial", 1, 30));
		String line = f.toString() +": " + f.getID() + "      Player: " + Game.getCurrentPlayer().getName();
		g.drawString(line, 200, 200);
	}
}
