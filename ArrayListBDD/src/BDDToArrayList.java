import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class BDDToArrayList {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/users";
			String user = "root";
			String pwd = "Pierrebing59";
			
			Connection cn = (Connection) DriverManager.getConnection(url, user, pwd);
			
			Statement st = (Statement) cn.createStatement();
			
			String sql = "SELECT * FROM personne";
			
			ResultSet result = st.executeQuery(sql);
			
			ArrayList<Personne> listePersonne = new ArrayList<Personne>();
			
			while(result.next()) {
				
				Personne p = new Personne();
				
				p.setNom(result.getString("nom"));
				p.setPrenom(result.getString("prenom"));
				p.setAge(result.getInt("age"));
				p.setEmail(result.getString("email"));
				p.setTelephone(result.getString("telephone"));
				
				listePersonne.add(p);
				
			}
			for(int i = 0; i <listePersonne.size(); i++) {
				System.out.print(listePersonne.get(i).getNom());
				System.out.print(" " +listePersonne.get(i).getPrenom());
				System.out.print(" " +listePersonne.get(i).getAge());
				System.out.print(" " +listePersonne.get(i).getEmail());
				System.out.println(" " +listePersonne.get(i).getTelephone());
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
