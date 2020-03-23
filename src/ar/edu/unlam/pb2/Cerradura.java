package ar.edu.unlam.pb2;

public class Cerradura {
	private Integer contrase�a;
	private Boolean abierto=false;
	private Integer cantidadIntentosConsecutivos=3;
	private Integer contadorIntentosfallidos=0;
	private Boolean fueBloqueada=false;
	
	public Cerradura(Integer contrase�a){
		this.contrase�a=contrase�a;
	}
	
	public void abrirCerradura(Integer contrase�a){
		if ((this.contrase�a==contrase�a && contadorIntentosfallidos<cantidadIntentosConsecutivos && fueBloqueada==false)||
				(this.contrase�a==contrase�a && contadorIntentosfallidos==cantidadIntentosConsecutivos && fueBloqueada==false)) {
			abierto=true;
			contadorIntentosfallidos=0;
		} else {
			contadorIntentosfallidos++;
			//|| contadorIntentosfallidos>cantidadIntentosConsecutivos
			if ((this.contrase�a!=contrase�a && contadorIntentosfallidos==cantidadIntentosConsecutivos)) {
				fueBloqueada=true;
			}
			
		}
	}
	
	public void cambiaContrase�a(Integer NuevaContrase�a){
		contrase�a=NuevaContrase�a;
	}
	
	public Boolean bloqueada(){
		return fueBloqueada;
	}
	
	public Boolean verEstado(){
		return abierto;
	}
	
}
