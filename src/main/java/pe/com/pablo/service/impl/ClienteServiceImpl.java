package pe.com.pablo.service.impl;

import pe.com.pablo.entity.Cliente;
import pe.com.pablo.service.ClienteService;
import pe.com.pablo.dao.ClienteDAO;
import pe.com.pablo.dao.impl.ClienteDAOImpl;

public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Integer> implements ClienteService  {
	
	private ClienteDAO ClienteDAO;

    public ClienteServiceImpl() {
        super(new ClienteDAOImpl());
        this.ClienteDAO = (ClienteDAO) super.dao;
    }
}
