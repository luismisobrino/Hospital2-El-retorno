/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte1;
//Hola wenas
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Revij
 */
public class Sanitario extends Thread{
    Random rand = new Random();
    private int tiempoPreparacion;
    private CyclicBarrier descanso = new CyclicBarrier(2);
    private Recepcion recepcion;
    private PuestoVacunacion miPuesto;
    
    Sanitario(Recepcion recepcion){
        tiempoPreparacion = rand.nextInt(3) + 1;
        tiempoPreparacion *= 1000;
        this.recepcion = recepcion;
        
    }
    
    public void trabajo() throws InterruptedException, BrokenBarrierException{
        descanso.await();
    }
    
    @Override
    public void run(){
        try {
            sleep(tiempoPreparacion);
            /*
            Tiene que encontrar sala de recepcion y ponerse a vacunar
            
            
            
            Despues tiene que descansar
            
            
            Si tiene una emergencia la socorre primero
            
            
            Si no, vuelve a curar
            
            
            */
            
            miPuesto = recepcion.medicoEntraEnSala();
            miPuesto.vacunar();
        } catch (InterruptedException ex) {
            Logger.getLogger(Sanitario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
