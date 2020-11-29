import javax.swing.JOptionPane;

public class Objeto {
	private No Raiz;
	
	public Objeto() {
		Raiz=null;
	}
	public void insert() {
		int valor=Integer.parseInt(JOptionPane.showInputDialog("Informe o valor "));
		Raiz=insert(Raiz,valor);
	}
	private No insert(No arv,int valor) {
		if(arv==null) {
			No novo=new No();
			novo.setInfo(valor);
			return novo;
		}else {
			if(valor>arv.getInfo())
				arv.setEsq(insert(arv.getEsq(),valor));
			else 
				arv.setDir(insert(arv.getDir(),valor));
			return arv;
		}
		
	}
	public void imprime() {
		imprime(Raiz);
	}
	private void imprime(No arv) {
		if(arv!=null) {
			imprime(arv.getEsq());
			System.out.println(arv.getInfo());
			imprime(arv.getDir());
		}
	}
	public void Maior() {
		System.out.println("Maior Numeroe " + Maior(Raiz));
	}
	private int Maior(No arv) {
		int maior=0;
		while(arv!=null) {
			if(arv.getInfo()>maior) {
				maior=arv.getInfo();
			}
			arv=arv.getEsq();
		}
		return maior;
	}
	public void exclui() {
		int valor=Integer.parseInt(JOptionPane.showInputDialog("Informe o valor "));
		Raiz=exclui(Raiz,valor);
	}
	private No exclui(No arv,int valor) {
		if(arv==null) {
			return arv;
		}
		if(valor>arv.getInfo()) {
			arv.setEsq(exclui(arv.getEsq(),valor));
		}else if(valor>arv.getInfo()) {
			arv.setDir(exclui(arv.getDir(),valor));
		}else {
			if(arv.getEsq()==null && arv.getDir()==null) {
				return null;
			}else if(arv.getEsq()!=null && arv.getDir()!=null) {
				No maior=arv.getEsq();
				No aux=arv.getEsq();
				while(aux!=null) {
					maior=aux;
					aux=aux.getDir();
				}
				maior.setInfo(maior.getInfo());
				aux.setEsq(exclui(arv.getEsq(),maior.getInfo()));
			}else {
				No filho=(arv.getEsq()!=null)?arv.getEsq():arv.getDir();
				arv=filho;
			}
		}
		return arv;
	}
	public void Menor() {
		System.out.println("Menor Numero " + Menor(Raiz));
	}
	private int Menor(No arv) {
		int menor=arv.getInfo(); //NAO PRECISA DECLARAR MENOR COM  10000
		while(arv!=null) {
			if(arv.getInfo()<menor) {
				menor=arv.getInfo();
			}
			arv=arv.getDir();
		}
		return menor;
	}
	public void Count() {
		System.out.println("QTD " + Count(Raiz));
	}
	private int Count(No arv) {
		int i=0;
		if(arv!=null) {
			i+=Count(arv.getEsq());
			i+=Count(arv.getDir());
			i++;
		}
		return i;
	}
	public void Par(){
		System.out.println("QTD Par " + Par(Raiz));
	}
	private int Par(No arv) {
		int par=0;
		if(arv!=null) {//Ponto de parada
			par+=Par(arv.getEsq());
			par+=Par(arv.getDir());
			if(arv.getInfo()% 2 ==0) {
				par++;
				System.out.println("N° "+arv.getInfo() +" Par ");
			}
		}
		return par;
	}
	
	public void Impar(){
		System.out.println("QTD Impar " + Impar(Raiz));
	}
	private int Impar(No arv) {
		int impar=0;
		if(arv!=null) {//Ponto de parada
			impar+=Impar(arv.getEsq());
			impar+=Impar(arv.getDir());
			if(arv.getInfo() % 2 !=0) {
				impar++;
				System.out.println("N° "+arv.getInfo() + " Impar " );
			}
			 
		}
		return impar;
	}
	public void StatusArvore() {
		this.Impar();
		this.Par();
		this.Soma();
		this.Maior();
		this.Menor();
		
	}
	public void Soma() {
		System.out.println("Soma "+Soma(Raiz));
	}
	private double Soma(No arv) {
		double soma=0;
		if(arv!=null) {
			soma+=Soma(arv.getEsq());
			soma+=Soma(arv.getDir());
			soma+=arv.getInfo();
		}
		return soma;
	}
	public void copiaArvore() {
		this.insert();
	}
	private No copiaArvore(No arv,int valor) {
		if(arv!=null) {
			this.insert(arv, valor);
		}
		return arv;
	}
 
}








