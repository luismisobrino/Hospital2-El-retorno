/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Revij
 */
public class Paciente extends Thread{
    private boolean citado = true;
    Random rand = new Random();
    private int probabilidad, id;
    private PuestoVacunacion puesto;
    
    Paciente(int id){
        this.id = id;
        probabilidad = rand.nextInt(100);
        if(probabilidad == 99){
            citado = false;
        }
    }
    
    @Override
    public void run(){
        try {
            puesto.vacunarse();
        } catch (InterruptedException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean getCitado(){
        return citado;
    }
    
    public void setPuesto(PuestoVacunacion puesto){
        this.puesto = puesto;
    }
    
    public int getID(){
        return id;
    }
}
