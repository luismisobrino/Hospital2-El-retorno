/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte1;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Revij
 */
public class Auxiliar1 extends Thread {
    private int atendidos = 0;
    long tiempo;
    private LinkedBlockingQueue<Paciente> pacientes;
    private Recepcion recepcion;
    Paciente persona;
    Random rand = new Random();
    
    Auxiliar1(Recepcion recepcion, LinkedBlockingQueue<Paciente> pacientes){
        this.recepcion = recepcion;
        this.pacientes = pacientes;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                
                persona = pacientes.poll();
                tiempo = ((rand.nextInt(2) + 1)/2) * 1000;
                sleep(tiempo);
                if(persona.getCitado()){
                    persona.setPuesto(recepcion.salaLibre());
                    persona.start();
                }
                else{
                    //NO ESTÁ CITADO
                    int id = persona.getID();
                    System.out.println("El paciente no está citado para hoy: " + id);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Auxiliar1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    
}
