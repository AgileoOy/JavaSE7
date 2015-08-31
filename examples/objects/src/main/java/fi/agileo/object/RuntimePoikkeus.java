package fi.agileo.object;

public class RuntimePoikkeus
    {
      public static void main(String args[])  {
        String mj1 = "Sata";
        try {
          int j=0;
          int i = 6/j;
          int luku1 = Integer.parseInt(mj1);
        }
        // virhe laskutoimituksessa (esim. nollalla jako)
        catch (ArithmeticException e) {
          System.out.println("Laskuvirhe" + e);
        }
        // muunnos merkkijonosta luvuksi epäonnistui.
        catch (NumberFormatException e) {
          System.out.println("Muunnos merkkijono<->luku ei onnistunut!");          
        }
        // muut poikkeustilanteet.
        catch (Exception e) {
          System.out.println("Poikkeus " + e);
        }
      }
    }