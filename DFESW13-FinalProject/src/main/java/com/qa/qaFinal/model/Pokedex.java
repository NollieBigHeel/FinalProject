package com.qa.qaFinal.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokedex {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 30) // value cannot be null
	private String name;
	
	@Column(nullable = false, length = 30)
	private String type;
	
	@Column(nullable = false) // value cannot be null
	private int hp;
	
	@Column(nullable = true, length = 250)
	private String description;
	
	@Column(nullable = false)
	private boolean traded;

	public Pokedex() {
		super();
		
	}
    // With id
	public Pokedex(long id, String name, String type, int hp, String description, boolean traded) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.hp = hp;
		this.description = description;
		this.traded = traded;
	}	
	
	// Without id
	public Pokedex(String name, String type, int hp, String description, boolean traded) {
		super();
		this.name = name;
		this.type = type;
		this.hp = hp;
		this.description = description;
		this.traded = traded;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isTraded() {
		return traded;
	}
	public void setTraded(boolean traded) {
		this.traded = traded;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, hp, id, name, traded, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Pokedex other = (Pokedex) obj;
		return Objects.equals(description, other.description) && hp == other.hp && id == other.id
				&& Objects.equals(name, other.name) && traded == other.traded && Objects.equals(type, other.type);
	}
	@Override
	public String toString() {
		return "Pokedex [id=" + id + ", name=" + name + ", type=" + type + ", hp=" + hp + ", description=" + description
				+ ", traded=" + traded + "]";
	}
	
	
	

	
	
	
	
	

}
