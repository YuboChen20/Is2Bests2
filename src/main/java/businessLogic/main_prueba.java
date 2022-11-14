package businessLogic;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import domain.Event;

import domain.UserAdapter;
import domain.Usuario;


public class main_prueba  {
	
	public static void main(String[]	args)	{
		//	obtener el	objeto Facade	local
		int isLocal =	1;
		BLFacade	blFacade =	new BLFactory().getBusinessLogicFactory(isLocal);
		SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = sdf.parse("1/12/2022"); //	Recuerda que los dias con eventos cambia, se recomienda ejecutar la aplicacion e ir a consulta para buscar un dia con eventos.
			ExtendedIterator<Event>	i =	blFacade.getEventsIterator(date);
			Event	e;
			System.out.println("_____________________");
			System.out.println("RECORRIDO	HACIA	ATRÁS");
			i.goLast();	//	Hacia atrás
			while (i.hasPrevious())	{
				e =	i.previous();
			System.out.println(e.toString());
			}
			System.out.println();
			System.out.println("_____________________");
			System.out.println("RECORRIDO	HACIA	ADELANTE");
			i.goFirst();	//	Hacia adelante
			while (i.hasNext())	{
				e =	i.next();
				System.out.println(e.toString());
			}
			
			
			
		}catch (ParseException	e1)	{
			System.out.println("Problems	with	date??	" +	"17/12/2020");
		}
		
		try {
			
		Usuario u=blFacade.getUser(new Usuario("User1","12345","1010293833",false,"usuariomasguapo@gmail.com"));
		ArrayList s=(ArrayList) blFacade.getBet(u);

		UserAdapter model=new UserAdapter(s);
		
		JFrame j=new JFrame();
		JTable table = new JTable(model);
		j.add(new JScrollPane(table));

		 j.setTitle(u.getUserName()+"'s bets");
		 j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 j.pack();
		 j.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
} 
