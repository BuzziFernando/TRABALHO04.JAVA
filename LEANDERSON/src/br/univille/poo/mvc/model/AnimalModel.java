package br.univille.poo.mvc.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import JDBC.AnimaisDAO;
import br.univille.poo.mvc.util.Observer;
import br.univille.poo.mvc.util.Subject;

public class AnimalModel implements  Subject{
	
	private long id;
	private String Especie;
	private String Raça;
	private String Animal;
	private List<Observer> list;
	
	public AnimalModel() {
		list = new ArrayList<Observer>();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEspecie() {
		return Especie;
	}
	public void setEspecie(String Especie) {
		this.Especie = Especie;
	}
	public String getRaca() {
		return Raça;
	}
	public void setRaça(String Raça) {
		this.Raça = Raça;
	}
	public String getAnimal() {
		return Animal;
	}
	public void setAnimal(String Animal) {
		this.Animal = Animal;
	}
	
	
	public void novo() {
		id = 0;
		Especie = "";
		Raça = "";
		Animal = "";
		notifyObservers();
	}
	
	@Override
	public String toString() {
		return "PessoaModel [id=" + id + ", Especie=" + Especie + ", Raça=" + Raça + ", Animal=" + Animal + "]";
	}
	
	
	@Override
	public void attach(Observer o) {
		list.add(o);
	}

	@Override
	public void detach(Observer o) {
		list.remove(o);
	}

	@Override
	public void notifyObservers() {
		// Avisa cada um dos observadores
		for(Observer o : list) {
			// Atualiza a informacao no observador
			o.update(this, this);
		}
	}

	public void salvar() throws Exception {
		
		if(Raça == null || Raça.isEmpty()) {
			throw new Exception("Raça Ã© invÃ¡lido");
		}
		if(Especie == null || Especie.isEmpty()) {
			throw new Exception("Especie Ã© invÃ¡lido");
		}
		if(Animal == null || Animal.isEmpty()) {
			throw new Exception("Animal Ã© invÃ¡lido");
		}
		//Novo Raça
		System.out.println("ola");
		if(id == 0) {
			// Gera um id
			id = (new Random()).nextInt(100);
			// insere no banco de dados
			AnimaisDAO dao = new AnimaisDAO();
			dao.insert(this);
			System.out.println("ola");
		}else {
			// Atualizar no banco de dados
			
		}
		notifyObservers();
	}
	
	public void deletar() {
		//deletar no banco de dados
		novo();
		notifyObservers();
	}
	
	

}
