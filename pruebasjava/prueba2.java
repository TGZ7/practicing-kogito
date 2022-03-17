class Bird {
    public void printName() {
    System.out.println("Smallest bird is: Hummingbird");
  }
}

class Campain {

  private String nombre;
  private int fecha;
  
  public Campain() {

  }

  public Campain(String nombre, int fecha) {
      super();
      this.nombre = nombre;
      this.fecha = fecha;
  }

  public String getNombre() {
      return nombre;
  }

  public int getFecha() {
      return fecha;
  }
}

public class prueba2 {
  public static void main(String[] args) {
  
    Bird obj = new Bird();
  
    obj.printName();

    Campain obj2 = new Campain("Bravo",2022);
    System.out.println(obj2.getNombre());

   }
   
}
