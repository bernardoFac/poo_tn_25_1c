package calculadoraSimple;

public class Calculadora {
    public int sumar(int num1, int num2) {
        return num1 + num2;
    }

    public int restar(int num1, int num2) {
        return num1 - num2;
    }

    public int multiplicar(int num1, int num2) {
        return num1 * num2;
    }

    public int dividir(int num1, int num2) {
        if (num2 == 0) {
            System.out.println("No se puede dividir un numero por cero");
            return 0;
        }
        else {return num1 / num2;}
    }
}

