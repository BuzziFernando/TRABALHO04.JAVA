package br.univille.poo.mvc;

import br.univille.poo.mvc.control.CadastroAnimalControl;
import br.univille.poo.mvc.model.AnimalModel;
import br.univille.poo.mvc.view.CadastroAnimalView;

public class Main {

	public static void main(String[] args) {
		AnimalModel p = new AnimalModel();
		p.setRaça("101");
		p.setAnimal("cachorro Dalmata");
		p.setEspecie("Mamifero");
		p.setId(123);
		
		CadastroAnimalControl control = new CadastroAnimalControl(new CadastroAnimalView(),p);
		control.exibirTela();
	}

}
