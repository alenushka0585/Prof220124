package org.example.lesson23;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class StoppableThread extends Thread{
    private boolean hasToStop =  false;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Stoppable index is: " + i);
            if(hasToStop){
                System.out.println("I has to stop!");
                return; //таким образом завершается поток
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StoppableThread thread = new StoppableThread();
        thread.start();
        Thread.sleep(250);
        thread.setHasToStop(true);
    }
}
