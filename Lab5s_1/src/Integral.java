/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author Shwartskopff
 */
public class Integral {
     private static final double accur = 100;
     
     public static double meth(Function function, double a, double b, double accur) {
        while(a < b) {
            double l = (b - a)/100;
            double sumS = 0;
            
            for(int i=0; i<accur; i++) {
            a += l;
            double S = l*function.f(a - l/2);
            sumS += S;
        } return sumS;
        }
         return 0;
} 
     private static class Func implements Function {
        @Override
        public double f(double x) {
           return x*x+x;
        }
    }
    
     private static class Exp{
         double e(double x) {
             return Math.exp(-x);
         }
     }
    
     private static class Sin{
         double s(double x) {
             return Math.sin(x)*x;
         }
     }

     public static void main(String[] args) {
       Function f1 = new Function() {
        public double f(double x) {
                return Math.log(x);
            }
        };
        System.out.println("");
        System.out.println("Реализация интерфеса с помощью вложенного класса: ");
        System.out.println(meth(f1, 2, 5, accur));
        System.out.println("____________________________________________________________");
        
        Function f2 = new Func();
        System.out.println("");
        System.out.println("Реализация интерфеса с помощью анонимного класса: ");
        System.out.println(meth(f2, 3, 4, accur));
        System.out.println("____________________________________________________________");
        
        Sin s = new Sin();
        Function f3 = s::s; 
        System.out.println("");
        System.out.println("Реализация интерфеса с помощью ссылки на метод экземпляра: ");
        System.out.println(meth(f3, 0, 1, accur));
        System.out.println("____________________________________________________________");
        
        Exp e = new Exp();
        Function f4 = e::e; 
        System.out.println("");
        System.out.println("Реализация интерфеса с помощью ссылки на метод экземпляра: ");
        System.out.println(meth(f4, 0.01, 2, accur));
        System.out.println("___________________________________________________________");
       
        
        Function f5 = x -> x*x;
        System.out.println("");
        System.out.println("Реализация интерфейса с помощью лямбда-выражения: ");
        System.out.println(meth(f5, 1, 3, accur));
        System.out.println("___________________________________________________________");
     }
}
