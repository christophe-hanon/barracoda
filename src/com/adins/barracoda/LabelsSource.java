package com.adins.barracoda;

import java.awt.print.*;
import java.awt.*;
import net.sourceforge.barbecue.*; 
import java.awt.Rectangle;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.font.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class LabelsSource  {
    private String snow;
   private GregorianCalendar now; 
   public static final int LABEL_EXIST = 0;
    public static final int NO_SUCH_LABEL  = 1;
    public static Font labelFont= new Font("Times New Roman", Font.PLAIN, 12);
    private SheetLayout sheetLayout;
    public LabelsSource (SheetLayout sl) {
        this.sheetLayout  = sl;
        now = new GregorianCalendar();

        DateFormat df = new SimpleDateFormat("yyMMdd");
        snow = df.format(now.getTime());
    }
    public int print( Rectangle ri , Graphics2D g, int labelIndex) throws PrinterException {
    NumberFormat nf = new DecimalFormat("0000");
    
        String index = snow+ nf.format(labelIndex);
        Rectangle r = g.getClipBounds();
        // full label rectangle
        g.drawRect(  r.x, r.y, r.width, r.height);
        
        // g.drawString("CODE",r.x+(int)(6*SheetLayout.ONEMM),(int)(r.y+7*SheetLayout.ONEMM) );
        // classification rectangle
        g.drawRect(r.x + (int) ( 5*SheetLayout.ONEMM),r.y + (int) (2*SheetLayout.ONEMM),(int) (10*SheetLayout.ONEMM),(int) (10*SheetLayout.ONEMM));
        // order rectangle
        g.drawRect(r.x + (int) ( 17*SheetLayout.ONEMM),r.y + (int) (2*SheetLayout.ONEMM),(int) (33*SheetLayout.ONEMM),(int) (10*SheetLayout.ONEMM));
        
        try {
            
        Barcode b = BarcodeFactory.createCode128(index) ;
       // b.setMaximumSize(new Dimension((int)(sheetLayout.size_x()-25),(int) (sheetLayout.size_y()-45) ));
        b.setBarWidth(1);
        //b.setResolution(36);
        b.setFont(labelFont);
        b.draw(g, r.x+(int)(7* SheetLayout.ONEMM),r.y+(int) (16*SheetLayout.ONEMM));
        g.drawRect(r.x+(int)(5* SheetLayout.ONEMM), r.y+(int)(14*SheetLayout.ONEMM),b.getWidth()+ (int)(2*SheetLayout.ONEMM) , b.getHeight()+labelFont.getSize() +(int)(2*SheetLayout.ONEMM));
        g.drawRect(r.x+(int)(51* SheetLayout.ONEMM), r.y+(int)(14*SheetLayout.ONEMM),(int)(10*SheetLayout.ONEMM) , (int) (10*SheetLayout.ONEMM));
        return LABEL_EXIST;
        }
        catch (Exception e) {};
            return NO_SUCH_LABEL ;
  
 }
    
   
    
   
     

}