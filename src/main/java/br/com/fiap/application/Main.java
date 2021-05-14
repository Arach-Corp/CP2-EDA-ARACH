package br.com.fiap.application;

import br.com.fiap.dao.DAO;
import br.com.fiap.dao.exceptions.CommitException;
import br.com.fiap.dao.impl.*;
import br.com.fiap.entities.*;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
        EntityManager em = emf.createEntityManager();


        DAO<Usuario, Long> usuarioDAO = new UsuarioDAOImpl(em);
        Usuario user = new Usuario(null, "Fulano", "dulano@gmail.com", "*******", "url_da_foto");
        try {
            usuarioDAO.insert(user);
            usuarioDAO.commit();
            System.out.println("Usuario inserido com sucesso!");
        } catch (CommitException e) {
            e.printStackTrace();
        }


        DAO<Dispositivo, Long> dispositivoDAO = new DispositivoDAOImpl(em);
        Dispositivo dispositivo =new Dispositivo(null, "Dispensa Casa 1", "sad56as7d56as7d89sad53a");
        try {
            dispositivoDAO.insert(dispositivo);
            dispositivoDAO.commit();
            System.out.println("Dispositivo inserido com sucesso!");
        } catch (CommitException e) {
            e.printStackTrace();
        }


        DAO<Produto, Long> produtoDAO = new ProdutoDAOImpl(em);
        Produto produto = new Produto(null, "Achocolatado Nescau Radical", "Achocolatado integral", "Nestlé", "url_foto");
        try {
            produtoDAO.insert(produto);
            produtoDAO.commit();
            System.out.println("Produto cadastrado com sucesso inserido com sucesso!");
        } catch (CommitException e) {
            e.printStackTrace();
        }


        DAO<InformacaoNutricional, Long> infoNutriDAO = new InformacaoNutricionalDAOImpl(em);
        InformacaoNutricional infoNutri = new InformacaoNutricional(null, "30g", "10g", "0.1g", "20g", "1g", "10g", "0g", "0g", produto);
        try {
            infoNutriDAO.insert(infoNutri);
            infoNutriDAO.commit();
            System.out.println("Informação nutricional inserida com sucesso!");
        } catch (CommitException e) {
            e.printStackTrace();
        }

        DAO<Lote, Long> loteDAO = new LoteDAOImpl(em);
        Lote lote = new Lote(null, LocalDateTime.now(), LocalDateTime.now(), true, produto);
        try {
            loteDAO.insert(lote);
            loteDAO.commit();
            System.out.println("Lote inserido com sucesso!");
        } catch (CommitException e) {
            e.printStackTrace();
        }

        DAO<ItemDispensa, Long> itemDispensaDAO = new ItemDispensaDAOImpl(em);
        ItemDispensa itemDispensa = new ItemDispensa(null, 1, true, lote, dispositivo);
        try {
            itemDispensaDAO.insert(itemDispensa);
            itemDispensaDAO.commit();
            System.out.println("Item dispensa inserido com sucesso!");
        } catch (CommitException e) {
            e.printStackTrace();
        }


        DAO<Notificacao, Long> notificacaoDAO = new NotificacaoDAOImpl(em);
        Notificacao notificacao = new Notificacao(null, user, "Produto adicionado a dispensa", "Um novo produto foi adicionado à dispensa");
        try {
            notificacaoDAO.insert(notificacao);
            notificacaoDAO.commit();
            System.out.println("Notificacao inserida com sucesso!");
        } catch (CommitException e) {
            e.printStackTrace();
        }

        emf.close();
        em.close();
    }
}
