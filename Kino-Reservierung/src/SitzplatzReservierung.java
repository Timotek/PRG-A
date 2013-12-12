import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


public class SitzplatzReservierung extends JFrame {
	ReserveDemo reserveDemo = new ReserveDemo();
	ArrayList<Seat> seatList = new ArrayList<Seat>();
	int allSeatsReserved = 0;
	
	public SitzplatzReservierung() {
		setSize(300,300);
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new GridLayout(10,4));
		
		initSeats();
		reserveDemo.startThreading();
		
	}
	
	//Alle Sitzpl�tze einf�gen
	public void initSeats() {
		
		for (int i=0; i<40; i++){
			seatList.add(new Seat());
		}
	}
	public synchronized void reserve(int seatIndex){
		Seat seat = seatList.get(seatIndex);
		if (!seat.isReserved()){
			seat.reserveSeat();
			allSeatsReserved++;
			//System.out.println(allSeatsReserved);
		}
		if (allSeatsReserved == 40){
			Object error = null;
			JOptionPane.showMessageDialog((Component) error,
				    "Alle Sitzpl�tze wurden bereits reserviert",
				    "Achtung",
				    JOptionPane.WARNING_MESSAGE);
			System.exit(1);
		}
		
	}
//-------------------------------------------------------------------------	
	public class Seat {
		final JPanel seatPanel = new JPanel();
		boolean reserved = false;		
		
		
		public Seat() {
			seatPanel.setBackground(new Color(0,255,0));
			seatPanel.setBorder(new BevelBorder(BevelBorder.RAISED));	
			
			add(seatPanel);

		}
		
		public void reserveSeat(){
			reserved = true;
			seatPanel.setBackground(new Color(255,0,0));
		}
		public boolean isReserved(){
			return reserved;
		}
		
	}
//--------------------------------------------------------------------------------
	public class ReserveDemo {
		
		public class ReserveTask1 implements Runnable {
			Random random = new Random();
			boolean running = true;
			
			@Override
			public void run() {
				while (running) {
					try {
						int seatNumber = random.nextInt(40);
						int randomTime = (int) (Math.random()*1000);
						Thread.sleep(randomTime);
						reserve(seatNumber);
						//System.out.println("Task 1: Sitzplatz "+seatNumber+" wurde reserviert.");
					} catch (InterruptedException e) {
						System.out.println("run(): Schlaf unterbrochen");
					}	
				}
			}
		}
		public class ReserveTask2 implements Runnable {
			Random random = new Random();
			int randomTime = (int) (Math.random()*1000);
			boolean running = true;
			
			@Override
			public void run() {
				while (running) {
					try {
						int seatNumber = random.nextInt(40);
						int randomTime = (int) (Math.random()*1000);
						Thread.sleep(randomTime);
						reserve(seatNumber);
						//System.out.println("Task 2: Sitzplatz "+seatNumber+" wurde reserviert.");
					} catch (InterruptedException e) {
						System.out.println("run(): Schlaf unterbrochen");
					}	
				}
			}
		}
		public class ReserveTask3 implements Runnable {
			Random random = new Random();
			boolean running = true;
			
			@Override
			public void run() {
				while (running) {
					try {
						int seatNumber = random.nextInt(40);
						int randomTime = (int) (Math.random()*1000);
						Thread.sleep(randomTime);
						reserve(seatNumber);
						//System.out.println("Task 3: Sitzplatz "+seatNumber+" wurde reserviert.");
					} catch (InterruptedException e) {
						System.out.println("run(): Schlaf unterbrochen");
					}	
				}
			}
		}
		public class ReserveTask4 implements Runnable {
			Random random = new Random();
			boolean running = true;
			
			@Override
			public void run() {
				while (running) {
					try {
						int seatNumber = random.nextInt(40);
						int randomTime = (int) (Math.random()*1000);
						Thread.sleep(randomTime);
						reserve(seatNumber);
						//System.out.println("Task 4: Sitzplatz "+seatNumber+" wurde reserviert.");
					} catch (InterruptedException e) {
						System.out.println("run(): Schlaf unterbrochen");
					}	
				}
			}
		}
		public void startThreading() {
			ReserveTask1 reserveTask1 = new ReserveTask1();
			Thread thread1 = new Thread(reserveTask1);
			thread1.start();

			ReserveTask2 reserveTask2 = new ReserveTask2();
			Thread thread2 = new Thread(reserveTask2);
			thread2.start();
			
			ReserveTask3 reserveTask3 = new ReserveTask3();
			Thread thread3 = new Thread(reserveTask3);
			thread3.start();
			
			ReserveTask4 reserveTask4 = new ReserveTask4();
			Thread thread4 = new Thread(reserveTask4);
			thread4.start();
		}
	}
//------------------------------------------------------------------------------	
	
	public static void main (String[] args) {
		new SitzplatzReservierung();
		
	}
	
}

//neu