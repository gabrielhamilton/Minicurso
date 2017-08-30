/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2;

import org.repodriller.domain.Commit;
import org.repodriller.persistence.PersistenceMechanism;
import org.repodriller.scm.CommitVisitor;
import org.repodriller.scm.SCMRepository;

/**
 *
 * @author a1817400
 */
public class BugVisitor implements CommitVisitor 
{

    @Override
    public void process(SCMRepository scmr, Commit commit, PersistenceMechanism pm) 
    {
        
        boolean tembug = commit.getMsg().toLowerCase().contains("bug");
        int numarq = commit.getModifications().size();
        
        if(tembug)
        {
            pm.write(commit.getHash(), numarq);
        }
                       
    }

    @Override
    public String name() 
        {            
        return "Bug-visitor";
        }
    
}
