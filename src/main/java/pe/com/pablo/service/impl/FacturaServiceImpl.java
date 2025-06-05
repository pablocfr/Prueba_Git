package pe.com.pablo.service.impl;

import pe.com.pablo.dao.FacturaDAO;
import pe.com.pablo.entity.Factura;
import pe.com.pablo.service.FacturaService;
import pe.com.pablo.dao.impl.FacturaDAOImpl;

public class FacturaServiceImpl extends GenericServiceImpl<Factura, Integer> implements FacturaService {
	
	private FacturaDAO facturaDAO;

    public FacturaServiceImpl() {
        super(new FacturaDAOImpl());
        this.facturaDAO = (FacturaDAO) super.dao;
    }
}
