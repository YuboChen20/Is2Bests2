package domain;


import java.util.Vector;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;


@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Equipo {
	
	@XmlID
	@Id 
	private String nombre;

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Vector<Event> events=new Vector<Event>();
	
	@ManyToOne
	private Liga liga;
	
	private double numUsuariosApuestan;
	private double dineroApostado;
	
	public Equipo(String nombre, Liga liga) {
		this.nombre=nombre;
		this.setNumUsuariosApuestan(0);
		this.setDineroApostado(0);
		this.liga=liga;
		liga.anadirEquipo(this);
	}
	public String getNombre() {
		return nombre;
	}

	public Vector<Event> getEvents() {
		return events;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEvents(Vector<Event> questions) {
		this.events = questions;
	}
	
	public double getDineroApostado() {
		return dineroApostado;
	}
	public void setDineroApostado(double dineroApostado) {
		this.dineroApostado = dineroApostado;
	}
	public Liga getLiga() {
		return liga;
	}
	public void setLiga(Liga liga) {
		this.liga = liga;
	}
	public void anadirEvento(Event ev) {
		this.events.add(ev);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		if (nombre != other.nombre)
			return false;
		return true;
	}
	
	 @Override
	  public int hashCode() {
		 int prime = 31;
		 int result = 1;
		 result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		 return result;
	  }
	
	@Override
	public String toString() {
		return nombre;
	}
	public double getNumUsuariosApuestan() {
		return numUsuariosApuestan;
	}
	public void setNumUsuariosApuestan(double numUsuariosApuestan) {
		this.numUsuariosApuestan = numUsuariosApuestan;
	}
	public void incrNumUsuariosApuestan() {
		this.numUsuariosApuestan = numUsuariosApuestan+1;
	}
	public void halfIncrNumUsuariosApuestan() {
		this.numUsuariosApuestan = numUsuariosApuestan+0.5;
	}
	
	
	
	
	

	
}