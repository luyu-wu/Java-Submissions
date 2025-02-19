import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Insert the quadratic values (in order a,b,c)");
        
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        
        System.out.println("Insert Earth Orbital Characteristics (Semimajor, Semiminor)");
        
        double sMa = scan.nextDouble();
        double sMi = scan.nextDouble();

        Orbit myOrbit = new Orbit(sMa,sMi);
        Quadratic myObj = new Quadratic(a,b,c);
        
        double increment = 0.01;
        
        double moid = 9999999;
        double distance; 
        
        for (double x_quad = -sMa; x_quad < sMa; x_quad += increment) {
            
            myObj.setPoint(x_quad);
            
            for (double x_orb = - sMa; x_orb < sMa; x_orb += increment) {
                distance = myObj.Distance(x_orb, myOrbit.findY(x_orb));
                if (distance < moid) {
                    System.out.println(distance);

                    moid = distance;
                }
                
            }
            
        }
        System.out.println("Minimum distance is ");
        System.out.print(moid);
    }
}
