package aula22_10;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.h2.result.ResultWithGeneratedKeys;

public class RegistroRepository {

    private EntityManager em;

    public RegistroRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BancoDeDados");
        em = factory.createEntityManager();
    }

    public void inserir(Registro registro) {
        this.em.getTransaction().begin();
        this.em.merge(registro);
        this.em.getTransaction().commit();
    }

    public List<Registro> buscar() {
        TypedQuery<Registro> buscarTodosQuery = this.em.createQuery("select e from Registro e", Registro.class);
        return buscarTodosQuery.getResultList();
    }

    public Registro buscar(Integer id){
         TypedQuery<Registro> query = this.em.createQuery("select e from Registro e where e.nome like :nome", Registro.class);
        query.setParameter("id", id);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Registro buscarPorId(Integer id) {
        return  this.em.find(Registro.class, id);
    }

    public void atualizar(Registro registro) {
        this.em.getTransaction().begin();
        this.em.merge(registro);
        this.em.getTransaction().commit();
    }

    public void remover(Registro registro) {
        this.em.getTransaction().begin();
        this.em.remove(registro);
        this.em.getTransaction().commit();
    }
}
