import java.util.ArrayList;

public class Trem {
	private ArrayList<CarroFerroviario> carros;
	private int identificador;

	private int contadorCarros;
	private int contadorLocomotivas;
	private int contadorVagoes;

	private int numMaxCarros;
	private int numAuxCarros;

	private int pesoMaxCarros;
	private int pesoAtualCarros;
	private int pesoAuxCarros;


	public Trem(int identificador) {
		this.identificador = identificador;
		carros = new ArrayList<>();
	}

	public void engatarV(Vagao v){
        if(carros.isEmpty()){
            System.out.printf("\nNão é possivel engatar. | Precisa de uma locomotiva!");
			return;
        }
        if(numMaxCarros < contadorCarros){
            System.out.println("\nNão é possível engatar. | A capacidade máxima de carros foi atingida!");
			return;
        }
		if(pesoAtualCarros > pesoMaxCarros){
			System.out.println("\nNão é possível engatar. | A capacidade total foi atingida!");
			return;
		}
		pesoAuxCarros = v.getCapacidadeCarga();
        pesoMaxCarros = pesoMaxCarros + (int) (pesoMaxCarros - (0.1 * pesoAuxCarros));
		pesoAtualCarros = pesoAtualCarros + 100;

        carros.add(v);
        contadorCarros++;
		contadorVagoes++;
        System.out.printf("\nVagão %d|id:%d| engatado!\n",contadorVagoes,v.getId());
    }

	public void desengataV(Vagao v){
		carros.remove(v);
		contadorCarros--;
		contadorVagoes--;
		pesoAuxCarros = v.getCapacidadeCarga();
        pesoMaxCarros = pesoMaxCarros - (int) (pesoMaxCarros - (0.1 * pesoAuxCarros));
		pesoAtualCarros = pesoAtualCarros - 100;
		System.out.printf("\nVagão |%d| desengatado!\n",v.getId());
	}

	public void engatarL(Locomotiva l) {
        if (carros.isEmpty()) {
			numMaxCarros = l.getNumeroMaximoVagoes();
			pesoMaxCarros = l.getCapacidadeCarga();
            carros.add(l);
            contadorCarros++;
			contadorLocomotivas++;
			pesoAtualCarros = pesoAtualCarros + 50;
            System.out.printf("\nLocomotiva %d|%d| engatada! Capacidade Total: %s\n", contadorLocomotivas, l.getId(), pesoMaxCarros);
			return;
        }
                
        if (numMaxCarros > contadorCarros) {
			if(contadorVagoes > 0){
					System.out.println("\nNão é possível engatar. | Retire os vagões!");
					return;
            }
			else if(pesoAtualCarros < pesoMaxCarros){
				numAuxCarros = l.getNumeroMaximoVagoes();
        		numMaxCarros = numMaxCarros + numAuxCarros - 1;

				pesoAuxCarros = l.getCapacidadeCarga();
        		pesoMaxCarros = pesoMaxCarros + (int) (pesoMaxCarros - (0.1 * pesoAuxCarros));
				pesoAtualCarros = pesoAtualCarros + 50;

				carros.add(l);
                contadorCarros++;
				contadorLocomotivas++;
                System.out.printf("\nLocomotiva %d|%d| engatada! Capacidade Total: %s\n", contadorLocomotivas, l.getId(), pesoMaxCarros);
				return;
			}
			System.out.println("\nNão é possível engatar. | A capacidade total foi atingida!");
			return;
		} 
        System.out.println("\nNão é possível engatar. | A capacidade máxima de carros foi atingida!");
    }

	public void desengataL(Locomotiva l){
        if(contadorVagoes == 0){
            carros.remove(l);
            contadorCarros--;
			contadorLocomotivas--;
			pesoAuxCarros = l.getCapacidadeCarga();
        	pesoMaxCarros = pesoMaxCarros - (int) (pesoMaxCarros - (0.1 * pesoAuxCarros));
			pesoAtualCarros = pesoAtualCarros - 50;
            System.out.printf("\nLocomotiva |%d| desengatada!",l.getId());
        }
        else{
            System.out.println("\nNão é possivel desengatar. | Retire os vagões antes!");
        }
    }

	public int getIdentificador() {
		return identificador;
	}

	public int getQtdadeCarros() {
		return carros.size();
	}

	public CarroFerroviario getCarro(int id) {
		CarroFerroviario aux = null;
		for (CarroFerroviario cf : carros) {
			if (cf.getId() == id) {
				return cf;
			}
		}
		return aux;
	}

	public ArrayList<Locomotiva> getTodasLocomotivas() {
		ArrayList<Locomotiva> lstAux = new ArrayList<>();
		for (CarroFerroviario cf : carros) {
			if (cf instanceof Locomotiva) {
				lstAux.add((Locomotiva) cf);
			}
		}
		return lstAux;
	}

	public int getNumCarros(){
		return contadorCarros;
	}
	public int getNumLocomotivas(){
		return contadorLocomotivas;
	}
	public int getNumVagoes(){
		return contadorVagoes;
	}

	public ArrayList<Vagao> getTodosVagoes() {
		ArrayList<Vagao> lstAux = new ArrayList<>();
		for (CarroFerroviario cf : carros) {
			if (cf instanceof Vagao) {
				lstAux.add((Vagao) cf);
			}
		}
		return lstAux;
	}

	@Override
    public String toString(){
        return "Trem: "+identificador+" |Locomotivas: "+this.contadorLocomotivas+", Vagões: "+this.contadorVagoes;
    }
}
