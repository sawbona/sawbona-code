/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sawbona.code.test.ejb.f2;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author jacob
 */
@Local(SimpleEJBF2Interface.class)
@Stateless(name="SimpleEJBF2RemoteBean", mappedName="ejb/SimpleEJBF2RemoteBean")
public class SimpleEJBF2Local implements SimpleEJBF2Interface{

    @Override
    public String saluda(String nombre) {
        return "Hola.! [SimpleEJBF2Local implements SimpleEJBF2Interface] " + nombre;
    }

}
