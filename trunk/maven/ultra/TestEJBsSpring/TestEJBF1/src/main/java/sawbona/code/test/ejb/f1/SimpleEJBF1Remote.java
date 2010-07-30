/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sawbona.code.test.ejb.f1;

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

    @EJB(mappedName="ejb/SimpleEJBF2RemoteBean")
    private SimpleEJBF2Interface simpleEJBF2Interface;

    @Override
    public Object findNegocio(Class clase) {
        return simpleEJBF2Interface.find(clase);
    }

}
