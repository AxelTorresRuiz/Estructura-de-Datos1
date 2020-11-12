package Peces;

public class Pez {
    public String Tipo_Pez;
    public double Por_Nacimiento;


    public Pez(String tipo_Pez, double por_Nacimiento) {
        Tipo_Pez = tipo_Pez;
        Por_Nacimiento = por_Nacimiento;
    }

    public Pez() {

    }

    public String Por_nacimiento(double numero) {
        double CantPN = .90;
        numero = numero * CantPN;
        return numero + "";

    }


    public String Tipo_pez(String nombre) {
        return nombre;
    }
}