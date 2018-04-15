/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Canvas;
import java.awt.Graphics;
import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author hs140
 *
 */
public class RuppeBean extends Canvas implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String sampleProperty;
    
    private PropertyChangeSupport propertySupport;
    private String others;
    private double ruppee;
    public void setOthers(String others)
    {
        this.others=others;
    }
    
    public String getOthers()
    {
        return others;
    }
    
    public void setRuppee(double ruppee)
    {
        this.ruppee=ruppee;
        repaint();
    }
    public double getRuppee()
    {
        return ruppee;
    }
    
    @Override
    public void paint(Graphics g)
    {super.paint(g);
        if(others.equals("america"))
           g.drawString(String.valueOf(ruppee/65), 20, 20);
        else if(others.equals("canada"))
           g.drawString(String.valueOf(ruppee/48),20,20);
        else g.drawString("currncy not found", 20, 20);
    }
    
    public RuppeBean() 
    {
        setSize(200,25);
        others="america";
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getSampleProperty() {
        return sampleProperty;
    }
    
    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
