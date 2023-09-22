import java.util.ArrayList;

public class Patio {
    private ArrayList<Trem> trens;
    
    public Patio(){
        trens = new ArrayList<>();
    }

    public void estaciona(Trem t){
        trens.add(t);
    }

    public int qtdade(){
        return trens.size();
    }

    public Trem get(int id){
        Trem aux = null;
        for(Trem cf:trens){
            if (cf.getIdentificador() == id){
                aux = cf;
                break;
            }
        }
        return aux;
    }

    public Trem retira(int id){
        Trem aux = null;
        for(Trem cf:trens){
            if (cf.getIdentificador() == id){
                aux = cf;
                break;
            }
        }
        if (aux != null){
            trens.remove(aux);
        }
        return aux;
    }

    public int pesquisarTrem(int id){
        int local = -1;
        for(int i = 0; i < trens.size(); i++){
            if(trens.get(i).getIdentificador() == id){
                local = i;
                return local;
            }
        }
        return local;
    }

    public ArrayList<Trem> listaTrens(){
        return trens;
    }
}
    

