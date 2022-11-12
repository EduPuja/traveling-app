package Implements;

import Funcions.ConnexioBDD;
import Interfaces.InterfaceEquipatge;
import Objectes.Equipatge;

import java.sql.Statement;

public class ImplementsEquipatge implements InterfaceEquipatge
{


    /**
     * Insertar equipatge base de dades ✅
     *
     */
    @Override
    public void afegirEquipatge(Equipatge equipatge) throws Exception
    {
        Statement statement = ConnexioBDD.conexioDB();

        String insertQuery = "INSERT INTO `equipatge`(`id_equip`, `num_factura`, `linia_factura`, `pes_kg`, `num_maletes`) VALUES ("+equipatge.getIdEquipatge()+","+equipatge.getNumFactura()+","+equipatge.getLiniaFactura()+","+equipatge.getPesKg()+","+equipatge.getNumMaletes();
        if(statement.executeUpdate(insertQuery) ==1)
        {
            System.out.println("Equipatge insertat");
        }
        else System.out.println("Equipatge NO insertat");
        statement.close();

    }

    @Override
    public void eliminarEquipatge(int idEquipatge)
    {

    }

    @Override
    public void modificarEquipatge(String dades)
    {

    }

    @Override
    public void llistarEquipatge()
    {

    }
}
