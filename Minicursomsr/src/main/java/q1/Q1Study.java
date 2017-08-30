/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import java.io.Writer;
import org.repodriller.RepoDriller;
import org.repodriller.RepositoryMining;
import org.repodriller.Study;
import org.repodriller.filter.range.Commits;
import org.repodriller.persistence.csv.CSVFile;
import org.repodriller.scm.GitRemoteRepository;
import org.repodriller.scm.GitRepository;

/**
 *
 * @author a1817400
 */
public class Q1Study implements Study{
    public static void main(String[] args) {
        new RepoDriller().start(new Q1Study());
    }

    @Override
    public void execute() {
        new RepositoryMining()
                .in(GitRemoteRepository
                        .hostedOn("https://github.com/gabrielhamilton/Minicurso.git")
                        .buildAsSCMRepository())
                .through(Commits.all())
                .process(new CommitVisitor(), new CSVFile("/home/todos/alunos/cm/a1817400/Documentos/q1.csv"))
                .mine();
                    
    }
    
    
}
