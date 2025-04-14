import gestorEstudiantes.Estudiante;
import calculadoraSimple.Calculadora;

public class Main {
    public static void main(String[] args) {
                //Calculadora calculadora = new Calculadora();
                //int resultado = calculadora.sumar(10, 20);
                //System.out.println(resultado);
                //int resultado1 = calculadora.restar(5, 5);
                //System.out.println(resultado1);
                //int resultado2 = calculadora.multiplicar(10, 10);
                //System.out.println(resultado2);
                //int resultado3 = calculadora.dividir(10, 0);
                //System.out.println(resultado3);
                //CalculadoraCompleja calculadoraCompleja = new CalculadoraCompleja();
                //int resultado4 = compleja.potencia(10, 2);
                //System.out.println(resultado4);
                //int resultado5 = compleja.modulo(10, 2);
                //System.out.println(resultado5);
                //int resultado6 = compleja.raiz(49);
                //System.out.println(resultado6);

                Estudiante estudianteNroUno = new Estudiante();
                estudianteNroUno.nombre = "Bernardo Olmedo";
                estudianteNroUno.edad = 20;
                estudianteNroUno.mostrarEstudiante();
                estudianteNroUno.actualizarEstudiante();
                estudianteNroUno.mostrarEstudiante();

    }
}

