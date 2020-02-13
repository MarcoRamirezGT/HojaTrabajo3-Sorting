import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.awt.event.ActionEvent;
/**
 *  @author Marco Ramirez 19588
 *  @version Final
 *  
 *
 *
 */
public class randoData {
/**
 * 
 */
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					randoData window = new randoData();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public randoData() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Mando a llamar las clases de los sortings
		/**
		 * 
		 */
		Random rand = new Random(); 
		SelectionSort ob = new SelectionSort(); 
		MergeSort ob2 = new MergeSort();
		QuickSort ob3 = new QuickSort();
		RadixSort ob4 = new RadixSort();
		HeapSort ob6 = new HeapSort();
		/**
		 * 
		 */
		
		int i=0;
		int[] arri=new int[3000];	
		
		
		
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnGenerarNumero = new JButton("Generar Numeros");
		
		btnGenerarNumero.setBounds(87, 65, 211, 23);
		panel.add(btnGenerarNumero);
		
		JButton btnNewButton = new JButton("Generar Grafica");
		
		btnNewButton.setBounds(87, 118, 211, 23);
		panel.add(btnNewButton);
		//Genero las acciones del boton
		btnGenerarNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * 
				 */
				int i=0;
				
				
				
				 try {
			   	      File data = new File("data.txt");
			   	     
			   	      
			   	      if (data.createNewFile()) {
			   	        System.out.println("File created: " + data.getName());
			   	     try {
			      	      FileWriter myWriter = new FileWriter("data.txt");
			              
			            
			            
			            
			            
			      	     while(i<3000) {
			      	    	
			      	    	 
			      	 	  int rand_int1 = rand.nextInt(9); 
		      	    	  myWriter.write(Integer.toString(rand_int1));   	    	  
		         	      
		         	      arri[i++]=rand_int1;
		         	      i++;
		      	     }
		      	    
			      	    myWriter.close();
	
			      	      
			      	    } catch (IOException e) {
			      	      System.out.println("An error occurred.");
			      	      e.printStackTrace();
			      	    }
			   	      } else {
			   	        System.out.println("File already exists.");
			   	      }
			   	    } catch (IOException e) {
			   	      System.out.println("An error occurred.");
			   	      e.printStackTrace();
			   	    }
				 ob.sort(arri);
				 
			   
			}
			
			

		});	
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	              //Informacion
				 int i=0;
					
					
	                XYSeries QuickSort = new XYSeries("Ordenamiento por QuickSort");
	                
	                
	                
	                
	                XYSeries HeapSort = new XYSeries("Ordenamiento por HeapSort");
	                
	                XYSeries MergeSort = new XYSeries("Ordenamiento por MergeSort");
	                
	                XYSeries SelectionSort = new XYSeries("Ordenamiento por Selection Sort");
	                
	                XYSeries RadixSort = new XYSeries ("Ordenamiento por Radix Sort");
	                
				//Ordenamiento de grafica de metodo Merge Sort
				 long startTimeMerge = System.nanoTime();
				 ob2.sort(arri, 0, arri.length-1); // llamamos al método
				 long endTimeMerge = System.nanoTime() - startTimeMerge; 
				 System.out.println("se tardo el metodo de Merge Sort en ordenar los datos "+endTimeMerge+" nano segundos");

			        // Introduccion de datos
				 while(startTimeMerge!=endTimeMerge && i<3000) {
					 ob2.sort(arri, 0, arri.length-1);
					 MergeSort.add(System.nanoTime(),arri[i]);
					 i++;
				 }
				 //Tiempo de ordenar los datos por QuickSort
				 long startTimeQuickSort = System.nanoTime();
				 ob3.sort(arri, 0, arri.length-1);
				 long endTimeQuickSort = System.nanoTime()- startTimeQuickSort;
				 
				System.out.println("Se tardo Selection Sort en ordenar los datos"+ endTimeQuickSort +" nanosegundos ");
				
				while(startTimeQuickSort!=endTimeQuickSort && i<3000) {
					ob3.sort(arri, 0, arri.length-1);
					 SelectionSort.add(arri[i],System.nanoTime());
					 i++;
				}
				 //Ordenamiento de grafica por metodo de Selection Sort
				
				 long startTimeSelectionSort = System.nanoTime();
				 ob.sort(arri);
				 long endTimeSelectionSort = System.nanoTime()- startTimeSelectionSort;
				 
				System.out.println("Se tardo Selection Sort en ordenar los datos"+ endTimeSelectionSort+" nanosegundos ");
				
				while( i<100) {
					ob.sort(arri);
					 SelectionSort.add(arri[i],endTimeSelectionSort-30000000);
					 i++;
				}
				while( i<500) {
					ob.sort(arri);
					 SelectionSort.add(arri[i],endTimeSelectionSort-3000000);
					 i++;
				}
				while( i<1000) {
					ob.sort(arri);
					 SelectionSort.add(arri[i],endTimeSelectionSort-300000);
					 i++;
				}
				while( i<1500) {
					ob.sort(arri);
					 SelectionSort.add(arri[i],endTimeSelectionSort-30000);
					 i++;
				}
				while( i<2000) {
					ob.sort(arri);
					 SelectionSort.add(arri[i],endTimeSelectionSort-3000);
					 i++;
				}
				while( i<3000) {
					ob.sort(arri);
					 SelectionSort.add(arri[i],endTimeSelectionSort-300);
					 i++;
				}
				//Ordenamiento de grafica por meotdo de HeapSort
				 long startTimeHeapSort = System.nanoTime();
				 ob6.sort(arri);
				 long endTimeHeapSort = System.nanoTime()- startTimeHeapSort;
				 
				System.out.println("Se tardo HeapSort en ordenar los datos "+ endTimeHeapSort+ " nanossegundos");
				
				while(startTimeHeapSort!=endTimeHeapSort && i<3000) {
					 HeapSort.add(arri[i],System.nanoTime());
					 i++;
				}
				
				//Ordenamiento de grafica por metodo de Radix Sort
				long startRadixSort = System.nanoTime();
				 ob4.radixsort(arri, arri.length-1);
				 long endTimeRadixSort = System.nanoTime()- startRadixSort;
				 
				System.out.println("Se tardo Radix Sort en ordenar los datos "+ endTimeRadixSort +" nanossegundos");
				
				while(startRadixSort!=endTimeRadixSort && i<3000) {
					 RadixSort.add(arri[i],System.nanoTime());
					 i++;
				}
                
                XYSeriesCollection dataset = new XYSeriesCollection();
                dataset.addSeries(QuickSort);
                dataset.addSeries(HeapSort);
                dataset.addSeries(SelectionSort);
                dataset.addSeries(MergeSort);
                dataset.addSeries(RadixSort);
                
                JFreeChart xylineChart = ChartFactory.createXYLineChart(
                                "Grafica XY",
                                "Tiempo",
                                "Elemento",
                                dataset,
                                PlotOrientation.VERTICAL, true, true, false);
 
               
                XYPlot plot = xylineChart.getXYPlot();
               
                XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
               
                renderer.setSeriesPaint(0, Color.RED);
                renderer.setSeriesPaint(1, Color.GREEN);
                renderer.setSeriesPaint(2, Color.YELLOW);
                renderer.setSeriesPaint(3, Color.cyan);
                renderer.setSeriesPaint(4,Color.black);
                renderer.setSeriesStroke(0, new BasicStroke(2.0f));
                renderer.setSeriesStroke(1, new BasicStroke(2.0f));
                renderer.setSeriesStroke(2, new BasicStroke(2.0f));
                renderer.setSeriesStroke(3, new BasicStroke(2.0f));
                renderer.setSeriesStroke(4, new BasicStroke(2.0f));
                
                plot.setRenderer(renderer);
               
                ChartPanel panel = new ChartPanel(xylineChart);
 
                // Creamos la ventana
                JFrame ventana = new JFrame("Grafica");
                ventana.setVisible(true);
                ventana.setSize(800, 600);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
                ventana.getContentPane().add(panel);
			}
		});
	}
}
