package com.adins.barracoda;

import java.awt.Graphics;
import java.awt.print.*;
import net.sourceforge.barbecue.*; 

public class SheetLayout  {
    private PageFormat pageformat;
    public void setPageFormat(PageFormat pageformat) {
    this.pageformat = pageformat;
    }
    private double portrait_margin_size_top = 9* ONEMM;
    private double portrait_margin_size_bottom =0;
    private double portrait_margin_size_left = 0;
    private double portrait_margin_size_right = 0;
    private double portrait_label_width= 70 * ONEMM;
    private double portrait_label_height= 35 * ONEMM;
    public static final double ONEINCH = 25.4; // milimeter
    public static final double ONEMM = 72 / 25.4 ;// Pixel                                    
    SheetLayout () {
        
    }
   
    public Double max_x() {
       return pageformat.getWidth();
       
    }
    public Double max_y() {
       return pageformat.getHeight();
    
    }
    public int number_of_labels_x() {
       //return (int) ((max_x() - portrait_margin_size_left -portrait_margin_size_right) / portrait_label_width);
       return 3;
    
    }
    public int number_of_labels_y() {
       return 8; // return (int) ((max_y() - portrait_margin_size_top -portrait_margin_size_bottom) / portrait_label_height);
   
    
    }
     int number_of_labels_per_page () {
        return number_of_labels_x() * number_of_labels_y() ;
     }
    public Double pos_x(int labelnumber) {
        int posx = labelnumber % number_of_labels_x();
        return portrait_margin_size_left+portrait_label_width* (posx);
    }
    public Double pos_y (int labelnumber) {
        int posy = labelnumber / number_of_labels_x();
        return portrait_margin_size_top +portrait_label_height * (posy);
    }
    public Double size_x() {
            return portrait_label_width;
    }
     public Double size_y() {
            return portrait_label_height;
    }
}
