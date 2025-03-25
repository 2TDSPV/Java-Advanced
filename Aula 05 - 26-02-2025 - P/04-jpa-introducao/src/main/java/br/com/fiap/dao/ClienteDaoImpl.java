package br.com.fiap.dao;

import br.com.fiap.entity.Cliente;
import br.com.fiap.exception.IdNaoEncontradoException;
import jakarta.persistence.EntityManager;

public class ClienteDaoImpl {
    private EntityManager em;

    public ClienteDaoImpl(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente) {
        em.persist(cliente);
    }

    public void atualizar(Cliente cliente) throws IdNaoEncontradoException{
        buscarPorId(cliente.getId());
        em.merge(cliente);
    }

    public  void remover(int id) throws IdNaoEncontradoException{
        Cliente cliente = buscarPorId(id);
        em.remove(cliente);
    }
}
