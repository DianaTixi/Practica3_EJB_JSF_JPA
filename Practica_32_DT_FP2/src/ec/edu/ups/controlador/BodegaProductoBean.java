package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;



import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.BodegaProductoFacade;
import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.BodegaProducto;
import ec.edu.ups.entidad.Categoria;
import ec.edu.ups.entidad.Ciudad;
import ec.edu.ups.entidad.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class BodegaProductoBean implements Serializable {
	private static final long serialVersionUID = 1L;

    @EJB
    private BodegaProductoFacade ejBodegaProductoFacade;
    
    @EJB
    private BodegaFacade ejBodegaFacade;
    
    @EJB
    private ProductoFacade ejProductoFacade;
    
    @EJB
    private CategoriaFacade ejCategoriaFacade;
    
    private List<BodegaProducto> listaBodPro;
    private BodegaProducto bodegaProducto;
    
    private List<Producto>listaProductos;  
    private Producto producto;
    
    private List<Bodega> listaBodegas;
    private Bodega bodega;
    
    private List<BodegaProducto> listaBodegaP;
   private String nombrePro;
   private String nombreBodega;
   private String nombreBodega1;
   private String stock;
   private String opcion;
   
   private int stock1;
   
   public BodegaProductoBean() {
	super();
	// TODO Auto-generated constructor stub
   }
   
   @PostConstruct
   public void init() {
		listaBodPro = new ArrayList<BodegaProducto>();
		listaBodegas= new ArrayList<Bodega>();
		listaProductos = new ArrayList<Producto>();
		listaBodegaP = new ArrayList<BodegaProducto>();
		listaBodPro = ejBodegaProductoFacade.findAll();
	
   }

	public BodegaProducto[] getListaBodPro() {
		return listaBodPro.toArray(new BodegaProducto[0]);
	}
	
	public void setListaBodPro(List<BodegaProducto> listaBodPro) {
		this.listaBodPro = listaBodPro;
	}
	
	public BodegaProducto getBodegaProducto() {
		return bodegaProducto;
	}
	
	public void setBodegaProducto(BodegaProducto bodegaProducto) {
		this.bodegaProducto = bodegaProducto;
	}
	
	public List<Producto> getListaProductos() {
		return listaProductos;
	}
	
	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public List<Bodega> getListaBodegas() {
		return listaBodegas;
	}
	
	public void setListaBodegas(List<Bodega> listaBodegas) {
		this.listaBodegas = listaBodegas;
	}
	
	public Bodega getBodega() {
		return bodega;
	}
	
	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}
	
	public String getNombrePro() {
		return nombrePro;
	}
	
	public void setNombrePro(String nombrePro) {
		this.nombrePro = nombrePro;
	}
	
	public String getNombreBodega() {
		return nombreBodega;
	}
	
	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}
	
	public String getStock() {
		return stock;
	}
	
	public void setStock(String stock) {
		this.stock = stock;
	}
	
	public int getStock1() {
		return stock1;
	}
	
	public void setStock1(int stock1) {
		this.stock1 = stock1;
	}
	
	
	public String getNombreBodega1() {
		return nombreBodega1;
	}

	public void setNombreBodega1(String nombreBodega1) {
		this.nombreBodega1 = nombreBodega1;
	}

	public List<BodegaProducto> getListaBodegaP() {
		return listaBodegaP;
	}
	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public void setListaBodegaP(List<BodegaProducto> listaBodegaP) {
		this.listaBodegaP = listaBodegaP;
	}

	public String add() {
		System.out.println("Producto: "+this.nombrePro+ "| Bodega: "+ this.nombreBodega+ "| Stock"+ this.stock);
		try {
		
			Bodega bodega = ejBodegaFacade.buscarBodega(this.nombreBodega);
			System.out.println("La bodega encontra es :"+bodega.getNombre()+ "| ID: "+bodega.getId());
			
			Producto producto = ejProductoFacade.buscarProducto(this.nombrePro);
			System.out.println("El Producto encontrado es: "+ producto.getNombre()+ "| ID: "+producto.getId());
			
			stock1 = Integer.valueOf(stock);
			ejBodegaProductoFacade.create(new BodegaProducto(0, stock1, bodega, producto));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "GestionProductos.xhtml";
		
	}
	
	public String ConsultarInv() {
		//BodegaProducto bp= ejBodegaProductoFacade.TotalProductos();
		//System.out.println("EL Stock Total es :"+ bp.getStock());
		return null;
	}
	
	public String InventarioBodega() {
		System.out.println("La Bodega es :" +this.nombreBodega);
		Bodega bodega = ejBodegaFacade.buscarBodega(this.nombreBodega);
		int idBodega = bodega.getId();
		System.out.println("Bodega Escogida: "+bodega.getId() + "| "+ bodega.getNombre());
		listaBodegaP = ejBodegaProductoFacade.InventarioBodega(idBodega);
		return null;
	}
	
	public String editar() {
		System.out.println("La bodega es "+ this.nombreBodega);
		Bodega bodega = ejBodegaFacade.buscarBodega(this.nombreBodega);
		System.out.println("Bodega es :"+ bodega.getNombre()+ "Id es: "+bodega.getId());
		
		Producto producto = ejProductoFacade.buscarProducto(this.nombrePro);
		System.out.println("Producto es :"+ producto.getNombre()+ "Id es: "+producto.getId());
		
		int idB= bodega.getId();
		int idP= producto.getId();
		BodegaProducto bodegaProducto = ejBodegaProductoFacade.buscar(idB, idP);
		
		System.out.println("El Id de BP es :"+ bodegaProducto.getId());
		
		
		stock1 = Integer.valueOf(this.stock);
		bodegaProducto.setStock(stock1);
		ejBodegaProductoFacade.edit(bodegaProducto);
		
		return null;
	}
	
	public String Catalogo() {
		String opcion1="Bodegas";

		String opcion2="Categorias";
		try {
			if (this.opcion.equals(opcion1)) {
				System.out.println("La Bodega es :" +this.nombreBodega);
				Bodega bodega = ejBodegaFacade.buscarBodega(this.nombreBodega);
				int idBodega = bodega.getId();
				System.out.println("Bodega Escogida: "+bodega.getId() + "| "+ bodega.getNombre());
				listaBodegaP = ejBodegaProductoFacade.InventarioBodega(idBodega);
				
			}
			if (this.opcion.equals(opcion2)) {
				System.out.println("La Categorias es :" +this.nombreBodega);
				Categoria categoria = ejCategoriaFacade.buscarCategoria(this.nombreBodega);
				int idCate = categoria.getId();
				//listaProductos= 
				//listaBodegaP= ejProductoFacade.ListarProductoCateg(idCate);
		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	
}
