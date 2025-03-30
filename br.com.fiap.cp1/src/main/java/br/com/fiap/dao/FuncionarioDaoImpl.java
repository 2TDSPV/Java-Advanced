package br.com.fiap.dao;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;

import javax.persistence.EntityManager;

public class FuncionarioDaoImpl implements FuncionarioDao {

    private EntityManager em;

    public FuncionarioDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void cadastrar(Funcionario funcionario) {
        em.persist(funcionario);

    }

    @Override
    public void atualizar(Funcionario funcionario) throws IdNaoEncontradoException {
        buscarPorId(funcionario.getIdFuncionario());
        em.merge(funcionario);

    }

    @Override
    public void remover(int id) throws IdNaoEncontradoException {
        Funcionario funcionario = buscarPorId(id);
        em.remove(funcionario);

    }

    @Override
    public Funcionario buscarPorId(int idFuncionario) throws IdNaoEncontradoException {
        Funcionario funcionario = em.find(Funcionario.class, idFuncionario);
        if (funcionario == null) {
            throw new IdNaoEncontradoException("Funcionario não encontrado");
        }
        return funcionario;
    }

    @Override
    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new CommitException("Erro ao realizar o commit", e);
        }
    }

}
