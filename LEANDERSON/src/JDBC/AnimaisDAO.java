package JDBC;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.univille.poo.mvc.model.AnimalModel;


public class AnimaisDAO extends BasicoDAO {
	
	public void insert(AnimalModel animais) {

        String sql = " insert Into animal ( Animal, Especie, Raca) values(?,?,?)";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)){
          
            statement.setString(1, animais.getAnimal());
            statement.setString(2, animais.getEspecie());
            statement.setString(3, animais.getRaca());
            statement.execute();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(AnimalModel animais) {

        String sql = " delete from animal where Id = ?";
        
        
        // PEGAR Id ANIMAL F
        
        try(Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, animais.getId());
            statement.execute();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void update(AnimalModel animais) {
        String sql = " update animal set Id = ?, Animal = ?, Especie = ?, Raca = ? where Id = ?";
          		
        
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)){
        	statement.setLong(1, animais.getId());
            statement.setString(2, animais.getAnimal());
            statement.setString(3, animais.getEspecie());
            statement.setString(4, animais.getRaca());
            statement.execute();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

   
   
}
