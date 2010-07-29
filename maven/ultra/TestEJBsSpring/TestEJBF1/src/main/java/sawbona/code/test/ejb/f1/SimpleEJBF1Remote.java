/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sawbona.code.test.ejb.f1;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import sawbona.code.test.ejb.f2.SimpleEJBF2Interface;

/**
 *
 * @author jacob
 */
@Remote(SimpleEJBF1Interface.class)
@Stateless(name = "BusinessBDBean", mappedName = "ejb/BusinessBDBean")
public class SimpleEJBF1Remote implements SimpleEJBF1Interface{

    @EJB(beanName="SimpleEJBF2RemoteBean")
    private SimpleEJBF2Interface simpleEJBF2Interface;

    @Override
    public String diHolaF1(String nombre) {
        if(simpleEJBF2Interface != null){
            Date inicial = new Date();
            for(int i = 0; i < 1000000; i ++){
                simpleEJBF2Interface.saluda(nombre);
            }
            Date dfinal = new Date();
            long name = dfinal.getTime() - inicial.getTime();
            name = name / 1000;
            return simpleEJBF2Interface.saluda(nombre) + " EJB INYECTADO DESDE... AHORA. Tiempo de respuesta: " + (name);
        }
        return "Hola desde [SimpleEJBF1Remote implements SimpleEJBF1Interface] " + nombre;
    }

}
