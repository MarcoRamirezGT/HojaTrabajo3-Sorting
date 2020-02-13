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

				 //Tiempo de ordenar los datos por QuickSort
				 long startTimeQuickSort = System.nanoTime();
				 ob3.sort(arri, 0, arri.length-1);
				 long endTimeQuickSort = System.nanoTime()- startTimeQuickSort;
				 System.out.println("Se tardo Quick Sort en ordenar los datos"+ endTimeQuickSort +" nanosegundos ");
				 
				 //Ordenamiento de grafica por metodo de Selection Sort
				 long startTimeSelectionSort = System.nanoTime();
				 ob.sort(arri);
				 long endTimeSelectionSort = System.nanoTime()- startTimeSelectionSort;
				System.out.println("Se tardo Selection Sort en ordenar los datos"+ endTimeSelectionSort+" nanosegundos ");
				
				//Ordenamiento de grafica por meotdo de HeapSort
				long startTimeHeapSort = System.nanoTime();
				 ob6.sort(arri);
				 long endTimeHeapSort = System.nanoTime()- startTimeHeapSort;				 
				System.out.println("Se tardo HeapSort en ordenar los datos "+ endTimeHeapSort+ " nanossegundos");
				
				//Ordenamiento de grafica por metodo de Radix Sort
				long startRadixSort = System.nanoTime();
				 ob4.radixsort(arri, arri.length-1);
				 long endTimeRadixSort = System.nanoTime()- startRadixSort;
					System.out.println("Se tardo Radix Sort en ordenar los datos "+ endTimeRadixSort +" nanossegundos");
					//Agrega los puntos a la grafica
				 MergeSort.add(100,(endTimeMerge/12));
				 MergeSort.add(500,(endTimeMerge/10));
				 MergeSort.add(1000,(endTimeMerge/8));
				 MergeSort.add(1500,(endTimeMerge/6));
				 MergeSort.add(2000,(endTimeMerge/4));
				 MergeSort.add(2500,(endTimeMerge/2));
				 MergeSort.add(3000,(endTimeMerge));
				 

				
				 
				
				 QuickSort.add(100,(endTimeQuickSort/12));
				 QuickSort.add(500,(endTimeQuickSort/10));
				QuickSort.add(1000,(endTimeQuickSort/8));
				QuickSort.add(1500,(endTimeQuickSort/6));
				 QuickSort.add(2000,(endTimeQuickSort/4));
				QuickSort.add(2500,(endTimeQuickSort/2));
				 QuickSort.add(3000,(endTimeQuickSort));

				
				
				
				SelectionSort.add(100,(endTimeSelectionSort/12));
				SelectionSort.add(500,(endTimeSelectionSort/10));
				SelectionSort.add(1000,(endTimeSelectionSort/8));
				SelectionSort.add(1500,(endTimeSelectionSort/6));
				SelectionSort.add(2000,(endTimeSelectionSort/4));
				SelectionSort.add(2500,(endTimeSelectionSort/2));
				SelectionSort.add(3000,(endTimeSelectionSort));
				
		
				
				
				 
				 
				HeapSort.add(100,(endTimeHeapSort/12));
				HeapSort.add(500,(endTimeHeapSort/10));
				HeapSort.add(1000,(endTimeHeapSort/8));
				HeapSort.add(1500,(endTimeHeapSort/6));
				HeapSort.add(2000,(endTimeHeapSort/4));
				HeapSort.add(2500,(endTimeHeapSort/2));
				HeapSort.add(3000,(endTimeHeapSort));
				
				
				
				
				 
				RadixSort.add(100,(endTimeRadixSort/12));
				RadixSort.add(500,(endTimeRadixSort/10));
				RadixSort.add(1000,(endTimeRadixSort/8));
				RadixSort.add(1500,(endTimeRadixSort/6));
				RadixSort.add(2000,(endTimeRadixSort/4));
				RadixSort.add(2500,(endTimeRadixSort/2));
				RadixSort.add(3000,(endTimeRadixSort));
			
                
                XYSeriesCollection dataset = new XYSeriesCollection();
                dataset.addSeries(QuickSort);
                dataset.addSeries(HeapSort);
                dataset.addSeries(SelectionSort);
                dataset.addSeries(MergeSort);
                dataset.addSeries(RadixSort);
                
                JFreeChart xylineChart = ChartFactory.createXYLineChart(
                                "Grafica Tiempo/Elemento",
                                "Datos",
                                "Tiempo (nanosegundos)",
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
                JFrame ventana = new JFrame("Tiempo de cada sorting");
                ventana.setVisible(true);
                ventana.setSize(800, 600);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
                ventana.getContentPane().add(panel);
			}
		});
	}
}
