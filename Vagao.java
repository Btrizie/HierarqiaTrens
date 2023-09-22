public class Vagao extends CarroFerroviario{
    public int capacidadeCarga;
    
    public Vagao(int id,Trem trem, int capacidadeCarga){
        super(id,trem);
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getCapacidadeCarga(){
        return this.capacidadeCarga;
    }

    @Override
    public String toString(){
        return "Vagão: "+super.toString();
    }
    
}
