package calculadoraAvanzada;


import calculadoraSimple.Calculadora;

public class Compleja extends Calculadora {
    public int potencia(int base,int exponente){
        return (int) Math.pow(base,exponente);
    }
    public int raiz(int num){
        return (int) Math.sqrt(num);
    }
    public int modulo(int dividendo, int divisor){
        return dividendo % divisor;
    }
}

