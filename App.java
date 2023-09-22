import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        Patio patio = new Patio();
        GaragemFerroviaria gf = new GaragemFerroviaria();
        Locomotiva l1 = new Locomotiva(121,null,1000,6);
        Locomotiva l2 = new Locomotiva(248,null,1000,6);
        gf.estaciona(l1);
        gf.estaciona(l2);

        Vagao v1 = new Vagao(145,null, 200);
        Vagao v2 = new Vagao(500,null, 200);
        Vagao v3 = new Vagao(367,null, 200);
        Vagao v4 = new Vagao(121,null, 200);
        gf.estaciona(v1);
        gf.estaciona(v2);
        gf.estaciona(v3);
        gf.estaciona(v4);

        int input = 1;

        System.out.println("Bem vindo! O que deseja fazer?");
        while(input != 5){

            System.out.println("(1)Criar trem (2)Editar trem");
            System.out.println("(3)Listar trens já criados (4)desfazer trem");
            System.out.println("(5)Sair");
            input = in.nextInt();
            if(input < 1 || input > 5){
                System.out.println("Numero inválido! Tente novamente");
                continue;
            }

            int id = 0; 
            String idl = null;
            int i = 0;

            switch(input){
                case 1:
                    System.out.println("Informe o id do trem");
                    id = in.nextInt();
                    System.out.println("Trem criado!");
                    Trem trem = new Trem(id); 
                    gf.retira(l1.getId());
                    l1.setTrem(trem);
                    trem.engatarL(l1);
                    patio.estaciona(trem);
                    break;
                case 2:
                    int id2 = 0;
                    Trem tremAux; 
                    System.out.println("Informe o id do trem:");
                    id2 = in.nextInt();
                    in.nextLine();
                    if(patio.pesquisarTrem(id2) != -1){
                        tremAux = patio.get(id2);
                        while(i != 7){
                            i =0;
                            System.out.println("O que deseja fazer?");
                            System.out.println("(1)Engatar locomotiva (2)Engatar vagão");
                            System.out.println("(3)Remover locomotiva (4)Remover vagão");
                            System.out.println("(5)Listar locomotivas (6)Listar vagões");
                            System.out.println("(7)Encerrar edição");
                            i = in.nextInt();
                            String id3 = " ";
                            String aux = " ";

                            switch(i){
                                case 1:
                                    System.out.println("Informe o id da locomotiva que deseja engatar:");
                                    id3 = in.next(); 
                                    if (id3.equals("l1" )&& idl != "l1"){
                                        gf.retira(l1.getId());
                                        l1.setTrem(tremAux);
                                        tremAux.engatarL(l1); break;
                                    }
                                    if (id3.equals("l2")&& idl != "l2"){
                                        gf.retira(l2.getId());
                                        l2.setTrem(tremAux);
                                        tremAux.engatarL(l2); break;
                                    }
                                    else {
                                        System.out.println("Locomotiva inválida!");
                                        break;
                                    }
                                    
                                case 2: 
                                    System.out.println("Informe o vagão que deseja engatar:");
                                    id3 = " ";
                                    id3 = in.next();
                                    if (id3.equals("v1")){
                                        gf.retira(v1.getId());
                                        v1.setTrem(tremAux);
                                        tremAux.engatarV(v1); break;
                                    }
                                    if (id3.equals("v2")){
                                        gf.retira(v2.getId());
                                        v2.setTrem(tremAux);
                                        tremAux.engatarV(v2); break;
                                    }
                                    if (id3.equals("v3")){
                                        gf.retira(v3.getId());
                                        v3.setTrem(tremAux);
                                        tremAux.engatarV(v3); break;
                                    }
                                    if (id3.equals("v4")){
                                        gf.retira(v4.getId());
                                        v4.setTrem(tremAux);
                                        tremAux.engatarV(v4); break;
                                    }
                                    else{
                                        System.out.println("Vagão inválido!");
                                        break;
                                    }
                                case 3:   
                                    System.out.println("Informe a locomotiva que deseja desengatar:");
                                    aux = in.next();
                                    if (aux.equals("l1")){
                                        gf.estaciona(l1);
                                        tremAux.desengataL(l1); break;
                                    }
                                    if (aux.equals("l2")){
                                        gf.estaciona(l2);
                                        tremAux.desengataL(l2); break;
                                    }
                                    else {
                                        System.out.println("Locomotiva inválida!");
                                        break;
                                    }
                                case 4:
                                    System.out.println("Informe o vagão que deseja desengatar:");
                                    aux = " ";
                                    aux = in.next();
                                    if (aux.equals("v1")){
                                        gf.estaciona(v1);
                                        tremAux.desengataV(v1); break;
                                    }
                                    if (aux.equals("v2")){
                                        gf.estaciona(v2);
                                        tremAux.desengataV(v2); break;
                                    }
                                    if (aux.equals("v3")){
                                        gf.estaciona(v3);
                                        tremAux.desengataV(v3); break;
                                    }
                                    if (aux.equals("v4")){
                                        gf.estaciona(v4);
                                        tremAux.desengataV(v4); break;
                                    }
                                    else{
                                        System.out.println("Vagão inválido!");
                                        break;
                                    }
                                case 5:   System.out.println(tremAux.getTodasLocomotivas()); break;
                                case 6:   System.out.println(tremAux.getTodosVagoes()); break;
                                default:  System.out.println("Fim da edição!"); 
                            }
                        }
                    }
                    else{
                        System.out.println("Trem não encontrado!");
                    }
                    break;
                case 3:    
                    System.out.println(patio.listaTrens());
                    break;
                case 4:
                    int b = 0;
                    System.out.println("Informe o id do trem a ser desfeito:");
                    b = in.nextInt();    
                    patio.retira(b); 
                    System.out.printf("trem %d desfeito!\n",b);
                    break; 
                default:   System.out.println("Fim da edição!");
            }
        }
        in.close();
    }
}
