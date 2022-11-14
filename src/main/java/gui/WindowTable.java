package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import businessLogic.BLFacade;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import domain.Bet;
import domain.UserAdapter;
import domain.Usuario;

public class WindowTable extends JFrame{
	private Usuario	user;
	private JTable	tabla;
	public WindowTable(Usuario	use){
		BLFacade facade = MainGUI.getBusinessLogic();
		Usuario us =facade.getUser(use);
		//super("Apuestas	realizadas	por	"+	us.getUserName() +":");
		this.setBounds(100,	100,	700,	200);
		this.user=us;
		List<Bet>apuestas = facade.getBet(us);
		UserAdapter	adapt	=	new UserAdapter((ArrayList<Bet>) apuestas);
		tabla =	new JTable(adapt);
		tabla.setPreferredScrollableViewportSize(new Dimension(500,	70));
		//Creamos un JscrollPane	y	le agregamos la JTable
		JScrollPane	scrollPane =	new JScrollPane(tabla);
		//Agregamos el	JScrollPane	al contenedor
		getContentPane().add(scrollPane,BorderLayout.CENTER);
	}
}
