/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import entity.User;
import facade.AssignmentFacade;
import facade.SolutionFacade;
import facade.UserFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PeterBoss
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Persistence.generateSchema("myPU", null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");

        UserFacade uf = new UserFacade();
        AssignmentFacade af = new AssignmentFacade();
        SolutionFacade sf = new SolutionFacade();

        uf.addEntityManagerFactory(emf);
        af.addEntityManagerFactory(emf);
        sf.addEntityManagerFactory(emf);
        
        EntityManager em = emf.createEntityManager();
        
        List<User> usersInRange = uf.getUsersInRange(9.5f, 10.0f);
        
        System.out.println(usersInRange.size() + " users in range");
        for (User u : usersInRange) {
            System.out.println(u.getId() + ": "+ u.getName() + " (" + u.getRating() + ")");
        }
    }
}
