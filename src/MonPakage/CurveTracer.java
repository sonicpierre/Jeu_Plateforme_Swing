package MonPakage;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class CurveTracer extends JFrame {

    private static final long serialVersionUID = -3914578220391097071L;


    private CurveCanvas curveCanvas = new CurveCanvas();
    
    public CurveTracer() {
        super( "Curve tracer" );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        
        JPanel contentPane = (JPanel) this.getContentPane();
        
        
        contentPane.add( curveCanvas, BorderLayout.CENTER );
        
        
        this.setSize( 400, 470 );
        this.setLocationRelativeTo( null );
    }
    


    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel( new NimbusLookAndFeel() );
        CurveTracer window = new CurveTracer();
        window.setVisible( true );
    }

}