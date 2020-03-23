package ar.edu.unlam.pb2;

public class Cerradura {
	private Integer contraseña;
	private Boolean abierto=false;
	private Integer cantidadIntentosConsecutivos=3;
	private Integer contadorIntentosfallidos=0;
	private Boolean fueBloqueada=false;
	
	public Cerradura(Integer contraseña){
		this.contraseña=contraseña;
	}
	
	public void abrirCerradura(Integer contraseña){
		if ((this.contraseña==contraseña && contadorIntentosfallidos<cantidadIntentosConsecutivos && fueBloqueada==false)||
				(this.contraseña==contraseña && contadorIntentosfallidos==cantidadIntentosConsecutivos && fueBloqueada==false)) {
			abierto=true;
			contadorIntentosfallidos=0;
		} else {
			contadorIntentosfallidos++;
			//|| contadorIntentosfallidos>cantidadIntentosConsecutivos
			if ((this.contraseña!=contraseña && contadorIntentosfallidos==cantidadIntentosConsecutivos)) {
				fueBloqueada=true;
			}
			
		}
	}
	
	public void cambiaContraseña(Integer NuevaContraseña){
		contraseña=NuevaContraseña;
	}
	
	public Boolean bloqueada(){
		return fueBloqueada;
	}
	
	public Boolean verEstado(){
		return abierto;
	}
	
}
