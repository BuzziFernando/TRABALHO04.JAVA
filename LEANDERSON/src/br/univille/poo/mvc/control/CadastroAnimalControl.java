package br.univille.poo.mvc.control;

import br.univille.poo.mvc.model.AnimalModel;
import br.univille.poo.mvc.view.CadastroAnimalView;

public class CadastroAnimalControl {
	
	private CadastroAnimalView view;
	private AnimalModel model;
	
	public CadastroAnimalControl(CadastroAnimalView view, AnimalModel model) {
		this.view = view;
		this.model = model;
		model.attach(view);
		view.setModel(model);
		view.setControl(this);
	}
	
	public void exibirTela() {
		view.show();
		model.notifyObservers();
	}

	public void deletar() {
		model.deletar();
		view.setMensagemStatusBar("Raca deletado.");
		view.getBotaoDeletar().setEnabled(false);
	}

	public void novo() {
		model.novo();
		view.getBotaoDeletar().setEnabled(false);
		view.setMensagemStatusBar("Raca nova.");
	}
	
	public void salvar() {
		model.setAnimal(view.getAnimal());
		model.setRaça(view.getRaça());
		model.setEspecie(view.getEspecie());
		try {
			model.salvar();
			view.setMensagemStatusBar("Raca salvo com sucesso.");
			view.getBotaoDeletar().setEnabled(true);
		}catch(Exception e) {
			e.printStackTrace();
			view.setMensagemStatusBar("Erro: "+e.getMessage());
		}
	}

}
