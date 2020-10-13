/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import static java.awt.Frame.NORMAL;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author student
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TableView<String[]> Table;
    private Label Label2;
    @FXML
    private Button Button2;
    @FXML
    private ImageView Image;
    @FXML
    private AnchorPane doZadan;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        Utils.buildTable(Table, 8, 6, 24, 90, true, new String[] {"1","2","3","4","5","6"}); // Вариант с шапкой
        doRandom(null);
        
        //table.getItems().add(new String[6]); // Так можно добавить строку
        //table.getItems().remove(table.getItems().size()-1); // Так можно удалить строку
        //table.refresh(); // Обновить таблицу на экране
    }

    @FXML
    private void doRandom(ActionEvent event) {
        // Заполнение таблицы случайными числами
        for (int row = 0; row < Table.getItems().size(); row++) {
            for (int col = 0; col < Table.getColumns().size(); col++) {
                int rand = (int) Math.round(-1 + Math.random() * 10);
                Table.getItems().get(row)[col] = String.valueOf(rand);
            }
        }
        Table.refresh();
    }

    @FXML
    private void doSum(ActionEvent event) {
        // Расчет суммы чисел таблицы
        double sum = 0;
        for (int row = 0; row < Table.getItems().size(); row++) {
            for (int col = 0; col < Table.getColumns().size(); col++) {
                sum = sum + Double.parseDouble(Table.getItems().get(row)[col]);
            }
        }
        
        
        label.setText("Ответ=" + String.valueOf(sum));
        Table.refresh();
    }

    @FXML
     private void doZadan(ActionEvent event) {
    int max, maxI, maxJ;
    max = Integer.parseInt(Table.getItems().get(0)[0]);
    maxI = 0;
    maxJ = 0;
    for (int row = 0; row < Table.getItems().size(); row++) {
        for (int col = 0; col < Table.getColumns().size(); col++) {
            if (Integer.parseInt(Table.getItems().get(row)[col]) > max) {
                max=Integer.parseInt(Table.getItems().get(row)[col]);
                maxI=row;
                maxJ=col;
            }
        }
        }
        boolean has = false;
        for (int row = maxI; row < Table.getItems().size(); row++) {
        for (int col = maxJ; col < Table.getColumns().size(); col++) {
            if (Integer.parseInt(Table.getItems().get(row)[col]) == 1) 
                has = true;
        }
        }
        if(has)
        {
           for (int row = maxI; row < Table.getItems().size(); row++) {
            for (int col = maxJ; col < Table.getColumns().size(); col++) {
                if (Integer.parseInt(Table.getItems().get(row)[col]) > 0) 
                {
                    Table.getItems().get(row)[col] = String.valueOf(Integer.parseInt(Table.getItems().get(row)[col])*2);
                    Table.refresh();
                }
            }
            Table.refresh();
            }
        }
        
        
  
     label.setText("Максимальный элемент = " + max + "["+ (maxI + 1)+","+(maxJ + 1) + "]" );   
    }}

         
    
     


         
    
    
    
